package com.hideorshowdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hideorshowdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO< RecyclerView 的适配器>
 *
 * @author: 小嵩
 * @date: 2017/1/9 15:20
 * @version: V1.0
 */

public class RecyclerAdapter extends BaseRecyclerAdapter<String>{
    private List<String> mDataList;

    public RecyclerAdapter(ArrayList<String> Data) {
        super(Data);
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new MyHolder(layout);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, String data) {
        if(viewHolder instanceof MyHolder) {
            ((MyHolder) viewHolder).text.setText(data);
        }
    }

    class MyHolder extends BaseRecyclerAdapter.Holder {
        TextView text;
        public MyHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }

}
