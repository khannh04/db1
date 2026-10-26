package com.example.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class GiangVienRequestDTO {

    @NotBlank(message = "Mã giảng viên không được để trống")
    @Size(max = 10, message = "Mã giảng viên tối đa 10 ký tự")
    private String maGV;

    @NotBlank(message = "Họ tên giảng viên không được để trống")
    @Size(max = 100, message = "Họ tên tối đa 100 ký tự")
    private String hoTen;

    @Email(message = "Email không đúng định dạng")
    @Size(max = 100, message = "Email tối đa 100 ký tự")
    private String email;

    @Pattern(regexp = "^[0-9]{10,15}$", message = "Số điện thoại phải từ 10 đến 15 chữ số")
    private String soDienThoai;

    @NotBlank(message = "Mã khoa không được để trống")
    @Size(max = 10, message = "Mã khoa tối đa 10 ký tự")
    private String maKhoa;
}
