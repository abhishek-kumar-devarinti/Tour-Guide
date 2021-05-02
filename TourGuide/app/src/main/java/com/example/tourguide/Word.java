package com.example.tourguide;

public class Word {
    private String mName, mAddress, mContact, mUrl;
    private int mImageresorceId;

    public Word(String name, String address, int imageResorceId, String url) {
        mName = name;
        mAddress = address;
        mImageresorceId = imageResorceId;
        mUrl = url;
    }

    public Word(String name, String address, String contact, int imageResorceId, String url) {
        mName = name;
        mAddress = address;
        mImageresorceId = imageResorceId;
        mContact = contact;
        mUrl = url;
    }

    public String getName() {
        return mName;
    }

    public String getAdress() {
        return mAddress;
    }

    public int getImageresorceId() {
        return mImageresorceId;
    }

    public String getContact() {
        return mContact;
    }

    public String getUrl() {
        return mUrl;
    }
}
