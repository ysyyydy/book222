package myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.logIn.R;


public class FragmentC extends androidx.fragment.app.Fragment {  @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // 加载布局文件
    View view = inflater.inflate(R.layout.fragment_c, container, false);
// 获取按钮视图
    Button button = view.findViewById(R.id.ButtonCC);
    Button button2 = view.findViewById(R.id.ButtonCJ);

    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragmentcj fragment = new Fragmentcj();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


/*                // 如果要跳转到另一个Activity，可以使用以下代码
                Intent intent = new Intent(requireContext(), OtherActivity.class);
                startActivity(intent);*/
        }
    });

// 设置按钮的点击事件监听器
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 在此处处理按钮点击事件，跳转到其他页面

            // 如果要跳转到另一个Fragment，可以使用以下代码


            FragmentCC fragment = new FragmentCC();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


/*                // 如果要跳转到另一个Activity，可以使用以下代码
                Intent intent = new Intent(requireContext(), OtherActivity.class);
                startActivity(intent);*/
        }
    });

    // 在这里对视图进行操作或添加事件监听器等

    return view;
}

    // 在这里添加你的代码
}