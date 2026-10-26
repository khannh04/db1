package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "SINHVIEN",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_sinhvien_email", columnNames = "Email")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"lop", "ketQuas"})
public class SinhVien {

    @Id
    @Column(name = "MaSV", length = 15, nullable = false)
    private String maSV;

    @Column(name = "HoTen", length = 100, nullable = false)
    private String hoTen;

    @Column(name = "NgaySinh", nullable = false)
    private LocalDate ngaySinh;

    @Column(name = "GioiTinh", length = 5, nullable = false)
    private String gioiTinh;

    @Column(name = "DiaChi", length = 255)
    private String diaChi;

    @Column(name = "Email", length = 100, unique = true)
    private String email;

    @Column(name = "SoDienThoai", length = 15)
    private String soDienThoai;

    // Sinh viên thuộc 1 Lớp (bắt buộc)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaLop", nullable = false)
    private Lop lop;

    // Sinh viên 1 - N Kết quả (DB: ON DELETE CASCADE)
    @Builder.Default
    @OneToMany(mappedBy = "sinhVien", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KetQua> ketQuas = new ArrayList<>();
}
