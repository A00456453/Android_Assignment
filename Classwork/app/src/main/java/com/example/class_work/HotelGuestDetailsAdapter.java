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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {
        }
    }

}
