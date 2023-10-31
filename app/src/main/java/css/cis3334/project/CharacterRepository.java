package css.cis3334.project;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;

public class CharacterRepository {
    private CharacterDao characterDao;
    private LiveData<List<Character>> allCharacters;

    public CharacterRepository(Application application) {
        CharacterDatabase database = CharacterDatabase.getInstance(application);
        characterDao = database.characterDao();
        allCharacters = characterDao.getAllCharacters();
    }

    public void insert(Character character) {
        CharacterDatabase.databaseWriteExecutor.execute(() -> {
            characterDao.insert(character);
        });
    }

    public void delete(Character character) {
        CharacterDatabase.databaseWriteExecutor.execute(() -> {
            characterDao.delete(character);
        });
    }


    public LiveData<List<Character>> getAllCharacters() {
        return allCharacters;
    }
}
