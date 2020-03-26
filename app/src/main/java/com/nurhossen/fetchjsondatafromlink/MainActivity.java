package com.nurhossen.fetchjsondatafromlink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_data,btn_gdata;
    public static TextView textView;
    public static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_data=findViewById(R.id.btn_data);
        btn_gdata=findViewById(R.id.btn_gdata);
        recyclerView=findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btn_data.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onClick(View v) {
              //  Datareciver datareciver = new Datareciver();

              new Datareciver(){
                  @Override
                  protected void onPostExecute(List<Datamodel> aVoid) {
                      super.onPostExecute(aVoid);

                      Customadapter adapter = new Customadapter(MainActivity.this,aVoid);
                      recyclerView.setAdapter(adapter);
                      adapter.notifyDataSetChanged();

                  }
              }.execute();
            }
        });


        btn_gdata.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onClick(View v) {
                new Dataparser_google(){
                    @Override
                    protected void onPostExecute(List<googledatamodel> googledatamodels) {
                        super.onPostExecute(googledatamodels);

                        Customadapterforgoogle gadapter = new Customadapterforgoogle(MainActivity.this,googledatamodels);
                        recyclerView.setAdapter(gadapter);
                        gadapter.notifyDataSetChanged();
                    }
                }.execute();
            }
        });
    }
}
