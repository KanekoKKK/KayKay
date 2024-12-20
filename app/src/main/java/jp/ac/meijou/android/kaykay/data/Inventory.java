package jp.ac.meijou.android.kaykay.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "inventory",
        foreignKeys = {@ForeignKey(
                entity = Dagashi.class,
                parentColumns = "dagashi_id",
                childColumns = "item_id"
        )}
)
public class Inventory {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_index")
    private int item_index;

    @ColumnInfo(name = "item_id")
    private String item_id;

    @ColumnInfo(name = "item_amount")
    private int item_amount;


    // setter and getter
    public void setItem_index(int item_index) {
        this.item_index = item_index;
    }

    public int getItem_index() {
        return item_index;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_amount(int item_amount) {
        this.item_amount = item_amount;
    }

    public int getItem_amount() {
        return item_amount;
    }
}
