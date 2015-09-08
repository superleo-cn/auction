package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;

import constants.Constants;
import constants.Messages;
import models.Craft;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Application extends Controller {

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result findAll() {
        ObjectNode result = Json.newObject();
        try {
            List<Craft> list = Craft.findAll();
            result.put(Constants.CODE, Constants.SUCCESS);
            result.replace(Constants.DATAS, Json.toJson(list));
        } catch (Exception e) {
            result.put(Constants.CODE, Constants.ERROR);
            result.put(Constants.MESSAGE, Messages.QUERY_ERROR);
        }
        return ok(result);
    }

}
