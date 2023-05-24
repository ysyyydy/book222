package myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.logIn.R;

import rank.Rank_hpb;
import rank.Rank_rqb;
import rank.Rank_rsb;
import rank.Rank_tjb;
import rank.Rank_wjb;
import rank.Rank_xsb;

public class ButtonBB extends AppCompatActivity implements View.OnClickListener {

    private Rank_rqb rank_rqb;
    private Rank_tjb rank_tjb;
    private Rank_xsb rank_xsb;
    private Rank_hpb rank_hpb;
    private Rank_rsb rank_rsb;
    private Rank_wjb rank_wjb;

    Button Buttonrqb;
    Button Buttontjb;
    Button Buttonxsb;
    Button Buttonhpb;
    Button Buttonrsb;
    Button Buttonwjb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonbb);

        // 初始化按钮
        Buttonrqb = findViewById(R.id.Buttonrqb);
        Buttontjb = findViewById(R.id.Buttontjb);
        Buttonxsb = findViewById(R.id.Buttonxsb);
        Buttonhpb = findViewById(R.id.Buttonhpb);
        Buttonrsb = findViewById(R.id.Buttonrsb);
        Buttonwjb = findViewById(R.id.Buttonwjb);


        // 设置按钮点击事件监听器
        Buttonrqb.setOnClickListener(this);
        Buttontjb.setOnClickListener(this);
        Buttonxsb.setOnClickListener(this);
        Buttonhpb.setOnClickListener(this);
        Buttonrsb.setOnClickListener(this);
        Buttonwjb.setOnClickListener(this);

        // 创建 Fragment 实例
        rank_rqb = new Rank_rqb();
        rank_tjb = new Rank_tjb();
        rank_xsb = new Rank_xsb();
        rank_hpb = new Rank_hpb();
        rank_rsb = new Rank_rsb();
        rank_wjb = new Rank_wjb();
        // 获取 FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 默认显示 Rank_rqb
        fragmentManager.beginTransaction()
                .add(R.id.freast, rank_rqb)
                .commit();

    }
    private void resetButtonColors() {
        Buttonrqb.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        Buttontjb.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        Buttonxsb.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        Buttonhpb.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        Buttonrsb.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        Buttonwjb.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Buttonrqb:
                switchToFragmentrqb();
                break;
            case R.id.Buttontjb:
                switchToFragmenttjb();
                break;
            case R.id.Buttonxsb:
                switchToFragmentxsb();
                break;
            case R.id.Buttonhpb:
                switchToFragmenthpb();
                break;
            case R.id.Buttonrsb:
                switchToFragmentrsb();
                break;
            case R.id.Buttonwjb:
                switchToFragmentwjb();
                break;

        }
    }

    public void switchToFragmentrqb() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.freast, rank_rqb);
        transaction.commit();
        resetButtonColors();
        Buttonrqb.setBackgroundColor(getResources().getColor(R.color.white));
    }
    public void switchToFragmenttjb() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.freast, rank_tjb);
        transaction.commit();
        resetButtonColors();
        Buttonrqb.setBackgroundColor(getResources().getColor(R.color.white));
    }
    public void switchToFragmentxsb() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.freast, rank_xsb);
        transaction.commit();
        resetButtonColors();
        Buttonxsb.setBackgroundColor(getResources().getColor(R.color.white));
    }
    public void switchToFragmenthpb() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.freast, rank_hpb);
        transaction.commit();
        resetButtonColors();
        Buttonhpb.setBackgroundColor(getResources().getColor(R.color.white));
    }
    public void switchToFragmentrsb() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.freast, rank_rsb);
        transaction.commit();
        resetButtonColors();
        Buttonrsb.setBackgroundColor(getResources().getColor(R.color.white));
    }
    public void switchToFragmentwjb() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.freast, rank_wjb);
        transaction.commit();
        resetButtonColors();
        Buttonwjb.setBackgroundColor(getResources().getColor(R.color.white));
    }


}
