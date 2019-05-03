
public class Person
{
	private String fName;
	private String lName;
	
	public Person(String firstname, String lastname)
	{
		fName = firstname;
		lName = lastname;
	}
	
	public void setFirstName(String firstname)
	{
		fName = firstname;
	}
	
	public void setLastName(String lastname)
	{
		lName = lastname;
	}
	
	public String getFirstName()
	{
		return fName;
	}
	
	public String getLastName()
	{
		return lName;
	}
}