package css.cis3334.project;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Character.class, Spell.class}, version = 1)
public abstract class CharacterDatabase extends RoomDatabase {
    public abstract CharacterDao characterDao();

    private static volatile CharacterDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static CharacterDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (CharacterDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    CharacterDatabase.class, "character-database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
