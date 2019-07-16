package comndroid.example.recyclerview.smarteducation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;

import comndroid.example.recyclerview.smarteducation.Beans.Baoxiubeans;
import comndroid.example.recyclerview.smarteducation.Beans.Baoxiubeans.data;
import comndroid.example.recyclerview.smarteducation.Beans.Baoxiuitembean;
import comndroid.example.recyclerview.smarteducation.Beans.ResetVerfiyCodebean;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout.titlelayoutClickListener;
import comndroid.example.recyclerview.smarteducation.presenter.BaoxiuchuliImp;
import comndroid.example.recyclerview.smarteducation.presenter.BaoxiuchuliPrensenter;
import comndroid.example.recyclerview.smarteducation.presenter.InfoRepairImp;
import comndroid.example.recyclerview.smarteducation.presenter.InfoRepairPrensenter;
import comndroid.example.recyclerview.smarteducation.ui.BaoxiuchuliView;
import comndroid.example.recyclerview.smarteducation.ui.InfoRepairView;

public class YIchulibaoxiuActivity extends BaseActity
        implements InfoRepairView, BaoxiuchuliView
{
    private BaoxiuchuliPrensenter baoxiuchuliPrensenter;

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.bxlx)
    TextView bxlx;

    @BindView(R.id.content)
    TextView bxnr;
    private Baoxiubeans.data data;

    @BindView(R.id.replycontent)
    EditText hfnr;


    @BindView(R.id.image)
    ImageView imageView;
    private InfoRepairPrensenter infoRepairPrensenter;

    @BindView(R.id.jtdz)
    TextView jtdz;

    @BindView(R.id.lxdh)
    TextView lxdh;
    private String repairId;
    private String telphone = SPHelper.getInstance().getString("telphone", "");

    @BindView(R.id.title)
    Titlelayout titlelayout;

    @BindView(R.id.tjsj)
    TextView tjsj;
    private String token = SPHelper.getInstance().getString("token", "");
    private String userId = SPHelper.getInstance().getString("userId", "");

    @BindView(R.id.xm)
    TextView xm;

    public void getBaoxiuitembean(Baoxiuitembean paramBaoxiuitembean)
    {
        if (paramBaoxiuitembean.isSuccess())
        {
            this.xm.setText(paramBaoxiuitembean.getUserName());
            this.lxdh.setText(this.telphone);
            this.bxlx.setText(paramBaoxiuitembean.getRepairTypeName());
            this.jtdz.setText(paramBaoxiuitembean.getAddress());
            this.bxnr.setText(paramBaoxiuitembean.getReportContent());
            this.tjsj.setText(paramBaoxiuitembean.getReportTime());
            RequestManager localRequestManager = Glide.with(this);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(Url.image);
            localStringBuilder.append(paramBaoxiuitembean.getImage());
            localRequestManager.load(localStringBuilder.toString()).into(this.imageView);
        }
    }

    public void getError(Throwable paramThrowable, String paramString)
    {
        ToastUtils.showShort("服务器开了小差请稍后重试");
    }

    public void getResetVerfiyCodebean(ResetVerfiyCodebean paramResetVerfiyCodebean)
    {
        if (paramResetVerfiyCodebean.isSuccess())
        {
            ToastUtils.showShort("回复成功");
            RxBus.getDefault().post(paramResetVerfiyCodebean);
            finish();
            return;
        }
        ToastUtils.showShort("服务器开了小差请稍后重试");
    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
        ToastUtils.showShort("服务器开了小差请稍后重试");
    }

    public void initview()
    {
        ButterKnife.bind(this);
        this.infoRepairPrensenter = new InfoRepairImp(this);
        this.baoxiuchuliPrensenter = new BaoxiuchuliImp(this);
        this.data = ((Baoxiubeans.data)getIntent().getSerializableExtra("Baoxiubeans"));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.data.getRepairId());
        localStringBuilder.append("");
        this.repairId = localStringBuilder.toString();
        this.button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (YIchulibaoxiuActivity.this.hfnr.getText().toString() != null)
                {
                    String s1 = YIchulibaoxiuActivity.this.hfnr.getText().toString();
                    YIchulibaoxiuActivity.this.baoxiuchuliPrensenter.huoqu(YIchulibaoxiuActivity.this.userId, YIchulibaoxiuActivity.this.token, "20", s1, YIchulibaoxiuActivity.this.repairId);
                }
            }
        });
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener()
        {
            public void leftClick()
            {
                YIchulibaoxiuActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });
        this.infoRepairPrensenter.huoqu(this.userId, this.token, this.repairId);
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_yichulibaoxiu);
        initview();
    }
}