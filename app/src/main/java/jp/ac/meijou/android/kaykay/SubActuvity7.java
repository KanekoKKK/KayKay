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

public class SubActuvity7 extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub7); // 遷移後のレイアウトを指定



        // ボタンにクリックリスナーを設定
        findViewById(R.id.button14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 次の画面にランダムインデックスを渡す
                Intent intent = new Intent(SubActuvity7.this, SubActivity5t.class);
                startActivity(intent);
            }
        });
    }

}