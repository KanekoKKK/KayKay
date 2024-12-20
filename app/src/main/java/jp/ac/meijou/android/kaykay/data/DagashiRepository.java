package jp.ac.meijou.android.kaykay.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DagashiRepository {

    private DagashiDao mDagashiDao;
    private LiveData<List<Dagashi>> mAllDagashi;

    // コンストラクタ
    public DagashiRepository(Application application) {
        DagashiDatabase db = DagashiDatabase.getDatabase(application);
        mDagashiDao = db.dagashiDao();
        mAllDagashi = mDagashiDao.getAllDagashi();
    }

    public void insertItem(Dagashi dagashi) {
        DagashiDatabase.databaseWriteExecutor.execute(() -> {
            mDagashiDao.insertDagashi(dagashi);
        });
    }

    public LiveData<Dagashi> getDagashi(String dagashiId) {
        return mDagashiDao.getDagashi(dagashiId);
    }

    public LiveData<List<Dagashi>> getAllDagashi() {
        return mAllDagashi;
    }


}
