package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
@Table(name = "MONHOC")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"ketQuas"})
public class MonHoc {

    @Id
    @Column(name = "MaMH", length = 15, nullable = false)
    private String maMH;

    @Column(name = "TenMH", length = 150, nullable = false)
    private String tenMH;

    @Column(name = "SoTinChi", nullable = false)
    private Integer soTinChi;

    // Môn học 1 - N Kết quả
    @Builder.Default
    @OneToMany(mappedBy = "monHoc", fetch = FetchType.LAZY)
    private List<KetQua> ketQuas = new ArrayList<>();
}
