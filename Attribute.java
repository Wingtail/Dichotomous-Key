

public class Attribute{
  private String name;
  private int rate;

  public Attribute()
  {
    name = "UNKNOWN";
    rate = 0;
  }

  public String getName()
  {
    return name;
  }

  public String toString()
  {
    return name;
  }

  public void setName(String key)
  {
    name = key;
  }

  public int getRate()
  {
    return rate;
  }

  public void resetRate()
  {
    rate = 0;
  }

  public int incrementRate()
  {
    rate++;
    return rate;
  }

  public void setRate(int key)
  {
    rate = key;
  }


}
