import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class Dichotomous{

  ArrayList<Attribute> attributeList;
  ArrayList<Subject> subjects;
  Scanner input;
  Node mainNode = null;

  public Dichotomous(){
    attributeList = new ArrayList<Attribute>();
    subjects = new ArrayList<Subject>();
    input = new Scanner(System.in);
  }

  public static void main(String[] args)
  {
    int choice = 0;
    Dichotomous dichotomous = new Dichotomous();
    Scanner keyboard = new Scanner(System.in);
    while(choice!=-999)
    {
      System.out.println("****************Dichotomous Key***************");
      System.out.println("     Press 1 to Add Trait");
      System.out.println("     Press 2 to Add Subject");
      System.out.println("     Press 3 to Add Trait to Subject");
      System.out.println("     Press 4 to RUN QUICK SEARCH");
      System.out.println("     Press 5 to RUN DICHOTOMOUS SEARCH");
      System.out.println("     Press 6 to List Current Subjects");
      System.out.println("     Press 7 to List Current Traits");
      System.out.println("     Press 8 to Remove Subject");
      System.out.println("     Press 9 to Remove Trait");
      System.out.println("     Press 10 to Remove Trait from Subject");
      System.out.println("     Press 11 to List Traits of Subject");
      System.out.println("     Press 12 to Create a Dichotomous Tree");
      System.out.println("     Press 13 to Save Current Dichotomous Tree");
      System.out.println("     Press 14 to Load a Dichotomous Tree");
      System.out.println("     Press -999 to Exit");
      System.out.print("Input: ");
      choice = keyboard.nextInt();
      dichotomous.transportMenu(choice);
    }

  }

  public void transportMenu(int choice)
  {
    switch(choice)
    {
      case 1:
        addTrait();
      break;

      case 2:
        addCharacter();
      break;

      case 3:
        addTraitofCharacter();
      break;

      case 4:
        System.out.println("Sorry, we are in maintenance.. Please try again");
      break;

      case 5:
        questionSearch();
      break;

      case 6:
        listSubjects();
      break;

      case 7:
        listTraits();
      break;

      case 8:
        removeSubject();
      break;

      case 9:
        removeTrait();
      break;
      
      case 10:
          removeTraitfromSubject();
        break;
        
      case 11:
          listTraitsofSubject();
        break;
        
      case 12:
          System.out.println("This option plans to graphically print a dichotomous key\nWork in Progress...");
        break;
        
      case 14:
          ReadData.loadData("Data.txt");
          subjects = new ArrayList<Subject>();
          attributeList = new ArrayList<Attribute>();
          
          for(Subject subject : ReadData.loadedSubjects)
          {
        	  	subjects.add(subject);
          }
          
          for(Attribute attribute : ReadData.loadedAttributes)
          {
        	  	attributeList.add(attribute);
          }
          System.out.println("Data loaded");
          
        break;
        
      case 13:
          try {
			WriteData.recordData(subjects, attributeList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          System.out.println("Data recorded");
        break;

      case -999:
        System.out.println("Exiting...");
        return;


      default:
        System.out.println("Wrong Choice! Please try again...");
      break;

    }
  }

  public int input()
  {
    System.out.print("Input: ");
    return input.nextInt();
  }

  public void listSubjects()
  {
    for(int i=0;i<subjects.size();i++)
    {
      System.out.println(i+":  "+subjects.get(i).getName());
    }
  }

  public void listTraitsofSubject()
  {
	  	int i;
	    int choice = -1;

	    Subject subject;

	    if(subjects.size() <= 0)
	    {
	      System.out.println("No Subject to remove! Try again...");
	      return;
	    }

	    if(attributeList.size() <= 0)
	    {
	      System.out.println("No traits to remove!");
	      return;
	    }

	    while(true)
	    {
	      System.out.println("Select subject\n");

	      for(i=0;i<subjects.size();i++)
	      {
	        System.out.println(i+":  "+subjects.get(i).getName());
	      }
	      System.out.println("Press -999 to Exit");
	      choice = input();

	      if(choice == -999)
	      {
	        System.out.println("Exiting mode");
	        return;
	      }
	      if(choice < 0 || choice >= subjects.size())
	      {
	        System.out.println("Wrong choice! Try again!");
	      }else{
	        subject = subjects.get(choice);
	        break;
	      }
	    }
	    
	    System.out.println("*********************************");
		System.out.println("List of Attributes:");
	    for(i=0;i<subject.getAttributeSize();i++)
	    {
	    		System.out.println(i+": "+subject.getAttribute(i).getName());
	    }
	    System.out.println("*********************************");
  }
  
  public void listTraits()
  {
    for(int i=0;i<attributeList.size();i++)
    {
      System.out.println(i+":  "+attributeList.get(i).getName());
    }
  }

  public void removeTrait()
  {
    int choice;
    System.out.println("Select Trait to Remove");
    listTraits();
    System.out.println("-999 to Exit");
    choice = input.nextInt();

    if(choice == -999)
    {
      System.out.println("Exiting..");
      return;
    }else if(choice >= 0 || choice < attributeList.size())
    {
      System.out.println(attributeList.remove(choice)+" removed..");
    }
    else{
      System.out.println("Wrong choice! Try again!");
    }

  }
  
  public void removeTraitfromSubject()
  {
	  	int i;
	    int choice = -1;

	    Subject subject;

	    if(subjects.size() <= 0)
	    {
	      System.out.println("No Subject to remove! Try again...");
	      return;
	    }

	    if(attributeList.size() <= 0)
	    {
	      System.out.println("No traits to remove!");
	      return;
	    }

	    while(true)
	    {
	      System.out.println("Select subject\n");

	      for(i=0;i<subjects.size();i++)
	      {
	        System.out.println(i+":  "+subjects.get(i).getName());
	      }
	      System.out.println("Press -999 to Exit");
	      choice = input();

	      if(choice == -999)
	      {
	        System.out.println("Exiting mode");
	        return;
	      }
	      if(choice < 0 || choice >= subjects.size())
	      {
	        System.out.println("Wrong choice! Try again!");
	      }else{
	        subject = subjects.get(choice);
	        break;
	      }
	    }
	    while(true)
	    {
	      System.out.println("\n\n");
	      System.out.println("Remove Trait to Subject\n");
	      System.out.println("****************************************");
	      System.out.println("Current List of Trait of "+subject.getName()+":");
	      for(i=0;i<subject.getAttributeSize();i++)
	      {
	        System.out.println(i+":  "+subject.getAttribute(i).getName());
	      }
	      System.out.println("****************************************");
	      System.out.println("Remove Trait to Subject\n");
	      for(i=0;i<subject.getAttributeSize();i++)
	      {
	        System.out.println(i+":  "+subject.getAttribute(i).getName());
	      }
	      System.out.println("-999 to Exit");
	      choice = input();

	      if(choice == -999)
	      {
	        System.out.println("Exiting..");
	        return;
	      }else if(choice >= 0 && choice < attributeList.size())
	      {
	        attributeList.get(choice).decrementRate();
	        subject.removeAttribute(choice);
	        System.out.println("Attribute Removed");
	      }
	      else{
	        System.out.println("Wrong choice! Try again!");
	      }

	    }
  }

  public void removeSubject()
  {
    int choice;
    System.out.println("Select Subject to Remove");
    listSubjects();
    System.out.println("-999 to Exit");
    choice = input.nextInt();

    if(choice == -999)
    {
      System.out.println("Exiting..");
      return;
    }else if(choice >= 0 && choice < subjects.size())
    {
      System.out.println(subjects.remove(choice)+" removed..");
    }
    else{
      System.out.println("Wrong choice! Try again!");
    }
  }

  public void addCharacter()
  {
    Subject subject = new Subject();
    System.out.println("Subject to add: ");
    String name;
    name = input.nextLine();
    for(Subject candidate : subjects)
    {
      if(candidate.getName().equals(name))
      {
        System.out.println("There is already an organism named \""+name+"\"\nTry again...");
        return;
      }
    }
    subject.setName(name);
    subjects.add(subject);
    System.out.println("Subject added!");
  }

  public void addTrait()
  {
    Attribute trait = new Attribute();
    String name;
    System.out.println("Trait to add: ");
    System.out.println("Press -999 to exit");
    name = input.nextLine();
    
    if(Integer.parseInt(name) == -999)
    {
    		System.out.println("Exiting..");
    		return;
    }
    for(Attribute candidate : attributeList)
    {
      if(candidate.getName().equals(name))
      {
        System.out.println("There is already a trait named \""+name+"\"\nTry again...");
        return;
      }
    }
    trait.setName(name);
    attributeList.add(trait);
    System.out.println("Trait added!");
  }

  public void addTraitofCharacter()
  {

    int i;
    int choice = -1;

    Subject subject;
    Attribute attribute;

    if(subjects.size() <= 0)
    {
      System.out.println("No Subject to add trait! Try again...");

      System.out.println("Add Subject? (Y/N): ");
      String in = input.nextLine();
      if(in.equals("Y") || in.equals("y"))
      {
        addCharacter();
      }else{
        System.out.println("Try again next time..");
        return;
      }
    }

    if(attributeList.size() <= 0)
    {
      System.out.println("No traits to add!");
      System.out.println("Add trait? (Y/N)");
      String in = input.nextLine();
      if(in.equals("Y") || in.equals("y"))
      {
        addTrait();
      }else{
        System.out.println("Try again next time..");
        return;
      }
    }

    while(true)
    {
      System.out.println("Select subject to add\n");

      for(i=0;i<subjects.size();i++)
      {
        System.out.println(i+":  "+subjects.get(i).getName());
      }
      System.out.println("Press -999 to Exit");
      choice = input();

      if(choice == -999)
      {
        System.out.println("Exiting mode");
        return;
      }
      if(choice < 0 || choice >= subjects.size())
      {
        System.out.println("Wrong choice! Try again!");
      }else{
        subject = subjects.get(choice);
        break;
      }
    }
    while(true)
    {
      System.out.println("\n\n");
      System.out.println("Add Trait to Subject\n");
      System.out.println("****************************************");
      System.out.println("Current List of Trait of "+subject.getName()+":");
      for(i=0;i<subject.getAttributeSize();i++)
      {
        System.out.println(i+":  "+subject.getAttribute(i).getName());
      }
      System.out.println("****************************************");
      System.out.println("Add Trait to Subject\n");
      for(i=0;i<attributeList.size();i++)
      {
        System.out.println(i+":  "+attributeList.get(i).getName());
      }
      System.out.println("-999 to Exit");
      choice = input();

      if(choice == -999)
      {
        System.out.println("Exiting..");
        return;
      }else if(choice >= 0 && choice < attributeList.size())
      {
        attribute = attributeList.get(choice);
        subject.addAttribute(attribute);
        attribute.incrementRate();
      }
      else{
        System.out.println("Wrong choice! Try again!");
      }

    }

  }

  public void quickSearch()
  {

  }

  public Attribute getMaxAttribute(ArrayList<Subject> subjects)
  {
    int max = -999;
    Attribute meanAttribute = null;
    for(Subject member:subjects)
    {
      Attribute attribute = member.getMaxAttribute();
      if(attribute.getRate() > max)
      {
        meanAttribute = attribute;
        max = attribute.getRate();
      }
    }

    if(meanAttribute == null)
    {
      System.out.println("meanAttribute is NULL!!");
    }
    return meanAttribute;
  }

  public void createTree()
  {
    int i;
    int j;
    System.out.println("Constructing Dichotomous Tree...");
    ArrayList<Subject> dummy = new ArrayList<Subject>();
    for(i=0;i<subjects.size();i++)
    {
      Subject subject = new Subject();
      subject.setName(subjects.get(i).getName());
      for(j=0;j<subjects.get(i).getAttributeSize();j++)
      {
        subject.addAttribute(subjects.get(i).getAttribute(j));
      }
      dummy.add(subject);
    }

    if(dummy.size() > 0)
    {
    		mainNode = new Node(getMaxAttribute(dummy), dummy);
    }
    System.out.println("Tree Constructed!");
  }

  public void questionSearch()
  {
    int i;
    ArrayList<Node> qeue = new ArrayList<Node>();
    createTree();
    if(mainNode != null)
    {
    		qeue.add(mainNode);
    }
    while(qeue.size() > 0)
    {
      System.out.println("Does trait \""+qeue.get(0).mainAttribute.getName()+"\" Exist? (Y/N)");
      System.out.print("Input(Y/N): ");
      String in = input.nextLine();
      if(in.equals("Y") || in.equals("y"))
      {
        if(qeue.get(0).nodeYes != null)
        {
          qeue.add(qeue.get(0).nodeYes);
        }else{
          System.out.println("**************************************");
          System.out.println("Final Classification Result:");
          for(i=0;i<qeue.get(0).members.size();i++)
          {
            System.out.println((i+1)+": "+qeue.get(0).members.get(i).getName());
          }
          System.out.println("**************************************");
        }
        qeue.remove(0);
      }else if(in.equals("N") || in.equals("n"))
      {
        if(qeue.get(0).nodeNo != null)
        {
          qeue.add(qeue.get(0).nodeNo);
        }else{
          System.out.println("**************************************");
          System.out.println("Final Classification Result:");
          for(i=0;i<qeue.get(0).members.size();i++)
          {
            System.out.println((i+1)+": "+qeue.get(0).members.get(i).getName());
          }
          System.out.println("**************************************");
        }
        qeue.remove(0);
      }else{
        System.out.println("Please type Y or N\n\n");
      }
    }
  }
}
