package com.example;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class YamlFileReadWrite 
{
  public static void main(String [] args) 
    {
	File originalFile = new File ("C:\\Users\\DT-BSIT-005\\eclipse-workspace\\YamlReadAndWrite\\src\\com\\example\\original.yaml");
	File copyFile = new File("C:\\Users\\DT-BSIT-005\\eclipse-workspace\\YamlReadAndWrite\\src\\com\\example\\copy.yaml");
	boolean present = originalFile.exists();
	boolean copyPresent = copyFile.exists();
	System.out.println("original File present: " + present );
	System.out.println("copy File present: " + copyPresent );
	

	if(present == false)
		try {
		boolean created = originalFile.createNewFile();
		System.out.println("File Created" + created);
		}  catch(IOException e) 
	{
	e.printStackTrace();
    }

  if(copyPresent == false)
	try {
		boolean created= copyFile.createNewFile();
		System.out.println("Copy File Created"+ created);
	}catch(IOException e) {
		e.printStackTrace();

	}

	
	if (originalFile.exists()) 
	{
		try(FileReader reader = new FileReader(originalFile);
			FileWriter writer = new FileWriter(copyFile))
		{
		int output = reader.read();
				while(output!=-1) 
				{
					writer.write(output);
					output=  reader.read();
				}
				System.out.println("\n File copied Successfully" + copyFile.getAbsolutePath());
		}
  catch(IOException e) 
		{
		e.printStackTrace();
	    }
	}
		else {
			System.out.println("original.yaml file not found");
    }
 }
}