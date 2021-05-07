package com.example.calculatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.calculatar.Adapters.HistoryAdapter;
import com.example.calculatar.Room.History;
import com.example.calculatar.Room.MyDatabase;
import com.example.calculatar.databinding.ActivityHistoryBinding;
import com.example.calculatar.databinding.ToolbarBinding;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class HistoryActivity extends AppCompatActivity {
    ActivityHistoryBinding binding;
    MyDatabase myDatabase;
    ArrayList<History> al;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        getSupportActionBar().hide();
        setContentView(binding.getRoot());
        Toolbar toolbar = new Toolbar(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //fatching data from data base
        roomDbSetUp();
        List<History> historyList = myDatabase.dao().getHistory();
        al = new ArrayList<>();
        al.addAll(historyList);
        HistoryAdapter adapter = new HistoryAdapter(this, al);
        binding.listView.setAdapter(adapter);
        binding.btnHistory.setOnClickListener(view -> {
            myDatabase.dao().deleteAllHistory();
            al.clear();
            adapter.notifyDataSetChanged();
            Toast.makeText(HistoryActivity.this, "All History Deleted Sucessfulley", LENGTH_LONG).show();
        });

        binding.toolbar.btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }

    private void roomDbSetUp() {
        myDatabase = Room.databaseBuilder(this, MyDatabase.class, "Historydb").allowMainThreadQueries().build();
    }

}