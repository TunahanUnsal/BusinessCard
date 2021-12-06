package app.web.firmcard.view.adapters;

//          Code with 🥂
//  ┌─────────────────────────────────┐
//  │     Created by Tuna UNSAL       │
//  │ ─────────────────────────────── │
//  │ tunahan.unsal@eczacibasi.com.tr │            
//  │ ─────────────────────────────── │
//  │        27.11.2021  15:04        │
//  └─────────────────────────────────┘


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import app.web.firmcard.R;
import app.web.firmcard.model.models.BusinessCardModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryListAdapter extends BaseAdapter {

    private int resourceLayout;
    private Context mContext;
    private List<BusinessCardModel> list;


    public HistoryListAdapter(Context context, int resource, List<BusinessCardModel> items) {
        this.resourceLayout = resource;
        this.mContext = context;
        this.list = items;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(mContext).inflate(R.layout.history_list_item,null);

        TextView textView_name = convertView.findViewById(R.id.textView_name);
        TextView textView_date = convertView.findViewById(R.id.textView_date);

        textView_name.setText(list.get(position).getName());
        textView_date.setText(list.get(position).getDate());

        return convertView;
    }

}
