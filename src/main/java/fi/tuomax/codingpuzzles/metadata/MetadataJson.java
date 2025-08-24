package fi.tuomax.codingpuzzles.metadata;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class MetadataJson 
{

    private Map<String, Site> sites = new HashMap<>();

    public Site getSite(String id) 
    {
        return sites.get(id);
    }

    public void addSite(Site event)
    {
        sites.put(event.getId(), event);
    }

    public static MetadataJson fromJson(JSONObject json)
    {
        MetadataJson metadata = new MetadataJson();
        JSONArray jsonSites = json.getJSONArray("sites");
        Integer numOfSites = jsonSites.length();
        for (int i = 0; i < numOfSites; i++) {
            metadata.addSite(Site.fromJson(jsonSites.getJSONObject(i)));
        }
        return metadata;
    }

}