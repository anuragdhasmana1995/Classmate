package com.htlconline.sm.classmate.CustomRequests;

import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.htlconline.sm.classmate.Config;
import com.htlconline.sm.classmate.SessionManagement;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shikhar Garg on 23-12-2016.
 */
public class CustomGetRequest extends Request<JSONObject> {

    private Response.Listener<JSONObject> listener;

    public CustomGetRequest(int method, String url, Response.Listener<JSONObject> listener1, Response.ErrorListener listener) {
        super(method, url, listener);
        this.listener = listener1;
    }

    @Override
    public Map getHeaders() {
        HashMap<String, String> headers = new HashMap<String, String>();
        Log.i("customgetcookie",SessionManagement.get_cookie());
        headers.put("Cookie",SessionManagement.get_cookie());
        return headers;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        String jsonString = null;
        try {
            jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            return Response.success(new JSONObject(jsonString), HttpHeaderParser.parseCacheHeaders(response));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void deliverResponse(JSONObject response) {
        listener.onResponse(response);
    }
}
