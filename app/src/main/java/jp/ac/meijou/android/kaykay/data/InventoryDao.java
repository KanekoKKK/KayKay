package jp.ac.meijou.android.kaykay.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

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
    List<Dagashi> getExtractableItems();

    @Transaction
    @Query("SELECT * FROM dagashi AS t1 INNER JOIN inventory AS t2 ON t1.dagashi_id = t2.item_id WHERE t1.dagashi_type = 2")
    List<Dagashi> getMaterialItems();

    @Query("SELECT item_amount FROM inventory WHERE item_index = :itemIndex")
    int getItemAmount(String itemIndex);

    @Query("SELECT * FROM inventory")
    List<Inventory> getAllItems();
}
