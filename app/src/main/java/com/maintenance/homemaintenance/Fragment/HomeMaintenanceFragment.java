package com.maintenance.homemaintenance.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maintenance.homemaintenance.Activities.MainActivity;
import com.maintenance.homemaintenance.Adapter.HomeImageSliderAdapter;
import com.maintenance.homemaintenance.Adapter.MyAdapter;
import com.maintenance.homemaintenance.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeMaintenanceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeMaintenanceFragment extends Fragment {
    View view;
    private static ViewPager mPager;
    private static int currentPage = 0;
    Runnable Update=null;
    Timer timer=null;
    private static final Integer[] XMEN= {R.drawable.hassle_free,R.drawable.evrything_on_go,R.drawable.book_section,R.drawable.package_service};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeMaintenanceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeMaintenanceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeMaintenanceFragment newInstance(String param1, String param2) {
        HomeMaintenanceFragment fragment = new HomeMaintenanceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_home_maintenance, container, false);
        init();
        return view;
    }
    private void init() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);

        mPager = view.findViewById(R.id.pager);
        mPager.setAdapter(new HomeImageSliderAdapter(getContext(),XMENArray));
        CircleIndicator indicator = view.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
        // Auto start of viewpager
    /*    final Handler handler = new Handler() {
            @Override
            public void publish(LogRecord logRecord) {

            }

            @Override
            public void flush() {

            }

            @Override
            public void close() throws SecurityException {

            }
        };*/
        Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                mPager.post(new Runnable(){

                    @Override
                    public void run() {
                        mPager.setCurrentItem((mPager.getCurrentItem()+1)%XMEN.length);
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 5000, 5000);
    }
}