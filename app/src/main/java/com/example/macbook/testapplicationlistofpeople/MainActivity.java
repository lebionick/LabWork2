package com.example.macbook.testapplicationlistofpeople;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.TreeSet;

public class MainActivity extends Activity {
    Button put, write;
    EditText name, age;
    TreeSet<String> tSet;
    TextView table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        put = (Button) findViewById(R.id.putButton);
        write = (Button) findViewById(R.id.writeButton);
        name = (EditText) findViewById(R.id.nameInput);
        age = (EditText) findViewById(R.id.ageInput);
        table= (TextView) findViewById(R.id.nameTable);
        tSet = new TreeSet<String>();

        put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String Name=name.getText().toString();
                    if(Name.isEmpty())
                        throw new  TypeNotPresentException("Name", new  Throwable());
                    Integer Age= Integer.parseInt(age.getText().toString());
                    tSet.add(Name+' '+Age);
                    name.setText("");
                    age.setText("");
                }
                catch (TypeNotPresentException e){
                    Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Incorrect Age", Toast.LENGTH_LONG).show();
                }
            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table.setText(PeopleSetToString());
            }
        });

    }
    private String PeopleSetToString(){
        String result="";
        for(String pVar : tSet){
            result+=(pVar+"\n");
        }
        return result;
    }
}