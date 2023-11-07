package jz.cbq.android.complex_template;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import jz.cbq.android.complex_template.fragment.CarFragment;
import jz.cbq.android.complex_template.fragment.HomeFragment;
import jz.cbq.android.complex_template.fragment.MineFragment;
import jz.cbq.android.complex_template.fragment.OrderFragment;

/**
 * 安卓 启动！
 *
 * @author CBQ
 * @date 2023/11/7 0:13
 * @since 1.0.0
 */
public class MainActivity extends AppCompatActivity {
    private HomeFragment home;
    private CarFragment car;
    private OrderFragment order;
    private MineFragment mine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottom = findViewById(R.id.main_activity_bottomNavigationView);

        selectedFragment(0);

        bottom.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                selectedFragment(0);
            } else if (item.getItemId() == R.id.navigation_car) {
                selectedFragment(1);
            } else if (item.getItemId() == R.id.navigation_order) {
                selectedFragment(2);
            } else {
                selectedFragment(3);
            }
            return true;
        });
    }

    /**
     * 选中 Fragment
     * @param position position
     */
    private void selectedFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);

        if (position == 0) {
            if (home == null) {
                home = new HomeFragment();
                transaction.add(R.id.main_activity_content, home);
            } else {
                transaction.show(home);
            }
        } else if (position == 1) {
            if (car == null) {
                car = new CarFragment();
                transaction.add(R.id.main_activity_content, car);
            } else {
                transaction.show(car);
                car.loadData();
            }
        } else if (position == 2) {
            if (order == null) {
                order = new OrderFragment();
                transaction.add(R.id.main_activity_content, order);
            } else {
                transaction.show(order);
            }
        } else {
            if (mine == null) {
                mine = new MineFragment();
                transaction.add(R.id.main_activity_content, mine);
            } else {
                transaction.show(mine);
            }
        }

        transaction.commit();
    }

    /**
     * 隐藏 Fragment
     * @param transaction transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (home != null) {
            transaction.hide(home);
        }
        if (car != null) {
            transaction.hide(car);
        }
        if (order != null) {
            transaction.hide(order);
        }
        if (mine != null) {
            transaction.hide(mine);
        }
    }
}