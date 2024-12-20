package jp.ac.meijou.android.kaykay;
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

public class SubActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        ImageView iv1 = findViewById(R.id.iv1); //画像を表示させるImageView

        // ボタンにクリックリスナーを設定
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 次の画面にランダムインデックスを渡す
                Intent intent = new Intent(SubActivity.this, SubActivity2.class);
                startActivity(intent);
            }
        });
    }

}
