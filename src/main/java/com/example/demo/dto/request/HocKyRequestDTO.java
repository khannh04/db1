package com.example.demo.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class HocKyRequestDTO {

    @NotBlank(message = "Mã học kỳ không được để trống")
    @Size(max = 10, message = "Mã học kỳ tối đa 10 ký tự")
    private String maHK;

    @NotBlank(message = "Năm học không được để trống")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{4}$", message = "Năm học phải theo định dạng YYYY-YYYY (VD: 2024-2025)")
    private String namHoc;

    @NotNull(message = "Kỳ học không được để trống")
    @Min(value = 1, message = "Kỳ học từ 1 đến 3")
    @Max(value = 3, message = "Kỳ học từ 1 đến 3 (1: Học kỳ 1, 2: Học kỳ 2, 3: Kỳ hè)")
    private Integer ky;
}
