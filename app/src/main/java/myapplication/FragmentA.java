package myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.logIn.R;

public class FragmentA extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        Button downloadButton = view.findViewById(R.id.ButtonAA);
        Button historyButton = view.findViewById(R.id.ButtonBB);
        Button historyButton1 = view.findViewById(R.id.SearchBar);


        downloadButton.setOnClickListener(this);
        historyButton.setOnClickListener(this);
        historyButton1.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ButtonAA:
                // 执行分类的跳转逻辑
                Intent intent = new Intent(requireContext(), FragmentAA.class);
                startActivity(intent);
                break;
            case R.id.ButtonBB:
                // 执行排行榜的跳转逻辑
                Intent intent1 = new Intent(requireContext(),ButtonBB.class);
                startActivity(intent1);
                break;
            case R.id.SearchBar:
                // 执行搜索的跳转逻辑
                Intent intent2 = new Intent(requireContext(),Searchbar.class);
                startActivity(intent2);
                break;

        }
    }

}