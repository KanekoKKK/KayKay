package jp.ac.meijou.android.kaykay;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

//抽出結果画面
public class SubActivity7 extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub7); // 遷移後のレイアウトを指定
        // 抽出画面に戻るボタン
        findViewById(R.id.button14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubActivity7.this, SubActivity5t.class);
                startActivity(intent);
            }
        });

        //抽出したデータ受け取り
        Intent intent = getIntent();
        String[] result = intent.getStringArrayExtra("t_result");
    }
}