package hello.tech.infits.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import hello.tech.infits.Adapters.GraphAdapter;
import hello.tech.infits.Modals.GraphModal;
import hello.tech.infits.View.ViewAll;
import hello.tech.infits.databinding.FragmentWaterBinding;

public class waterFragment extends Fragment {
    FragmentWaterBinding binding;
    ArrayList<GraphModal> list;
    GraphAdapter adapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentWaterBinding.inflate(getLayoutInflater());
        list=new ArrayList<>();
        adapter=new GraphAdapter(list,getContext());
        binding.recycle.setHasFixedSize(true);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycle.setAdapter(adapter);
        list.add(new GraphModal("SEP","18","Shake","85 ml","9:10 AM"));
        list.add(new GraphModal("SEP","17","Dinner","100 ml","9:15 AM"));
        binding.viewAllItem.setOnClickListener(v -> startActivity(new Intent(getContext(), ViewAll.class)));
        return binding.getRoot();
    }
}