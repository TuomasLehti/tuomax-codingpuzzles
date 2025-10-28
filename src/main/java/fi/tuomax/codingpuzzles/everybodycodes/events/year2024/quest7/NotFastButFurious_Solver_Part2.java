package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public String parseTrack(String[] trackInput)
    {
        StringBuilder trk = new StringBuilder(trackInput[0]);
        for (int row = 1; row < trackInput.length - 1; row++) {
            trk.append(trackInput[row].charAt(trackInput[row].length() - 1));
        }
        trk.append(new StringBuilder(trackInput[trackInput.length - 1]).reverse());
        for (int row = trackInput.length - 2; row >= 1; row--) {
            trk.append(trackInput[row].charAt(0));
        }
        return trk.toString();
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
