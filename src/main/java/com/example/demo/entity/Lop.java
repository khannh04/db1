package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LOP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"khoa", "giangVienCoVan", "sinhViens"})
public class Lop {

    @Id
    @Column(name = "MaLop", length = 15, nullable = false)
    private String maLop;

    @Column(name = "TenLop", length = 100, nullable = false)
    private String tenLop;

    @Column(name = "KhoaHoc", nullable = false)
    private Integer khoaHoc;

    // Lớp thuộc 1 Khoa (bắt buộc)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKhoa", nullable = false)
    private Khoa khoa;

    // Cố vấn học tập (có thể null, DB: ON DELETE SET NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaGVCoVan")
    private GiangVien giangVienCoVan;

    // Lớp 1 - N Sinh viên
    @Builder.Default
    @OneToMany(mappedBy = "lop", fetch = FetchType.LAZY)
    private List<SinhVien> sinhViens = new ArrayList<>();
}
