package fi.tuomax.codingpuzzles.everybodycodes.setuphelpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class SetupEcYear 
{

    private static String clazzPath = "";

    private static Integer year;

    private static Integer day;

    private static String name;

    private static String namePascalCase;

    private static String workingDir = "";



    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        workingDir = System.getProperty("user.dir");

        System.out.println("Everybody Codes Setup Wizard v. 1.0");
        System.out.println("");

        System.out.print("Year> ");
        year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Quest> ");
        day = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name> ");
        name = scanner.nextLine();

        clazzPath = String.format(
            "fi.tuomax.codingpuzzles.everybodycodes.events.year%d.quest%d",
            year, day
        );

        pascalizeName();
        createInputDir();
        createSourceDir();
        createSolver(1);
        createSolver(2);
        createSolver(3);
        createTestDir();

        scanner.close();
    }

    private static void pascalizeName()
    {
        String[] parts = name.split(" |-");
        StringBuilder pascalized = new StringBuilder();
        for (String part : parts) {
            pascalized.append(part.substring(0, 1).toUpperCase());
            pascalized.append(part.substring(1).toLowerCase());
        }
        namePascalCase = pascalized.toString();
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

    private static void createSolver(Integer part)
    {
        Path solverSrc = Path.of(
            getSourceDir(),
            String.format("%s_Solver_Part%d.java", namePascalCase, part)
        );
        String[] lines = new String[]{
            "package " + clazzPath + ";",
            "",
            "import fi.tuomax.codingpuzzles.framework.Solver;",
            "",
            "public class " + namePascalCase + "_Solver_Part" + part,
            "extends Solver",
            "{",
            "",
            "    @Override",
            "    public void solve(List<String> input) ",
            "    {",
            "    }",
            "    ",
            "}",
        };
        FileWriter writer = null;
        try {
            writer = new FileWriter(solverSrc.toFile());
            for (String line : lines) {
                writer.write(line);
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to write to " + solverSrc.toString() + ".");
        } 
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
