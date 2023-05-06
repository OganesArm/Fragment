package com.example.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;


public class Fragment1 extends Fragment  implements View.OnClickListener {
    Button btn1, btn2, btn3;
    TextView textFR1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        btn1 = view.findViewById(R.id.btn1_FR1);
        btn2 = view.findViewById(R.id.btn2_FR1);
        btn3 = view.findViewById(R.id.btn3_FR1);
        textFR1 = view.findViewById(R.id.textFR1);
        String i = "Здесь страница с FRAGMENT 1";
        textFR1.setText(i);
        textFR1.setTextSize(23);
        btn3.setVisibility(View.GONE);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        return view;
    }


@Override
public void onClick(View v) {
    //задержка при переходе по кнопке
    for (int i = 0; i < 350; i++) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // используем getParentFragmentManager(), если устройство работает на API 26 и выше
        if (v.getId() == R.id.btn1_FR1) {
            Fragment newFragment = new Fragment3();
            assert getParentFragmentManager() != null; // Нужна ли проверка на ноль???
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (v.getId() == R.id.btn2_FR1) {
            Fragment newFragment = new Fragment2();
            assert getParentFragmentManager() != null;
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
        }
    } else {
        // используем getActivity().getSupportFragmentManager() для устройств с API ниже 26
        if (v.getId() == R.id.btn1_FR1) {
            Fragment newFragment = new Fragment3();
            assert getActivity().getSupportFragmentManager() != null;
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (v.getId() == R.id.btn2_FR1) {
            Fragment newFragment = new Fragment2();
            assert getActivity().getSupportFragmentManager() != null;
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
        }
        }
    }
}