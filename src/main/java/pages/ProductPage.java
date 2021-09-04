package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    WebElement bigPic, thumb1, thumb2, thumb3, thumb4, sizeInput, quantityPlus, addToCart, continueShopping, wElement;

    public ProductPage(WebDriver driver, Actions action, WebDriverWait wait){
        this.driver = driver;
        this.action = action;
        this.wait = wait;
    }

    public void find_all_images_elements(){
        this.bigPic = driver.findElement(By.id("bigpic"));
        this.thumb1 = driver.findElement(By.id("thumb_1"));
        this.thumb2 = driver.findElement(By.id("thumb_2"));
        this.thumb3 = driver.findElement(By.id("thumb_3"));
        this.thumb4 = driver.findElement(By.id("thumb_4"));
    }

    private void check_thumb_and_big_image_src(WebElement thumb, WebElement bigPic){
        String thumbImageName = thumb.getAttribute("src").split("/")[thumb.getAttribute("src").split("/").length - 1];
        String bigPicImageName = bigPic.getAttribute("src").split("/")[thumb.getAttribute("src").split("/").length - 1];
        if (thumbImageName.charAt(0) == bigPicImageName.charAt(0)) {
            System.out.println("image changed successfully");
        } else {
            System.out.println("image changed unsuccessfully");
        }
    }

    public void hover_small_image_and_check_big_image_change(){
        action.moveToElement(this.thumb1).perform();
        this.check_thumb_and_big_image_src(thumb1, bigPic);

        action.moveToElement(this.thumb2).perform();
        this.check_thumb_and_big_image_src(thumb2, bigPic);

        action.moveToElement(this.thumb3).perform();
        this.check_thumb_and_big_image_src(thumb3, bigPic);

        action.moveToElement(this.thumb4).perform();
        this.check_thumb_and_big_image_src(thumb4, bigPic);
    }

    public void find_size_input_element(){
        this.sizeInput = driver.findElement(By.name("group_1"));
    }

    public void click_size_input_and_select_m(){
        this.sizeInput.click();
//        this.wElement = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@title = 'M']")));
        sizeInput.findElement(By.xpath("//option[@title = 'M']")).click();
        this.sizeInput.click();
    }

    public void find_quantity_plus_element(){
        this.quantityPlus = driver.findElement(By.className("product_quantity_up"));
    }

    public void click_quantity_plus_element(){
        this.quantityPlus.click();
    }

    public void find_add_to_cart_element(){
        this.addToCart = driver.findElement(By.xpath("//p[@id = 'add_to_cart']/button"));
    }

    public void click_add_to_cart_element(){
        this.addToCart.click();
    }

    public void wait_until_cart_layer_display(){
        this.wElement = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
    }

    public void find_continue_shopping_element(){
        this.continueShopping = driver.findElement(By.xpath("//span[@title = 'Continue shopping']"));
    }

    public void click_continue_shopping_element(){
        this.continueShopping.click();
    }
}