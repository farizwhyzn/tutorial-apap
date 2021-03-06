package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.CabangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalTime;
import java.util.List;

@Controller
public class CabangController {

    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @GetMapping("/cabang/add")
    public String addCabangForm(Model model) {
        model.addAttribute("cabang", new CabangModel());
        return "form-add-cabang";
    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @GetMapping("/cabang/viewall")
    public String listCabang(Model model){
        List<CabangModel> listCabang = cabangService.getCabangList();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

    @GetMapping("/cabang/view")
    public String viewDetailCabang(
            @RequestParam(value = "noCabang") Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);
        model.addAttribute("listMenu", cabang.getListMenu());

        return "view-cabang";
    }

    @GetMapping("/cabang/update/{noCabang}")
    public String updateCabangForm(
            @PathVariable Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute("cabang", cabang);
        return "form-update-cabang";
    }

    @PostMapping("/cabang/update")
    public String updateCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        cabangService.updateCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "update-cabang";
    }

    @GetMapping("/cabang/viewallasc")
    public String findByOrderByNamaCabangAscList(Model model){
        List<CabangModel> listCabang = cabangService.findByOrderByNamaCabangAscList();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

    @GetMapping("/cabang/delete/{noCabang}")
    public String deleteCabang(
            @PathVariable Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        if ((LocalTime.now().isAfter(cabang.getWaktuTutup())
                || LocalTime.now().isBefore(cabang.getWaktuBuka())) && cabang.getListPegawai().isEmpty())
        {
            cabangService.deleteCabang(cabang);
            model.addAttribute("cabang", cabang);
            return "delete-cabang";
        }

        else if (!cabang.getListPegawai().isEmpty()){
            return "error-cabang-pegawai-exist";
        }

        else {
            return "error-cabang-buka";
        }
    }

}
