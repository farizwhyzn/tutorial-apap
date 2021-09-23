package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;

import java.util.Optional;

public interface PegawaiService {
    void addPegawai(PegawaiModel pegawai);
    PegawaiModel findByNoPegawai(Long noPegawai);
    void updatePegawai(PegawaiModel pegawai);
    void deletePegawai(PegawaiModel pegawai);
}
