package apap.tutorial.kebunsafari.controller;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import apap.tutorial.kebunsafari.service.KebunSafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KebunSafariController {
    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
            @RequestParam(value="id", required = true) String idKebunSafari,
            @RequestParam (value="nama", required = true) String namaKebunSafari,
            @RequestParam (value="alamat", required = true) String alamat,
            @RequestParam (value="noTelepon", required = true) String noTelepon,
            Model model
    ){
        KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        kebunSafariService.addKebunSafari(kebunSafari);

        model.addAttribute("kebunSafari", kebunSafari);

        return "add-kebun-safari";
    }

    @RequestMapping("/")
    public String listKebunSafari(Model model){
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();
        model.addAttribute("listKebunSafari", listKebunSafari);
        return "get-all-kebun-safari";
    }

    @RequestMapping("/kebun-safari")
    public String getKebunSafariById(@RequestParam(value="id", required = true) String idKebunSafari, Model model){
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        model.addAttribute("kebunSafari", kebunSafari);
        return "detail-kebun-safari";
    }

    @RequestMapping("/kebun-safari/view/{id}")
    public String view(@PathVariable String id, Model model) {
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(id);
        model.addAttribute("kebunSafari", kebunSafari);
        System.out.println(kebunSafari);
        return "detail-kebun-safari";
    }

    @RequestMapping("/kebun-safari/update/{id}")
    public String updateKebunSafariById(@RequestParam(value="noTelepon", required = true) String noTelepon, @PathVariable String id, Model model){
        kebunSafariService.updateKebunSafariByIdKebunSafari(id, noTelepon);
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(id);
        model.addAttribute("kebunSafari", kebunSafari);
        return "detail-kebun-safari";
    }

    @RequestMapping("/kebun-safari/delete/{id}")
    public String deleteKebunSafariById(@PathVariable String id, Model model){
        KebunSafariModel delete = kebunSafariService.deleteKebunSafariByIdKebunSafari(id);
        if (delete != null) {
            List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();
            model.addAttribute("listKebunSafari", listKebunSafari);
            return "get-all-kebun-safari";
        }
        else {
            return "gagal";
        }
    }
}