package com.idemobi.customlistmeapp;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jerome Demyttenaere on 30/05/2017.
 */
class PeopleAdapter extends ArrayAdapter<People> {

    PeopleAdapter(Context context, List<People> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        RowViewHolder viewHolder = (RowViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new RowViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }

        People tName = getItem(position);
        viewHolder.pseudo.setText(tName.getPseudo());
        viewHolder.text.setText(tName.getText());
        viewHolder.avatar.setImageDrawable(new ColorDrawable(tName.getColor()));

        return convertView;
    }

    private class RowViewHolder {
        TextView pseudo;
        TextView text;
        ImageView avatar;
    }
}
