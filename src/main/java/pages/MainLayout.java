package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainLayout {

    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    WebElement womenCategory, tShirtsCategory, dressesCategory, casualDressesCategory, cartElement, checkoutElement,
            continueShopping, layerCart;

    public MainLayout (WebDriver driver, Actions action, WebDriverWait wait) {
        this.action = action;
        this.driver = driver;
        this.wait = wait;
    }

    public void find_women_category() {
        this.womenCategory = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"));
    }

    public void hover_women_category() {
        action.moveToElement(this.womenCategory).perform();
    }

    public void find_t_shirts_sub_category() {
        this.tShirtsCategory = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
    }

    public void click_t_shirts_sub_category() {
        this.tShirtsCategory.click();
    }

    public void go_to_main_page(){
        this.driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).click();
    }

    public void find_dresses_category() {
        this.dressesCategory = this.driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"));
    }

    public void hover_dresses_category() {
        action.moveToElement(this.dressesCategory).build().perform();
    }

    public void find_casual_dresses_sub_category(){
        this.casualDressesCategory = this.driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]"));
    }

    public void click_casual_dresses_category(){
        this.casualDressesCategory.click();
    }

    public void find_cart_element(){
        this.cartElement = this.driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
    }

    public void hover_cart_element(){
        action.moveToElement(this.cartElement).build().perform();
    }

    public void find_checkout_element(){
        this.checkoutElement = driver.findElement(By.id("button_order_cart"));
    }

    public void click_checkout_element(){
        this.checkoutElement.click();
    }

    public void wait_until_cart_layer_display(){
        this.layerCart = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
    }

    public void wait_until_cart_layer_display_none(){
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("layer_cart")));
    }

    public void find_continue_shopping_element(){
        this.continueShopping = driver.findElement(By.xpath("//span[@title = 'Continue shopping']"));
    }

    public void click_continue_shopping_element(){
        this.continueShopping.click();
    }
}
