package com.example.demo.repository;

import com.example.demo.entity.HocKy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HocKyRepository extends JpaRepository<HocKy, String> {
    Optional<HocKy> findByNamHocAndKy(String namHoc, Integer ky);
    boolean existsByNamHocAndKy(String namHoc, Integer ky);
}
