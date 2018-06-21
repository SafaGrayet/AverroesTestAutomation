package com.Averroes.e2etests.stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import com.Averroes.e2etests.base.Setup;
import com.Averroes.e2etests.stepDefinitions.LoginStep;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;


@Test
public class AlimentationVariableTest {
	public  static WebDriver driver;
	public AlimentationVariableTest () throws AWTException  {
		driver = Setup.driver;
	}
	
   private LoginStep loginStep = new LoginStep ();
	
	
    Robot bot = new Robot();
    Actions builder = new Actions(Setup.driver);

 

    @And("^je créé un nouveau processus \"([^\"]*)\"$")
    public void jeCreeUnNouveauProcessus(String arg0) throws Throwable {
        //cliquer sur le boutton de création d'un nouveau processus
        driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-newWorkflow-button-button")).click();
        driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(2000);

        if (driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow-dialog")).isEnabled()) {
            System.out.println("l'interface de création d'un process est affichée");

            //Entrer le nom du processus
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_cm_name")).sendKeys(arg0);

        //base.driver.findElement(By.id("//input[contains(@id,'default-createWorkflow_prop_cm_name')]")).sendKeys("Processus Alimentation Variable d'un initiateur");
            //cliquer sur le boutton "sélectionner" pour sélectionner la catégorie du processus
            driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-itemGroupActions")).click();
            driver.manage().timeouts().pageLoadTimeout(100000000, TimeUnit.SECONDS);
            Thread.sleep(1000);
            //cliquer sur le bouton "ajouter" pour choisir la catégorie "générale"
            driver.findElement(By.id("alf-id4")).click();
            //Cliquer sur "OK"
            driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-ok-button")).click();
            //Cliquer sur le boutton "Enregistrer" pour confirmer la création du processus

            driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow-form-submit-button")).click();
            Thread.sleep(2000);

        }
    }



    @And("^je réalise le workflow d'Alimentaion variable$")
    public void jeRealiseLeWorkflowDAlimentaionVariable() throws Throwable {

        Thread.sleep(3000);


        //placer le scroll en haut
        int mask1 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 300);
        bot.mousePress(mask1);
        bot.mouseRelease(mask1);

        Actions builder = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(4000);
        //click sur noeud de début

        driver.findElement(By.id("startTask")).click();
        Thread.sleep(500);
        //placer le noeud de début dans les coordonnées x=200,y=200
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();
        driver.manage().timeouts().implicitlyWait(100000000,TimeUnit.SECONDS);

        Thread.sleep(1000);
        //cliquer sur "sauvegarder"
        driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
        Thread.sleep(500);
        //cliquer sur la tache système
        driver.findElement(By.id("serviceTask")).click();
        //base.driver.findElement(By.id("startTask")).click();
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
        //Cliquer sur le flux de séquence
        driver.findElement(By.id("sequenceFlow")).click();
        //liaison du noeud de début avec la tache systéme
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200, 200).click().build().perform();

        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

        //click sur la tache utilisateur

        driver.findElement(By.id("userTask")).click();
        //placer le noeud de début dans les coordonnées x=500,y=300
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 500 , 300).click().build().perform();

        Thread.sleep(2000);
        //cliquer sur "affectation"
        driver.findElement(By.xpath("//em[contains(text(),'Affectation')]")).click();
       Thread.sleep(1000);
       //cliquer sur l'icone (-->) pour affecter la tache utilisateur à l'initiateur

        driver.findElement(By.xpath("//button[contains(@id,'_workflowUserTaskAssignment-cntrl-select-assignee-button-button')]")).click();
        //cliquer sur sauvegarder
     driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
        Thread.sleep(500);
        //cliquer sur flux de séquence
        driver.findElement(By.id("sequenceFlow")).click();

        //accorder le tache système avec la tache système avec la tache utilisateur
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();

        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 500, 300).click().build().perform();

        //cliquer sur le noeud fin
        driver.findElement(By.id("endEvent")).click();
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 400, 400).click().build().perform();

        //cliquer sur flux de séquence

        driver.findElement(By.id("sequenceFlow")).click();

        //accorder le tache système la tache utilisateur avec le noeud de fin

        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 500, 300).click().build().perform();

        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 400, 400).click().build().perform();
        //cliquer sur l'icone select
        driver.findElement(By.id("select")).click();

        //Cliquer sur la tache utilisateur
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();





    }

    @And("^je créé la varible de processus nom de type texte$")
    public void jeCreeLaVaribleDeProcessusDeTypeTexte() throws Throwable {
        Thread.sleep(4000);


        //cliquer sur le point de coordonnées x=800, y=500
        int mask1 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(850, 500);
        bot.mousePress(mask1);
        bot.mouseRelease(mask1);
        //placer le scroll en bas
        Thread.sleep(1000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 600);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        Thread.sleep(1000);
        //cliquer sur "données" pour créé une variable de processus
        driver.findElement(By.xpath("//em[contains(text(),'Données')]")).click();
        Thread.sleep(1000);
        //cliquer sur l'icone "ajouter"
        int mask2 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1293, 520);
        bot.mousePress(mask2);
        bot.mouseRelease(mask2);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        //  WebDriverWait some_element = new WebDriverWait(base.driver,100);
        //  some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-properties-form_prop_wdm_workflowVariables-cntrl-newVariable_prop_wdm_workflowVariableId']")));

        //écrire le nom de la variable
        driver.findElement(By.xpath("//input[contains(@id,'-newVariable_prop_wdm_workflowVariableId')]")).sendKeys("nom");
        //écrire le titrz de la variable
        driver.findElement(By.name("prop_wdm_workflowVariableLabel")).sendKeys("nom");
        //écrire le type de la variable
        driver.findElement(By.name("prop_wdm_workflowVariableType")).sendKeys("Texte");
        //cliquer sur le boutton "enregistrer"
        driver.findElement(By.xpath("//button[contains(@id,'newVariable-form-submit-button')]")).click();




    }

    @And("^je créé la variable de processus prenom de type texte$")
    public void jeCreeLaVariableDeProcessusDeTypeTexte() throws Throwable {
        Thread.sleep(1000);
        //cliquer sur l'icone (+) pour ajouter une variablede processus
        Robot bot = new Robot();
        bot.mouseMove(1293, 520);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //écrire le nom de la variable

        driver.findElement(By.xpath("//input[contains(@id,'-newVariable_prop_wdm_workflowVariableId')]")).sendKeys("prenom");
        //écrire le titre de la variable
        driver.findElement(By.name("prop_wdm_workflowVariableLabel")).sendKeys("prenom");
        //écrire le type de la variable
        driver.findElement(By.name("prop_wdm_workflowVariableType")).sendKeys("Texte");
        //cliquer sur "enregistrer"
        driver.findElement(By.xpath("//button[contains(@id,'newVariable-form-submit-button')]")).click();


    }

    @And("^je créé le formulaire dans la tache utilisateur$")
    public void jeCreeLeFormulaireDansLaTacheUtilisateur() throws Throwable {
        Thread.sleep(3000);
        //placer le scroll en haut

        bot.mouseMove(1350, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        //cliquer sur la tache utilisateur
        Thread.sleep(2000);
        bot.mouseMove(700, 500);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
       // builder.moveToElement( base.driver.findElement(By.xpath("//div[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-designer']//div[@class='jspContainer']//div[@class='jspPane']")), 500 , 300).click().build().perform();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //cliquer sur "Designer de formulaire"
        driver.findElement(By.xpath("//em[contains(text(),'Designer de formulaire')]")).click();
        // base.driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
        //Se placer dans le iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'-form-builder')]")));
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);

        //élément texte
        WebElement dragFrom = driver.findElement(By.xpath("//span[contains(@title,'Text Field')]"));
        //dropzone
        WebElement dragTo = driver.findElement(By.className("dropzone"));
        //méthode drag and drop
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
        //cliquer sur sauvegarder
        driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
    }

    @And("^je configure l'action de la tache système \"([^\"]*)\"$")
    public void jeConfigureLActionDeLaTacheSysteme(String arg0) throws Throwable {
        //cliquer sur la tache système
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
            //placer le scroll vers le bas
        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        //cliquer sur "configuration"
        driver.findElement(By.xpath("//a[@href='#tab_1']")).click();
        //Séléctionner l'action Alimentation des variables d'après la liste des actions
        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Alimentation des variables");


        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        Thread.sleep(1000);
        bot.mouseMove(700, 400);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //base.driver.findElement(By.xpath("//td[@xpath='1']")).click();

        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("Initiateur");

        Thread.sleep(1000);
        bot.mouseMove(700, 450);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //base.driver.findElement(By.xpath("//td[@xpath='1']")).click();

        Select dropdown3 = new Select(driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("Initiateur");

        Thread.sleep(1000);
        bot.mouseMove(780, 400);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //base.driver.findElement(By.xpath("//td[@xpath='1']")).click();

        Select dropdown4 = new Select(driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown4.getFirstSelectedOption();
        dropdown4.selectByVisibleText("Nom");



        Thread.sleep(1000);
        bot.mouseMove(780, 450);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //base.driver.findElement(By.xpath("//td[@xpath='1']")).click();

        Select dropdown5 = new Select(driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown5.getFirstSelectedOption();
        dropdown5.selectByVisibleText("Prénom");

        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();








    }

    @And("^je lance le processus \"([^\"]*)\"$")
    public void jeLanceLeProcessus(String arg0) throws Throwable {
        driver.findElement(By.linkText(arg0)).click();
        Thread.sleep(5000);
        //bouton lancer
        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }
    String pr="";
    @Then("^je vois le formulaire avec le nom et le prènom de l'initiateur$")
    public void jeVoisLeFormulaireAvecLeNomEtLePrenomDeLInitiateur() throws Throwable {

        Thread.sleep(3000);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='formioFormIframe']")));
        Thread.sleep(2000);
       pr= driver.findElement(By.xpath("//input[contains(@name,'data[var-prenom]')]")).getText();
       System.out.println(pr.toString());
       if(pr.equals("Administrator")){
           System.out.println("Le prènom de l'intiateur est "+pr);

       }else
           System.out.println("Le prènom n'a pas été figurer dans le formulaire");



    }


    @Given("^je créé un nouveau processus alimentation variable d'un utilisateur dynamique$")
    public void jeCreeUnNouveauProcessusAlimentationVariableDUnUtilisateurDynamique() throws Throwable {
        driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-newWorkflow-button-button")).click();
        driver.manage().timeouts().implicitlyWait(1000000000, TimeUnit.SECONDS);
        Thread.sleep(2000);

        if (driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow-dialog")).isEnabled()) {
            System.out.println("l'interface de création d'un process est affichée");
            Thread.sleep(3000);

            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_cm_name")).sendKeys("Processus Alimentation Variable d'un utilisateur dynamique");

            //base.driver.findElement(By.id("//input[contains(@id,'default-createWorkflow_prop_cm_name')]")).sendKeys("Processus Alimentation Variable d'un initiateur");

            driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-itemGroupActions")).click();
            driver.manage().timeouts().pageLoadTimeout(100000000, TimeUnit.SECONDS);
            Thread.sleep(1000);
            driver.findElement(By.id("alf-id4")).click();
            driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow_prop_wdm_workflowCategory-cntrl-ok-button")).click();

            driver.findElement(By.id("page_x002e_ctool_x002e_process_x0023_default-createWorkflow-form-submit-button")).click();

        }

    }

    @And("^je créé une variable de processus \"([^\"]*)\" de type personne$")
    public void jeCreeUneVariableDeProcessusDeTypePersonne(String arg0) throws Throwable {
        Thread.sleep(3000);



        int mask1 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(800, 500);
        bot.mousePress(mask1);
        bot.mouseRelease(mask1);

        Thread.sleep(1000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 600);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//em[contains(text(),'Données')]")).click();
        Thread.sleep(1000);

        int mask2 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1293, 520);
        bot.mousePress(mask2);
        bot.mouseRelease(mask2);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        //  WebDriverWait some_element = new WebDriverWait(base.driver,100);
        //  some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-properties-form_prop_wdm_workflowVariables-cntrl-newVariable_prop_wdm_workflowVariableId']")));


        driver.findElement(By.xpath("//input[contains(@id,'-newVariable_prop_wdm_workflowVariableId')]")).sendKeys("user");
        driver.findElement(By.name("prop_wdm_workflowVariableLabel")).sendKeys(arg0);
        driver.findElement(By.name("prop_wdm_workflowVariableType")).sendKeys("Personne");
        driver.findElement(By.xpath("//button[contains(@id,'newVariable-form-submit-button')]")).click();

    }

    @And("^je créé le formulaire dans le noeud de début$")
    public void jeCreeLeFormulaireDansLeNoeudDeDebut() throws Throwable {
        Thread.sleep(1000);
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();

        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
        // builder.moveToElement( base.driver.findElement(By.xpath("//div[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-designer']//div[@class='jspContainer']//div[@class='jspPane']")), 500 , 300).click().build().perform();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//em[contains(text(),'Designer de formulaire')]")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'-form-builder')]")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Composants de base')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Composants Averroes')]")).click();


        WebElement dragFrom = driver.findElement(By.xpath("//span[contains(@title,'Person')]"));
        WebElement dragTo = driver.findElement(By.className("dropzone"));

        loginStep.dragAndDropElement( dragFrom,  dragTo);


        Select dropdown = new Select(driver.findElement(By.id("key")));
        dropdown.getFirstSelectedOption();
        dropdown.selectByVisibleText("user");

        driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();



    }

    @Then("^je vois le formulaire avec le nom et le prènom de l'utilisateur dynamique$")
    public void jeVoisLeFormulaireAvecLeNomEtLePrenomDeLUtilisateurDynamique() throws Throwable {

    }

    @And("^je configure l'action de la tache système Alimentation variable$")
    public void jeConfigureLActionDeLaTacheSystemeAlimentationVariable() throws Throwable {
        //cliquer sur la tache système
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
        //placer le scoll en bas
        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        //cliquer sur configuration
        driver.findElement(By.xpath("//a[@href='#tab_1']")).click();
        //selectionner la tache système alimentation des variables
        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Alimentation des variables");

        //cliquer sur l'icone de configuration de la tache système
        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        Thread.sleep(1000);
        bot.mouseMove(700, 420);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //base.driver.findElement(By.xpath("//td[@xpath='1']")).click();

        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("user");

        Thread.sleep(1000);
        bot.mouseMove(700, 450);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //base.driver.findElement(By.xpath("//td[@xpath='1']")).click();

        Select dropdown3 = new Select(driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown3.getFirstSelectedOption();
        dropdown3.selectByVisibleText("user");

        Thread.sleep(1000);
        bot.mouseMove(780, 420);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //base.driver.findElement(By.xpath("//td[@xpath='1']")).click();

        Select dropdown4 = new Select(driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown4.getFirstSelectedOption();
        dropdown4.selectByVisibleText("Nom");



        Thread.sleep(1000);
        bot.mouseMove(780, 450);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //base.driver.findElement(By.xpath("//td[@xpath='1']")).click();

        Select dropdown5 = new Select(driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown5.getFirstSelectedOption();
        dropdown5.selectByVisibleText("Prénom");

        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();




    }

    @When("^je lance le processus Alimentation variable d'un utilisateur dynamique$")
    public void jeLanceLeProcessusAlimentationVariableDUnUtilisateurDynamique() throws Throwable {
        Thread.sleep(2000);
       // base.driver.findElement(By.xpath("//a[contains(text(),'Processus Alimentation Variable d'un utilisateur dynamique')]")).click();
        driver.findElement(By.linkText("Processus Alimentation Variable d'un utilisateur dynamique")).click();

        Thread.sleep(4000);
        bot.mouseMove(700, 230);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(3000);
        bot.mouseMove(700, 350);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();




    }

    @And("^je créé une variable de processus \"([^\"]*)\" de type \"([^\"]*)\"$")
    public void jeCreeUneVariableDeProcessusDeType(String arg0, String arg1) throws Throwable {

        Thread.sleep(3000);



        int mask1 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(800, 500);
        bot.mousePress(mask1);
        bot.mouseRelease(mask1);

        Thread.sleep(1000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 600);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//em[contains(text(),'Données')]")).click();
        Thread.sleep(1000);

        int mask2 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1293, 520);
        bot.mousePress(mask2);
        bot.mouseRelease(mask2);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        //  WebDriverWait some_element = new WebDriverWait(base.driver,100);
        //  some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-properties-form_prop_wdm_workflowVariables-cntrl-newVariable_prop_wdm_workflowVariableId']")));


        driver.findElement(By.xpath("//input[contains(@id,'-newVariable_prop_wdm_workflowVariableId')]")).sendKeys(arg0);
        driver.findElement(By.name("prop_wdm_workflowVariableLabel")).sendKeys(arg0);
        driver.findElement(By.name("prop_wdm_workflowVariableType")).sendKeys(arg1);
        driver.findElement(By.xpath("//button[contains(@id,'newVariable-form-submit-button')]")).click();

    }

    @And("^je créé la varible de processus \"([^\"]*)\" de type texte$")
    public void jeCreeLaVaribleDeProcessusDeTypeTexte(String arg0) throws Throwable {

        Thread.sleep(3000);



        int mask1 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(800, 500);
        bot.mousePress(mask1);
        bot.mouseRelease(mask1);

        Thread.sleep(3000);
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1350, 600);
        bot.mousePress(mask);
        bot.mouseRelease(mask);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//em[contains(text(),'Données')]")).click();
        Thread.sleep(1000);

        int mask2 = InputEvent.BUTTON1_DOWN_MASK;
        bot.mouseMove(1293, 520);
        bot.mousePress(mask2);
        bot.mouseRelease(mask2);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        //  WebDriverWait some_element = new WebDriverWait(base.driver,100);
        //  some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-properties-form_prop_wdm_workflowVariables-cntrl-newVariable_prop_wdm_workflowVariableId']")));


        driver.findElement(By.xpath("//input[contains(@id,'-newVariable_prop_wdm_workflowVariableId')]")).sendKeys(arg0);
        driver.findElement(By.name("prop_wdm_workflowVariableLabel")).sendKeys(arg0);
        driver.findElement(By.name("prop_wdm_workflowVariableType")).sendKeys("Texte");
        driver.findElement(By.xpath("//button[contains(@id,'newVariable-form-submit-button')]")).click();

    }

    @And("^je créé le formulaire constitué par la variable groupe dans le noeud de début$")
    public void jeCreeLeFormulaireConstitueParLaVariableGroupeDansLeNoeudDeDebut() throws Throwable {
        Thread.sleep(1000);
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 200 , 200).click().build().perform();

        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
        // builder.moveToElement( base.driver.findElement(By.xpath("//div[@id='page_x002e_ctool_x002e_process_x0023_default-diagramTab-alf-id3-designer']//div[@class='jspContainer']//div[@class='jspPane']")), 500 , 300).click().build().perform();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//em[contains(text(),'Designer de formulaire')]")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'-form-builder')]")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Composants de base')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Composants Averroes')]")).click();


        WebElement dragFrom = driver.findElement(By.xpath("//span[contains(@title,'Group')]"));
        WebElement dragTo = driver.findElement(By.className("dropzone"));

        loginStep.dragAndDropElement( dragFrom,  dragTo);


        Select dropdown = new Select(driver.findElement(By.id("key")));
        dropdown.getFirstSelectedOption();
        dropdown.selectByVisibleText("groupe");

        driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();

        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
    }

    @And("^je créé le formulaire de la variable role dans la tache utilisateur$")
    public void jeCreeLeFormulaireDeLaVariableRoleDansLaTacheUtilisateur() throws Throwable {
        Thread.sleep(5000);
        bot.mouseMove(1350, 300);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        Thread.sleep(2000);
        bot.mouseMove(700, 500);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

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
        dropdown.selectByVisibleText("role");

        driver.findElement(By.xpath("//button[contains(@ng-click,'closeThisDialog(true)')]")).click();


        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder')]")).click();
    }

    @And("^je configure l'action de la tache système Alimentation variable d'un groupe dynamique$")
    public void jeConfigureLActionDeLaTacheSystemeAlimentationVariableDUnGroupeDynamique() throws Throwable {
        builder.moveToElement( driver.findElement(By.xpath("//div[contains(@id,'-designer')]")), 300, 300).click().build().perform();
        bot.mouseMove(1350, 600);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@href='#tab_1']")).click();

        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[contains(@id,'workflowServiceTaskProcessing-cntrl-webscripts-config-menu')]")));
        dropdown1.getFirstSelectedOption();
        dropdown1.selectByVisibleText("Alimentation des variables");


        driver.findElement(By.xpath("//button[contains(@id,'form_prop_wdm_workflowServiceTaskProcessing-cntrl-editProcessing-button-button')]")).click();
        driver.manage().timeouts().implicitlyWait(1000000000,TimeUnit.SECONDS);
        Thread.sleep(1000);
        bot.mouseMove(700, 450);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //base.driver.findElement(By.xpath("//td[@xpath='1']")).click();

        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown2.getFirstSelectedOption();
        dropdown2.selectByVisibleText("groupe");


        Thread.sleep(1000);
        bot.mouseMove(780, 450);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //base.driver.findElement(By.xpath("//td[@xpath='1']")).click();

        Select dropdown4 = new Select(driver.findElement(By.xpath("//select[@style='zoom: 1;']")));
        dropdown4.getFirstSelectedOption();
        dropdown4.selectByVisibleText("Rôle");



        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();



    }

    @When("^je lance le processus Alimentation variable d'un groupe dynamique$")
    public void jeLanceLeProcessusAlimentationVariableDUnGroupeDynamique() throws Throwable {
        Thread.sleep(2000);
        // base.driver.findElement(By.xpath("//a[contains(text(),'Processus Alimentation Variable d'un utilisateur dynamique')]")).click();
        driver.findElement(By.linkText("alimentation variable d'un groupe dynamique")).click();

        Thread.sleep(4000);
        bot.mouseMove(700, 230);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(3000);
        bot.mouseMove(700, 290);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        driver.findElement(By.xpath("//button[contains(text(),'Lancer')]")).click();
    }

    @Then("^je vois le formulaire avec le role du groupe dynamique$")
    public void jeVoisLeFormulaireAvecLeRoleDuGroupeDynamique() throws Throwable {

    }
 
}
