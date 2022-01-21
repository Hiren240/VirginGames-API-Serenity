package com.virgingames.testsuite;
/*
 * Created By: Hiren Patel
 * Project Name: VirginGames-API-Serenity
 */

import com.virgingames.steps.VirginGamesSteps;
import com.virgingames.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class VirginGamesTestWithSteps extends TestBase {

    @Steps
    VirginGamesSteps virginGamesSteps;

    static String timeStamp; // create static variable
    static String startTime; // create static variable

    @Title("This will get all Bingo Games")
    @Test
    public void getAllBingFeedAndVerifyDefaultGameFrequencyTime() {
        // below statement store response body in response object
        ValidatableResponse response = virginGamesSteps.getALLBingoLobbyFeed();
        // below statement get log is validation fail and check status code
        response.log().ifValidationFails().statusCode(200);
        // below statement extract default game frequency and store in gameFreqTime variable
        List<String> gameFreqTime = response.extract().jsonPath().getList("bingoLobbyInfoResource.streams.defaultGameFrequency");
        // below statement print game frequency time from response
        System.out.println("Game Frequency is: " + gameFreqTime);
        try {
            // below statement verify that it contains 300000 and does not contain null value
            assertThat(gameFreqTime.toArray()).contains(300000).doesNotContainNull();
            System.out.println("Game Frequency does not contain null");
        } catch (Error e) {
            // below statement print Assertion error e
            System.out.println("Assertion Error :" + e);
            // below statement verify that it contains 300000 and contain null value
            assertThat(gameFreqTime.toArray()).contains(300000).containsNull();
            // below statement print index of value containing null
            System.out.println("Index of Null value in Game Frequency is: " + gameFreqTime.indexOf(null));
        }
    }
}
