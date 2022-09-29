package hello.tech.infits.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import hello.tech.infits.Adapters.GraphAdapter;
import hello.tech.infits.Modals.GraphModal;
import hello.tech.infits.databinding.ActivityGraphClientBinding;

public class GraphClient extends AppCompatActivity {
ActivityGraphClientBinding binding;
GraphAdapter adapter;
ArrayList<GraphModal>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGraphClientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        list=new ArrayList<>();
        adapter=new GraphAdapter(list,this);
        binding.recycle.setHasFixedSize(true);
        binding.recycle.setLayoutManager(new LinearLayoutManager(this));
        binding.recycle.setAdapter(adapter);
        list.add(new GraphModal("SEP","18","Shake","85 ml","9:10 AM"));
        list.add(new GraphModal("SEP","17","Dinner","100 ml","9:15 AM"));
        binding.viewAllItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GraphClient.this,ViewAll.class));
            }
        });
    }
}