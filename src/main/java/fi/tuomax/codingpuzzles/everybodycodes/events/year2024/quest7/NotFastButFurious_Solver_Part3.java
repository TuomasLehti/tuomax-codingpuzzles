package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.tuomax.codingpuzzles.framework.Solver;

public class NotFastButFurious_Solver_Part3
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        Plan plan = new Plan(input.get(0));
        track = parseTrack(trackInput);
        rival = plan.loop(track, 2024);
        combinations(5, 3, 3, new StringBuilder());
        setAnswer(ans.toString());
    }

    Integer rival;
    Integer ans = 0;
    String track;

    int r = 0;

    public void combinations(int pluses, int minuses, int equalses, StringBuilder current)
    {
        if (pluses == 0 && minuses == 0 && equalses == 0) {
            race(current);
            r++;
            if (r % 100 == 0) System.out.println(r);
            return;
        }
        if (pluses > 0) {
            current.append("+,");
            combinations(pluses - 1, minuses, equalses, current);
            current.deleteCharAt(current.length() - 1);
            current.deleteCharAt(current.length() - 1);
        }
        if (minuses > 0) {
            current.append("-,");
            combinations(pluses, minuses - 1, equalses, current);
            current.deleteCharAt(current.length() - 1);
            current.deleteCharAt(current.length() - 1);
        }
        if (equalses > 0) {
            current.append("=,");
            combinations(pluses, minuses, equalses - 1, current);
            current.deleteCharAt(current.length() - 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    private void race(StringBuilder current)
    {
        String s = current.toString();
        s = "X:" + s.substring(0, s.length() - 1);
        Plan plan = new Plan(s);
        if (plan.loop(track, 2024) > rival) ans++;
    }

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
        "S+= +=-== +=++=     =+=+=--=    =-= ++=     +=-  =+=++=-+==+ =++=-=-=--",
        "- + +   + =   =     =      =   == = - -     - =  =         =-=        -",
        "= + + +-- =-= ==-==-= --++ +  == == = +     - =  =    ==++=    =++=-=++",
        "+ + + =     +         =  + + == == ++ =     = =  ==   =   = =++=       ",
        "= = + + +== +==     =++ == =+=  =  +  +==-=++ =   =++ --= + =          ",
        "+ ==- = + =   = =+= =   =       ++--          +     =   = = =--= ==++==",
        "=     ==- ==+-- = = = ++= +=--      ==+ ==--= +--+=-= ==- ==   =+=    =",
        "-               = = = =   +  +  ==+ = = +   =        ++    =          -",
        "-               = + + =   +  -  = + = = +   =        +     =          -",
        "--==++++==+=+++-= =-= =-+-=  =+-= =-= =--   +=++=+++==     -=+=++==+++-",
    };


}
