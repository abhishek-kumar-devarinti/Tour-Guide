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
public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Word> restaurants = new ArrayList<>();
        restaurants.add(new Word("Swaad Restaurant", "Bungalow, Bethal Colony, Kothapeta", "090304 31155", R.drawable.swaad1, "https://www.google.com/maps/place/Swaad+Restaurant/@14.0573861,78.7496797,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb3022882e55555:0xa647b71ddfdddbc8!8m2!3d14.0573809!4d78.7518684"));
        restaurants.add(new Word("Swaad Restaurant", "34/58, 34/58, S.N Colony", "No Contact", R.drawable.swaad2, "https://www.google.com/maps/place/Swaad+Restaurant/@14.0546895,78.7512767,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb30225d6555553:0x57b725ce5c1087ea!8m2!3d14.0546843!4d78.7534654"));
        restaurants.add(new Word("Rajadhani Restaurant", "S.N Colony", "9989919263", R.drawable.rajadhani, "https://www.google.com/maps/place/Rajadhani+Restaurant/@14.0537421,78.7493811,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb30226f43397af:0x7410e07e3d0e9b06!8m2!3d14.0537369!4d78.7515698"));
        restaurants.add(new Word("BMR family restaurant", "next to Canara Bank, S.N Colony", "097045 45049", R.drawable.bmr, "https://www.google.com/maps/place/BMR+family+restaurant/@14.0493588,78.7489435,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb303c2b6e53e7b:0x9160e8c64e9c93a1!8m2!3d14.0493536!4d78.7511322"));
        restaurants.add(new Word("Vihari Restaurant", "Kothapeta", "081214 04072", R.drawable.vihari, "https://www.google.com/maps/place/Vihaari+Family+Restaurant/@14.0557761,78.7493093,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb30226394be877:0x255bd6d2ac1ea474!8m2!3d14.0557709!4d78.751498"));
        restaurants.add(new Word("Haritha Family Restaurant", "Bus Stand Rd, Bethal Colony", "099853 24787", R.drawable.haritha, "https://www.google.com/maps/place/Haritha+Family+Restaurant/@14.0572513,78.7481485,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb302287ddbc0b1:0xb23e880cff2d4fd1!8m2!3d14.0572461!4d78.7503372"));

        CustomAdapter adapter = new CustomAdapter(getActivity(), restaurants, R.color.category_restaurants, false);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentRestaurant = restaurants.get(position);
                Intent intent = new Intent(getActivity(),WebActivity.class);
                intent.putExtra("url",currentRestaurant.getUrl());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
