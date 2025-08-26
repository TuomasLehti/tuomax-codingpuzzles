package fi.tuomax.codingpuzzles.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Part> getParts()
    {
        return parts;
    }

    private Map<String, TestCase> testCases = new HashMap<>();

    public void addTest(TestCase testcase)
    {
        testCases.put(testcase.name(), testcase);
    }

    public TestCase getTest(String testName)
    {
        return testCases.get(testName);
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

        JSONArray jsonTests = jsonDay.getJSONArray("tests");
        Integer numOfTests = jsonTests.length();
        for (int i = 0; i < numOfTests; i++) {
            day.addTest(TestCase.fromJson(jsonTests.getJSONObject(i)));
        }

        return day;
    }

    
}