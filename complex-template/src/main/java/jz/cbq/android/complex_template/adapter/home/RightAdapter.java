package jz.cbq.android.complex_template.adapter.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.entity.ProductInfo;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * RightAdapter
 *
 * @author Cola777jz
 * @date 2023/11/6 22:54
 * @since 1.0.0
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.Holder> {
    private onItemClickListener itemClickListener;

    private List<ProductInfo> dataList = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setDataList(List<ProductInfo> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void setItemClickListener(onItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.right_list_item, null);
        return new Holder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull Holder holder, int position) {
        ProductInfo productInfo = dataList.get(position);

        holder.img.setImageResource(productInfo.getImg());
        holder.title.setText(productInfo.getTitle());
        holder.description.setText(productInfo.getDescription());

        holder.price.setText(productInfo.getPrice() + " ");

        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClick(productInfo,position));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;
        TextView description;
        TextView price;

        public Holder(@NonNull @NotNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_img);
            title = itemView.findViewById(R.id.tx_title);
            description = itemView.findViewById(R.id.tx_description);
            price = itemView.findViewById(R.id.tx_price);
        }
    }

    public interface onItemClickListener{
        void onItemClick(ProductInfo productInfo, int position);
    }
}

