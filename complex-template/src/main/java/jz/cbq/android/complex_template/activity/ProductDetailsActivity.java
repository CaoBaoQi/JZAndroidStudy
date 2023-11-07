package jz.cbq.android.complex_template.activity;

import android.annotation.SuppressLint;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.entity.ProductInfo;


/**
 * 商品详情
 *
 * @author CBQ
 * @date 2023/11/6 22:54
 * @since 1.0.0
 */
public class ProductDetailsActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ProductInfo productInfo = (ProductInfo) getIntent().getSerializableExtra("productInfo");

        findViewById(R.id.product_details_activity_toolbar).setOnClickListener(v -> finish());


        ImageView iv_img = findViewById(R.id.product_details_activity_iv_img);
        TextView tx_title = findViewById(R.id.product_details_activity_tv_title);
        TextView tx_description = findViewById(R.id.product_details_activity_tv_description);
        TextView tx_price = findViewById(R.id.product_details_activity_tv_price);


        if (productInfo != null) {
            iv_img.setImageResource(productInfo.getImg());
            tx_title.setText(productInfo.getTitle());
            tx_description.setText(productInfo.getDescription());
            tx_price.setText(productInfo.getPrice() + " ");
        }


    }
}