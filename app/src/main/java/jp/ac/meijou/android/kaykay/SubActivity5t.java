package jp.ac.meijou.android.kaykay;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity5t extends AppCompatActivity {
    private void setupButtonClickListener(int buttonId, final Class<?> targetActivity) {
        findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity5t.this, targetActivity);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub5);
        setupButtonClickListener(R.id.button3, SubActivity2.class);
        setupButtonClickListener(R.id.button4, SubActivity8.class);
        setupButtonClickListener(R.id.button5, SubActivity4.class);
        setupButtonClickListener(R.id.button6, SubActivity3.class);
        setupButtonClickListener(R.id.button9,SubActuvity7.class);

        //素材の配列
        ImageButton items[] = {
                findViewById(R.id.image16),findViewById(R.id.image17),findViewById(R.id.image18),findViewById(R.id.image19),
                findViewById(R.id.image20),findViewById(R.id.image21),findViewById(R.id.image22),findViewById(R.id.image23),
                findViewById(R.id.image24),findViewById(R.id.image25),findViewById(R.id.image26),findViewById(R.id.image27),
                findViewById(R.id.image28),findViewById(R.id.image29),findViewById(R.id.image30),findViewById(R.id.image31),
        };
        boolean[] isSelected = new boolean[items.length];

        for (int i = 0; i < items.length; i++) {
            final int index = i;
            items[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    isSelected[index] = !isSelected[index];
                    itemSelected(items[index],isSelected[index]);
                }
            });
        }


    }
    private void itemSelected(ImageButton button, boolean isSelected) {
        if (isSelected) {
            button.setBackgroundColor(Color.parseColor("#FF0000")); // 選択状態なら半透明
        } else {
            button.setBackgroundColor(Color.parseColor("#52FFFFFF"));
        }
    }
}
