package com.example.sm.problem2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyBaseAdapter adapter;
    ListView listview;
    ArrayList<Employee> emp_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // need something here

        emp_list = new ArrayList<Employee>();
        

        adapter = new MyBaseAdapter(this, emp_list);
        listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((AdapterView.OnItemClickListener)adapter);
    }
    @Override
    public void onClick(View v){
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        EditText edit_age = (EditText) findViewById(R.id.edit_age);
        EditText edit_salary = (EditText) findViewById(R.id.edit_salary);


        Employee employee;

        switch (v.getId()){
            case R.id.btn_inc:
                // need something here
                if(!edit_salary.getText().toString().equals("")) {
                    int salary_num = Integer.parseInt(edit_salary.getText().toString()) + 10000;
                    edit_salary.setText(Integer.toString(salary_num));
                }else{
                    edit_salary.setText("10000");
                }

                break;

            case R.id.btn_dec:
                // need something here
                if(!edit_salary.getText().toString().equals("")) {
                    int salary_num = Integer.parseInt(edit_salary.getText().toString()) - 10000;
                    edit_salary.setText(Integer.toString(salary_num));
                }else{
                    edit_salary.setText("-10000");
                }
                break;

            case R.id.btn_store:
                // need something here
                if(!edit_name.getText().toString().equals("")&&!edit_age.getText().toString().equals("")&&!edit_salary.getText().toString().equals("")){
                    String name = edit_name.getText().toString();
                    int age = Integer.parseInt(edit_age.getText().toString());
                    int salary = Integer.parseInt(edit_salary.getText().toString());
                    //Toast.makeText(this, name+" "+age+" "+salary, Toast.LENGTH_SHORT).show();
                    Employee em = new Employee(name, age, salary);
                    emp_list.add(em);
                    Toast.makeText(this, Integer.toString(emp_list.size()), Toast.LENGTH_SHORT).show();

                }
                //listview.setAdapter(adapter);


                break;

            case R.id.btn_modify:
                // need something here
                break;

            case R.id.btn_delete:
                // need something here
                break;
        }
    }
}

interface Payment {
    void increase();
    void decrease();
}
