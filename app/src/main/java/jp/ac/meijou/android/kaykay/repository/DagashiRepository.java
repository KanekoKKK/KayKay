package jp.ac.meijou.android.kaykay.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import jp.ac.meijou.android.kaykay.dao.DagashiDao;
import jp.ac.meijou.android.kaykay.database.DagashiDatabase;
import jp.ac.meijou.android.kaykay.entity.Dagashi;

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
