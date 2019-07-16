package comndroid.example.recyclerview.smarteducation.Adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import comndroid.example.recyclerview.smarteducation.Beans.MyapproveListBean;
import comndroid.example.recyclerview.smarteducation.Beans.MyapproveListBean.data;
import comndroid.example.recyclerview.smarteducation.R;

public class WdqjAdapter extends RecyclerView.Adapter<WdqjAdapter.ViewHolder> {
    private List<MyapproveListBean.data> list;
    private WdqjClickListener wdqjClickListener;

    public WdqjAdapter(List<MyapproveListBean.data> paramList)
    {
        this.list = paramList;
    }

    public void SetOnWdqjClickListener(WdqjClickListener paramWdqjClickListener)
    {
        this.wdqjClickListener = paramWdqjClickListener;
    }

    public int getItemCount()
    {
        return this.list.size();
    }

    public void onBindViewHolder(@NonNull ViewHolder paramViewHolder, int paramInt)
    {
        MyapproveListBean.data localdata = (MyapproveListBean.data)this.list.get(paramInt);
        paramViewHolder.startTime.setText(localdata.getStartDate());
        paramViewHolder.endTime.setText(localdata.getEndDate());
        paramViewHolder.name.setText(localdata.getRealName());
        String[] localObject = localdata.getCreateDate().split(" ");
        String s1=localObject[0];
        paramViewHolder.clsj.setText(s1);
        switch (localdata.getAppStatus())
        {
            case 3:
            default:
                break;
            case 5:
                paramViewHolder.state.setText("审批通过");
                paramViewHolder.state.setTextColor(Color.rgb(96, 187, 254));
                break;
            case 4:
                paramViewHolder.state.setText("二级审批未通过");
                paramViewHolder.state.setTextColor(Color.rgb(242, 124, 69));
                break;
            case 2:
                paramViewHolder.state.setText("一级审批未通过");
                paramViewHolder.state.setTextColor(Color.rgb(0, 255, 153));
                break;
            case 1:
                paramViewHolder.state.setText("二级审批未处理");
                paramViewHolder.state.setTextColor(Color.rgb(242, 124, 69));
                break;
            case 0:
                paramViewHolder.state.setText("请假未处理");
                paramViewHolder.state.setTextColor(Color.rgb(0, 255, 153));
        }
        paramViewHolder.itemView.setTag(localdata);
        paramViewHolder.itemView.setOnClickListener(new OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (WdqjAdapter.this.wdqjClickListener != null)
                    WdqjAdapter.this.wdqjClickListener.run((MyapproveListBean.data)paramView.getTag());
            }
        });
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
        return new ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.myapprovelist, paramViewGroup, false));
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView clsj;
        private TextView endTime;
        private TextView name;
        private TextView startTime;
        private TextView state;

        public ViewHolder(View arg2)
        {
            super(arg2);
            this.clsj = ((TextView)arg2.findViewById(R.id.clsj));
            this.state = ((TextView)arg2.findViewById(R.id.state));
            this.endTime = ((TextView)arg2.findViewById(R.id.endTime));
            this.startTime = ((TextView)arg2.findViewById(R.id.startTime));
            this.name = ((TextView)arg2.findViewById(R.id.name));
        }
    }

    public static abstract interface WdqjClickListener
    {
        public abstract void run(MyapproveListBean.data paramdata);
    }
}