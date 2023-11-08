package jz.cbq.android.complex_template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品信息
 *
 * @author CBQ
 * @date 2023/11/8 13:55
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo {
    /**
     * id
     */
    private Integer order_id;
    /**
     * username
     */
    private String username;
    /**
     * 商品 img
     */
    private int product_img;
    /**
     * 商品 title
     */
    private String product_title;

    /**
     * 商品 price
     */
    private int product_price;

    /**
     * 商品 count
     */
    private int product_count;
    /**
     * 地址
     */
    private String address;
    /**
     * 电话
     */
    private String mobile;
}
