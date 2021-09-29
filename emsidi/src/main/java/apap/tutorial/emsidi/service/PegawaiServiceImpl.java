package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {

    @Autowired
    PegawaiDB pegawaiDB;

    @Override
    public void addPegawai(PegawaiModel pegawai) {
        pegawaiDB.save(pegawai);
    }
    
    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai) {
        Optional<PegawaiModel> pegawai = pegawaiDB.findByNoPegawai(noPegawai);
        if (pegawai.isPresent()) {
            return pegawai.get();
        }
        return null;
    }
    
    @Override
    public void updatePegawai(PegawaiModel pegawai) {
        pegawaiDB.save(pegawai);
    }
    
    @Override
    public void deletePegawai(PegawaiModel pegawai) {
        pegawaiDB.delete(pegawai);
    }
    
}
