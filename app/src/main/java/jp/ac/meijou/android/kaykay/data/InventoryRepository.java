package jp.ac.meijou.android.kaykay.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

public class InventoryRepository {
    private InventoryDao mInventoryDao;
    private LiveData<List<Inventory>> mAllItems;

    public InventoryRepository(Application application) {
        InventoryDatabase db = InventoryDatabase.getDatabase(application);
        mInventoryDao = db.inventoryDao();
        mAllItems = mInventoryDao.getAllItems();
    }

    public void insertItem(Inventory item) {
        InventoryDatabase.databaseWriteExecutor.execute(() -> {
            mInventoryDao.insertItem(item);
        });
    }

    public void updateItem(Inventory item) {
        InventoryDatabase.databaseWriteExecutor.execute(() -> {
            mInventoryDao.updateItem(item);
        });
    }

    public void deleteItem(Inventory item) {
        InventoryDatabase.databaseWriteExecutor.execute(() -> {
            mInventoryDao.deleteItem(item);
        });
    }

    public LiveData<List<Dagashi>> getExtractableItems() {
        return mInventoryDao.getExtractableItems();
    }

    public LiveData<List<Dagashi>> getMaterialItems() {
        return mInventoryDao.getMaterialItems();
    }

    public LiveData<Inventory> getItem(int itemIndex) {
        return mInventoryDao.getItem(itemIndex);
    }

    public LiveData<List<Inventory>> getAllItems() {
        return mAllItems;
    }
}
