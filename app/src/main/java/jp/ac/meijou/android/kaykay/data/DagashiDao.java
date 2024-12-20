package jp.ac.meijou.android.kaykay.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

@Dao
public interface DagashiDao {
    @Insert
    void insertDagashi(Dagashi dagashi);

    @Query("SELECT * FROM dagashi WHERE dagashi_id = :dagashiId")
    public Dagashi getDagashi(String dagashiId);

    @Query("SELECT * FROM dagashi ORDER BY dagashi_id")
    public List<Dagashi> getAllDagashi();
}
