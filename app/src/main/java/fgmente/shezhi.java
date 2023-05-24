
package fgmente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.logIn.MainActivity;
import com.logIn.R;

public class shezhi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liangdu);

        Button buttonfanhuiBtn = findViewById(R.id.buttonfanhui);
        buttonfanhuiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shezhi.this, MainActivity.class);
                startActivity(intent);
            }
        });
        SeekBar brightness_seekbar = findViewById(R.id.brightness_seekbar);
        brightness_seekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shezhi.this, liangdu.class);
                startActivity(intent);
            }
        });
        Button buttonYJ = findViewById(R.id.buttonYJ);
        buttonYJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shezhi.this, yijian.class);
                startActivity(intent);
            }
        });
    }

}








