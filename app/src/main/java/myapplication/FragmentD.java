package myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.logIn.R;

import fragmentD.button10;
import fragmentD.button11;

public class FragmentD extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d, container, false);

        LinearLayout button = (LinearLayout) view.findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), button11.class);
                startActivity(intent);

            }

        });
        LinearLayout button10 = (LinearLayout) view.findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), button10.class);
                startActivity(intent);

            }

        });
        LinearLayout button12 = (LinearLayout) view.findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fragmentD.button12.class);
                startActivity(intent);

            }

        });
        LinearLayout button13 = (LinearLayout) view.findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fragmentD.button13.class);
                startActivity(intent);

            }

        });
        return view;
    }
}