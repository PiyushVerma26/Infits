package hello.tech.infits.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import hello.tech.infits.Modals.TrackerModal;
import hello.tech.infits.R;

public class TrackerAdapter extends RecyclerView.Adapter<TrackerAdapter.viewHolder> {
    ArrayList<TrackerModal>list;
    Context context;

    public TrackerAdapter(ArrayList<TrackerModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.food,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        TrackerModal modal= list.get(position);
       holder.name.setText(modal.getName());
        holder.description.setText(modal.getDescription());
       holder.image.setImageResource(modal.getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name, description;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.foodName);
            description=itemView.findViewById(R.id.description);
        }
    }
}
