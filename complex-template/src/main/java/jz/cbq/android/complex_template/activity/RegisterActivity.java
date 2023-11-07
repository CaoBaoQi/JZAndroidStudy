package jz.cbq.android.complex_template.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import jz.cbq.android.complex_template.R;
import jz.cbq.android.complex_template.db.UserDbHelper;

/**
 * 注册
 *
 * @author CBQ
 * @date 2023/11/6 22:54
 * @since 1.0.0
 */
public class RegisterActivity extends AppCompatActivity {


    private EditText et_username, et_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        et_username = findViewById(R.id.register_activity_et_username);
        et_pwd = findViewById(R.id.register_activity_et_pwd);

        View back = findViewById(R.id.register_activity_toolbar);
        back.setOnClickListener(v -> finish());

        Button btn_register = findViewById(R.id.register_activity_btn_register);

        btn_register.setOnClickListener(this::validateForm);
    }

    /**
     * 校验注册表单
     *
     * @param v view
     */
    private void validateForm(View v) {
        String username = et_username.getText().toString();
        String pwd = et_pwd.getText().toString();

        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
        } else {

            int count = UserDbHelper.getInstance(RegisterActivity.this).register(username, pwd, "TODO");

            if (count > 0) {
                Toast.makeText(this, "注册成功请登录", Toast.LENGTH_SHORT).show();
                finish();
            }



        }
    }
}