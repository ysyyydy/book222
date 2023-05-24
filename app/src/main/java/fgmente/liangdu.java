package fgmente;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.logIn.R;

public class liangdu extends AppCompatActivity {

    private SeekBar mBrightnessSeekBar;
    private TextView mBrightnessValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, 0);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liangdu);

        mBrightnessSeekBar = findViewById(R.id.brightness_seekbar);
        mBrightnessValueTextView = findViewById(R.id.brightness_value_textview);

        // 获取当前屏幕亮度并设置初始进度
        int currentBrightness = Settings.System.getInt(getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS, 0);
        mBrightnessSeekBar.setProgress(currentBrightness);
        mBrightnessValueTextView.setText(String.valueOf(currentBrightness));

        // 设置SeekBar的监听器，在进度发生变化时修改屏幕亮度并更新UI
        mBrightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 修改屏幕亮度
                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.screenBrightness = (float) progress / 255;
                getWindow().setAttributes(layoutParams);

                // 更新UI
                mBrightnessValueTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}