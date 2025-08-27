package fi.tuomax.codingpuzzles.everybodycodes.stories.story2.quest1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fi.tuomax.codingpuzzles.framework.Solver;

public class NailDownYourLuck_Solver_Part3
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        machine = new SlotMachine(input);

        Set<Long> slots = new HashSet<>();
        for (long i = machine.numOfSlots(); i > 0; i--) {
            slots.add(i);
        }

        while (!input.get(0).isEmpty()) input.remove(0);
        input.remove(0);
        coins = input;

        String slotStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(0, (int) (machine.numOfSlots() % Integer.MAX_VALUE));
        combs(
            new StringBuilder(slotStr),
            (long) coins.size(),
            new StringBuilder()
        );
//        System.out.println(s);

        setAnswer(minScore + " " + maxScore);
    }

    public List<String> coins;

    public Long maxScore = Long.MIN_VALUE;

    public Long minScore = Long.MAX_VALUE;

    private SlotMachine machine;

    public void playGame(String slots)
    {
        Long score = 0L;
        for (int i = 0; i < coins.size(); i++) {
            String coin = coins.get(i);
            Long slot = (long) (slots.charAt(i) - 'A') + 1;
            score += machine.dropCoin(coin, slot);
        }
        maxScore = Math.max(maxScore, score);
        minScore = Math.min(minScore, score);
    }

    private Long s = 0L;

    public void combs(StringBuilder slots, Long numOfCoins, StringBuilder current)
    {
        if (numOfCoins == 0) {
            playGame(current.toString());
            s++;
//            if (s % 1_000_000 == 0) System.out.println(s);
        } else {
            for (int i = 0; i < slots.length(); i++) {
                current.append(slots.charAt(i));
                slots.delete(i, i + 1);
                combs(slots, numOfCoins - 1, current);
                slots.insert(i, current.substring(current.length() - 1));
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
    
}
