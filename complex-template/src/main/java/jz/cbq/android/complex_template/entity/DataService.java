package jz.cbq.android.complex_template.entity;

import jz.cbq.android.complex_template.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页数据提供者
 *
 * @author CBQ
 * @date 2023/11/7 0:13
 * @since 1.0.0
 */
public class DataService {

    /**
     * 根据 position 获取 list
     * @param position position
     * @return list
     */
    public static List<ProductInfo> getListData(int position) {
        List<ProductInfo> list = new ArrayList<>();
        if (position == 0) {
            list.add(new ProductInfo(1, R.drawable.avatar, "CBQ", "I am cbq-1", 100));
            list.add(new ProductInfo(2, R.drawable.avatar, "CBQ", "I am cbq-2", 200));
            list.add(new ProductInfo(3, R.drawable.avatar, "CBQ", "I am cbq-3", 300));
            list.add(new ProductInfo(4, R.drawable.avatar, "CBQ", "I am cbq-4", 400));
        } else {
            list.add(new ProductInfo(1, R.drawable.avatar, "CB", "I am cb-1", 100));
            list.add(new ProductInfo(2, R.drawable.avatar, "CB", "I am cb-2", 200));
            list.add(new ProductInfo(3, R.drawable.avatar, "CB", "I am cb-3", 300));
        }
        return list;
    }
}
