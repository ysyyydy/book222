package myapplication;

import DB_book.BookDao;
import DB_book.BookDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.logIn.R;
import fgmente.FragmentE;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;
    private FragmentD fragmentD;
    private FragmentE fragmentE;
    Button btnFragmentA;
    Button btnFragmentB;
    Button btnFragmentC;
    Button btnFragmentD;
    Button btnFragmentE;
    private BookDatabase bookDatabase;
    private BookDao bookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        bookDatabase = BookDatabase.getInstance(this);
        bookDao = bookDatabase.bookDao();
        // 初始化按钮
        btnFragmentA = findViewById(R.id.btnFragmentA);
        btnFragmentB = findViewById(R.id.btnFragmentB);
        btnFragmentC = findViewById(R.id.btnFragmentC);
        btnFragmentD = findViewById(R.id.btnFragmentD);
        btnFragmentE = findViewById(R.id.btnFragmentE);


        // 设置按钮点击事件监听器
        btnFragmentA.setOnClickListener(this);
        btnFragmentB.setOnClickListener(this);
        btnFragmentC.setOnClickListener(this);
        btnFragmentD.setOnClickListener(this);
        btnFragmentE.setOnClickListener(this);


        // 创建 Fragment 实例
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentC = new FragmentC();
        fragmentD = new FragmentD();
        fragmentE = new FragmentE();


        // 获取 FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 默认显示 FragmentA
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragmentA)
                .commit();

    }
    private void resetButtonColors() {
        btnFragmentA.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        btnFragmentB.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        btnFragmentC.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        btnFragmentD.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        btnFragmentE.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFragmentA:
                switchToFragmentA();
                break;
            case R.id.btnFragmentB:
                switchToFragmentB();
                break;
            case R.id.btnFragmentC:
                switchToFragmentC();
                break;
            case R.id.btnFragmentD:
                switchToFragmentD();
                break;
            case R.id.btnFragmentE:
                switchToFragmentE();
                break;
        }
    }

    public void switchToFragmentA() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentA);
        transaction.commit();
        resetButtonColors();
        btnFragmentA.setBackgroundColor(getResources().getColor(R.color.selectedButtonColor));
    }

    public void switchToFragmentB() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentB);
        transaction.commit();
        resetButtonColors();
        btnFragmentB.setBackgroundColor(getResources().getColor(R.color.selectedButtonColor));
    }
    public void switchToFragmentC() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentC);
        transaction.commit();
        resetButtonColors();
        btnFragmentC.setBackgroundColor(getResources().getColor(R.color.selectedButtonColor));
    }

    public void switchToFragmentD() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentD);
        transaction.commit();
        resetButtonColors();
        btnFragmentD.setBackgroundColor(getResources().getColor(R.color.selectedButtonColor));
    }
    public void switchToFragmentE() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentE);
        transaction.commit();
        resetButtonColors();
        btnFragmentE.setBackgroundColor(getResources().getColor(R.color.selectedButtonColor));
    }

}
