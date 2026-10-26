package com.example.demo.dto.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KetQuaRequestDTO {

    @NotBlank(message = "Mã sinh viên không được để trống")
    private String maSV;

    @NotBlank(message = "Mã môn học không được để trống")
    private String maMH;

    @NotBlank(message = "Mã học kỳ không được để trống")
    private String maHK;

    @DecimalMin(value = "0.00", message = "Điểm chuyên cần phải >= 0")
    @DecimalMax(value = "10.00", message = "Điểm chuyên cần phải <= 10")
    @Digits(integer = 2, fraction = 2, message = "Điểm chuyên cần tối đa 2 chữ số thập phân")
    private BigDecimal diemCC;

    @DecimalMin(value = "0.00", message = "Điểm giữa kỳ phải >= 0")
    @DecimalMax(value = "10.00", message = "Điểm giữa kỳ phải <= 10")
    @Digits(integer = 2, fraction = 2, message = "Điểm giữa kỳ tối đa 2 chữ số thập phân")
    private BigDecimal diemGK;

    @DecimalMin(value = "0.00", message = "Điểm cuối kỳ phải >= 0")
    @DecimalMax(value = "10.00", message = "Điểm cuối kỳ phải <= 10")
    @Digits(integer = 2, fraction = 2, message = "Điểm cuối kỳ tối đa 2 chữ số thập phân")
    private BigDecimal diemCK;
}
