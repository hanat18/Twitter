package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tweet {

    // list out the attributes
    public String body;
    public long uid; // database id for the tweet
    public User user;
    public String createdAt;
    public String imageUrl;

    // deserialize the JSON
    public static Tweet fronJSON(JSONObject object) throws JSONException {
        Tweet tweet = new Tweet();

        // extract the values from the JSON
        tweet.body = object.getString("text");
        tweet.uid = object.getLong("id");
        tweet.createdAt = object.getString("created_at");
        tweet.user = User.fromJSON(object.getJSONObject("user"));
        JSONObject ff = object.getJSONObject("entities");
        if(ff.has("media")){
            JSONArray ff2 = ff.getJSONArray("media");
            JSONObject rr = ff2.getJSONObject(0);
            tweet.imageUrl = rr.getString("media_url_https");
        }
        else{
            tweet.imageUrl = null;
        }

        return tweet;
    }
}
