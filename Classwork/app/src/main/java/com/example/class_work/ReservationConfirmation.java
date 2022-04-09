package com.example.class_work;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class ReservationConfirmation  {

    String hotel_name;
    String checkin;
    String checkout;
    List<GuestsInfo> guests_list;

    public ReservationConfirmation(String hotel_name, String checkin, String checkout, List<GuestsInfo> guests_list) {
        this.hotel_name = hotel_name;
        this.checkin = checkin;
        this.checkout = checkout;
        this.guests_list = guests_list;
    }
}