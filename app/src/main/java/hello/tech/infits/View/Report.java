package hello.tech.infits.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import hello.tech.infits.Adapters.ReportAdapter;
import hello.tech.infits.Modals.ReportModal;
import hello.tech.infits.databinding.ActivityReportBinding;

public class Report extends AppCompatActivity {
   ActivityReportBinding binding;
    ArrayList<ReportModal> list;
    ReportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        list = new ArrayList<>();
        adapter = new ReportAdapter(list, this);
        binding.reportRecycle.setLayoutManager(new LinearLayoutManager(this));
        binding.reportRecycle.setHasFixedSize(true);
        binding.reportRecycle.setAdapter(adapter);
        list.add(new ReportModal("Snacks","370 kcal","29 Jun 2019","5:10 PM"));
        list.add(new ReportModal("Snacks","370 kcal","29 Jun 2019","5:10 PM"));
        list.add(new ReportModal("Snacks","370 kcal","29 Jun 2019","5:10 PM"));
        list.add(new ReportModal("Snacks","370 kcal","29 Jun 2019","5:10 PM"));
        list.add(new ReportModal("Snacks","370 kcal","29 Jun 2019","5:10 PM"));
        list.add(new ReportModal("Snacks","370 kcal","29 Jun 2019","5:10 PM"));
        list.add(new ReportModal("Snacks","370 kcal","29 Jun 2019","5:10 PM"));
        list.add(new ReportModal("Snacks","370 kcal","29 Jun 2019","5:10 PM"));
        list.add(new ReportModal("Snacks","370 kcal","29 Jun 2019","5:10 PM"));
    }
}