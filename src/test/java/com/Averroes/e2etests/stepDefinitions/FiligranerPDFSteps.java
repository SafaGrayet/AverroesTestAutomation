package com.Averroes.e2etests.stepDefinitions;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Averroes.e2etests.base.BaseUtil;
import com.Averroes.e2etests.base.Setup;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;


@Test
public class FiligranerPDFSteps {
public  static WebDriver driver;
	
	public FiligranerPDFSteps () throws AWTException  {
		driver = Setup.driver;
	}
    Robot bot = new Robot();
    Actions builder = new Actions(Setup.driver);



    @Given("^je connecte à Averroès en tant que admin$")
    public void jeConnecteAAverroesEnTantQueAdmin() throws Throwable {

        System.out.println("Connnexion valide à Avveroès");


    }

    @Then("^je vois le dashboard d'admin$")
    public void jeVoisLeDashboardDAdmin() throws Throwable { 
    	
    	Thread.sleep(3000);
    
       if(driver.findElement(By.id("global_x002e_header_x0023_default-searchText")).isEnabled()){
           System.out.println("dashboard admin s'ouvre");

       }
    }

    @And("^je clique sur le lien du dashlet administration processus$")
    public void jeCliqueSurLeLienDuDashletAdministrationProcessus() throws Throwable {

        Thread.sleep(1000);
      driver.findElement(By.xpath("//a[@href='/share/page/console/process/workflow-console'][contains(text(),'Voir tout')]")).click();



       driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }

    @And("^je créé un nouveau processus$")
    public void jeCreeUnNouveauProcessus() throws Throwable {

        //boutton.nouveauProcess.click();
        driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-newWorkflow-button-button")).click();
       driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);

        if( driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow-dialog")).isDisplayed()) {
            System.out.println("l'interface de création d'un process est affichée");

            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
         driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_cm_name")).sendKeys("Processus Filigraner PDF");

            driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-itemGroupActions")).click();
            driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
            driver.findElement(By.id("alf-id4")).click();
          driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-ok-button")).click();

           driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow-form-submit-button")).click();


        }
    }

    @And("^je réalise le workflow de filigranner PDF$")
    public void jeRealiseLeWorkflowDeFiligrannerPDF() throws Throwable {

       
        driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(3000);

        driver.findElement(By.id("startTask")).click();
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);
        Thread.sleep(500);
       driver.findElement(By.xpath("//em[contains(text(),'Documents attachés')]")).click();
       driver.findElement(By.xpath("//label[contains(text(),'Voir')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Ajouter')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Supprimer')]")).click();


        Thread.sleep(2000);

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

        builder.moveToElement(driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 400, 300).click().build().perform();
     driver.findElement(By.id("select")).click();


        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@href='#tab_1']")).click();






        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Filigraner PDF");



        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);



    }

    @And("^je configure l'action de la tache système$")
    public void jeConfigureLActionDeLaTacheSysteme() throws Throwable {
        Thread.sleep(3000);
        Select dropdown1 = new Select(driver.findElement(By.name("prop_wm-pdf_watermark-type")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Image");
        Thread.sleep(1000);
        bot.mouseMove(430, 270);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(4000);
        bot.mouseMove(650, 350);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(4000);
        bot.mouseMove(1000, 580);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);







      driver.findElement(By.xpath("//input[contains(@id,'prop_wdm_workflowServiceTaskProcessing-watermark-pdf_prop_cm_name')]")).sendKeys("fichier filigrané");
        Select dropdown2 = new Select(driver.findElement(By.name("prop_wm-pdf_emplacement")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Statique");

        Thread.sleep(1000);
        bot.mouseMove(430, 470);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(4000);
        bot.mouseMove(500, 320);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);



        driver.findElement(By.xpath("//button[contains(@id,'locationDialog-ok-button')]")).click();

        //documents attachés
       driver.findElement(By.xpath("//span[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-watermark-pdf_prop_wm-pdf_variables-type')]")).click();
        driver.findElement(By.xpath("//label[contains(@for,'pdf_variables-type-i1')]")).click();

        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);


        Select dropdown4 = new Select(driver.findElement(By.xpath("//select[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-watermark-pdf_prop_wm-pdf_watermark-depth')]")));
        dropdown4.getFirstSelectedOption();
        dropdown4.selectByVisibleText("Au-dessus");
       driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        Select dropdown5 = new Select(driver.findElement(By.name("prop_wm-pdf_watermark-page")));
        dropdown5.getFirstSelectedOption();
        dropdown5.selectByVisibleText("Toutes");

       driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

     driver.findElement(By.xpath("//button[contains(@id,'wdm_workflowServiceTaskProcessing-watermark-pdf-form-submit-button')]")).click();












    }

    @And("^je clique sur l'icone générer$")
    public void jeCliqueSurLIconeGenerer() throws Throwable {
        Thread.sleep(5000);
        bot.mouseMove(1350, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
       driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //bouton générer
     driver.findElement(By.xpath("//button[contains(@id,'generateWorkflow-button-button')]")).click();
      Thread.sleep(55000);
    }

    @And("^je clique sur l'icone activer$")
    public void jeCliqueSurLIconeActiver() throws Throwable {
        //liste de processus
     driver.findElement(By.xpath("//em[contains(text(),'LISTE DES PROCESSUS')]")).click();
      driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //icone d'activation du processus
        Thread.sleep(4000);
        bot.mouseMove(1160, 310);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[contains(@id,'-button')]")).click();
        Thread.sleep(2000);


    }

    @And("^je consule la dashlet processus$")
    public void jeConsuleLaDashletProcessus() throws Throwable {
        Thread.sleep(2000);
       driver.navigate().to("http://127.0.0.1:8099/share/page/");

        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/share/page/workflows']")));

       driver.findElement(By.xpath("//a[@href='/share/page/workflows']")).click();
       Thread.sleep(5000);
       //driver.findElement(By.xpath("//*[@id=\"body\"]/ul/li/h3/text()")).click();
       //driver.findElement(By.xpath("//h3[contains(text(),'General')]")).click();
       
      /* WebElement btnG = driver.findElement(By.xpath("//h3[contains(text(),'General')]"));
       Actions build = new Actions(driver);
       build.moveToElement(btnG).build().perform();*/
       
       //driver.findElement(By.linkText("General")).click();
       

    }

    @And("^je lance le processus$")
    public void jeLanceLeProcessus() throws Throwable {
        Thread.sleep(2000);
       driver.findElement(By.linkText("Processus Filigraner PDF")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[contains(text(),'Document existant')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("alf-id8")).click();

     driver.findElement(By.xpath("//button[contains(@id,'packageItems-cntrl-ok-button')]")).click();

        //bouton lancer
        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @And("^je consulte la dashlet Bibliothéque$")
    public void jeConsulteLaDashletBibliotheque() throws Throwable {
        Thread.sleep(2000);
      driver.navigate().to("http://localhost:8099/share/page/site/averroes/documentlibrary");

        driver.findElement(By.name("username")).sendKeys("admin");
       driver.findElement(By.name("password")).sendKeys("Safa1994");

      driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();
      
        Thread.sleep(4000);
        
        
    }

    
    
	@SuppressWarnings("deprecation")
	@Then("^je trouve le document filigrané$")
    public void jeTrouveLeDocumentFiligrane() throws Throwable {
    	driver.findElement(By.linkText("Filigrane")).click();
        Thread.sleep(2000);
        
       // Assert.assertTrue(driver.findElement(By.linkText("Filigrane")).isEnabled());
        
        driver.findElement(By.linkText("test.pdf")).click();
        
        

    }
}











