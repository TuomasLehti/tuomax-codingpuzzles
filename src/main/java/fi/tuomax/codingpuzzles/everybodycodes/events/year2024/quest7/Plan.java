package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest7;

public class Plan 
{

    private String id;

    public String getId() 
    {
        return id;
    }

    private String[] actions;

    public Plan(String ecInput) 
    {
        String[] parts = ecInput.split(":");
        id = parts[0];
        actions = parts[1].split(",");
    }

    public Integer race(Integer numOfSegments)
    {
        Integer power = 10;
        Integer essence = 0;
        for (int segment = 0; segment < numOfSegments; segment++) {
            String action = actions[segment % actions.length];
            if (action.equals("+")) {
                power++;
            } else if (action.equals("-") && power > 0) {
                power--;
            }
            essence += power;
        }
        return essence;
    }

    public Integer loop(String track, Integer numOfLoops)
    {
        String trackActions = track.repeat(numOfLoops).substring(1) + 'S';

        Integer power = 10;
        Integer essence = 0;

        for (int pos = 0; pos < trackActions.length(); pos++) {
            if (trackActions.charAt(pos) == '+') {
                power++;
            } else if (trackActions.charAt(pos) == '-') {
                power--;
            } else {
                String action = actions[pos % actions.length];
                if (action.equals("+")) {
                    power++;
                } else if (action.equals("-") && power > 0) {
                    power--;
                }
            }
            essence += power;
        }
        return essence;
    }
        
}
