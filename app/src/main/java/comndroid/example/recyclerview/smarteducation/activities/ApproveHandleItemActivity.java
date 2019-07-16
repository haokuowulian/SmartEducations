package comndroid.example.recyclerview.smarteducation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Beans.ApproveListBean;
import comndroid.example.recyclerview.smarteducation.Beans.ApproveListBean.data;
import comndroid.example.recyclerview.smarteducation.Beans.HandlereturnBean;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.presenter.ApproveHandleingImp;
import comndroid.example.recyclerview.smarteducation.presenter.ApproveHandleingPresenter;
import comndroid.example.recyclerview.smarteducation.ui.ApproveHandleingView;

public class ApproveHandleItemActivity extends BaseActity
        implements View.OnClickListener, ApproveHandleingView
{
    private ApproveHandleingPresenter approveHandleingPresenter;
    private ApproveListBean.data data;
    private String id;

    @BindView(R.id.jj)
    Button jj;

    @BindView(R.id.js)
    Button js;

    @BindView(R.id.lx)
    TextView lx;
    private PopupWindow popupWindow = null;

    @BindView(R.id.reason)
    TextView reason;

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

    public void backgroundAlpha(float paramFloat)
    {
        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        localLayoutParams.alpha = paramFloat;
        getWindow().setAttributes(localLayoutParams);
        getWindow().addFlags(2);
    }

    public void closePopWindow()
    {
        this.popupWindow.dismiss();
        this.popupWindow = null;
        backgroundAlpha(1.0F);
    }

    public void getHandlereturnBean(HandlereturnBean paramHandlereturnBean)
    {
        if (paramHandlereturnBean.isSuccess())
        {
            if (this.popupWindow != null)
                closePopWindow();
            ToastUtils.showShort("操作成功");
            EventBus.getDefault().post(paramHandlereturnBean);
            finish();
            return;
        }
        ToastUtils.showShort("服务器开了小差请稍后再试");

    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
        ToastUtils.showShort("服务器开了小差请稍后再试");
    }

    public void initview()
    {
        addActivity(this);
        ButterKnife.bind(this);
        this.approveHandleingPresenter = new ApproveHandleingImp(this);
        this.data = ((ApproveListBean.data)getIntent().getSerializableExtra("ApproveListBean.data"));
        this.id = this.data.getId();
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
        this.jj.setOnClickListener(this);
        this.js.setOnClickListener(this);
    }

    public void onClick(View paramView)
    {
        switch (paramView.getId())
        {
            default:
                return;
            case R.id.js:
                this.approveHandleingPresenter.huoqu(this.userId, this.id, this.token, "1", "");
                return;
            case R.id.jj:
        }
        View view= LayoutInflater.from(this).inflate(R.layout.refusewindow, null, false);
        this.popupWindow = new PopupWindow((View)view, 600, -2);
        RelativeLayout quxiao = view.findViewById(R.id.quxiao);
        RelativeLayout refuse = view.findViewById(R.id.jujueqingjia);
        final EditText content = view.findViewById(R.id.contents);
        this.popupWindow.setFocusable(true);
        this.popupWindow.setAnimationStyle(2131689874);
        this.popupWindow.setOutsideTouchable(false);
        this.popupWindow.showAtLocation(this.reason, 17, 0, 0);
        this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener()
        {
            public void onDismiss()
            {
                ApproveHandleItemActivity.this.closePopWindow();
            }
        });
        quxiao.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                ApproveHandleItemActivity.this.closePopWindow();
            }
        });
        refuse.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                String s1 = content.getText().toString();
                if (s1 != null)
                {
                    ApproveHandleItemActivity.this.approveHandleingPresenter.huoqu(ApproveHandleItemActivity.this.userId, ApproveHandleItemActivity.this.id, ApproveHandleItemActivity.this.token, "2", s1);
                    return;
                }
                ToastUtils.showShort("请输入拒绝原因");
            }
        });
        backgroundAlpha(0.5F);
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_approve_handle_item);
        initview();
    }
}