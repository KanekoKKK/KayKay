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

        // ボタンにクリックリスナーを設定
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 次の画面にランダムインデックスを渡す
                Intent intent = new Intent(SubActivity.this, SubActivity2.class);
                startActivity(intent);
            }
        });

        //獲得処理
        Intent getIntent = getIntent();
        int money = getIntent.getIntExtra("fraction", 50);//50はエラー
        String result[] = {"none", "none"};
        if(money >= 40){
            result[0] = "chocolate_chip_cookie";
        } else if (money >= 30) {
            result[0] = "potato_chip";
        } else if (money >= 20) {
            result[0] = "candy_cola";
        } else if (money >= 10) {
            result[0] = "cookie";
        }
        money  = money % 10;
        if(money >= 7) {
            result[1] = "chocolate";
        } else if (money >= 4) {
            result[1] = "cola";
        } else if (money >= 1) {
            result[1] = "solt";
        }


        //獲得結果表示
        String result1 = "material_" + result[0];
        String result2 = "material_" + result[1];
        ImageView iv1 = findViewById(R.id.iv1);
        int resId1 = getResources().getIdentifier(result1, "drawable", getPackageName());
        if (resId1 != 0) {
            Drawable material1 = getResources().getDrawable(resId1, null);
            iv1.setImageDrawable(material1);
        }
        ImageView iv2 = findViewById(R.id.iv2);
        int resId2 = getResources().getIdentifier(result2, "drawable", getPackageName());
        if (resId2 != 0) {
            Drawable material2 = getResources().getDrawable(resId2, null);
            iv2.setImageDrawable(material2);
        }

        /*保存処理*/
    }
}
