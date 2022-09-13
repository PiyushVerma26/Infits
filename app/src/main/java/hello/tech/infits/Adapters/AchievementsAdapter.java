package hello.tech.infits.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hello.tech.infits.Modals.AchievementsModal;
import hello.tech.infits.R;

public class AchievementsAdapter extends RecyclerView.Adapter<AchievementsAdapter.viewHolder> {

    ArrayList<AchievementsModal> list;
    Context context;

    public AchievementsAdapter(ArrayList<AchievementsModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AchievementsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.achievements,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementsAdapter.viewHolder holder, int position) {

        AchievementsModal modal= list.get(position);
        holder.clientsNumber.setText(modal.getClientsNumber());
        holder.achievementsNumber.setText(modal.getAchievementsNumber());
      holder.progressBar.setProgress(Integer.parseInt(modal.getProgress()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class  viewHolder extends RecyclerView.ViewHolder{

        TextView clientsNumber, achievementsNumber;
        ProgressBar progressBar;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            clientsNumber=itemView.findViewById(R.id.numberOfClients);
            achievementsNumber=itemView.findViewById(R.id.achievementsNumber);
            progressBar=itemView.findViewById(R.id.progress);
        }
    }
}
