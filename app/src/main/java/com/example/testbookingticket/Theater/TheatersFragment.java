package com.example.testbookingticket.Theater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testbookingticket.R;

import java.util.List;

public class TheatersFragment extends Fragment {

    private List<Theater> theaters;
    private RecyclerView rcv_theater;
    private  TheaterAdapter theaterAdapter = new TheaterAdapter();
    private TheaterViewModel theaterViewModel;
    public TheatersFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_theaters, container, false);
        theaterViewModel = new ViewModelProvider(this).get(TheaterViewModel.class);


        rcv_theater = rootView.findViewById(R.id.rcv_theater);
        LinearLayoutManager layout = new LinearLayoutManager(requireContext());
        rcv_theater.setLayoutManager(layout);
        rcv_theater.setAdapter(theaterAdapter);

        theaterViewModel.getTheaters().observe(getViewLifecycleOwner(), new Observer<List<Theater>>() {
            @Override
            public void onChanged(List<Theater> theaters) {
                theaterAdapter.setTheaters(theaters);
            }
        });

        return rootView;
    }
}