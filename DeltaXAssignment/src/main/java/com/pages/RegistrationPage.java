package com.pages;



import com.utils.Actions;
import com.utils.ObjectLocator;


public class RegistrationPage {

	
	public static ObjectLocator firstName = new ObjectLocator("Name", "first_name",
			" First Name ");
	public static ObjectLocator lastName = new ObjectLocator("Name", "last_name",
			" Last Name ");
	public static ObjectLocator departmentName = new ObjectLocator("Name", "department",
			" Department ");
	public static ObjectLocator usernameName = new ObjectLocator("Name", "user_name",
			" user Name ");
	public static ObjectLocator password = new ObjectLocator("Name", "user_password",
			" password ");
	public static ObjectLocator confirmPassword = new ObjectLocator("Name", "confirm_password",
			" Confirm Passowrd ");
	public static ObjectLocator email = new ObjectLocator("Name", "email",
			" Email ");
	public static ObjectLocator phoneNumber = new ObjectLocator("Name", "contact_no",
			" phone Number ");
	public static ObjectLocator submitButton = new ObjectLocator("Xpath", "//button[@type='submit']",
			" submit button ");
	public static ObjectLocator regristrationFormHeader = new ObjectLocator("Xpath", "//b[normalize-space(.)='Registration Form']",
			" submit button ");
	
	public static ObjectLocator emptyFiled = new ObjectLocator("Xpath", "//small[normalize-space(.)='$']",
			" Empty Field validation ");
	public static ObjectLocator inValidError = new ObjectLocator("Xpath", "//small[@data-bv-validator-for='$' and normalize-space(.)='This value is not valid']", "Not a valid Field ");
	
	public static ObjectLocator ThanksNote = new ObjectLocator("Xpath", "//b[normalize-space(.)='Thanks']", " Thanks Note ");
	
	
	
	
	public void VerifyAllFields(){

		Actions.Assertrue(Actions.IsVisible(firstName), "First Name is visible");
		Actions.Assertrue(Actions.FindElement(lastName).isDisplayed(), "Last Name is visible");
		Actions.Assertrue(Actions.FindElement(usernameName).isDisplayed(), "User name field is visible");
		Actions.Assertrue(Actions.FindElement(departmentName).isDisplayed(), " Department field is visible");
		Actions.Assertrue(Actions.FindElement(password).isDisplayed(), " Password field is visible");
		Actions.Assertrue(Actions.FindElement(confirmPassword).isDisplayed(), " Confirm password  is visible");
		Actions.Assertrue(Actions.FindElement(email).isDisplayed(), "Email field is visible");
		Actions.Assertrue(Actions.FindElement(phoneNumber).isDisplayed(), "Phhone Number is visible");
	}
	
	public void VerifyFieldValidationMessage(){
		
		Actions.FindElement(submitButton).click();
		
		Actions.Assertrue(Actions.FindElement(emptyFiled.ReplaceLocator("$", "Please enter your First Name")).isDisplayed(), "Please enter your First Name error message displayed");
		Actions.Assertrue(Actions.FindElement(emptyFiled.ReplaceLocator("$", "Please enter your Last Name")).isDisplayed(), "Please enter your Last Name error message displayed");
		Actions.Assertrue(Actions.FindElement(emptyFiled.ReplaceLocator("$", "Please enter your Username")).isDisplayed(), "Please enter your Username error message displayed");
		Actions.Assertrue(Actions.FindElement(emptyFiled.ReplaceLocator("$", "Please enter your Password")).isDisplayed(), "Please enter your Password error message displayed");
		Actions.Assertrue(Actions.FindElement(emptyFiled.ReplaceLocator("$", "Please confirm your Password")).isDisplayed(), "Please confirm your Password error message displayed");
		Actions.Assertrue(Actions.FindElement(emptyFiled.ReplaceLocator("$", "Please enter your Email Address")).isDisplayed(), "Please enter your Email Address error message displayed");
	}
	
	public void VerifyErrorFieldValidation(){
		
		
		Actions.EnterText(firstName, "1");
		
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "first_name")).isDisplayed(), "This value is not valid error message displayed for first name");
		
		Actions.EnterText(firstName, "#");
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "first_name")).isDisplayed(), "This value is not valid error message displayed for first name");
		Actions.EnterText(firstName, "sasidhar");
		
		Actions.EnterText(lastName, "a");
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "last_name")).isDisplayed(), "Please enter valid Last Name error message displayed for last name ");
		
		Actions.EnterText(lastName, "#");
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "last_name")).isDisplayed(), "Please enter valid Last Name error message displayed for last name ");
		
		Actions.EnterText(lastName, "1234");
		
		
		Actions.EnterText(usernameName, "abc123");
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "user_name")).isDisplayed(), "This value is not valid error message displayed for username ");
		
		Actions.EnterText(usernameName, "abc##");
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "user_name")).isDisplayed(), "This value is not valid error message displayed  for username ");
		
		Actions.EnterText(usernameName, "123");
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "user_name")).isDisplayed(), "This value is not valid error message displayed  for username ");
		Actions.EnterText(usernameName, "Vsasidhar123");
		
		Actions.EnterText(password, "abc123");
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "user_password")).isDisplayed(), "This value is not valid error message displayed  for Password ");
		Actions.EnterText(password, "123");
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "user_password")).isDisplayed(), "This value is not valid error message displayed  for Password ");
		Actions.EnterText(password, "abc123456");
		
		
		
		Actions.EnterText(confirmPassword, "abc123");
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "confirm_password")).isDisplayed(), "This value is not valid error message displayed for confirm passowrd ");
		Actions.EnterText(confirmPassword, "34#");
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "confirm_password")).isDisplayed(), "This value is not valid error message displayed for confirm passowrd");
		Actions.EnterText(confirmPassword, "abc");
		Actions.Assertrue(Actions.FindElement(inValidError.ReplaceLocator("$", "confirm_password")).isDisplayed(), "This value is not valid error message displayed for confirm passowrd");
		Actions.EnterText(confirmPassword, "abc4567654");
		Actions.Assertrue(Actions.IsDisplayed(inValidError.ReplaceLocator("$", "confirm_password")), "This value is not valid error message displayed for confirm passowrd");
	
		Actions.EnterText(email, "resddy@gmail");
		Actions.Assertrue(Actions.IsDisplayed(inValidError.ReplaceLocator("$", "email")), "This value is not valid error message displayed for Email");
		Actions.EnterText(email, "resddy.gmail@com");
		Actions.Assertrue(Actions.IsDisplayed(inValidError.ReplaceLocator("$", "email")), "This value is not valid error message displayed for Email");
		Actions.EnterText(email, "resddy.gmail");
		Actions.Assertrue(Actions.IsDisplayed(inValidError.ReplaceLocator("$", "email")), "This value is not valid error message displayed for Email");
		Actions.EnterText(email, "resddy@gmail@gmail.com");
		Actions.Assertrue(Actions.IsDisplayed(inValidError.ReplaceLocator("$", "email")), "This value is not valid error message displayed for Email");
		Actions.EnterText(email, "resddygmail@gmail.com");
	
		Actions.EnterText(phoneNumber, "70346048123456");
		Actions.Assertrue(Actions.IsDisplayed(inValidError.ReplaceLocator("$", "contact_no")), "This value is not valid error message displayed for phone");
		Actions.EnterText(phoneNumber, "123456");
		Actions.Assertrue(Actions.IsDisplayed(inValidError.ReplaceLocator("$", "contact_no")), "This value is not valid error message displayed for phone");
		Actions.EnterText(phoneNumber, "70346048sd");
		Actions.Assertrue(Actions.IsDisplayed(inValidError.ReplaceLocator("$", "contact_no")), "This value is not valid error message displayed for phone");
		
	}
	
	public void registerUser(String firstname, String lastname, String department, String username, String passowrd, String confirmPassowrd, String emailID, String phonenumber){
		
		Actions.EnterText(firstName, firstname);
		Actions.EnterText(lastName, lastname);
		Actions.SelectbyVisibleText(departmentName, department);
		Actions.EnterText(usernameName, username);
		Actions.EnterText(password,passowrd);
		Actions.EnterText(confirmPassword, confirmPassowrd);
		Actions.EnterText(email, emailID);
		Actions.EnterText(phoneNumber, phonenumber);
		Actions.FindElement(submitButton).click();
		Actions.Assertrue(Actions.IsDisplayed(ThanksNote), " Thanks Note Dislayed Successfully ");
	}
	
	
	

}
