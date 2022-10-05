package hello.tech.infits.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hello.tech.infits.Modals.ReportModal;
import hello.tech.infits.R;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.viewHolder> {
    ArrayList<ReportModal> list;
    Context context;

    public ReportAdapter(ArrayList<ReportModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.reportlayout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ReportModal modal = list.get(position);
        holder.type.setText(modal.getType());
        holder.kcal.setText(modal.getKcal());
        holder.date.setText(modal.getDate());
        holder.time.setText(modal.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView type, kcal, date, time;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            kcal = itemView.findViewById(R.id.kcal);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }
}
