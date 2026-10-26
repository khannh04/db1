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
public class GiangVienResponseDTO {
    private String maGV;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String maKhoa;
    private String tenKhoa;
}
