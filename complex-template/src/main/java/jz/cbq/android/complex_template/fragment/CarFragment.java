package jz.cbq.android.complex_template.fragment;

import android.os.Bundle;
import android.util.Log;
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
import jz.cbq.android.complex_template.entity.CarInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (rootView == null){
            rootView = inflater.inflate(R.layout.fragment_car, container, false);
        }
        recyclerView = rootView.findViewById(R.id.car_fragment_recyclerView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        carAdapter = new CarAdapter();
        recyclerView.setAdapter(carAdapter);

        loadData();
    }

    public  void loadData() {
        List<CarInfo> carInfoList = CarDbHelper.getInstance(getActivity()).findAll("cbq");
        Log.d("cbq", carInfoList.toString());
        carAdapter.setDataList(carInfoList);
    }
}