package com.example.demo.repository;

import com.example.demo.entity.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LopRepository extends JpaRepository<Lop, String> {

    List<Lop> findByKhoa_MaKhoa(String maKhoa);
    List<Lop> findByGiangVienCoVan_MaGV(String maGV);

    // JOIN FETCH để tải trước Khoa và GiangVien cố vấn, tránh N+1 Query
    @Query("SELECT l FROM Lop l JOIN FETCH l.khoa LEFT JOIN FETCH l.giangVienCoVan")
    List<Lop> findAllWithDetails();

    @Query("SELECT l FROM Lop l JOIN FETCH l.khoa LEFT JOIN FETCH l.giangVienCoVan WHERE l.maLop = :maLop")
    Optional<Lop> findByIdWithDetails(@Param("maLop") String maLop);
}
