package com.example.sm.problem3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t=(TextView)findViewById(R.id.textView);

        ArrayList<CustomerThread> list = new ArrayList<CustomerThread>();
        Manager manager = new Manager();

        for(int i = 0 ; i < 10 ; i++){
            Customer customer = new Customer("Customer" + i);
            final CustomerThread ct = new CustomerThread(customer);
            list.add(ct);
            manager.add_customer(customer);
            ct.start();
        }




        manager.sort();

        String text="";
        for(int i=0;i<10;i++){
//            list.get(i).start();

            text+=list.get(i).customer.getName() + "     " + Integer.toString(list.get(i).customer.getSpentMoney()) + "\n";
        }
        t.setText(text);

//        MyBaseAdapter adapter = new MyBaseAdapter(this, manager.list);
//        ListView listview = (ListView) findViewById(R.id.listView1) ;
//        listview.setAdapter(adapter);


    }
}

class CustomerThread extends Thread{

    Customer customer;

    CustomerThread(Customer customer){
        this.customer = customer;
    }
    // need something here



    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            customer.work();
        }

    }


}

abstract class Person{

    static int money = 100000;
    int spent_money = 0;
    abstract void work();

}


class Customer extends Person{

    String name;

    Customer(String name){
        this.name = name;
    }


    // need something here
    public String getName(){return name;}
    public int getSpentMoney(){return spent_money;}

    @Override
    void work() {
        Random r = new Random();
        super.spent_money += r.nextInt(1000);
    }
}


class Manager extends Person{
    ArrayList <Customer> list = new ArrayList<Customer>();

    void add_customer(Customer customer) {
        list.add(customer);
    }

    void sort(){ // 직접 소팅 알고리즘을 이용하여 코딩해야함. 자바 기본 정렬 메소드 이용시 감
        for(int i=0;i<list.size()-1;i++){
            for(int j=0;j<list.size()-1-i;j++){
                if(list.get(j).getSpentMoney()>list.get(j+1).getSpentMoney()){
                    Customer c = list.get(j);
                    list.remove(j);
                    list.add(j+1, c);
                }
            }
        }
        // need something here

    }

    @Override
    void work() {
        sort();
    }
}

// need something here

