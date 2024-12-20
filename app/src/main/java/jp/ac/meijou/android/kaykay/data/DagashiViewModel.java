package jp.ac.meijou.android.kaykay.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DagashiViewModel extends AndroidViewModel {

    private DagashiRepository mRepository;
    private final LiveData<List<Dagashi>> mAllDagashi;

    // コンストラクタ
    public DagashiViewModel(Application application) {
        super(application);
        mRepository = new DagashiRepository(application);
        mAllDagashi = mRepository.getAllDagashi();
    }

    public void insertDagashi(Dagashi dagashi) {
        mRepository.insertItem(dagashi);
    }

    public LiveData<Dagashi> getDagashi(String dagashiId) {
        return mRepository.getDagashi(dagashiId);
    }

    public LiveData<List<Dagashi>> getAllDagashi() {
        return mAllDagashi;
    }
}
