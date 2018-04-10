package com.company.handlers;

import com.company.Collections.UserCollection;
import com.company.Models.Login;
import com.company.Models.User;
import com.company.utils.JWT;
import com.sun.net.httpserver.HttpExchange;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;

public class SignInHandler extends Handler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        super.handle(httpExchange);

        // get data from POST request
        String request = getRequest();

        // parse data from JSON to Login model
        Login login;
        try {
            login = Login.parse(request);
        } catch (ParseException e) {
            sendResponse("Invalid input data", 400);
            return;
        }

        try {
            User u = UserCollection.getUser(login.login, login.password);
            if (u == null){
                sendResponse("Incorrect login or password",403);
                return;
            }
            String token = JWT.createJWT(String.valueOf(u.id), "store.com", "store/user", 3600000);
            sendResponse(token,200);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}