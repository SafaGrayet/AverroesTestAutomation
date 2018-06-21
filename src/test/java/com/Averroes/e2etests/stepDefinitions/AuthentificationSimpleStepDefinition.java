package com.Averroes.e2etests.stepDefinitions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Averroes.e2etests.base.Setup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@Test
public class AuthentificationSimpleStepDefinition  {
	
	public  static WebDriver driver;
	
	public AuthentificationSimpleStepDefinition() {
		driver = Setup.driver;
	}
	
	@Given("^Utilisateur est dans la page Home$")
	public void utilisateur_est_dans_la_page_Home() throws Throwable {
		
		driver.get("https://rct-selogervacances.poliris.net/");
		Thread.sleep(2000);
		
	}

	@When("^Utilisateur navigue dans la page Connectez-vous$")
	public void utilisateur_navigue_dans_la_page_Connectez_vous() throws Throwable {
		
		driver.findElement(By.linkText("Connexion")).click();
		Thread.sleep(2000);
	    
	}

	@When("^Utilisateur entrer adreese email  et mot de passe$")
	public void utilisateur_entrer_adreese_email_et_mot_de_passe() throws Throwable {
	   
		driver.findElement(By.id("Identifiant")).sendKeys("zied.seloger.03@gmail.com"); 	
	    driver.findElement(By.id("MotDePasse")).sendKeys("123456zied");
	    driver.findElement(By.className("tagClick")).click();
	    
	    Thread.sleep(2000);
	}

	@Then("^Message affiche Connexion reussie$")
	public void message_affiche_Connexion_reussie() throws Throwable {
	    
		System.out.println("Login Successfully");
	}
	

}
