package fi.tuomax.codingpuzzles.metadata;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Metadata 
{

    private JSONObject metadata;

    public Metadata()
    {
        try {
            metadata = new JSONObject(Files.readString(new File("metadata.json").toPath()));
        } catch (JSONException e) {
            System.out.println("Malformed metadata.");
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("File most likely not found.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public List<String> getInput(String event, Integer year, Integer day, Integer part) 
    throws JSONException, IOException
    {
        JSONObject eventObj = getEventObj(event);
        JSONObject yearObj = getYearObj(eventObj, year);
        JSONObject dayObj = getDayObj(yearObj, day);
        JSONObject partObj = getPartObj(dayObj, part);
        return Files.readAllLines(new File(partObj.getString("inputFilename")).toPath());
    }

    public TestCase getTestCase(String event, Integer year, Integer day, String testname)
    throws JSONException, IOException
    {
        JSONObject eventObj = getEventObj(event);
        JSONObject yearObj = getYearObj(eventObj, year);
        JSONObject dayObj = getDayObj(yearObj, day);
        JSONObject partObj = getTestCaseObj(dayObj, testname);
        return new TestCase(
            Files.readAllLines(new File(partObj.getString("inputFilename")).toPath()),
            partObj.getString("expectedAnswer")
        );
    }

    private JSONObject getTestCaseObj(JSONObject dayObj, String testname) 
    {
        JSONArray testArr = dayObj.getJSONArray("tests");
        Integer numOfTests = testArr.length();
        for (int testIdx = 0; testIdx < numOfTests; testIdx++) {
            JSONObject testObj = testArr.getJSONObject(testIdx);
            if (testname.equals(testObj.getString("name"))) {
                return testObj;
            }
        }
        throw new IllegalArgumentException(String.format("Test %s not found.", testname));
    }

    private JSONObject getPartObj(JSONObject dayObj, Integer part) 
    {
        JSONArray partArr = dayObj.getJSONArray("parts");
        Integer numOfParts = partArr.length();
        for (int partIdx = 0; partIdx < numOfParts; partIdx++) {
            JSONObject partObj = partArr.getJSONObject(partIdx);
            if (part.equals(partObj.getInt("part"))) {
                return partObj;
            }
        }
        throw new IllegalArgumentException(String.format("Part %d not found.", part));
    }

    private JSONObject getDayObj(JSONObject yearObj, Integer day) 
    {
        JSONArray dayArr = yearObj.getJSONArray("days");
        Integer numOfdays = dayArr.length();
        for (int dayIdx = 0; dayIdx < numOfdays; dayIdx++) {
            JSONObject dayObj = dayArr.getJSONObject(dayIdx);
            if (day.equals(dayObj.getInt("day"))) {
                return dayObj;
            }
        }
        throw new IllegalArgumentException(String.format("Day %d not found.", day));
    }


    private JSONObject getYearObj(JSONObject eventObj, Integer year) 
    {
        JSONArray yearArr = eventObj.getJSONArray("years");
        Integer numOfYears = yearArr.length();
        for (int yearIdx = 0; yearIdx < numOfYears; yearIdx++) {
            JSONObject yearObj = yearArr.getJSONObject(yearIdx);
            if (year.equals(yearObj.getInt("year"))) {
                return yearObj;
            }
        }
        throw new IllegalArgumentException(String.format("Year %d not found.", year));
    }

    public JSONObject getEventObj(String event)
    {
        JSONArray eventArr = metadata.getJSONArray("events");
        Integer numOfEcents = eventArr.length();
        for (int eventIdx = 0; eventIdx < numOfEcents; eventIdx++) {
            JSONObject eventObj = eventArr.getJSONObject(eventIdx);
            if (eventObj.getString("event").equals(event)) {
                return eventObj;
            }
        }
        throw new IllegalArgumentException(String.format("Event %s not found.", event));
    }
    
}
