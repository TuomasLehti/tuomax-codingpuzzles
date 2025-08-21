package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import fi.tuomax.codingpuzzles.metadata.Metadata;

public class EniCode_Solver_Part3
{

    public String eni(Long n, Long exp, Long mod)
    {
        Long accumulator = 1L;
        Long remainder = 1L;
        List<Long> remainders = new ArrayList<>();
        for (int i = 0; i < exp; i++) {
            remainder = (remainder * n) % mod;
            if (remainders.contains(remainder)) {
                remainders.add(remainder);
                break;
            }
            remainders.add(remainder);
        }

        return Long.toString(sumTerms(remainders, exp));
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

    public long sumTerms(List<Long> longs, long idx)
    {
        long firstRepeatingLong = longs.get(longs.size() - 1);
        longs.remove(longs.size() - 1);

        int introLength = longs.indexOf(firstRepeatingLong);
        long cycleLength = longs.size() - introLength;

        int firstIndexOfCycle = introLength;
        long lastIndexOfCycle = firstIndexOfCycle + cycleLength - 1;

        long numOfWholeCycles = (idx - introLength) / cycleLength;

        long firstIndexOfIncompleteCycle = introLength + numOfWholeCycles * cycleLength;
        long idxToCycle = (idx - firstIndexOfIncompleteCycle) % cycleLength;

        long accumulator = 0;
        for (int i = 0; i < introLength; i++) {
            accumulator += longs.get(i);
        }
        for (int i = introLength; i < longs.size(); i++) {
            accumulator += longs.get(i) * numOfWholeCycles;
        }
        for (int i = 0; i < idxToCycle; i++) {
            accumulator += longs.get(i + introLength);
        }
        return accumulator;
    }

    public BigInteger summedEni(Long a, Long b, Long c, Long x, Long y, Long z, Long m)
    {
        BigInteger first = new BigInteger(eni(a, x, m));
        BigInteger second = new BigInteger(eni(b, y, m));
        BigInteger thirs = new BigInteger(eni(c, z, m));
        BigInteger total = first.add(second).add(thirs);
        return total;
    }

    public String solve(Metadata metadata) 
    throws IOException
    {
        List<String> input = metadata.getInput("everybodyCodesStories", 2024, 1, 3);
        BigInteger answer = new BigInteger("-1");

        for (String line : input) {
            String[] parts = line.split(" |=");
            BigInteger sum = summedEni(
                Long.valueOf(parts[1]),
                Long.valueOf(parts[3]),
                Long.valueOf(parts[5]),
                Long.valueOf(parts[7]),
                Long.valueOf(parts[9]),
                Long.valueOf(parts[11]),
                Long.valueOf(parts[13])
            );
            System.out.println(sum);
            if (sum.compareTo(answer) > 0) {
                answer = sum;
            }
        }
        return answer.toString();
    }

    
}
