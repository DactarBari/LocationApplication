package com.twopibd.location;

public class Listener {
    public static locationReceiveListener LocationReceiveListener;

    public static void setLocationReceiveListener(locationReceiveListener listener) {
        LocationReceiveListener = listener;
    }
}
