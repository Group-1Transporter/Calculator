package com.example.calculatar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.calculatar.Models.History;
import com.example.calculatar.R;
import com.example.calculatar.databinding.HistoryListBinding;

import java.util.ArrayList;

public class HistoryAdapter extends ArrayAdapter {
    Context context;
    ArrayList<History>al;

    public HistoryAdapter(@NonNull Context context, ArrayList<History>historyArrayList) {

        super(context, R.layout.history_list,historyArrayList);
        this.context=context;
        this.al=historyArrayList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HistoryListBinding binding = HistoryListBinding.inflate(LayoutInflater.from(context));
        History history = al.get(position);
        binding.calculation.setText(history.getResult());
        binding.result.setText(history.getResultFinal());
        return binding.getRoot();
    }
}
