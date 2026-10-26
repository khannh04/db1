package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * DTO trả về kết quả học tập cho Frontend.
 * Chứa thuộc tính dẫn xuất: diemTong, diemChu, xepLoai (được tính toán động tại tầng Service).
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KetQuaResponseDTO {
    // Thông tin sinh viên
    private String maSV;
    private String hoTenSV;
    private String maLop;

    // Thông tin môn học
    private String maMH;
    private String tenMH;
    private Integer soTinChi;

    // Thông tin học kỳ
    private String maHK;
    private String namHoc;
    private Integer ky;

    // Các thành phần điểm gốc
    private BigDecimal diemCC;
    private BigDecimal diemGK;
    private BigDecimal diemCK;

    // Thuộc tính dẫn xuất - KHÔNG lưu trong DB, tự tính tại Service
    private BigDecimal diemTong;   // diemCC * 0.1 + diemGK * 0.2 + diemCK * 0.7
    private String diemChu;        // A, B+, B, C+, C, D+, D, F
    private String xepLoai;        // Xuất sắc, Giỏi, Khá, Trung bình, Yếu, Kém
    private Boolean ketQuaDat;     // true: Đạt (diemTong >= 4.0), false: Học lại
}
