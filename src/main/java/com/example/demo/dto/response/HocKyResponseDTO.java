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
public class HocKyResponseDTO {
    private String maHK;
    private String namHoc;
    private Integer ky;
    private String tenHocKy; // Ghép từ NamHoc + Ky
}
