package com.example.demo.repository;

import com.example.demo.entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, String> {
    List<MonHoc> findByTenMHContainingIgnoreCase(String tenMH);
    boolean existsByTenMH(String tenMH);
}
