package com.Averroes.e2etests.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardElements extends BaseUtil {
    private BaseUtil base;

    public DashboardElements(BaseUtil base) {
        this.base = base;
    }

    public WebElement processlLink=BaseUtil.driver.findElement(By.id("dashlet_admin_process_link"));

    public WebElement documentLink=BaseUtil.driver.findElement(By.id("dashlet_documents_link"));
    public  WebElement tasksLink=BaseUtil.driver.findElement(By.id("dashlet_tasks_link"));
}
