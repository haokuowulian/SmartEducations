package comndroid.example.recyclerview.smarteducation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.ProgressBar;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Adapter.AlarmListAdapter;
import comndroid.example.recyclerview.smarteducation.Adapter.AlarmListAdapter.AlarmClickListener;
import comndroid.example.recyclerview.smarteducation.Beans.AlarmHandleBean;
import comndroid.example.recyclerview.smarteducation.Beans.BaojingBean;
import comndroid.example.recyclerview.smarteducation.Beans.BaojingBean.data;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout.titlelayoutClickListener;
import comndroid.example.recyclerview.smarteducation.presenter.GetAlarmListImp;
import comndroid.example.recyclerview.smarteducation.presenter.GetAlarmListPresenter;
import comndroid.example.recyclerview.smarteducation.ui.GetAlarmListView;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BaojingListActivity extends BaseActity
        implements  GetAlarmListView, OnRefreshListener, OnLoadMoreListener {
    private AlarmListAdapter alarmListAdapter;
    private GetAlarmListPresenter getAlarmListPresenter;
    private int index = 0;
    private List<BaojingBean.data> list = new ArrayList();
    private int pageCount;
  private int count;
  private int pagesize;


    @BindView(R.id.recylerview)
    RecyclerView recyclerView;

    @BindView(R.id.sw)
    SmartRefreshLayout smartRefreshLayout;

    @BindView(R.id.title)
    Titlelayout titlelayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private String userId = SPHelper.getInstance().getString("userId", "");

    public void getBaojingBean(BaojingBean paramBaojingBean) {
        count=paramBaojingBean.getCount();
        pagesize=paramBaojingBean.getPageSize();
        smartRefreshLayout.finishLoadMore();
        smartRefreshLayout.finishRefresh();
        if (paramBaojingBean.getCount() > 0) {
            smartRefreshLayout.setVisibility(View.VISIBLE);

            if(index==0){
             list.clear();
             list.addAll(paramBaojingBean.getData());
         }else {
             list.addAll(paramBaojingBean.getData());

         }
            alarmListAdapter.notifyDataSetChanged();
        }else {
            smartRefreshLayout.setVisibility(View.GONE);
        }
    }
    public void geterror(Throwable paramThrowable, String paramString)
    {
    }

    public void initview()
    {
        addActivity(this);
        ButterKnife.bind(this);
        this.getAlarmListPresenter = new GetAlarmListImp(this);
        Object localObject = new LinearLayoutManager(this);
//        RxBus.getDefault().toObservable(AlarmHandleBean.class).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaojingListActivity..Lambda.0(this));
        this.alarmListAdapter = new AlarmListAdapter(this.list);
        this.alarmListAdapter.SetOnAlarmClickListener(new AlarmListAdapter.AlarmClickListener()
        {
            public void run(BaojingBean.data paramdata)
            {
                Intent localIntent = new Intent(BaojingListActivity.this.getBaseContext(), BaojingItemActivity.class);
                localIntent.putExtra("BaojingBean.data", paramdata);
                BaojingListActivity.this.startActivity(localIntent);
            }
        });
        this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
        this.recyclerView.setAdapter(this.alarmListAdapter);
        localObject = this.getAlarmListPresenter;
        String str1 = this.userId;
        String str2 = this.token;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        ((GetAlarmListPresenter)localObject).huoqu(str1, str2, "20", "", "", localStringBuilder.toString(), "8");
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener()
        {
            public void leftClick()
            {
                BaojingListActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });

        smartRefreshLayout.setOnRefreshListener(this);
        smartRefreshLayout.setOnLoadMoreListener(this);
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_baojing_list);
        initview();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        this.index = 0;
        GetAlarmListPresenter localGetAlarmListPresenter = this.getAlarmListPresenter;
        String str1 = this.userId;
        String str2 = this.token;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        localGetAlarmListPresenter.huoqu(str1, str2, "20", "", "", localStringBuilder.toString(), "8");
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
            GetAlarmListPresenter localGetAlarmListPresenter = this.getAlarmListPresenter;
            String str1 = this.userId;
            String str2 = this.token;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.index);
            localStringBuilder.append("");
            localGetAlarmListPresenter.huoqu(str1, str2, "20", "", "", localStringBuilder.toString(), "8");

        }
            else {
                smartRefreshLayout.finishRefresh();
                smartRefreshLayout.finishLoadMore();
        }

    }
}