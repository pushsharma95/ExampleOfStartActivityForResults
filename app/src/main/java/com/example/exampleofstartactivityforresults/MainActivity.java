package com.example.exampleofstartactivityforresults;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int IntentId_RequestCode =101; //Intent Request Code
    public static final int Second_RequestCode =102;
    private  TextView resultFirstMessage;
   // private  TextView resultSecondMessage;
      Button mFirstActivityBT;
      Button mSecondtActivityBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultFirstMessage = (TextView)findViewById(R.id.resultfirstMessage);
      //  resultSecondMessage = (TextView)findViewById(R.id.resultsecondMessage);
        mFirstActivityBT = findViewById(R.id.btn_firstActivityBtn);
       // mSecondtActivityBT = findViewById(R.id.btn_secondActivityBtn);
        mFirstActivityBT.setOnClickListener(this);
        //mSecondtActivityBT.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
            case IntentId_RequestCode:
                if(resultCode == RESULT_OK)
                { String messageReturn = data.getStringExtra("firstmessage");
                    resultFirstMessage.setText(messageReturn);
                }
                break;
           /* case Second_RequestCode:
                if(resultCode == RESULT_OK)
                {
                    String messageReturn = data.getStringExtra("secondmessage");
                    resultSecondMessage.setText(messageReturn);
                }
                break;*/

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_firstActivityBtn:
                    Intent intentFirst = new Intent(MainActivity.this, FirstActivity.class);
                    startActivityForResult(intentFirst, IntentId_RequestCode);
                  break;

            case R.id.btn_secondActivityBtn:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, Second_RequestCode);
                break;

        }
    }
}
