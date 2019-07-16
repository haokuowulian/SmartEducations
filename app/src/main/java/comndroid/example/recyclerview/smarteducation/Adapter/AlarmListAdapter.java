package comndroid.example.recyclerview.smarteducation.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import comndroid.example.recyclerview.smarteducation.Beans.BaojingBean;
import comndroid.example.recyclerview.smarteducation.R;

public class AlarmListAdapter extends RecyclerView.Adapter<AlarmListAdapter.ViewHolder>
{
    private AlarmClickListener alarmClickListener;
    private List<BaojingBean.data> list;

    public AlarmListAdapter(List<BaojingBean.data> paramList)
    {
        this.list = paramList;
    }

    public void SetOnAlarmClickListener(AlarmClickListener paramAlarmClickListener)
    {
        this.alarmClickListener = paramAlarmClickListener;
    }

    public int getItemCount()
    {
        return this.list.size();
    }

    public void onBindViewHolder(@NonNull ViewHolder paramViewHolder, int paramInt)
    {
        BaojingBean.data localdata = (BaojingBean.data)this.list.get(paramInt);
        paramViewHolder.address.setText(localdata.getAddress());
        paramViewHolder.title.setText(localdata.getAlarmType());
        paramViewHolder.time.setText(localdata.getAlarmTime());
        switch (localdata.getIsConfirmed())
        {
            default:
                break;
            case 1:
                paramViewHolder.state_image.setImageResource(R.mipmap.bq1);
                paramViewHolder.state_text.setText("已处理");
                break;
            case 0:
                paramViewHolder.state_text.setText("待处理");
                paramViewHolder.state_image.setImageResource(R.mipmap.bq2);
        }
        paramViewHolder.itemView.setTag(localdata);
        paramViewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (AlarmListAdapter.this.alarmClickListener != null)
                    AlarmListAdapter.this.alarmClickListener.run((BaojingBean.data)paramView.getTag());
            }
        });
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
        return new ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.alarmlist, paramViewGroup, false));
    }

    public static abstract interface AlarmClickListener
    {
        public abstract void run(BaojingBean.data paramdata);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView address;
        private ImageView state_image;
        private TextView state_text;
        private TextView time;
        private TextView title;


        public ViewHolder(View arg2)
        {
            super(arg2);
            this.time = ((TextView)arg2.findViewById(R.id.time));
            this.state_image = ((ImageView)arg2.findViewById(R.id.state_image));
            this.state_text = ((TextView)arg2.findViewById(R.id.state_text));
            this.title = ((TextView)arg2.findViewById(R.id.title));
            this.address = ((TextView)arg2.findViewById(R.id.address));
        }
    }
}