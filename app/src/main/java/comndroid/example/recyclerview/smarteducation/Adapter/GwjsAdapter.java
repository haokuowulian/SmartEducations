package comndroid.example.recyclerview.smarteducation.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import comndroid.example.recyclerview.smarteducation.Beans.FileListBean;
import comndroid.example.recyclerview.smarteducation.R;

//公文接收列表的子项
public class GwjsAdapter extends RecyclerView.Adapter<GwjsAdapter.ViewHolder>
{
    private GwjsClickListener gwjsClickListener;
    private List<FileListBean.data> list;

    public GwjsAdapter(List<FileListBean.data> paramList)
    {
        this.list = paramList;
    }

    public void SetOnGwjsClickListener(GwjsClickListener paramGwjsClickListener)
    {
        this.gwjsClickListener = paramGwjsClickListener;
    }

    public int getItemCount()
    {
        return this.list.size();
    }

    public void onBindViewHolder(@NonNull ViewHolder paramViewHolder, int paramInt)
    {
        FileListBean.data localdata = (FileListBean.data)this.list.get(paramInt);
        paramViewHolder.creater.setText(localdata.getCreator());
        paramViewHolder.title.setText(localdata.getTitle());
        paramViewHolder.itemView.setTag(localdata);
        paramViewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (GwjsAdapter.this.gwjsClickListener != null)
                    GwjsAdapter.this.gwjsClickListener.run((FileListBean.data)paramView.getTag());
            }
        });
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
        return new ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.xiazailist, paramViewGroup, false));
    }

    public static abstract interface GwjsClickListener
    {
        public abstract void run(FileListBean.data paramdata);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView creater;
        private TextView title;

        public ViewHolder(View arg2)
        {
            super(arg2);
            this.title = ((TextView)arg2.findViewById(R.id.filetitle));
            this.creater = ((TextView)arg2.findViewById(R.id.creater));
        }
    }
}