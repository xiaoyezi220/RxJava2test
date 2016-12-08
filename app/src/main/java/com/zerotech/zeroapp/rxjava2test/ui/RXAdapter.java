package com.zerotech.zeroapp.rxjava2test.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zerotech.zeroapp.rxjava2test.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/8.
 */
public class RXAdapter extends RecyclerView.Adapter<RXAdapter.RXViewHolder> {

    private Context context;
    private ArrayList<String> dataList = new ArrayList<>();

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public RXAdapter(Context context,ArrayList<String> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public RXViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RXViewHolder(LayoutInflater.from(
                context).inflate(R.layout.rx_recycleview_item, parent,
                false));
    }

    @Override
    public void onBindViewHolder(final RXViewHolder holder, int position) {
        holder.title.setText(dataList.get(position));
        if (mOnItemClickLitener != null) {
            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
        }

        }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class RXViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public RXViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.rx_title);
        }
    }
}
