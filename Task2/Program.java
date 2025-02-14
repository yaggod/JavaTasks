public class Program
{
    public static void main(String[] args) 
    {

    }

    private static String FindLongestSubstring(String originalString) 
    {
        int[] lastFoundCharPositions = new int[1 << 16]; // goodbye ram but i guess we cant use hashmaps for this task
        int currentSubstringStart = 0;
        int currentSubstringSize = 0;
        int longestFoundSubstringStart = 0;
        int longestfoundSubstringSize = 0;
        for(int i = 0; i < originalString.length(); i++)
        {
            char currentChar = originalString.charAt(i);
            int lastFoundCharPosition = lastFoundCharPositions[currentChar];
            boolean metThisCharBefore = (lastFoundCharPosition >= currentSubstringStart &&
                                        i != 0 &&
                                        originalString.charAt(lastFoundCharPosition) == currentChar);
            if(metThisCharBefore)
            {
                if(currentSubstringSize > longestfoundSubstringSize)
                    {
                        longestFoundSubstringStart = currentSubstringStart;
                        longestfoundSubstringSize = currentSubstringSize;
                    }
                    currentSubstringStart = lastFoundCharPosition + 1;
                    currentSubstringSize = i - currentSubstringStart + 1;
            }
            else
            {
                currentSubstringSize++;
            }
            lastFoundCharPositions[currentChar] = i;
        }

        if(currentSubstringSize > longestfoundSubstringSize)
        {
            longestFoundSubstringStart = currentSubstringStart;
            longestfoundSubstringSize = currentSubstringSize;
        }

        return originalString.substring(longestFoundSubstringStart, longestFoundSubstringStart + longestfoundSubstringSize);
    }

    private static int[] MergeSortedArrays(int[] left, int[] right) 
    {
        int[] result = new int[left.length + right.length];
        int leftPointer = 0;
        int rightPointer = 0;
        while(leftPointer + rightPointer < left.length + right.length)
        {
            int chosenValue;
            if(leftPointer == left.length) 
                chosenValue = right[rightPointer++];
            else if(rightPointer == right.length)
                chosenValue = left[leftPointer++];
            else if(right[rightPointer] < left[leftPointer])
                chosenValue = right[rightPointer++];
            else
                chosenValue = left[leftPointer++];

            result[leftPointer + rightPointer - 1] = chosenValue;
        }

        return result;
    }

    private static int FindHighestSubsum(int[] array)
    {
        int[] subarraySums = new int[array.length];
        int result = 0;
        subarraySums[0] = array[0];
        for(int i = 1; i < array.length; i++)
        {
            subarraySums[i] = subarraySums[i - 1] + array[i];
            result = Integer.max(result, subarraySums[i]);
        }

        int highestNegativeFoundIndex = -1;
        for(int i = 0; i < subarraySums.length; i++)
        {
            if(subarraySums[i] > 0)
                continue;
            if(highestNegativeFoundIndex < 0 || subarraySums[i] < subarraySums[highestNegativeFoundIndex])
                highestNegativeFoundIndex = i;
        }
        if(highestNegativeFoundIndex == -1)
            return result;
        
        for(int i = highestNegativeFoundIndex + 1; i < subarraySums.length; i++)
            result = Integer.max(result, subarraySums[i] - subarraySums[highestNegativeFoundIndex]);

        return result;
    }

    private static int[][] RotateClockwise(int[][] matrix)
    {
        int rowsCount = matrix.length;
        int columnsCount = matrix[0].length;
        int[][] result = new int[columnsCount][rowsCount];
        for(int i = 0; i < rowsCount; i++)
            for(int j = 0; j < columnsCount; j++)
                result[j][rowsCount-i-1] = matrix[i][j];


        return result;
    }

    private static int[] FindPairHavingSum(int[] array, int target)
    {
        // no hashmaps allowed (i guess), so O(n^2) is the only viable solution left
        for(int i = 0; i < array.length - 1; i++)
            for(int j = i + 1; j < array.length; j++)
                if(array[i] + array[j] == target)
                    return new int[]{array[i], array[j]};
        return null;
    }

    private static int GetTotalSum(int[][] matrix)
    {
        int result = 0;
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
                result += matrix[i][j];

        return result;
    }
}    