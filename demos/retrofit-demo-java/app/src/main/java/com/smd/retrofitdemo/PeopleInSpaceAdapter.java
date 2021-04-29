package com.smd.retrofitdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.smd.retrofitdemo.network.Person;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/**
 * Adapter for the list of astronauts
 */
class PeopleInSpaceAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<Person> peopleInSpace;

    public PeopleInSpaceAdapter(List<Person> peopleInSpace) {
        this.peopleInSpace = peopleInSpace;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PeopleInSpaceViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ((PeopleInSpaceViewHolder) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return peopleInSpace.size();
    }

    /**
     * ViewHolder for showing the name of an astronaut and their craft
     */
    class PeopleInSpaceViewHolder extends ViewHolder {
        TextView name;
        TextView craft;

        public PeopleInSpaceViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            craft = itemView.findViewById(R.id.craft);
        }

        public void bind(int position) {
            Person astronaut = peopleInSpace.get(position);
            name.setText(astronaut.getName());
            craft.setText(astronaut.getCraft());
        }
    }

    public void replaceAll(List<Person> newData) {
        peopleInSpace.clear();
        peopleInSpace.addAll(newData);
        notifyDataSetChanged();
    }
}