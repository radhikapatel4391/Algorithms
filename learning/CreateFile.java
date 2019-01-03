package learning;
import java.io.File;
import java.io.IOException;
public class CreateFile{

 public static void main(String[] args) throws IOException
 {
	String sep = System.getProperty("file.separator");
	System.out.println("Seprator: "+sep);
	String path = "//"+"temp"+"//"+"temp.txt";
	System.out.println(path);
	File file = new File(path);
	if(file.createNewFile()){
	System.out.println("file created sucssessfully: "+path);
	}
 }

}