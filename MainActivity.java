package com.example.lk.petexperts;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lk.petexperts.fragment.FragmentGDFW;
import com.example.lk.petexperts.fragment.FragmentJBZC;
import com.example.lk.petexperts.fragment.FragmentJJZJ;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentJJZJ fragmentJJZJ;
    private FragmentJBZC fragmentJBZC;
    private FragmentGDFW fragmentGDFW;

    FragmentManager manager;
    FragmentTransaction transaction;

    private ImageView imageViewJJZJ;
    private ImageView imageViewJBZC;
    private ImageView imageViewGDFW;

    private TextView textViewJJZJ;
    private TextView textViewJBZC;
    private TextView textViewGDFW;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindID();

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        if (fragmentJJZJ == null) {
            fragmentJJZJ = new FragmentJJZJ();
        }
        // 将页面替换掉
        transaction.replace(R.id.container, fragmentJJZJ);
        // 提交
        transaction.commit();

    }

    private void bindID() {
        imageViewJJZJ = (ImageView) findViewById(R.id.image_jjzj);
        imageViewJBZC = (ImageView) findViewById(R.id.image_jjzc);
        imageViewGDFW = (ImageView) findViewById(R.id.image_gdfw);
        textViewJJZJ = (TextView) findViewById(R.id.textView_jjzj);
        textViewJBZC = (TextView) findViewById(R.id.textView_jjzc);
        textViewGDFW = (TextView) findViewById(R.id.textView_gdfw);



        imageViewJJZJ.setOnClickListener(this);
        imageViewJBZC.setOnClickListener(this);
        imageViewGDFW.setOnClickListener(this);
        textViewJJZJ.setOnClickListener(this);
        textViewJBZC.setOnClickListener(this);
        textViewGDFW.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_jjzj:
                transaction = manager.beginTransaction();
                if (fragmentJJZJ == null) {
                    fragmentJJZJ = new FragmentJJZJ();
                }
                // 将页面替换掉
                transaction.replace(R.id.container, fragmentJJZJ);
                // 提交
                transaction.commit();

                custom();
                imageViewJJZJ.setImageResource(R.drawable.jinjizijiured);
                textViewJJZJ.setTextColor(Color.RED);

                break;
            case R.id.image_jjzc:
                transaction = manager.beginTransaction();
                if (fragmentJBZC == null) {
                    fragmentJBZC = new FragmentJBZC();
                }
                // 将页面替换掉
                transaction.replace(R.id.container, fragmentJBZC);
                // 提交
                transaction.commit();

                custom();
                imageViewJBZC.setImageResource(R.drawable.chazhaored);
                textViewJBZC.setTextColor(Color.RED);

                break;
            case R.id.image_gdfw:
                transaction = manager.beginTransaction();
                if (fragmentGDFW == null) {
                    fragmentGDFW = new FragmentGDFW();
                }
                // 将页面替换掉
                transaction.replace(R.id.container, fragmentGDFW);
                // 提交
                transaction.commit();

                custom();
                imageViewGDFW.setImageResource(R.drawable.shequred);
                textViewGDFW.setTextColor(Color.RED);

                break;
        }

    }

    private void custom() {
        imageViewJJZJ.setImageResource(R.drawable.jinjizijiu);
        imageViewJBZC.setImageResource(R.drawable.chazhao);
        imageViewGDFW.setImageResource(R.drawable.shequ);

        textViewJJZJ.setTextColor(Color.WHITE);
        textViewJBZC.setTextColor(Color.WHITE);
        textViewGDFW.setTextColor(Color.WHITE);
    }
}
