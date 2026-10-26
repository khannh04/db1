package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
    name = "KHOA",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_khoa_ten", columnNames = "TenKhoa")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"giangViens", "lops"})
public class Khoa {

    @Id
    @Column(name = "MaKhoa", length = 10, nullable = false)
    private String maKhoa;

    @Column(name = "TenKhoa", length = 100, nullable = false, unique = true)
    private String tenKhoa;

    // Khoa 1 - N Giảng viên (DB: ON DELETE RESTRICT)
    @Builder.Default
    @OneToMany(mappedBy = "khoa", fetch = FetchType.LAZY)
    private List<GiangVien> giangViens = new ArrayList<>();

    // Khoa 1 - N Lớp (DB: ON DELETE RESTRICT)
    @Builder.Default
    @OneToMany(mappedBy = "khoa", fetch = FetchType.LAZY)
    private List<Lop> lops = new ArrayList<>();
}
