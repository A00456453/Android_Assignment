package com.example.class_work;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HotelGuestDetailsFragment extends Fragment {

    View view;
    Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_guest_details_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView hotelRecapTextView = view.findViewById(R.id.hotel_recap_text_view);

        String hotelName = getArguments().getString("hotel name");
        String hotelPrice = getArguments().getString("hotel price");
        String hotelAvailability = getArguments().getString("hotel availability");
        String checkInDate = getArguments().getString("check in date");
        String checkOutDate = getArguments().getString("check out date");
        String size = getArguments().getString("number of guests");
        hotelRecapTextView.setText("Hotel Name : " +hotelName + "\nCheck-In Date : "+checkInDate +
                "\nCheck-Out Date : "+checkOutDate + "\nPrice : "+hotelPrice + "\n\nGuest Details : ");
        setupRecyclerView(size);
        RecyclerView hotelGuestsDetailRecyclerView = view.findViewById(R.id.guests_list_recyclerView);
        Button submitButton = view.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                List<GuestsInfo> guestsInfoList = new ArrayList<GuestsInfo>();
                for (int i = 0; i < Integer.parseInt(size); i++){
                    View detailsGuest = hotelGuestsDetailRecyclerView.getChildAt(i);

                    EditText guestEditText = detailsGuest.findViewById(R.id.guest_name_edittext_view);
                    String hotelName = guestEditText.getText().toString();
                    RadioGroup rg = (RadioGroup) detailsGuest.findViewById(R.id.radio_group);
                    final String value = ((RadioButton) detailsGuest.findViewById(rg.getCheckedRadioButtonId()))
                                    .getText().toString();
                    GuestsInfo guestsInfo =new GuestsInfo(hotelName, value);
                    guestsInfoList.add(guestsInfo);
                }

                ReservationConfirmation reservationConfirmation = new ReservationConfirmation(hotelName, checkInDate, checkOutDate, guestsInfoList);

                Api.getClient().postReq(reservationConfirmation, new Callback<ConfirmationResponse>() {
                    @Override
                    public void success(ConfirmationResponse confirmationResponse, Response response) {
                        String confirmationId = confirmationResponse.getConfirmation_number();
                        Bundle bundle = new Bundle();
                        bundle.putString("confirmation ID", confirmationId);

                        ResponseScreen responseScreen = new ResponseScreen();
                        responseScreen.setArguments(bundle);

                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.remove(HotelGuestDetailsFragment.this);
                        fragmentTransaction.replace(R.id.main_layout, responseScreen);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commitAllowingStateLoss();
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });

    }

    private void setupRecyclerView(String size) {
        RecyclerView recyclerView = view.findViewById(R.id.guests_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotelGuestDetailsAdapter hotelGuestDetailsAdapter = new HotelGuestDetailsAdapter(getActivity(), size);
        recyclerView.setAdapter(hotelGuestDetailsAdapter);
    }
}
