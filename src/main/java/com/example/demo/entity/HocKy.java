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
    name = "HOCKY",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_hocky_namky", columnNames = {"NamHoc", "Ky"})
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"ketQuas"})
public class HocKy {

    @Id
    @Column(name = "MaHK", length = 10, nullable = false)
    private String maHK;

    @Column(name = "NamHoc", length = 9, nullable = false)
    private String namHoc;

    @Column(name = "Ky", nullable = false)
    private Integer ky;

    // Học kỳ 1 - N Kết quả
    @Builder.Default
    @OneToMany(mappedBy = "hocKy", fetch = FetchType.LAZY)
    private List<KetQua> ketQuas = new ArrayList<>();
}
