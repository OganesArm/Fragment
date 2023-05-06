package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment1 f1 = new Fragment1();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); //создаем переход
        ft.replace(R.id.container, f1); // указываем где заменить и на что
        ft.addToBackStack(null); // удаляем предыдущие фрагменты из памяти
        ft.commit(); //запускаем
    }

//    public void click1(View view){
//        Fragment1 f1 = new Fragment1();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); //создаем переход
//        ft.replace(R.id.container, f1); // указываем где заменить и на что
//        ft.addToBackStack(null); // удаляем предыдущие фрагменты из памяти
//        ft.commit(); //запускаем
//    }
//
//    public void click2(View view){
//        Fragment2 f2 = new Fragment2();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.conteiner, f2); // указываем где заменить и на что
//        ft.commit(); //запускаем
//    }
//
//    public void click3(View view){
//        Fragment3 f3 = new Fragment3();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.conteiner, f3); // указываем где заменить и на что
//        ft.commit(); //запускаем
//    }
}