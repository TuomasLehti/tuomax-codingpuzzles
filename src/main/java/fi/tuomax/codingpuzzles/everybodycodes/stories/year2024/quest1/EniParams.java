package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

public record EniParams(
    Integer a,
    Integer b,
    Integer c,
    Integer x,
    Integer y,
    Integer z,
    Integer m
) {
    
    public static EniParams fromEcInput(String line)
    {
        String[] parts = line.split(" |=");
        return new EniParams(
            Integer.valueOf(parts[1]),
            Integer.valueOf(parts[3]),
            Integer.valueOf(parts[5]),
            Integer.valueOf(parts[7]),
            Integer.valueOf(parts[9]),
            Integer.valueOf(parts[11]),
            Integer.valueOf(parts[13])
        );
    }

}
