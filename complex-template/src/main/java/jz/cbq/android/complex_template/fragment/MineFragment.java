package jz.cbq.android.complex_template.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jz.cbq.android.complex_template.R;
import org.jetbrains.annotations.NotNull;

/**
 * 我的
 *
 * @author CBQ
 * @date 2023/11/7 0:13
 * @since 1.0.0
 */
public class MineFragment extends Fragment {

    private View rootView;


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (rootView == null){
            rootView = inflater.inflate(R.layout.fragment_mine, container, false);
        }

        return rootView;
    }
}