package com.example.vishesh.girvidiary;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText rate_item,months,interest;
    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rate_item = (EditText)findViewById(R.id.rate_i);
        months = (EditText)findViewById(R.id.months);
        interest = (EditText)findViewById(R.id.interest);
        ans = (TextView) findViewById(R.id.ans);



    }
    public void ans(View view)
    {
        String result;
        double rate = Double.parseDouble(rate_item.getText().toString());
        double in = Double.parseDouble(interest.getText().toString());
        double m = Double.parseDouble(months.getText().toString());
        double ans1;
        ans1 = (rate * in)/100;
        ans1 = ans1 * m;
        result = String.format("%.2f",ans1);
        ans.setText(result);

    }
}
