package hello.tech.infits.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import hello.tech.infits.Adapters.DietChartAdapter;
import hello.tech.infits.Modals.DietChartModal;
import hello.tech.infits.R;
import hello.tech.infits.databinding.FragmentDietBreakfastBinding;

public class DietBreakfastFragment extends Fragment {
    FragmentDietBreakfastBinding binding;
    DietChartAdapter adapter;
    ArrayList<DietChartModal> list;
    public DietBreakfastFragment() {
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentDietBreakfastBinding.inflate(getLayoutInflater());
        list=new ArrayList<>();
       adapter=new DietChartAdapter(list,getContext());
        binding.dietRecycle.setHasFixedSize(true);
        binding.AfterRecycle.setHasFixedSize(true);
        LinearLayoutManager linearlayout=new LinearLayoutManager(getContext());
        linearlayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.dietRecycle.setLayoutManager(linearlayout);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.AfterRecycle.setLayoutManager(linearLayoutManager);
        binding.dietRecycle.setAdapter(adapter);
        binding.AfterRecycle.setAdapter(adapter);
        list.add(new DietChartModal(R.drawable.plus));
        list.add(new DietChartModal(R.drawable.plus));
        list.add(new DietChartModal(R.drawable.plus));
        list.add(new DietChartModal(R.drawable.plus));






        return binding.getRoot();
    }
}