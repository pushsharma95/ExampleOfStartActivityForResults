package com.example.exampleofstartactivityforresults;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int Second_RequestCode =102;
    private static EditText inputMessage;
    private static Button cancel, submit;
    private TextView resultSecondMessage;
    Button mSecondtActivityBT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        resultSecondMessage = (TextView)findViewById(R.id.resultsecondMessage);
        mSecondtActivityBT = findViewById(R.id.btn_secondActivityBtn);
        mSecondtActivityBT.setOnClickListener(this);
       /* inputMessage = (EditText)findViewById(R.id.inputMessage);
        cancel = (Button)findViewById(R.id.cancel);
        submit = (Button)findViewById(R.id.submit);*/

       /* cancel.setOnClickListener((View.OnClickListener) this);
        submit.setOnClickListener((View.OnClickListener) this);*/
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_secondActivityBtn:
                Intent intent=new Intent(this,SecondActivity.class);
                startActivityForResult(intent, Second_RequestCode);

                /*String message = inputMessage.getText().toString();
                if (message.length() != 0 && !message.equals("")) {
                    Intent intent = new Intent();
                    intent.putExtra("secondmessage", message);//Put Message to pass over intent
                    setResult(RESULT_OK, intent);//Set result OK
                    finish();//finish activity
                } else
                    Toast.makeText(SecondActivity.this, "Please enter a message.", Toast.LENGTH_SHORT).show();

                break;
            case R.id.cancel:
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);//For cancel button set result CANCEl
                finish();//finish activity
                break;*/
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            // This request code is set by startActivityForResult(intent, REQUEST_CODE_1) method.
            case Second_RequestCode:
                if(resultCode == RESULT_OK)
                { String messageReturn = data.getStringExtra("firstmessage");
                    resultSecondMessage.setText(messageReturn);
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
}
