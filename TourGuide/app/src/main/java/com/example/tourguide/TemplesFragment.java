package com.example.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TemplesFragment extends Fragment {

    public TemplesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Word> temples = new ArrayList<>();
        temples.add(new Word("VeeraBhadhra Swamy Temple", "Market Road, Kothapeta", R.drawable.veerabhadhra, "https://www.google.co.in/maps/place/Sri+Veerabhadra+Swamy+Temple+Rayachoti/@14.0610391,78.7472148,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb30229961d365d:0xec225c7bbb530130!8m2!3d14.0610339!4d78.7494035?hl=en"));
        temples.add(new Word("Uma Maheshwara Temple", "Kothapeta, Rayachoty", R.drawable.umamaheswara, "https://www.google.com/maps/place/Uma+Maheshwara+Temple+Rayachoti+Andhra+Pradesh/@14.0488101,78.7484796,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb303a7a8b0c8eb:0x95aac50bf1be1234!8m2!3d14.0488049!4d78.7506683"));
        temples.add(new Word("Sai Baba Temple", "Near SBI Bank,Kothapeta", R.drawable.saibaba, "https://www.google.com/maps/place/Sai+Baba+Temple/@14.0504513,78.7495386,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb302213a7bd529:0x96474063f7199129!8m2!3d14.0504461!4d78.7517273"));
        temples.add(new Word("Anjaneya Swamy Temple", "Near Sai Theatre,Rampauram", R.drawable.anjaneya, "https://www.google.com/maps/place/Anjaneya+Swami+Temple/@14.0587911,78.7414303,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb301865cea4071:0x8d4c518e13d9c6f9!8m2!3d14.0587859!4d78.743619"));
        temples.add(new Word("Ramalayam", "NGO Colony,Kothapeta", R.drawable.ramalayam, "https://www.google.com/maps/place/Ramaalayam+Temple,+NGO+Colony/@14.0509937,78.7428779,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb3018980bf0ed7:0x4bcb5e5d3b97038e!8m2!3d14.0509885!4d78.7450666"));


        CustomAdapter adapter = new CustomAdapter(getActivity(), temples, R.color.category_temple, true);
        ListView list = rootView.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentTemple = temples.get(position);
                Intent intent = new Intent(getActivity(),WebActivity.class);
                intent.putExtra("url",currentTemple.getUrl());
                startActivity(intent);
            }
        });

        return rootView;
    }
}
