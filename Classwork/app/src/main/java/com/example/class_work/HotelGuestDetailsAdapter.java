package com.example.class_work;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HotelGuestDetailsAdapter extends RecyclerView.Adapter<HotelGuestDetailsAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    String size;

    //Data gets passed in the constructor
    HotelGuestDetailsAdapter(Context context, String size) {
        this.layoutInflater = LayoutInflater.from(context);
        this.size = size;
    }

    @NonNull
    @Override
    public HotelGuestDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hotel_guest_details_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelGuestDetailsAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
            return Integer.valueOf(size);
    }

    public void setClickListener(ItemClickListener itemClickListener){
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

//        TextView hotelName, hotelPrice, hotelAvailability;
//
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            hotelName = itemView.findViewById(R.id.hotel_name_text_view);
//            hotelPrice = itemView.findViewById(R.id.price_text_view);
//            hotelAvailability = itemView.findViewById(R.id.availability_text_view);
//
//            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
//            if (clickListener != null)
//                clickListener.onClick(view, getAbsoluteAdapterPosition());
        }
    }

}
