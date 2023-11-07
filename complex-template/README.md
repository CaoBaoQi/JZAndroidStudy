# Complex-Template

> 安卓项目模板搭建 

## Features

- [x] 底部导航栏 （主页、购物车、订单、我的）
- [x] SQLite + SP （登录、注册、记住我）

## Version

| 工具   | 版本     |
| ------ | -------- |
| IDEA   | 2023.2.+ |
| JDK    | 17       |
| Gradle | 8.x      |
| API    | 30 (R)   |

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

```java
package jz.cbq.android.complex_template.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import jz.cbq.android.complex_template.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * user DB 数据库
 *
 * @author CBQ
 * @date 2023/11/7 13:53
 * @since 1.0.0
 */
public class UserDbHelper extends SQLiteOpenHelper {
    private static UserDbHelper sHelper;
    /**
     * 数据库名
     */
    private static final String DB_NAME = "user.db";
    /**
     * 版本号
     */
    private static final int VERSION = 1;

    public UserDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 创建单例，供使用调用该类里面的的增删改查的方法
     *
     * @param context context
     * @return UserDbHelper
     */
    public synchronized static UserDbHelper getInstance(Context context) {
        if (null == sHelper) {
            sHelper = new UserDbHelper(context, DB_NAME, null, VERSION);
        }
        return sHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建 user_table 表
        db.execSQL("create table user_table(user_id integer primary key autoincrement, " +
                "username text," +
                "password text," +
                "nickname text" +
                ")");
        db.execSQL("insert into user_table values(null,'cbq','cb','TODO')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * 注册
     *
     * @param username username
     * @param password password
     * @return count
     */
    public int register(String username, String password, String nickname) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);
        values.put("nickname", nickname);
        String nullColumnHack = "values(null,?,?,?)";

        int insert = (int) db.insert("user_table", nullColumnHack, values);
        db.close();
        return insert;
    }

    /**
     * 登录  根据用户名查找用户
     */
    @SuppressLint("Range")
    public UserInfo login(String username) {
        SQLiteDatabase db = getReadableDatabase();
        UserInfo userInfo = null;
        String sql = "select user_id,username,password,nickname  from user_table where username=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()) {
            int user_id = cursor.getInt(cursor.getColumnIndex("user_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String nickname = cursor.getString(cursor.getColumnIndex("nickname"));
            userInfo = new UserInfo(user_id, name, password, nickname);
        }
        cursor.close();
        db.close();
        return userInfo;
    }

    /**
     * 获取所有注册用户
     */
    @SuppressLint("Range")
    public List<UserInfo> queryRegisterListData() {
        SQLiteDatabase db = getReadableDatabase();
        List<UserInfo> list = new ArrayList<>();
        String sql = "select _id,username,password,register_type  from user_table";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int user_id = cursor.getInt(cursor.getColumnIndex("user_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String nickname = cursor.getString(cursor.getColumnIndex("nickname"));
            list.add(new UserInfo(user_id, name, password, nickname));
        }
        cursor.close();
        db.close();
        return list;
    }

    /**
     * 根据用户唯一 user_id 来修改密码
     */
    public int updatePwd(int user_id, String password) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("password", password);

        int update = db.update("user_table", values, " user_id=?", new String[]{user_id + ""});

        db.close();
        return update;

    }

    /**
     * 根据用户 唯一 user_id 删除用户
     */
    public int delete(String user_id) {
        SQLiteDatabase db = getWritableDatabase();
        int delete = db.delete("user_table", " user_id=?", new String[]{user_id});
        db.close();
        return delete;
    }

}

```

```java
package jz.cbq.android.complex_template.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import jz.cbq.android.complex_template.MainActivity;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.db.UserDbHelper;
import jz.cbq.android.complex_template.entity.UserInfo;

/**
 * 登录
 *
 * @author CBQ
 * @date 2023/11/6 22:54
 * @since 1.0.0
 */
public class LoginActivity extends AppCompatActivity {

    private EditText et_username, et_pwd;
    private SharedPreferences shared;
    private boolean is_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        shared = getSharedPreferences("user", MODE_PRIVATE);
        CheckBox cb_save_pwd = findViewById(R.id.login_activity_cb_save_pwd);

        et_username = findViewById(R.id.login_activity_et_username);
        et_pwd = findViewById(R.id.login_activity_et_pwd);

        TextView tx_register = findViewById(R.id.login_activity_tx_register);
        Button btn_login = findViewById(R.id.login_activity_btn_login);

        is_login = shared.getBoolean("is_login", false);

        if (is_login) {
            String username = shared.getString("username", "cbq");
            String pwd = shared.getString("pwd", "cb");
            et_username.setText(username);
            et_pwd.setText(pwd);
            cb_save_pwd.setChecked(true);
        }

        tx_register.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
        btn_login.setOnClickListener(this::validateForm);
        cb_save_pwd.setOnCheckedChangeListener((buttonView, isChecked) -> is_login = isChecked);
    }

    /**
     * 校验登录表单
     *
     * @param v view
     */
    private void validateForm(View v) {
        String username = et_username.getText().toString();
        String pwd = et_pwd.getText().toString();

        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
        } else {
            UserInfo userInfo = UserDbHelper.getInstance(LoginActivity.this).login(username);
            if (!(userInfo == null)) {
                if (username.equals(userInfo.getUsername()) && pwd.equals(userInfo.getPassword())) {

                    SharedPreferences.Editor editor = shared.edit();
                    editor.putBoolean("is_login", is_login);
                    editor.putString("username", username);
                    editor.putString("pwd", pwd);
                    editor.apply();

                    UserInfo.setCurrentUserInfo(userInfo);

                    Toast.makeText(this, "登录成功,欢迎您 " + username, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "未注册", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
```

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

# 四、Car 页面实现

## XML

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent" xmlns:app="http://schemas.android.com/apk/res-auto"
                tools:context=".fragment.CarFragment">

    <androidx.appcompat.widget.LinearLayoutCompat
            android:layout_width="match_parent"
            android:layout_above="@id/car_fragment_bottom"
            android:orientation="vertical"
            android:layout_height="match_parent">
        <androidx.appcompat.widget.Toolbar
                android:id="@+id/car_fragment_toolbar"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:title="@string/car"
                app:titleTextColor="@color/white"
                android:background="@color/my_light_primary"/>


        <androidx.recyclerview.widget.RecyclerView
                android:id="@+id/car_fragment_recyclerView"
                android:layout_width="match_parent"
                tools:listitem="@layout/car_list_item"
                app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
                android:layout_height="wrap_content"/>


    </androidx.appcompat.widget.LinearLayoutCompat>

    <androidx.appcompat.widget.LinearLayoutCompat
            android:id="@+id/car_fragment_bottom"
            android:gravity="right"
            android:layout_alignParentBottom="true"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

        <androidx.appcompat.widget.LinearLayoutCompat
                android:gravity="center_vertical"
                android:layout_margin="15dp"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content">
            <TextView
                    android:id="@+id/car_fragment_tx_total"
                    android:text="@string/total"
                    android:textSize="26sp"
                    android:textStyle="bold"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"/>
            <androidx.appcompat.widget.LinearLayoutCompat
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content">

                <androidx.appcompat.widget.LinearLayoutCompat
                        android:layout_width="wrap_content"
                        android:layout_gravity="center_vertical"
                        android:layout_height="wrap_content">
                    <ImageView
                            android:layout_marginBottom="4dp"
                            android:src="@drawable/baseline_currency_yen_24"
                            android:layout_gravity="bottom"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content" tools:ignore="ContentDescription"/>
                    <TextView
                            android:textSize="20sp"
                            android:textStyle="bold"
                            android:textColor="@color/my_light_primary"
                            android:text="@string/money"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"/>
                </androidx.appcompat.widget.LinearLayoutCompat>

                <Button
                        android:id="@+id/car_fragment_btn_buy"
                        android:layout_marginLeft="10dp"
                        android:text="@string/buy"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"/>

            </androidx.appcompat.widget.LinearLayoutCompat>
        </androidx.appcompat.widget.LinearLayoutCompat>


    </androidx.appcompat.widget.LinearLayoutCompat>


</RelativeLayout>
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.appcompat.widget.LinearLayoutCompat xmlns:android="http://schemas.android.com/apk/res/android"
                                              xmlns:tools="http://schemas.android.com/tools"
                                              android:layout_width="match_parent"
                                              android:layout_height="wrap_content">

    <androidx.appcompat.widget.LinearLayoutCompat
            android:layout_margin="10dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

        <ImageView
                android:id="@+id/car_list_item_iv_01"
                android:src="@drawable/avatar"
                android:scaleType="centerCrop"
                android:layout_width="90dp"
                android:layout_height="90dp" tools:ignore="ContentDescription"/>

        <androidx.appcompat.widget.LinearLayoutCompat
                android:layout_marginLeft="10dp"
                android:orientation="vertical"
                android:layout_width="match_parent"
                android:layout_height="wrap_content">

            <TextView
                    android:id="@+id/car_list_item_tv_title"
                    android:maxLines="2"
                    android:textColor="#333"
                    android:text="@string/cbq"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"/>

            <androidx.appcompat.widget.LinearLayoutCompat
                    android:layout_width="wrap_content"
                    android:layout_marginTop="10dp"
                    android:layout_height="wrap_content">

                <ImageView
                        android:src="@drawable/baseline_currency_yen_24"
                        android:layout_gravity="bottom"
                        android:layout_marginBottom="4dp"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content" tools:ignore="ContentDescription"/>
                <TextView
                        android:id="@+id/car_list_item_tv_price"
                        android:text="@string/money"
                        android:textColor="@color/my_light_primary"
                        android:textSize="20sp"
                        android:textStyle="bold"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"/>

            </androidx.appcompat.widget.LinearLayoutCompat>

            <androidx.appcompat.widget.LinearLayoutCompat
                    android:layout_gravity="right"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content">

                <TextView
                        android:id="@+id/car_list_item_tv_sub"
                        android:background="#c9c9c9"
                        android:gravity="center"
                        android:text="@string/sub"
                        android:textColor="@color/white"
                        android:layout_width="20dp"
                        android:layout_height="20dp"/>

                <TextView
                        android:id="@+id/car_list_item_tv_count"
                        android:layout_width="wrap_content"
                        android:text="@string/num"
                        android:layout_marginStart="10dp"
                        android:layout_height="wrap_content"/>

                <TextView
                        android:id="@+id/car_list_item_tv_add"
                        android:background="@color/my_light_primary"
                        android:gravity="center"
                        android:text="@string/add"
                        android:textColor="@color/white"
                        android:layout_width="20dp"
                        android:layout_height="20dp"/>

            </androidx.appcompat.widget.LinearLayoutCompat>

        </androidx.appcompat.widget.LinearLayoutCompat>

    </androidx.appcompat.widget.LinearLayoutCompat>

</androidx.appcompat.widget.LinearLayoutCompat>
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".activity.ProductDetailsActivity">

    <androidx.appcompat.widget.LinearLayoutCompat
            android:layout_width="match_parent"
            android:orientation="vertical"
            android:layout_height="wrap_content">

        <androidx.appcompat.widget.Toolbar
                android:id="@+id/product_details_activity_toolbar"
                android:layout_width="match_parent"
                app:title="@string/product_details"
                app:titleTextColor="@color/white"
                android:background="@color/my_light_primary"
                app:navigationIcon="@drawable/baseline_arrow_back_24"
                android:layout_height="wrap_content"/>

        <ImageView
                android:id="@+id/product_details_activity_iv_img"
                android:src="@drawable/avatar"
                android:scaleType="centerCrop"
                android:layout_width="match_parent"
                android:layout_height="240dp"
                tools:ignore="ContentDescription"/>

        <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="10dp"
                android:orientation="vertical">


            <LinearLayout
                    android:layout_width="wrap_content"
                    android:orientation="horizontal"
                    android:layout_height="wrap_content" tools:ignore="UseCompoundDrawables,UselessParent">

                <ImageView
                        android:src="@drawable/baseline_currency_yen_24"
                        android:layout_marginBottom="4dp"
                        android:layout_gravity="bottom"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content" android:contentDescription="@string/money"/>

                <TextView
                        android:id="@+id/product_details_activity_tv_price"
                        android:text="198"
                        android:textColor="@color/my_light_primary"
                        android:textSize="24sp"
                        android:textStyle="bold"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content" tools:ignore="HardcodedText"/>
            </LinearLayout>

            <TextView
                    android:id="@+id/product_details_activity_tv_title"
                    android:layout_marginTop="10dp"
                    android:textStyle="bold"
                    android:textSize="36sp"
                    android:text="@string/cbq"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"/>

            <TextView
                    android:id="@+id/product_details_activity_tv_description"
                    android:layout_marginTop="10dp"
                    android:textColor="#999999"
                    android:lineSpacingExtra="6dp"
                    android:text="@string/i_am_cbq_1"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"/>

        </LinearLayout>

    </androidx.appcompat.widget.LinearLayoutCompat>

    <Button
            android:id="@+id/product_details_activity_buy_car"
            android:layout_width="wrap_content"
            android:layout_alignParentEnd="true"
            android:layout_alignParentBottom="true"
            android:layout_margin="20dp"
            android:text="@string/buy_car"
            android:layout_height="wrap_content"/>

</RelativeLayout>
```

## Java

```java
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
                        .setNegativeButton("取消", (dialog, which) -> {
                            Toast.makeText(getActivity(), "取消删除", Toast.LENGTH_SHORT).show();
                        }).create().show();

            }
        });

        btn_buy.setOnClickListener(v -> {
            UserInfo userInfo = UserInfo.getCurrentUserInfo();

            if (userInfo != null) {
                List<CarInfo> carInfoList = CarDbHelper.getInstance(getActivity()).findAll(userInfo.getUsername());
                OrderDbHelper.getInstance(getActivity()).insertByAll(carInfoList, "文华街 199 号", "19510201902");

                carInfoList.forEach(carInfo -> CarDbHelper.getInstance(getActivity()).delete(carInfo.getCar_id() + ""));
            }
            loadData();

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
```



```java
package jz.cbq.android.complex_template.activity;

import android.annotation.SuppressLint;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.db.CarDbHelper;
import jz.cbq.android.complex_template.entity.ProductInfo;
import jz.cbq.android.complex_template.entity.UserInfo;


/**
 * 商品详情
 *
 * @author CBQ
 * @date 2023/11/6 22:54
 * @since 1.0.0
 */
public class ProductDetailsActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ProductInfo productInfo = (ProductInfo) getIntent().getSerializableExtra("productInfo");

        findViewById(R.id.product_details_activity_toolbar).setOnClickListener(v -> finish());


        ImageView iv_img = findViewById(R.id.product_details_activity_iv_img);
        TextView tx_title = findViewById(R.id.product_details_activity_tv_title);
        TextView tx_description = findViewById(R.id.product_details_activity_tv_description);
        TextView tx_price = findViewById(R.id.product_details_activity_tv_price);


        if (productInfo != null) {
            iv_img.setImageResource(productInfo.getImg());
            tx_title.setText(productInfo.getTitle());
            tx_description.setText(productInfo.getDescription());
            tx_price.setText(productInfo.getPrice() + " ");
        }

        findViewById(R.id.product_details_activity_buy_car).setOnClickListener(v -> {
            UserInfo userInfo = UserInfo.getCurrentUserInfo();

            if (userInfo != null) {
                int count = CarDbHelper.getInstance(ProductDetailsActivity.this)
                        .addCar(userInfo.getUsername(), productInfo.getId(), productInfo.getImg(), productInfo.getTitle(), productInfo.getDescription(), productInfo.getPrice());

                if (count > 0) {
                    Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
                }
            }


        });

    }
}
```

```java
package jz.cbq.android.complex_template.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import jz.cbq.android.complex_template.entity.CarInfo;
import jz.cbq.android.complex_template.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * car DB 数据库
 *
 * @author CBQ
 * @date 2023/11/7 16:05
 * @since 1.0.0
 */
public class CarDbHelper extends SQLiteOpenHelper {
    private static CarDbHelper sHelper;
    /**
     * 数据库名
     */
    private static final String DB_NAME = "car.db";
    /**
     * 版本号
     */
    private static final int VERSION = 1;

    public CarDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 创建单例，供使用调用该类里面的的增删改查的方法
     *
     * @param context context
     * @return UserDbHelper
     */
    public synchronized static CarDbHelper getInstance(Context context) {
        if (null == sHelper) {
            sHelper = new CarDbHelper(context, DB_NAME, null, VERSION);
        }
        return sHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建 car_table 表
        db.execSQL("create table car_table(car_id integer primary key autoincrement, " +
                "username text," +
                "product_id integer," +
                "product_img integer," +
                "product_title text," +
                "product_description text," +
                "product_price integer," +
                "product_count integer" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * 添加购物车
     *
     * @param username            username
     * @param product_id          商品 id
     * @param product_img         商品 img
     * @param product_title       商品 title
     * @param product_description 商品 description
     * @param product_price       商品 price
     * @return count
     */
    public int addCar(String username, Integer product_id, Integer product_img, String product_title, String product_description, Integer product_price) {
        CarInfo carInfo = loadCarInfoByUsernameAndProductId(username, product_id);

        if (carInfo == null) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put("username", username);
            values.put("product_id", product_id);
            values.put("product_img", product_img);
            values.put("product_title", product_title);
            values.put("product_description", product_description);
            values.put("product_price", product_price);
            values.put("product_count", 1);
            String nullColumnHack = "values(null,?,?,?,?,?,?,?)";

            int insert = (int) db.insert("car_table", nullColumnHack, values);
            db.close();
            return insert;
        } else {
            return updateProduct(carInfo.getCar_id(), carInfo);
        }


    }

    /**
     * 根据用户名查找购物信息
     */
    @SuppressLint("Range")
    public CarInfo findCarByUsername(String username) {
        SQLiteDatabase db = getReadableDatabase();
        CarInfo carInfo = null;
        String sql = "select car_id,username,product_id,product_img,product_title,product_description,product_price" +
                "  from car_table where username=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()) {
            int car_id = cursor.getInt(cursor.getColumnIndex("car_id"));
            int product_id = cursor.getInt(cursor.getColumnIndex("product_id"));
            int product_img = cursor.getInt(cursor.getColumnIndex("product_img"));
            String product_title = cursor.getString(cursor.getColumnIndex("product_title"));
            String product_description = cursor.getString(cursor.getColumnIndex("product_description"));
            int product_price = cursor.getInt(cursor.getColumnIndex("product_price"));
            int product_count = cursor.getInt(cursor.getColumnIndex("product_count"));
            carInfo = new CarInfo(car_id, username, product_id, product_img, product_title, product_description, product_price, product_count);
        }
        cursor.close();
        db.close();
        return carInfo;
    }

    /**
     * 根据 id 修改购物车商品数量
     */
    public int updateProduct(int car_id, CarInfo carInfo) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("product_count", carInfo.getProduct_count() + 1);

        int update = db.update("car_table", values, " car_id=?", new String[]{car_id + ""});

        db.close();
        return update;

    }

    /**
     * 根据 id 修改购物车商品数量
     */
    public int updateProductSub(int car_id, CarInfo carInfo) {

        if (carInfo.getProduct_count() >= 2) {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("product_count", carInfo.getProduct_count() - 1);

            int update = db.update("car_table", values, " car_id=?", new String[]{car_id + ""});

            db.close();
            return update;
        }
        return 0;
    }

    /**
     * 根据用户名查找购物信息
     */
    @SuppressLint("Range")
    public CarInfo loadCarInfoByUsernameAndProductId(String username, Integer product_id) {
        SQLiteDatabase db = getReadableDatabase();
        CarInfo carInfo = null;
        String sql = "select car_id,username,product_id,product_img,product_title,product_description,product_price,product_count from car_table where username=? and product_id = ?";
        String[] selectionArgs = {username, String.valueOf(product_id)};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()) {
            int car_id = cursor.getInt(cursor.getColumnIndex("car_id"));
            int product_img = cursor.getInt(cursor.getColumnIndex("product_img"));
            String product_title = cursor.getString(cursor.getColumnIndex("product_title"));
            String product_description = cursor.getString(cursor.getColumnIndex("product_description"));
            int product_price = cursor.getInt(cursor.getColumnIndex("product_price"));
            int product_count = cursor.getInt(cursor.getColumnIndex("product_count"));
            carInfo = new CarInfo(car_id, username, product_id, product_img, product_title, product_description, product_price, product_count);
        }
        cursor.close();
        db.close();
        return carInfo;
    }

    /**
     * 获取所有信息
     */
    @SuppressLint("Range")
    public List<CarInfo> findAll(String username) {
        SQLiteDatabase db = getReadableDatabase();
        List<CarInfo> list = new ArrayList<>();
        String sql = "select car_id,username,product_id,product_img,product_title,product_description,product_price,product_count  from car_table where username = ?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            int car_id = cursor.getInt(cursor.getColumnIndex("car_id"));
            int product_id = cursor.getInt(cursor.getColumnIndex("product_id"));
            int product_img = cursor.getInt(cursor.getColumnIndex("product_img"));
            String product_title = cursor.getString(cursor.getColumnIndex("product_title"));
            String product_description = cursor.getString(cursor.getColumnIndex("product_description"));
            int product_price = cursor.getInt(cursor.getColumnIndex("product_price"));
            int product_count = cursor.getInt(cursor.getColumnIndex("product_count"));
            list.add(new CarInfo(car_id, username, product_id, product_img, product_title, product_description, product_price, product_count));
        }
        cursor.close();
        db.close();
        return list;
    }

    /**
     * 根据 car_id 删除
     */
    public int delete(String car_id) {
        SQLiteDatabase db = getWritableDatabase();
        int delete = db.delete("car_table", " car_id=?", new String[]{car_id});
        db.close();
        return delete;
    }


}

```





# 五、Order 页面实现

## XML

```xml
```

## Java

```java
package jz.cbq.android.complex_template.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import jz.cbq.android.complex_template.entity.CarInfo;

import java.util.List;


/**
 * OrderDbHelper
 *
 * @author CBQ
 * @date 2023/11/7 21:56
 * @since 1.0.0
 */
public class OrderDbHelper extends SQLiteOpenHelper {
    private static OrderDbHelper sHelper;
    /**
     * 数据库名
     */
    private static final String DB_NAME = "order.db";
    /**
     * 版本号
     */
    private static final int VERSION = 1;

    public OrderDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 创建单例，供使用调用该类里面的的增删改查的方法
     *
     * @param context context
     * @return UserDbHelper
     */
    public synchronized static OrderDbHelper getInstance(Context context) {
        if (null == sHelper) {
            sHelper = new OrderDbHelper(context, DB_NAME, null, VERSION);
        }
        return sHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建 order_table 表
        db.execSQL("create table order_table(order_id integer primary key autoincrement, " +
                "username text," +
                "product_img integer," +
                "product_title text," +
                "product_price integer," +
                "product_count integer," +
                "address text," +
                "mobile text" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * 批量插入
     * @param list list
     * @param address address
     * @param mobile mobile
     */
    public void insertByAll(List<CarInfo> list, String address, String mobile) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            for (int i = 0; i < list.size(); i++) {
                ContentValues values = new ContentValues();
                values.put("username", list.get(i).getUsername());
                values.put("product_img", list.get(i).getProduct_img());
                values.put("product_title", list.get(i).getProduct_title());
                values.put("product_price", list.get(i).getProduct_price());
                values.put("product_count", list.get(i).getProduct_count());
                values.put("address", address);
                values.put("mobile", mobile);
                db.insert("order_table", null, values);

            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        db.close();

    }

}

```



