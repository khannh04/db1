package com.example.demo.repository;

import com.example.demo.entity.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, String> {

    boolean existsByEmail(String email);
    boolean existsByEmailAndMaGVNot(String email, String maGV);

    List<GiangVien> findByKhoa_MaKhoa(String maKhoa);

    // Dùng JOIN FETCH để tránh lỗi N+1 Query
    @Query("SELECT g FROM GiangVien g JOIN FETCH g.khoa")
    List<GiangVien> findAllWithKhoa();

    @Query("SELECT g FROM GiangVien g JOIN FETCH g.khoa WHERE g.maGV = :maGV")
    Optional<GiangVien> findByIdWithKhoa(@Param("maGV") String maGV);
}
