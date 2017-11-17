package com.example.lk.petexperts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YinDaoYeActivity extends AppCompatActivity {
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_dao_ye);
        button1 = (Button) findViewById(R.id.button_yidaoye);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YinDaoYeActivity.this, MainActivity.class);
                YinDaoYeActivity.this.startActivity(intent);
                finish();
            }
        });
    }
}
