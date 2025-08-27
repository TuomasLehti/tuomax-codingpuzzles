package fi.tuomax.codingpuzzles.everybodycodes.stories.story2.quest1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlotMachine 
{

    private Set<Coords2d> nails = new HashSet<>();

    private Long width;

    private Long height;

    public SlotMachine(List<String> input)
    {
        Long col = 0L;
        Long row = 0L;
        for (String line : input) {
            if (line.isEmpty()) break;
            width = (long) line.length(); // done multiple times but doesn't matter
            for (Character c : line.toCharArray()) {
                if (c == '*') {
                    nails.add(new Coords2d(col, row));
                }
                col++;
            }
            row++;
            col = 0L;
        }
        height = row;
        numOfSlots = (width + 1) / 2;
    }

    private Long numOfSlots;

    public Long numOfSlots()
    {
        return numOfSlots;
    }
    
    private Map<SlotGame, Long> scores = new HashMap<>();

    public Long dropCoin(String behaviours, Long startSlot)
    {
        SlotGame game = new SlotGame(startSlot, behaviours);
        if (!scores.containsKey(game)) {
            Coords2d coinPos = new Coords2d((startSlot - 1) * 2, -1L);
            Integer behaviourIdx = 0;

            while (coinPos.y() < height) {
                coinPos = new Coords2d(coinPos.x(), coinPos.y() + 1);
                if (nails.contains(coinPos)) {
                    if (behaviours.charAt(behaviourIdx) == 'L') {
                        if (coinPos.x() > 0) {
                            coinPos = new Coords2d(coinPos.x() - 1, coinPos.y());
                        } else {
                            coinPos = new Coords2d(coinPos.x() + 1, coinPos.y());
                        }
                    } else {
                        if (coinPos.x() < (width - 1)) {
                            coinPos = new Coords2d(coinPos.x() + 1, coinPos.y());
                        } else {
                            coinPos = new Coords2d(coinPos.x() - 1, coinPos.y());
                        }
                    }
                    behaviourIdx++;
                }
            }

            Long endSlot = coinPos.x() / 2 + 1;
            Long score = endSlot * 2 - startSlot;
            scores.put(game, Math.max(0, score));
        }
        return scores.get(game);

    }
        
}
