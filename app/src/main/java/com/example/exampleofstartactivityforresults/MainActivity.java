package com.example.exampleofstartactivityforresults;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int IntentId_RequestCode =101; //Intent Request Code
    private static TextView resultMessage;
    private static Button getMessageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getMessageBtn = (Button)findViewById(R.id.secondActivityBtn);



        getMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open second activity with request code
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivityForResult(intent, IntentId_RequestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
            case IntentId_RequestCode:
                TextView textView = (TextView)findViewById(R.id.resultMessage);
                if(resultCode == RESULT_OK)
                {
                    String messageReturn = data.getStringExtra("message");
                    textView.setText(messageReturn);
                }
        }
    }
}
