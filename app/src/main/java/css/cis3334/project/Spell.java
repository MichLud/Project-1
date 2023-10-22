package css.cis3334.project;

/**
 * Represents a certain level of spells and the max allowed for the character
 */
public class Spell {
    public int spellLevel, spellMax;

    /**
     * Constructs a Spell with the specified name and spell level.
     *
     * @param level The level of the spell.
     * @param spellMax The maximum slots for that level
     */
    public Spell(int level, int spellMax) {
        this.spellLevel = level;
        this.spellMax = spellMax;
    }
}
