package jp.ac.meijou.android.kaykay.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import jp.ac.meijou.android.kaykay.entity.Dagashi;
import jp.ac.meijou.android.kaykay.entity.Inventory;
import jp.ac.meijou.android.kaykay.repository.InventoryRepository;

public class InventoryViewModel extends AndroidViewModel {
    private InventoryRepository mRepository;
    private final LiveData<List<Inventory>> mAllItems;
    private final LiveData<List<Dagashi>> mExtractableItems;
    private final LiveData<List<Dagashi>> mMaterialItems;

    // コンストラクタ
    public InventoryViewModel(Application application) {
        super(application);
        mRepository = new InventoryRepository(application);
        mExtractableItems = mRepository.getExtractableItems();
        mMaterialItems = mRepository.getMaterialItems();
        mAllItems = mRepository.getAllItems();
    }

    public void insertItem(Inventory item) {
        mRepository.insertItem(item);
    }

    public void updateItem(Inventory item) {
        mRepository.updateItem(item);
    }

    public void deleteItem(Inventory item) {
        mRepository.deleteItem(item);
    }

    public LiveData<List<Dagashi>> getExtractableItems() {
        return mExtractableItems;
    }

    public LiveData<List<Dagashi>> getMaterialItems() {
        return mMaterialItems;
    }

    public LiveData<Inventory> getItem(int itemIndex) {
        return mRepository.getItem(itemIndex);
    }

    public LiveData<List<Inventory>> getAllItems() {
        return mAllItems;
    }
}
