package css.cis3334.project;
import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class SpellsConverter {
    @TypeConverter
    public static String fromArrayList(ArrayList<Spell> list) {
        if (list == null) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Spell>>() {}.getType();
        return gson.toJson(list, type);
    }

    @TypeConverter
    public static ArrayList<Spell> toArrayList(String json) {
        if (json == null) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Spell>>() {}.getType();
        return gson.fromJson(json, type);
    }
}

