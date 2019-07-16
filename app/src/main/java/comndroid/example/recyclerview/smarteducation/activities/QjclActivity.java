package comndroid.example.recyclerview.smarteducation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Adapter.QjryAdapter;
import comndroid.example.recyclerview.smarteducation.Adapter.QjryAdapter.QjryClickListener;
import comndroid.example.recyclerview.smarteducation.Beans.ApproveListBean;
import comndroid.example.recyclerview.smarteducation.Beans.ApproveListBean.data;
import comndroid.example.recyclerview.smarteducation.Beans.HandlereturnBean;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout.titlelayoutClickListener;
import comndroid.example.recyclerview.smarteducation.presenter.ApproveHandleImp;
import comndroid.example.recyclerview.smarteducation.presenter.ApproveHandlePresenter;
import comndroid.example.recyclerview.smarteducation.presenter.MyRepairListPresenter;
import comndroid.example.recyclerview.smarteducation.ui.ApproveListView;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class QjclActivity extends BaseActity
        implements ApproveListView, OnRefreshListener, OnLoadMoreListener {
    private ApproveHandlePresenter approveHandlePresenter;
    private int index = 0;
    private List<ApproveListBean.data> list = new ArrayList();
    private int pageCount;
   private int count;
   private int pagesize;

    private QjryAdapter qjryAdapter;

    @BindView(R.id.recylerview)
    RecyclerView recyclerView;

    @BindView(R.id.sw)
    SmartRefreshLayout smartRefreshLayout;

    @BindView(R.id.title)
    Titlelayout titlelayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private String userId = SPHelper.getInstance().getString("userId", "");

    @Subscribe(threadMode= ThreadMode.ASYNC)
    public void Event(HandlereturnBean paramMessageEvents)
    {
        this.index = 0;
        this.list = new ArrayList();
        ApproveHandlePresenter localApproveHandlePresenter = this.approveHandlePresenter;
        String str1 = this.userId;
        String str2 = this.token;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        localApproveHandlePresenter.huoqu(str1, str2, "20", localStringBuilder.toString(), "6");
    }
    public void getApproveListBean(ApproveListBean paramApproveListBean)
    {

        count=paramApproveListBean.getCount();
        pagesize=paramApproveListBean.getPageSize();
        smartRefreshLayout.finishLoadMore();
        smartRefreshLayout.finishRefresh();
        if (paramApproveListBean.getCount() > 0) {
            smartRefreshLayout.setVisibility(View.VISIBLE);
            if(index==0){
                list.clear();
                list.addAll(paramApproveListBean.getData());

            }else {
                list.addAll(paramApproveListBean.getData());

            }
            qjryAdapter.notifyDataSetChanged();
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
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener()
        {
            public void leftClick()
            {
                QjclActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });
        this.approveHandlePresenter = new ApproveHandleImp(this);
        smartRefreshLayout.setOnLoadMoreListener(this);
        LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this);
        ApproveHandlePresenter localApproveHandlePresenter = this.approveHandlePresenter;
        String str1 = this.userId;
        String str2 = this.token;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        localApproveHandlePresenter.huoqu(str1, str2, "20", localStringBuilder.toString(), "6");
        //                ApproveHandlePresenter localApproveHandlePresenter = QjclActivity.this.approveHandlePresenter;
//                String str1 = QjclActivity.this.userId;
//                String str2 = QjclActivity.this.token;
//                StringBuilder localStringBuilder = new StringBuilder();
//                localStringBuilder.append(QjclActivity.this.index);
//                localStringBuilder.append("");
//                localApproveHandlePresenter.huoqu(str1, str2, "20", localStringBuilder.toString(), "6");
        this.recyclerView.setLayoutManager(localLinearLayoutManager);
        this.qjryAdapter = new QjryAdapter(this.list);
        this.qjryAdapter.SetOnQjryClickListener(new QjryAdapter.QjryClickListener()
        {
            public void run(ApproveListBean.data paramdata)
            {
                Intent localIntent = new Intent(QjclActivity.this.getBaseContext(), ApproveHandleItemActivity.class);
                localIntent.putExtra("ApproveListBean.data", paramdata);
                QjclActivity.this.startActivity(localIntent);
            }
        });
        this.smartRefreshLayout.setOnRefreshListener(this);
        this.recyclerView.setAdapter(this.qjryAdapter);
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_qjcl);
        EventBus.getDefault().register(this);
        initview();
    }


    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        this.index = 0;
        ApproveHandlePresenter localApproveHandlePresenter = this.approveHandlePresenter;
        String str1 = this.userId;
        String str2 = this.token;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        localApproveHandlePresenter.huoqu(str1, str2, "20", localStringBuilder.toString(), "6");
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
            ApproveHandlePresenter localApproveHandlePresenter = this.approveHandlePresenter;
            String str1 = this.userId;
            String str2 = this.token;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.index);
            localStringBuilder.append("");
            localApproveHandlePresenter.huoqu(str1, str2, "20", localStringBuilder.toString(), "6");

        }else {
            smartRefreshLayout.finishRefresh();
            smartRefreshLayout.finishLoadMore();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}