package com.example.vova.task0302;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectBackgroundActivity extends AppCompatActivity {

    Button red,blue,white;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_background);
        red = (Button) findViewById(R.id.red);
        blue = (Button) findViewById(R.id.blue);
        white = (Button) findViewById(R.id.white);


        red.setOnClickListener(onClickListener);
        blue.setOnClickListener(onClickListener);
        white.setOnClickListener(onClickListener);

    }

    

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int color = 0;
            switch (v.getId()){
                case  R.id.red:
                    color = R.color.RED;
                    break;
                case  R.id.white:
                    color = R.color.WHITE;
                    break;
                case  R.id.blue:
                    color = R.color.BLUE;
                    break;
            }
            Intent intent = new Intent();
            intent.putExtra("COLOR",color);
            setResult(RESULT_OK,intent);
            finish();
        }
    };
}
