package com.jldevelopment.avansapp.ResultClasses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jldevelopment.avansapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ResultActivity extends AppCompatActivity {

    ArrayList<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String info = getIntent().getStringExtra("INFO");
        System.out.println(info);

        JSONArray array = null;
        results = new ArrayList<>();
        Date compareDate = null;
        try {
            array = new JSONArray(info);
            SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
            compareDate = formatDate.parse("10-08-2016");
            for(int i = 0;i<array.length();i++){
                JSONObject jo = array.getJSONObject(i);
                results.add(new Result(jo.getString("typ:korteNaamCusus"),jo.getString("typ:resultaat"),jo.getString("typ:mutatiedatumTekst"),Integer.parseInt(jo.getString("typ:punten")),jo.getString("typ:voldoende")));
            }
        } catch (Exception e){

        }

        int totaal=0;
        int behaald = 0;
        ArrayList<String> names = new ArrayList<>();
        names.add("start");
        boolean same = false;

        for(int i = 0; i<results.size();i++){
            if(results.get(i).date.compareTo(compareDate)>0){
                for(int ii = 0;ii<names.size()&&same!=true;ii++){
                    if(results.get(i).name.equals(names.get(ii))){
                        same = true;
                    }
                }
                if(same==false) {
                    totaal += results.get(i).EC;
                    names.add(results.get(i).name);
                    //System.out.println(results.get(i).name);
                } else{
                    same = false;
                }
                if(results.get(i).gehaald){
                    behaald+=results.get(i).EC;
                }
            }
        }

        TextView tv1 = (TextView) findViewById(R.id.textView2);
        tv1.setText("Aantal behaalde EC's");
        TextView tv2 = (TextView) findViewById(R.id.textView4);
        tv2.setText("/");
        TextView totaalT = (TextView) findViewById(R.id.TotaalEC_id);
        totaalT.setText(totaal+"");
        TextView behaaldT = (TextView) findViewById(R.id.behaaldeEC_id);
        behaaldT.setText(behaald+"");


        Collections.sort(results);
        ListView lv = (ListView) findViewById(R.id.results_listview_id);
        ArrayAdapter mAdapter = new ResultAdapter((this.getApplicationContext()), results);
        lv.setAdapter(mAdapter);


    }
}
