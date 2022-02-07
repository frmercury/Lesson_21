package com.ex.ui.TestRailQA;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.Random;

public class TestRunPage extends BasePage {

    public TestRunPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By testCaseCheckBox = By.xpath("//td[@class='checkbox']/input");
    private By addResultLink = By.xpath("//a[@id='massAddResult']");
    private By addResultField = By.xpath("//div[@id='addResultStatus_chzn']/a");
    private By testCaseStatuses = By.xpath("//div[@id='addResultStatus_chzn']//li");
    private By addResultButton = By.xpath("//button[@id='addResultSubmit']");
    private By testCaseStatusDropDown = By.xpath("..//following-sibling::td[@class='js-status']");

    private By testCaseId = By.xpath("//td[@class='id']");



    public TestRunPage clickRandomTestCase () {
        List<WebElement> randomCaseId = webDriver.findElements(testCaseId);
        Random random = new Random();
        WebElement randomTestCaseID = randomCaseId.get(random.nextInt(randomCaseId.size()));
        randomTestCaseID.click();
        return this;
    }


    /**
     * Вопрос по поводу нахождения элементов на странице по xpath.
     *
     * Задача:
     * 1. создать новый тестран,рандомно отметить циклом несколько тесткейсов через чекбокс,
     * 2. затем нажать кнопку "AddResults",
     * 3. рандомно выбрать статус,
     * 4. сразу проверить успешное изменение статуса кейса на странице TestRun.
     *
     * Проблема:
     * Я выбираю лист элементов randomCheckBox, выбираю рандомно один чекбос,
     * нахожу относительно него элемент статуса тесткейса td[@class='js-status']
     * Я проверил - элементы выбираются корректно (через sout.getAttribute).
     *
     * Но если я выполняю изменение статусу randomCheckBox.click(); clickAddResultLink().addRandomResultStatus();,
     * то на странице атрибут элемента td[@class='js-status'] не изменяет, что бы я не делелал,
     * а если я добавляю waitForAjax - то сразу падает со Stale ошибкой.
     *
     */

    public TestRunPage randomCaseSelection () {
        List<WebElement> randomCaseCheckBoxes = webDriver.findElements(testCaseCheckBox);
        Random random = new Random();
        WebElement randomCheckBox = randomCaseCheckBoxes.get(random.nextInt(randomCaseCheckBoxes.size()));
        System.out.println(randomCheckBox.getAttribute("name"));
        WebElement randomTestCaseStatusDropDown = randomCheckBox.findElement(testCaseStatusDropDown);
        System.out.println(randomTestCaseStatusDropDown.getAttribute("rel"));

        randomCheckBox.click();
        clickAddResultLink().addRandomResultStatus();
        waitForAjax(webDriver);


        /**
         *  После выбора статуса тесткейса - тест ниже упадет с Stale ошибкой
         */


        System.out.println(randomTestCaseStatusDropDown.getAttribute("rel"));
        Assertions.assertThat(randomTestCaseStatusDropDown.getAttribute("rel")).doesNotMatch("3");

        /**
         * Ниже изначальный код, который я пытался запустить
         */

//        for (int i = 0; i <= 5; i++) {
//
//            randomCheckBox = randomCaseCheckBoxes.get(random.nextInt(randomCaseCheckBoxes.size()));
//            randomTestCaseStatusDropDown = randomCheckBox.findElement(testCaseStatusDropDown);
//
//            if (randomCheckBox.findElement(testCaseCheckBox).isSelected()) {
//                continue;
//            } else {
//                randomCheckBox.click();
//                clickAddResultLink().addRandomResultStatus();
//                waitForAjax(webDriver);
//                Assertions.assertThat(randomTestCaseStatusDropDown.getAttribute("rel")).doesNotMatch("3");
//            }
//        }
        return this;
    }

    public TestRunPage clickAddResultLink () {
        findElement(webDriver, addResultLink).click();
        return this;
    }

    public TestRunPage addRandomResultStatus() {
        findElement(webDriver, addResultField).click();
        chooseRandomCaseStatus();
        clickAddResultButton();
        return this;
    }

    public void chooseRandomCaseStatus () {
        List<WebElement> randomCaseStatusList = webDriver.findElements(testCaseStatuses);
        Random random = new Random();
        WebElement randomStatus = randomCaseStatusList.get(random.nextInt(randomCaseStatusList.size()));
        randomStatus.click();
    }
    public void clickAddResultButton () {
        findElement(webDriver, addResultButton).click();
    }
}