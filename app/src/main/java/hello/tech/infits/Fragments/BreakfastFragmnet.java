package hello.tech.infits.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import hello.tech.infits.Adapters.TrackerAdapter;
import hello.tech.infits.Modals.TrackerModal;
import hello.tech.infits.R;
import hello.tech.infits.databinding.FragmentBreakfastFragmnetBinding;

public class BreakfastFragmnet extends Fragment {
FragmentBreakfastFragmnetBinding binding;
TrackerAdapter adapter;
ArrayList<TrackerModal> list;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentBreakfastFragmnetBinding.inflate(getLayoutInflater());
        list= new ArrayList<>();
        adapter =new TrackerAdapter(list,getContext());

        binding.breakfastRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.breakfastRecycle.setHasFixedSize(true);
        binding.breakfastRecycle.setAdapter(adapter);
        list.add(new TrackerModal(R.drawable.food1,"Aloo Paratha","Calories 299,Protien 4g,Carbs 36g,Fat 12g "));
        list.add(new TrackerModal(R.drawable.food2,"Juice","Calories 299,Protien 4g,Carbs 36g,Fat 12g "));
        list.add(new TrackerModal(R.drawable.food3,"Fruit","Calories 299,Protien 4g,Carbs 36g,Fat 12g "));
        return binding.getRoot();
    }
}