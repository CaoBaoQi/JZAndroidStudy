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

    private List<ProductInfo> dataList = new ArrayList<>();

    public RightAdapter(List<ProductInfo> dataList) {
        this.dataList = dataList;
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
        ProductInfo info = dataList.get(position);

        holder.img.setImageResource(info.getImg());
        holder.title.setText(info.getTitle());
        holder.description.setText(info.getDescription());

        holder.price.setText(info.getPrice() + " ");
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
}

