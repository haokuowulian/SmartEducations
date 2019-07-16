package comndroid.example.recyclerview.smarteducation.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import comndroid.example.recyclerview.smarteducation.Adapter.QjryAdapter;
import comndroid.example.recyclerview.smarteducation.Adapter.QjryAdapter.QjryClickListener;
import comndroid.example.recyclerview.smarteducation.Beans.ApproveListBean;
import comndroid.example.recyclerview.smarteducation.Beans.ApproveListBean.data;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.presenter.ApproveListImp;
import comndroid.example.recyclerview.smarteducation.presenter.ApprovelistPrensenter;
import comndroid.example.recyclerview.smarteducation.ui.ApproveListView;
import java.util.ArrayList;
import java.util.List;

public class QjryFragment extends Fragment
        implements ApproveListView, com.scwang.smartrefresh.layout.listener.OnRefreshListener, OnLoadMoreListener {
    private ApprovelistPrensenter approvelistPrensenter;
    private int index = 0;
    private int count;
    private int pagesize;
    private List<ApproveListBean.data> list = new ArrayList();
    private int pageCount;
    private ProgressBar progressBar;
    private QjryAdapter qjryAdapter;
    private RecyclerView recyclerView;
    private SmartRefreshLayout smartRefreshLayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private String userId = SPHelper.getInstance().getString("userId", "");
 private Titlelayout title;
    public void getApproveListBean(ApproveListBean paramApproveListBean)
    {
        smartRefreshLayout.finishRefresh();
        smartRefreshLayout.finishLoadMore();
        count=paramApproveListBean.getCount();
        pagesize=paramApproveListBean.getPageSize();
        this.progressBar.setVisibility(View.GONE);
        List localList = paramApproveListBean.getData();
        this.smartRefreshLayout.setVisibility(View.VISIBLE);
        if(index==0){
            this.list.clear();
            this.list.addAll(localList);

        }else {
            this.list.addAll(localList);
        }
        qjryAdapter.notifyDataSetChanged();

    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
    {
        View view = paramLayoutInflater.inflate(R.layout.qjryfragment, null);
        this.progressBar = ((ProgressBar)view.findViewById(R.id.progressbar));
        this.smartRefreshLayout = view.findViewById(R.id.sw);
        title=view.findViewById(R.id.title);

        this.recyclerView = ((RecyclerView)view.findViewById(R.id.recylerview));
        this.qjryAdapter = new QjryAdapter(this.list);
        title.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener() {
            @Override
            public void leftClick() {

            }

            @Override
            public void rightClick() {

            }
        });
        this.qjryAdapter.SetOnQjryClickListener(new QjryAdapter.QjryClickListener()
        {
            public void run(ApproveListBean.data paramdata)
        {
        }
    });
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.setAdapter(this.qjryAdapter);
        this.smartRefreshLayout.setOnRefreshListener(this);
        smartRefreshLayout.setOnLoadMoreListener(this);
        this.approvelistPrensenter = new ApproveListImp(this);
        approvelistPrensenter.huoqu(userId,token, "20", index+"", "6");
        return view;
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        this.index = 0;
        ApprovelistPrensenter localApprovelistPrensenter = this.approvelistPrensenter;
        String str1 = this.userId;
        String str2 = this.token;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.index);
        localStringBuilder.append("");
        localApprovelistPrensenter.huoqu(str1, str2, "20", localStringBuilder.toString(), "6");
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
    ApprovelistPrensenter localApprovelistPrensenter = this.approvelistPrensenter;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.index);
    localStringBuilder.append("");
    localApprovelistPrensenter.huoqu(str1, str2, "20", localStringBuilder.toString(), "6");

}else {
    ToastUtils.showShort("没有啦亲");
    progressBar.setVisibility(View.GONE);
    smartRefreshLayout.finishRefresh();
    smartRefreshLayout.finishLoadMore();
}
    }
}