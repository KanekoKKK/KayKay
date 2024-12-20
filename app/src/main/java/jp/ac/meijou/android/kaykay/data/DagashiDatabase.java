package jp.ac.meijou.android.kaykay.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Dagashi.class}, version = 1, exportSchema = false)
public abstract class DagashiDatabase extends RoomDatabase {

    public abstract DagashiDao dagashiDao();

    private static volatile DagashiDatabase instance;
    private static final int NUMBER_OF_THREAD = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREAD);

    public static DagashiDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (DagashiDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            DagashiDatabase.class,
                            "dagashi_database"
                    ).build();
                }
            }
        }
        return instance;
    }
}
