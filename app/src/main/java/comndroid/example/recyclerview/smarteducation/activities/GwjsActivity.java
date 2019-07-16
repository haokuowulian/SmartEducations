package comndroid.example.recyclerview.smarteducation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Adapter.GwjsAdapter;
import comndroid.example.recyclerview.smarteducation.Adapter.GwjsAdapter.GwjsClickListener;
import comndroid.example.recyclerview.smarteducation.Beans.FileListBean;
import comndroid.example.recyclerview.smarteducation.Beans.FileListBean.data;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout.titlelayoutClickListener;
import comndroid.example.recyclerview.smarteducation.presenter.FileListImp;
import comndroid.example.recyclerview.smarteducation.presenter.FileListPresenter;
import comndroid.example.recyclerview.smarteducation.ui.FileListView;
import java.util.ArrayList;
import java.util.List;

public class GwjsActivity extends BaseActity
        implements  FileListView, GwjsClickListener, OnLoadMoreListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener {
    private FileListPresenter fileListPresenter;
    private GwjsAdapter gwjsAdapter;
    private int index = 0;
    private List<FileListBean.data> list = new ArrayList();
    private int pageCount;
    private int count;
    private  int pagesize;

    @BindView(R.id.recylerview)
    RecyclerView recyclerView;

    @BindView(R.id.sw)
    SmartRefreshLayout smartRefreshLayout;

    @BindView(R.id. title)
    Titlelayout titlelayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private String userId = SPHelper.getInstance().getString("userId", "");

    public void getFileListBean(FileListBean paramFileListBean)
    {
        smartRefreshLayout.finishRefresh();
        smartRefreshLayout.finishLoadMore();
        count=paramFileListBean.getCount();
        pagesize=paramFileListBean.getPageSize();


        if(paramFileListBean.getCount()>0){
            List localList = paramFileListBean.getData();
         if(index==0){
             list.clear();
             list.addAll(localList);

         }else {
             list.addAll(localList);
         }
            this.gwjsAdapter.notifyDataSetChanged();

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
                GwjsActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });
        smartRefreshLayout.setOnRefreshListener(this);
        smartRefreshLayout.setOnLoadMoreListener(this);
        this.fileListPresenter = new FileListImp(this);
        this.gwjsAdapter = new GwjsAdapter(this.list);
        this.recyclerView.setAdapter(this.gwjsAdapter);
        Object localObject = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
        this.gwjsAdapter.SetOnGwjsClickListener(this);
        localObject = this.fileListPresenter;
        String str1 = this.userId;
        String str2 = this.token;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        ((FileListPresenter)localObject).huoqu(str1, str2, "20", "10", localStringBuilder.toString());

    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_gwjs);
        initview();
    }
    public void run(FileListBean.data paramdata)
    {
        Intent localIntent = new Intent(this, XiazaiWjActivity.class);
        localIntent.putExtra("FileListBean.data", paramdata);
        startActivity(localIntent);
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
            String str1 = this.userId;
            String str2 = this.token;
            FileListPresenter localFileListPresenter = this.fileListPresenter;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.index);
            localStringBuilder.append("");
            localFileListPresenter.huoqu(str1, str2, "20", "10", localStringBuilder.toString());
        }else {
            ToastUtils.showShort("没有啦亲");
            smartRefreshLayout.finishRefresh();
            smartRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        this.index = 0;
        FileListPresenter localFileListPresenter = this.fileListPresenter;
        String str1 = this.userId;
        String str2 = this.token;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        localFileListPresenter.huoqu(str1, str2, "20", "10", localStringBuilder.toString());
    }
}