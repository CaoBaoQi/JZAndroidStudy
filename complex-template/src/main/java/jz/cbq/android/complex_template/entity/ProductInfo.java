package jz.cbq.android.complex_template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProductInfo
 *
 * @author Cola777jz
 * @date 2023/11/6 23:50
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {
    private int id;
    private int img;
    private String title;
    private String description;
    private int price;
}
