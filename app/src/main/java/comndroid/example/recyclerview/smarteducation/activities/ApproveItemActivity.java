package comndroid.example.recyclerview.smarteducation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Adapter.ShlcAdapter;
import comndroid.example.recyclerview.smarteducation.Beans.ApproveItemBean;
import comndroid.example.recyclerview.smarteducation.Beans.MyapproveListBean;
import comndroid.example.recyclerview.smarteducation.Beans.MyapproveListBean.data;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout.titlelayoutClickListener;
import comndroid.example.recyclerview.smarteducation.presenter.ApproveItemImp;
import comndroid.example.recyclerview.smarteducation.presenter.ApproveItemPresenter;
import comndroid.example.recyclerview.smarteducation.ui.ApproveItemView;
import java.util.ArrayList;
import java.util.List;

public class ApproveItemActivity extends BaseActity
        implements ApproveItemView
{
    private ApproveItemBean approve;
    private ApproveItemPresenter approveItemPresenter;
    private MyapproveListBean.data data;
    private String id;

    @BindView(R.id.image)
    ImageView imageView;
    private List<ApproveItemBean> list = new ArrayList();

    @BindView(R.id.lx)
    TextView lx;

    @BindView(R.id.reason)
    TextView reason;

    @BindView(R.id.recylerview)
    RecyclerView recyclerView;
    private ShlcAdapter shlcAdapter;

    @BindView(R.id.sj1)
    TextView sj1;

    @BindView(R.id.sj2)
    TextView sj2;

    @BindView(R.id.sqr)
    TextView sqr;
    private int state;

    @BindView(R.id.title)
    Titlelayout titlelayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private String userId = SPHelper.getInstance().getString("userId", "");

    @BindView(R.id.zw)
    TextView zw;

    public void getApproveItemBean(ApproveItemBean paramApproveItemBean)
    {
        if (paramApproveItemBean != null)
        {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramApproveItemBean);
            this.list.addAll(localArrayList);
            this.shlcAdapter.notifyDataSetChanged();
            return;
        }
        this.recyclerView.setVisibility(View.GONE);
    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
    }

    public void initview()
    {
        addActivity(this);
        this.data = ((MyapproveListBean.data)getIntent().getSerializableExtra("MyapproveListBean.data"));
        ButterKnife.bind(this);
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener()
        {
            public void leftClick()
            {
                ApproveItemActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });
        this.approveItemPresenter = new ApproveItemImp(this);
        this.id = this.data.getId();
        this.state = this.data.getAppStatus();
        int i = this.state;
        if (i != 4)
            switch (i)
            {
                default:
                    break;
                case 2:
                    this.imageView.setImageResource(R.mipmap.img_qjxq_bohui);
                    break;
                case 1:
                    this.imageView.setVisibility(View.GONE);
                    break;
                case 0:
                    this.imageView.setVisibility(View.GONE);
                    break;
            }
        else
            this.imageView.setImageResource(R.mipmap.img_qjxx_tg);
        this.approveItemPresenter.huoqu(this.id, this.userId, this.token);
        this.sqr.setText(this.data.getRealName());
        this.zw.setText(this.data.getDeptName());
        this.sj1.setText(this.data.getStartDate());
        this.sj2.setText(this.data.getEndDate());
        switch (this.data.getLeaveType())
        {
            default:
                break;
            case 3:
                this.lx.setText("其他");
                break;
            case 2:
                this.lx.setText("事假");
                break;
            case 1:
                this.lx.setText("病假");
                break;
            case 0:
                this.lx.setText("公假");
        }
        this.reason.setText(this.data.getIncident());
        LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(localLinearLayoutManager);
        this.shlcAdapter = new ShlcAdapter(this.list);
        this.recyclerView.setAdapter(this.shlcAdapter);
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_approve_item);
        initview();
    }
}
