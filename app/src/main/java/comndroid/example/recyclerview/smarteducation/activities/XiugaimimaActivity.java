package comndroid.example.recyclerview.smarteducation.activities;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Beans.ForgetPasswordbean;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout.titlelayoutClickListener;
import comndroid.example.recyclerview.smarteducation.presenter.UpdatePasswordImp;
import comndroid.example.recyclerview.smarteducation.presenter.UpdatePasswordPresenter;
import comndroid.example.recyclerview.smarteducation.ui.UpdatePasswordView;

public class XiugaimimaActivity extends BaseActity
        implements View.OnClickListener, UpdatePasswordView
{

    @BindView(R.id.dianji1)
    RelativeLayout dianji1;

    @BindView(R.id.dianji2)
    RelativeLayout dianji2;

    @BindView(R.id.dianji3)
    RelativeLayout dianji3;
private  boolean f1=false;
private boolean f2=false;
private boolean f3=false;
    @BindView(R.id.mima2)
    EditText newmima;

    @BindView(R.id.mima3)
    EditText newmima1;

    @BindView(R.id.mima1)
    EditText oldmima;

    @BindView(R.id.mimakejians)
    ImageView pascontrol1;

    @BindView(R.id.mimakejian2)
    ImageView pascontrol2;

    @BindView(R.id.mimakejian1)
    ImageView pascontrol3;

    @BindView(R.id.titlelayout_2)
    Titlelayout titlelayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private UpdatePasswordPresenter updatePasswordPresenter;
    private String userId = SPHelper.getInstance().getString("userId", "");

    @BindView(R.id.xiugaimimatijiao)
    Button xiugai;

    public void getForgetPasswordbean(ForgetPasswordbean paramForgetPasswordbean)
    {
        if (paramForgetPasswordbean.isSuccess())
        {
            ToastUtils.showShort("修改成功");
            finish();
        }
    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
    }

    public void initview()
    {
        ButterKnife.bind(this);
        this.updatePasswordPresenter = new UpdatePasswordImp(this);
        this.xiugai.setOnClickListener(this);
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener()
        {
            public void leftClick()
            {
                XiugaimimaActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });
        this.dianji1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (!f1)
                {
                    f1=true;
                    XiugaimimaActivity.this.pascontrol1.setImageResource(R.mipmap.btn_sz_display);
                    XiugaimimaActivity.this.oldmima.setInputType(144);
                    return;
                }
                f1=false;
                XiugaimimaActivity.this.pascontrol1.setImageResource(R.mipmap.btn_sz_xianshi);
                XiugaimimaActivity.this.oldmima.setInputType(129);
            }
        });
        this.dianji3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (!f2)
                {
                     f2=true;
                    XiugaimimaActivity.this.pascontrol2.setImageResource(R.mipmap.btn_sz_display);
                    XiugaimimaActivity.this.newmima1.setInputType(144);
                    return;
                }
                f2=false;
                XiugaimimaActivity.this.pascontrol2.setImageResource(R.mipmap.btn_sz_xianshi);
                XiugaimimaActivity.this.newmima1.setInputType(129);
            }
        });
        this.dianji2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (!f3)
                {
                    f3=true;
                    XiugaimimaActivity.this.pascontrol3.setImageResource(R.mipmap.btn_sz_display);
                    XiugaimimaActivity.this.newmima.setInputType(144);
                    return;
                }
                f3=false;
                XiugaimimaActivity.this.pascontrol3.setImageResource(R.mipmap.btn_sz_xianshi);
                XiugaimimaActivity.this.newmima.setInputType(129);
            }
        });
    }

    public void onClick(View paramView)
    {
        String s2 = this.newmima1.getText().toString().trim();
        String str1 = this.newmima.getText().toString().trim();
        String str2 = this.oldmima.getText().toString().trim();
        if (s2.equals(str1))
        {
            this.updatePasswordPresenter.update(this.userId, this.token, str2, s2);
            return;
        }
        ToastUtils.showShort("新密码两次输入不一致");
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_xiugaimima);
        initview();
    }
}