package fi.tuomax.codingpuzzles.framework;

import java.util.List;

import org.json.JSONObject;

/**
 * A base class for a solver.
 */
public abstract class Solver 
{

    private String answer = "";

    protected JSONObject jsonMetadata;

    public void setJsonMetadata(JSONObject metadata) 
    {
        this.jsonMetadata = metadata;
    }

    protected void setAnswer(String answer)
    {
        this.answer = answer;
    }

    protected void setAnswer(Number answer)
    {
        this.answer = answer.toString();
    }

    public String getAnswer()
    {
        return answer;
    }

    public abstract void solve(List<String> input);
    
}
