package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class EniCode_Solver_Part1 
{

    public String eni(Integer n, Integer exp, Integer mod)
    {
        Long accumulator = 1L;
        List<Long> remainders = new ArrayList<>();
        for (int i = 0; i < exp; i++) {
            accumulator *= n;
            remainders.add(accumulator % mod);
        }
        StringBuilder sb = new StringBuilder();
        for (int idx = remainders.size() - 1; idx >= 0; idx--) {
            sb.append(remainders.get(idx).toString());
        }
        return sb.toString();
    }

    public Long summedEni(Integer a, Integer b, Integer c, Integer x, Integer y, Integer z, Integer m)
    {
        return Long.valueOf(eni(a, x, m)) + Long.valueOf(eni(b, y, m)) + Long.valueOf(eni(c, z, m));
    }

    public Long solve() 
    throws IOException
    {
        List<String> input = Files.readAllLines(new File("inputs\\everybodycodes\\stories\\year2024\\quest1\\ecs-2024-1-input.txt").toPath());
        Long answer = Long.MIN_VALUE;
        for (String line : input) {
            String[] parts = line.split(" |=");
            Long sum = summedEni(
                Integer.valueOf(parts[1]),
                Integer.valueOf(parts[3]),
                Integer.valueOf(parts[5]),
                Integer.valueOf(parts[7]),
                Integer.valueOf(parts[9]),
                Integer.valueOf(parts[11]),
                Integer.valueOf(parts[13])
            );
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    
}
