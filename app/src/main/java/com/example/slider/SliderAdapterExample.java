package com.example.slider;
/*
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;

    public SliderAdapterExample(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.cardview, null );
        return new SliderAdapterVH ( inflate );
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {


        switch (position) {
            case 0:
                viewHolder.textViewDescription.setText ( "This is slider item " + position );
                viewHolder.textViewDescription.setTextSize ( 16 );
                viewHolder.textViewDescription.setTextColor ( Color.WHITE );
                viewHolder.imageGifContainer.setVisibility ( View.GONE );
                Glide.with ( viewHolder.itemView ).load ( "https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260" ).fitCenter ().into ( viewHolder.imageViewBackground );
                break;
            case 2:
                viewHolder.textViewDescription.setText ( "This is slider item " + position );
                viewHolder.textViewDescription.setTextSize ( 16 );
                viewHolder.textViewDescription.setTextColor ( Color.WHITE );
                viewHolder.imageGifContainer.setVisibility ( View.GONE );
                Glide.with ( viewHolder.itemView ).load ( "https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260" ).fitCenter ().into ( viewHolder.imageViewBackground );
                break;
            case 4:
                viewHolder.textViewDescription.setText ( "This is slider item " + position );
                viewHolder.textViewDescription.setTextSize ( 16 );
                viewHolder.textViewDescription.setTextColor ( Color.WHITE );
                viewHolder.imageGifContainer.setVisibility ( View.GONE );
                Glide.with ( viewHolder.itemView ).load ( "https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260" ).fitCenter ().into ( viewHolder.imageViewBackground );
                break;
            default:
                viewHolder.textViewDescription.setTextSize ( 29 );
                viewHolder.textViewDescription.setTextColor ( Color.WHITE );
                viewHolder.textViewDescription.setText ( "Ohhhh! look at this!" );
                viewHolder.imageGifContainer.setVisibility ( View.VISIBLE );
                Glide.with ( viewHolder.itemView ).load ( R.drawable.abc ).fitCenter ().into ( viewHolder.imageViewBackground );
                Glide.with ( viewHolder.itemView ).asGif ().load ( R.drawable.abc ).into ( viewHolder.imageGifContainer );
                break;

        }
    }

    public int getCount() {
        //slider view count could be dynamic size
        return 4;
    }


    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super ( itemView );
            imageViewBackground = itemView.findViewById ( R.id.iv_auto_image_slider );
            imageGifContainer = itemView.findViewById ( R.id.iv_gif_container );
            textViewDescription = itemView.findViewById ( R.id.tv_auto_image_slider );
            this.itemView = itemView;
        }
    }


}*/
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


public class SliderAdapterExample extends PagerAdapter {


    private ArrayList<Integer> IMAGES;
    private LayoutInflater inflater;
    private Context context;


    public SliderAdapterExample(Context context,ArrayList<Integer> IMAGES) {
        this.context = context;
this.IMAGES=IMAGES;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return IMAGES.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.cardview, view, false);

        assert imageLayout != null;
        final ImageView imageView = imageLayout
                .findViewById(R.id.image);


imageView.setImageResource(IMAGES.get(position));

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}

