package fragmentD;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.logIn.R;

public class button10 extends Activity {
    Button shubutton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.button10);

        shubutton=findViewById(R.id.shubutton);
        shubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(button10.this, shu1.class);
                startActivity(intent);
            }
        });
    }
}
