package comndroid.example.recyclerview.smarteducation.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import comndroid.example.recyclerview.smarteducation.Adapter.BaoxiuAdapter;
import comndroid.example.recyclerview.smarteducation.Beans.AddRepairBean;
import comndroid.example.recyclerview.smarteducation.Beans.Baoxiubeans;
import comndroid.example.recyclerview.smarteducation.Beans.Baoxiubeans.data;
import comndroid.example.recyclerview.smarteducation.Beans.BuildingBean;
import comndroid.example.recyclerview.smarteducation.Beans.ResetVerfiyCodebean;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.activities.AddRepairActivity;
import comndroid.example.recyclerview.smarteducation.activities.BaoxiuActivity;
import comndroid.example.recyclerview.smarteducation.activities.BaoxiuActivity.MessageEvents;
import comndroid.example.recyclerview.smarteducation.activities.DaichulibaoxiuActivity2;
import comndroid.example.recyclerview.smarteducation.activities.RxBus;
import comndroid.example.recyclerview.smarteducation.presenter.GetBuildingListImp;
import comndroid.example.recyclerview.smarteducation.presenter.GetBulidingListPresenter;
import comndroid.example.recyclerview.smarteducation.presenter.MyRepairListImp;
import comndroid.example.recyclerview.smarteducation.presenter.MyRepairListPresenter;
import comndroid.example.recyclerview.smarteducation.ui.GetBulidingListView;
import comndroid.example.recyclerview.smarteducation.ui.MyRepairListPresenterView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DaichuliFragment2 extends Fragment
        implements MyRepairListPresenterView, GetBulidingListView, com.scwang.smartrefresh.layout.listener.OnRefreshListener, OnLoadMoreListener {
    private BaoxiuAdapter baoxiuAdapter;
    private BuildingBean buildingBean;
    private Button button;
    private Button buttons;
    private String distId;
    private GetBulidingListPresenter getBulidingListPresenter;
    private int index;
    private List<data> list;
    private MyRepairListPresenter myRepairListPresenterl;
    private int pageCount;
    private RecyclerView recyclerView;
    private String repairType;
    private String state;
    private int count;
    private int pagesize;
    private SmartRefreshLayout smartRefreshLayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private String userId = SPHelper.getInstance().getString("userId", "");

    public DaichuliFragment2()
    {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(SPHelper.getInstance().getInt("distId", 0));
        localStringBuilder.append("");
        this.distId = localStringBuilder.toString();
        this.state = "0";
        this.index = 0;
        this.repairType = "";
        this.list = new ArrayList();
    }

    @Subscribe(threadMode=ThreadMode.ASYNC)
    public void Event(BaoxiuActivity.MessageEvents paramMessageEvents)
    {
        this.index = 0;
        this.list = new ArrayList();
        this.repairType = paramMessageEvents.getMessage();
        MyRepairListPresenter localMyRepairListPresenter = this.myRepairListPresenterl;
        String str1 = this.userId;
        String str2 = this.token;
        String str3 = this.distId;
        String str4 = this.state;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        localMyRepairListPresenter.huoqu(str1, str2, str3, str4, localStringBuilder.toString(), "6", this.repairType, "1");
    }
    public void Event(AddRepairBean paramAddRepairBean)
    {
        this.index = 0;
        MyRepairListPresenter localMyRepairListPresenter = this.myRepairListPresenterl;
        String str1 = this.userId;
        String str2 = this.token;
        String str3 = this.distId;
        String str4 = this.state;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        localMyRepairListPresenter.huoqu(str1, str2, str3, str4, localStringBuilder.toString(), "6", this.repairType, "1");
    }

    public void getBaoxiubeans(Baoxiubeans paramBaoxiubeans)
    {
        count=paramBaoxiubeans.getTotal();
        pagesize=6;
        smartRefreshLayout.finishLoadMore();
        smartRefreshLayout.finishRefresh();
        if (paramBaoxiubeans.isSuccess())
        {
            if (paramBaoxiubeans.getTotal() > 0)
            {
                smartRefreshLayout.setVisibility(View.VISIBLE);

                if(index==0){
                  list.clear();
                  list.addAll(paramBaoxiubeans.getData());

              }else {
                  list.addAll(paramBaoxiubeans.getData());

              }
                baoxiuAdapter.notifyDataSetChanged();

            }
            else {
                this.list.clear();
                this.smartRefreshLayout.setVisibility(View.GONE);
            }
            return;
        }
    }

    public void getBuildingListBean(BuildingBean paramBuildingBean)
    {
        this.buildingBean = paramBuildingBean;
    }

    public void getError(Throwable paramThrowable, String paramString)
    {
        ToastUtils.showShort("服务器开了小差请稍后重试");
    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
    }

    public void onCreate(@Nullable Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        EventBus.getDefault().register(this);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
    {
        this.myRepairListPresenterl = new MyRepairListImp(this);
        View view = paramLayoutInflater.inflate(R.layout.repairlists, null);
        this.smartRefreshLayout = view.findViewById(R.id.sr);
        this.recyclerView = ((RecyclerView)view.findViewById(R.id.recylerview));
        this.button = ((Button)view.findViewById(R.id.button));
        this.buttons = ((Button)view.findViewById(R.id.buttonss));
        this.getBulidingListPresenter = new GetBuildingListImp(this);
        smartRefreshLayout.setOnRefreshListener(this);
        this.baoxiuAdapter = new BaoxiuAdapter(this.list);
//        RxBus.getDefault().toObservable(ResetVerfiyCodebean.class).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DaichuliFragment2..Lambda.0(this));
//        RxBus.getDefault().toObservable(AddRepairBean.class).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
        this.button.setOnClickListener(new OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (DaichuliFragment2.this.buildingBean != null)
                {
                    Intent intent = new Intent(DaichuliFragment2.this.getContext(), AddRepairActivity.class);
                    intent.putExtra("buildingBean", DaichuliFragment2.this.buildingBean);
                    DaichuliFragment2.this.startActivity(intent);
                    return;
                }
                DaichuliFragment2.this.getBulidingListPresenter.huoqu(DaichuliFragment2.this.userId, DaichuliFragment2.this.token, "20");
            }
        });
        this.buttons.setOnClickListener(new OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (DaichuliFragment2.this.buildingBean != null)
                {
                    Intent intent = new Intent(DaichuliFragment2.this.getContext(), AddRepairActivity.class);
                    intent.putExtra("buildingBean",buildingBean);
                    DaichuliFragment2.this.startActivity(intent);
                    return;
                }
                DaichuliFragment2.this.getBulidingListPresenter.huoqu(DaichuliFragment2.this.userId, DaichuliFragment2.this.token, "20");
            }
        });
        this.baoxiuAdapter.SetonBaoxiuClickListener(new BaoxiuAdapter.BaoxiuClickListener()
        {
            public void run(Baoxiubeans.data paramdata)
            {
                Intent localIntent = new Intent(DaichuliFragment2.this.getContext(), DaichulibaoxiuActivity2.class);
                localIntent.putExtra("Baoxiubeans", paramdata);
                DaichuliFragment2.this.startActivity(localIntent);
            }
        });
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.setAdapter(this.baoxiuAdapter);
        this.getBulidingListPresenter.huoqu(this.userId, this.token, "20");
        MyRepairListPresenter localMyRepairListPresenter = DaichuliFragment2.this.myRepairListPresenterl;
        String str1 = DaichuliFragment2.this.userId;
        String str2 = DaichuliFragment2.this.token;
        String str3 = DaichuliFragment2.this.distId;
        String str4 = DaichuliFragment2.this.state;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(DaichuliFragment2.this.index);
        localStringBuilder.append("");
        localMyRepairListPresenter.huoqu(str1, str2, str3, str4, localStringBuilder.toString(), "6", DaichuliFragment2.this.repairType, "1");
        smartRefreshLayout.setOnLoadMoreListener(this);
        return view;
    }

    public void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    public void onResume()
    {
        super.onResume();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

        this.index = 0;
        MyRepairListPresenter localMyRepairListPresenter = this.myRepairListPresenterl;
        String str1 = this.userId;
        String str2 = this.token;
        String str3 = this.distId;
        String str4 = this.state;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        localMyRepairListPresenter.huoqu(str1, str2, str3, str4, localStringBuilder.toString(), "6", this.repairType, "1");
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        int i=count/pagesize;
        if(count%pagesize==0){

        }else {

            i=i+1;
        }
        if(index<i-1){
            index++;
            MyRepairListPresenter localMyRepairListPresenter = this.myRepairListPresenterl;
            String str1 = this.userId;
            String str2 = this.token;
            String str3 = this.distId;
            String str4 = this.state;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.index);
            localStringBuilder.append("");
            localMyRepairListPresenter.huoqu(str1, str2, str3, str4, localStringBuilder.toString(), "6", this.repairType, "1");
        }

    }
}