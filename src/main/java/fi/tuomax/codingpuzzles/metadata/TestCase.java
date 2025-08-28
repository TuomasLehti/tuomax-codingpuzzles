package fi.tuomax.codingpuzzles.metadata;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public record TestCase(
    String name,
    List<String> input,
    String expectedAnswer,
    JSONObject jsonTest
) {

    public static TestCase fromJson(JSONObject jsonTest)
    {
        List<String> input = null;
        try {
            input = Files.readAllLines(new File(jsonTest.getString("inputFilename")).toPath());
        } catch (JSONException | IOException e) {
            input = new ArrayList<>();
        }
        return new TestCase(
            jsonTest.getString("name"),
            input,
            jsonTest.getString("expectedAnswer"),
            jsonTest
        );
    }

}
