package gson;

import com.google.gson.*;
import gson.Constants;

import java.lang.reflect.Type;

import static gson.Constants.CLASSNAME;
import static gson.Constants.INSTANCE;


public class Deserializer<T> implements JsonDeserializer<T> {
    public Deserializer() {
    }

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        String className = prim.getAsString();
        Class<?> clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e);
        }
        return context.deserialize(jsonObject.get(INSTANCE), clazz);
    }
}