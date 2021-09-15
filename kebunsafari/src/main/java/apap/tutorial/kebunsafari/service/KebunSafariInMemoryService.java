package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class KebunSafariInMemoryService implements KebunSafariService{
    private List<KebunSafariModel> listKebunSafari;

    // Constructor
    public KebunSafariInMemoryService(){
        listKebunSafari = new ArrayList<>();
    }
    
    @Override
    public void addKebunSafari(KebunSafariModel kebunSafari) {
        listKebunSafari.add(kebunSafari);
    }

    @Override
    public List<KebunSafariModel> getKebunSafariList() {
        return listKebunSafari;
    }

    @Override
    public KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari) {
        List<KebunSafariModel> listkebunsafari = getKebunSafariList();
        for(KebunSafariModel x: listkebunsafari){
            if(x.getIdKebunSafari().equals(idKebunSafari)){
                return x;
            }
        }
        return null;
    }
    @Override
    public KebunSafariModel setPhoneKebunSafari(String idKebunSafari, String noTelepon) {
        List<KebunSafariModel> listkebunsafari = getKebunSafariList();
        for(KebunSafariModel x: listkebunsafari){
            if(x.getIdKebunSafari().equals(idKebunSafari)){
                x.setNoTelepon(noTelepon);
            }
    }
        return null;
}
}