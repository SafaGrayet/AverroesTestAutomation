package com.Averroes.e2etests.stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Averroes.e2etests.base.BaseUtil;
import com.Averroes.e2etests.base.Setup;

import java.awt.*;
import java.awt.event.InputEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;


public class InsertionBDSteps {

public  static WebDriver driver;
	
	public InsertionBDSteps() throws AWTException  {
		driver = Setup.driver;
	}
	private LoginStep loginStep = new LoginStep ();
    Robot bot = new Robot();
    Actions builder = new Actions(Setup.driver);



    @And("^je réalise le workflow d'insertion dans la base de doonée$")
    public void jeRealiseLeWorkflowDInsertionDansLaBaseDeDoonee() throws Throwable {
        Thread.sleep(2000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 300);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        Actions builder = new Actions(Setup.driver);
        driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(3000);

        driver.findElement(By.id("startTask")).click();
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);

        WebDriverWait some_element = new WebDriverWait(driver,10000000);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sauvegarder')]")));

        driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

        driver.findElement(By.id("serviceTask")).click();
        //base.driver.findElement(By.id("startTask")).click();
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
        driver.findElement(By.id("sequenceFlow")).click();
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200, 200).click().build().perform();


        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

        driver.findElement(By.id("endEvent")).click();
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 400, 300).click().build().perform();
        driver.findElement(By.id("sequenceFlow")).click();


        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 400, 300).click().build().perform();
        driver.findElement(By.id("select")).click();
        return;
    }

    @And("^je créé le formulaire contenat les champs nom et prénom dans le noeud de début$")
    public void jeCreeLeFormulaireContenatLesChampsNomEtPrenomDansLeNoeudDeDebut() throws Throwable {
        Thread.sleep(5000);
        bot.mouseMove(1350, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(1000);
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();


        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
        // builder.moveToElement( base.driver.findElement(By.xpath("//div[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-designer']//div[@class='jspContainer']//div[@class='jspPane']")), 500 , 300).click().build().perform();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//em[contains(text(),'Designer de formulaire')]")).click();
        // base.driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'-form-builder')]")));
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);


        WebElement dragFrom = driver.findElement(By.xpath("//span[contains(@title,'Text Field')]"));
        WebElement dragTo = driver.findElement(By.className("dropzone"));

        loginStep.dragAndDropElement( dragFrom,  dragTo);


        Select dropdown = new Select(driver.findElement(By.id("key")));
        dropdown.getFirstSelectedOption();
        dropdown.selectByVisibleText("nom");

        driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        loginStep.dragAndDropElement( dragFrom,  dragTo);

        Select dropdown1 = new Select(driver.findElement(By.id("key")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("prenom");

        driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
        return;
    }

    @And("^je configure l'action de la tache système insertion dans la base de donnée$")
    public void jeConfigureLActionDeLaTacheSystemeInsertionDansLaBaseDeDonnee() throws Throwable {
        Thread.sleep(2000);

        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@href='#tab_1']")).click();


        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Insertion dans une base de données");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        Select dropdown6 = new Select(driver.findElement(By.name("prop_insert-intoDb_insertIntoDbConnection")));
        dropdown6.getFirstSelectedOption();
        dropdown6.selectByVisibleText("averroesDB");

        driver.findElement(By.xpath("//em[contains(text(),\"Requête sql d'insertion de données\")]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("request")).sendKeys("INSERT INTO test( nom, prenom) VALUES ('#nom', '#prenom');");
        Thread.sleep(2000);

        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('yui-button yui-submit-button')[0].click();");
        Thread.sleep(1000);
        return;

    }

    @When("^je lance le processus Insertion dans la base de donnée$")
    public void jeLanceLeProcessusInsertionDansLaBaseDeDonnee() throws Throwable {
        driver.findElement(By.linkText("Insertion dans la base de données")).click();

        Thread.sleep(4000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[contains(@name,'data[var-nom]')]")).sendKeys("Graaayeeet");

        driver.findElement(By.xpath("//input[contains(@name,'data[var-prenom]')]")).sendKeys("Saaafaaa");

        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        //bouton lancer
        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
        Thread.sleep(2000);
    return;
    }

    @Then("^je vois que les données saisies dans le formulaire sont bien insérer dans la base de donnée$")
    public void jeVoisQueLesDonneesSaisiesDansLeFormulaireSontBienInsererDansLaBaseDeDonnee() throws Throwable {

        Class.forName("org.postgresql.Driver");
        DriverManager.getConnection("jdbc:postgresql://localhost:5434/alfresco","alfresco","Safa1994");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5434/alfresco","alfresco","Safa1994");
        con.createStatement();
        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery("Select * from test");
        if (rs.next()) {
            String nomm= rs.getString("nom");
            String pre= rs.getString("prenom");
            System.out.println("les données sont bien insérer dans la base de données");


        }
        else {
            System.out.println("erreur lors de l'insertion des données");
        }


return;


    }
}



