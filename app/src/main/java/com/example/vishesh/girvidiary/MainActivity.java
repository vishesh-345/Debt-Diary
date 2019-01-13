package com.example.vishesh.girvidiary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    mydatabasehandler mydb;
     EditText editcust, edititem, editvillage, editdate, editmobile, editrate, editid;
    Button adddata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new mydatabasehandler(this);

        editcust = (EditText) findViewById(R.id.custmore);
        edititem = (EditText) findViewById(R.id.item);
        editvillage = (EditText) findViewById(R.id.village);
        editdate = (EditText) findViewById(R.id.date_t);
        editmobile = (EditText) findViewById(R.id.mobile);
        editrate = (EditText) findViewById(R.id.rate_t);
        editid = (EditText) findViewById(R.id.editText);

        adddata = (Button) findViewById(R.id.addb);



    }
    public void cal_interest(View view)
    {
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
    }
    public void deletedata(View view)
    {
        Integer deleterows = mydb.deletedata(editid.getText().toString());
        if(deleterows > 0)
        {
            Toast.makeText(MainActivity.this, "Data is Deleted", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(MainActivity.this, "Data is not Deleted", Toast.LENGTH_LONG).show();
        editcust.setText("");
        editvillage.setText("");
        edititem.setText("");
        editrate.setText("");
        editdate.setText("");
        editmobile.setText("");
        editid.setText("");
    }

    public void adddata(View view) {
        boolean isinserted = mydb.insertdata(editdate.getText().toString(), editcust.getText().toString(), edititem.getText().toString(), editvillage.getText().toString(), editmobile.getText().toString(), editrate.getText().toString());
        if (isinserted = true)
            Toast.makeText(MainActivity.this, "Data is Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data is not Inserted", Toast.LENGTH_LONG).show();
        editcust.setText("");
        editvillage.setText("");
        edititem.setText("");
        editrate.setText("");
        editdate.setText("");
        editmobile.setText("");
        editid.setText("");

    }

    public void search(View view)
    {
        Cursor res = mydb.getparticulardata(editcust.getText().toString());
        if (res.getCount() == 0) {
            showmessage("Error", "No data found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("id :" + res.getString(0) + "\n");
            buffer.append("date :" + res.getString(1) + "\n");
            buffer.append("coustomer :" + res.getString(2) + "\n");
            buffer.append("items :" + res.getString(3) + "\n");
            buffer.append("village :" + res.getString(4) + "\n");
            buffer.append("mobile no :" + res.getString(5) + "\n");
            buffer.append("rate :" + res.getString(6) + "\n\n");

            //show all data


        }
        showmessage("Data", buffer.toString());
        editcust.setText("");
        editvillage.setText("");
        edititem.setText("");
        editrate.setText("");
        editdate.setText("");
        editmobile.setText("");
        editid.setText("");
    }

    public void viewall(View view) {
        Cursor res = mydb.getAllData();
        if (res.getCount() == 0) {
            showmessage("Error", "No data found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("id :" + res.getString(0) + "\n");
            buffer.append("date :" + res.getString(1) + "\n");
            buffer.append("coustomer :" + res.getString(2) + "\n");
            buffer.append("items :" + res.getString(3) + "\n");
            buffer.append("village :" + res.getString(4) + "\n");
            buffer.append("mobile no :" + res.getString(5) + "\n");
            buffer.append("rate :" + res.getString(6) + "\n\n");

            //show all data


        }
        showmessage("Data", buffer.toString());
        editcust.setText("");
        editvillage.setText("");
        edititem.setText("");
        editrate.setText("");
        editdate.setText("");
        editmobile.setText("");
        editid.setText("");
    }

    public void total_a(View view) {
        Cursor res = mydb.getAllData();
        if (res.getCount() == 0) {
            showmessage("Error", "No amount till now");
            return;
        }


        //StringBuffer buffer = new StringBuffer();
        int answer=0;
        while (res.moveToNext()) {
            //buffer.append("rate :" + res.getString(6) + "\n\n");
            answer = answer + Integer.parseInt(res.getString(6));
            //show all data
        }
        String total;
        total = String.format("%d",answer);
        showmessage("Total amount", total);
        editcust.setText("");
        editvillage.setText("");
        edititem.setText("");
        editrate.setText("");
        editdate.setText("");
        editmobile.setText("");
        editid.setText("");
    }
        public void showmessage(String title,String msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);//we can cancel it after use
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }


    }
