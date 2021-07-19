package com.maintenance.homemaintenance.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.maintenance.homemaintenance.R;

import java.util.ArrayList;

public class HomeImageSliderAdapter   extends PagerAdapter {
    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private Context context;

    public HomeImageSliderAdapter(Context context, ArrayList<Integer> images) {
        this.context = context;
        this.images=images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = (View) inflater.inflate(R.layout.home_imageslider_list ,view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.image);
        myImage.setImageResource(images.get(position));
        TextView message=(TextView)myImageLayout.findViewById(R.id.message);
        if(position==0){
            message.setText("Get quality service by trusted professionals for all your home maintenance and repair needs at your doorstep");

        }
        else if(position==1){
            message.setText("Pay invoices,get quptations and approvals,manage your service bookings,purchases,packages and properties on your fingertips");
        }else if(position==2){
            message.setText("Select the date and time slot that suits you for our professional to arrive on site");
        }else if(position==3){
            message.setText("Choose from a range of reliable and affordable Home maintenance yearly/monthly packages or on services for your home improvement need");
        }
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
