package jp.ac.meijou.android.kaykay;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "DailyUsagePrefs"; // SharedPreferencesの名前
    private static final String LAST_USED_DATE_KEY = "lastUsedDate"; // 最終利用日を保存するキー
    private int i = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // SharedPreferencesを取得
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // 現在の日付を取得
        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().getTime());

        // 最終利用日を取得
        String lastUsedDate = prefs.getString(LAST_USED_DATE_KEY, "");

        //ボタンを押したとき
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(LAST_USED_DATE_KEY, currentDate);
                editor.apply();
                Intent intent;
                if (currentDate.equals(lastUsedDate)) {
                    intent = new Intent(MainActivity.this, SubActivity2.class);
                } else {
                    intent = new Intent(MainActivity.this, SubActivity.class);
                }
                startActivity(intent);
            }

        });
        //開発者モード条件
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i==7){
                   Intent intent = new Intent(MainActivity.this, SubActivity.class);
                    startActivity(intent);
                   i=0;
                }
            }
        });
    }
}