package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        // pegawai.se(cabang);
        pegawai.setCabang(cabang);
        model.addAttribute("noCabang", noCabang);
        model.addAttribute("pegawai", pegawai);
        return "form-add-pegawai";
    }

    @PostMapping("/pegawai/add")
    public String addPegawaiSubmit(
        @ModelAttribute PegawaiModel pegawai, Model model
    ){
        pegawaiService.addPegawai(pegawai);
        model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
        model.addAttribute("namaPegawai", pegawai.getNamaPegawai());
        return "add-pegawai";
    }
    
    @GetMapping("/pegawai/update/{noPegawai}")
    public String updateCabangForm(@PathVariable Long noPegawai, Model model) {
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        model.addAttribute("pegawai", pegawai);
        LocalTime time = LocalTime.now();
        if (time.isAfter(pegawai.getCabang().getWaktuBuka()) && time.isBefore(pegawai.getCabang().getWaktuTutup())) {
            model.addAttribute("text", "tidak dapat diupdate, karena cabang tempat pegawai tersebut bekerja sedang buka");
            return "update-pegawai";
        }
        else {
            return "form-update-pegawai";
        }
    }

    @PostMapping("/pegawai/update")
    public String updatePegawaiSubmit(@ModelAttribute PegawaiModel pegawai, Model model) {
        model.addAttribute("noPegawai", pegawai.getNoPegawai());
        pegawaiService.updatePegawai(pegawai);
        model.addAttribute("text", "berhasil diupdate");
        // LocalTime time = LocalTime.now();
        // if (time.isAfter(pegawai.getCabang().getWaktuBuka()) && time.isBefore(pegawai.getCabang().getWaktuTutup())) {
        //     model.addAttribute("text", "tidak dapat diupdate, karena cabang pegawai tersebut bekerja sedang buka");

        // }
        // else {
        //     pegawaiService.updatePegawai(pegawai);
        //     model.addAttribute("text", "berhasil diupdate");
        // }
        return "update-pegawai";
    }
    @RequestMapping("/pegawai/delete/{noPegawai}")
    public String deletePegawai(@PathVariable(value = "noPegawai", required = true) Long noPegawai, Model model) {
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        model.addAttribute("pegawai", noPegawai);
        LocalTime time = LocalTime.now();
        if (time.isAfter(pegawai.getCabang().getWaktuBuka()) && time.isBefore(pegawai.getCabang().getWaktuTutup())) {
            model.addAttribute("text", "tidak dapat dihapus, karena cabang pegawai tersebut bekerja sedang buka");

        } else {
            pegawaiService.deletePegawai(pegawai);
            model.addAttribute("text", "berhasil dihapus");
        }

        return "delete-pegawai";
    }
    @PostMapping("/pegawai/delete")
    public String deletePegawaiSubmit(
        @ModelAttribute CabangModel cabang,
        Model model)
    {
        model.addAttribute("noCabang", cabang.getNoCabang());
        LocalTime now = LocalTime.now();
        if(now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())) {
           for (PegawaiModel pegawai : cabang.getListPegawai()) {
            pegawaiService.deletePegawai(pegawai);

        }
        return "delete-pegawai";
    }
    return "error-cannot-delete";
}
}
