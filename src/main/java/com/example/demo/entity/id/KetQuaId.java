package com.example.demo.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Composite Key cho thực thể yếu KETQUA
 * Mượn khóa chính từ: MaSV, MaMH, MaHK
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class KetQuaId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "MaSV", length = 15, nullable = false)
    private String maSV;

    @Column(name = "MaMH", length = 15, nullable = false)
    private String maMH;

    @Column(name = "MaHK", length = 10, nullable = false)
    private String maHK;
}
