package core.annotation;

import java.lang.annotation.Documented;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Author(DeveloperName = "abdelaziz Sayed" , Salary=100000)
public class TestAnnotation {

	@Author(DeveloperName = "abdelaziz Sayed" , Salary=100000)
	public static String myName = "";
	String Date;
	
	@Author(DeveloperName = "Salma" , Salary=30000)
	 TestAnnotation(){
	 }
	
	@Author(DeveloperName = "Arwa" , Salary=40000)
	public static void myMeth(){
		try{	
			Class<?> clas = Class.forName("core.annotation.TestAnnotation");
			Field field = clas.getField("myName");
			Method method = clas.getMethod("myMeth");
			Author methodAnnotation = method.getAnnotation(Author.class);
			Author classAnnotation = clas.getAnnotation(Author.class);
			Author fieldAnnotation = field.getAnnotation(Author.class);
			System.out.println("myMeth Methode Developer Name Is : "+ methodAnnotation.DeveloperName() +" And "+"Salary Is : " + methodAnnotation.Salary());
			System.out.println("TestAnnotation Class Developer Name Is :  " + classAnnotation.DeveloperName() +" And " +"Salary Is : " + classAnnotation.Salary());
			System.out.println("myName Field Developer Name Is :  " + fieldAnnotation.DeveloperName() +" And " +"Salary Is : " + fieldAnnotation.Salary());

		}catch(ClassNotFoundException e){
			System.out.println("Not Found Class");
		}catch(NoSuchMethodException E){
			System.out.println("Not Found Method");
		}catch(NoSuchFieldException b){
			System.out.println("Not Found Field");
		}
		
	}
	public static void main(String args[])
	{
		myMeth();
	}
}
