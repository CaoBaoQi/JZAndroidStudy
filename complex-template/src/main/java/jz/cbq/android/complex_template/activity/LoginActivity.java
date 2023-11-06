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