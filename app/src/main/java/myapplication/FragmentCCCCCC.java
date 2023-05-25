package myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.logIn.R;

public class FragmentCCCCCC extends Fragment { @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // 加载布局文件
    View view = inflater.inflate(R.layout.fragment_cccccc, container, false);
    @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button = view.findViewById(R.id.ButtonCCCCC);

    return view;
}

// 在这里添加你的代码
}