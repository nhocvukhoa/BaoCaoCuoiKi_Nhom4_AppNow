package com.example.now1.home.listProvince;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.now1.R;

import java.util.ArrayList;

public class ProvinceAdapter extends ArrayAdapter<com.example.now1.home.listProvince.ProvinceModel> implements View.OnClickListener{

    private ArrayList<com.example.now1.home.listProvince.ProvinceModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtProvince;
    }

    public ProvinceAdapter(ArrayList<com.example.now1.home.listProvince.ProvinceModel> data, Context context) {
        super(context, R.layout.province_row, data);
        this.dataSet = data;
        this.mContext=context;

    }
    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        com.example.now1.home.listProvince.ProvinceModel dataModel=(com.example.now1.home.listProvince.ProvinceModel) object;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        com.example.now1.home.listProvince.ProvinceModel provinceModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.province_row, parent, false);
            viewHolder.txtProvince = (TextView) convertView.findViewById(R.id.textprovince);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtProvince.setText(provinceModel.getProvince());
        // Return the completed view to render on screen
        return convertView;
    }
}
