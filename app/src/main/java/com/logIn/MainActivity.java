package com.logIn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import data.DatabaseHelper;


public class MainActivity extends Activity {
    // 调用Actvity
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 关联activity.xml
        setContentView(R.layout.activity_main);
        // 关联用户名、密码和登录、注册按钮
        EditText userName = (EditText) this.findViewById(R.id.UserNameEdit);
        EditText passWord = (EditText) this.findViewById(R.id.PassWordEdit);
        Button loginButton = (Button) this.findViewById(R.id.LoginButton);
        Button signUpButton = (Button) this.findViewById(R.id.SignUpButton);

        databaseHelper = new DatabaseHelper(this);

        // 登录按钮监听器
        loginButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 获取用户名和密码
                        String strUserName = userName.getText().toString().trim();
                        String strPassWord = passWord.getText().toString().trim();

                        boolean loginSuccess = databaseHelper.login(strUserName, strPassWord);
                        // 判断如果用户名为"123456"密码为"123456"则登录成功
                        if (loginSuccess) {
                            Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, main.EnterActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "请输入正确的用户名或密码！", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
        // 注册按钮监听器
        signUpButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 跳转到注册界面
                        Intent intent = new Intent(MainActivity.this, com.logUp.SignUpActivity.class);
                        startActivity(intent);
                    }
                }
        );
        // 检查是否有传递的额外数据
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // 从Bundle中获取文本字段内容
            String text = extras.getString("text");

            // 将文本字段内容设置到userName的EditText中
            userName.setText(text);
        }

    }


}





