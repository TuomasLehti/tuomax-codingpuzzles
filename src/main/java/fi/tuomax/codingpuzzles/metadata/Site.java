package fi.tuomax.codingpuzzles.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Site is a programming puzzle site (Advent of Code, Everybody Codes).
 * Each site holds events, and event indexing may be year-based, which
 * is why this class uses a map instead of an array.
 */
public class Site 
{

    public static final String ID_ECS = "everybodyCodesStories";

    private String id;

    public String getId() 
    {
        return id;
    }

    private String name;

    public String getName() 
    {
        return name;
    }

    private Map<Integer, Event> events = new HashMap<>();

    public void addEvent(Event event)
    {
        events.put(event.getId(), event);
    }

    public Event getEvent(Integer id)
    {
        return events.get(id);
    }

    public List<Integer> getEventIds()
    {
        List<Integer> eventIds = new ArrayList<>(events.keySet());
        Collections.sort(eventIds);
        return eventIds;
    }

    public static Site fromJson(JSONObject jsonSite) 
    {
        Site event = new Site();
        
        event.id = jsonSite.getString("site");
        event.name = jsonSite.getString("name");

        JSONArray jsonEvents = jsonSite.getJSONArray("events");
        Integer numOfEvents = jsonEvents.length();
        for (int i = 0; i < numOfEvents; i++) {
            event.addEvent(Event.fromJson(jsonEvents.getJSONObject(i)));
        }

        return event;
    }
    
}
