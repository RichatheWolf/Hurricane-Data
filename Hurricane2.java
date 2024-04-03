import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project title: 07.03
 *
 * Purpose of Project: Challenge program for Hurricane data.
 *
 * @version 3/20/24
 *
 * @author Richa Limaye
 *
 * *********** PMR ***********
 *
 * ***************************
 *
 */


public class Hurricane2 {
	public static void main(String[] args) throws IOException {
		//declare and initialize variables
		int arrayLength = 14;
		
		int[] year = new int[arrayLength];
		String[] month = new String[arrayLength];
		int[] pressure = new int[arrayLength];
		int[] windSpeed = new int[arrayLength];
		int[] category = new int[arrayLength];
		String[] name = new String[arrayLength];
		int f0 = 0;
		int f1 = 0;
		int f2 = 0;
		int f3 = 0;
		int f4 = 0;
		int f5 = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int maxCat = 0;
		int minCat = 0;
		int maxSpeed = 0;
		int minSpeed = 0;
		int maxPres = 0;
		int minPres = 0;
		int sum = 0;
		int averageCat = 0;
		int averageSpeed = 0;
		int averagePres = 0;
		
		File fileName = new File("HurricaneData.txt");
		Scanner inFile = new Scanner(fileName);
		
		//INPUT  - read data in from the file
		int index = 0;
		while (inFile.hasNext()){
			year[index] = inFile.nextInt();
			month[index] = inFile.next();
			pressure[index] = inFile.nextInt();
			windSpeed[index] = inFile.nextInt();
			name[index] = inFile.next();
			index++;
		}
		
		
		inFile.close();
		
		//PROCESSING - calculate and convert values
		
		// convert windspeed from knots to MPH
		if(2003 <= year[index] && year[index] <= 2005) {
			for (int i = 0; i < windSpeed.length; i++) {
				windSpeed[i] = (int) (windSpeed[i] * 1.151);
			}
			// determine category
			for (int i = 0; i < windSpeed.length; i++) {
				if (windSpeed[i] >= 74 && windSpeed[i] <= 95) {
					category[i] = 1;
				} else if (windSpeed[i] >= 96 && windSpeed[i] <= 110) {
					category[i] = 2;
				} else if (windSpeed[i] >= 111 && windSpeed[i] <= 129) {
					category[i] = 3;
				} else if (windSpeed[i] >= 130 && windSpeed[i] <= 156) {
					category[i] = 4;
				} else if (windSpeed[i] >= 157) {
					category[i] = 5;
				} else {
					category[i] = 0;
				}
			}
			
			// count number of each category
			for (int hurricane : category) {            //hurricane temporary variable will appear throughout the code,
				if (hurricane == 1) {                   //it represents each index of an array
					f1++;
				} else if (hurricane == 2) {
					f2++;
				} else if (hurricane == 3) {
					f3++;
				} else if (hurricane == 4) {
					f4++;
				} else if (hurricane == 5) {
					f5++;
				} else {
					f0++;
				}
			}
			
			//Find min, max and average for category, windspeed and pressure
			for (int hurricane : category) {
				if (hurricane > max) {
					max = hurricane;
				}
			}
			maxCat = max;
			max = Integer.MIN_VALUE;
			
			for (int hurricane : category) {
				if (hurricane < min) {
					min = hurricane;
				}
			}
			minCat = min;
			min = Integer.MAX_VALUE;
			
			for (int hurricane : windSpeed) {
				if (hurricane > max) {
					max = hurricane;
				}
			}
			maxSpeed = max;
			max = Integer.MIN_VALUE;
			for (int hurricane : windSpeed) {
				if (hurricane < min) {
					min = hurricane;
				}
			}
			minSpeed = min;
			min = Integer.MAX_VALUE;
			
			for (int hurricane : pressure) {
				if (hurricane > max) {
					max = hurricane;
				}
			}
			maxPres = max;
			max = Integer.MIN_VALUE;
			for (int hurricane : pressure) {
				if (hurricane < min) {
					min = hurricane;
				}
			}
			minPres = min;
			min = Integer.MAX_VALUE;
			
			for (int hurricane : category) {
				sum += hurricane;
			}
			averageCat = (int) (sum / category.length);
			sum = 0;
			
			for (int hurricane : windSpeed) {
				sum += hurricane;
			}
			averageSpeed = (int) (sum / windSpeed.length);
			sum = 0;
			
			for (int hurricane : pressure) {
				sum += hurricane;
			}
			averagePres = (int) (sum / pressure.length);
			sum = 0;
		}
		//Output - print table using printf to format the columns
		
		System.out.println("                      Hurricanes 2003 - 2005");
		System.out.println();
		System.out.println("Year     Hurricane    Category     Pressure (mb)     Wind Speed (mph)");
		System.out.println("=====================================================================");

		for (int i = 0; i < year.length; i++) {
			System.out.printf("%4d%12s%11d%16d%18d%n", year[i], name[i], category[i], pressure[i], windSpeed[i]);
		}
		System.out.println("=====================================================================");
		System.out.printf("%7s%20d%16d%18d%n", "Average", averageCat, averagePres, averageSpeed);
		System.out.printf("%7s%20d%16d%18d%n", "Maximum", maxCat, maxPres, maxSpeed);
		System.out.printf("%7s%20d%16d%18d%n", "Minimum", minCat, minPres, minSpeed);
		System.out.println();
		
		System.out.println("Number of Tropical Storms: " + f0);
		System.out.println("Number of Category 1: " + f1);
		System.out.println("Number of Category 2: " + f2);
		System.out.println("Number of Category 2: " + f3);
		System.out.println("Number of Category 2: " + f4);
		System.out.println("Number of Category 2: " + f5);
		
		//Output - write table to a .txt file
	}//end main()
}//end Hurricanes2