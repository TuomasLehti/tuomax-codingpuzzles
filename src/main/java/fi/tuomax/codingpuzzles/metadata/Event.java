package fi.tuomax.codingpuzzles.metadata;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * An event is a single happening on a site. They are usually yearly, but 
 * events may also be held more often. An event usually contains multiple
 * days. 
 */
public class Event 
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

    private List<Day> days = new ArrayList<>();

    public Day getDay(Integer id)
    {
        return days.get(id);
    }

    public void addDay(Day day)
    {
        days.add(day);
    }

    public List<Day> getDays() 
    {
        return days;
    }

    public static Event fromJson(JSONObject jsonEvent) 
    {
        Event event = new Event();

        event.id = jsonEvent.getInt("event");
        event.name = jsonEvent.getString("name");

        JSONArray jsonDays = jsonEvent.getJSONArray("days");
        Integer numOfDays = jsonDays.length();
        for (int i = 0; i < numOfDays; i++) {
            event.addDay(Day.fromJson(jsonDays.getJSONObject(i)));
        }

        return event;
    }

    
    
}
