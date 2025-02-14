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
}    

