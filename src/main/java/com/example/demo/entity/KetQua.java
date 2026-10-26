package com.example.demo.entity;

import com.example.demo.entity.id.KetQuaId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Thực thể yếu KETQUA: Khóa chính mượn từ 3 thực thể chủ (SinhVien, MonHoc, HocKy).
 * Lưu ý: Điểm tổng là thuộc tính dẫn xuất, KHÔNG lưu trong Entity mà tính toán trong DTO.
 */
@Entity
@Table(name = "KETQUA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"sinhVien", "monHoc", "hocKy"})
public class KetQua {

    @EmbeddedId
    private KetQuaId id;

    // Quan hệ mượn khóa từ SINHVIEN
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maSV")
    @JoinColumn(name = "MaSV", nullable = false)
    private SinhVien sinhVien;

    // Quan hệ mượn khóa từ MONHOC
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maMH")
    @JoinColumn(name = "MaMH", nullable = false)
    private MonHoc monHoc;

    // Quan hệ mượn khóa từ HOCKY
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maHK")
    @JoinColumn(name = "MaHK", nullable = false)
    private HocKy hocKy;

    @Column(name = "DiemCC", precision = 4, scale = 2)
    private BigDecimal diemCC;

    @Column(name = "DiemGK", precision = 4, scale = 2)
    private BigDecimal diemGK;

    @Column(name = "DiemCK", precision = 4, scale = 2)
    private BigDecimal diemCK;
}
