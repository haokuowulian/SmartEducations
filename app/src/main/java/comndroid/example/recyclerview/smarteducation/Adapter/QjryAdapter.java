package comndroid.example.recyclerview.smarteducation.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import comndroid.example.recyclerview.smarteducation.Beans.ApproveListBean;
import comndroid.example.recyclerview.smarteducation.R;

public class QjryAdapter extends RecyclerView.Adapter<QjryAdapter.ViewHolder>
{
    private List<ApproveListBean.data> list;
    private QjryClickListener qjryClickListener;

    public QjryAdapter(List<ApproveListBean.data> paramList)
    {
        this.list = paramList;
    }

    public void SetOnQjryClickListener(QjryClickListener paramQjryClickListener)
    {
        this.qjryClickListener = paramQjryClickListener;
    }

    public int getItemCount()
    {
        return this.list.size();
    }

    public void onBindViewHolder(@NonNull ViewHolder paramViewHolder, int paramInt)
    {
        ApproveListBean.data localdata = (ApproveListBean.data)this.list.get(paramInt);
        paramViewHolder.zw.setText(localdata.getDeptName());
        TextView localTextView = paramViewHolder.qjsj;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localdata.getStartDate());
        localStringBuilder.append("-");
        localStringBuilder.append(localdata.getEndDate());
        localTextView.setText(localStringBuilder.toString());
        paramViewHolder.qjsy.setText(localdata.getIncident());
        paramViewHolder.name.setText(localdata.getRealName());
        paramViewHolder.itemView.setTag(localdata);
        paramViewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (QjryAdapter.this.qjryClickListener != null)
                    QjryAdapter.this.qjryClickListener.run((ApproveListBean.data)paramView.getTag());
            }
        });
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
        return new ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.qjrylist, paramViewGroup, false));
    }

    public static abstract interface QjryClickListener
    {
        public abstract void run(ApproveListBean.data paramdata);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name;
        private TextView qjsj;
        private TextView qjsy;
        private TextView zw;

        public ViewHolder(View arg2)
        {
            super(arg2);
            this.zw = ((TextView)arg2.findViewById(R.id.zw));
            this.qjsj = ((TextView)arg2.findViewById(R.id.qjsj));
            this.qjsy = ((TextView)arg2.findViewById(R.id.qjsy));
            this.name = ((TextView)arg2.findViewById(R.id.name));
        }
    }
}