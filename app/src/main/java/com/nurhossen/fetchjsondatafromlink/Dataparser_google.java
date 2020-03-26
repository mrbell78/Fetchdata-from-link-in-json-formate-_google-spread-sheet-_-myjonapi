package com.nurhossen.fetchjsondatafromlink;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Dataparser_google extends AsyncTask<Void,Void, List<googledatamodel>> {

    private static final String TAG = "Dataparser_google";

    String data = "";
    googledatamodel googledatamodel_object;
    List<googledatamodel> datalist = new ArrayList<>();

    @Override
    protected List<googledatamodel> doInBackground(Void... voids) {

        try {
            URL url = new URL("https://script.googleusercontent.com/macros/echo?user_content_key=lBlbNzvMCDrWQyraOSQA6nzrfA0dDBhjHbobj6pauVNrzxGbr2zuGMuqbYJ4yAp9JSbG-QZKmMvuX0eDtUbEJa_n2zljNsjkOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUZU5K0NR_M_LscJAuRwpGvK0qJP8cTNjmkIZCre38oapO1o_EbRbR2pN3VxzkJ3E2bCO2t2lZk7EsOpQiEuE64w&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            JSONObject jsonObject = JSONParser.getDataFromWeb();

            if(jsonObject!=null){

                if(jsonObject.length()>0){
                    JSONArray array = jsonObject.getJSONArray("Users");

                    int lena= array.length();
                    int value=datalist.size();

                    if(lena>0){
                        for(; value<lena;value++){

                            googledatamodel model = new googledatamodel();

                            JSONObject obj = array.getJSONObject(value);

                            String name =obj.getString("name");
                            String meaning =obj.getString("Meaning_");
                            String synonims = obj.getString("synonyms");

                            model.setName(name);
                            model.setMeaning_(meaning);
                            model.setSynonyms(synonims);

                            datalist.add(model);
                        }
                    }

                }




            }

            return datalist;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList<googledatamodel>();
    }

    @Override
    protected void onPostExecute(List<googledatamodel> googledatamodels) {
        super.onPostExecute(googledatamodels);

        Log.d(TAG, "onPostExecute: ............................... "+ data+"\n");
    }
}
