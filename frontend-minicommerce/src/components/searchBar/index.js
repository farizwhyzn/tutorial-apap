import React from "react";


const SearchBar = (props) => {
    const { action, submit, namaItem } = props;
    return (
        <form>
            <input placeholder="Search..." type="text" name="title" value={namaItem} onChange={action} />
            <input type="submit" value="Submit" onClick={submit} hidden />
        </form>
    );
};

export default SearchBar;