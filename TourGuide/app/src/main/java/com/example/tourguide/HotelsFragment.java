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
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Word> hotels = new ArrayList<>();
        hotels.add(new Word("Hotel Preetham Residency", "Rayachoti-Galiveedu Rd, Ramapuram", "9393684888", R.drawable.preetham, "https://www.google.com/maps/place/Preetham+Residency/@14.0571919,78.7412213,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb301e58a2a721b:0xaeade50711d6bc19!8m2!3d14.0571867!4d78.74341"));
        hotels.add(new Word("New Delux Hotel", "45/178, Bose Nagar Road, Kothapeta", "9505000907", R.drawable.hotel, "https://www.google.com/maps/place/Swaad+Hotel/@13.7822987,78.5876978,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb2593b3b1edb4b:0xed499e6f0b30ae3e!8m2!3d13.7822935!4d78.5898865"));
        hotels.add(new Word("Swetha lodge", "S.N Colony", "094406 51848", R.drawable.hotel, "https://www.google.com/maps/place/Swetha+lodge/@14.0505412,78.7492362,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb3033d2a11337f:0xdbf716e2b09bd2b4!8m2!3d14.050536!4d78.7514249"));
        hotels.add(new Word("Rainbow lodge", "S.N Colony", "9949336491", R.drawable.hotel, "https://www.google.com/maps/place/Rainbow+lodge/@14.0587391,78.7512602,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb3022f34672fc5:0xcbcc6947c34cf046!8m2!3d14.0587339!4d78.7534489"));
        hotels.add(new Word("New Bombay Residency", "Kurnool Chittoor Highway", "NO Contact", R.drawable.hotel, "https://www.google.com/maps/place/New+Bombay+Residency/@14.0544602,78.7493693,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb302265c0538f3:0xa3991d4247d4cb9a!8m2!3d14.054455!4d78.751558"));

        CustomAdapter adapter = new CustomAdapter(getActivity(), hotels, R.color.category_hotels, false);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentHotel = hotels.get(position);
                Intent intent = new Intent(getActivity(),WebActivity.class);
                intent.putExtra("url",currentHotel.getUrl());
                startActivity(intent);
            }
        });
        return rootView;
    }

}
