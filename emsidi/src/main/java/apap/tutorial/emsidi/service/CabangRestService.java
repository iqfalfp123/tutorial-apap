package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.rest.CabangDetail;
import java.util.List;
import reactor.core.publisher.Mono;

public interface CabangRestService {
    CabangModel createCabang(CabangModel cabang);
    List<CabangModel> retrieveListCabang();
    CabangModel getCabangByNoCabang(Long nocabang);
    CabangModel updateCabang(Long nocabang, CabangModel cabangUpdate);
    void deleteCabang(Long noCabang);
    Mono<String> getStatus(Long noCabang);
    Mono<CabangDetail> postStatus();
}
