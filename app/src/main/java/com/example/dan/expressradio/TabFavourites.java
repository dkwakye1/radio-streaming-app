package com.example.dan.expressradio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dan on 11/12/16.
 */

public class TabFavourites extends Fragment {

   //MyStations st1 = new MyStations("Peace FM", "http://198.255.36.2:8000");

    //String stationUrl;

    Button stopPlay, buttonFav;

    //MyStationsPlayer[] items  = {};

    List<String> items_list = new ArrayList<>();


    ArrayAdapter<String> adapter;

    ListView listView1;

    private BroadcastReceiver mMessageReceiver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mMessageReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {

                String stationName = intent.getStringExtra("stationName");
                items_list.add(stationName);
                adapter.notifyDataSetChanged();
                TabAllStations.st1.stationUrl = intent.getStringExtra("stationURL");
            }
        };

     //   List<String> items_list2 = items_list;

        View rootView = inflater.inflate(R.layout.tab_favourites, container, false);

      LocalBroadcastManager.getInstance(this.getActivity()).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-event-name"));

        listView1 = (ListView) rootView.findViewById(R.id.listView1);

        stopPlay = (Button) rootView.findViewById(R.id.buttonStop);
        buttonFav = (Button) rootView.findViewById(R.id.buttonFav);


        stopPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              TabAllStations.st1.stopPlaying();
            }

        });

        adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, items_list);

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {


                switch (position){
                    case 0:
                        TabAllStations.st1.stopPlaying();
                        TabAllStations.st1.initializeMediaPlayer(TabAllStations.st1.stationUrl);
                        Toast.makeText(getActivity(), "Now Playing: " + (String)parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                        break;


                    case 1:
                        TabAllStations.st1.stopPlaying();
                        TabAllStations.st1.initializeMediaPlayer(TabAllStations.st1.stationUrl);
                        Toast.makeText(getActivity(), "Now Playing: " + (String)parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                        break;


                    case 2:
                        TabAllStations.st1.stopPlaying();
                        TabAllStations.st1.initializeMediaPlayer(TabAllStations.st1.stationUrl);
                        Toast.makeText(getActivity(), "Now Playing: " + (String)parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                        break;

                }


            }
        });



        return rootView;
    }

}
