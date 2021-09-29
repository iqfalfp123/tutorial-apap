package apap.tutorial.emsidi.repository;

import apap.tutorial.emsidi.model.CabangModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;
public interface CabangDB extends JpaRepository<CabangModel, Long> {
    Optional<CabangModel> findByNoCabang(Long noCabang);
    List<CabangModel> findByOrderByNamaCabangAsc();
    
}
