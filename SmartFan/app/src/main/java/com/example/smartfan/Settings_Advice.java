package com.example.smartfan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Settings_Advice extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Settings_Advice_Versions> versionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //각 파일에 맞게 ContentView 설정
        setContentView(R.layout.settings__advice);

        recyclerView = findViewById(R.id.settings_recyclerView);

        initData();
        setRecyclerView();

    }

    private void setRecyclerView() {
        Settings_Advice_VersionsAdapter versionsAdapter = new Settings_Advice_VersionsAdapter(versionsList);
        recyclerView.setAdapter(versionsAdapter);
        recyclerView.setHasFixedSize(false);
    }

    private void initData() {

        versionsList = new ArrayList<>();

        versionsList.add(new Settings_Advice_Versions("remote control", "불라불라", "머시기머시기", "랄랄라"));
        versionsList.add(new Settings_Advice_Versions("add remote control", "블라블라", "머시기머시기", "랄랄라"));
        versionsList.add(new Settings_Advice_Versions("위젯설정", "블라블라", "머시기머시기", "랄랄라"));
        versionsList.add(new Settings_Advice_Versions("온도푸시알람", "블라블라", "머시기머시기", "랄랄라"));
        versionsList.add(new Settings_Advice_Versions("음성인식모드", "블라블라", "머시기머시기", "랄랄라"));

    }
}