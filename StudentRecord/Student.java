/*
 *	Name	Ryan Nilo Ybañez
 *	Course	BSCS - IV
 *	Subject	Data Structure java implemented
 *
 **/

public class Student extends Person
{
	private Integer id;
	private String course;
	private String level;
	
	public Student(String firstname, String lastname, Integer id, String course, String level)
	{
		super(firstname,lastname);
		this.id 	= id;
		this.course = course;
		this.level 	= level;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public void SetCourse(String course)
	{
		this.course = course;
	}
	
	public void setLevel(String level)
	{
		this.level = level;
	}
	
	public Integer getIdNum()
	{
		return id;
	}
	
	public String getCourse()
	{
		return course;
	}
	
	public String getYearLevel()
	{
		return level;
	}
}