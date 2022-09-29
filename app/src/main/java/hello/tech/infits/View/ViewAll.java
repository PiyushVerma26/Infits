package hello.tech.infits.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import hello.tech.infits.Adapters.GraphAdapter;
import hello.tech.infits.Modals.GraphModal;
import hello.tech.infits.databinding.ActivityViewAllBinding;

public class ViewAll extends AppCompatActivity {
ActivityViewAllBinding binding;
GraphAdapter adapter;
ArrayList<GraphModal> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityViewAllBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        list=new ArrayList<>();
        adapter=new GraphAdapter(list,this);
        binding.viewAll.setHasFixedSize(true);
        binding.viewAll.setLayoutManager(new LinearLayoutManager(this));
        binding.viewAll.setAdapter(adapter);
        list.add(new GraphModal("SEP","18","Shake","85 ml","9:10 AM"));
        list.add(new GraphModal("SEP","17","Dinner","100 ml","9:15 AM"));
        list.add(new GraphModal("SEP","16","Shake","85 ml","9:10 AM"));
        list.add(new GraphModal("SEP","15","Dinner","100 ml","9:15 AM"));
        list.add(new GraphModal("SEP","14","Shake","85 ml","9:10 AM"));
        list.add(new GraphModal("SEP","13","Dinner","100 ml","9:15 AM"));
        list.add(new GraphModal("SEP","12","Dinner","100 ml","9:15 AM"));
        list.add(new GraphModal("SEP","11","Dinner","100 ml","9:15 AM"));
        list.add(new GraphModal("SEP","10","Dinner","100 ml","9:15 AM"));
        list.add(new GraphModal("SEP","09","Dinner","100 ml","9:15 AM"));
        list.add(new GraphModal("SEP","08","Dinner","100 ml","9:15 AM"));
        list.add(new GraphModal("SEP","07","Dinner","100 ml","9:15 AM"));
        list.add(new GraphModal("SEP","06","Dinner","100 ml","9:15 AM"));
        list.add(new GraphModal("SEP","05","Dinner","100 ml","9:15 AM"));


    }
}