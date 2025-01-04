package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.example.pageobjects.LeavePageObject;


public class LeaveAction extends UIInteractionSteps {
    LeavePageObject leavePageObject;

    @Step
    public void selectDate(String label, String date) {
        leavePageObject.selectDate(label,date);
    }

    @Step
    public  void selectLeaveStatus(String leaveStatus){
        leavePageObject.selectLeaveStatus(leaveStatus);
    }

    @Step
    public void selectLeaveType(String leaveType){
        leavePageObject.selectLeaveType(leaveType);
    }

    @Step
    public  void  selectEmployeeName(String empName){
        leavePageObject.selectEmployeeName(empName);
    }

    @Step
    public void clickSearch(){
        leavePageObject.clickSearch();
    }

    @Step
    public void checkRecord(){
        leavePageObject.checkRecord();
    }

    @Step
    public void  navigateToAddEntitlements(){
        leavePageObject.navigateToAddEntitlements();
    }

    @Step
    public void selectLeavePeriod(String leavePeriod){
        leavePageObject.selectLeavePeriod(leavePeriod);
    }

    @Step
    public void enterEntitlement(int entitlement) {
        leavePageObject.enterEntitlement(entitlement);
    }

    @Step
    public void clickSave(){
        leavePageObject.clickSave();
    }

    @Step
    public void clickConfirm(){
       leavePageObject.clickConfirm();
    }
    @Step
    public void clickAssign(){
        leavePageObject.clickAssign();
    }

    @Step
    public void navigateToAssignPage() {
        leavePageObject.navigateToAssignPage();
    }
}
