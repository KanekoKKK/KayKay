package jp.ac.meijou.android.kaykay;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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
        okashi[0].setOkashiData("chocolate", "none", "none", 3);
        okashi[1].setOkashiData("cola", "none", "none", 5);
        okashi[2].setOkashiData("cookie", "none", "none", 2);
        okashi[3].setOkashiData("salt", "none", "none", 14);
        okashi[4].setOkashiData("potato_chip_none", "none", "none", 4);
        okashi[5].setOkashiData("candy_none", "none", "none", 7);

        //合成素材の表示
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

        //合成ボタンを押したとき
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //押しているボタンの数を数える
                int countTrue = 0;
                for(int i = 0; i < okashi.length; i++){
                    if (okashi[i].getIsSelected()==true) {
                        countTrue++;
                    }
                }
                if(countTrue == 2) {
                    //合成機能
                    String result;
                    int isEnouch = 0;
                    //選択した素材を保存
                    String selected[] = {"none", "none"};
                    boolean isFinish = false;
                    for (int j = 0; j < okashi.length; j++) {
                        if (okashi[j].getIsSelected()) {
                            if (!isFinish) {
                                if(okashi[j].getMaterial1() == "none" && okashi[j].getMaterial2() == "none"){
                                    selected[0] = okashi[j].getOkashi();
                                    isFinish = true;
                                }else {
                                    selected[0] = "none";
                                }
                                isEnouch = okashi[j].getAmount();
                            } else {
                                if(okashi[j].getMaterial1() == "none" && okashi[j].getMaterial2() == "none"){
                                    selected[1] = okashi[j].getOkashi();
                                }else {
                                    selected[1] = "none";
                                }
                                isEnouch = isEnouch * okashi[j].getAmount();
                                break;
                            }
                        }
                    }
                    //レシピを使って合成
                    if(isEnouch == 0) {
                        /*合成素材の所持数が足りない*/
                    } else if ((selected[0] == "none" || selected[1] == "none")) {
                        /*これ以上合成できないお菓子の場合*/
                    } else {
                        //正しく合成できる場合
                        if ((selected[0] == "cookie" && selected[1] == "salt")
                                || (selected[0] == "salt" && selected[1] == "cookie")){
                            result = "material_cookie_salt";
                        } else if ((selected[0] == "potato_chip_none" && selected[1] == "chocolate")
                                || (selected[0] == "chocolate" && selected[1] == "potato_chip_none")){
                            result = "material_chocolate_potato";
                        } else if ((selected[0] == "candy_none" && selected[1] == "chocolate")
                                || (selected[0] == "chocolate" && selected[1] == "candy_none")){
                            result = "material_chocolate_candy";
                        } else if ((selected[0] == "chocolate" && selected[1] == "cola")
                                || (selected[0] == "cola" && selected[1] == "chocolate")){
                            result = "material_chocolate_cola_float";
                        } else if ((selected[0] == "cookie" && selected[1] == "chocolate")
                                || (selected[0] == "chocolate" && selected[1] == "cookie")){
                            result = "material_chocolate_chip_cookie";
                        } else if ((selected[0] == "potato_chip_none" && selected[1] == "salt")
                                || (selected[0] == "salt" && selected[1] == "potato_chip_none")){
                            result = "material_potato_chip";
                        } else if ((selected[0] == "candy_none" && selected[1] == "cola")
                                || (selected[0] == "cola" && selected[1] == "candy")){
                            result = "material_candy_cola";
                        } else {
                            result = "material_darkmatter";
                        }
                        /*所持数を保存(合成元1・2 -1(amount)、合成先+1(result,所持数の保存先未実装))*/
                        Intent intent = new Intent(SubActivity5g.this, SubActivity6.class);
                        intent.putExtra("g_result", result);
                        startActivity(intent);
                    }
                } else {
                  /*お菓子が2個未満or3個以上選択されている*/
                }
            }
        });
    }
}
