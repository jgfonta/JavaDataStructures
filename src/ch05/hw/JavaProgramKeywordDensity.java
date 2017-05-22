package ch05.hw;

import java.io.*;
import java.util.Scanner;

import ch05.collections.SortedArrayCollection;

//************************************************
//problem #14
//************************************************
//The file Keywords.txt found in the input folder contains
//all the Java keywords. Create an application that accepts the name
//of a Java program file as a command line argument and displays a
//count of the total number of keywords the program contains. For
//example, if you use the VocabularyDensity.java program as
//your input, the application should display
//VocabularyDensity.java contains 24 Java keywords
//As part of your solution you should create a collection of keywords
//using the information in the Keywords.txt file. Do not worry
//about the fact that you might be counting keywords contained
//within comments or strings.

public class JavaProgramKeywordDensity {

	public static void main(String[] args) throws IOException
	{
	
		String keywordFileName = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\input\\Keywords.txt";
		FileReader myKeywordFile = new FileReader(keywordFileName);
		Scanner inputLine = new Scanner(myKeywordFile);
		String inputString;
		SortedArrayCollection javaKeywords = new SortedArrayCollection<String>();
		SortedArrayCollection checkedProgram = new SortedArrayCollection<String>();
		
		System.out.println("Populating Java keyword database");
		while (inputLine.hasNext())
		{
			inputString = (inputLine.next()).toLowerCase();	
			//System.out.println(inputString);
			javaKeywords.add(inputString);
		}
		System.out.println("Java keyword database built");
		
		String myProgramName = "C:\\Users\\IBM_ADMIN\\QAFrameworkEclipse\\Workspace\\Data Structures and Algorithms\\src\\ch05\\apps\\VocabularyDensity.java";

		System.out.println("Going to analyze this program:\n" + myProgramName);
		
		FileReader myProgramFile = new FileReader(myProgramName);
		inputLine = new Scanner(myProgramFile);
		int totalWords, javaWords;
		totalWords = 0;
		javaWords = 0;
		while (inputLine.hasNext())
		{
			inputString = (inputLine.next()).toLowerCase();	
			//System.out.println(inputString);
			if (javaKeywords.contains(inputString))
			{
				javaWords++;
			}
			totalWords++;
			//checkedProgram.add(inputString);
		}
		System.out.println("Parsed " + totalWords + " found " + javaWords + " Java keywords");
	}

}
