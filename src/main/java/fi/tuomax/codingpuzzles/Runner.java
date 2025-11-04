package fi.tuomax.codingpuzzles;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import fi.tuomax.codingpuzzles.framework.Solver;
import fi.tuomax.codingpuzzles.metadata.Day;
import fi.tuomax.codingpuzzles.metadata.Event;
import fi.tuomax.codingpuzzles.metadata.Metadata;
import fi.tuomax.codingpuzzles.metadata.Part;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Runner 
{

    public void run()
    {
        Metadata metadata = readMetadata();
//        runPart(metadata.getSite(Site.ID_EC).getEvent(2025).getDay(0).getPart(2));
        runDay(metadata.getSite(Site.ID_EC).getEvent(2025).getDay(0));
//        runEvent(metadata.getSite(Site.ID_EC).getEvent(2024));
//        runSite(metadata.getSite(Site.ID_ECS));
    }

    public void runSite(Site site)
    {
        System.out.print(site.getName());
        for (Integer eventId : site.getEventIds()) {
            runEvent(site.getEvent(eventId));
        }
    }

    public void runEvent(Event event)
    {
        System.out.println("Event " + event.getId() + ": " + event.getName());
        for (Day day : event.getDays()) {
            runDay(day);
        }       
    }

    public void runDay(Day day)
    {
        System.out.println("Day " + day.getId() + ": " + day.getName());
        for (Part part : day.getParts()) {
            runPart(part);
        }
    }

    public void runPart(Part part)
    {
        List<String> input = readInput(part);
        Solver solver = null;
        try {
            Class<?> solverClass = getClass().getClassLoader().loadClass(part.getSolverClassName());
            solver = (Solver) solverClass.getDeclaredConstructor().newInstance();
            solver.setJsonMetadata(part.getJsonPart());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException | NoSuchMethodException e) {
            System.out.println("Unable to create a solver.");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        solver.solve(input);
        System.out.print("Part " + part.getId() + ": " + solver.getAnswer());
        System.out.println(solver.getAnswer().equals(part.getExpectedAnswer()) ? " (right)" : " (wrong)");
    }

    public Metadata readMetadata()
    {
        try {
            return Metadata.fromJson(
                new JSONObject(Files.readString(new File("metadata.json").toPath()))
            );
        } catch (JSONException | IOException e) {
            System.out.println("Unable to read metadata.");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return null; // unreachable but required
    }

    public List<String> readInput(Part part)
    {
        try {
            return Files.readAllLines(new File(part.getInputFilename()).toPath());
        } catch (IOException e) {
            System.out.println("Unable to read input.");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return null; // unreachable but required
    }
    
    public static void main(String[] args)
    {
        Runner runner = new Runner();
        runner.run();
    }
    
}

