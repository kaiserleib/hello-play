package controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public Result head() {
        return ok();
    }

    public Result hello() {
        return ok("Hello World!");
    }
}
