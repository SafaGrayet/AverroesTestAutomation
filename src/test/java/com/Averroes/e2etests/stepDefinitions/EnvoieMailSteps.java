package com.Averroes.e2etests.stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Averroes.e2etests.base.Setup;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;
@Test
public class EnvoieMailSteps {
	public  static WebDriver driver;
	public EnvoieMailSteps() throws AWTException  {
		driver = Setup.driver;
	}
    Robot bot = new Robot();
    Actions builder = new Actions(Setup.driver);

    



    @Then("^je réalise le workflow de Envoie Mail$")
    public void jeRealiseLeWorkflowDeEnvoieMail() throws Throwable {

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

    }

    @And("^je configure la tache système envoie mail$")
    public void jeConfigureLaTacheSystemeEnvoieMail() throws Throwable {
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
        dropdown1.selectByVisibleText("Envoi de mail");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        WebDriverWait some_element = new WebDriverWait(driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.id("Input")));
        driver.findElement(By.id("Input")).sendKeys("safa");
        driver.findElement(By.xpath("//span[@style='cursor: pointer;']")).click();
        driver.findElement(By.xpath("//input[contains(@id,'mail_sendMailSubject')]")).sendKeys("test");
        driver.findElement(By.xpath("//textarea[contains(@id,'editProcessing_prop_send-mail_sendMailText')]")).sendKeys("mail test");
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();



    }

    @When("^je lance le processus Evoie Mail à un utilisateur statique$")
    public void jeLanceLeProcessusEvoieMailAUnUtilisateurStatique() throws Throwable {
        driver.findElement(By.linkText("Evoie Mail à un utilisateur statique")).click();
        Thread.sleep(5000);
        //bouton lancer
        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
        Thread.sleep(2000);
    }

    @Then("^je reçue le mail dans la boite de réception de l'utilisateur indiqué statiquement$")
    public void jeRecueLeMailDansLaBoiteDeReceptionDeLUtilisateurIndiqueStatiquement() throws Throwable {

    }

    @And("^je configure la tache système envoie mail à un initiateur$")
    public void jeConfigureLaTacheSystemeEnvoieMailAUnInitiateur() throws Throwable {
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
        dropdown1.selectByVisibleText("Envoi de mail");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'autocomplete-recievers-selector')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("initiateur");


        driver.findElement(By.xpath("//input[contains(@id,'mail_sendMailSubject')]")).sendKeys("test");
        driver.findElement(By.xpath("//textarea[contains(@id,'editProcessing_prop_send-mail_sendMailText')]")).sendKeys("mail test");
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }

    @When("^je lance le processus Evoie Mail à un initiateur$")
    public void jeLanceLeProcessusEvoieMailAUnInitiateur() throws Throwable {
        driver.findElement(By.linkText("Evoie Mail à un initiateur")).click();
        Thread.sleep(5000);
        //bouton lancer
        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
        Thread.sleep(2000);
    }


    @Then("^je reçue le mail dans la boite de réception de l'initiateur$")
    public void jeRecueLeMailDansLaBoiteDeReceptionDeLInitiateur() throws Throwable {

    }

    @And("^je configure la tache système Evoie Mail à un utilisateur dynamique$")
    public void jeConfigureLaTacheSystemeEvoieMailAUnUtilisateurDynamique() throws Throwable {
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
        dropdown1.selectByVisibleText("Envoi de mail");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'autocomplete-recievers-selector')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Dynamique");
        driver.findElement(By.id("Input")).sendKeys("user");
        driver.findElement(By.xpath("//span[@style='cursor: pointer;']")).click();



        driver.findElement(By.xpath("//input[contains(@id,'mail_sendMailSubject')]")).sendKeys("test");
        driver.findElement(By.xpath("//textarea[contains(@id,'editProcessing_prop_send-mail_sendMailText')]")).sendKeys("mail test");
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();

    }

    @Then("^je reçue le mail dans la boite de réception de l'utilisateur indiqué dynamiquement$")
    public void jeRecueLeMailDansLaBoiteDeRcceptionDeLUtilisateurIndiqucDynamiquement() throws Throwable {

    }

    @When("^je lance le processus Evoie Mail à un utilisateur dynamique$")
    public void jeLanceLeProcessusEvoieMailAUnUtilisateurDynamique() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.linkText("Evoie Mail à un utilisateur dynamique")).click();
        Thread.sleep(4000);

        bot.mouseMove(700, 230);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(3000);
        bot.mouseMove(700, 350);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //bouton lancer
        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
        Thread.sleep(2000);


    }

    @And("^je configure la tache système Evoie Mail à un chef hiérarchique statique$")
    public void jeConfigureLaTacheSystemeEvoieMailAUnChefHierarchiqueStatique() throws Throwable {
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
        dropdown1.selectByVisibleText("Envoi de mail");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'autocomplete-recievers-selector')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Chef Hierarchique");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Choisir un Chef Hierarchique']")).sendKeys("groupe");
        driver.findElement(By.xpath("//li[@class='yui-ac-highlight']//span[@style='cursor: pointer;']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        WebDriverWait some_element1 = new WebDriverWait(driver,100);
        some_element1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'mail_sendMailSubject')]")));


        driver.findElement(By.xpath("//input[contains(@id,'mail_sendMailSubject')]")).sendKeys("test");
        driver.findElement(By.xpath("//textarea[contains(@id,'editProcessing_prop_send-mail_sendMailText')]")).sendKeys("mail test");
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }

    @When("^je lance le processus Evoie Mail à un chef hiérarchique statique$")
    public void jeLanceLeProcessusEvoieMailAUnChefHierarchiqueStatique() throws Throwable {
        driver.findElement(By.linkText("Evoie Mail à un chef hiérarchique statique")).click();
        Thread.sleep(5000);
        //bouton lancer
        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
        Thread.sleep(2000);

    }

    @Then("^je reçue le mail dans la boite de réception du chef hiérarchique statique$")
    public void jeRecueLeMailDansLaBoiteDeReceptionDuChefHierarchiqueStatique() throws Throwable {

    }

    @And("^je configure la tache système Evoie Mail au chef hiérarchique de l'initiateur$")
    public void jeConfigureLaTacheSystemeEvoieMailAuChefHierarchiqueDeLInitiateur() throws Throwable {
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
        dropdown1.selectByVisibleText("Envoi de mail");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'autocomplete-recievers-selector')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Chef Hierarchique");

        Thread.sleep(2000);
        Select dropdown3 = new Select( driver.findElement(By.xpath("//select[contains(@id,'-form_prop_wdm_workflowServiceTaskProcessing-editProcessing_prop_send-mail_sendMailTo-cntrl-chief-dialog-form-selector')]")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("initiateur");

        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        WebDriverWait some_element1 = new WebDriverWait(driver,100);
        some_element1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'mail_sendMailSubject')]")));


        driver.findElement(By.xpath("//input[contains(@id,'mail_sendMailSubject')]")).sendKeys("test");
        driver.findElement(By.xpath("//textarea[contains(@id,'editProcessing_prop_send-mail_sendMailText')]")).sendKeys("mail test");
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }

    @Then("^je reçue le mail dans la boite de réception du chef hiérarchique de l'initiateur$")
    public void jeRecueLeMailDansLaBoiteDeReceptionDuChefHierarchiqueDeLInitiateur() throws Throwable {

    }

    @When("^je lance le processus Evoie Mail au chef hiérarchique de l'initiateur$")
    public void jeLanceLeProcessusEvoieMailAuChefHierarchiqueDeLInitiateur() throws Throwable {
        driver.findElement(By.linkText("Evoie Mail au chef hiérarchique de l'initiateur")).click();
        Thread.sleep(5000);
        //bouton lancer
        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
        Thread.sleep(2000);
    }

    @And("^je configure la tache système Envoie mail au chef hiérarchique d'un utilisateur dynamique$")
    public void jeConfigureLaTacheSystemeEnvoieMailAuChefHierarchiqueDUnUtilisateurDynamique() throws Throwable {
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
        dropdown1.selectByVisibleText("Envoi de mail");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'autocomplete-recievers-selector')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Chef Hierarchique");

        Thread.sleep(2000);
        Select dropdown3 = new Select( driver.findElement(By.xpath("//select[contains(@id,'-form_prop_wdm_workflowServiceTaskProcessing-editProcessing_prop_send-mail_sendMailTo-cntrl-chief-dialog-form-selector')]")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("dynamique");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Choisir un Chef Hierarchique']")).sendKeys("user");
        driver.findElement(By.xpath("//li[@class='yui-ac-highlight']//span[@style='cursor: pointer;']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        WebDriverWait some_element1 = new WebDriverWait(driver,100);
        some_element1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'mail_sendMailSubject')]")));


        driver.findElement(By.xpath("//input[contains(@id,'mail_sendMailSubject')]")).sendKeys("test");
        driver.findElement(By.xpath("//textarea[contains(@id,'editProcessing_prop_send-mail_sendMailText')]")).sendKeys("mail test");
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }


    @When("^je lance le processus Envoie mail au chef hiérarchique d'un utilisateur dynamique$")
    public void jeLanceLeProcessusEnvoieMailAuChefHierarchiqueDUnUtilisateurDynamique() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.linkText("Envoie mail au chef hiérarchique d'un utilisateur dynamique")).click();
        Thread.sleep(4000);

        bot.mouseMove(700, 230);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(3000);
        bot.mouseMove(700, 350);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //bouton lancer
        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
        Thread.sleep(2000);
    }

    @Then("^je reçue le mail dans la boite de réception du chef hiérarchique de l'utilisateur indiqué dynamiquement$")
    public void jeRecueLeMailDansLaBoiteDeReceptionDuChefHierarchiqueDeLUtilisateurIndiqueDynamiquement() throws Throwable {

    }
}
