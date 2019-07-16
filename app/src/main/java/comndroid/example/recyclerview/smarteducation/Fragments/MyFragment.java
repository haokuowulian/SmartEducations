package comndroid.example.recyclerview.smarteducation.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.activities.BaoxiuActivity;
import comndroid.example.recyclerview.smarteducation.activities.MyapproveListActivity;
import comndroid.example.recyclerview.smarteducation.activities.WodeshezhiActivity;
import comndroid.example.recyclerview.smarteducation.activities.WupinbaoxiuActivity;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;


public class MyFragment extends Fragment
        implements View.OnClickListener
{
    private TextView name;
    private String realname = SPHelper.getInstance().getString("realName", "");
    private int usertpye = SPHelper.getInstance().getInt("userType", 1);
    private LinearLayout wdbx;
    private LinearLayout wdqj;
    private LinearLayout wdsz;
    private String zhiwu = SPHelper.getInstance().getString("deptName", "");
    private TextView zw;
 private Titlelayout title;
    public void onClick(View paramView)
    {
        int i = paramView.getId();
        if (i != 2131230878)
        {
            switch (i)
            {
                default:
                    return;
                case R.id.wdsz:
                    startActivity(new Intent(getContext(), WodeshezhiActivity.class));
                    return;
                case R.id.wdqj:
                    startActivity(new Intent(getContext(), MyapproveListActivity.class));
                    return;
                case R.id.wdbx:

                    switch (this.usertpye)
                    {
                        default:
                            return;
                        case 11:
                            startActivity(new Intent(getContext(), BaoxiuActivity.class));

                            break;
                        case 10:
                            startActivity(new Intent(getContext(), WupinbaoxiuActivity.class));
                            break;
                    }
                   break;

            }

        }
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
    {
        View view = paramLayoutInflater.inflate(R.layout.myfragment, null);
        this.wdbx = view.findViewById(R.id.wdbx);
        this.wdqj = view.findViewById(R.id.wdqj);
        this.wdsz = view.findViewById(R.id.wdsz);
        this.name = view.findViewById(R.id.name);
        title=view.findViewById(R.id.title);
        this.zw = view.findViewById(R.id.zw);
        this.zw.setText(this.zhiwu);
        this.name.setText(this.realname);
        this.wdbx.setOnClickListener(this);
        this.wdqj.setOnClickListener(this);
        title.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener() {
            @Override
            public void leftClick() {

            }

            @Override
            public void rightClick() {

            }
        });
        this.wdsz.setOnClickListener(this);
        return view;
    }
}