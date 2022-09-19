package hello.tech.infits.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hello.tech.infits.Modals.DietChartModal;
import hello.tech.infits.R;

public class DietChartAdapter extends RecyclerView.Adapter<DietChartAdapter.viewHolder> {
    ArrayList<DietChartModal> list;
    Context context;

    public DietChartAdapter(ArrayList<DietChartModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.plus,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        DietChartModal modal=list.get(position);
      holder.image.setImageResource(modal.getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class viewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.plus);
        }
    }
}
