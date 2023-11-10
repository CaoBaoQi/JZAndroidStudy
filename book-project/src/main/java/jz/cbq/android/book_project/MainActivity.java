package jz.cbq.android.book_project;

import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import jz.cbq.android.book_project.fragment.FragmentCar;
import jz.cbq.android.book_project.fragment.FragmentHome;
import jz.cbq.android.book_project.fragment.FragmentMine;
import jz.cbq.android.book_project.fragment.FragmentOrder;

public class MainActivity extends AppCompatActivity {
    private FragmentHome home;
    private FragmentCar car;
    private FragmentOrder order;
    private FragmentMine mine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        BottomNavigationView bottom = findViewById(R.id.main_activity_bottom);
        bottom.setItemIconTintList(null); // 取消图标的着色效果
        selectedFragment(0);

        bottom.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.tab_home) {
                selectedFragment(0);
            } else if (item.getItemId() == R.id.tab_car) {
                selectedFragment(1);
            }else if (item.getItemId() == R.id.tab_order) {
                selectedFragment(2);
            } else {
                selectedFragment(3);
            }
            return true;
        });

    }


    /**
     * 选中 Fragment
     *
     * @param position position
     */
    private void selectedFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (position) {
            case 0:
                if (home == null) {
                    home = new FragmentHome();
                    transaction.add(R.id.main_activity_container, home);
                } else {
                    transaction.show(home);
                }
                break;
            case 1:
                if (car == null) {
                    car = new FragmentCar();
                    transaction.add(R.id.main_activity_container, car);
                } else {
                    transaction.show(car);
                }
                break;
            case 2:
                if (order == null) {
                    order = new FragmentOrder();
                    transaction.add(R.id.main_activity_container, order);
                } else {
                    transaction.show(order);
                }
                break;
            default:
                if (mine == null) {
                    mine = new FragmentMine();
                    transaction.add(R.id.main_activity_container, mine);
                } else {
                    transaction.show(mine);
                }
                break;
        }

        transaction.commit();
    }

    /**
     * 隐藏 Fragment
     *
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