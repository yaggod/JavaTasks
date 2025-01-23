import java.util.Scanner;
import javax.naming.OperationNotSupportedException;

public class Program
{
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws OperationNotSupportedException
	{
		System.out.println("Enter task id: ");
		int subTaskId = scanner.nextInt();
		executeTaskFromId(subTaskId);
	}

	public static void executeTaskFromId(int id) throws OperationNotSupportedException
	{
		switch (id)
		{
			case 1:
				executeSubtask1();
				break;
			case 2:
				executeSubtask2();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				throw new OperationNotSupportedException("");
		} 
	}

    private static void executeSubtask1() 
	{
		int stepsCount = 0;
		long value;
		System.out.println("Enter base value: ");
		value = scanner.nextLong();
		while(value != 1)
		{
			if(value % 2 == 0)
				value /= 2;
			else
				value = 3*value + 1;
			stepsCount++;
		}

		System.out.println(stepsCount + " steps in total");
	}

    private static void executeSubtask2() 
	{
        System.out.println("Enter numbers count: ");
		int numbersCount = scanner.nextInt();
		int result = 0;
		for(int i = 0; i < numbersCount; i++)
		{
			if(i % 2 == 0)
				result += scanner.nextInt();
			else
				result -= scanner.nextInt();
		}

		System.out.println(result);
    }
}