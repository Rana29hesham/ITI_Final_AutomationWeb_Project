package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparePage extends PageBase{
    public ComparePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.no-data")
    public WebElement removeDataMsg;
    @FindBy(css = "a.clear-list")
    WebElement clearListBtn;
    @FindBy(tagName = "tr")
    public List <WebElement> allRows;
    @FindBy(linkText = "Asus N551JK-XO076H Laptop")
    public WebElement productOneLink;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement productTwoLink;


    public  void clearCompareList(){
        clickButton(clearListBtn);
    }

    public void CompareProducts(){
        //Get all Rows
        System.out.println(allRows.size());

        //Get data from each Row
        for(WebElement row : allRows){
            System.out.println(row.getText()+"\t");

        }
    }



}
