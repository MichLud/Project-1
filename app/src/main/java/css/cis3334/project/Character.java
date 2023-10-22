package css.cis3334.project;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Dungeons & Dragons character with a name, character class, and ability scores.
 */
@Entity
public class Character {

    public String name;
    public String characterClass;
    
    public List<Integer> attributes;

    public ArrayList<Spell> spells;

    @PrimaryKey(autoGenerate = true)
    public int id;

    /**
     * Constructs a Character with the specified name and character class.
     *
     * @param name The name of the character.
     * @param characterClass The character's class or profession.
     */
    public Character(String name, String characterClass, List<Integer> attributes) {
        this.name = name;
        this.characterClass = characterClass;
        this.attributes = attributes;

        spells = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + ", " + characterClass;
    }
}

