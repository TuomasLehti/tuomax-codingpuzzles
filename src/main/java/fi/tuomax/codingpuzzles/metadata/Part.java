package fi.tuomax.codingpuzzles.metadata;

import org.json.JSONObject;

public class Part {

    private Integer id;

    public Integer getId() 
    {
        return id;
    }

    private String inputFilename;

    public String getInputFilename() 
    {
        return inputFilename;
    }

    private String expectedAnswer;

    public String getExpectedAnswer() 
    {
        return expectedAnswer;
    }

    private String solverClassName;

    public String getSolverClassName() 
    {
        return solverClassName;
    }

    private JSONObject jsonPart;

    public JSONObject getJsonPart() 
    {
        return jsonPart;
    }


    public static Part fromJsonArray(JSONObject jsonObject) 
    {
        Part part = new Part();
        part.id = jsonObject.getInt("part");
        part.inputFilename = jsonObject.getString("inputFilename");
        part.expectedAnswer = jsonObject.getString("expectedAnswer");
        part.solverClassName = jsonObject.optString("solverClassName", "");
        part.jsonPart = jsonObject;
        return part;
    }

}
