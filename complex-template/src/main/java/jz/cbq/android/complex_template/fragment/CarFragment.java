package jz.cbq.android.complex_template.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.adapter.car.CarAdapter;
import jz.cbq.android.complex_template.db.CarDbHelper;
import jz.cbq.android.complex_template.db.OrderDbHelper;
import jz.cbq.android.complex_template.entity.CarInfo;
import jz.cbq.android.complex_template.entity.UserInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 购物车
 *
 * @author CBQ
 * @date 2023/11/7 0:13
 * @since 1.0.0
 */
public class CarFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private CarAdapter carAdapter;
    private TextView tx_total;
    private Button btn_buy;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_car, container, false);
        }
        recyclerView = rootView.findViewById(R.id.car_fragment_recyclerView);
        tx_total = rootView.findViewById(R.id.car_fragment_tx_total);
        btn_buy = rootView.findViewById(R.id.car_fragment_btn_buy);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        carAdapter = new CarAdapter();
        recyclerView.setAdapter(carAdapter);
        carAdapter.setCarAdapterOnItemClickListener(new CarAdapter.CarAdapterOnItemClickListener() {
            @Override
            public void addOnClick(CarInfo carInfo, int position) {
                CarDbHelper.getInstance(getActivity()).updateProduct(carInfo.getCar_id(), carInfo);
                loadData();
            }

            @Override
            public void subOnClick(CarInfo carInfo, int position) {
                CarDbHelper.getInstance(getActivity()).updateProductSub(carInfo.getCar_id(), carInfo);
                loadData();
            }

            @Override
            public void deleteOnClick(CarInfo carInfo, int position) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle("确定删除吗？")
                        .setPositiveButton("确认", (dialog, which) -> {
                            CarDbHelper.getInstance(getActivity()).delete(carInfo.getCar_id() + "");
                            loadData();
                        })
                        .setNegativeButton("取消", (dialog, which) -> Toast.makeText(getActivity(), "取消删除", Toast.LENGTH_SHORT).show()).create().show();
            }
        });

        btn_buy.setOnClickListener(v -> {
            UserInfo userInfo = UserInfo.getCurrentUserInfo();

            if (userInfo != null) {
                List<CarInfo> carInfoList = CarDbHelper.getInstance(getActivity()).findAll(userInfo.getUsername());
                if (carInfoList.size() == 0){
                    Toast.makeText(getActivity(), "当前购物车为空", Toast.LENGTH_SHORT).show();
                }else {
                    OrderDbHelper.getInstance(getActivity()).insertByAll(carInfoList, "文华街 199 号", "19510201902");
                    carInfoList.forEach(carInfo -> CarDbHelper.getInstance(getActivity()).delete(carInfo.getCar_id() + ""));
                    loadData();
                }
            }
        });

        loadData();
    }

    public void setTotalData(List<CarInfo> carInfoList) {
        AtomicInteger total = new AtomicInteger();
        carInfoList.forEach(carInfo -> total.addAndGet(carInfo.getProduct_price() * carInfo.getProduct_count()));
        tx_total.setText(total + " ");
    }

    public void loadData() {
        UserInfo userInfo = UserInfo.getCurrentUserInfo();

        if (userInfo != null) {
            List<CarInfo> carInfoList = CarDbHelper.getInstance(getActivity()).findAll(userInfo.getUsername());
            carAdapter.setDataList(carInfoList);
            setTotalData(carInfoList);
        }


    }
}