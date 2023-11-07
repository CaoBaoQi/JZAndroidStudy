package jz.cbq.android.complex_template.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.activity.ProductDetailsActivity;
import jz.cbq.android.complex_template.adapter.home.LeftAdapter;
import jz.cbq.android.complex_template.adapter.home.RightAdapter;
import jz.cbq.android.complex_template.entity.DataService;
import jz.cbq.android.complex_template.entity.ProductInfo;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页
 *
 * @author CBQ
 * @date 2023/11/7 0:13
 * @since 1.0.0
 */
public class HomeFragment extends Fragment {

    private View rootView;
    private RecyclerView left, right;

    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;

    private List<String> leftList = new ArrayList<>();

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
        }

        left = rootView.findViewById(R.id.home_fragment_leftRecyclerView);
        right = rootView.findViewById(R.id.home_fragment_rightRecyclerView);


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        leftList.add("CBQ");
        leftList.add("CB");
        leftAdapter = new LeftAdapter(leftList);
        left.setAdapter(leftAdapter);

        rightAdapter = new RightAdapter();
        rightAdapter.setDataList(DataService.getListData(0));
        right.setAdapter(rightAdapter);

        rightAdapter.setItemClickListener((productInfo, position) -> {
            Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
            intent.putExtra("productInfo", productInfo);
            startActivity(intent);
        });

        leftAdapter.setLeftListOnClickItemListener(position -> {
            leftAdapter.setCurrentIndex(position);

            rightAdapter.setDataList(DataService.getListData(position));
        });


    }
}