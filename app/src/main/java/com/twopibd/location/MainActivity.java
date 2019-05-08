package com.twopibd.location;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends GPSOpenActivity implements locationReceiveListener ,ApiListener.locationSubmitListener{
    LatLng currentLocation=null;
    @BindView(R.id.submitBtn)
    Button submitBtn;

    @BindView(R.id.tv_address)
    TextView tv_address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Listener.setLocationReceiveListener(this);
    }

    @Override
    public void onLocationRetriveSuccess(LatLng latLng) {

        tv_address.setText(latLng.toString());
        Toast.makeText(context, latLng.toString(), Toast.LENGTH_SHORT).show();
        currentLocation=latLng;
        submitBtn.setEnabled(true);
    }

    public void submitLocation(View view) {
        MyProgressDialog.with(MainActivity.this);
        Api.getInstance().sendLocation(String.valueOf(currentLocation.latitude),String.valueOf(currentLocation.longitude),this);
    }

    @Override
    public void onlocationSubmitSuccess(StatusMessage response) {
        MyProgressDialog.destroy();
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onlocationSubmitFailed(String msg) {
        MyProgressDialog.destroy();
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }
}
