package jz.cbq.android.complex_template.fragment;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.adapter.home.LeftAdapter;
import jz.cbq.android.complex_template.adapter.home.RightAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

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

        left = rootView.findViewById(R.id.leftRecyclerView);
        right = rootView.findViewById(R.id.rightRecyclerView);


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        leftList.add("CBQ");
        leftList.add("CB");
        leftAdapter = new LeftAdapter(leftList);
        left.setAdapter(leftAdapter);

        leftAdapter.setLeftListOnClickItemListener(position -> leftAdapter.setCurrentIndex(position));

    }
}