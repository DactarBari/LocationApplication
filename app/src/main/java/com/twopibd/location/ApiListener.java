package com.twopibd.location;




public class ApiListener {

    public interface locationSubmitListener {
        void onlocationSubmitSuccess(StatusMessage response);
        void onlocationSubmitFailed(String msg);
    }
}
