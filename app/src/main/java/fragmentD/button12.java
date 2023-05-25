package fragmentD;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.logIn.R;

public class button12 extends Activity {

    Button button17;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.button12);

       button17=findViewById(R.id.button17);
       button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(button12.this, fukuan.class);
                startActivity(intent);
            }
        });
    }
}