import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteData {
	FileWriter fw;
	ArrayList<Subject> subjects;
	ArrayList<Attribute> attributes;
	
	public WriteData(ArrayList<Subject> subjects, ArrayList<Attribute> attributes) throws IOException
	{
		this.subjects = subjects;
		this.attributes = attributes;
		fw = new FileWriter("Data.txt");
	}
	
	public void recordData()
	{
		
	}

	
	
}
