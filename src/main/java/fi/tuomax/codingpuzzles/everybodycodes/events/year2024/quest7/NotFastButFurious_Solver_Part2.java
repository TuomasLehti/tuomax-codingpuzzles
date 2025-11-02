package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.tuomax.codingpuzzles.framework.Solver;

public class NotFastButFurious_Solver_Part2
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Plan> plans = parse(input);
        String track = parseTrack(trackInput);

        for (Plan plan : plans) {
            System.out.println(plan.loop(track, 10));
        }

        Collections.sort(plans, new Comparator<Plan>(){
            @Override
            public int compare(Plan o1, Plan o2) {
                return o2.loop(track, 10).compareTo(o1.loop(track, 10));
            }
        });
        String ans = "";
        for (Plan plan : plans) {
            ans += plan.getId();
        }
        setAnswer(ans);
    }

    private List<Plan> parse(List<String> input)
    {
        List<Plan> plans = new ArrayList<>();
        for (String line : input)
            plans.add(new Plan(line));
        return plans;
    }

    /* TODO: extract common functionality with part 3 */

    public String parseTrack(String[] trackInput)
    {
        Map<Vector, Character> segments = new HashMap<>();
        long rNum = 0;
        long cNum = 0;
        for (String row : trackInput) {
            for (Character col : row.toCharArray()) {
                if (col != ' ') {
                    segments.put(new Vector(cNum, rNum), col);
                }
                cNum++;
            }
            cNum = 0;
            rNum++;
        }

        StringBuilder track = new StringBuilder("S");
        segments.remove(new Vector(0, 0));
        Vector pos = new Vector(1, 0);
        while (segments.size() > 0) {
            track.append(segments.get(pos));
            segments.remove(pos);
            if (segments.containsKey(new Vector(pos.x() + 1, pos.y()))) {
                pos = new Vector(pos.x() + 1, pos.y());
            } else if (segments.containsKey(new Vector(pos.x() - 1, pos.y()))) {
                pos = new Vector(pos.x() - 1, pos.y());
            } else if (segments.containsKey(new Vector(pos.x(), pos.y() + 1))) {
                pos = new Vector(pos.x(), pos.y() + 1);
            } else if (segments.containsKey(new Vector(pos.x(), pos.y() - 1))) {
                pos = new Vector(pos.x(), pos.y() - 1);
            } 
        }

        return track.toString();
    }

    private String[] trackInput = new String[]{
        "S-=++=-==++=++=-=+=-=+=+=--=-=++=-==++=-+=-=+=-=+=+=++=-+==++=++=-=-=--",
        "-                                                                     -",
        "=                                                                     =",
        "+                                                                     +",
        "=                                                                     +",
        "+                                                                     =",
        "=                                                                     =",
        "-                                                                     -",
        "--==++++==+=+++-=+=-=+=-+-=+-=+-=+=-=+=--=+++=++=+++==++==--=+=++==+++-",
    };


}
