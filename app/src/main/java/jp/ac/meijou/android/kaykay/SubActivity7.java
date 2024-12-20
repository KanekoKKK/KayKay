package jp.ac.meijou.android.kaykay;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
        String result1 = "material_" + result[0];
        String result2 = "material_" + result[1];

        //抽出結果表示
        ImageView iv1 = findViewById(R.id.iv2);
        int resId1 = getResources().getIdentifier(result1, "drawable", getPackageName());
        if (resId1 != 0) {
            Drawable material1 = getResources().getDrawable(resId1, null);
            iv1.setImageDrawable(material1);
        }
        ImageView iv2 = findViewById(R.id.iv3);
        int resId2 = getResources().getIdentifier(result2, "drawable", getPackageName());
        if (resId2 != 0) {
            Drawable material2 = getResources().getDrawable(resId2, null);
            iv2.setImageDrawable(material2);
        }
    }
}