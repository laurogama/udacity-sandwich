package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {

            Sandwich sandwich = new Sandwich();
            JSONObject jsonO = new JSONObject(json);
            JSONObject name = jsonO.getJSONObject("name");
            sandwich.setMainName(name.getString("mainName"));
            sandwich.setPlaceOfOrigin(jsonO.getString("placeOfOrigin"));
            sandwich.setAlsoKnownAs(parseJsonArray(name.getJSONArray("alsoKnownAs")));
            sandwich.setDescription(jsonO.getString("description"));
            sandwich.setImage(jsonO.getString("image"));
            sandwich.setIngredients(parseJsonArray(jsonO.getJSONArray("ingredients")));

            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> parseJsonArray(JSONArray array) {
        List<String> strings = new ArrayList<>();
        try {
            for (int i = 0; i < array.length(); i++) {
                strings.add(array.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
