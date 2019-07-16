package comndroid.example.recyclerview.smarteducation.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import comndroid.example.recyclerview.smarteducation.Beans.Baoxiubeans;
import comndroid.example.recyclerview.smarteducation.R;

public class BaoxiuAdapter extends RecyclerView.Adapter<BaoxiuAdapter.ViewHolder>
{
    private BaoxiuClickListener baoxiuClickListener;
    private List<Baoxiubeans.data> list;

    public BaoxiuAdapter(List<Baoxiubeans.data> paramList)
    {
        this.list = paramList;
    }

    public void SetonBaoxiuClickListener(BaoxiuClickListener paramBaoxiuClickListener)
    {
        this.baoxiuClickListener = paramBaoxiuClickListener;
    }

    public int getItemCount()
    {
        return this.list.size();
    }

    public void onBindViewHolder(@NonNull ViewHolder paramViewHolder, int paramInt)
    {
        Baoxiubeans.data localdata = (Baoxiubeans.data)this.list.get(paramInt);
        paramViewHolder.bxyy.setText(localdata.getReportContent());
        paramViewHolder.bxsj.setText(localdata.getReportTime());
        paramViewHolder.dzlx.setText(localdata.getAddress());
        switch (localdata.getState())
        {
            default:
                break;
            case 1:
                paramViewHolder.state.setText("已处理");
                break;
            case 0:
                paramViewHolder.state.setText("待处理");
        }
        paramViewHolder.itemView.setTag(localdata);
        paramViewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (BaoxiuAdapter.this.baoxiuClickListener != null)
                    BaoxiuAdapter.this.baoxiuClickListener.run((Baoxiubeans.data)paramView.getTag());
            }
        });
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
        return new ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.baoxiulist, paramViewGroup, false));
    }

    public static abstract interface BaoxiuClickListener
    {
        public abstract void run(Baoxiubeans.data paramdata);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView bxsj;
        private TextView bxyy;
        private TextView dzlx;
        private TextView state;

        public ViewHolder(View arg2)
        {
            super(arg2);
            this.bxsj = ((TextView)arg2.findViewById(R.id.bxsj));
            this.dzlx = ((TextView)arg2.findViewById(R.id.dzlx));
            this.bxyy = ((TextView)arg2.findViewById(R.id.bxyy));
            this.state = ((TextView)arg2.findViewById(R.id.state));
        }
    }
}