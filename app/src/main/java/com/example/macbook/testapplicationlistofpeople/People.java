package com.example.macbook.testapplicationlistofpeople;

import android.view.ViewDebug;

/**
 * Created by macbook on 02.04.16.
 */
public class People {
    String fullName="";
    Integer age=0;
    public People(String Name, Integer Age){
        fullName=Name;
        age=Age;
    }

    @Override
    public String toString() {
        return (fullName+' '+Integer.toString(age));
    }
}
