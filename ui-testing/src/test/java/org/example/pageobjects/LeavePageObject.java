package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LeavePageObject extends PageObject {

    private final By leaveStatusInput = By.xpath("//label[contains(text(), 'Show Leave with Status')]/following::div[@class='oxd-select-text-input']");
    private final By leaveTypeInput = By.xpath("//label[contains(text(), 'Leave Type')]/following::div[@class='oxd-select-text-input']");
    private final By empNameInput  = By.xpath("//label[contains(text(), 'Employee Name')]/following::input[1]");
    private final By searchButton = By.xpath("//button[contains(., 'Search')]");
    private final By recordStatus = By.xpath("//span[@class='oxd-text oxd-text--span']");
    private final By addEntitlementsTab = By.xpath("//span[@class='oxd-topbar-body-nav-tab-item' and text()='Entitlements ']");
    private final By addEntitlementsDropdown = By.xpath("//ul[@class='oxd-dropdown-menu']//a[text()='Add Entitlements']");
    private final By leavePeriodSelect = By.xpath("//label[contains(text(), 'Leave Period')]/following::div[@class='oxd-select-text-input']");
    private final By entitlementInput = By.xpath("//label[contains(text(), 'Entitlement')]/ancestor::div[contains(@class, 'oxd-input-group')]/following-sibling::div//input");
    private final By yearSelector = By.xpath("//div[contains(@class, 'oxd-calendar-selector-year-selected')]/p");
    private final By monthSelector = By.xpath("//div[contains(@class, 'oxd-calendar-selector-month-selected')]/p");
    private final By calendarNavigationButton = By.xpath("//button[contains(@class, 'oxd-icon-button')]");
    private final By saveButton = By.xpath("//button[contains(., ' Save ')]");
    private final By confirmButton = By.xpath("//button[contains(., ' Confirm ')]");
    private final By assignButton = By.xpath("//button[contains(., ' Assign ')]");
    private final By assignPageLink = By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Assign Leave']");



    String leaveStatusDropdownXpath = "//div[@role='listbox']//div[@role='option']//span[text()='%s']";
    String leaveTypeDropdownXpath = "//div[@role='listbox']//div[@role='option']//span[text()='%s']";
    String empNameDropdownXpath = "//div[@role='listbox']//div[@role='option']//span[text()='%s']";
    String leavePeriodDropdownXpath = "//div[@role='listbox']//div[@role='option']//span[text()='%s']";
    String dateInputXpath = "//label[contains(text(), '%s')]/following::input[1]";
    String daySelectorXpath = "//div[@class='oxd-calendar-date-wrapper']//div[text()='%s']";

    public void selectLeaveStatus(String leaveStatus) {
        $(leaveStatusInput).click();
        $(By.xpath(leaveStatusDropdownXpath.formatted(leaveStatus))).click();
    }

    public void selectLeaveType(String leaveType) {
        $(leaveTypeInput).click();
        $(By.xpath(leaveTypeDropdownXpath.formatted(leaveType))).click();
    }

    public void selectEmployeeName(String empName){
        $(empNameInput).type(empName);
        $(By.xpath(empNameDropdownXpath.formatted(empName))).click();
    }

    public void clickSearch() {
        $(searchButton).click();
    }

    public void checkRecord() {
        assert $(recordStatus).getText().contains("Records Found");
    }

    public void navigateToAddEntitlements() {
        $(addEntitlementsTab).click();
        $(addEntitlementsDropdown).click();
    }

    public void selectLeavePeriod(String leavePeriod) {
        $(leavePeriodSelect).click();
        $(By.xpath(leavePeriodDropdownXpath.formatted(leavePeriod))).click();
    }

    public void enterEntitlement(int entitlement) {
        $(entitlementInput).sendKeys(String.valueOf(entitlement));
    }

    public void clickSave() {
        $(saveButton).click();
    }

    public void clickConfirm() {
        $(confirmButton).click();
    }

    public void clickAssign() {
        $(assignButton).click();
    }

    public void navigateToAssignPage() {
        $(assignPageLink).click();
    }

    public void selectDate(String label, String date) {
        String[] dateParts = date.split("-");
        String year = dateParts[0];
        String day = String.valueOf(Integer.parseInt(dateParts[1]));
        String month = dateParts[2];

        $(By.xpath(String.format(dateInputXpath, label))).click();

        while (!$(yearSelector).getText().equals(year)) {
            $(calendarNavigationButton).click();
        }

        while (!$(monthSelector).getText().equals(getMonthName(Integer.parseInt(month)))) {
            $(calendarNavigationButton).click();
        }

        $(By.xpath(String.format(daySelectorXpath, day))).click();
    }

    private String getMonthName(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };
    }
}



