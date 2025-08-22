package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

public record EniParams(
    Long a,
    Long b,
    Long c,
    Long x,
    Long y,
    Long z,
    Long m
) {
    
    public static EniParams fromEcInput(String line)
    {
        String[] parts = line.split(" |=");
        return new EniParams(
            Long.valueOf(parts[1]),
            Long.valueOf(parts[3]),
            Long.valueOf(parts[5]),
            Long.valueOf(parts[7]),
            Long.valueOf(parts[9]),
            Long.valueOf(parts[11]),
            Long.valueOf(parts[13])
        );
    }

}
