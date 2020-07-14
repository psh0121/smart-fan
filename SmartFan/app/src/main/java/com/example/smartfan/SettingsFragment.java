package com.example.smartfan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {


    ArrayList<Setting> settings;
    ListView settingsListView;
    private static SettingsAdapter settingsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        //data를 가져와서 어답터와 연결해 준다. 서버에서 가져오는게 대부분 이다.
        settings = new ArrayList<>();
        settings.add(new Setting("위젯 설정", R.drawable.widget, "바탕화면에 추가시킬 위젯에 대한 설정"));
        settings.add(new Setting("온도 PUSH 알람", R.drawable.temperature, "일정 온도가 넘어가면 선풍기를 돌아가도록 설정"));
        settings.add(new Setting("음성인식모드 설정", R.drawable.voice, "버튼 클릭을 최소화해 음성만으로 선풍기가 켜지도록 설정"));
        settings.add(new Setting("도움말", R.drawable.advice, "기타 질문 확인"));

        settingsListView = (ListView) rootView.findViewById(R.id.listView_settings);
        settingsAdapter = new SettingsAdapter(getContext(),settings);
        settingsListView.setAdapter(settingsAdapter);

        //클릭하면 원하는 페이지로 넘어가게 설정
        settingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Settings_Widget.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Settings_Temperature.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Settings_Voice.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(view.getContext(), Settings_Advice.class);
                    startActivity(intent);
                }

            }
        });

        return rootView;
    }
}


//data class
class Setting {
    private String title;
    private String description;
    private Integer icon;

    public Setting(String title, Integer icon, String description) {
        this.title = title;
        this.description = description;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getIcon() {
        return icon;
    }
}
