package comndroid.example.recyclerview.smarteducation.Adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import comndroid.example.recyclerview.smarteducation.Beans.ApproveItemBean;
import comndroid.example.recyclerview.smarteducation.R;

public class ShlcAdapter extends RecyclerView.Adapter<ShlcAdapter.ViewHolder>
{
    private ApproveItemBean data;
    private List<ApproveItemBean> list;
    private int state;
private String    localObject2;
    public ShlcAdapter(List<ApproveItemBean> paramList)
    {
        this.list = paramList;
    }

    public int getItemCount()
    {
        int j = this.list.size();
        int i = 3;
        if (j > 0)
        {
            this.data = ((ApproveItemBean)this.list.get(0));
            this.state = ((ApproveItemBean)this.list.get(0)).getApprove().getAppStatus();
        }
        switch (this.state)
        {
            case 3:
            default:
                break;
            case 2:
                return 2;
            case 0:
                return 1;
            case 1:
            case 4:
            case 5:
        }
        return i;
    }

    public void onBindViewHolder(@NonNull ViewHolder paramViewHolder, int paramInt)
    {
        if (this.list.size() > 0)
        {
            paramViewHolder.view.setVisibility(View.VISIBLE);
            this.data = ((ApproveItemBean)this.list.get(0));
            this.state = this.data.getApprove().getAppStatus();
            String[] arg = this.data.getApprove().getCreateDate().split(":");
            String str=arg[0]+":"+arg[1];
            if(data.getApprove().getUpdateDate()!=null){
                String[] args = this.data.getApprove().getUpdateDate().split(":");
                 localObject2=args[0]+":"+args[1];
            }
            switch (this.state)
            {
                case 3:
                default:
                    return;
                case 5:
                    switch (paramInt)
                    {
                        default:
                            return;
                        case 2:
                            paramViewHolder.view.setVisibility(View.GONE);
                            paramViewHolder.content.setText("二级通过");
                            paramViewHolder.name.setText(this.data.getTwolevelName());
                            paramViewHolder.content.setTextColor(Color.rgb(140, 209, 130));
                            paramViewHolder.time.setText(str);
                            return;
                        case 1:
                            paramViewHolder.view.setVisibility(View.VISIBLE);
                            paramViewHolder.content.setText("一级通过");
                            paramViewHolder.name.setText(this.data.getOnelevelName());
                            paramViewHolder.content.setTextColor(Color.rgb(140, 209, 130));
                            paramViewHolder.time.setText((CharSequence)localObject2);
                            return;
                        case 0:
                    }
                    paramViewHolder.view.setVisibility(View.VISIBLE);
                    paramViewHolder.name.setText("我");
                    paramViewHolder.content.setText("发起申请");
                    paramViewHolder.content.setTextColor(Color.rgb(140, 209, 130));
                    paramViewHolder.time.setText((CharSequence)localObject2);
                    return;
                case 4:
                    switch (paramInt)
                    {
                        default:
                            return;
                        case 2:
                            paramViewHolder.view.setVisibility(View.GONE);
                            paramViewHolder.content.setText(this.data.getApprove().getRefusefor());
                            paramViewHolder.name.setText(this.data.getTwolevelName());
                            paramViewHolder.content.setTextColor(Color.rgb(246, 167, 125));
                            paramViewHolder.time.setText(str);
                            return;
                        case 1:
                            paramViewHolder.view.setVisibility(View.VISIBLE);
                            paramViewHolder.content.setText("一级通过");
                            paramViewHolder.name.setText(this.data.getOnelevelName());
                            paramViewHolder.content.setTextColor(Color.rgb(140, 209, 130));
                            paramViewHolder.time.setText((CharSequence)localObject2);
                            return;
                        case 0:
                    }
                    paramViewHolder.view.setVisibility(View.VISIBLE);
                    paramViewHolder.name.setText("我");
                    paramViewHolder.content.setText("发起申请");
                    paramViewHolder.content.setTextColor(Color.rgb(140, 209, 130));
                    paramViewHolder.time.setText((CharSequence)localObject2);
                    return;
                case 2:
                    switch (paramInt)
                    {
                        default:
                            return;
                        case 1:
                            paramViewHolder.view.setVisibility(View.GONE);
                            paramViewHolder.content.setText(this.data.getApprove().getRefusefor());
                            paramViewHolder.name.setText(this.data.getOnelevelName());
                            paramViewHolder.content.setTextColor(Color.rgb(246, 167, 125));
                            paramViewHolder.time.setText(str);
                            return;
                        case 0:
                    }
                    paramViewHolder.view.setVisibility(View.VISIBLE);
                    paramViewHolder.name.setText("我");
                    paramViewHolder.content.setText("发起申请");
                    paramViewHolder.content.setTextColor(Color.rgb(140, 209, 130));
                    paramViewHolder.time.setText((CharSequence)localObject2);
                    return;
                case 1:
                    switch (paramInt)
                    {
                        default:
                            return;
                        case 2:
                            paramViewHolder.content.setText("等待中");
                            paramViewHolder.view.setVisibility(View.GONE);
                            paramViewHolder.name.setText(this.data.getTwolevelName());
                            paramViewHolder.content.setTextColor(Color.rgb(247, 171, 138));
                            paramViewHolder.time.setText(str);
                            return;
                        case 1:
                            paramViewHolder.view.setVisibility(View.VISIBLE);
                            paramViewHolder.content.setText("一级通过");
                            paramViewHolder.name.setText(this.data.getOnelevelName());
                            paramViewHolder.content.setTextColor(Color.rgb(140, 209, 130));
                            paramViewHolder.time.setText((CharSequence)localObject2);
                            return;
                        case 0:
                    }
                    paramViewHolder.view.setVisibility(View.GONE);
                    paramViewHolder.name.setText("我");
                    paramViewHolder.content.setText("发起申请");
                    paramViewHolder.content.setTextColor(Color.rgb(140, 209, 130));
                    paramViewHolder.time.setText((CharSequence)localObject2);
                    return;
                case 0:
            }
            paramViewHolder.name.setText("我");
            paramViewHolder.content.setText("发起申请");
            paramViewHolder.content.setTextColor(Color.rgb(140, 209, 130));
            paramViewHolder.time.setText((CharSequence)localObject2);
            paramViewHolder.view.setVisibility(View.VISIBLE);
        }
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
        return new ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.qjlclist, paramViewGroup, false));
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView content;
        private TextView name;
        private TextView time;
        private View view;

        public ViewHolder(View arg2)
        {
            super(arg2);
            this.time = ((TextView)arg2.findViewById(R.id.time));
            this.name = ((TextView)arg2.findViewById(R.id.name));
            this.content = ((TextView)arg2.findViewById(R.id.content));
            this.view = arg2.findViewById(R.id.vis);
        }
    }
}
