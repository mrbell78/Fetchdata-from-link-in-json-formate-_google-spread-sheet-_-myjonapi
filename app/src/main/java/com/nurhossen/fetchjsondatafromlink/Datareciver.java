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

public class Datareciver extends AsyncTask<Void, Void, List<Datamodel>> {

    private static final String TAG = "Datareciver";


    String data="";
    String dataparsed="";
    String singleparsed="";
    List<Datamodel> datarecivers_bygetter=new ArrayList<>();
    Datamodel model;

    @Override
        protected List<Datamodel> doInBackground(Void... voids) {

        try {
            URL url = new URL("https://api.myjson.com/bins/19r5ac");

            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while(line!=null){

                    line = bufferedReader.readLine();

                    data =data+line;

                }
                JSONArray JA = new JSONArray(data);

                for(int i=0;i<JA.length(); i++){
                    try {
                        JSONObject jsonObject = (JSONObject) JA.get(i);
                        /*singleparsed="name" + jsonObject.get("name")+"\n"
                        +"password" + jsonObject.get("password")+"\n"
                        +"contatct" + jsonObject.get("contatct")+"\n"
                        +"country" + jsonObject.get("country")+"\n\n";

                        dataparsed=dataparsed+singleparsed;*/
                        model= new Datamodel(jsonObject.get("name").toString(),jsonObject.get("password").toString(),jsonObject.get("contatct").toString(),jsonObject.get("country").toString());
                        datarecivers_bygetter.add(model);





                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return datarecivers_bygetter;


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new ArrayList<Datamodel>();
    }

    @Override
    protected void onPostExecute(List<Datamodel> datamodels) {
        super.onPostExecute(datamodels);

        Log.d(TAG, "onPostExecute: ....................... "+data+"\n");
    }
}
