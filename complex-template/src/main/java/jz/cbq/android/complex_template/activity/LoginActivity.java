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