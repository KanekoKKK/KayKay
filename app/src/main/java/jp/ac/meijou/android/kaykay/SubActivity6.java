package jp.ac.meijou.android.kaykay;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity6 extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub6); // 遷移後のレイアウトを指定

        // ホームに戻る
        findViewById(R.id.button13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubActivity6.this, SubActivity2.class);
                startActivity(intent);
            }
        });

        //合成したデータ受け取り
        Intent intent = getIntent();
        String result = intent.getStringExtra("g_result");

        //合成結果表示
        ImageView iv = findViewById(R.id.iv2);
        int resId = getResources().getIdentifier(result, "drawable", getPackageName());
        if (resId != 0) {
            Drawable material = getResources().getDrawable(resId, null);
            iv.setImageDrawable(material);
        }
    }

}