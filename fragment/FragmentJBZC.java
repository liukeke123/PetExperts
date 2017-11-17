package com.example.lk.petexperts.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.lk.petexperts.BiaoxianZhengzhuangActivity;
import com.example.lk.petexperts.R;
import com.example.lk.petexperts.adapter.PetWebAdapter;
import com.example.lk.petexperts.vo.PetWeb;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentJBZC extends Fragment {
    private DrawerLayout drawerLayout2;
    private ImageView imageView2;


    private GridView gridView;
    private PetWebAdapter adapter;
    private List<PetWeb> list = new ArrayList<>();

    public FragmentJBZC() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jbzc, container, false);
        drawerLayout2 = (DrawerLayout) view.findViewById(R.id.drawerlayout2);
        imageView2 = (ImageView) view.findViewById(R.id.image_wdjbzc);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout2.openDrawer(GravityCompat.START);
            }
        });
        list.clear();
        gridView = (GridView) view.findViewById(R.id.gridview);
        PetWeb p = new PetWeb("鼻子");
        PetWeb p2 = new PetWeb("眼睛");
        PetWeb p3 = new PetWeb("口腔");
        PetWeb p4 = new PetWeb("耳朵");
        PetWeb p5 = new PetWeb("皮肤");
        PetWeb p6 = new PetWeb("肺部");
        PetWeb p7 = new PetWeb("腹部");
        PetWeb p8 = new PetWeb("泌尿部");
        PetWeb p9 = new PetWeb("乳房");
        PetWeb p10 = new PetWeb("肛门");
        PetWeb p11 = new PetWeb("全身");
        PetWeb p12 = new PetWeb("四肢");
        list.add(p);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        list.add(p10);
        list.add(p11);
        list.add(p12);

        adapter = new PetWebAdapter(getActivity(), list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getActivity(), BiaoxianZhengzhuangActivity.class);
                    getActivity().startActivity(intent);
                }
            }
        });

        return view;
    }

}
