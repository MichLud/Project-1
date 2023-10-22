package css.cis3334.project;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CharacterDao {
    @Insert
    void insert(Character character);

    @Delete
    void delete(Character character);

    @Query("SELECT * FROM Character")
    LiveData<List<Character>> getAllCharacters();
}