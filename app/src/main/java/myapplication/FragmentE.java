package myapplication;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.logIn.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FragmentE extends Fragment {
    private static final int REQUEST_CODE_PICK_IMAGE = 1;

    private ImageView imageViewTX; // 类成员变量imageViewTX

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_e, container, false);

        imageViewTX = view.findViewById(R.id.imageViewTX); // 初始化imageViewTX

        imageViewTX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        Button button = view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fgmente.button1.class);
                startActivity(intent);
            }
        });

        Button button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fgmente.button2.class);
                startActivity(intent);
            }
        });

        Button button3 = view.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fgmente.button3.class);
                startActivity(intent);
            }
        });

        Button button4 = view.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fgmente.button4.class);
                startActivity(intent);
            }
        });

        Button button5 = view.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fgmente.button5.class);
                startActivity(intent);
            }
        });

        Button button6 = view.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fgmente.shezhi.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void chooseImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_PICK_IMAGE) {
            Uri imageUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageUri);

                if (imageViewTX != null) { // 判断imageViewTX是否为空，避免空指针异常
                    imageViewTX.setImageBitmap(bitmap);
                    saveAvatar(bitmap); // 将图片保存到本地文件系统
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveAvatar(Bitmap bitmap) {
        try {
            // 将 Bitmap 转换为文件
            File file = new File(getActivity().getFilesDir(), "avatar.png");
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();

            // 记录文件路径
            SharedPreferences preferences = getContext().getSharedPreferences("avatar", MODE_PRIVATE);
            preferences.edit().putString("path", file.getAbsolutePath()).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}