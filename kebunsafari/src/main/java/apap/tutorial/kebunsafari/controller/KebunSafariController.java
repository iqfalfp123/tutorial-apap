package apap.tutorial.kebunsafari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import apap.tutorial.kebunsafari.service.KebunSafariService;
import java.util.Objects;

@Controller
public class KebunSafariController {
    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
        @RequestParam (value="id", required = true) String idKebunSafari,
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
    public String getKebunSafariById(
        @RequestParam(value="id", required = true) String idKebunSafari,
         Model model){
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        model.addAttribute("kebunSafari", kebunSafari);
        return "detail-kebun-safari";
    }
    @RequestMapping("/kebun-safari/view/{id}")
    public String getKebunSafaryByIdWithPath(
        @PathVariable(value = "id", required = true) String idKebunSafari, Model model){
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        model.addAttribute("kebunSafari", kebunSafari);
        return "detail-kebun-safari";
    }
    
    @RequestMapping("/kebun-safari/update/{id}")
    public String updatephoneKebunSafari(
        @PathVariable(value = "id", required = true) String idKebunSafari,
        @RequestParam(value = "noTelepon", required = true) String noTelepon,
        Model model) {
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        model.addAttribute("kebunSafari", idKebunSafari);
        if (kebunSafari != null) {
            kebunSafariService.setPhoneKebunSafari(idKebunSafari, noTelepon);
            model.addAttribute("text", "berhasil diupdate");
        } else {
            model.addAttribute("text", "tidak ditemukan, proses update dibatalkan");
        }
        return "update-phone-kebun-safari";
    }
    
    @RequestMapping("/kebun-safari/delete/{id}")
    public String deleteKebunSafari(@PathVariable(value = "id", required = true) String idKebunSafari, Model model) {
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        model.addAttribute("kebunSafari", idKebunSafari);
        if(Objects.isNull(kebunSafari)){
            model.addAttribute("text", "tidak ditemukan, proses delete dibatalkan");
        }
       else{
            model.addAttribute("text", "berhasil dihapus");
            // kebunSafariService.deleteKebunSafariByIdKebunSafari(idKebunSafari);
            kebunSafariService.getKebunSafariList().remove(kebunSafari);
        }
        // else{
        //     model.addAttribute("text", "tidak ditemukan, proses delete dibatalkan");
        // }
        return "delete-kebun-safari";
    }
    @RequestMapping("/kebun-safari/delete-by-name")
    public String deleteKebunSafaribynama(@RequestParam(value = "nama", required = true) String namaKebunSafari, Model model) {
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByNamaKebunSafari(namaKebunSafari);
        kebunSafariService.getKebunSafariList().remove(kebunSafari);
        model.addAttribute("kebunSafari", namaKebunSafari);
        return "deletebynama";
    }
}
