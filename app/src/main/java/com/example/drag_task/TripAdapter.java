package com.example.drag_task;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    DisplayMetrics displayMetrics;
    int height;
    private Context mCtx;
    private List<Trip> tripList;

    public TripAdapter(Context mCtx, List<Trip> tripList) {
        this.mCtx = mCtx;
        this.tripList = tripList;
        displayMetrics = new DisplayMetrics();
        height = mCtx.getResources().getDisplayMetrics().heightPixels /
                4;
    }


    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card, parent, false);
        return new TripViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {


        Trip trip = tripList.get(position);
        String status = "Payment " + trip.getStatus();
        String price = "₹" + trip.getPrice();
        holder.date.setText(trip.getDate());
        holder.id.setText(trip.getId());
        holder.origin.setText(trip.getOrigin());
        holder.destination.setText(trip.getDestination());
        holder.price.setText(price);
        holder.status.setText(status);

        switch (trip.getStatus()) {
            case "successfull":
                holder.status.setBackgroundResource(R.color.lightish_blue);
                break;
            case "pending":
                holder.status.setBackgroundResource(R.color.yellow_orange);
                break;
            case "failed":
                holder.status.setBackgroundResource(R.color.grapefruit);
                break;
            default:
                holder.status.setBackgroundResource(R.color.black);
                break;
        }

        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) holder.cardView.getLayoutParams();
        layoutParams.height = height;
        layoutParams.width = MATCH_PARENT;
        holder.cardView.setLayoutParams(layoutParams);

    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    class TripViewHolder extends RecyclerView.ViewHolder {

        TextView date, id, price, origin, destination, status;
        CardView cardView;

        public TripViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            id = itemView.findViewById(R.id.bookingid);
            price = itemView.findViewById(R.id.price);
            origin = itemView.findViewById(R.id.origin);
            destination = itemView.findViewById(R.id.destination);
            status = itemView.findViewById(R.id.payment_status);
            cardView = itemView.findViewById(R.id.parentCard);


        }
    }
}
