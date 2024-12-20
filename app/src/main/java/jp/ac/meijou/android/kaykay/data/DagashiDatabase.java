package jp.ac.meijou.android.kaykay.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Dagashi.class}, version = 1, exportSchema = false)
public abstract class DagashiDatabase extends RoomDatabase {

    public abstract DagashiDao dagashiDao();

    private static volatile DagashiDatabase instance;

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
