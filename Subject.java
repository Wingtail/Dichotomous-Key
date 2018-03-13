import java.util.ArrayList;

public class Subject{
  private ArrayList<Attribute> attributes;
  private String name;

  public Subject()
  {
    attributes = new ArrayList<Attribute>();
    name = "UNKNOWN";
  }

  public String toString()
  {
    return name;
  }

  public boolean hasAttribute(String key)
  {
    for(Attribute attribute : attributes)
    {
      if(attribute.getName().equals(key))
      {
        return true;
      }
    }
    return false;
  }

  public Attribute getMaxAttribute()
  {
    int min = -999;
    Attribute attri = null;
    for(Attribute attribute : attributes)
    {
      if(attribute.getRate() > min)
      {
        attri = attribute;
        min = attribute.getRate();
      }
    }
    return attri;
  }

  public void resetAttributeRate()
  {
    for(Attribute attribute : attributes)
    {
      attribute.resetRate();
    }
  }

  public void incrementAttributes()
  {
    for(Attribute attribute : attributes)
    {
      attribute.incrementRate();
    }
  }

  public void addAttribute(Attribute attribute)
  {
    attributes.add(attribute);
  }

  public String getName()
  {
    return name;
  }

  public Attribute getAttribute(int index)
  {
    return attributes.get(index);
  }

  public int getAttributeSize()
  {
    return attributes.size();
  }

  public void setAttribute(Attribute trait, int index)
  {
    attributes.set(index, trait);
  }

  public Attribute removeAttribute(int index)
  {
    return attributes.remove(index);
  }

  public void setName(String key)
  {
    name = key;
  }



}
