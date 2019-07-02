package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Tweet {

    // list out the attributes
    public String body;
    public long uid; // database id for the tweet
    public User user;
    public String createdAt;

    // deserialize the JSON
    public static Tweet fronJSON(JSONObject object) throws JSONException {
        Tweet tweet = new Tweet();

        // extract the values from the JSON
        tweet.body = object.getString("text");
        tweet.uid = object.getLong("id");
        tweet.createdAt = object.getString("created_at");
        tweet.user = User.fromJSON(object.getJSONObject("user"));

        return tweet;
    }
}
