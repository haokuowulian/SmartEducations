package comndroid.example.recyclerview.smarteducation.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import comndroid.example.recyclerview.smarteducation.Beans.FileitemBean;
import comndroid.example.recyclerview.smarteducation.Beans.FileitemBean.fileList;
import comndroid.example.recyclerview.smarteducation.R;

public class XiazaiAdapter extends RecyclerView.Adapter<XiazaiAdapter.ViewHolder>
{
    private List<FileitemBean.fileList> list;

    public XiazaiAdapter(List<FileitemBean.fileList> paramList)
    {
        this.list = paramList;
    }

    public int getItemCount()
    {
        return this.list.size();
    }

    public void onBindViewHolder(@NonNull ViewHolder paramViewHolder, int paramInt)
    {
        FileitemBean.fileList localfileList = (FileitemBean.fileList)this.list.get(paramInt);
        if (localfileList != null)
            paramViewHolder.title.setText(localfileList.getTitle());
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
        return new ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.xiazailist, paramViewGroup, false));
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title;

        public ViewHolder(View arg2)
        {
            super(arg2);
            this.title = ((TextView)arg2.findViewById(R.id.filetitle));
        }
    }
}