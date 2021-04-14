package com.example.materialsidenavui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.materialsidenavui.R;
import com.example.materialsidenavui.TimeTableActivity;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class DashboardFragment extends Fragment {

    PieChart pieChart;
    TextView viewall;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        pieChart = inflatedView.findViewById(R.id.piechart);
        viewall=inflatedView.findViewById(R.id.viewAll);

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getContext(), TimeTableActivity.class));
            }
        });

        return inflatedView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        pieChart.addPieSlice(
                new PieModel(
                        "R",
                        87F,
                        Color.parseColor("#4B4873")));
        pieChart.addPieSlice(
                new PieModel(
                        "Python",
                        13F,
                        Color.parseColor("#24C6DC")));



        // To animate the pie chart
        pieChart.startAnimation();

    }
}