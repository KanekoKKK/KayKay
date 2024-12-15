package jp.ac.meijou.android.kaykay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity5g extends AppCompatActivity {
    private void setupButtonClickListener(int buttonId, final Class<?> targetActivity) {
        findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity5g.this, targetActivity);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub4);
        setupButtonClickListener(R.id.button3, SubActivity2.class);
        setupButtonClickListener(R.id.button4, SubActivity.class);
        setupButtonClickListener(R.id.button5, SubActivity4.class);
        setupButtonClickListener(R.id.button6, SubActivity3.class);
    }
}
