package fragmentD;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.logIn.R;

public class button11 extends Activity {
    Button shuu1button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.button10);

        shuu1button=findViewById(R.id.shubutton);
        shuu1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(button11.this, shu.class);
                startActivity(intent);
            }
        });
    }
}