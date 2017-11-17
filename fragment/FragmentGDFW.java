package com.example.lk.petexperts.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lk.petexperts.FuJinFuWuActivity;
import com.example.lk.petexperts.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGDFW extends Fragment {
    private DrawerLayout drawerLayout3;
    private ImageView imageView3;
    private ImageView imageViewFJFW;


    public FragmentGDFW() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gdfw, container, false);
        drawerLayout3 = (DrawerLayout) view.findViewById(R.id.drawerlayout3);
        imageView3 = (ImageView) view.findViewById(R.id.image_wdgdfw);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout3.openDrawer(GravityCompat.START);
            }
        });

        imageViewFJFW = (ImageView) view.findViewById(R.id.fjff_tu);
        imageViewFJFW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FuJinFuWuActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }

}
