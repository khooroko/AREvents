package com.example.android.actionbarcompat.styled;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {

    private List<Event> eventsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView date;
        public TextView startTime;
        public TextView endTime;
        public TextView place;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            date = (TextView) view.findViewById(R.id.date);
            startTime = (TextView) view.findViewById(R.id.startTime);
            endTime = (TextView) view.findViewById(R.id.endTime);
            place = (TextView) view.findViewById(R.id.place);
        }
    }


    public EventsAdapter(List<Event> eventsList) {
        this.eventsList = eventsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Event event = eventsList.get(position);
        holder.name.setText(event.getName());
        holder.date.setText(event.getDate());
        holder.startTime.setText(event.getStartTime());
        holder.endTime.setText(event.getEndTime());
        holder.place.setText(event.getPlace());
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

}
