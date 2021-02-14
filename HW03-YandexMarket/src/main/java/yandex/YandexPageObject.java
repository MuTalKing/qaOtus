package yandex;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class YandexPageObject {

    public static final By section(String sectionName){
        return By.xpath(format("//div[@role='tablist']//span[text()='%s']",sectionName));
    }

    public static final By subSection(String subsectionName){
        return By.xpath(format("//*[@class='_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS'][text()='%s']",subsectionName));
    }

    public static final By selectProducer(String producerName){
        return By.xpath(format("//*[@class='NVoaOvqe58'][text()='%s']",producerName));
    }

    public static final By sortBy(String sortMethod){
        return By.xpath(format("//*[@class='_2zH77vazcW _3tIaiy1WMf'][text()='%s']",sortMethod));
    }

    public static final By addFirstProducerPhoneToComparisonButton(String producerName){
        return By.xpath(format("//div[@data-zone-name='SearchResults']//article//a[contains(@title, '%s')]/../../../..//div[contains(@aria-label, 'сравнению')]",producerName));
    }

    public static final By closeTip(){
        return By.xpath("//button[@type='button']//span[text()='Понятно']");
    }

    public static final By popUpInformer(){
        return By.xpath("//div[@data-apiary-widget-id='/content/popupInformer']//div[2]/div[1]");
    }

    public static final By productName(String producerName){
        return By.xpath(format("//div[@data-zone-name='SearchResults']//article//a[contains(@title, '%s')]", producerName));
    }

    public static final By comparisonButton(){
        return By.xpath("//a[@href='/my/compare-lists']//span[text()='Сравнить']");
    }

    public static final By deleteButton(){
        return By.xpath("//div[@data-apiary-widget-id='/content/compareContent']//div[@aria-label='Удалить']");
    }
}
