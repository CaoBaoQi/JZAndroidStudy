package jz.cbq.android.complex_template.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.adapter.car.CarAdapter;
import jz.cbq.android.complex_template.adapter.order.OrderAdapter;
import jz.cbq.android.complex_template.db.CarDbHelper;
import jz.cbq.android.complex_template.db.OrderDbHelper;
import jz.cbq.android.complex_template.entity.CarInfo;
import jz.cbq.android.complex_template.entity.OrderInfo;
import jz.cbq.android.complex_template.entity.UserInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 订单
 *
 * @author CBQ
 * @date 2023/11/7 0:13
 * @since 1.0.0
 */
public class OrderFragment extends Fragment {
    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;
    private View rootView;


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_order, container, false);
        }

        recyclerView = rootView.findViewById(R.id.order_fragment_recycleView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        orderAdapter = new OrderAdapter();
        recyclerView.setAdapter(orderAdapter);

        loadData();


    }

    public void loadData() {
        UserInfo userInfo = UserInfo.getCurrentUserInfo();
        if (userInfo != null) {
            List<OrderInfo> orderInfoList = OrderDbHelper.getInstance(getActivity()).findAll(userInfo.getUsername());
            orderAdapter.setDataList(orderInfoList);
        }

    }
}