package comndroid.example.recyclerview.smarteducation.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import comndroid.example.recyclerview.smarteducation.R;


public class CityselectAdapter extends RecyclerView.Adapter<CityselectAdapter.ViewHolder>
        implements View.OnClickListener
{
    private List<Map<String, String>> list;
    private OnItemClickListeners mItemClickListener;

    public CityselectAdapter(List<Map<String, String>> paramList)
    {
        this.list = paramList;
    }

    public int getItemCount()
    {
        return this.list.size();
    }

    public void onBindViewHolder(@NonNull ViewHolder paramViewHolder, int paramInt)
    {
        HashMap localHashMap = (HashMap)this.list.get(paramInt);
        Iterator localIterator = localHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
            String str = (String)((Map.Entry)localIterator.next()).getKey();
            paramViewHolder.textView.setText(str);
        }
        paramViewHolder.itemView.setTag(localHashMap);
    }

    public void onClick(View paramView)
    {
        if (this.mItemClickListener != null)
            this.mItemClickListener.onItemClick((Map)paramView.getTag());
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
        paramViewGroup = (ViewGroup) LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.select_city, paramViewGroup, false);
        ViewHolder localViewHolder = new ViewHolder(paramViewGroup);
        paramViewGroup.setOnClickListener(this);
        return localViewHolder;
    }

    public void setmItemClickListener(OnItemClickListeners paramOnItemClickListeners)
    {
        this.mItemClickListener = paramOnItemClickListeners;
    }

    public static abstract interface OnItemClickListeners
    {
        public abstract void onItemClick(Map<String, String> paramMap);
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textView;

        public ViewHolder(View paramView)
        {
            super(paramView);
            this.textView = ((TextView)paramView.findViewById(R.id.select_citys));
        }
    }
}