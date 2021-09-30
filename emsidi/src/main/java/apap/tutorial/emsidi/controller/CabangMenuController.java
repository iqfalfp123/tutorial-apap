// package apap.tutorial.emsidi.controller;

// import apap.tutorial.emsidi.model.CabangModel;
// import apap.tutorial.emsidi.model.PegawaiModel;
// import apap.tutorial.emsidi.model.MenuModel;
// import apap.tutorial.emsidi.service.CabangService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.ui.Model;
// import java.time.LocalTime;

// import java.util.List;

// @Controller
// public class MenuController {
//     @Qualifier("menuServiceImpl")
//     @Autowired
//     MenuService menuService;
//     CabangService cabangService;
//  @PostMapping("/cabang-menu/add")
//     public String addCabangMenuSubmit(
//         @ModelAttribute CabangModel cabang, MenuModel menu, Model model
//     ){
//         cabangService.addCabang(cabang);
//         model.addAttribute("noCabang", cabang.getNoCabang());
//         return "add-cabang";
//     }