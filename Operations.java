package myPackage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {
	public void listAllFiles(String Path) {
		if(Path==null || Path.isEmpty() || Path.isBlank())
			throw new NullPointerException("Path Cannot Be empty");
		
		File folder_Name = new File(Path);
		
		if (!folder_Name.exists())
			throw new IllegalArgumentException("Path Does Not Exists");
		if (folder_Name.isFile())
			throw new IllegalArgumentException("The given path is a file");
		
		String [] files = folder_Name.list();
		
		System.out.println("\n*********************************************");
		if (files != null && files.length > 0) {
			Set<String>filesList = new TreeSet<String>(Arrays.asList(files));
			System.out.println("The Files In "+ folder_Name.getAbsolutePath() +"are: " + "\n");
			for (String file1:filesList) {
				System.out.println(file1);
			}
			System.out.println("\nTotal Number of files: " + filesList.size());
		}
		else {
			System.out.println("Directory Is Empty");
		 }
		}
	public void createNewFile(String Directory , String filename)throws IOException{	
		
		if (Directory == null || Directory.isBlank() || Directory.isEmpty())
			throw new NullPointerException("File Cannot Be Empty");
		File newfile =  new File(Directory + File.pathSeparator + filename);
		
		boolean createFile = newfile.createNewFile();
		
		if (createFile) {
			System.out.println("\nNew File is Succesfully Created--> " + newfile.getAbsolutePath());
		}
		else if (!createFile) {
			System.out.println("\nFile Already Exists...Try Again...");
		}
		}
	
	public void deleteFile(String Directory, String filename)throws IOException{
		
		if (Directory == null || Directory.isBlank() || Directory.isEmpty())
		   throw new NullPointerException("Path Cannot Be Empty");
	
	    
		if (filename  == null ||filename.isBlank() || filename.isEmpty())
			throw new NullPointerException("File Cannot Be Empty or Null");
		
		File newFile = new File(Directory + File.separator + filename);
		
		boolean deleteFile = newFile.delete();
		
		if (deleteFile) {
			System.out.println("\nFile Deleted Succesfully");
		}
		else {
			System.out.println("\nFile Not Found.....Try again");
		}
			
	
	}
	
	public void SearchFile(String Directory, String fileName) {
		if (Directory == null || Directory.isEmpty() || Directory.isBlank())
			throw new NullPointerException("Path Cannot Be Empty");
		
		if (fileName == null || fileName.isBlank() || fileName.isEmpty())
			throw new NullPointerException("File Name Cannot be Empty");
		
		File folder_Name = new File(Directory);
		
		if (!folder_Name.exists())
			throw new NullPointerException("Does Not Exists");
		if (folder_Name.isFile())
			throw new NullPointerException("THE GIVEN PATH IS A FILE, DIRECTORY EXPECTED");
		
		
		String [] fileList = folder_Name.list();
		boolean flag = false;
		
		Pattern pat = Pattern.compile(fileName);
		
		if (fileList != null && fileList.length > 0) {
			for (String file : fileList) {
				Matcher mat = pat.matcher(file);
				if (mat.matches()) {
					System.out.println("File Found At The Given Location" + folder_Name.getAbsolutePath());
					flag = true;
					break;
				}
			}
		}
		if (flag == false)
			System.out.println("File Not Found FNF...TRY AGAN TA");
		}
	}



