package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
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
    private int value;

    @GetMapping("/cabang/add")
    public String addCabangForm(Model model) {
        model.addAttribute("cabang", new CabangModel());
        return "form-add-cabang";
    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
        @ModelAttribute CabangModel cabang, Model model
    ){
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }
    @GetMapping("/cabang/viewall")
    public String listCabang(Model model) {
        List<CabangModel> listCabang = cabangService.getCabangList();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";

    }
    @GetMapping("/cabang/view")
    public String viewDeteailCabang(
        @RequestParam(value = "noCabang") Long noCabang, Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);
        return "view-cabang";
    }
    @GetMapping("/cabang/update/{noCabang}")
    public String updateCabangForm(
        @PathVariable Long noCabang, Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute("cabang", cabang);
        LocalTime time = LocalTime.now();
         if (time.isAfter(cabang.getWaktuBuka()) && time.isBefore(cabang.getWaktuTutup())) {
             model.addAttribute("text", "tidak dapat diupdate, karena cabang sedang buka");
            return "update-cabang";
            }
        else{
            return "form-update-cabang";
        }
    }
    @PostMapping("/cabang/update")
    public String updateCabangSubmit(
        @ModelAttribute CabangModel cabang, Model model
    ) {
        model.addAttribute("noCabang", cabang.getNoCabang());
        cabangService.updateCabang(cabang);
        model.addAttribute("text", "berhasil diupdate");
        // LocalTime time = LocalTime.now();
        // if (time.isAfter(cabang.getWaktuBuka()) && time.isBefore(cabang.getWaktuTutup())) {
        //     model.addAttribute("text", "tidak dapat diupdate, karena cabang sedang buka");

        // } else {
        //     cabangService.updateCabang(cabang);
        //     model.addAttribute("text", "berhasil diupdate");
        // }
        return "update-cabang";
    }
    
    @RequestMapping("/cabang/delete/{noCabang}")
    public String deletePegawai(@PathVariable(value = "noCabang", required = true) Long noCabang, Model model) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute("cabang", noCabang);
        LocalTime time = LocalTime.now();
        if(time.isAfter(cabang.getWaktuBuka()) && time.isBefore(cabang.getWaktuTutup())) {
            value = 1;
        }

        if(cabang.getListPegawai().size() == 0 && value == 0) {
            cabangService.deleteCabang(cabang);
            model.addAttribute("text", "berhasil dihapus");
        }else {
            model.addAttribute("text", "tidak dapat dihapus karena cabang memiliki pegawai atau cabang tersebut sedang buka");
            value = 0;        
        }

        return "delete-cabang";
    }
    
    @GetMapping("/cabang/viewall-cabang-order")
    public String listCabangOrder(Model model) {
        List<CabangModel> listCabang = cabangService.getCabangListOrder();
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang-order";

    }
}
