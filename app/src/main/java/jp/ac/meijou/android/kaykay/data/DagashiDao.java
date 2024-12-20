package jp.ac.meijou.android.kaykay.data;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

@Dao
public interface DagashiDao {
    @Query("SELECT * FROM dagashi WHERE dagashi_name = :dagashiName")
    public Flow<Dagashi> getDagashi(String dagashiName);

    @Query("SELECT * FROM dagashi ORDER BY dagashi_name")
    public Flow<List<Dagashi>> getAllDagashi();
}
