package jz.cbq.android.complex_template.adapter.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jz.cbq.android.complex_template.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * LeftAdapter
 *
 * @author Cola777jz
 * @date 2023/11/6 22:54
 * @since 1.0.0
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.Holder> {

    private List<String> dataList = new ArrayList<>();
    private int currentIndex = 0;
    private LeftListOnClickItemListener leftListOnClickItemListener;

    public LeftAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    public void setLeftListOnClickItemListener(LeftListOnClickItemListener leftListOnClickItemListener) {
        this.leftListOnClickItemListener = leftListOnClickItemListener;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_list_item, null);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Holder holder, int position) {
        holder.tv_name.setText(dataList.get(position));

        holder.itemView.setOnClickListener(v -> {
            if (leftListOnClickItemListener != null) {
                leftListOnClickItemListener.onItemClick(position);
            }
        });

        if (currentIndex == position){
            holder.itemView.setBackgroundResource(R.drawable.type_selector_bg);
        }else {
            holder.itemView.setBackgroundResource(R.drawable.type_selector_normal_bg);
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView tv_name;

        public Holder(@NonNull @NotNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.name);
        }
    }


    public interface LeftListOnClickItemListener {
        void onItemClick(int position);
    }

}
