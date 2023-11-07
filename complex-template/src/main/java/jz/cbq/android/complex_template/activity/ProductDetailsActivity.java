package jz.cbq.android.complex_template.activity;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.entity.ProductInfo;

public class ProductDetailsActivity extends AppCompatActivity {
    private ImageView iv_img;
    private TextView tx_title;
    private TextView tx_description;
    private TextView tx_price;

    private ProductInfo productInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        productInfo = (ProductInfo) getIntent().getSerializableExtra("productInfo");


        findViewById(R.id.product_details_activity_toolbar).setOnClickListener(v -> finish());


        iv_img = findViewById(R.id.product_details_activity_iv_img);
        tx_title = findViewById(R.id.product_details_activity_tv_title);
        tx_description = findViewById(R.id.product_details_activity_tv_description);
        tx_price = findViewById(R.id.product_details_activity_tv_price);


        if (productInfo != null) {
            iv_img.setImageResource(productInfo.getImg());
            tx_title.setText(productInfo.getTitle());
            tx_description.setText(productInfo.getDescription());
            tx_price.setText(productInfo.getPrice() + " ");
        }


    }
}