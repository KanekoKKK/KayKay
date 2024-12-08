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
        setContentView(R.layout.activity_sub); // 遷移後のレイアウトを指定

        // ImageView を取得
        ImageView iv1 = findViewById(R.id.iv1);

        // TypedArray からランダムな画像を取得
        TypedArray typedArray = getResources().obtainTypedArray(R.array.default_albumart);
        int i = (int) (Math.random() * typedArray.length());

        // 前画面からランダムインデックスが渡されたか確認
        int randomIndex = getIntent().getIntExtra("random_index", i);

        // 選択された画像を取得
        Drawable drawable = typedArray.getDrawable(randomIndex);

        // ImageView に画像を設定
        iv1.setImageDrawable(drawable);

        // TypedArray を解放
        typedArray.recycle();

        // ボタンにクリックリスナーを設定
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 次の画面にランダムインデックスを渡す
                Intent intent = new Intent(SubActivity.this, SubActivity.class);
                intent.putExtra("random_index", randomIndex);
                startActivity(intent);
            }
        });
    }
}
