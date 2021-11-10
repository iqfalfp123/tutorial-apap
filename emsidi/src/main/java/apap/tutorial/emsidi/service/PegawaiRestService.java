package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.rest.PegawaiDetail;
import apap.tutorial.emsidi.rest.ResponsePegawai;

import java.util.List;
import java.util.Map;

import reactor.core.publisher.Mono;

public interface PegawaiRestService {
    PegawaiModel createPegawai(PegawaiModel pegawai);

    List<PegawaiModel> retrieveListPegawai();

    PegawaiModel getPegawaiByNoPegawai(Long nopegawai);

    PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate);

    void deletePegawai(Long noPegawai);

    Mono<ResponsePegawai> getUmurPegawai(Long noPegawai);

    Map<String, Object> addUmurPegawai(Long noPegawai, String age);

    // Mono<PegawaiDetail> postStatus();
}
