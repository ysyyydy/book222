package myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import com.logIn.R;

public class Classify_4 extends Activity {
    ListView list4;
    //
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classify_4);
        list4 = (ListView)findViewById(R.id.bookList);
        String[] data={
                "斗罗大陆1" ,
                "斗罗大陆2" ,
                "斗罗大陆3" ,
                "斗罗大陆4" ,
                "斗罗大陆5" ,
                "斗罗大陆6" ,
        };
        list4.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,data));
        //list.setOnClickListener(new mItemClick());
    }
    public void onImageButtonClick4(View view) {
        Intent intent = new Intent(this, FragmentAA.class);
        startActivity(intent);
    }
}
