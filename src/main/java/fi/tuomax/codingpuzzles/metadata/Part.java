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

    public static Part fromJsonArray(JSONObject jsonObject) 
    {
        Part part = new Part();
        part.id = jsonObject.getInt("part");
        part.inputFilename = jsonObject.getString("inputFilename");
        part.expectedAnswer = jsonObject.getString("expectedAnswer");
        return part;
    }

}
