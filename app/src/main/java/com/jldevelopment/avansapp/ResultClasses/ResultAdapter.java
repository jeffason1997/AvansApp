package com.jldevelopment.avansapp.ResultClasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jldevelopment.avansapp.R;
import com.jldevelopment.avansapp.ResultClasses.ResultActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jeffrey on 7-7-2017.
 */

public class ResultAdapter extends ArrayAdapter<Result> {

    public ResultAdapter(@NonNull Context context, ArrayList<Result> results) {
        super(context,0, results);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
            Date compareDate = formatDate.parse("10-08-2016");
            Result result = getItem(position);

            if(result.date.compareTo(compareDate)>0){
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.lv_rows_results, parent, false);
                }
                TextView vakNaam = (TextView) convertView.findViewById(R.id.vak_naam_id);
                vakNaam.setText(result.name);

                TextView Resultaat = (TextView) convertView.findViewById(R.id.resultaat_id);
                Resultaat.setText(result.grade);
            }
        } catch (Exception e){
            System.out.println(e+"he kut man");
        }


        return convertView;
    }
}