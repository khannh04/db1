package com.example.demo.repository;

import com.example.demo.entity.KetQua;
import com.example.demo.entity.id.KetQuaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KetQuaRepository extends JpaRepository<KetQua, KetQuaId> {

    List<KetQua> findById_MaSV(String maSV);
    List<KetQua> findById_MaMH(String maMH);
    List<KetQua> findById_MaHK(String maHK);

    // JOIN FETCH đầy đủ các thực thể chủ để không bị N+1 query khi hiển thị bảng điểm
    @Query("SELECT k FROM KetQua k " +
           "JOIN FETCH k.sinhVien s " +
           "JOIN FETCH s.lop l " +
           "JOIN FETCH k.monHoc " +
           "JOIN FETCH k.hocKy")
    List<KetQua> findAllWithDetails();

    @Query("SELECT k FROM KetQua k " +
           "JOIN FETCH k.sinhVien s " +
           "JOIN FETCH s.lop l " +
           "JOIN FETCH k.monHoc " +
           "JOIN FETCH k.hocKy " +
           "WHERE k.id = :id")
    Optional<KetQua> findByIdWithDetails(@Param("id") KetQuaId id);

    @Query("SELECT k FROM KetQua k " +
           "JOIN FETCH k.sinhVien s " +
           "JOIN FETCH s.lop l " +
           "JOIN FETCH k.monHoc " +
           "JOIN FETCH k.hocKy " +
           "WHERE k.id.maSV = :maSV")
    List<KetQua> findBySinhVienWithDetails(@Param("maSV") String maSV);

    @Query("SELECT k FROM KetQua k " +
           "JOIN FETCH k.sinhVien s " +
           "JOIN FETCH s.lop l " +
           "JOIN FETCH k.monHoc " +
           "JOIN FETCH k.hocKy " +
           "WHERE k.id.maSV = :maSV AND k.id.maHK = :maHK")
    List<KetQua> findBySinhVienAndHocKyWithDetails(@Param("maSV") String maSV, @Param("maHK") String maHK);
}
