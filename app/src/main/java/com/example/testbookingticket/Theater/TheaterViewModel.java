package com.example.testbookingticket.Theater;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class TheaterViewModel extends ViewModel {
    private TheaterRepository theaterRepository;
    private LiveData<List<Theater>> theatersLiveData;

    public TheaterViewModel() {
        this.theaterRepository = new TheaterRepository();
        theatersLiveData = theaterRepository.getAllTheaters();
    }

    public LiveData<List<Theater>> getTheaters() {
        return theatersLiveData;
    }
}
