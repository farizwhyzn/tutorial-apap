package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KebunSafariInMemoryService implements KebunSafariService {
    private List<KebunSafariModel> listKebunSafari;

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
        for (int i = 0; i < listKebunSafari.size(); i++) {
            System.out.println(listKebunSafari.get(i).getIdKebunSafari());
            if (listKebunSafari.get(i).getIdKebunSafari().equals(idKebunSafari)) {
                return listKebunSafari.get(i);
            }
        }
        return null;
    }

    @Override
    public void updateKebunSafariByIdKebunSafari(String idKebunSafari, String noTelepon) {
        for (int i = 0; i < listKebunSafari.size(); i++) {
            System.out.println(listKebunSafari.get(i).getIdKebunSafari());
            if (listKebunSafari.get(i).getIdKebunSafari().equals(idKebunSafari)) {
                listKebunSafari.get(i).setNoTelepon(noTelepon);
            }
        }
    }

    @Override
    public KebunSafariModel deleteKebunSafariByIdKebunSafari(String idKebunSafari) {
        for (int i = 0; i < listKebunSafari.size(); i++) {
            System.out.println(listKebunSafari.get(i).getIdKebunSafari());
            KebunSafariModel data = listKebunSafari.get(i);
            if (listKebunSafari.get(i).getIdKebunSafari().equals(idKebunSafari)) {
                listKebunSafari.remove(i);
                return data;
            }
        }
        return null;
    }

}