package fi.tuomax.codingpuzzles.everybodycodes.setuphelpers;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class SetupEcYear 
{

    private static String clazzPath = "";

    private static Integer year;

    private static Integer day;

    private static String workingDir = "";



    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        workingDir = System.getProperty("user.dir");

        System.out.println("Everybody Codes Setup Wizard v. 1.0");
        System.out.println("");

        System.out.print("Year> ");
        year = scanner.nextInt();

        System.out.print("Quest> ");
        day = scanner.nextInt();

        clazzPath = String.format(
            "fi.tuomax.codingpuzzles.everybodycodes.events.year%d.quest%d",
            year, day
        );

        createInputDir();
        createSourceDir();
        createTestDir();

        scanner.close();
    }

    private static void createInputDir() 
    {
        File inputDir = new File(getInputDir());
        if (inputDir.exists()) {
            System.out.println("Input directory already exists.");
        } else {
            inputDir.mkdirs();
            System.out.println("Input directory created.");
        }
    }

    private static String getInputDir()
    {
        return Path.of(
            workingDir, 
            "inputs", 
            "everybodycodes", 
            "events", 
            String.format("year%d", year),
            String.format("quest%d", day)
        ).toString();
    }

    private static void createSourceDir() 
    {
        File sourceDir = new File(getSourceDir());
        if (sourceDir.exists()) {
            System.out.println("Source directory already exists.");
        } else {
            sourceDir.mkdirs();
            System.out.println("Source directory created.");
        }
    }

    private static String getSourceDir()
    {
        return Path.of(
            workingDir, 
            "src", 
            "main", 
            "java", 
            "fi",
            "tuomax",
            "codingpuzzles",
            "everybodycodes",
            "events",
            String.format("year%d", year),
            String.format("quest%d", day)
        ).toString();
    }

    private static void createTestDir() 
    {
        File sourceDir = new File(getTestDir());
        if (sourceDir.exists()) {
            System.out.println("Test source directory already exists.");
        } else {
            sourceDir.mkdirs();
            System.out.println("Test source directory created.");
        }
    }

    private static String getTestDir()
    {
        return Path.of(
            workingDir, 
            "src", 
            "test", 
            "java", 
            "fi",
            "tuomax",
            "codingpuzzles",
            "everybodycodes",
            "events",
            String.format("year%d", year),
            String.format("quest%d", day)
        ).toString();
    }
    
}
