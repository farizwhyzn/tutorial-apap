package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {

    @Autowired
    PegawaiDb pegawaiDb;

    @Override
    public void addPegawai(PegawaiModel pegawai) { pegawaiDb.save(pegawai); }

    public void updatePegawai(PegawaiModel pegawai) { pegawaiDb.save(pegawai); }

    public PegawaiModel findByNoPegawai(Long noPegawai) {
        PegawaiModel pegawai = pegawaiDb.getById(noPegawai);
        return pegawai;
    }

    public void deletePegawai(PegawaiModel pegawai) {
        pegawaiDb.delete(pegawai);
    }
}
