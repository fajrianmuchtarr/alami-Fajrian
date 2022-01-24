package alami.mavenpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testcase1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.elevenia.co.id/");

        Thread.sleep(2000);
        //(Close Pop Up Banner)
        driver.findElement(By.xpath("//div[@id='mainPopBanner']/div[2]/a")).click();

        Thread.sleep(3000);

        //(Input Text Komputer+validasi value nya sudah sesuai)

        WebElement Value1=driver.findElement(By.id("AKCKwd"));
        
        Value1.sendKeys("komputer");

        Thread.sleep(2000);
        
        String attribute = Value1.getAttribute("value");
		
		    System.out.println("Entered value:"+attribute);
		
		    if(attribute.contains("komputer"))
		    {
			  System.out.println("Data Valid");
		    }
		
		    else
		    {
			  System.out.println("Data not Valid");
		    }

        Thread.sleep(2000);

        //(Button Action Search)
        driver.findElement(By.className("btn-search")).click();

        Thread.sleep(3000);

        //(SortingProdukTerlaris)
        driver.findElement(By.xpath("//a[contains(text(),'Produk terlaris')]")).click();


        Thread.sleep(2000);


        //(Pilih Produk Pertama)
        driver.findElement(By.xpath("//a[contains(.,'JOYSEUS Wireless Mouse 1800DPI USB Computer 2.4GHz Mouse - MS0003')]")).click();

        Thread.sleep(4000);
        
        //validation apakah produk yang dipilih sudah sesuai
        if(driver.getPageSource().contains("JOYSEUS Wireless Mouse 1800DPI USB Computer 2.4GHz Mouse - MS0003")){

          System.out.println("Text is present");
          
          }
          
          else
          
          {
          
          System.out.println("Text is absent");
          
          }


        //(Menambahkan 2 Produk ke keranjang)

            Actions actions = new Actions(driver);
            WebElement elementLocator = driver.findElement(By.xpath("//button[contains(.,'Increase')]"));
            actions.doubleClick(elementLocator).perform();

        Thread.sleep(1000);

        //(Tambah item ke cart)
        driver.findElement(By.xpath("//a[contains(text(),'Tambahkan ke Cart')]")).click();

        Thread.sleep(1000);

        if(driver.getPageSource().contains("Produk telah ditambahkan ke dalam Cart.")){

          System.out.println("Text is present");
          
          }
          
          else
          
          {
          
          System.out.println("Text is absent");
          
          }


        //(Confirm Message  menambah ke cart)
        driver.findElement(By.xpath("//a[contains(text(),'Ya')]")).click();

        Thread.sleep(2000);
        
        //validation for amount dari produk yang masuk ke keranjang
        WebElement Value2=driver.findElement(By.xpath("//form[@id='frmTmall']/table/tbody/tr/td[3]/input"));
        
        String attribute2 = Value2.getAttribute("value");
		
		    System.out.println("Entered value:"+attribute2);
		
		    if(attribute2.contains("3"))
		    {
			  System.out.println("Data Valid");
		    }
		
		    else
		    {
			  System.out.println("Data not Valid");
		    }


        //button ubah kurir
        driver.findElement(By.xpath("//a[contains(text(),'Ubah Kurir')]")).click();

        try
        {
           driver.switchTo().frame(4);
        }
          catch(NoSuchFrameException e)
        {
          System.out.println(e.getMessage());
        }

        //validation pop up message ubah kurir
        if(driver.getPageSource().contains("Anda dapat mengubah kurir/jenis pengiriman pada pilihan dibawah ini.")){

          System.out.println("Text is present");
          
          }
          
          else
          
          {
          
          System.out.println("Text is absent");
          
          }
        
        //(button Batal)
        driver.findElement(By.xpath("//a[contains(.,'Batal')]")).click();

        driver.switchTo().defaultContent();

        Thread.sleep(2000);

        //(ButtonHapusCart)
        driver.findElement(By.xpath("//a[contains(.,'Hapus')]")).click();

        Thread.sleep(2000);
        
        
        driver.findElement(By.xpath("//a[@id='chkDelPopY']")).click();

        Thread.sleep(1000);
        
        //validation sudah tidak ada produk di keranjang
        if(driver.getPageSource().contains("Tidak ada produk di Shopping Cart.")){

          System.out.println("Text is present");
          
          }
          
          else
          
          {
          
          System.out.println("Text is absent");
          
          }

        Thread.sleep(2000);

        driver.quit();
        
    }
}