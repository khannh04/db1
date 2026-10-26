package com.example.demo.dto.request;

import jakarta.validation.constraints.Max;
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
public class LopRequestDTO {

    @NotBlank(message = "Mã lớp không được để trống")
    @Size(max = 15, message = "Mã lớp tối đa 15 ký tự")
    private String maLop;

    @NotBlank(message = "Tên lớp không được để trống")
    @Size(max = 100, message = "Tên lớp tối đa 100 ký tự")
    private String tenLop;

    @NotNull(message = "Khóa học không được để trống")
    @Min(value = 2000, message = "Khóa học phải từ năm 2000 trở đi")
    @Max(value = 2100, message = "Khóa học không vượt quá năm 2100")
    private Integer khoaHoc;

    @NotBlank(message = "Mã khoa không được để trống")
    @Size(max = 10, message = "Mã khoa tối đa 10 ký tự")
    private String maKhoa;

    @Size(max = 10, message = "Mã giảng viên cố vấn tối đa 10 ký tự")
    private String maGVCoVan; // Có thể null
}
