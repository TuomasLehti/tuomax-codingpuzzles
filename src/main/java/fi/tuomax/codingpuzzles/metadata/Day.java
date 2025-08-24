package fi.tuomax.codingpuzzles.metadata;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Day 
{

    private Integer id;

    public Integer getId() 
    {
        return id;
    }

    private String name;

    public String getName() 
    {
        return name;
    }

    private List<Part> parts = new ArrayList<>();

    public Part getPart(Integer id)
    {
        return parts.get(id);
    }

    public void addPart(Part part) 
    {
        parts.add(part);
    }

    public static Day fromJson(JSONObject jsonDay) 
    {
        Day day = new Day();

        day.id = jsonDay.getInt("day");
        day.name = jsonDay.getString("name");

        JSONArray jsonParts = jsonDay.getJSONArray("parts");
        Integer numOfParts = jsonParts.length();
        for (int i = 0; i < numOfParts; i++) {
            day.addPart(Part.fromJsonArray(jsonParts.getJSONObject(i)));
        }

        return day;
    }

    
}