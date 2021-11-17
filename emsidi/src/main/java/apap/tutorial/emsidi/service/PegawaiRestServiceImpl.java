package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.rest.*;
import apap.tutorial.emsidi.repository.PegawaiDB;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService {
    private final WebClient webClient;
    @Autowired
    private PegawaiDB pegawaiDB;

    @Override
    public PegawaiModel createPegawai(PegawaiModel pegawai) {
        return pegawaiDB.save(pegawai);
    }

    @Override
    public List<PegawaiModel> retrieveListPegawai() {
        return pegawaiDB.findAll();
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai) {
        Optional<PegawaiModel> pegawai = pegawaiDB.findByNoPegawai(noPegawai);

        if (pegawai.isPresent()) {
            return pegawai.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate) {
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        pegawai.setNamaPegawai(pegawaiUpdate.getNamaPegawai());
        pegawai.setJenisKelamin(pegawaiUpdate.getJenisKelamin());
        pegawai.setCabang(pegawaiUpdate.getCabang());

        return pegawaiDB.save(pegawai);

    }

    @Override
    public void deletePegawai(Long noPegawai) {
        LocalTime now = LocalTime.now();
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        if ((now.isBefore(pegawai.getCabang().getWaktuBuka()) || now.isAfter(pegawai.getCabang().getWaktuTutup()))) {
            pegawaiDB.delete(pegawai);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public PegawaiRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.agify.io").build();
    }

    @Override
    public Mono<ResponsePegawai> getUmurPegawai(Long noPegawai) {
        PegawaiModel pegawai = pegawaiDB.findById(noPegawai).get();
        String namaPegawai = pegawai.getNamaPegawai().split(" ")[0];
        return this.webClient.get().uri("https://api.agify.io/?name=" + namaPegawai).retrieve().bodyToMono(ResponsePegawai.class);
    }
    @Override
    public Map<String, Object> addUmurPegawai(Long noPegawai, String age) {
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        pegawai.setUmurPegawai(Integer.parseInt(age));
        pegawaiDB.save(pegawai);
        Map<String, Object> result = new HashMap<>();
        result.put("noPegawai", pegawai.getNoPegawai());
        result.put("namaPegawai", pegawai.getNamaPegawai().split(" ")[0]);
        result.put("jenisKelamin", pegawai.getJenisKelamin());
        result.put("umur", pegawai.getUmurPegawai());
        return result;
    }

    // @Override
    // public Mono<PegawaiDetail> postStatus() {
    //     MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
    //     data.add("namaPegawai", "Pegawai C");
    //     data.add("alamatPegawai", "Jl. C");

    //     return this.webClient.post().uri("/rest/pegawai/full").syncBody(data).retrieve().bodyToMono(PegawaiDetail.class);
    // }
}
