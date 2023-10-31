package css.cis3334.project;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainViewModel extends ViewModel {

    public LiveData<List<Character>> characterList;
    public CharacterRepository characterRepository;

    public MainViewModel(Application application) {
        characterRepository = new CharacterRepository(application);
        characterList = characterRepository.getAllCharacters();
    }

    public void addCharacter(Character newCharacter) {
        characterRepository.insert(newCharacter);
    }


    public LiveData<List<Character>> getAllCharacters() {
        return characterList;
    }
}