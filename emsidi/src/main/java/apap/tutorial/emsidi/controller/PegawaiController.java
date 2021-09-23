package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;

@Controller
public class PegawaiController {
    @Qualifier("pegawaiServiceImpl")
    @Autowired
    PegawaiService pegawaiService;

    @Qualifier("cabangServiceImpl")
    @Autowired
    CabangService cabangService;

    @GetMapping("/pegawai/add/{noCabang}")
    public String addPegawaiForm(@PathVariable Long noCabang, Model model){
        PegawaiModel pegawai = new PegawaiModel();
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        pegawai.setCabang(cabang);
        model.addAttribute("noCabang", noCabang);
        model.addAttribute("pegawai", pegawai);
        return "form-add-pegawai";
    }

    @PostMapping("/pegawai/add")
    public String addPegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai,
            Model model
    ){
        pegawaiService.addPegawai(pegawai);
        model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
        model.addAttribute("namaPegawai", pegawai.getNamaPegawai());
        return "add-pegawai";
    }

    @GetMapping("/pegawai/update/{noPegawai}")
    public String updatePegawaiForm(
            @PathVariable Long noPegawai,
            Model model
    ) {
        PegawaiModel pegawai = pegawaiService.findByNoPegawai(noPegawai);
        model.addAttribute("pegawai", pegawai);
        model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
        return "form-update-pegawai";
    }

    @PostMapping("/pegawai/update")
    public String updatePegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai,
            Model model
    ) {
        if (LocalTime.now().isAfter(pegawai.getCabang().getWaktuTutup())
                || LocalTime.now().isBefore(pegawai.getCabang().getWaktuBuka())) {

            pegawaiService.updatePegawai(pegawai);
            model.addAttribute("noPegawai", pegawai.getNoPegawai());
            return "update-pegawai";
        }
        else {
            return "error-cabang-buka";
        }
    }

    @GetMapping("/pegawai/delete/{noPegawai}")
    public String deletePegawai(
            @PathVariable Long noPegawai,
            Model model
    ) {
        PegawaiModel pegawai = pegawaiService.findByNoPegawai(noPegawai);
        if (LocalTime.now().isAfter(pegawai.getCabang().getWaktuTutup())
                || LocalTime.now().isBefore(pegawai.getCabang().getWaktuBuka())) {

            pegawaiService.deletePegawai(pegawai);
            model.addAttribute("pegawai", pegawai);
            return "delete-pegawai";
        }
        else {
            return "error-cabang-buka";
        }

    }

}