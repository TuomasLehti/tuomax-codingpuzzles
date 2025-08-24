package fi.tuomax.codingpuzzles.framework;

import java.util.List;

/**
 * A base class for a solver.
 */
public abstract class Solver 
{

    private String answer = "";

    protected void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getAnswer()
    {
        return answer;
    }

    public abstract void solve(List<String> input);
    
}
