package com.example.demo.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class MonHocRequestDTO {

    @NotBlank(message = "Mã môn học không được để trống")
    @Size(max = 15, message = "Mã môn học tối đa 15 ký tự")
    private String maMH;

    @NotBlank(message = "Tên môn học không được để trống")
    @Size(max = 150, message = "Tên môn học tối đa 150 ký tự")
    private String tenMH;

    @NotNull(message = "Số tín chỉ không được để trống")
    @Min(value = 1, message = "Số tín chỉ phải lớn hơn 0")
    private Integer soTinChi;
}
