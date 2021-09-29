package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;

public interface PegawaiService {
 void addPegawai(PegawaiModel pegawai); 
 PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
 void updatePegawai(PegawaiModel pegawai);
 void deletePegawai(PegawaiModel pegawai);
}
