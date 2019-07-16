package comndroid.example.recyclerview.smarteducation.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import comndroid.example.recyclerview.smarteducation.Beans.XiajiBean;
import comndroid.example.recyclerview.smarteducation.R;

import static android.media.CamcorderProfile.get;

public class JsrAdapter extends RecyclerView.Adapter<JsrAdapter.ViewHolder>
{
    private JsrClickListener jsrClickListener;
    private  List<XiajiBean.userList> list;
    private  List<XiajiBean.userList> lists=new ArrayList<>();

    public List<XiajiBean.userList> getLists() {
        return lists;
    }

    public void setLists(List<XiajiBean.userList> lists) {
        this.lists = lists;
    }

    public JsrAdapter(List<XiajiBean.userList> list)
    {
        this.list = list;
    }

    public void SetOnJsrClickListener(JsrClickListener paramJsrClickListener)
    {
        this.jsrClickListener = paramJsrClickListener;
    }

    public int getItemCount()
    {
        return this.list.size();
    }

    public void onBindViewHolder(@NonNull final ViewHolder paramViewHolder, final int paramInt)
    {
        final XiajiBean.userList userList= list.get(paramInt);
            paramViewHolder.name.setText(userList.getRealName());
            paramViewHolder.checkBox.setChecked(userList.isChecked());
        paramViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userList.isChecked()) {
                    userList.setChecked(false);
                    paramViewHolder.checkBox.setChecked(userList.isChecked());
                    if(lists.size()>0){
                        if(lists.contains(userList)){
                            lists.remove(userList);
                        }
                    }

                }else {
                    userList.setChecked(true);
                    if(lists.size()>0){
                     if( lists.contains(userList)) {

                     }else {
                         lists.add(userList);
                     }
                    }else {
                        lists.add(userList);
                    }

                    paramViewHolder.checkBox.setChecked(userList.isChecked());
                }
                if (JsrAdapter.this.jsrClickListener != null)
                    JsrAdapter.this.jsrClickListener.run(userList);
            }
        });
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
        return new ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.jsrlist, paramViewGroup, false));
    }

    public static abstract interface JsrClickListener
    {
        public abstract void run(XiajiBean.userList userList);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private CheckBox checkBox;
        private TextView name;

        public ViewHolder(View arg2)
        {
            super(arg2);
            this.name = ((TextView)arg2.findViewById(R.id.name));
            this.checkBox = ((CheckBox)arg2.findViewById(R.id.checkbox));
        }
    }
}