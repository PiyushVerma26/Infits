package hello.tech.infits.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

import hello.tech.infits.Adapters.InviteAdapter;
import hello.tech.infits.Modals.InviteModal;
import hello.tech.infits.R;
import hello.tech.infits.databinding.ActivityReferBinding;

public class ReferActivity extends AppCompatActivity {
ActivityReferBinding binding;
ArrayList<InviteModal> list;
InviteAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityReferBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
      list=new ArrayList<>();
        adapter=new InviteAdapter(list,this);
        binding.recycle.setLayoutManager(new LinearLayoutManager(this));
        binding.recycle.setHasFixedSize(true);
        binding.recycle.setAdapter(adapter);
        list.add( new InviteModal(R.drawable.p1,"Facebook","Tongkun Lee",true));
        list.add( new InviteModal(R.drawable.p2,"Flicker","Rehmem Khihal",true));
        list.add( new InviteModal(R.drawable.p1,"Facebook","Tongkun Lee",false));
        list.add( new InviteModal(R.drawable.p2,"Facebook","Tongkun Lee",false));
        list.add( new InviteModal(R.drawable.p1,"Facebook","Tongkun Lee",true));
        list.add( new InviteModal(R.drawable.p2,"Facebook","Tongkun Lee",true));
    }
}