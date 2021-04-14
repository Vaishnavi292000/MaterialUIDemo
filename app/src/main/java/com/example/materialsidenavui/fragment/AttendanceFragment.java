package com.example.materialsidenavui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.materialsidenavui.R;
import com.ramotion.foldingcell.FoldingCell;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class AttendanceFragment extends Fragment {

    FoldingCell fc,fc1;
    PieChart pieChart,pieChart1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_attendance, container, false);
        fc = (FoldingCell) view.findViewById(R.id.folding_cell);
        fc1 = (FoldingCell) view.findViewById(R.id.folding_cell1);
        pieChart = view.findViewById(R.id.piechart);
        pieChart1 = view.findViewById(R.id.piechart1);

        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });

        // attach click listener to folding cell
        fc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc1.toggle(false);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        pieChart.addPieSlice(
                new PieModel(
                        "R",
                        87F,
                        Color.parseColor("#32CD32")));
        pieChart.addPieSlice(
                new PieModel(
                        "Python",
                        13F,
                        Color.parseColor("#FF4500")));


        // To animate the pie chart
        pieChart.startAnimation();


        pieChart1.addPieSlice(
                new PieModel(
                        "R",
                        87F,
                        Color.parseColor("#32CD32")));
        pieChart1.addPieSlice(
                new PieModel(
                        "Python",
                        13F,
                        Color.parseColor("#FF4500")));


        // To animate the pie chart
        pieChart1.startAnimation();

    }
}