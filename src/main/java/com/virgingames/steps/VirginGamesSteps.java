package com.virgingames.steps;
/*
 * Created By: Hiren Patel
 * Project Name: VirginGames-API-Serenity
 */

import com.virgingames.constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VirginGamesSteps {

    @Step("Getting Bingo Lobby Feed")
    public ValidatableResponse getALLBingoLobbyFeed(){

        return SerenityRest.rest()
                .given().log().all()
                .contentType(ContentType.JSON) // contentType set to JSON
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get(EndPoints.GET_BINGO_LOBBY_FEED_ENDPOINT)
                .then().log().all();
    }
}
