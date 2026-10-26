package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LopResponseDTO {
    private String maLop;
    private String tenLop;
    private Integer khoaHoc;
    private String maKhoa;
    private String tenKhoa;
    private String maGVCoVan;
    private String tenGVCoVan;
    private Integer soLuongSinhVien;
}
