package jz.cbq.android.complex_template.adapter.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.entity.OrderInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 订单 Adapter
 *
 * @author CBQ
 * @date 2023/11/8 13:50
 * @since 1.0.0
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.Holder> {
    private List<OrderInfo> dataList;

    public void setDataList(List<OrderInfo> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }


    @NonNull
    @NotNull
    @Override
    public OrderAdapter.Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item, null);

        return new OrderAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OrderAdapter.Holder holder, int position) {

        OrderInfo orderInfo = dataList.get(position);

        holder.product_img.setImageResource(orderInfo.getProduct_img());
        holder.product_title.setText(orderInfo.getProduct_title());
        holder.product_price.setText(orderInfo.getProduct_price() + "");
        holder.product_count.setText("x " + orderInfo.getProduct_count());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        ImageView product_img;
        TextView product_title;
        TextView product_price;
        TextView product_count;


        public Holder(@NonNull @NotNull View itemView) {
            super(itemView);
            product_img = itemView.findViewById(R.id.order_list_item_iv_01);
            product_title = itemView.findViewById(R.id.order_list_item_tv_title);
            product_price = itemView.findViewById(R.id.order_list_item_tv_price);
            product_count = itemView.findViewById(R.id.order_list_item_tv_count);
        }
    }

}
