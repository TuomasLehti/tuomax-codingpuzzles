package fi.tuomax.codingpuzzles.everybodycodes.stories.story2.quest1;

import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class NailDownYourLuck_Solver_Part1
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        SlotMachine machine = new SlotMachine(input);

        while (!input.get(0).isEmpty()) input.remove(0);
        input.remove(0);

        Long startSlot = 1L;
        Long answer = 0L;
        for (String line : input)
        {
            Long prize = machine.dropCoin(line, startSlot);
            if (prize > 0) {
                answer += prize;
            }
            startSlot++;
        }
        setAnswer(answer.toString());
    }
    
}
