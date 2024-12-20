package jp.ac.meijou.android.kaykay;

import android.graphics.Color;
import android.widget.ImageButton;

public class OkashiData {
    private ImageButton button;
    private boolean isSelected;
    private String okashi;
    private String material1;
    private String material2;
    private int amount;
    private String drawable;

    //ImageButtonを保存
    public OkashiData(ImageButton button){
        setButton(button);
        setIsSelected(false);
        setOkashi("none");
        setMaterial1("none");
        setMaterial2("none");
        setAmount(0);
    }
    //お菓子のデータを保存
    public void setOkashiData(String okashi, String material1, String material2, int amount){
        setOkashi(okashi);
        setMaterial1(material1);
        setMaterial2(material2);
        setAmount(amount);
        nameToDrawable();
    }

    //ボタンがクリックされたとき
    public void click() {
        setIsSelected(!getIsSelected());
        if (this.isSelected) {
            this.button.setBackgroundColor(Color.parseColor("#FF0000")); // 選択状態なら半透明
        } else {
            this.button.setBackgroundColor(Color.parseColor("#52FFFFFF"));
        }
    }

    //お菓子名から画像名
    public void nameToDrawable() {
        this.drawable = "material_" + this.okashi;
    }

    public ImageButton getButton() {return this.button;}
    public void setButton(ImageButton button) {this.button = button;}

    public boolean getIsSelected() {return this.isSelected;}
    public void setIsSelected(boolean isSelected) {this.isSelected = isSelected;}

    public String getOkashi() {return this.okashi;}
    public void setOkashi(String okashi) {this.okashi = okashi;}

    public String getMaterial1() {return this.material1;}
    public void setMaterial1(String material1) {this.material1 = material1;}

    public String getMaterial2() {return this.material2;}
    public void setMaterial2(String material2) {this.material2 = material2;}

    public int getAmount() {return this.amount;}
    public void setAmount(int amount) {this.amount = amount;}

    public String getDrawable() {return this.drawable;}
    public void setDrawable(String drawable) {this.drawable = drawable;}
}
