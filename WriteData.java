import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteData {
	public static FileWriter fw;
	public static ArrayList<Subject> subjects;
	public static ArrayList<Attribute> attributes;
	
	public WriteData() throws IOException
	{
		
	}
	
	public static void recordData(ArrayList<Subject> subjects, ArrayList<Attribute> attributes) throws IOException
	{
		WriteData.subjects = subjects;
		WriteData.attributes = attributes;
		fw = new FileWriter("Data.txt");
		
		fw.write("Subjects");
		for(Subject subject : subjects)
		{
			fw.write(subject.getName());
		}
		fw.write("Attributes");
		for(Attribute attribute : attributes)
		{
			fw.write(attribute.getName());
		}
		fw.write("Traits");
		for(Subject subject : subjects)
		{
			fw.write(subject.getName());
			for(int i = 0;i < subject.getAttributeSize();i++)
			{
				fw.write(subject.getAttribute(i).getName());
			}
		}
		
		System.out.println("Data Recorded");
	}

	
	
}
