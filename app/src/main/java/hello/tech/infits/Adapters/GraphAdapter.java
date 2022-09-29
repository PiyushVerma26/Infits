package hello.tech.infits.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hello.tech.infits.Modals.GraphModal;
import hello.tech.infits.R;

public class GraphAdapter extends RecyclerView.Adapter<GraphAdapter.viewHolder> {
    ArrayList<GraphModal> list;
    Context context;

    public GraphAdapter(ArrayList<GraphModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pastlayout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        GraphModal modal = list.get(position);
        holder.month.setText(modal.getMonth());
        holder.date.setText(modal.getDate());
        holder.item.setText(modal.getItem());
        holder.quantity.setText(modal.getQuantity());
        holder.time.setText(modal.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView month, date, item, quantity, time;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            month = itemView.findViewById(R.id.month);
            date = itemView.findViewById(R.id.date);
            item = itemView.findViewById(R.id.item);
            quantity = itemView.findViewById(R.id.quantity);
            time = itemView.findViewById(R.id.time);
        }
    }
}
