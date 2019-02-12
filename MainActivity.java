package com.example.vova.task0302;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button menuBtn;
    TextView text;
    RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuBtn = (Button) findViewById(R.id.menu);
        text = (TextView) findViewById(R.id.insert_text);
        layout = (RelativeLayout) findViewById(R.id.layout);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showPopupMenu(v);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
        text.setText(data.getStringExtra("text"));}
        else
            layout.setBackgroundResource(data.getExtras().getInt("COLOR"));

    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.menu);

        popupMenu
                .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.exit:
                                finish();
                                return true;
                            case R.id.bg:
                                Intent intentBg = new Intent(MainActivity.this,SelectBackgroundActivity.class);
                                startActivityForResult(intentBg,2);
                                return true;
                            case R.id.text:
                                Intent intentText = new Intent(MainActivity.this,SelectTextActivity.class);
                                startActivityForResult(intentText,1);
                                return true;
                            default:
                                return false;
                        }
                    }
                });

        popupMenu.show();
    }
}
