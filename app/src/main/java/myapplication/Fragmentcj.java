package myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.logIn.R;

import java.util.Random;

public class Fragmentcj extends Fragment {

    private Button mButtonDraw;
    private TextView mTextWinner;

    private String[] mCandidates = {"电视", "电风扇", "电脑", "洗衣机", "自行车"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentcj, container, false);

        mButtonDraw = view.findViewById(R.id.button_draw);
        mTextWinner = view.findViewById(R.id.text_winner);

        mButtonDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 随机选择一个奖
                Random random = new Random();
                int index = random.nextInt(mCandidates.length);
                String winner = mCandidates[index];

                // 在文本框中显示奖
                mTextWinner.setText("恭喜 " + " 中" + winner);
            }
        });

        return view;
    }
}