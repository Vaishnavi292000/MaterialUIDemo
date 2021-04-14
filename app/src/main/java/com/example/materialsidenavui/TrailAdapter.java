package com.example.materialsidenavui;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TrailAdapter extends RecyclerView.Adapter<TrailAdapter.ViewHolder> {

    private static final int VIEW_TYPE_TOP = 0;
    private static final int VIEW_TYPE_MIDDLE = 1;
    private static final int VIEW_TYPE_BOTTOM = 2;
    private List<ItemModel> mItems;

    public TrailAdapter(List<ItemModel> itemModelList) {
        mItems=itemModelList;
    }


    @Override
    public void onBindViewHolder(final TrailAdapter.ViewHolder holder, final int position) {
        ItemModel item = mItems.get(position);
        // Populate views...
        holder.mItemSubtitle.setText(mItems.get(position).getItem_subtitle());
        holder.mItemTitle.setText(mItems.get(position).getItem_title());
        switch(holder.getItemViewType()) {
            case VIEW_TYPE_TOP:
                // The top of the line has to be rounded
                holder.mItemLine.setBackgroundResource(R.drawable.line_bg_top);
                break;
            case VIEW_TYPE_MIDDLE:
                // Only the color could be enough
                // but a drawable can be used to make the cap rounded also here
                holder.mItemLine.setBackgroundResource(R.drawable.line_bg_middle);
                break;
            case VIEW_TYPE_BOTTOM:
                holder.mItemLine.setBackgroundResource(R.drawable.line_bg_bottom);
                break;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trialtimeline, parent, false);

        return new ViewHolder(itemView);    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_TOP;}
        else if (position == mItems.size() - 1) {
                return VIEW_TYPE_BOTTOM;
            }
            return VIEW_TYPE_MIDDLE;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mItemTitle;
        TextView mItemSubtitle;
        FrameLayout mItemLine;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemTitle = (TextView) itemView.findViewById(R.id.item_title);
            mItemSubtitle = (TextView) itemView.findViewById(R.id.item_subtitle);
            mItemLine = (FrameLayout) itemView.findViewById(R.id.item_line);
        }
    }

}
