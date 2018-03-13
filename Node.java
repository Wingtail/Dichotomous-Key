import java.util.ArrayList;

public class Node{
  Attribute mainAttribute;
  ArrayList<Subject> members;

  Node nodeYes = null;
  Node nodeNo = null;

  public Node(Attribute mainAttribute, ArrayList<Subject> members)
  {
    this.mainAttribute = mainAttribute;
    this.members = members;
    branchClassification();
  }

  public void branchClassification()
  {
    int i;
    int max;
    ArrayList<Subject> yesClass = new ArrayList<Subject>();
    ArrayList<Subject> noClass = new ArrayList<Subject>();
    Attribute nextMainClassYes = null;
    Attribute nextMainClassNo = null;

    if(members.size()<=0)
    {
      System.out.println("No members to classify");
      return;
    }

    for(Subject member:members)
    {
      if(member == null)
      {
        System.out.println("There is error..");
        break;
      }
      if(member.hasAttribute(mainAttribute.getName()))
      {
        yesClass.add(member);
      }else{
        noClass.add(member);
      }
    }

    if(yesClass.size() <=0 && noClass.size() <= 0)
    {
      System.out.println("End of Node Reached");
      return;
    }

    for(Subject member : yesClass)
    {
      for(i=0;i<member.getAttributeSize();i++)
      {
        if(member.getAttribute(i).getName().equals(mainAttribute.getName()))
        {
          member.removeAttribute(i);
          break;
        }
      }
    }

    for(Subject member : noClass)
    {
      for(i=0;i<member.getAttributeSize();i++)
      {
        if(member.getAttribute(i).getName().equals(mainAttribute.getName()))
        {
          member.removeAttribute(i);
          break;
        }
      }
    }

    for(Subject member:yesClass)
    {
      member.resetAttributeRate();
      member.incrementAttributes();
    }
    
    max = -1;
    for(Subject member:yesClass)
    {
      Attribute attribute = member.getMaxAttribute();
      if(attribute != null && attribute.getRate() > max)
      {
        nextMainClassYes = attribute;
        max = attribute.getRate();
      }
    }
    
    if(nextMainClassYes == null)
    {
    		System.out.println("End of Node Reached...");
    }else {
    	nodeYes = new Node(nextMainClassYes, yesClass);
    }
    
    for(Subject member:noClass)
    {
      member.resetAttributeRate();
      member.incrementAttributes();
    }
    

    max = -1;
    for(Subject member:noClass)
    {
      Attribute attribute = member.getMaxAttribute();
      if(attribute != null && attribute.getRate() > max)
      {
        nextMainClassNo = attribute;
        max = attribute.getRate();
      }
    }
 
    if(nextMainClassNo == null)
    {
    		System.out.println("End of Node Reached...");
    }else {
    		nodeNo = new Node(nextMainClassNo, noClass);
    }

  }


}
