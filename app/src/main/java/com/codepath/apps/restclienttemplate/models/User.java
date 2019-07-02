package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    //list the attributes
    public String name;
    public Long uid;
    public String screenName;
    public String profileImageUrl;

    // deserialize the JSON
    public static User fromJSON(JSONObject object) throws JSONException{
        User user = new User();

        //extract and fill the values
        user.name = object.getString("name");
        user.uid = object.getLong("id");
        user.screenName = object.getString("screen_name");
        user.profileImageUrl = object.getString("profile_image_url");

        return user;
    }
}
