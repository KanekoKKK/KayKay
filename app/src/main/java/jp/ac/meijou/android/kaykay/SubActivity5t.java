package jp.ac.meijou.android.kaykay;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

//抽出画面
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

        //ImageButtonのデータ
        OkashiData okashi[] = new OkashiData[16];
        ImageButton buttons[] = {
                findViewById(R.id.image16),findViewById(R.id.image17),findViewById(R.id.image18),findViewById(R.id.image19),
                findViewById(R.id.image20),findViewById(R.id.image21),findViewById(R.id.image22),findViewById(R.id.image23),
                findViewById(R.id.image24),findViewById(R.id.image25),findViewById(R.id.image26),findViewById(R.id.image27),
                findViewById(R.id.image28),findViewById(R.id.image29),findViewById(R.id.image30),findViewById(R.id.image31),
        };
        int o = 0;
        for(ImageButton button : buttons){
            okashi[o] = new OkashiData(button);
            o++;
        }
        //お菓子サンプルデータ
        okashi[0].setOkashiData("chocolate_chip_cookie", "cookie", "chocolate", 2);
        okashi[1].setOkashiData("candy_cola", "candy_none", "cola", 1);

        //抽出元の表示
        int k = 0;
        while(okashi[k].getOkashi() != "none"){
            int resId1 = getResources().getIdentifier(okashi[k].getDrawable(), "drawable", getPackageName());
            if (resId1 != 0) {
                Drawable material1 = getResources().getDrawable(resId1, null);
                okashi[k].getButton().setImageDrawable(material1);
            }
            k++;
        }


        //素材の選択(クリックリスナー)
        for (int i = 0; i < okashi.length; i++) {
            final int index = i;
            okashi[i].getButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    okashi[index].click();
                }
            });
        }

        //抽出ボタンを押したとき
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //押しているボタンの数を数える
                int countTrue = 0;
                for(int i = 0; i < okashi.length; i++){
                    if (okashi[i].getIsSelected()==true) {
                        countTrue++;
                    }
                }
                if(countTrue == 1){
                    //抽出機能
                    for(int j = 0; j < okashi.length; j++) {
                        //結果
                        if(okashi[j].getIsSelected()) {
                            String result[] = {okashi[j].getMaterial1(), okashi[j].getMaterial2()};
                            if(okashi[j].getAmount() < 1){
                                /*抽出元の所持数が足りない*/
                            } else  if (result[0] == "none" && result[1] == "none") {
                                /*これ以上抽出できない素材の場合*/
                            } else {
                                //正しく抽出できた時
                                /*所持数を保存(抽出元-1(amount)、抽出先+1(material1・2,所持数の保存先未実装))*/
                                Intent intent = new Intent(SubActivity5t.this, SubActivity7.class);
                                intent.putExtra("t_result", result);
                                startActivity(intent);
                            }
                            break;
                        }
                    }
                } else {
                    /*お菓子が0個or2個以上選択されている*/
                }
            }
        });
    }
}
