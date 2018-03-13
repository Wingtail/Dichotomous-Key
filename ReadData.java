import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData{

  public static ArrayList<Attribute> loadedAttributes;
  public static ArrayList<Subject> loadedSubjects;
  public static BufferedReader br = null;
  public static FileReader fr = null;


  public static void loadData(String FILEDIR)
  {
	  loadedAttributes = new ArrayList<Attribute>();
	  loadedSubjects = new ArrayList<Subject>();

	  try{
	      fr = new FileReader(FILEDIR);
	      br = new BufferedReader(fr);
	  }catch(IOException e)
	  {
	      System.out.println("Error while loading file.. Perhaps no File?");
	  }
    try{
      String sCurrentLine = null;
      int index = 0;
      int choice = -1;
      while((sCurrentLine = br.readLine()) != null)
      {
        if(choice == 0 && !sCurrentLine.equals("Subjects"))
        {
        		Subject subject = new Subject();
        		subject.setName(sCurrentLine);
        		loadedSubjects.add(subject);
        }else if(choice == 1 && !sCurrentLine.equals("Attributes"))
        {
          Attribute attribute = new Attribute();
          attribute.setName(sCurrentLine);
          attribute.incrementRate();
          loadedAttributes.add(attribute);
        }else if(choice == 2 && !sCurrentLine.equals("Traits"))
        {
          if(sCurrentLine.equals(loadedSubjects.get(index).getName()))
          {
            index++;
          }else{
            Attribute attribute = new Attribute();
            attribute.setName(sCurrentLine);
            attribute.incrementRate();
            loadedSubjects.get(index-1).addAttribute(attribute);
          }
        }

        if(sCurrentLine.equals("Subjects"))
        {
          choice = 0;
        }else if(sCurrentLine.equals("Attributes"))
        {
          choice = 1;

        }else if(sCurrentLine.equals("Traits"))
        {
          choice = 2;
        }
      }
    }catch(IOException e)
    {
      System.out.println("Error while loading file");
      e.printStackTrace();
    } finally {
      if(br != null)
      {
        try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      if(fr!=null)
      {
        try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
    }
  }

}
