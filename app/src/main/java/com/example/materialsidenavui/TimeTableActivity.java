package com.example.materialsidenavui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TimeTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        List<ItemModel> itemModelList=new ArrayList<>();

        for (int i=0;i<5;i++)
        {
            ItemModel itemModel=new ItemModel();
            itemModel.setItem_subtitle("Faculty Name");
            itemModel.setItem_title("Subject Name");
            itemModelList.add(itemModel);
        }


        TrailAdapter adapter=new TrailAdapter(itemModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



    }
}