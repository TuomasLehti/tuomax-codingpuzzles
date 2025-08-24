package fi.tuomax.codingpuzzles.metadata;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class Test_Metadata 
{

    @Test
    public void test_Metadata()
    {
        try {
            MetadataJson metadata = MetadataJson.fromJson(
                new JSONObject(Files.readString(new File("new_metadata.json").toPath()))
            );
            System.out.println();
        } catch (JSONException | IOException e) {
            fail(e.getMessage());
        }
    }
    
}
