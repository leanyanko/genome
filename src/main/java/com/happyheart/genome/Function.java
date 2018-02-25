 package com.happyheart.genome;

import java.util.*;
import com.microsoft.azure.serverless.functions.annotation.*;
import com.microsoft.azure.serverless.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/hello". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/hello
     * 2. curl {your host}/api/hello?name=HTTP%20Query
     */

    //    public JSONObject grocery_list = new JSONObject().put("Ingredient", "Chicken");

    //    grocery_list = { [
    //     {
    //         'Ingredient': 'Chicken',
    //         'Quantity': '1 lbs'
    //     },
    //     {
    //         'Ingredient': 'Butter',
    //         'Quantity': '2 tbs'
    //     },
    //     {
    //         'Ingredient': 'Chicken',
    //         'Quantity': '1 lbs'
    //     },
    //     {
    //         'Ingredient': 'Chicken',
    //         'Quantity': '1 lbs'
    //     },
    //     {
    //         'Ingredient': 'Chicken',
    //         'Quantity': '1 lbs'
    //     } ] });

        //public String grocery_list = "";
        public String grocery_list = 
        "{[{\"Ingredient\": \"Chicken\",\"Quantity\": \"1 lbs\"},{\"Ingredient\": \"Butter\",\"Quantity\": \"2 tbs\"},{\"Ingredient\": \"Chicken\",\"Quantity\": \"1 lbs\"},{\"Ingredient\": \"Chicken\",\"Quantity\": \"1 lbs\"}]}";

    public String summary = "You should eat healthier!";

    @FunctionName("hello")
    public HttpResponseMessage<String> hello(
            @HttpTrigger(name = "req", methods = {"get", "post"}, 
            authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
         //  slak = '949fbebce009d7876d0b9394bf4e50b1ddac5b04',
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        String query = request.getQueryParameters().get("name");
        String name = request.getBody().orElse(query);

        if (name == null) {
            return request.createResponse(400, "Please pass a name on the query string or in the request body");
        } else {
            return request.createResponse(200, "Hello, " + name);
        }
    }


    @FunctionName("getgrocery")
    public HttpResponseMessage<String> getgrocery(
            @HttpTrigger(name = "grocery", methods = {"get"}, 
            authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        //String query = request.getQueryParameters().get("name");
        //String name = request.getBody().orElse(query);

        return request.createResponse(200, grocery_list);
    }

    @FunctionName("getsummary")
    public HttpResponseMessage<String> getsummary(
            @HttpTrigger(name = "summary", methods = {"get"}, 
            authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        //String query = request.getQueryParameters().get("name");
        //String name = request.getBody().orElse(query);

        return request.createResponse(200, summary);
        
    }

    

    @FunctionName("print")
    public HttpResponseMessage<String> print(
            @HttpTrigger(name = "req", methods = {"get", "post"}, 
            authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        String query = request.getQueryParameters().get("name");
        String name = request.getBody().orElse(query);

        if (name == null) {
            return request.createResponse(400, "Error");
        } else {
            return request.createResponse(200, "Data: " + name);
        }
    }
}





  

