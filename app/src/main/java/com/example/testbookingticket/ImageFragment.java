package com.example.testbookingticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ImageFragment extends Fragment {

    private Button tabNews, tabOffers;
    private FrameLayout fragmentContainerImage;

    public ImageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_image, container, false);

        tabNews = rootView.findViewById(R.id.tab_news_main);
        tabOffers = rootView.findViewById(R.id.tab_offers);
        fragmentContainerImage = rootView.findViewById(R.id.fragment_container_image);

        // Hiển thị NewsFragment ban đầu khi vào ImageFragment
        replaceFragment(new NewsFragment());

        // Thiết lập sự kiện onClickListener cho tab News
        tabNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new NewsFragment());
            }
        });

        // Thiết lập sự kiện onClickListener cho tab Offers
        tabOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new OffersFragment());
            }
        });

        return rootView;
    }

    // Hàm thay thế Fragment
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container_image, fragment);
        transaction.commit();
    }
}
