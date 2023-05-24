package fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import com.logIn.R;
import myapplication.FragmentAA;

public class button2 extends Activity {
    Button soucangbutton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.button2);

        soucangbutton=findViewById(R.id.soucangbutton);
        soucangbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(button2.this, FragmentAA.class);
                        startActivity(intent);
                    }
                });
    }
}