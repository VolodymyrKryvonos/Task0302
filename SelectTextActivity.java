package com.example.vova.task0302;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SelectTextActivity extends AppCompatActivity {
    EditText text;
    Button buttonT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_text);
        text = (EditText) findViewById(R.id.ed_text);
        buttonT = (Button) findViewById(R.id.finish);
        buttonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("text",text.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
