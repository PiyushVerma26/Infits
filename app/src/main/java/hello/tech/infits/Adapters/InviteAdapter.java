package hello.tech.infits.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hello.tech.infits.Modals.InviteModal;
import hello.tech.infits.R;

public class InviteAdapter extends RecyclerView.Adapter<InviteAdapter.viewHolder> {

    ArrayList<InviteModal> list;
    Context context;

    public InviteAdapter(ArrayList<InviteModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public InviteAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.invite,parent,false);
        return new viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull InviteAdapter.viewHolder holder, int position) {
        InviteModal modal= list.get(position);
        holder.name.setText(modal.getName());
        holder.source.setText(modal.getSource());
        holder.image.setImageResource(modal.getImage());
        if (modal.isInvite())
        {
            holder.invite.setText("invited");
            holder.invite.setTextColor(Color.parseColor("#333437"));
        }
        else
        {
            holder.invite.setText("invite");

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, source,invite;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.ReferImage);
            name=itemView.findViewById(R.id.ReferName);
            source=itemView.findViewById(R.id.ReferSource);
           invite=itemView.findViewById(R.id.ReferInvite);

        }
    }
}
