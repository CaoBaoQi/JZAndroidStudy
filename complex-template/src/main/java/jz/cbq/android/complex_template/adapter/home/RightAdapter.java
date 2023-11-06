package jz.cbq.android.complex_template.adapter.home;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

/**
 * RightAdapter
 *
 * @author Cola777jz
 * @date 2023/11/6 22:54
 * @since 1.0.0
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.Holder> {

    @NonNull
    @NotNull
    @Override
    public Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}

