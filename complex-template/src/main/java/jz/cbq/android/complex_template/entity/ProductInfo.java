package jz.cbq.android.complex_template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品信息
 *
 * @author CBQ
 * @date 2023/11/6 23:50
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo implements Serializable {
    /**
     * id
     */
    private int id;
    /**
     * img
     */
    private int img;
    /**
     * title
     */
    private String title;
    /**
     * description
     */
    private String description;
    /**
     * price
     */
    private int price;
}
