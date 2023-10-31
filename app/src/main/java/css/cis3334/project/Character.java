package css.cis3334.project;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Dungeons & Dragons character with a name, character class, and ability scores.
 */
@Entity
public class Character implements Serializable {

    public String name;
    public String characterClass;

    @TypeConverters(AttributeListConverter.class)
    public List<Integer> attributes;

    @TypeConverters(SpellsConverter.class)
    public ArrayList<Spell> spells;

    @PrimaryKey(autoGenerate = true)
    public int id;

    public Character() {
        this("New Character", " ");
    }

    /**
     * Constructs a Character with the specified name and character class.
     *
     * @param name The name of the character.
     * @param characterClass The character's class or profession.
     */
    public Character(String name, String characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        attributes = new ArrayList<>();
        for(int i=0; i<6; i++) {
            attributes.add(10);
        }

        spells = new ArrayList<>();
        for(int i=0; i<3; i++) {
            spells.add(new Spell(i+1, 0));
        }
    }

    @Override
    public String toString() {
        return name + ", " + characterClass;
    }
}

