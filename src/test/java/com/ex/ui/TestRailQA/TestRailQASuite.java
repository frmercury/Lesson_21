package com.ex.ui.TestRailQA;

import com.ex.ui.BaseTest;
import org.testng.annotations.Test;

public class TestRailQASuite extends BaseTest {

        @Test
        public void newTestCaseCreationTest() {
            new DashboardPage(webDriver)
                    .clickOnTestCasesLink();
            new TestCasesPage(webDriver)
                    .addNewTestCase();
            new NewTestCaseCreationPage(webDriver)
                    .fillCaseTitleInput()
                    .chooseCaseTemplateSteps()
                    .chooseCaseTypeAutomated()
                    .fillPreconditionField()
                    .clickAddTestCaseButton();
            new TestCasesPage(webDriver)
                    .checkSuccessMessageIsDisplayed();
        }

        @Test
        public void newTestRunCreationTest(){
            new DashboardPage(webDriver)
                    .clickOnTestRunsLink();
            new TestRunsResultsPage(webDriver)
                    .addNewTestRun();
            new NewTestRunCreationPage(webDriver)
                    .fillRunTitleInput()
                    .fillDescriptionField()
                    .clickAddTestCaseButton();
            new TestRunPage(webDriver)
                    .clickRandomTestCase();
            new TestCasePage(webDriver)
                    .clickAddTestCaseButton()
                    .addRandomResultStatus()
                    .checkStatusModification();
        }

    /**
     * Вопрос
     */
//    @Test
//    public void newTestCaseStatusModificationTest(){
//        new DashboardPage(webDriver)
//                .clickOnTestRunsLink();
//        new TestRunsResultsPage(webDriver)
//                .addNewTestRun();
//        new NewTestRunCreationPage(webDriver)
//                .fillRunTitleInput()
//                .fillDescriptionField()
//                .clickAddTestCaseButton();
//        new TestRunPage(webDriver)
//                .randomCaseSelection();
//    }
}