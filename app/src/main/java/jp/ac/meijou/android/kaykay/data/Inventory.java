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
    int item_index;

    @ColumnInfo(name = "item_id")
    String item_id;

    @ColumnInfo(name = "item_amount")
    int item_amount;
}
