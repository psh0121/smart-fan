package com.example.smartfan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

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

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null); // 화면에 보이는 앱 제목 타이틀을 제거

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.settings_recyclerView);

        initData();
        setRecyclerView();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void setRecyclerView() {
        Settings_Advice_VersionsAdapter versionsAdapter = new Settings_Advice_VersionsAdapter(versionsList);
        recyclerView.setAdapter(versionsAdapter);
        recyclerView.setHasFixedSize(false);
    }

    private void initData() {

        versionsList = new ArrayList<>();

        versionsList.add(new Settings_Advice_Versions("remote control", "불라불라", "머시기머시기"));
        versionsList.add(new Settings_Advice_Versions("add remote control", "블라블라", "머시기머시기"));
        versionsList.add(new Settings_Advice_Versions("위젯설정", "블라블라", "머시기머시기"));
        versionsList.add(new Settings_Advice_Versions("온도푸시알람", "블라블라", "머시기머시기"));
        versionsList.add(new Settings_Advice_Versions("음성인식모드", "블라블라", "머시기머시기"));

    }
}