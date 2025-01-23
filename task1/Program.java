import java.util.Scanner;
import javax.naming.OperationNotSupportedException;

public class Program
{
	private static Scanner scanner = new Scanner(System.in, "UTF-8");

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
				executeSubtask3();
				break;
			case 4:
				executeSubtask4();
				break;
			case 5:
				break;
			default:
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

    private static void executeSubtask3() 
	{
		int destinationX, destinationY, stepSize;
		int stepsCount = 0;
		int currentX = 0;
		int currentY = 0;
		int result = 0;
		boolean foundAnswer = false;
		String lastDirection;

		System.out.println("Enter destination x: ");
		destinationX = scanner.nextInt();
		System.out.println("Enter destination y: ");
		destinationY = scanner.nextInt();
		while(true)
		{
			System.out.println("Enter direction: ");
			lastDirection = scanner.next();
			if(lastDirection.equals("стоп")) // read a comment below
				break;
			System.out.println("Enter step size: ");
			stepSize = scanner.nextInt();
			switch(lastDirection) // hardcoded literals but who cares
			{
				case "восток":
					currentX += stepSize;
					break;
				case "запад":
					currentX -= stepSize;
					break;
				case "север":
					currentY  += stepSize;
					break;
				case "юг":
					currentY -= stepSize;
					break;

				default:
					System.out.println("Unknown direction");
					continue;
			}
			stepsCount++;
			if(currentX != destinationX || currentY != destinationY)
				continue;
			if(!foundAnswer)
				result = stepsCount;
		}

		System.out.println(result);
	}

    private static void executeSubtask4() 
	{
		System.out.println("Enter roads count: ");
		int roadsCount = scanner.nextInt();
		int foundRoadHeight = 0;
		int foundRoad = -1;
		for(int road = 0; road < roadsCount; road++)
		{
			System.out.println("Enter tunnels count on the road: ");
			int tunnelsCount = scanner.nextInt();
			int currentRoadLowestHeight = 0;
			boolean chosenAny = false;
			for(int tunnel = 0; tunnel < tunnelsCount; tunnel++)
			{
				System.out.println("Enter tunnel height: ");
				int height = scanner.nextInt();
				if(!chosenAny)
				{
					currentRoadLowestHeight = height;
					chosenAny = true;
				}
				else
				{
					currentRoadLowestHeight = Math.min(currentRoadLowestHeight, height);
				}
			}
			if(foundRoadHeight < currentRoadLowestHeight || road == 0)
			{
				foundRoadHeight = currentRoadLowestHeight;
				foundRoad = road;
			}
		}

		System.out.println(foundRoad + 1 + " " + foundRoadHeight);
	}
}