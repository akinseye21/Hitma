package com.example.hitma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class ItmaDashboard extends AppCompatActivity implements InecDashboards.OnFragmentInteractionListener, ProgressReport.OnFragmentInteractionListener, Notification.OnFragmentInteractionListener, InecHotlines.OnFragmentInteractionListener{

    NavigationView naviview;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    ImageView profileimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itma_dashboard);

        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Courses").setIcon(R.drawable.ab));
        tabLayout.addTab(tabLayout.newTab().setText("Progress Report").setIcon(R.drawable.progressreport));
        tabLayout.addTab(tabLayout.newTab().setText("Notifications").setIcon(R.drawable.notification_white));
        tabLayout.addTab(tabLayout.newTab().setText("Inec's Hotlines").setIcon(R.drawable.hotline_white));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //working with drawer layout
        mDrawerLayout = findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        ImageView imageView = findViewById(R.id.menu);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        profileimg = findViewById(R.id.profileimg);
        profileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imageclick = new Intent(ItmaDashboard.this, ItmaEditProfile.class);
                startActivity(imageclick);
            }
        });

        final ViewPager viewPager = findViewById(R.id.pager);
        final ItmaPagerAdapter adapter = new ItmaPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager
                .setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        naviview = findViewById(R.id.navigationview);
        naviview.setItemIconTintList(null);
        View hView = naviview.inflateHeaderView(R.layout.itma_navigation_header);
        naviview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.dashboard:
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.notification:
                        Intent notification = new Intent(ItmaDashboard.this, ItmaNotification.class);
                        startActivity(notification);
                        break;
                    case R.id.trainingmodules:
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.progressreport:
                        Intent progressreport = new Intent(ItmaDashboard.this, ItmaProgressReport.class);
                        startActivity(progressreport);
                        break;
                    case R.id.inechotlines:
                        Intent hotlines = new Intent(ItmaDashboard.this, ItmaHotline.class);
                        startActivity(hotlines);
                        break;
                    case R.id.abouthandout:
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.invitefriends:
                        Intent invite = new Intent(ItmaDashboard.this, ItmaInviteFriends.class);
                        startActivity(invite);
                        break;
                    case R.id.settings:
                        Intent settings = new Intent(ItmaDashboard.this, ItmaSettings.class);
                        startActivity(settings);
                        break;
                    case R.id.signout:
                        final AlertDialog.Builder builder = new AlertDialog.Builder(ItmaDashboard.this);
                        builder.setMessage("Are you sure you want to exit?");
                        builder.setCancelable(true);
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                Toast.makeText(ItmaDashboard.this, "Inec Handout Training", Toast.LENGTH_LONG).show();
                                Intent c = new Intent(getApplicationContext(), ItmaLogin.class);
                                startActivity(c);
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        break;

                    default:
                        mDrawerLayout.closeDrawers();
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
