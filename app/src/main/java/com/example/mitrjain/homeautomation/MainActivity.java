package com.example.mitrjain.homeautomation;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> listOfProfiles = new ArrayList<String>();
    public static ArrayList<String> overviewList = new ArrayList<String>();
    public static ArrayList<customAdapterImageButton> imgsrc = new ArrayList<customAdapterImageButton>();
    public static TextView userDetails;
    public static String username="";
    public static RecyclerView rv;
    public static Drawable hall,kitchen,bedroom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ImageButton img1 = (ImageButton) findViewById(R.id.Img1);
//        ImageButton img2 = (ImageButton) findViewById(R.id.Img2);
//        ImageButton img3 = (ImageButton) findViewById(R.id.Img3);
        ListView profiles = (ListView) findViewById(R.id.Profiles_ListView);
        ListView overview = (ListView) findViewById(R.id.Overview_ListView);
        DrawerLayout navDrawer = (DrawerLayout) findViewById(R.id.navDrawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rv = (RecyclerView) findViewById(R.id.recyclerView);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, navDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
         hall =getDrawable(R.drawable.hall);
         kitchen = getDrawable(R.drawable.kitchen);
         bedroom = getDrawable(R.drawable.bedroom);
        imgsrc.add(new customAdapterImageButton(hall));
        imgsrc.add(new customAdapterImageButton(kitchen));
        imgsrc.add(new customAdapterImageButton(bedroom));
        customAdapter images = new customAdapter(imgsrc);
        rv.setAdapter(images);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

        overviewList.clear();
        listOfProfiles.clear();
        overviewList.add("Lights");
        overviewList.add("CCTV Cameras");
        overviewList.add("Thermostats");
        listOfProfiles.add("Party");
        listOfProfiles.add("Not Home");
        listOfProfiles.add("Night");
        ArrayAdapter listAdapter1 = new ArrayAdapter(this, R.layout.navigationfield, listOfProfiles);
        ArrayAdapter listAdapter2 = new ArrayAdapter(this, R.layout.navigationfield, overviewList);
        profiles.setAdapter(listAdapter1);
        overview.setAdapter(listAdapter2);

        userDetails=(TextView) findViewById(R.id.UserDetails);
        username = "Hi "+getIntent().getExtras().getString("username");
        userDetails.setText(username);

        overview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView)view;
                if(tv.getText().toString().equalsIgnoreCase("Lights"))
                {
                    Intent intent = new Intent(MainActivity.this,OverviewActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Work under Progress",Toast.LENGTH_SHORT).show();
                }

            }
        });

        profiles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView)view;
                String profileMode=tv.getText().toString();
                Toast.makeText(MainActivity.this,profileMode+" mode Activated",Toast.LENGTH_SHORT).show();


            }
        });

    }

    public void navigate(View v) {

        ImageButton imgbutton = (ImageButton)v;
        int tag = (Integer)imgbutton.getTag();

        switch(tag){
            case 1:
                Intent i1 = new Intent(MainActivity.this, HallActivity.class);
                startActivity(i1);
                break;
            case 2:
                Toast.makeText(MainActivity.this,"Work under Progress",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Intent i3 = new Intent(MainActivity.this, BedroomActivity.class);
                startActivity(i3);
                break;



        }



    }

}
