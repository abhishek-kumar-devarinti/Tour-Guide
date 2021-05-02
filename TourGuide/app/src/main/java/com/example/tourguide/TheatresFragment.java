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
public class TheatresFragment extends Fragment {

    public TheatresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Word> theatres = new ArrayList<>();
        theatres.add(new Word("Sai Theatre", "Rayachoti-Galiveedu Rd, Ramapuram", "099660 96660", R.drawable.theatre, "https://www.google.com/maps/place/Sai+Theater/@14.0576118,78.7406169,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb30186122ed8cb:0xf30a0a37adda1149!8m2!3d14.0576066!4d78.7428056"));
        theatres.add(new Word("Prasad Theatre", "Rayachoti-Galiveedu Rd, Ramapuram", "079938 19427", R.drawable.theatre, "https://www.google.com/maps/place/Prasad+Theatre/@14.0579266,78.7404969,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb3018612b0f413:0x9a39efbae52de03c!8m2!3d14.0579214!4d78.7426856"));
        theatres.add(new Word("Goutham Theatre", "Rayachoti-Galiveedu Rd, Ramapuram", "9502416247", R.drawable.theatre, "https://www.google.com/maps/place/Gowtham+Theatre/@14.0584164,78.74058,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb30186722a51f7:0x221910a6d42ef252!8m2!3d14.0584112!4d78.7427687"));
        theatres.add(new Word("Sayidha Theatre", "Bus Stand Rd, Bethal Colony, Kothapeta", "No Contact", R.drawable.theatre, "https://www.google.com/maps/place/Sayeedia+Picture+Palace/@14.057221,78.748139,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb302287e77dd75:0x287aa7c9026b53cb!8m2!3d14.0572158!4d78.7503277"));
        theatres.add(new Word("SoniRaj", "Bus Stand Rd, Kothapeta", "NO Contact", R.drawable.theatre, "https://www.google.com/maps/place/Soniraj+Theatre/@14.0568577,78.7480146,17z/data=!3m1!4b1!4m5!3m4!1s0x3bb3035eb38c3cfb:0x41d204f7b613bed2!8m2!3d14.0568525!4d78.7502033"));

        CustomAdapter adapter = new CustomAdapter(getActivity(), theatres, R.color.category_theatres, false);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentTheatre = theatres.get(position);
                Intent intent = new Intent(getActivity(),WebActivity.class);
                intent.putExtra("url",currentTheatre.getUrl());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
