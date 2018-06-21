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
import org.testng.annotations.Test;

import com.Averroes.e2etests.base.BaseUtil;
import com.Averroes.e2etests.base.Setup;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;


@Test
public class CopieDepDocTest {

	public  static WebDriver driver;
	
	public CopieDepDocTest() throws AWTException  {
		driver = Setup.driver;
	}
	
	private LoginStep loginStep = new LoginStep ();
	
   

    Robot bot = new Robot();
    Actions builder = new Actions(Setup.driver);


    @And("^je réalise le workflow Déplacement d'un document statique dans un emplacement statique$")
    public void jeRealiseLeWorkflowDeplacementDUnDocumentStatiqueDansUnEmplacementStatique() throws Throwable {
        Thread.sleep(2000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 300);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        Actions builder = new Actions(Setup.driver);
        driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(1000);

        driver.findElement(By.id("startTask")).click();
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);


        WebDriverWait some_element = new WebDriverWait(driver,10000000);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sauvegarder')]")));

        driver.findElement(By.xpath("//em[contains(text(),'Documents attachés')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Voir')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Ajouter')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Supprimer')]")).click();


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

    @And("^je configure l'action de la tache système Déplacement d'un document statique dans un emplacement statique$")
    public void jeConfigureLActionDeLaTacheSystemeDeplacementDUnDocumentStatiqueDansUnEmplacementStatique() throws Throwable {

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
        dropdown1.selectByVisibleText("Déplacement Copie Des Documents");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        //déplacement
        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'prop_dep-cpy_operation')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Déplacement");
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        //documents attachés
        driver.findElement(By.xpath("//span[@style='display: inline-block; white-space: nowrap; overflow: hidden; width: 150px; text-overflow: ellipsis;']")).click();
        driver.findElement(By.xpath("//label[contains(@for,'deplacementCopieDocuments_prop_dep-cpy_elementsType-type-i1')]")).click();
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //cliquer sur le boutton sélectionner
        driver.findElement(By.xpath("//button[contains(text(),'Sélectionner')]")).click();
        WebDriverWait some_element = new WebDriverWait(driver,10000);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Filigrane')]")));
        //cliquer sur le dossier Filigrane
        driver.findElement(By.xpath("//span[contains(text(),'Filigrane')]")).click();
        //cliquer sur OK
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        WebDriverWait some_elemet = new WebDriverWait(driver,10000);
        some_elemet.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enregistrer')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();

    }

    @When("^je lance le processus Déplacement d'un document statique dans un emplacement statique$")
    public void jeLanceLeProcessusDeplacementDUnDocumentStatiqueDansUnEmplacementStatique() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.linkText("Déplacement d'un document statique dans un emplacement statique")).click();
        Thread.sleep(5000);


        //bouton lancer
        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @Then("^je vois le document est bien placer dans l'emplacemrnt indiqué statiquement$")
    public void jeVoisLeDocumentEstBienPlacerDansLEmplacemrntIndiqueStatiquement() throws Throwable {
        driver.findElement(By.linkText("Filigrane")).click();
        Thread.sleep(2000);
       String nn= driver.findElement(By.xpath("//a[contains(text(),'CV_Grayet_Safa.pdf')]")).getText();
       if(nn.equals("CV_Grayet_Safa-1.pdf")){
           System.out.println("le fichier a été déplacer avec succès");
       }else
           System.out.println("Le fichier n'a pas été deplacer");

    }

    @Then("^je réalise le workflow de Déplacement d'un document dynamique dans un emplacement statique$")
    public void jerealiseLeWorkflowDeDeplacementDUnDocumentDynamiqueDansUnEmplacementStatique() throws Throwable {
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

    @And("^je créé le formulaire contenat le champs fichier dans le noeud de début$")
    public void jeCreeLeFormulaireContenatLeChampsFichierDansLeNoeudDeDebut() throws Throwable {
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

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Composants de base')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Composants Averroes')]")).click();


        WebElement dragFrom1 = driver.findElement(By.xpath("//span[contains(@title,'Contenu GED')]"));
        WebElement dragTo1 = driver.findElement(By.className("dropzone"));

        loginStep.dragAndDropElement( dragFrom1,  dragTo1);


        Select dropdown2 = new Select(driver.findElement(By.id("key")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("fichier");

        driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
    }

    @And("^je configure la tache système Déplacement d'un document dynamique dans un emplacement statique$")
    public void jeConfigureLaTacheSystemeDeplacementDUnDocumentDynamiqueDansUnEmplacementStatique() throws Throwable {
        //cliquer sur la tache système
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
        //scroll down
        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //cliquer sur "configuration
        driver.findElement(By.xpath("//a[@href='#tab_1']")).click();

        //choisir l'action "Déplacement Copie Des Documents"
        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Déplacement Copie Des Documents");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        //déplacement
        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'prop_dep-cpy_operation')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Déplacement");
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        //documents attachés
        driver.findElement(By.xpath("//span[@style='display: inline-block; white-space: nowrap; overflow: hidden; width: 150px; text-overflow: ellipsis;']")).click();
        driver.findElement(By.xpath("//label[contains(@for,'deplacementCopieDocuments_prop_dep-cpy_elementsType-type-i2')]")).click();
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //cliquer sur le boutton sélectionner
        driver.findElement(By.xpath("//button[contains(text(),'Sélectionner')]")).click();
        WebDriverWait someelement = new WebDriverWait(driver,10000);
        someelement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Filigrane')]")));
        //cliquer sur le dossier Filigrane
        driver.findElement(By.xpath("//span[contains(text(),'Filigrane')]")).click();
        //cliquer sur OK
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        WebDriverWait someelemet = new WebDriverWait(driver,10000);
        someelemet.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enregistrer')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }

    @When("^je lance le processus Déplacement d'un document dynamique dans un emplacement statique$")
    public void jeLanceLeProcessusDeplacementDUnDocumentDynamiqueDansUnEmplacementStatique() throws Throwable {
        driver.findElement(By.linkText("Déplacement d'un document dynamique dans un emplacement statique")).click();

        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));


        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[0].click();");
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.id("alf-id8")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        driver.switchTo().defaultContent();


        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @And("^je trouve le document est bien déplacer dans l'emplacemrnt indiqué statiquemente$")
    public void jeTrouveLeDocumentEstBienDeplacerDansLEmplacemrntIndiqueStatiquemente() throws Throwable {
        WebDriverWait some_element = new WebDriverWait(driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Filigrane")));
        driver.findElement(By.linkText("Filigrane")).click();
        Thread.sleep(2000);
        String nn= driver.findElement(By.xpath("//a[contains(text(),'CV_Grayet_Safa-2.pdf')]")).getText();

        if(nn.equals("CV_Grayet_Safa-2.pdf")){
            System.out.println("le fichier a été déplacer avec succès");
        }else
            System.out.println("Le fichier n'a pas été deplacer");
    }

    @Then("^je réalise le workflow de Déplacement d'un document statique dans un emplacement dynamique$")
    public void jeRealiseLeWorkflowDeDeplacementDUnDocumentStatiqueDansUnEmplacementDynamique() throws Throwable {
        Thread.sleep(2000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 300);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        Actions builder = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(3000);

        driver.findElement(By.id("startTask")).click();
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);

        WebDriverWait some_element = new WebDriverWait(driver,10000000);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sauvegarder')]")));


        driver.findElement(By.xpath("//em[contains(text(),'Documents attachés')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Voir')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Ajouter')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Supprimer')]")).click();

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

    @And("^je créé le formulaire contenat le champ dossier dans le noeud de début$")
    public void jeCreeLeFormulaireContenatLeChampDossierDansLeNoeudDeDebut() throws Throwable {
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

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Composants de base')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Composants Averroes')]")).click();


        WebElement dragFrom1 = driver.findElement(By.xpath("//span[contains(@title,'Contenu GED')]"));
        WebElement dragTo1 = driver.findElement(By.className("dropzone"));

        loginStep.dragAndDropElement( dragFrom1,  dragTo1);


        Select dropdown2 = new Select(driver.findElement(By.id("key")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("dossier");

        driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
    }

    @And("^je configure la tache système Déplacement d'un document statique dans un emplacement dynamique$")
    public void jeConfigureLaTacheSystemeDeplacementDUnDocumentStatiqueDansUnEmplacementDynamique() throws Throwable {
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
        dropdown1.selectByVisibleText("Déplacement Copie Des Documents");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        //déplacement
        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'prop_dep-cpy_operation')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Déplacement");
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        //documents attachés
        driver.findElement(By.xpath("//span[@style='display: inline-block; white-space: nowrap; overflow: hidden; width: 150px; text-overflow: ellipsis;']")).click();
        driver.findElement(By.xpath("//label[contains(@for,'deplacementCopieDocuments_prop_dep-cpy_elementsType-type-i1')]")).click();
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //emplacement dynamique
        Select dropdown3 = new Select(driver.findElement(By.xpath("//select[contains(@name,'prop_dep-cpy_emplacement')]")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("Dynamique");
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        WebDriverWait some_elemet = new WebDriverWait(driver,10000);
        some_elemet.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enregistrer')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }

    @When("^je lance le processus Déplacement d'un document statique dans un emplacement dynamique$")
    public void jeLanceLeProcessusDeplacementDUnDocumentStatiqueDansUnEmplacementDynamique() throws Throwable {
        driver.findElement(By.linkText("Déplacement d'un document statique dans un emplacement dynamique")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Document existant')]")).click();
        Thread.sleep(500);
        driver.findElement(By.id("alf-id8")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();


        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));
        Thread.sleep(2000);

        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[0].click();");
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("document.getElementById('alf-id9').click();");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[contains(@id,'dossier-cntrl-ok-button')]")).click();

        driver.switchTo().defaultContent();



        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();

    }

    @And("^je trouve le fichier déplacé dans l'enplacement dynamique indiqué dans le formulaire$")
    public void jeTrouveLeFichierDeplaceDansLEnplacementDynamiqueIndiqueDansLeFormulaire() throws Throwable {
        WebDriverWait some_element = new WebDriverWait(driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Filigrane")));
        driver.findElement(By.linkText("Filigrane")).click();
        Thread.sleep(2000);
        String nn= driver.findElement(By.xpath("//a[contains(text(),'test.pdf')]")).getText();

        if(nn.equals("test.pdf")){
            System.out.println("le fichier a été déplacer avec succès");
        }else
            System.out.println("Le fichier n'a pas été deplacer");
    }

    @Then("^je réalise le workflow de Déplacement d'un document dynamique dans un emplavement dynamique$")
    public void jeRealiseLeWorkflowDeDeplacementDUnDocumentDynamiqueDansUnEmplavementDynamique() throws Throwable {
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

    @And("^je créé le formulaire contenat les champs fichier,dossier dans le noeud de début$")
    public void jeCreeLeFormulaireContenatLesChampsFichierDossierDansLeNoeudDeDebut() throws Throwable {
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

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Composants de base')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Composants Averroes')]")).click();


        WebElement dragFrom1 = driver.findElement(By.xpath("//span[contains(@title,'Contenu GED')]"));
        WebElement dragTo1 = driver.findElement(By.className("dropzone"));

        loginStep.dragAndDropElement( dragFrom1,  dragTo1);


        Select dropdown2 = new Select(driver.findElement(By.id("key")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("dossier");

        driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();
        Thread.sleep(1000);

        loginStep.dragAndDropElement( dragFrom1,  dragTo1);


        Select dropdown3 = new Select(driver.findElement(By.id("key")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("fichier");

        driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();


        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
    }

    @And("^je configure la tache système Déplacement d'un document dynamique dans un emplavement dynamique$")
    public void jeConfigureLaTacheSystemeDeplacementDUnDocumentDynamiqueDansUnEmplavementDynamique() throws Throwable {
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
        dropdown1.selectByVisibleText("Déplacement Copie Des Documents");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        //déplacement
        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'prop_dep-cpy_operation')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Déplacement");
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        //documents attachés
        driver.findElement(By.xpath("//span[@style='display: inline-block; white-space: nowrap; overflow: hidden; width: 150px; text-overflow: ellipsis;']")).click();
        driver.findElement(By.xpath("//label[contains(@for,'deplacementCopieDocuments_prop_dep-cpy_elementsType-type-i2')]")).click();
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //emplacement dynamique
        Select dropdown3 = new Select(driver.findElement(By.xpath("//select[contains(@name,'prop_dep-cpy_emplacement')]")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("Dynamique");
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        WebDriverWait some_elemet = new WebDriverWait(driver,10000);
        some_elemet.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enregistrer')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }

    @When("^je lance le processus Déplacement d'un document dynamique dans un emplavement dynamique$")
    public void jeLanceLeProcessusDeplacementDUnDocumentDynamiqueDansUnEmplavementDynamique() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.linkText("Déplacement d'un document dynamique dans un emplavement dynamique")).click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));


        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[0].click();");
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.id("alf-id5")).click();

        driver.switchTo().defaultContent();

        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('yui-button yui-push-button')[6].click();");
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));

        Thread.sleep(2000);

        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[1].click();");
        Thread.sleep(1000);
        driver.switchTo().defaultContent();

        Thread.sleep(2000);
        driver.findElement(By.id("alf-id10")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @And("^je trouve le fichier déplacé dynamiqument dans l'emplacement dynamique$")
    public void jeTrouveLeFichierDeplaceDynamiqumentDansLEmplacementDynamique() throws Throwable {
        WebDriverWait some_element = new WebDriverWait(driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Filigrane")));
        driver.findElement(By.linkText("Filigrane")).click();
        Thread.sleep(2000);
        String nn= driver.findElement(By.xpath("//a[contains(text(),'8481155.png-1')]")).getText();

        if(nn.equals("8481155.png-1")){
            System.out.println("le fichier a été déplacer avec succès");
        }else
            System.out.println("Le fichier n'a pas été deplacer");
    }

    @And("^je réalise le workflow Copie d'un document statique dans un emplacement statique$")
    public void jeRealiseLeWorkflowCopieDUnDocumentStatiqueDansUnEmplacementStatique() throws Throwable {
        Thread.sleep(2000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 300);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        Actions builder = new Actions(Setup.driver);
        driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(1000);

        driver.findElement(By.id("startTask")).click();
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);


        WebDriverWait some_element = new WebDriverWait(driver,10000000);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sauvegarder')]")));

        driver.findElement(By.xpath("//em[contains(text(),'Documents attachés')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Voir')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Ajouter')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Supprimer')]")).click();


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

    @And("^je configure l'action de la tache système Copie d'un document statique dans un emplacement statique$")
    public void jeConfigureLActionDeLaTacheSystemeCopieDUnDocumentStatiqueDansUnEmplacementStatique() throws Throwable {
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
        dropdown1.selectByVisibleText("Déplacement Copie Des Documents");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);


        //documents attachés
        driver.findElement(By.xpath("//span[@style='display: inline-block; white-space: nowrap; overflow: hidden; width: 150px; text-overflow: ellipsis;']")).click();
        driver.findElement(By.xpath("//label[contains(@for,'deplacementCopieDocuments_prop_dep-cpy_elementsType-type-i1')]")).click();
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //cliquer sur le boutton sélectionner
        driver.findElement(By.xpath("//button[contains(text(),'Sélectionner')]")).click();
        WebDriverWait some_element = new WebDriverWait(driver,10000);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Filigrane')]")));
        //cliquer sur le dossier Filigrane
        driver.findElement(By.xpath("//span[contains(text(),'Filigrane')]")).click();
        //cliquer sur OK
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        WebDriverWait some_elemet = new WebDriverWait(driver,10000);
        some_elemet.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enregistrer')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }

    @When("^je lance le processus Copie d'un document statique dans un emplacement statique$")
    public void jeLanceLeProcessusCopieDUnDocumentStatiqueDansUnEmplacementStatique() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.linkText("Copie d'un document statique dans un emplacement statique")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(text(),'Document existant')]")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("alf-id8")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        driver.switchTo().defaultContent();


        //bouton lancer
        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @Then("^je trouve le document est bien copier dans l'emplacemrnt indiqué statiquement$")
    public void jeTrouveLeDocumentEstBienCopierDansLEmplacemrntIndiqueStatiquement() throws Throwable {
        driver.findElement(By.linkText("Filigrane")).click();
        Thread.sleep(2000);
        String nn= driver.findElement(By.xpath("//a[contains(text(),'Chapitre1_PFE_Safa.pdf')]")).getText();
        if(nn.equals("Chapitre1_PFE_Safa.pdf")){
            System.out.println("le fichier a été copier avec succès");
        }else
            System.out.println("Le fichier n'a pas été copier");
    }

    @Then("^je réalise le workflow de Copie d'un document dynamique dans un emplacement statique$")
    public void jeRealiseLeWorkflowDeCopieDUnDocumentDynamiqueDansUnEmplacementStatique() throws Throwable {
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

    @And("^je configure la tache système Copie d'un document dynamique dans un emplacement statique$")
    public void jeConfigureLaTacheSystemeCopieDUnDocumentDynamiqueDansUnEmplacementStatique() throws Throwable {
        //cliquer sur la tache système
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
        //scroll down
        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //cliquer sur "configuration
        driver.findElement(By.xpath("//a[@href='#tab_1']")).click();

        //choisir l'action "Déplacement Copie Des Documents"
        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Déplacement Copie Des Documents");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);


        //documents attachés
        driver.findElement(By.xpath("//span[@style='display: inline-block; white-space: nowrap; overflow: hidden; width: 150px; text-overflow: ellipsis;']")).click();
        driver.findElement(By.xpath("//label[contains(@for,'deplacementCopieDocuments_prop_dep-cpy_elementsType-type-i2')]")).click();
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //cliquer sur le boutton sélectionner
        driver.findElement(By.xpath("//button[contains(text(),'Sélectionner')]")).click();
        WebDriverWait some_element = new WebDriverWait(driver,10000);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Filigrane')]")));
        //cliquer sur le dossier Filigrane
        driver.findElement(By.xpath("//span[contains(text(),'Filigrane')]")).click();
        //cliquer sur OK
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        WebDriverWait some_elemet = new WebDriverWait(driver,10000);
        some_elemet.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enregistrer')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }

    @When("^je lance le processus Copie d'un document dynamique dans un emplacement statique$")
    public void jeLanceLeProcessusCopieDUnDocumentDynamiqueDansUnEmplacementStatique() throws Throwable {

        driver.findElement(By.linkText("Copie d'un document dynamique dans un emplacement statique")).click();

        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));


        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[0].click();");
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.id("alf-id8")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        driver.switchTo().defaultContent();


        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }





    @And("^je trouve le document est bien copié dans l'emplacemrnt indiqué statiquement$")
    public void jeTrouveLeDocumentEstBienCopieDansLEmplacemrntIndiqueStatiquement() throws Throwable {
        WebDriverWait some_element = new WebDriverWait(driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Filigrane")));
        driver.findElement(By.linkText("Filigrane")).click();
        Thread.sleep(5000);
        String nn= driver.findElement(By.xpath("//a[contains(text(),'Chapitre1_PFE_Safa.pdf-3')]")).getText();

        if(nn.equals("Chapitre1_PFE_Safa.pdf-3")){
            System.out.println("le fichier a été copier avec succès");
        }else
            System.out.println("Le fichier n'a pas été copier");
    }


    @Then("^je réalise le workflow de Copie d'un document statique dans un emplacement dynamique$")
    public void jeRealiseLeWorkflowDeCopieDUnDocumentStatiqueDansUnEmplacementDynamique() throws Throwable {
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


        driver.findElement(By.xpath("//em[contains(text(),'Documents attachés')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Voir')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Ajouter')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Supprimer')]")).click();

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

    @And("^je configure la tache système Copie d'un document statique dans un emplacement dynamique$")
    public void jeConfigureLaTacheSystemeCopieDUnDocumentStatiqueDansUnEmplacementDynamique() throws Throwable {
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
        dropdown1.selectByVisibleText("Déplacement Copie Des Documents");
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();

        Thread.sleep(2000);

        //déplacement
        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'prop_dep-cpy_operation')]")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Déplacement");
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        //documents attachés
        driver.findElement(By.xpath("//span[@style='display: inline-block; white-space: nowrap; overflow: hidden; width: 150px; text-overflow: ellipsis;']")).click();
        driver.findElement(By.xpath("//label[contains(@for,'deplacementCopieDocuments_prop_dep-cpy_elementsType-type-i1')]")).click();
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //emplacement dynamique
        Select dropdown3 = new Select(driver.findElement(By.xpath("//select[contains(@name,'prop_dep-cpy_emplacement')]")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("Dynamique");
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        WebDriverWait some_elemet = new WebDriverWait(driver,10000);
        some_elemet.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enregistrer')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]")).click();
    }




    @When("^je lance le processus Copie d'un document statique dans un emplacement dynamique$")
    public void jeLanceLeProcessusCopieDUnDocumentStatiqueDansUnEmplacementDynamique() throws Throwable {
        driver.findElement(By.linkText("Copie d'un document statique dans un emplacement dynamique")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Document existant')]")).click();
        Thread.sleep(500);
        driver.findElement(By.id("alf-id8")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();


        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));
        Thread.sleep(2000);

        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('btn btn-primary btn-sm')[0].click();");
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("document.getElementById('alf-id9').click();");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[contains(@id,'dossier-cntrl-ok-button')]")).click();

        driver.switchTo().defaultContent();



        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @And("^je trouve le fichier Copié dans l'enplacement dynamique indiqué dans le formulaire$")
    public void jeTrouveLeFichierCopieDansLEnplacementDynamiqueIndiqueDansLeFormulaire() throws Throwable {
        WebDriverWait some_element = new WebDriverWait(driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Filigrane")));
        driver.findElement(By.linkText("Filigrane")).click();
        Thread.sleep(2000);
        String nn= driver.findElement(By.xpath("//a[contains(text(),'test.pdf')]")).getText();

        if(nn.equals("test.pdf")){
            System.out.println("le fichier a été déplacer avec succès");
        }else
            System.out.println("Le fichier n'a pas été deplacer");
    }

    @Then("^je réalise le workflow de Copie d'un document dynamique dans un emplavement dynamique$")
    public void jeRealiseLeWorkflowDeCopieDUnDocumentDynamiqueDansUnEmplavementDynamique() throws Throwable {

    }

    @And("^je configure la tache système Copie d'un document dynamique dans un emplavement dynamique$")
    public void jeConfigureLaTacheSystemeCopieDUnDocumentDynamiqueDansUnEmplavementDynamique() throws Throwable {

    }

    @When("^je lance le processus Copie d'un document dynamique dans un emplavement dynamique$")
    public void jeLanceLeProcessusCopieDUnDocumentDynamiqueDansUnEmplavementDynamique() throws Throwable {

    }

    @And("^je trouve le fichier Copié dynamiqument dans l'emplacement dynamique$")
    public void jeTrouveLeFichierCopieDynamiqumentDansLEmplacementDynamique() throws Throwable {

    }

    @And("^je créé la varible de processus fichier de type Contenu GED contenu$")
    public void jeCreeLaVaribleDeProcessusFichierDeTypeContenuGEDContenu() throws Throwable {
        Thread.sleep(3000);



        int mask1 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(800, 500);
        bot.mousePress(mask1);
        bot.mouseRelease(mask1);

        Thread.sleep(2000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 600);
        bot.mousePress(mask);
        bot.mouseRelease(mask);



        driver.findElement(By.xpath("//em[contains(text(),'Données')]")).click();
        Thread.sleep(2000);

        int mask2 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1293, 520);
        bot.mousePress(mask2);
        bot.mouseRelease(mask2);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        Thread.sleep(1000);

        //  WebDriverWait some_element = new WebDriverWait(base.driver,100);
        //  some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-properties-form_prop_wdm_workflowVariables-cntrl-newVariable_prop_wdm_workflowVariableId']")));


        driver.findElement(By.xpath("//input[contains(@id,'-newVariable_prop_wdm_workflowVariableId')]")).sendKeys("fichier");
        driver.findElement(By.name("prop_wdm_workflowVariableLabel")).sendKeys("fichier");
        driver.findElement(By.name("prop_wdm_workflowVariableType")).sendKeys("Contenu GED");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@class='yui-ac-highlight']//span[@id='ac-choice-cm:gedContent']")).click();
        Thread.sleep(500);
        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[contains(@id,'cntrl-constraints-list')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Contenu");

        driver.findElement(By.xpath("//button[contains(@id,'newVariable-form-submit-button')]")).click();
    }

    @And("^je créé la varible de processus dossier de type Contenu GED$")
    public void jeCreeLaVaribleDeProcessusDossierDeTypeContenuGED() throws Throwable {
        WebDriverWait some_element = new WebDriverWait(driver,100);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'-designer')]")));
        Thread.sleep(2000);

        bot.mouseMove(450, 300);
        bot.mousePress( InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease( InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(3000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 600);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        driver.findElement(By.xpath("//em[contains(text(),'Données')]")).click();
        Thread.sleep(2000);

        int mask2 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1293, 520);
        bot.mousePress(mask2);
        bot.mouseRelease(mask2);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@id,'-newVariable_prop_wdm_workflowVariableId')]")).sendKeys("dossier");
        driver.findElement(By.name("prop_wdm_workflowVariableLabel")).sendKeys("dossier");
        driver.findElement(By.name("prop_wdm_workflowVariableType")).sendKeys("Contenu GED");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@class='yui-ac-highlight']//span[@id='ac-choice-cm:gedContent']")).click();
        Thread.sleep(1000);
        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[contains(@id,'cntrl-constraints-list')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Dossier");

        driver.findElement(By.xpath("//button[contains(@id,'newVariable-form-submit-button')]")).click();
    }
}
