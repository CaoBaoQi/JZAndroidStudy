# Complex-Template

> 模板搭建 

# 一、底部导航栏（Bottom）

## activity_main

```java
package jz.cbq.android.complex_template;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import jz.cbq.android.complex_template.fragment.CarFragment;
import jz.cbq.android.complex_template.fragment.HomeFragment;
import jz.cbq.android.complex_template.fragment.MineFragment;
import jz.cbq.android.complex_template.fragment.OrderFragment;

public class MainActivity extends AppCompatActivity {
    private HomeFragment home;
    private CarFragment car;
    private OrderFragment order;
    private MineFragment mine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottom = findViewById(R.id.bottomNavigationView);

        selectedFragment(0);

        bottom.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                selectedFragment(0);
            } else if (item.getItemId() == R.id.car) {
                selectedFragment(1);
            } else if (item.getItemId() == R.id.order) {
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
                transaction.add(R.id.content, home);
            } else {
                transaction.show(home);
            }
        } else if (position == 1) {
            if (car == null) {
                car = new CarFragment();
                transaction.add(R.id.content, car);
            } else {
                transaction.show(car);
            }
        } else if (position == 2) {
            if (order == null) {
                order = new OrderFragment();
                transaction.add(R.id.content, order);
            } else {
                transaction.show(order);
            }
        } else {
            if (mine == null) {
                mine = new MineFragment();
                transaction.add(R.id.content, mine);
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
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context=".MainActivity">

    <FrameLayout
            android:id="@+id/content"
            android:layout_above="@+id/bottomNavigationView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>

    <com.google.android.material.bottomnavigation.BottomNavigationView
            android:id="@+id/bottomNavigationView"
            app:menu="@menu/navigation"
            android:layout_alignParentBottom="true"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>
</RelativeLayout>
```

## fragment

### HomeFragment

```java
package jz.cbq.android.complex_template.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jz.cbq.android.complex_template.R;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:tools="http://schemas.android.com/tools"
             android:layout_width="match_parent"
             android:layout_height="match_parent" xmlns:app="http://schemas.android.com/apk/res-auto"
             tools:context=".fragment.HomeFragment">

    <androidx.appcompat.widget.Toolbar
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:title="@string/home"
            app:titleTextColor="@color/white"
            android:background="@color/my_light_primary"/>


</FrameLayout>
```

### CarFragment

```java
package jz.cbq.android.complex_template.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jz.cbq.android.complex_template.R;

public class CarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car, container, false);
    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:tools="http://schemas.android.com/tools"
             android:layout_width="match_parent"
             android:layout_height="match_parent" xmlns:app="http://schemas.android.com/apk/res-auto"
             tools:context=".fragment.CarFragment">

    <androidx.appcompat.widget.Toolbar
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:title="@string/car"
            app:titleTextColor="@color/white"
            android:background="@color/my_light_primary"/>


</FrameLayout>
```

### OrderFragment

```java
package jz.cbq.android.complex_template.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jz.cbq.android.complex_template.R;

public class OrderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:tools="http://schemas.android.com/tools"
             android:layout_width="match_parent"
             android:layout_height="match_parent" xmlns:app="http://schemas.android.com/apk/res-auto"
             tools:context=".fragment.OrderFragment">

    <androidx.appcompat.widget.Toolbar
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:title="@string/order"
            app:titleTextColor="@color/white"
            android:background="@color/my_light_primary"/>


</FrameLayout>
```

### MineFragment

```java
package jz.cbq.android.complex_template.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jz.cbq.android.complex_template.R;


public class MineFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:tools="http://schemas.android.com/tools"
             android:layout_width="match_parent"
             android:layout_height="match_parent" xmlns:app="http://schemas.android.com/apk/res-auto"
             tools:context=".fragment.MineFragment">

    <androidx.appcompat.widget.Toolbar
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:title="@string/mine"
            app:titleTextColor="@color/white"
            android:background="@color/my_light_primary"/>


</FrameLayout>
```

# 二、登录 注册

## 2.1 使用 SharedPreferences (SP) 实现

```java
package jz.cbq.android.complex_template.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import jz.cbq.android.complex_template.MainActivity;
import jz.cbq.android.complex_template.R;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username, et_pwd;
    private SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        shared = getSharedPreferences("user", MODE_PRIVATE);

        et_username = findViewById(R.id.et_username);
        et_pwd = findViewById(R.id.et_pwd);

        TextView tx_register = findViewById(R.id.tx_register);
        Button btn_login = findViewById(R.id.btn_login);

        tx_register.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
        btn_login.setOnClickListener(this::validateForm);
    }

    /**
     * 校验登录表单
     * @param v view
     */
    private void validateForm(View v) {
        String username = et_username.getText().toString();
        String pwd = et_pwd.getText().toString();

        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
        } else {
            String shared_username = shared.getString("username", "");
            String shared_pwd = shared.getString("pwd", "");

            if (username.equals(shared_username) && pwd.equals(shared_pwd)) {
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            } else {
                Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.appcompat.widget.LinearLayoutCompat
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context=".activity.LoginActivity">

    <androidx.appcompat.widget.Toolbar
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:title="@string/app_name"
            android:background="@color/my_light_primary"
            app:subtitleTextColor="@color/white"/>

    <ImageView
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:scaleType="centerCrop"
            android:src="@mipmap/jinzhong_11"
            android:contentDescription="@string/JZ"/>

    <TextView
            android:layout_marginTop="15dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textStyle="bold"
            android:textSize="20sp"
            android:text="@string/login"
            android:textColor="@color/black"
            android:gravity="center"/>

    <androidx.appcompat.widget.LinearLayoutCompat
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:layout_margin="26dp">

        <androidx.appcompat.widget.LinearLayoutCompat
                android:layout_width="match_parent"
                android:background="@drawable/et_bg"
                android:paddingLeft="10dp"
                android:paddingRight="10dp"
                android:layout_height="50dp">

            <ImageView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center_vertical"
                    android:src="@drawable/baseline_supervisor_account_24"
                    android:contentDescription="@string/account"/>

            <EditText
                    android:id="@+id/et_username"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginStart="10dp"
                    android:hint="@string/input_username"
                    android:textSize="14sp"
                    android:background="@null" android:autofillHints="" android:inputType="textAutoComplete"/>


        </androidx.appcompat.widget.LinearLayoutCompat>

        <androidx.appcompat.widget.LinearLayoutCompat
                android:layout_marginTop="10dp"
                android:layout_width="match_parent"
                android:background="@drawable/et_bg"
                android:paddingLeft="10dp"
                android:paddingRight="10dp"
                android:layout_height="50dp">

            <ImageView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center_vertical"
                    android:src="@drawable/baseline_lock_24"
                    android:contentDescription="@string/pwd"/>

            <EditText
                    android:id="@+id/et_pwd"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginStart="10dp"
                    android:hint="@string/input_pwd"

                    android:textSize="14sp"
                    android:background="@null" android:autofillHints="" android:inputType="textPassword"/>


        </androidx.appcompat.widget.LinearLayoutCompat>

        <TextView
                android:id="@+id/tx_register"
                android:layout_marginTop="10dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="right"
                android:textColor="@color/my_light_primary"
                android:text="@string/does_not_register"/>

        <Button
                android:id="@+id/btn_login"
                android:layout_marginTop="20dp"
                android:layout_width="match_parent"
                android:text="@string/login"
                android:layout_height="50dp"/>


    </androidx.appcompat.widget.LinearLayoutCompat>

</androidx.appcompat.widget.LinearLayoutCompat>
```


```java
package jz.cbq.android.complex_template.activity;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import jz.cbq.android.complex_template.R;

public class RegisterActivity extends AppCompatActivity {


    private EditText et_username, et_pwd;
    private SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        shared = getSharedPreferences("user", MODE_PRIVATE);

        et_username = findViewById(R.id.et_username);
        et_pwd = findViewById(R.id.et_pwd);

        View back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());

        Button btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this::validateForm);
    }

    /**
     * 校验注册表单
     * @param v view
     */
    private void validateForm(View v) {
        String username = et_username.getText().toString();
        String pwd = et_pwd.getText().toString();

        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences.Editor editor = shared.edit();
            editor.putString("username", username);
            editor.putString("pwd", pwd);

            editor.apply();

            Toast.makeText(this, "注册成功请登录", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.appcompat.widget.LinearLayoutCompat
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent" xmlns:app="http://schemas.android.com/apk/res-auto"
        android:orientation="vertical"
        tools:context=".activity.RegisterActivity">

    <androidx.appcompat.widget.Toolbar
            android:id="@+id/back"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:title="@string/register"
            app:navigationIcon="@drawable/baseline_arrow_back_24"
            android:background="@color/my_light_primary"
            app:subtitleTextColor="@color/white"/>


    <ImageView
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:scaleType="centerCrop"
            android:src="@mipmap/jinzhong_11"
            android:contentDescription="@string/JZ"/>

    <TextView
            android:layout_marginTop="15dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textStyle="bold"
            android:textSize="20sp"
            android:text="@string/register"
            android:textColor="@color/black"
            android:gravity="center"/>

    <androidx.appcompat.widget.LinearLayoutCompat
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:layout_margin="26dp">

        <androidx.appcompat.widget.LinearLayoutCompat
                android:layout_width="match_parent"
                android:background="@drawable/et_bg"
                android:paddingLeft="10dp"
                android:paddingRight="10dp"
                android:layout_height="50dp">

            <ImageView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center_vertical"
                    android:src="@drawable/baseline_supervisor_account_24"
                    android:contentDescription="@string/account"/>

            <EditText
                    android:id="@+id/et_username"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginStart="10dp"
                    android:hint="@string/input_username"
                    android:textSize="14sp"
                    android:background="@null" android:autofillHints="" android:inputType="textAutoComplete"/>


        </androidx.appcompat.widget.LinearLayoutCompat>

        <androidx.appcompat.widget.LinearLayoutCompat
                android:layout_marginTop="10dp"
                android:layout_width="match_parent"
                android:background="@drawable/et_bg"
                android:paddingLeft="10dp"
                android:paddingRight="10dp"
                android:layout_height="50dp">

            <ImageView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center_vertical"
                    android:src="@drawable/baseline_lock_24"
                    android:contentDescription="@string/account"/>

            <EditText
                    android:id="@+id/et_pwd"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginStart="10dp"
                    android:hint="@string/input_pwd"
                    android:textSize="14sp"
                    android:background="@null" android:autofillHints="" android:inputType="textPassword"/>


        </androidx.appcompat.widget.LinearLayoutCompat>

        <Button
                android:id="@+id/btn_register"
                android:layout_marginTop="20dp"
                android:layout_width="match_parent"
                android:text="@string/register"
                android:layout_height="50dp"/>


    </androidx.appcompat.widget.LinearLayoutCompat>

</androidx.appcompat.widget.LinearLayoutCompat>
```

## 2.2 使用 SQLite 实现



# 三、Home 页面实现

## XML

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <solid android:color="@color/white"/>
    <corners android:radius="15dp"/>
    <stroke android:color="@color/my_light_primary" android:width="1dp"/>

</shape>
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">

    <item>

        <shape>
            <solid android:color="#f9f4dc"/>
        </shape>

    </item>

    <item android:top="10dp" android:bottom="10dp" android:right="96dp">

        <shape>
            <solid android:color="@color/my_light_primary"/>
        </shape>

    </item>

</layer-list>
```



```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">

    <item>

        <shape>
            <solid android:color="#f9f4dc"/>
        </shape>

    </item>

</layer-list>
```



```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:tools="http://schemas.android.com/tools"
             android:layout_width="match_parent"
             android:layout_height="match_parent"
             android:orientation="vertical"
             xmlns:app="http://schemas.android.com/apk/res-auto"
             tools:context=".fragment.HomeFragment">

    <androidx.appcompat.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:title="@string/home"
            app:titleTextColor="@color/white"
            android:background="@color/my_light_primary"/>

    <androidx.appcompat.widget.LinearLayoutCompat
            android:layout_marginTop="65dp"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

        <androidx.appcompat.widget.LinearLayoutCompat
                android:layout_width="100dp"
                android:layout_height="match_parent">

            <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/leftRecyclerView"
                    tools:listitem="@layout/left_list_item"
                    app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"/>


        </androidx.appcompat.widget.LinearLayoutCompat>

        <androidx.appcompat.widget.LinearLayoutCompat
                android:layout_width="match_parent"
                android:layout_height="match_parent">

            <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rightRecyclerView"
                    tools:listitem="@layout/right_list_item"
                    app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"/>

        </androidx.appcompat.widget.LinearLayoutCompat>


    </androidx.appcompat.widget.LinearLayoutCompat>


</FrameLayout>
```



```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.appcompat.widget.LinearLayoutCompat
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    <TextView
            android:id="@+id/name"
            android:paddingStart="10dp"
            android:layout_width="100dp"
            android:text="@string/left"
            android:gravity="center_vertical"
            android:layout_height="50dp"/>



</androidx.appcompat.widget.LinearLayoutCompat>
```



```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.appcompat.widget.LinearLayoutCompat
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    <androidx.appcompat.widget.LinearLayoutCompat
            android:layout_margin="10dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

        <ImageView
                android:id="@+id/iv_img"
                android:src="@drawable/avatar"
                android:scaleType="centerCrop"
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:contentDescription="@string/picture"/>

        <androidx.appcompat.widget.LinearLayoutCompat
                android:layout_width="match_parent"
                android:layout_marginStart="10dp"
                android:orientation="vertical"
                android:layout_height="match_parent">

            <TextView
                    android:id="@+id/tx_title"
                    android:layout_width="wrap_content"
                    android:text="@string/title"
                    android:singleLine="true"
                    android:textColor="#333"
                    android:textStyle="bold"
                    android:layout_height="wrap_content"/>

            <TextView
                    android:id="@+id/tx_description"
                    android:layout_width="match_parent"
                    android:text="@string/description"
                    android:maxLines="1"
                    android:textSize="12sp"
                    android:layout_height="wrap_content"/>

            <androidx.appcompat.widget.LinearLayoutCompat
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content">

                <ImageView
                        android:src="@drawable/baseline_currency_yen_24"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_gravity="bottom"
                        android:layout_marginBottom="4dp"
                        android:contentDescription="@string/money"/>

                <TextView
                        android:id="@+id/tx_price"
                        android:layout_width="wrap_content"
                        android:textSize="20sp"
                        android:text="100"
                        android:textStyle="bold"
                        android:textColor="@color/my_light_primary"
                        android:layout_height="wrap_content" tools:ignore="HardcodedText"/>

            </androidx.appcompat.widget.LinearLayoutCompat>


        </androidx.appcompat.widget.LinearLayoutCompat>



    </androidx.appcompat.widget.LinearLayoutCompat>

</androidx.appcompat.widget.LinearLayoutCompat>
```

## Java

```java
package jz.cbq.android.complex_template.adapter.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jz.cbq.android.complex_template.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * LeftAdapter
 *
 * @author Cola777jz
 * @date 2023/11/6 22:54
 * @since 1.0.0
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.Holder> {

    private final List<String> dataList;
    private int currentIndex = 0;
    private LeftListOnClickItemListener leftListOnClickItemListener;

    public LeftAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    public void setLeftListOnClickItemListener(LeftListOnClickItemListener leftListOnClickItemListener) {
        this.leftListOnClickItemListener = leftListOnClickItemListener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_list_item, null);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Holder holder, int position) {
        holder.tv_name.setText(dataList.get(position));

        holder.itemView.setOnClickListener(v -> {
            if (leftListOnClickItemListener != null) {
                leftListOnClickItemListener.onItemClick(position);
            }
        });

        if (currentIndex == position){
            holder.itemView.setBackgroundResource(R.drawable.type_selector_bg);
        }else {
            holder.itemView.setBackgroundResource(R.drawable.type_selector_normal_bg);
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView tv_name;

        public Holder(@NonNull @NotNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.name);
        }
    }


    public interface LeftListOnClickItemListener {
        void onItemClick(int position);
    }

}

```



```java
package jz.cbq.android.complex_template.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.adapter.home.LeftAdapter;
import jz.cbq.android.complex_template.adapter.home.RightAdapter;
import jz.cbq.android.complex_template.entity.DataService;
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

        rightAdapter = new RightAdapter();
        rightAdapter.setDataList(DataService.getListData(0));
        right.setAdapter(rightAdapter);

        leftAdapter.setLeftListOnClickItemListener(position -> {
            leftAdapter.setCurrentIndex(position);

            rightAdapter.setDataList(DataService.getListData(position));
        });


    }
}
```



```java
package jz.cbq.android.complex_template.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProductInfo
 *
 * @author Cola777jz
 * @date 2023/11/6 23:50
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {
    private int id;
    private int img;
    private String title;
    private String description;
    private int price;
}

```



```java
package jz.cbq.android.complex_template.entity;

import jz.cbq.android.complex_template.R;

import java.util.ArrayList;
import java.util.List;

/**
 * DataService
 *
 * @author Cola777jz
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

```



