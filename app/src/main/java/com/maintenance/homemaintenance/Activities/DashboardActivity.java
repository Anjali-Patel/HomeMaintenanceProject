package com.maintenance.homemaintenance.Activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.maintenance.homemaintenance.Fragment.AccountFragment;
import com.maintenance.homemaintenance.Fragment.CartFragment;
import com.maintenance.homemaintenance.Fragment.HomeMaintenanceFragment;
import com.maintenance.homemaintenance.Fragment.OneOffFragment;
import com.maintenance.homemaintenance.Fragment.PackageFragment;
import com.maintenance.homemaintenance.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    BottomNavigationView bottom_navigationView;
    DrawerLayout drawer;
    NavigationView navigationView;
    Dialog dialog;
Fragment fragment=null;
    Toolbar toolbar;
    EditText searchpackage_service;
    boolean b_cart,b_packages,b_one_off,b_account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        navigationView = findViewById(R.id.nav_view);
        searchpackage_service=findViewById(R.id.searchpackage_service);
         toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        bottom_navigationView = findViewById(R.id.bottom_navigationView);
        bottom_navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bottom_navigationView.setItemIconTintList(null);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        loadHomeFragment(new HomeMaintenanceFragment());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    toolbar.setVisibility(View.VISIBLE);
                    searchpackage_service.setVisibility(View.VISIBLE);
                    loadHomeFragment(new HomeMaintenanceFragment());
                    break;
                case R.id.cart:
                    b_cart=true;
                    searchpackage_service.setVisibility(View.GONE);
                    toolbar.setVisibility(View.GONE);
                    loadHomeFragment(new CartFragment());
                    break;
                case R.id.packages:
                    b_packages=true;
                    searchpackage_service.setVisibility(View.GONE);
                    toolbar.setVisibility(View.GONE);
                    loadHomeFragment(new PackageFragment());
                    break;
                case R.id.one_off:
                    b_one_off=true;
                    searchpackage_service.setVisibility(View.GONE);
                    toolbar.setVisibility(View.GONE);
                    loadHomeFragment(new OneOffFragment());
                    break;
                case R.id.account:
                    b_account=true;
                    searchpackage_service.setVisibility(View.GONE);
                    toolbar.setVisibility(View.GONE);
                    loadHomeFragment(new AccountFragment());
                    break;

            }

            return false;
        }
    };

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.chat:
                Intent intent = new Intent(DashboardActivity.this, ChatActivity.class);
                startActivity(intent);
                drawer.closeDrawers();
                return true;
            case R.id.faqs:
                Intent intent1 = new Intent(DashboardActivity.this, FAQsActivity.class);
                startActivity(intent1);
                drawer.closeDrawers();
                return true;
            case R.id.contact_us:
                Intent intent2 = new Intent(DashboardActivity.this, ContactUsActivity.class);
                startActivity(intent2);
                drawer.closeDrawers();
                return true;
            case R.id.offers:
                Intent intent3 = new Intent(DashboardActivity.this, OffersActivity.class);
                startActivity(intent3);
                drawer.closeDrawers();
                return true;
            case R.id.home_maintenance_packages:
                toolbar.setVisibility(View.GONE);
                searchpackage_service.setVisibility(View.GONE);
                loadHomeFragment(new PackageFragment());
                bottom_navigationView.setSelectedItemId(R.id.packages);
                drawer.closeDrawers();
                return true;
            case R.id.one_off_serviceas:
                toolbar.setVisibility(View.GONE);
                searchpackage_service.setVisibility(View.GONE);
                loadHomeFragment(new OneOffFragment());
                bottom_navigationView.setSelectedItemId(R.id.one_off);
                drawer.closeDrawers();
                return true;
            case R.id.about_us:
                Intent intent6 = new Intent(DashboardActivity.this, AboutUsActivity.class);
                startActivity(intent6);
                drawer.closeDrawers();
                return true;
            case R.id.terms_conditions:
                Intent intent7 = new Intent(DashboardActivity.this, TermsConditionActivity.class);
                startActivity(intent7);
                drawer.closeDrawers();
                return true;
            case R.id.membership:
                Intent intent8 = new Intent(DashboardActivity.this, MembershipActivity.class);
                startActivity(intent8);
                drawer.closeDrawers();
                return true;
            case R.id.rating:
                Intent intent9 = new Intent(DashboardActivity.this, CustomerRatingModule.class);
                startActivity(intent9);
                drawer.closeDrawers();
                return true;
            case R.id.share:
                String appUrl = "https://play.google.com/store/apps/details?id=com.app.feish.application&hl=en_IN";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, appUrl);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, "Downloaad ");
                startActivity(shareIntent);
                return true;

            case R.id.logout:
                logoutDialog();
                return true;

            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

//    @Override
//    public boolean onSupportNavigateUp() {
////        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
////        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
////                || super.onSupportNavigateUp();
//    }

    private void logoutDialog() {
        dialog = new Dialog(DashboardActivity.this, R.style.AlertDialogCustom);
        dialog.setContentView(R.layout.custom_alert);
        dialog.setCancelable(false);
        TextView tv1 = dialog.findViewById(R.id.tv1);
        tv1.setTextSize(12f);
        Button b1 = dialog.findViewById(R.id.b1);
        b1.setText(getString(R.string.yes));
        Button b2 = dialog.findViewById(R.id.b2);
        b2.setText(getString(R.string.no));
        tv1.setText(R.string.logout);
        b1.setOnClickListener(v -> {

            Intent normalIntent = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(normalIntent);
            dialog.dismiss();
        });
        b2.setOnClickListener(v -> {
            dialog.dismiss();
        });
        try {
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private void loadHomeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }  else if(b_cart) {
            toolbar.setVisibility(View.VISIBLE);
            searchpackage_service.setVisibility(View.VISIBLE);

            loadHomeFragment(new HomeMaintenanceFragment());
            b_cart=false;
//            bottom_navigationView.setSelectedItemId(R.id.nav_home);
        } else if(b_packages){
            toolbar.setVisibility(View.VISIBLE);
            searchpackage_service.setVisibility(View.VISIBLE);
            loadHomeFragment(new HomeMaintenanceFragment());
            b_packages=false;
//            bottom_navigationView.setSelectedItemId(R.id.nav_home);
        }else if(b_one_off){
            toolbar.setVisibility(View.VISIBLE);
            searchpackage_service.setVisibility(View.VISIBLE);

            loadHomeFragment(new HomeMaintenanceFragment());
            b_one_off=false;
        } else if(b_account) {
            toolbar.setVisibility(View.VISIBLE);
            searchpackage_service.setVisibility(View.VISIBLE);

            loadHomeFragment(new HomeMaintenanceFragment());
            b_account=false;
//            bottom_navigationView.setSelectedItemId(R.id.nav_home);
        } else if(bottom_navigationView.getSelectedItemId()==R.id.bottom_home) {
            exitDialog();
        }





    }
    private void exitDialog() {
        dialog = new Dialog(DashboardActivity.this, R.style.AlertDialogCustom);
        dialog.setContentView(R.layout.custom_alert);
        dialog.setCancelable(false);
        TextView tv1 = dialog.findViewById(R.id.tv1);
        tv1.setTextSize(12f);
        Button b1 = dialog.findViewById(R.id.b1);
        b1.setText(getString(R.string.cancel));
        Button b2 = dialog.findViewById(R.id.b2);
        b2.setText(getString(R.string.exit));
        tv1.setText(R.string.want_exit);
        b1.setOnClickListener(v -> {
            dialog.dismiss();
        });
        b2.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            dialog.dismiss();

        });
        try {
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}