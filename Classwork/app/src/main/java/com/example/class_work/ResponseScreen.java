package com.example.class_work;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResponseScreen extends Fragment {

    View view;
    TextView reservationConfirmation;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.reservation_confirmation, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        reservationConfirmation = view.findViewById(R.id.reservation_confirmation_text_view);


        String confirmationID = getArguments().getString("confirmation ID");

        reservationConfirmation.setText("Your reservation has been successfully completed and your Confirmation" +
                " ID is " + confirmationID + "\n\n\nThank you for booking the room. Have a great stay at the Hotel");
    }
}
