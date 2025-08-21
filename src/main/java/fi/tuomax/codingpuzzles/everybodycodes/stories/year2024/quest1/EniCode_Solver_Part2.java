package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import fi.tuomax.codingpuzzles.metadata.Metadata;

public class EniCode_Solver_Part2
{

    public String eni(Long n, Long exp, Long mod)
    {
        Long accumulator = 1L;
        Long remainder = 1L;
        List<Long> remainders = new ArrayList<>();
        for (int i = 0; i < exp; i++) {
            remainder = (remainder * n) % mod;
            if (remainders.contains(remainder)) {
                break;
            }
            remainders.add(remainder);
        }
        StringBuilder sb = new StringBuilder();

        long fromIdx = Math.max(0, exp - 5);
        long toIdx = exp - 1;

        for (long idx = toIdx; idx >= fromIdx; idx--) {
            sb.append(getTerm(remainders, idx).toString());
        }
        return sb.toString();
    }

    public Long getTerm(List<Long> longs, long idx)
    {
        if (idx < longs.size()) {
            return longs.get((int) idx % Integer.MAX_VALUE);
        }
        long numOfWholeCycles = idx / longs.size();
        long firstIdxOfUncompleteCycle = numOfWholeCycles * longs.size();
        long idxToCycle = idx - firstIdxOfUncompleteCycle;
        return longs.get((int) idxToCycle % Integer.MAX_VALUE);
    }

    public Long summedEni(Long a, Long b, Long c, Long x, Long y, Long z, Long m)
    {
        return Long.valueOf(eni(a, x, m)) + Long.valueOf(eni(b, y, m)) + Long.valueOf(eni(c, z, m));
    }

    public Long solve(Metadata metadata) 
    throws IOException
    {
        List<String> input = metadata.getInput("everybodyCodesStories", 2024, 1, 2);
        Long answer = Long.MIN_VALUE;
        for (String line : input) {
            String[] parts = line.split(" |=");
            Long sum = summedEni(
                Long.valueOf(parts[1]),
                Long.valueOf(parts[3]),
                Long.valueOf(parts[5]),
                Long.valueOf(parts[7]),
                Long.valueOf(parts[9]),
                Long.valueOf(parts[11]),
                Long.valueOf(parts[13])
            );
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    
}
