package comndroid.example.recyclerview.smarteducation.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import comndroid.example.recyclerview.smarteducation.Adapter.BaoxiuAdapter;
import comndroid.example.recyclerview.smarteducation.Adapter.BaoxiuAdapter.BaoxiuClickListener;
import comndroid.example.recyclerview.smarteducation.Beans.Baoxiubeans;
import comndroid.example.recyclerview.smarteducation.Beans.Baoxiubeans.data;
import comndroid.example.recyclerview.smarteducation.Beans.ResetVerfiyCodebean;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.activities.BaoxiuActivity;
import comndroid.example.recyclerview.smarteducation.activities.BaoxiuActivity.MessageEvents;
import comndroid.example.recyclerview.smarteducation.activities.DaichulibaoxiuActivity;
import comndroid.example.recyclerview.smarteducation.activities.RxBus;
import comndroid.example.recyclerview.smarteducation.presenter.MyRepairListImp;
import comndroid.example.recyclerview.smarteducation.presenter.MyRepairListPresenter;
import comndroid.example.recyclerview.smarteducation.ui.MyRepairListPresenterView;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class yiwanchengFragment extends Fragment
        implements MyRepairListPresenterView, OnRefreshListener, OnLoadMoreListener {
    private BaoxiuAdapter baoxiuAdapter;
    private String distId;
    private int index;
    private List<Baoxiubeans.data> list;
    private MyRepairListPresenter myRepairListPresenterl;
    private int pageCount;
    private RecyclerView recyclerView;
    private String repairType;
    private String sign;
    private String state;
    private SmartRefreshLayout smartRefreshLayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private String userId = SPHelper.getInstance().getString("userId", "");
     private int count;
     private int pagesize=6;
    public yiwanchengFragment()
    {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(SPHelper.getInstance().getInt("distId", 0));
        localStringBuilder.append("");
        this.distId = localStringBuilder.toString();
        this.state = "1";
        this.index = 0;
        this.repairType = "";
        this.sign = "1";
        this.list = new ArrayList();
    }

    @Subscribe(threadMode=ThreadMode.ASYNC)
    public void Event(BaoxiuActivity.MessageEvents paramMessageEvents)
    {
        this.index = 0;
        this.repairType = paramMessageEvents.getMessage();
        MyRepairListPresenter localMyRepairListPresenter = yiwanchengFragment.this.myRepairListPresenterl;
        String str1 = yiwanchengFragment.this.userId;
        String str2 = yiwanchengFragment.this.token;
        String str3 = yiwanchengFragment.this.distId;
        String str4 = yiwanchengFragment.this.state;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(yiwanchengFragment.this.index);
        localStringBuilder.append("");
        localMyRepairListPresenter.huoqu(str1, str2, str3, str4, localStringBuilder.toString(), "6", yiwanchengFragment.this.repairType, yiwanchengFragment.this.sign);
    }

    public void getBaoxiubeans(Baoxiubeans paramBaoxiubeans) {
        count = paramBaoxiubeans.getTotal();
        pagesize = 6;
        smartRefreshLayout.finishLoadMore();
        smartRefreshLayout.finishRefresh();
        if (paramBaoxiubeans.isSuccess()) {
            if (paramBaoxiubeans.getTotal() > 0) {
                smartRefreshLayout.setVisibility(View.VISIBLE);
                if (index == 0) {
                    list.clear();
                    list.addAll(paramBaoxiubeans.getData());

                } else {
                    list.addAll(paramBaoxiubeans.getData());

                }
                baoxiuAdapter.notifyDataSetChanged();

            } else {
                this.list.clear();
                this.smartRefreshLayout.setVisibility(View.GONE);
            }

        }
    }
    public void getError(Throwable paramThrowable, String paramString)
    {
        smartRefreshLayout.finishRefresh();
        smartRefreshLayout.finishLoadMore();
        ToastUtils.showShort("服务器开了小差请稍后重试");
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
        View view = paramLayoutInflater.inflate(R.layout.repairlist, null);
        this.smartRefreshLayout = view.findViewById(R.id.sr);
        this.recyclerView = ((RecyclerView)view.findViewById(R.id.recylerview));
        this.smartRefreshLayout.setOnRefreshListener(this);
        this.baoxiuAdapter = new BaoxiuAdapter(this.list);
//        RxBus.getDefault().toObservable(ResetVerfiyCodebean.class).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new yiwanchengFragment..Lambda.0(this));
        this.baoxiuAdapter = new BaoxiuAdapter(this.list);
        this.baoxiuAdapter.SetonBaoxiuClickListener(new BaoxiuAdapter.BaoxiuClickListener()
        {
            public void run(Baoxiubeans.data paramdata)
            {
                Intent localIntent = new Intent(yiwanchengFragment.this.getContext(), DaichulibaoxiuActivity.class);
                localIntent.putExtra("Baoxiubeans", paramdata);
                yiwanchengFragment.this.startActivity(localIntent);
            }
        });
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.setAdapter(this.baoxiuAdapter);
        smartRefreshLayout.setOnLoadMoreListener(this);
        MyRepairListPresenter localMyRepairListPresenter = this.myRepairListPresenterl;
        String str1 = this.userId;
        String str2 = this.token;
        String str3 = this.distId;
        String str4 = this.state;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        localMyRepairListPresenter.huoqu(str1, str2, str3, str4, localStringBuilder.toString(), "6", this.repairType, this.sign);

        return view;
    }

    public void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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
        localMyRepairListPresenter.huoqu(str1, str2, str3, str4, localStringBuilder.toString(), "6", this.repairType, this.sign);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        int i=count/pagesize;
        if(count%pagesize==0){

        }else {

            i=i+1;
        }
        if(index<i-1) {
            index++;
            MyRepairListPresenter localMyRepairListPresenter = myRepairListPresenterl;
            String str1 = userId;
            String str2 = token;
            String str3 = distId;
            String str4 = state;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(index);
            localStringBuilder.append("");
            localMyRepairListPresenter.huoqu(str1, str2, str3, str4, localStringBuilder.toString(), "6", repairType, sign);
        }else {
            smartRefreshLayout.finishRefresh();
            smartRefreshLayout.finishLoadMore();
        }
    }
}
