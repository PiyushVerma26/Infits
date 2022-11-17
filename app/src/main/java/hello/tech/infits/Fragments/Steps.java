package hello.tech.infits.Fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.savvi.rangedatepicker.CalendarPickerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import hello.tech.infits.Adapters.GraphAdapter;
import hello.tech.infits.DataBase.DataFromDatbase;
import hello.tech.infits.Modals.GraphModal;
import hello.tech.infits.R;
import hello.tech.infits.View.CustomMarkerView;
import hello.tech.infits.View.ViewAll;
import hello.tech.infits.databinding.FragmentStepsBinding;


public class Steps extends Fragment {
   FragmentStepsBinding binding;
    GraphAdapter adapter;
    ArrayList<GraphModal> list;
    String url;
    StringRequest stringRequest;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStepsBinding.inflate(getLayoutInflater());
        list = new ArrayList<>();
        adapter = new GraphAdapter(list, getContext());
        binding.recycle.setHasFixedSize(true);
        binding.recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycle.setAdapter(adapter);
        list.add(new GraphModal("SEP", "18", "Shake", "85 ml", "9:10 AM"));
        list.add(new GraphModal("SEP", "17", "Dinner", "100 ml", "9:15 AM"));
        binding.viewAllItem.setOnClickListener(v -> startActivity(new Intent(getContext(), ViewAll.class)));

//        count

        url = String.format("%sstepsFragment.php", DataFromDatbase.ipConfig);
      stringRequest = new StringRequest(Request.Method.POST, url, response -> {
            if (!Objects.equals(response, "failure")) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject object0 = jsonArray.getJSONObject(0);
                    JSONObject object1 = jsonArray.getJSONObject(1);
                    JSONObject object2 = jsonArray.getJSONObject(2);
                    JSONObject object3 = jsonArray.getJSONObject(3);
                    String stepsWeek = object0.getString("stepsSumWeek");
                    if (stepsWeek.equals("null")) {
                        stepsWeek = "0";
                    }
                    binding.weekly.setText(stepsWeek);
                    String stepsMonth = object1.getString("stepsSumMonth");
                    if (stepsMonth.equals("null")) {
                        stepsMonth = "0";
                    }
                    binding.monthly.setText(stepsMonth);
                    String stepsDaily = object2.getString("stepsSumDaily");
                    if (stepsDaily.equals("null")) {
                        stepsDaily = "0";
                    }
                    binding.daily.setText(stepsDaily);
                    String stepsTotal = object3.getString("stepsSumTotal");
                    if (stepsTotal.equals("null")) {
                        stepsTotal = "0";
                    }
                    binding.total.setText(stepsTotal);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (response.equals("failure")) {
                Log.d("HeartFragment", "failure");
                Toast.makeText(getContext(), "heartFragment failed", Toast.LENGTH_SHORT).show();
            }
        }, error -> {

        }) {
            @NonNull
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> data = new HashMap<>();
                data.put("userID", DataFromDatbase.clientuserID);
                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        requestQueue.add(stringRequest);


//        Graph

        LineChart lineChart = binding.graph;
        ArrayList<Entry> NoOfEmp = new ArrayList<>();

        final LineDataSet[] dataSet = {new LineDataSet(NoOfEmp, "Number Of Employees")};
        dataSet[0].setDrawHorizontalHighlightIndicator(false);
        dataSet[0].setDrawVerticalHighlightIndicator(false);
        ArrayList<ILineDataSet> year = new ArrayList<>();
        year.add(dataSet[0]);

        dataSet[0].setColor(Color.parseColor("#FFA381"));
        dataSet[0].setCircleColor(Color.parseColor("#FFA381"));
        @SuppressLint("UseRequireInsteadOfGet") Typeface tf = ResourcesCompat.getFont(Objects.requireNonNull(getContext()), R.font.nats);
        LineData data = new LineData(dataSet[0]);

        XAxis xl = lineChart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);

        lineChart.getAxisRight().setEnabled(false);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);

        YAxis yAxisRight = lineChart.getAxisRight();
        yAxisRight.setDrawAxisLine(true);
        yAxisRight.setDrawGridLines(true);

        YAxis yAxisLeft = lineChart.getAxisLeft();
        yAxisLeft.setDrawGridLines(true);

        data.setValueTypeface(tf);

        lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                e.getData();
                CustomMarkerView customMarkerView = new CustomMarkerView(getContext(), R.layout.mark);
                lineChart.setMarker(customMarkerView);
            }

            @Override
            public void onNothingSelected() {

            }
        });

        dataSet[0].setDrawValues(false);

        lineChart.getDescription().setEnabled(false);
        lineChart.getLegend().setEnabled(false);

        lineChart.setData(data);

        RadioButton week_radioButton = binding.weekBtnSteps;
        RadioButton month_radioButton = binding.monthBtnSteps;
        RadioButton year_radioButton = binding.yearBtnSteps;
        RadioButton custom_radioButton = binding.customdatesBtnSteps;
        week_radioButton.setOnClickListener(v -> {
            NoOfEmp.removeAll(NoOfEmp);
            String url = String.format("%sstepsGraph.php", DataFromDatbase.ipConfig);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {
                System.out.println(DataFromDatbase.clientuserID);
                System.out.println(response);
                List<String> allNames = new ArrayList<>();
                JSONObject jsonResponse;
                ArrayList<String> mons = new ArrayList<>();
                try {
                    jsonResponse = new JSONObject(response);
                    JSONArray cast = jsonResponse.getJSONArray("steps");
                    for (int i = 0; i < cast.length(); i++) {
                        JSONObject actor = cast.getJSONObject(i);
                        String name = actor.getString("steps");
                        String date = actor.getString("date");
                        System.out.println(name + "   " + date);
                        allNames.add(name);
                        mons.add(date);
                        NoOfEmp.add(new Entry(i, Float.parseFloat(name)));
                        System.out.println("Points " + NoOfEmp.get(i));
                        dataSet[0] = (LineDataSet) lineChart.getData().getDataSetByIndex(0);

                        dataSet[0].setValues(NoOfEmp);


                        dataSet[0].notifyDataSetChanged();
                    }
                    lineChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mons));

                    lineChart.getData().notifyDataChanged();
                    lineChart.notifyDataSetChanged();
                    lineChart.invalidate();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }, error -> Log.d("Data", error.toString().trim())) {
                @NonNull
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> dataVol = new HashMap<>();
                    dataVol.put("clientuserID", DataFromDatbase.clientuserID);
                    return dataVol;
                }
            };
            Volley.newRequestQueue(requireActivity()).add(stringRequest);
        });

        month_radioButton.setOnClickListener(v -> {
            NoOfEmp.removeAll(NoOfEmp);
            String url = String.format("%sstepsMonthGraph.php", DataFromDatbase.ipConfig);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {
                System.out.println(DataFromDatbase.clientuserID);
                System.out.println(response);
                List<String> allNames = new ArrayList<>();
                JSONObject jsonResponse;
                ArrayList<String> mons = new ArrayList<>();
                try {
                    jsonResponse = new JSONObject(response);
                    JSONArray cast = jsonResponse.getJSONArray("steps");
                    for (int i = 0; i < cast.length(); i++) {
                        JSONObject actor = cast.getJSONObject(i);
                        String name = actor.getString("steps");
                        String date = actor.getString("date");
                        System.out.println(name + "   " + date);
                        allNames.add(name);
                        mons.add(date);
                        NoOfEmp.add(new Entry(i, Float.parseFloat(name)));
                        System.out.println("Points " + NoOfEmp.get(i));
                        dataSet[0] = (LineDataSet) lineChart.getData().getDataSetByIndex(0);

                        dataSet[0].setValues(NoOfEmp);


                        dataSet[0].notifyDataSetChanged();
                    }
                    lineChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mons));

                    lineChart.getData().notifyDataChanged();
                    lineChart.notifyDataSetChanged();
                    lineChart.invalidate();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }, error -> Log.d("Data", error.toString().trim())) {
                @NonNull
                @Override
                protected Map<String, String> getParams() {

                    Map<String, String> data = new HashMap<>();

                    data.put("clientID", DataFromDatbase.clientuserID);

                    return data;
                }
            };
            Volley.newRequestQueue(requireActivity()).add(stringRequest);
        });
        year_radioButton.setOnClickListener(v -> {
            NoOfEmp.removeAll(NoOfEmp);
            String url = String.format("%sstepsYearGraph.php", DataFromDatbase.ipConfig);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {
                List<String> allNames = new ArrayList<>();
                JSONObject jsonResponse;
                try {
                    jsonResponse = new JSONObject(response);
                    JSONArray cast = jsonResponse.getJSONArray("steps");
                    for (int i = 0; i < cast.length(); i++) {
                        JSONObject actor = cast.getJSONObject(i);
                        String name = actor.getString("av");
                        System.out.println(name);
                        allNames.add(name);
                        NoOfEmp.add(new Entry(i, Float.parseFloat(name)));
                        System.out.println("Points " + NoOfEmp.get(i));
                        dataSet[0] = (LineDataSet) lineChart.getData().getDataSetByIndex(0);

                        dataSet[0].setValues(NoOfEmp);

                        dataSet[0].notifyDataSetChanged();
                        lineChart.getData().notifyDataChanged();
                        lineChart.notifyDataSetChanged();
                        lineChart.invalidate();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }, error -> Log.d("Data", error.toString().trim())) {
                @NonNull
                @Override
                protected Map<String, String> getParams() {

                    Map<String, String> data = new HashMap<>();

                    data.put("userID", DataFromDatbase.clientuserID);

                    return data;
                }
            };
            Volley.newRequestQueue(requireActivity()).add(stringRequest);
        });
        custom_radioButton.setOnClickListener(v -> {
            NoOfEmp.removeAll(NoOfEmp);
            final Dialog dialog = new Dialog(getActivity());
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.calende_dialoug);
            final Calendar nextYear = Calendar.getInstance();
            nextYear.add(Calendar.YEAR, 10);

            final Calendar lastYear = Calendar.getInstance();
            lastYear.add(Calendar.YEAR, -10);

            CalendarPickerView calendarPickerView = dialog.findViewById(R.id.cal_for_graph);
            calendarPickerView.init(lastYear.getTime(), nextYear.getTime(), new SimpleDateFormat("MMMM", Locale.getDefault())).inMode(CalendarPickerView.SelectionMode.RANGE).withSelectedDate(new Date());

            Button done = dialog.findViewById(R.id.done);
            Button cancel = dialog.findViewById(R.id.cancel);

            done.setOnClickListener(vi -> {
                List<Date> dates = calendarPickerView.getSelectedDates();
                @SuppressLint("SimpleDateFormat") SimpleDateFormat sf = new SimpleDateFormat("MMM dd,yyyy");
                String from = sf.format(dates.get(0));
                String to = sf.format(dates.get(dates.size() - 1));
                String url = String.format("%scustom.php", DataFromDatbase.ipConfig);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {
                    System.out.println(DataFromDatbase.clientuserID);
                    System.out.println(response);
                    List<String> allNames = new ArrayList<>();
                    JSONObject jsonResponse;
                    ArrayList<String> mons = new ArrayList<>();
                    try {
                        jsonResponse = new JSONObject(response);
                        JSONArray cast = jsonResponse.getJSONArray("steps");
                        for (int i = 0; i < cast.length(); i++) {
                            JSONObject actor = cast.getJSONObject(i);
                            String name = actor.getString("steps");
                            String date = actor.getString("date");
                            System.out.println(name + "   " + date);
                            allNames.add(name);
                            mons.add(date);
                            NoOfEmp.add(new Entry(i, Float.parseFloat(name)));
                            System.out.println("Points " + NoOfEmp.get(i));
                            dataSet[0] = (LineDataSet) lineChart.getData().getDataSetByIndex(0);

                            dataSet[0].setValues(NoOfEmp);

                            dataSet[0].notifyDataSetChanged();
                        }
                        lineChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(mons));

                        lineChart.getData().notifyDataChanged();
                        lineChart.notifyDataSetChanged();
                        lineChart.invalidate();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> Log.d("Data", error.toString().trim())) {
                    @NonNull
                    @Override
                    protected Map<String, String> getParams() {

                        Map<String, String> dataVol = new HashMap<>();
                        dataVol.put("clientID", DataFromDatbase.clientuserID);
                        dataVol.put("from", from);
                        dataVol.put("to", to);
                        return dataVol;
                    }
                };
                Volley.newRequestQueue(requireActivity()).add(stringRequest);
                dialog.dismiss();
            });

            cancel.setOnClickListener(view1 -> dialog.dismiss());
            dialog.show();
        });
        return binding.getRoot();
    }
    
}