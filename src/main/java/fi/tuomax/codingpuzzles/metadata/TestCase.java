package fi.tuomax.codingpuzzles.metadata;

import java.util.List;

public record TestCase(
    List<String> input,
    String expectedAnswer
) {}
