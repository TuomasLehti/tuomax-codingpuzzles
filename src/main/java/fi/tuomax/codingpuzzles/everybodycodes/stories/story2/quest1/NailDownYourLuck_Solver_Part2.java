package fi.tuomax.codingpuzzles.everybodycodes.stories.story2.quest1;

import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class NailDownYourLuck_Solver_Part2
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        SlotMachine machine = new SlotMachine(input);

        while (!input.get(0).isEmpty()) input.remove(0);
        input.remove(0);

        Long answer = 0L;
        for (String line : input)
        {
            Long prize = 0L;
            for (long startSlot = 1; startSlot < 14; startSlot++) {
                prize = Math.max(prize, machine.dropCoin(line, startSlot));
            }
            answer += prize;
        }
        setAnswer(answer.toString());
    }
    
}
