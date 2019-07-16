package comndroid.example.recyclerview.smarteducation.activities;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Beans.ForgetPasswordbean;
import comndroid.example.recyclerview.smarteducation.Beans.ResetVerfiyCodebean;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.presenter.ForgetpasswordImp;
import comndroid.example.recyclerview.smarteducation.presenter.ForgetpasswordPresenter;
import comndroid.example.recyclerview.smarteducation.presenter.ResetVerfiyCodeImp;
import comndroid.example.recyclerview.smarteducation.presenter.ResetVerfiyCodePresenter;
import comndroid.example.recyclerview.smarteducation.ui.ForgetpasswordView;
import comndroid.example.recyclerview.smarteducation.ui.ResetVerfiyCodeView;

public class ForgetPasswordActivity extends BaseActity
        implements View.OnClickListener, ResetVerfiyCodeView, ForgetpasswordView
{

    @BindView(R.id.back)
    RelativeLayout back;
    private ForgetpasswordPresenter forgetpasswordPresenter;

    @BindView(R.id.huoquyanzhengma)
    TextView huoqu;

    @BindView(R.id.qingshurumima)
    EditText mima;

    @BindView(R.id.xiayibu)
    Button queren;
    private ResetVerfiyCodePresenter resetVerfiyCodePresenter;

    @BindView(R.id.telphonenumble)
    EditText tel;

    @BindView(R.id.yanzhengmatishi)
    TextView textView;
    private String token = SPHelper.getInstance().getString("token", "");
    private String userId = SPHelper.getInstance().getString("userId", "");

    @BindView(R.id.yanzhengma)
    EditText yanzhengma;

    public void getForgetpassworbean(ForgetPasswordbean paramForgetPasswordbean)
    {
        if (paramForgetPasswordbean.isSuccess())
        {
            ToastUtils.showShort("修改成功");
            finish();
        }
    }

    public void getResetVerfiyCodebean(ResetVerfiyCodebean paramResetVerfiyCodebean)
    {
        if ((paramResetVerfiyCodebean.isSuccess()) && (paramResetVerfiyCodebean.isSuccess()))
            this.huoqu.setText("已发送");
    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
        ToastUtils.showShort(paramString);
    }

    public void initview()
    {
        addActivity(this);
        ButterKnife.bind(this);
        this.back.setOnClickListener(this);
        this.queren.setOnClickListener(this);
        this.huoqu.setOnClickListener(this);
        this.resetVerfiyCodePresenter = new ResetVerfiyCodeImp(this);
        this.forgetpasswordPresenter = new ForgetpasswordImp(this);
    }

    public void onClick(View paramView)
    {
        int i = paramView.getId();
        switch (paramView.getId()){
            case R.id.xiayibu:
                if ((this.yanzhengma.getText().toString() != null) && (this.tel.getText().toString() != null) && (this.mima.getText().toString() != null))
                {
                    this.forgetpasswordPresenter.reset(this.mima.getText().toString(), this.yanzhengma.getText().toString(), this.tel.getText().toString());
                }else {
                    ToastUtils.showShort("新密码和验证码不能为空");
                }
                break;

            case R.id.huoquyanzhengma:
                if (this.tel.getText().toString() != null&&!tel.getText().toString().equals(""))
                {
                    this.resetVerfiyCodePresenter.reset(this.tel.getText().toString().trim());

                }else {
                    ToastUtils.showShort("手机号码不能为空");
                }
                break;
            case R.id.back:
                finish();
                break;
        }

    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_forget_password);
        initview();
    }
}
