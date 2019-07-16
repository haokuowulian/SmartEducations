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
import comndroid.example.recyclerview.smarteducation.Adapter.WdqjAdapter;
import comndroid.example.recyclerview.smarteducation.Adapter.WdqjAdapter.WdqjClickListener;
import comndroid.example.recyclerview.smarteducation.Beans.MyapproveListBean;
import comndroid.example.recyclerview.smarteducation.Beans.MyapproveListBean.data;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout.titlelayoutClickListener;
import comndroid.example.recyclerview.smarteducation.presenter.ApprovelistPrensenter;
import comndroid.example.recyclerview.smarteducation.presenter.MyapproveListImp;
import comndroid.example.recyclerview.smarteducation.presenter.MyapproveListPresenter;
import comndroid.example.recyclerview.smarteducation.ui.MyapproveListView;
import java.util.ArrayList;
import java.util.List;

public class MyapproveListActivity extends BaseActity implements MyapproveListView, WdqjClickListener, OnRefreshListener, OnLoadMoreListener {
    private int index = 0;
    private List<MyapproveListBean.data> list = new ArrayList();
    private MyapproveListPresenter myapproveListPresenter;
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
    private WdqjAdapter wdqjAdapter;

    public void geterror(Throwable paramThrowable, String paramString)
    {
        ToastUtils.showShort(paramString);
    }

    public void getmyapproveListbean(MyapproveListBean paramMyapproveListBean)
    {
        count=paramMyapproveListBean.getCount();
        pagesize=paramMyapproveListBean.getPageSize();
          smartRefreshLayout.finishLoadMore();
          smartRefreshLayout.finishRefresh();

            if(paramMyapproveListBean.getCount()>0){
                smartRefreshLayout.setVisibility(View.VISIBLE);
                List<MyapproveListBean.data> lists  = paramMyapproveListBean.getData();
                if(index==0){
                    this.list.clear();
                    this.list.addAll(lists);

                }else {
                    this.list.addAll(lists);
                }
                this.wdqjAdapter.notifyDataSetChanged();
            }else {
                smartRefreshLayout.setVisibility(View.GONE);
            }

    }

    public void initview()
    {
         addActivity(this);
        ButterKnife.bind(this);
        this.wdqjAdapter = new WdqjAdapter(this.list);
        Object localObject = new LinearLayoutManager(this);
        this.recyclerView.setAdapter(this.wdqjAdapter);
        this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
        this.myapproveListPresenter = new MyapproveListImp(this);
        this.wdqjAdapter.SetOnWdqjClickListener(this);
        localObject = this.myapproveListPresenter;
        String str1 = this.userId;
        String str2 = this.token;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.index);
        ((MyapproveListPresenter)localObject).huoqu(str1, str2, "20", localStringBuilder.toString(), "6");
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener()
        {
            public void leftClick()
            {
                MyapproveListActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });
        this.smartRefreshLayout.setOnRefreshListener(this);
        smartRefreshLayout.setOnLoadMoreListener(this);
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_myapprove_list);
        initview();
    }
    public void run(MyapproveListBean.data paramdata)
    {
        Intent localIntent = new Intent(this, ApproveItemActivity.class);
        localIntent.putExtra("MyapproveListBean.data", paramdata);
        startActivity(localIntent);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        this.index = 0;
        MyapproveListPresenter localMyapproveListPresenter = this.myapproveListPresenter;
        String str1 = this.userId;
        String str2 = this.token;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.index);
        localMyapproveListPresenter.huoqu(str1, str2, "20", localStringBuilder.toString(), "6");
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
            String str1 = this.userId;
            String str2 = this.token;
            MyapproveListPresenter localMyapproveListPresenter = MyapproveListActivity.this.myapproveListPresenter;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(MyapproveListActivity.this.index);
            localMyapproveListPresenter.huoqu(str1, str2, "20", localStringBuilder.toString(), "6");
        }else {
            ToastUtils.showShort("没有啦亲");
            smartRefreshLayout.finishRefresh();
            smartRefreshLayout.finishLoadMore();
        }
    }
}