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
import android.widget.ImageView;
import android.widget.ListView;

import com.example.lk.petexperts.R;
import com.example.lk.petexperts.ZiJiuActivity;
import com.example.lk.petexperts.adapter.PetAdapter;
import com.example.lk.petexperts.vo.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentJJZJ extends Fragment {
    private ListView listView;
    private PetAdapter adapter;
    private List<Pet> list = new ArrayList<>();

    private DrawerLayout drawerLayout;
    private ImageView imageViewWD;


    public FragmentJJZJ() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jjzj, container, false);
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerlayout);
        imageViewWD = (ImageView) view.findViewById(R.id.image_wdjjzj);
        list.clear();
        listView = (ListView) view.findViewById(R.id.listView_jjzi);
        Pet pet1 = new Pet("烫伤或烧伤", R.drawable.gengduo);
        Pet pet2 = new Pet("车祸撞伤", R.drawable.gengduo);
        Pet pet3 = new Pet("中毒", R.drawable.gengduo);
        Pet pet4 = new Pet("溺水", R.drawable.gengduo);
        Pet pet5 = new Pet("电击", R.drawable.gengduo);
        Pet pet6 = new Pet("休克", R.drawable.gengduo);
        Pet pet7 = new Pet("抽搐", R.drawable.gengduo);
        Pet pet8 = new Pet("晕车晕船", R.drawable.gengduo);
        Pet pet9 = new Pet("癫痫", R.drawable.gengduo);
        Pet pet10 = new Pet("狗咬伤", R.drawable.gengduo);
        Pet pet11 = new Pet("蜂蛰", R.drawable.gengduo);
        list.add(pet1);
        list.add(pet2);
        list.add(pet3);
        list.add(pet4);
        list.add(pet5);
        list.add(pet6);
        list.add(pet7);
        list.add(pet8);
        list.add(pet9);
        list.add(pet10);
        list.add(pet11);

        adapter = new PetAdapter(getActivity(), list);
        listView.setAdapter(adapter);


        imageViewWD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), ZiJiuActivity.class);
                getActivity().startActivity(intent);

            }
        });
        return view;
    }

}
