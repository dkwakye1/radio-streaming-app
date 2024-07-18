package com.example.dan.expressradio;
/**
 * Created by dan on 11/12/16.
 */

import android.content.Intent;
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


public class TabAllStations  extends Fragment {


    static MyStations st1 = new MyStations("Peace FM", "http://198.255.36.2:8000");
    MyStations st2 = new MyStations("Okay FM", "http://198.255.36.2:8002");
    MyStations st3 = new MyStations("Adom FM", "http://listen.shoutcast.com/adomfmghana");
    MyStations st4 = new MyStations("Melody FM", "http://198.255.36.2:8032");
    MyStations st5 = new MyStations("Agoo FM", "http://192.235.87.105:15542");
    MyStations st6 = new MyStations("Hello FM", "http://198.255.36.2:8004");
    MyStations st7 = new MyStations("Radio Ghana", "http://listen.shoutcast.com/radioghana");



    Button stopPlay, buttonFav;
    String stationUrl;

   String[] items  = {st1.stationName, st2.stationName, st3.stationName, st4.stationName, st5.stationName, st6.stationName, st7.stationName};


    ListView listView1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_allstations, container, false);
        listView1 = (ListView) rootView.findViewById(R.id.listView1);

        stopPlay = (Button) rootView.findViewById(R.id.buttonStop);
        buttonFav = (Button) rootView.findViewById(R.id.buttonFav);

        stopPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    st1.stopPlaying();
                }

            });


        buttonFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("custom-event-name");
                intent.putExtra("stationURL", stationUrl);
                intent.putExtra("stationName", st1.stationName);
                LocalBroadcastManager.getInstance(TabAllStations.this.getActivity()).sendBroadcast(intent);

                Intent theIntent = new Intent(TabAllStations.this.getActivity(), CustomService.class);
                TabAllStations.this.getActivity().startService(theIntent);

            }

        });


        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, items);

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {


                switch (position){
                    case 0:
                       st1.stopPlaying();
                        st1.stationName = "Peace FM";
                        st1.initializeMediaPlayer("http://198.255.36.2:8000");
                        Toast.makeText(getActivity(), "Now Playing: " + (String)parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                        stationUrl = "http://198.255.36.2:8000";
                        break;


                    case 1:
                       st1.stopPlaying();
                        st1.stationName = "Okay Fm";
                        st1.initializeMediaPlayer("http://198.255.36.2:8002");
                        Toast.makeText(getActivity(), "Now Playing: " + (String)parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                        stationUrl = "http://198.255.36.2:8002";
                        break;


                    case 2:
                        st1.stopPlaying();
                        st1.stationName = "Adom FM";
                        st1.initializeMediaPlayer("http://listen.shoutcast.com/adomfmghana");
                        Toast.makeText(getActivity(), "Now Playing: " + (String)parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                        stationUrl = "http://listen.shoutcast.com/adomfmghana";
                        break;

                    case 3:
                        st1.stopPlaying();
                        st1.stationName = "Melody FM";
                        st1.initializeMediaPlayer("http://198.255.36.2:8032");
                        Toast.makeText(getActivity(), "Now Playing: " + (String)parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                        stationUrl = "http://198.255.36.2:8032";
                        break;


                    case 4:
                        st1.stopPlaying();
                        st1.stationName = "Agoo FM";
                        st1.initializeMediaPlayer("http://192.235.87.105:15542");
                        Toast.makeText(getActivity(), "Now Playing: " + (String)parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                        stationUrl = "http://192.235.87.105:15542";
                        break;


                    case 5:
                        st1.stopPlaying();
                        st1.stationName = "Hello FM";
                        st1.initializeMediaPlayer("http://198.255.36.2:8004");
                        Toast.makeText(getActivity(), "Now Playing: " + (String)parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                        stationUrl = "http://198.255.36.2:8004";
                        break;

                    case 6:
                        st1.stopPlaying();
                        st1.stationName = "Radio Ghana";
                        st1.initializeMediaPlayer("http://listen.shoutcast.com/radioghana");
                        Toast.makeText(getActivity(), "Now Playing: " + (String)parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
                        stationUrl = "http://listen.shoutcast.com/radioghana";
                        break;

                }


            }
        });

        return rootView;

    }

}


