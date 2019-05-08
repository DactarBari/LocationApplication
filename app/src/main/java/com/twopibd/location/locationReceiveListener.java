package com.twopibd.location;

import com.google.android.gms.maps.model.LatLng;

public interface locationReceiveListener {
    void onLocationRetriveSuccess(LatLng latLng);
}