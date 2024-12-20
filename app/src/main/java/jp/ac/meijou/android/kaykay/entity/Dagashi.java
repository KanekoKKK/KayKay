package jp.ac.meijou.android.kaykay.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dagashi")
public class Dagashi {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "dagashi_id")
    private String dagashi_id;

    @ColumnInfo(name = "dagashi_type")
    private int dagashi_type;

    @ColumnInfo(name = "dagashi_name")
    private String dagashi_name;

    @ColumnInfo(name = "dagashi_image")
    private String dagashi_image;

    @ColumnInfo(name = "description")
    private String dagashi_description;


    // setter and getter
    public void setDagashi_id(@NonNull String dagashi_id) {
        this.dagashi_id = dagashi_id;
    }

    @NonNull
    public String getDagashi_id() {
        return dagashi_id;
    }

    public void setDagashi_type(int dagashi_type) {
        this.dagashi_type = dagashi_type;
    }

    public int getDagashi_type() {
        return dagashi_type;
    }

    public void setDagashi_name(String dagashi_name) {
        this.dagashi_name = dagashi_name;
    }

    public String getDagashi_name() {
        return dagashi_name;
    }

    public void setDagashi_image(String dagashi_image) {
        this.dagashi_image = dagashi_image;
    }

    public String getDagashi_image() {
        return dagashi_image;
    }

    public void setDagashi_description(String dagashi_description) {
        this.dagashi_description = dagashi_description;
    }

    public String getDagashi_description() {
        return dagashi_description;
    }
}
