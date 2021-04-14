package com.example.materialsidenavui.menu;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialsidenavui.R;
import com.example.materialsidenavui.model.DashboardMenu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yarolegovich on 25.03.2017.
 */

@SuppressWarnings({"rawtypes", "ConstantConditions"})
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {

    private List<DashboardMenu> items;
    private Context context;
    private int lastCheckedPosition = 0;
    private OnItemSelectedListener listener;

    public DrawerAdapter(List<DashboardMenu> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        context = parent.getContext();
        View v = inflater.inflate(R.layout.item_option, parent, false);
        return new ViewHolder(v);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DashboardMenu dashboardMenu = items.get(position);
        holder.title.setText(dashboardMenu.getMenuName());
        holder.icon.setImageResource(dashboardMenu.getIcon());
        System.out.println(dashboardMenu.getMenuName() + " menu name");
        holder.title.setTextColor(dashboardMenu.isChecked() ? color(R.color.colorAccent) : color(R.color.textColorPrimary));
        holder.icon.setColorFilter(dashboardMenu.isChecked() ? color(R.color.colorAccent) : color(R.color.textColorPrimary));
        holder.itemsll.setBackgroundResource(dashboardMenu.isChecked() ? R.drawable.itemselect_border : R.drawable.itemnotselect_border);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setSelected(int position) {

        DashboardMenu menuOld = items.get(lastCheckedPosition);
        menuOld.setChecked(false);
        notifyItemChanged(lastCheckedPosition);

        lastCheckedPosition = position;
        DashboardMenu menuNew = items.get(position);
        menuNew.setChecked(true);
        notifyItemChanged(position);


        if (listener != null) {
            listener.onItemSelected(position);
        }
    }

    public void setListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView icon;
        private TextView title;
        LinearLayout itemsll;


        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            title = (TextView) itemView.findViewById(R.id.title);
            itemsll = itemView.findViewById(R.id.itemsll);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            setSelected(getAdapterPosition());
        }
    }

    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(context, res);
    }
}
