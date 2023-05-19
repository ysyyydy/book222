package com.logUp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.logIn.MainActivity;
import com.logIn.R;

public class SignUpActivity extends Activity {
    // 调用Actvity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //关联activity_register.xml
        setContentView(R.layout.activity_sign_up);

        // 关联用户名、密码、确认密码、邮箱和注册、返回登录按钮
        EditText userName = (EditText) this.findViewById(R.id.UserNameEdit);
        EditText passWord = (EditText) this.findViewById(R.id.PassWordEdit);
        Button signUpButton = (Button) this.findViewById(R.id.SignUpButton);
        Button backLoginButton = (Button) this.findViewById(R.id.BackLoginButton);

        // 立即注册按钮监听器
 /*       signUpButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String strUserName = userName.getText().toString().trim();
                        String strPassWord = passWord.getText().toString().trim();
                        //注册格式粗检
                        if (strUserName.length() > 10) {
                            Toast.makeText(SignUpActivity.this, "用户名长度必须小于10！", Toast.LENGTH_SHORT).show();
                        } else if (strUserName.length() < 4) {
                            Toast.makeText(SignUpActivity.this, "用户名长度必须大于4！", Toast.LENGTH_SHORT).show();
                        } else if (strPassWord.length() > 16) {
                            Toast.makeText(SignUpActivity.this, "密码长度必须小于16！", Toast.LENGTH_SHORT).show();
                        } else if (strPassWord.length() < 6) {
                            Toast.makeText(SignUpActivity.this, "密码长度必须大于6！", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUpActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                            // 跳转到登录界面

                            Intent intent = getIntent();
                           *//* String stringExtra = intent.getStringExtra(userName, passWord);*//*
                        }
                    }
                }
        );*/

        // 立即注册按钮监听器
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUserName = userName.getText().toString().trim();
                String strPassWord = passWord.getText().toString().trim();
                // 注册格式粗检
                if (strUserName.length() > 10) {
                    Toast.makeText(SignUpActivity.this, "用户名长度必须小于10！", Toast.LENGTH_SHORT).show();
                } else if (strUserName.length() < 4) {
                    Toast.makeText(SignUpActivity.this, "用户名长度必须大于4！", Toast.LENGTH_SHORT).show();
                } else if (strPassWord.length() > 16) {
                    Toast.makeText(SignUpActivity.this, "密码长度必须小于16！", Toast.LENGTH_SHORT).show();
                } else if (strPassWord.length() < 6) {
                    Toast.makeText(SignUpActivity.this, "密码长度必须大于6！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();

                    // 创建一个新的Intent对象，将目标活动设置为MainActivity
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);

                    // 创建一个Bundle对象，并将文本字段内容放入Bundle中
                    Bundle bundle = new Bundle();
                    bundle.putString("text", strUserName); // 这里将用户名作为文本字段内容

                    // 将Bundle附加到Intent上
                    intent.putExtras(bundle);

                    // 启动MainActivity，并传递包含文本字段内容的Bundle
                    startActivity(intent);
                }
            }
        });



        // 返回登录按钮监听器
       backLoginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 跳转到登录界面
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
/*        Button btn;
        btn = (Button) findViewById(R.id.SignUpButton);
        btn.setOnClickListener(new btnclock());*/

    }
    /*class btnclock implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(SignUpActivity.this,MainActivity.class);
            EditText txt =(EditText)findViewById(R.id.UserNameEdit);
            Bundle bundle = new Bundle();
            bundle.putString("text", txt.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }*/
}

