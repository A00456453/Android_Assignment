package com.example.class_work;

import java.util.List;

public class HotelInformation {
    public List<HotelListData> getHotels_list() {
        return hotels_list;
    }

    public void setHotels_list(List<HotelListData> hotels_list) {
        this.hotels_list = hotels_list;
    }

    private List<HotelListData> hotels_list;
}
