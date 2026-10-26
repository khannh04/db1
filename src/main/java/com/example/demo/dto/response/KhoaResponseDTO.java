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
public class KhoaResponseDTO {
    private String maKhoa;
    private String tenKhoa;
    private Integer soLuongGiangVien;
    private Integer soLuongLop;
}
