package com.example.demo.repository;

import com.example.demo.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String> {

    boolean existsByEmail(String email);
    boolean existsByEmailAndMaSVNot(String email, String maSV);

    List<SinhVien> findByLop_MaLop(String maLop);

    // JOIN FETCH Lop và Khoa của Lop để tối ưu hóa truy vấn
    @Query("SELECT s FROM SinhVien s JOIN FETCH s.lop l JOIN FETCH l.khoa")
    List<SinhVien> findAllWithLopAndKhoa();

    @Query("SELECT s FROM SinhVien s JOIN FETCH s.lop l JOIN FETCH l.khoa WHERE s.maSV = :maSV")
    Optional<SinhVien> findByIdWithLopAndKhoa(@Param("maSV") String maSV);
}
