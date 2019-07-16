package comndroid.example.recyclerview.smarteducation.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;
import comndroid.example.recyclerview.smarteducation.Beans.Loginreturns;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.presenter.LoginPrestenterImp;
import comndroid.example.recyclerview.smarteducation.presenter.Loginpresenter;
import comndroid.example.recyclerview.smarteducation.ui.LoginVIew;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends BaseActity
        implements View.OnClickListener, LoginVIew
{
     public static boolean isForeground = false;
    private ArrayList<String> arrayListPer;

    @BindView(R.id.denglu)
    Button button;

    @BindView(R.id.deleate)
    RelativeLayout deleate;

    @BindView(R.id.wangjimima)
    TextView forget;
    private Loginpresenter loginpresenter;

    @BindView(R.id.mima)
    EditText mima;
    private MyReceiver myReceiver;
    private String password;
    private String telphone;
    private String userId;
    private int usertype;

    @BindView(R.id.zhanghao)
    EditText zhanghao;

    private void init()
    {
        JPushInterface.init(getApplicationContext());
    }

    private void initPermission()
    {
        String[] arrayOfString = new String[3];
        arrayOfString[0] = "android.permission.CAMERA";
        arrayOfString[1] = "android.permission.WRITE_EXTERNAL_STORAGE";
        arrayOfString[2] = "android.permission.READ_EXTERNAL_STORAGE";
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA"))
            {
                ToastUtils.showShort("用户曾拒绝打开相机权限");
                ActivityCompat.requestPermissions(this, arrayOfString, 2);
                return;
            }
            ActivityCompat.requestPermissions(this, arrayOfString, 3);
        }
    }

    private void setTagAndAlias()
    {
        HashSet localHashSet = new HashSet();
        if (this.userId != null)
            localHashSet.add(this.userId);
       JPushInterface.setTags(getBaseContext(), Integer.valueOf(this.userId).intValue(), localHashSet);
    }

    public void getLoginreturns(Loginreturns paramLoginreturns)
    {
        if (paramLoginreturns.isSuccess())
        {
            this.userId = paramLoginreturns.getUserId();
            SPHelper.getInstance().putString("telphone", this.zhanghao.getText().toString()).commit();
            SPHelper.getInstance().putString("password", this.mima.getText().toString()).commit();
            SPHelper.getInstance().putString("userId", paramLoginreturns.getUserId()).commit();
            SPHelper.getInstance().putString("token", paramLoginreturns.getToken()).commit();
            SPHelper.getInstance().putInt("distId", paramLoginreturns.getDistId()).commit();
            SPHelper.getInstance().putString("realName", paramLoginreturns.getRealName()).commit();
            SPHelper.getInstance().putString("deptName", paramLoginreturns.getDeptName()).commit();
            SPHelper.getInstance().putInt("userType", paramLoginreturns.getUserType()).commit();
            SPHelper.getInstance().putString("deptName", paramLoginreturns.getDeptName()).commit();
            SPHelper.getInstance().putInt("deptId", paramLoginreturns.getDeptId()).commit();
            this.usertype = paramLoginreturns.getUserType();
            setTagAndAlias();
            Intent localIntent = new Intent(this, Main2Activity.class);
            localIntent.putExtra("Loginreturns", paramLoginreturns);
            startActivity(localIntent);
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
       telphone = SPHelper.getInstance().getString("telphone", "");
       password = SPHelper.getInstance().getString("password", "");
        if ((telphone != null) && (password != null))
        {
            this.zhanghao.setText(this.telphone);
            this.mima.setText(this.password);
        }
        this.deleate.setOnClickListener(this);
        this.button.setOnClickListener(this);
        this.forget.setOnClickListener(this);
        this.loginpresenter = new LoginPrestenterImp(this);
        this.mima.setInputType(129);
    }

    public void onClick(View paramView)
    {
        int i = paramView.getId();
        if (i != 2131231197)
        {
            switch (i)
            {
                default:
                    return;
                case R.id.denglu:
                    if ((this.zhanghao.getText().toString().trim() != null) && (this.mima.getText().toString().trim() != null))
                    {
                        this.loginpresenter.login(this.zhanghao.getText().toString(), this.mima.getText().toString());
                        return;
                    }
                    ToastUtils.showShort("账号或者密码为空");
                    return;
                case R.id.deleate:
                    this.zhanghao.setText("");
                    break;
                case R.id.wangjimima:
                    startActivity(new Intent(this, ForgetPasswordActivity.class));
                    break;
            }

            return;
        }

    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 21)
        {
            getWindow().getDecorView().setSystemUiVisibility(1280);
            getWindow().setStatusBarColor(0);
        }
        this.arrayListPer = new ArrayList();
        this.arrayListPer.clear();
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0)
            ActivityCompat.requestPermissions(this, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 1);
        else
            this.arrayListPer.add("android.permission.WRITE_EXTERNAL_STORAGE");
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") != 0)
            ActivityCompat.requestPermissions(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 1);
        else
            this.arrayListPer.add("android.permission.READ_EXTERNAL_STORAGE");
        if (this.arrayListPer.size() == 2)
            initPermission();
        initview();
      registerMessageReceiver();

    }

    protected void onDestroy()
    {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.myReceiver);
        super.onDestroy();
    }

    protected void onPause()
    {
        isForeground = false;
        super.onPause();
    }

    protected void onResume()
    {
        isForeground = true;
        super.onResume();
    }

    public void registerMessageReceiver()
    {
        this.myReceiver = new MyReceiver();
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.setPriority(1000);
        localIntentFilter.addAction("com.example.jpushdemo.MESSAGE_RECEIVED_ACTION");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.myReceiver, localIntentFilter);
    }



}
