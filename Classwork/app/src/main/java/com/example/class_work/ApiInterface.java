package com.example.class_work;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ApiInterface {

    // API's endpoints
    @GET("/hotels")
    public void getHotelsLists(Callback<HotelInformation> callback);

    @POST("/reservation")
    public void postReq(@Body ReservationConfirmation reservationConfirmation, Callback<ConfirmationResponse> callback);

}
