package css.cis3334.project;
import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class AttributeListConverter {
    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Integer> fromString(String value) {
        Type listType = new TypeToken<List<Integer>>() {}.getType();
        return gson.fromJson(value, listType);
    }

    @TypeConverter
    public static String toString(List<Integer> list) {
        return gson.toJson(list);
    }
}
