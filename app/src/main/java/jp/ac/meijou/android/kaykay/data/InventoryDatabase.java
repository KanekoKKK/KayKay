package jp.ac.meijou.android.kaykay.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Dagashi.class, Inventory.class}, version = 1, exportSchema = false)
public abstract class InventoryDatabase extends RoomDatabase {

    public abstract InventoryDao inventoryDao();

    private static volatile InventoryDatabase instance;

    public static InventoryDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (InventoryDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            InventoryDatabase.class,
                            "inventory_database"
                    ).build();
                }
            }
        }
        return instance;
    }
}
