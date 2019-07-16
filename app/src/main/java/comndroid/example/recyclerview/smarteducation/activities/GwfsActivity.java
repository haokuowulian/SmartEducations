package comndroid.example.recyclerview.smarteducation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.leon.lfilepickerlibrary.LFilePicker;
import com.leon.lfilepickerlibrary.utils.Constant;

import comndroid.example.recyclerview.smarteducation.Adapter.JsrAdapter;
import comndroid.example.recyclerview.smarteducation.Beans.ForgetPasswordbean;
import comndroid.example.recyclerview.smarteducation.Beans.UplaodBean;
import comndroid.example.recyclerview.smarteducation.Beans.XiajiBean;
import comndroid.example.recyclerview.smarteducation.Beans.XiajiBean.userList;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout.titlelayoutClickListener;
import comndroid.example.recyclerview.smarteducation.presenter.UploadFileImp;
import comndroid.example.recyclerview.smarteducation.presenter.UploadFilePresenter;
import comndroid.example.recyclerview.smarteducation.presenter.UploadFilesImp;
import comndroid.example.recyclerview.smarteducation.presenter.UploadFilesPresenter;
import comndroid.example.recyclerview.smarteducation.ui.ForgetpasswordView;
import comndroid.example.recyclerview.smarteducation.ui.UploadView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GwfsActivity extends BaseActity
        implements View.OnClickListener, ForgetpasswordView, UploadView
{
    private int REQUEST_FILE = 1;

    @BindView(R.id.content)
    EditText content;
    private File file;
    private List<String> filePath = new ArrayList();

    @BindView(R.id.filename)
    TextView filename;
    private List<String> files = new ArrayList();
    private List<File> filess = new ArrayList();

    @BindView(R.id.fs)
    Button fs;

    @BindView(R.id.fswj)
    LinearLayout fswj;

    @BindView(R.id.jsrr)
    TextView jsr;
    private JsrAdapter jsrAdapter;
    private boolean s1exist=false;
    private boolean s2exist=false;
    private List<String> list;
    private List<XiajiBean.userList> mapList = new ArrayList();
    private PopupWindow popupWindow = null;
    private List<String> s1 = new ArrayList();
    private List<String> s2 = new ArrayList();
    private String sendname=null;
    private String sendto=null;

    @BindView(R.id.titles)
    EditText title;

    @BindView(R.id.title)
    Titlelayout titlelayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private UploadFilePresenter uploadFilePresenter;
    private UploadFilesPresenter uploadFilesPresenter;
    private String userId = SPHelper.getInstance().getString("userId", "");
    private XiajiBean xiajiBean;

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

    public void getForgetpassworbean(ForgetPasswordbean paramForgetPasswordbean)
    {
        if (paramForgetPasswordbean.isSuccess())
        {
            ToastUtils.showShort("上传成功");
            this.files.clear();
            this.filePath.clear();
            this.filess.clear();
            finish();
        }
    }

    public void getUploadBean(UplaodBean paramUplaodBean)
    {
        if (paramUplaodBean.isSuccess())
        {
            String [] arg = paramUplaodBean.getMessage().split(",");
            int i = 0;
            while (i < arg.length)
            {
                this.filePath.add(arg[i]);
                i += 1;
            }
            if (this.sendto != null)
            {
                this.uploadFilesPresenter.upload(this.userId, this.token, "20", this.title.getText().toString(), this.content.getText().toString(), this.sendto, this.sendname, this.files, this.filePath);
                return;
            }
            ToastUtils.showShort("您的权限不支持该操作");
        }
    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
    }

    public void initview()
    {
        addActivity(this);
        ButterKnife.bind(this);
        filename.setOnClickListener(this);
        this.xiajiBean = ((XiajiBean)getIntent().getSerializableExtra("xiajibean"));
        mapList = this.xiajiBean.getUserList();
        int i = 0;
        this.fswj.setOnClickListener(this);
        this.fs.setOnClickListener(this);
        this.jsr.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                View view = LayoutInflater.from(GwfsActivity.this.getBaseContext()).inflate(R.layout.gwjsr, null);
                RecyclerView localRecyclerView = (RecyclerView)view.findViewById(R.id.recylerview);
                TextView textView = view.findViewById(R.id.qr);
                textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendto=null;
                        sendname=null;
                        s1.clear();
                        s2.clear();
                        List<XiajiBean.userList> lists=jsrAdapter.getLists();
                       for(XiajiBean.userList userList:lists){
                           s1.add(userList.getId());
                           s2.add(userList.getRealName());
                       }
                        int i = 0;
                        while (i < s1.size())
                        {
                            if (i == s1.size() - 1)
                            {
                                sendto=sendto+s1.get(i);
                            }
                            else
                            {
                                sendto=s1.get(i)+","+sendto;
                            }
                            i += 1;
                        }
                        i = 0;
                        while (i < s2.size())
                        {
                            if (i == s2.size() - 1)
                            {
                                sendname=sendname+s2.get(i);
                            }
                            else
                            {
                                sendname=s2.get(i)+","+sendname;
                            }
                            i += 1;
                        }
                        if (sendto != null)
                        {
                          closePopWindow();
                            if(s2.size()>1){
                                jsr.setText(s2.get(0)+"等");

                            }else {
                                jsr.setText(s2.get(0));
                            }
                        }else {
                            closePopWindow();
                            jsr.setText("请选择接受人");
                        }
                    }
                });
                localRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                jsrAdapter=new JsrAdapter(mapList);
                localRecyclerView.setAdapter(jsrAdapter);


//                GwfsActivity.access$602(GwfsActivity.this, new PopupWindow(paramView, -1, -2));
                popupWindow=new PopupWindow(view,LinearLayout.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
                GwfsActivity.this.popupWindow.setOutsideTouchable(true);
                GwfsActivity.this.popupWindow.setAnimationStyle(2131689874);
                GwfsActivity.this.popupWindow.setFocusable(true);
                GwfsActivity.this.popupWindow.showAtLocation(GwfsActivity.this.jsr, 80, 0, 0);
                GwfsActivity.this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener()
                {
                    public void onDismiss()
                    {
                        GwfsActivity.this.closePopWindow();
                    }
                });
                GwfsActivity.this.backgroundAlpha(0.5F);
            }
        });
        this.content.clearFocus();
        this.title.clearFocus();
        this.uploadFilesPresenter = new UploadFilesImp(this);
        this.uploadFilePresenter = new UploadFileImp(this);
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener()
        {
            public void leftClick()
            {
                GwfsActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 == -1) && (paramInt1 == this.REQUEST_FILE))
        {
            this.list = paramIntent.getStringArrayListExtra(Constant.RESULT_INFO);
            paramInt1 = 0;
            while (paramInt1 < this.list.size())
            {
                this.file = new File((String)this.list.get(paramInt1));
                String names = this.file.getName();
                this.files.add(names);
                this.filess.add(this.file);
                paramInt1 += 1;
            }
            this.file = new File((String)this.list.get(0));
            this.filename.setText(this.file.getName());
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("选中了");
            localStringBuilder.append(this.list.size());
            localStringBuilder.append("个文件");
        }
    }

    public void onClick(View paramView)
    {
        switch (paramView.getId())
        {
            default:
                return;
            case R.id.filename:
                new LFilePicker().withActivity(this).withRequestCode(this.REQUEST_FILE).withTitle("Open From Fragment").start();
                break;
            case R.id.fs:
                if (this.file != null)
                    this.uploadFilePresenter.upload(this.filess);
                break;
        }

    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_gwfs);
        initview();
    }
}