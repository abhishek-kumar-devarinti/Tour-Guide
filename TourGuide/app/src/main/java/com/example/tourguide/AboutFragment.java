package com.example.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.about, container, false);
        TextView maps = (TextView) rootView.findViewById(R.id.text_maps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps?q=rayachoti&source=lmns&bih=529&biw=1280&hl=en&ved=2ahUKEwi4kOG6seXpAhU0pekKHQa1CTMQ_AUoAXoECAEQAQ"));
//                startActivity(intent);
                String url = "https://www.google.com/maps?q=rayachoti&source=lmns&bih=529&biw=1280&hl=en&ved=2ahUKEwi4kOG6seXpAhU0pekKHQa1CTMQ_AUoAXoECAEQAQ";
                Intent intent = new Intent(getActivity(),WebActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
