package myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.logIn.R;

import java.util.Timer;
import java.util.TimerTask;

import DB_book.AddBookActivity;
import fiction.MainReadActivity;
import local.NovelReaderActivity;

public class FragmentA extends Fragment implements View.OnClickListener {
    private Timer timer;
    private int currentPosition = 0;
    private HorizontalScrollView horizontalScrollView;
    private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        ImageView downloadButton = view.findViewById(R.id.imageView4);//查找控件
        ImageView historyButton = view.findViewById(R.id.imageView5);
        Button historyButton1 = view.findViewById(R.id.SearchBar);
        Button readButton = view.findViewById(R.id.ButtonCC);
        Button localButton = view.findViewById(R.id.ButtonDD);
        Button mainButton = view.findViewById(R.id.ButtonEE);


        downloadButton.setOnClickListener(this);//为控件设置监听器
        historyButton.setOnClickListener(this);
        historyButton1.setOnClickListener(this);
        readButton.setOnClickListener(this);
        localButton.setOnClickListener(this);
        mainButton.setOnClickListener(this);

        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);//查找并设置滚动监听器
        imageView = view.findViewById(R.id.imageView1);
        imageView = view.findViewById(R.id.imageView2);
        imageView = view.findViewById(R.id.imageView3);

        return view;
    }
    public void onResume() {
        super.onResume();
        startTimer();
    }

    @Override
    public void onPause() {
        super.onPause();
        stopTimer();
    }

    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                currentPosition++;
                if(currentPosition >= 3) { // 如果超过了最后一张图片，回到第一张图片
                    currentPosition = 0;
                }
                requireActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        horizontalScrollView.scrollTo(currentPosition * imageView.getWidth(), 0);//只让其水平滚动且滚动到相应位置
                    }
                });
            }
        }, 1000, 1000);
    }


    private void stopTimer() {
        if(timer != null) {
            timer.cancel();
            timer = null;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView4:
                // 执行分类的跳转逻辑
                Intent intent = new Intent(requireContext(), FragmentAA.class);
                startActivity(intent);
                break;
            case R.id.imageView5:
                // 执行排行榜的跳转逻辑
                Intent intent1 = new Intent(requireContext(),ButtonBB.class);
                startActivity(intent1);
                break;
            case R.id.SearchBar:
                // 执行搜索的跳转逻辑
                Intent intent2 = new Intent(requireContext(),Searchbar.class);
                startActivity(intent2);
                break;
            case R.id.ButtonCC:
                // 执行开始阅读的跳转逻辑
                Intent intent3 = new Intent(requireContext(), MainReadActivity.class);
                startActivity(intent3);
                break;
            case R.id.ButtonDD:
                // 执行本地阅读的跳转逻辑
                Intent intent4 = new Intent(requireContext(), NovelReaderActivity.class);
                startActivity(intent4);
                break;
            case R.id.ButtonEE:
                // 执行全部书籍的跳转逻辑
                Intent intent5 = new Intent(requireContext(), AddBookActivity.class);
                startActivity(intent5);
                break;

        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        stopTimer();
    }
}