import React from "react";
import listItems from "../../items.json";
import List from "../../components/List/index";
import "./index.css";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Fab } from "@material-ui/core";
import ViewStreamIcon from '@mui/icons-material/ViewStream';

export default class Home extends React.Component {    
    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.shopItems;
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        this.setState({ shopItems: tempShopItems });
    };

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
    };
    
    handleAddItemToCart = (item) => {
        const newItems = [...this.state.cartItems];
        const newItem = { ...item };
        const tempBalance = this.state.balance - newItem.price;
        if (tempBalance < 0) {
            alert('Balance not sufficient!')
        } else { 
            const targetInd = newItems.findIndex((it) => it.id === newItem.id);
            if (targetInd < 0) {
                newItem.inCart = true;                                 
                newItems.push(newItem);
                this.updateShopItem(newItem, true)
            }
            this.setState({ cartItems: newItems, balance: tempBalance });
        }
    };

    handleDeleteItemFromCart = (item) => {
        const newItems = [...this.state.cartItems];
        const newItem = { ...item };
        newItem.inCart = false;
        this.updateShopItem(newItem, false)
        const tempCartItems = newItems.filter((item) => item.id !== newItem.id)
        const tempBalance = this.state.balance + newItem.price;
        this.setState({ cartItems: tempCartItems, balance: tempBalance });

    };

    handleDeleteAllItem = () => {
        const newItems = [...this.state.cartItems];
        for(let i=0; i< newItems.length; i++){
            this.updateShopItem(newItems[i], false)
        }
        const emptyItems = [];
        this.setState({ cartItems: emptyItems, balance: 120 })
    }

    constructor(props) {
        super(props);
        this.state = {
            shopItems: listItems,
            cartItems: [],
            cartHidden: true,
            balance: 120,
        };
    }
    
    render() {
        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                    <Fab variant="extended" onClick={this.handleToggle}>
                        {this.state.cartHidden ?
                        <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                            <ShoppingCartIcon />
                        </Badge>
                        : <ViewStreamIcon/>}
                    </Fab>
                </div>
                <p className="text-center text-secondary text-sm font-italic">
                    (this is a <strong>class-based</strong> application)
                </p>
                <p className="text-center text-primary">Your Balance: <b> {this.state.balance}</b> k</p>
                <button onClick={this.handleDeleteAllItem}>Delete All</button>

                <div className="container pt-3">
                    <div className="row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <List
                                    title="My Cart"
                                    items={this.state.cartItems}
                                    onItemClick={this.handleDeleteItemFromCart}
                                ></List>
                            </div>
                        ) : <div className="col-sm">
                            <List
                            title="List Items"
                            items={this.state.shopItems}
                            onItemClick={this.handleAddItemToCart}
                            isShopList={true}
                            ></List>
                    </div>}
                    </div>
                </div>
            </div>
        );
    }
}