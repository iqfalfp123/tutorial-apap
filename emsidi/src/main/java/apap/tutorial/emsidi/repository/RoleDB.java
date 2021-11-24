package apap.tutorial.emsidi.repository;

import apap.tutorial.emsidi.model.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleDB extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findById(Long id);
}
