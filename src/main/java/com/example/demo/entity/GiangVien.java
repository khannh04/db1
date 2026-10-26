package com.example.demo.entity;

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

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "GIANGVIEN",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_giangvien_email", columnNames = "Email")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"khoa", "lopsCoVan"})
public class GiangVien {

    @Id
    @Column(name = "MaGV", length = 10, nullable = false)
    private String maGV;

    @Column(name = "HoTen", length = 100, nullable = false)
    private String hoTen;

    @Column(name = "Email", length = 100, unique = true)
    private String email;

    @Column(name = "SoDienThoai", length = 15)
    private String soDienThoai;

    // Giảng viên thuộc 1 Khoa (bắt buộc)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKhoa", nullable = false)
    private Khoa khoa;

    // Giảng viên cố vấn N Lớp (DB: Cố vấn 1 - N Lớp, không bắt buộc)
    @Builder.Default
    @OneToMany(mappedBy = "giangVienCoVan", fetch = FetchType.LAZY)
    private List<Lop> lopsCoVan = new ArrayList<>();
}
