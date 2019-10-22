package com.sunzn.divider.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sunzn.divider.library.HorizontalDivider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.addItemDecoration(new HorizontalDivider(this, R.drawable.shape_item_line, false));
//        mRecyclerView.addItemDecoration(new HorizontalDivider(this, R.color.colorAccent, 10, 10, false));
        mRecyclerView.addItemDecoration(new HorizontalDivider(this, R.color.colorAccent, 20, 10, 10, false));
//        HorizontalDivider divider = new HorizontalDivider(this, R.color.colorAccent, PX,1,false);
//        divider.setColor(R.color.colorAccent);
//        divider.setHeight(PX,1);
//        mRecyclerView.addItemDecoration(divider);
//        mRecyclerView.addItemDecoration(new HorizontalDivider(this, R.drawable.shape_item_line, 10, 10, false));
        mRecyclerView.setAdapter(new RecyclerAdapter());
    }
}
