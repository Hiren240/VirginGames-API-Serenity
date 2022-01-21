
package com.virgingames.testbase;
/*
 * Created By: Hiren Patel
 * Project Name: VirginGames-API-Serenity
 */

import com.virgingames.constants.Path;
import com.virgingames.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI=propertyReader.getProperty("baseUrl");
        RestAssured.basePath = Path.GET_BINGO_FEED_PATH;
    }
}
