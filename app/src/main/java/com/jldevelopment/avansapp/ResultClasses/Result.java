package com.jldevelopment.avansapp.ResultClasses;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jeffrey on 7-7-2017.
 */

public class Result implements Comparable<Result> {
    public String name;
    public String grade;
    public Date date;
    public int EC;
    public boolean gehaald;

    public Result(String name, String grade,String date,int EC,String gehaald) {
        this.name = name;
        this.grade = grade;
        this.EC = EC;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = dateFormat.parse(date);
        } catch (Exception e){
            System.out.println("kut man he");
        }

        if(gehaald.equals("N")){
            this.gehaald = false;
        } else if (gehaald.equals("J")) {
            this.gehaald = true;
        } else {
            gehaald = null;
            System.out.println("ERROR BIJ GEHAALD JONGUH");
        }
    }

    @Override
    public int compareTo(@NonNull Result o) {
        Date compareTime = ((Result)o).date;
        return date.compareTo(compareTime);
    }
}
