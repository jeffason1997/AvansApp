package com.jldevelopment.avansapp.nogVerwerken;

/**
 * Created by Jeffrey on 6-7-2017.
 */

public class Constants {

    public static final String CONSUMER_KEY 	= "0b9f4f848268e4fea7a6fab274d673123617f385";
    public static final String CONSUMER_SECRET 	= "fbcb8c0933674dc2af0b53055aa4cc53ee02da89";

    public static final String SCOPE 			= "https://publicapi.avans.nl/oauth/";
    public static final String REQUEST_URL 		= "https://publicapi.avans.nl/oauth/request_token";
    public static final String ACCESS_URL 		= "https://publicapi.avans.nl/oauth/access_token";
    public static final String AUTHORIZE_URL 	= "https://publicapi.avans.nl/oauth/login.php";

    public static final String	OAUTH_CALLBACK_SCHEME	= "x-avans-oauthflow";
    public static final String	OAUTH_CALLBACK_HOST		= "callback";
    public static final String	OAUTH_CALLBACK_URL		= OAUTH_CALLBACK_SCHEME + "://" + OAUTH_CALLBACK_HOST;

    public static final String API_REQUEST_PEOPLE 		= "https://publicapi.avans.nl/oauth/api/user";
    public static final String API_REQUEST_ROOSTER 		= "https://publicapi.avans.nl/oauth/lokaalbeschikbaarheid/?start=2017-04-05&filter=LA&type=free&format=json";
    public static final String API_REQUEST_INUSE 		= "https://publicapi.avans.nl/oauth/resultaten/v2/?format=json";
    public static final String API_REQUEST_GROUPS 		= "https://publicapi.avans.nl/oauth/groups/";
    public static final String API_REQUEST_BB 		= "https://publicapi.avans.nl/oauth/bb/ann/?format=json";


    public static final String ENCODING 		= "UTF-8";


}
