package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class KhoaRequestDTO {

    @NotBlank(message = "Mã khoa không được để trống")
    @Size(max = 10, message = "Mã khoa tối đa 10 ký tự")
    private String maKhoa;

    @NotBlank(message = "Tên khoa không được để trống")
    @Size(max = 100, message = "Tên khoa tối đa 100 ký tự")
    private String tenKhoa;
}
