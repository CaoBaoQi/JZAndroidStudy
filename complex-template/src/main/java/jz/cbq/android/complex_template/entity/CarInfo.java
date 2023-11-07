package jz.cbq.android.complex_template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 购物车信息
 *
 * @author CBQ
 * @date 2023/11/7 16:12
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarInfo {
    /**
     * id
     */
    private Integer car_id;
    /**
     * username
     */
    private String username;
    /**
     * 商品 id
     */
    private int product_id;
    /**
     * 商品 img
     */
    private int product_img;
    /**
     * 商品 title
     */
    private String product_title;
    /**
     * 商品 description
     */
    private String product_description;
    /**
     * 商品 price
     */
    private int product_price;

    /**
     * 商品 count
     */
    private int product_count;

}
