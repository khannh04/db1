package com.example.demo.repository;

import com.example.demo.entity.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, String> {
    boolean existsByTenKhoa(String tenKhoa);
    boolean existsByTenKhoaAndMaKhoaNot(String tenKhoa, String maKhoa);
    Optional<Khoa> findByTenKhoa(String tenKhoa);
}
