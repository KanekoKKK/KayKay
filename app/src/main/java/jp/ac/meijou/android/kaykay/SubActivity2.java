package jp.ac.meijou.android.kaykay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {
    private void setupButtonClickListener(int buttonId, final Class<?> targetActivity) {
        findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity2.this, targetActivity);
                startActivity(intent);
            }
        });
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        setupButtonClickListener(R.id.button3, SubActivity2.class);
        setupButtonClickListener(R.id.button4, SubActivity8.class);
        setupButtonClickListener(R.id.button5, SubActivity4.class);
        setupButtonClickListener(R.id.button6, SubActivity3.class);// 遷移後のレイアウトを指定

        //開発者モード
        findViewById(R.id.clearButton).setOnClickListener(new View.OnClickListener() {
            int pushCount = 0;
            @Override
            public void onClick(View view) {
                pushCount++;
                if(pushCount==7){
                    pushCount=0;
                    Intent intent = new Intent(SubActivity2.this, MainActivity.class);
                    intent.putExtra("isDevelop", true);   //開発者モードboolean
                    startActivity(intent);
                }
            }
        });
    }

}

