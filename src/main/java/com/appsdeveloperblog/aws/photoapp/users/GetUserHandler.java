package com.appsdeveloperblog.aws.photoapp.users;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.JsonObject;

import java.util.Map;

// API GateWay가 단순히 HTTP 요청을 Lambda 로 프록시 하는 경우
// 사용자 세부 정보를 가져오기 위한 요청을 처리하는 메서드 GetUserHandler
public class GetUserHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {


    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        Map<String, String> pathParameters = input.getPathParameters();
        String userId = pathParameters.get("userId");

        JsonObject returnValue = new JsonObject();
        returnValue.addProperty("firstName", "Lee");
        returnValue.addProperty("lastName", "seung min");
        returnValue.addProperty("Id", userId);

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.withStatusCode(200).withBody(returnValue.toString());

        return response;
    }
}