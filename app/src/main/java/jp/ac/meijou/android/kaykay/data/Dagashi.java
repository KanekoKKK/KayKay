package jp.ac.meijou.android.kaykay.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dagashi")
public class Dagashi {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "dagashi_name")
    String dagashi_name;

    @ColumnInfo(name = "dagashi_variable")
    String dagashi_variable;

    @ColumnInfo(name = "dagashi_image")
    String dagashi_image;

    @ColumnInfo(name = "dagashi_num")
    int dagashi_num = 0;

    @ColumnInfo(name = "description")
    String dagashi_description;
}
