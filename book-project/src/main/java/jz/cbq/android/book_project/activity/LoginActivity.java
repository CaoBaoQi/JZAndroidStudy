package jz.cbq.android.book_project.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import jz.cbq.android.book_project.MainActivity;
import jz.cbq.android.book_project.R;

public class LoginActivity extends AppCompatActivity {
    private TextView register;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.login_activity_tx_register);
        login = findViewById(R.id.login_activity_btn_login);

        register.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
        login.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, MainActivity.class)));

    }
}