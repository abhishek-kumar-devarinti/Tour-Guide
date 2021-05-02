package com.example.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Word> {
    private int mColorResourceID;
    private boolean mIsTemple;

    CustomAdapter(Context context, ArrayList words, int colorResourceId, boolean isTemple) {
        super(context, 0, words);
        mColorResourceID = colorResourceId;
        mIsTemple = isTemple;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);
        TextView name = (TextView) listItemView.findViewById(R.id.name_of_category);
        name.setText(currentWord.getName());
        TextView address = (TextView) listItemView.findViewById(R.id.adress_of_category);
        address.setText(currentWord.getAdress());
        TextView contact = (TextView) listItemView.findViewById(R.id.phone);
        if (mIsTemple) {
            contact.setVisibility(View.INVISIBLE);
        } else {
            contact.setVisibility(View.VISIBLE);
            contact.append(currentWord.getContact());
        }
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        image.setImageResource(currentWord.getImageresorceId());
        View layout = listItemView.findViewById(R.id.item_layout);
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        layout.setBackgroundColor(color);
        return listItemView;
    }
}
