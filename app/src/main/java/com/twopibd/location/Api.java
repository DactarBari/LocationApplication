package com.twopibd.location;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Api {
    private static Api dataManager = null;

    public static Api getInstance() {

        if (dataManager == null) {
            dataManager = new Api();
        }

        return dataManager;
    }
    public void sendLocation( String latitude, String longitude, final ApiListener.locationSubmitListener listener) {
        ApiClient.getApiInterface().submitLocation( latitude, longitude).enqueue(new Callback<StatusMessage>() {
            @Override
            public void onResponse(Call<StatusMessage> call, Response<StatusMessage> response) {
                listener.onlocationSubmitSuccess(response.body());

            }

            @Override
            public void onFailure(Call<StatusMessage> call, Throwable t) {
                listener.onlocationSubmitFailed(t.getLocalizedMessage());

            }
        });

    }
}
