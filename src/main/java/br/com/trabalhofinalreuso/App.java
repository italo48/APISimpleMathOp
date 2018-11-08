package br.com.trabalhofinalreuso;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
//        port(8080);
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Welcome to APISimpleMathOp. ");

        get("/sum/:x/:y", (req, res) -> {
            double x = Double.parseDouble(req.params("x"));
            double y = Double.parseDouble(req.params("y"));
            return x + y;
        });

        get("/sub/:x/:y", (req, res) -> {
            double x = Double.parseDouble(req.params("x"));
            double y = Double.parseDouble(req.params("y"));
            return x - y;
        });

        get("/mul/:x/:y", (req, res) -> {
            double x = Double.parseDouble(req.params("x"));
            double y = Double.parseDouble(req.params("y"));
            return x * y;
        });

        get("/div/:x/:y", (req, res) -> {
            double x = Double.parseDouble(req.params("x"));
            double y = Double.parseDouble(req.params("y"));
            if(y == 0)
                return 0;
            return x / y;
        });
        get("/stop",(req, res) -> {
            stop();
            return "Bye!!";
        });
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}