package demo;
import java.util.Arrays;

// package com.logicalduniya.practice.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.shubhamklogic.practice.selenium.SeleniumHelperUtil;


class Demo {
	
	private static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
        
        int[] arr = {11,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2};
        sort6_ViaQuickSort(arr, 0, arr.length-1);
		SeleniumHelperUtil.log("\n\nAfter Full Sorting  :\n" + Arrays.toString( arr ));

//		System.out.println("---- Mouseover text in Selenium WebDriver + Java Test is completed successfully !!");
	}

	private static void sort6_ViaQuickSort(int[] arr, int start, int end) {
		
		if (start < end) {
			int pivotInd = partition (arr, start, end);
			sort6_ViaQuickSort(arr, start, pivotInd-1);
			sort6_ViaQuickSort(arr, pivotInd+1, end);
		}
	}
	
	private static int partition (int[] arr, int start, int end) {
		int partitionInd = start;
		int pivot = arr[end];
		
		for(int i=start; i<end; i++) {
			if(arr[i] < pivot) {
				int tmp = arr[i];
				arr[i] = arr[partitionInd];
				arr[partitionInd] = tmp;
				partitionInd++;
			}
		}
		int tmp = arr[partitionInd];
		arr[partitionInd] = arr[end];
		arr[end] = tmp;
		
		
		return partitionInd;
	}
	
	
	private static void sort5_ViaMergeSort(int[] arr, String note) {
		
		// [10,8,6,12,14]  = 5
		// [10,8,6,12,14,4]= 6
		
		if (arr.length < 2) return;		// Base condition :: Returns if arr.length = 1
		int mid = arr.length / 2;
		
		int[] arrLeft = new int[mid];
		int[] arrRight = new int[arr.length - mid];
		
		for (int i=0; i < mid; i++)
			arrLeft[i] = arr[i];
		for (int i=0; i < arr.length-mid; i++)
			arrRight[i] = arr[mid+i];
		
		sort5_ViaMergeSort(arrLeft, "");
		sort5_ViaMergeSort(arrRight, "");
		merge(arrLeft, arrRight, arr);

	}
	
	private static void merge(int[] arrLeft, int[] arrRight, int[] arr) {
		
		int l = 0;		// smallest unpicked index in arrLeft
		int j = 0;		// smallest unpicked index in arrRight
		int k = 0;		// next index to be filled in arr
		
		while( l < arrLeft.length && j < arrRight.length) {		// loop 1
			if (arrLeft[l] < arrRight[j]) {
				arr[k] = arrLeft[l];
				l++;
				k++;
			}
			else {
				arr[k] = arrRight[j];
				j++;
				k++;
				
			}
		}
		
		// After loop 1, only one of the below loops (2 & 3) will get executed, as the other one condition is already failed in loop 1.
		
		while( l < arrLeft.length) {				// loop 2
			arr[k] = arrLeft[l];
			l++;
			k++;
		}
		
		while( j < arrRight.length) {				// loop 3
			arr[k] = arrRight[j];
			j++;
			k++;
		}
	}
	
	
	private static void sort4_ViaInsertionSort(int[] arr, String note) {
		
		for (int i = 1; i < arr.length; i++) {
			
			int hole = i;
			int value = arr[i];			// take back up of value
			
			while ( hole > 0 && arr[hole-1] > arr[hole]) {
				
				// swap arr[hole] with arr[hole-1]
				int tmp = arr[hole];
				arr[hole] = arr[hole-1];
				arr[hole-1] = tmp;
				
				// Shift hole to 1 index back
				hole--;
			}
			arr[hole] = value;			// put the backed up value in hole
		}
		SeleniumHelperUtil.log("\n\n" + note + ":: After Full Sorting  :\n" + Arrays.toString( arr ));

	}
	
	private static void sort3_ViaBubbleSort(int[] arr, String note) {
		
		// Bubble up the max element towards higher index in each pass..
		
		for( int i = 0; i < arr.length-1; i++) {
			int flag = 0;
			for( int j = 0; j < arr.length-1-i; j++) {
				
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					flag = 1;
				}
			}
			SeleniumHelperUtil.log(Arrays.toString( arr ));

			if (flag == 0) 
				break;
			
		}
		
		SeleniumHelperUtil.log("\n\n" + note + ":: After Full Sorting  :\n" + Arrays.toString( arr ));
		
	}
	
	private static void sort2_ViaSelectionSort(int[] arr, String note) {
		
		for (int i=0; i< arr.length-1; i++) {
			int iMin = i;							// assumed minimum val. index
			
			for(int j=i+1; j<arr.length; j++) {		// check presence of any other array value in remaining part of array, which is smaller than assumed min. val.
				if(arr[j] < arr[iMin]) { 
					iMin = j;						// found new minimum
				}
			}
			
			int tmp = arr[iMin];					// swap min. index value with curr. index value
			arr[iMin] = arr[i];
			arr[i] = tmp;
		}
		
		
		SeleniumHelperUtil.log("\n\n" + note + ":: After sorting  :\n" + Arrays.toString( arr ));
	}
	
	private static void sort1_ViaArray(int[] arrInt1, String note) {
		
		java.util.Arrays.sort(arrInt1);
		SeleniumHelperUtil.log("\n\n" + note + ":: After sorting  :\n" + Arrays.toString( arrInt1 ));
		
	}








	public static void setup() {

		System.setProperty("webdriver.chrome.driver",
			 "/Users/logical_duniya_com/Desktop/OtherFiles/ChromeDriver/chromedriver_mac");
			
					
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized"); 			// open Browser in maximized mode
		chromeOptions.addArguments("disable-infobars"); 		// disabling infobars
		chromeOptions.addArguments("--ignore-certificate-errors");
		chromeOptions.addArguments("--remote-allow-origins=*");
		chromeOptions.setAcceptInsecureCerts(true);				// AcceptInsecureCerts 

		driver = new ChromeDriver(chromeOptions);
	}

	
	public static void mouseOverTooltipTextReadTest() throws Exception {
		
		driver.get("https://codepen.io/shubh-sri/full/PoxBVvg?src=LogicalDuniya.com");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("result");
		
		 // Locate the image element
        WebElement imageElement = driver.findElement(By.xpath("//div[@class='imgbox']/img"));

        // Perform a mouseover (hover) action on the image
        performMouseover(driver, imageElement);

        // Get the tooltip text
        String tooltipText = getTooltipText(driver);

        // Print the tooltip text
        System.out.println("Tooltip Text is: " + tooltipText);

        // Close the browser
        driver.quit();
		
	}
	
	
	private static void performMouseover(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
    }
	
	private static String getTooltipText(WebDriver driver) {
        WebElement tooltipElement = driver.findElement(By.xpath("//div[@class='imgbox']/img"));
        return tooltipElement.getAttribute("title");
    }
	
}

