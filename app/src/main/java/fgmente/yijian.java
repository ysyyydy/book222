package fgmente;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.logIn.R;

public class yijian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yijain);

        Button buttontj = findViewById(R.id.buttontj);
        buttontj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yijian.this, tijiao.class);
                startActivity(intent);
            }
        });
    }
}
