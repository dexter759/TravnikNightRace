package com.example.incubator3.travniknightrace.activities.propertyActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.incubator3.travniknightrace.R;
import com.example.incubator3.travniknightrace.entities.Property;

import java.util.ArrayList;

/**
 * Created by admin on 3/22/2016.
 */
public class HomelistViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Property> beanClassArrayList;


    public HomelistViewAdapter(Context context, ArrayList<Property> beanClassArrayList) {
        this.context = context;
        this.beanClassArrayList = beanClassArrayList;


    }

    @Override
    public int getCount() {
        return beanClassArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanClassArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHoder viewHoder;
        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.home_listview, parent, false);

            viewHoder = new ViewHoder();



            viewHoder.city =  convertView.findViewById(R.id.city);
            viewHoder.hotel =  convertView.findViewById(R.id.hotel);
            viewHoder.image =  convertView.findViewById(R.id.image);

            convertView.setTag(viewHoder);

        } else {

            viewHoder = (ViewHoder) convertView.getTag();
        }



        Property beanClass = (Property) getItem(position);

            viewHoder.city.setText(beanClass.getName());
            viewHoder.hotel.setText(beanClass.getLocation());
            viewHoder.image.setImageResource(beanClass.getImage());



        return convertView;

    }


    private class ViewHoder{

        ImageView image;
        TextView city;
        TextView hotel;


    }

////    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
////        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
////                .getHeight(), Bitmap.Config.ARGB_8888);
////        Canvas canvas = new Canvas(output);
////
////        final int color = 0xff424242;
////        final Paint paint = new Paint();
////        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
////        final RectF rectF = new RectF(rect);
////        final float roundPx = pixels;
////
////        paint.setAntiAlias(true);
////        canvas.drawARGB(0, 0, 0, 0);
////        paint.setColor(color);
////        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
////
////        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
////        canvas.drawBitmap(bitmap, rect, rect, paint);
////
////        return output;
//    }



}
