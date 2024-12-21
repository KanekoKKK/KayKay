package jp.ac.meijou.android.kaykay.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import jp.ac.meijou.android.kaykay.entity.Dagashi;
import jp.ac.meijou.android.kaykay.entity.Inventory;

@Dao
public interface InventoryDao {
    @Insert
    void insertItem(Inventory item);

    @Update
    void updateItem(Inventory item);

    @Delete
    void deleteItem(Inventory item);

    @Transaction
    @Query("SELECT * FROM dagashi AS t1 INNER JOIN inventory AS t2 ON t1.dagashi_id = t2.item_id WHERE t1.dagashi_type = 0")
    LiveData<List<Dagashi>> getExtractableItems();

    @Transaction
    @Query("SELECT * FROM dagashi AS t1 INNER JOIN inventory AS t2 ON t1.dagashi_id = t2.item_id WHERE t1.dagashi_type = 2")
    LiveData<List<Dagashi>> getMaterialItems();

    @Query("SELECT * FROM inventory WHERE item_index = :itemIndex")
    LiveData<Inventory> getItem(int itemIndex);

    @Query("SELECT * FROM inventory WHERE item_id = :itemId")
    LiveData<Inventory> getItemById(String itemId);

    @Query("SELECT * FROM inventory")
    LiveData<List<Inventory>> getAllItems();
}
