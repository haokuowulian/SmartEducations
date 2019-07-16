package comndroid.example.recyclerview.smarteducation.activities;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Adapter.XiazaiAdapter;
import comndroid.example.recyclerview.smarteducation.Beans.FileListBean;
import comndroid.example.recyclerview.smarteducation.Beans.FileListBean.data;
import comndroid.example.recyclerview.smarteducation.Beans.FileitemBean;
import comndroid.example.recyclerview.smarteducation.Beans.FileitemBean.fileList;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.presenter.FileitemImp;
import comndroid.example.recyclerview.smarteducation.presenter.FileitemPresenter;
import comndroid.example.recyclerview.smarteducation.ui.FileitemView;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class XiazaiWjActivity extends BaseActity
        implements FileitemView
{
    private String Id;
@BindView(R.id.title)
    Titlelayout titlelayout;
    @BindView(R.id.button)
    Button button;
    private FileListBean.data data;
    private FileitemPresenter fileitemPresenter;
    private int index = 0;
    private int i=0;
    @BindView(R.id.iv)
    ImageView iv;
    private List<FileitemBean.fileList> list = new ArrayList();


    private ProgressDialog progressDialog;

    @BindView(R.id.recylerview)
    RecyclerView recylerview;
private long id;
    @BindView(R.id.text)
    TextView textView;
    private String title;
    private String token = SPHelper.getInstance().getString("token", "");
    private String url;
    private String userId = SPHelper.getInstance().getString("userId", "");
    private XiazaiAdapter xiazaiAdapter;



    public void getFileitemBean(FileitemBean paramFileitemBean)
    {
        if ((paramFileitemBean.getFileList().size() > 0) && (paramFileitemBean.getFileList() != null))
        {
            List<FileitemBean.fileList> lists = paramFileitemBean.getFileList();
            this.xiazaiAdapter = new XiazaiAdapter(this.list);
            this.list.addAll(lists);
        }
        else
        {
            this.list.clear();
            this.recylerview.setVisibility(View.GONE);
            this.textView.setVisibility(View.VISIBLE);
            this.iv.setVisibility(View.VISIBLE);
        }
        this.recylerview.setLayoutManager(new LinearLayoutManager(this));
        this.recylerview.setAdapter(this.xiazaiAdapter);
    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
    }

    public void initview()
    {
        addActivity(this);
        ButterKnife.bind(this);
        this.textView.setVisibility(View.GONE);
        titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        this.iv.setVisibility(View.GONE);
        this.recylerview.setVisibility(View.VISIBLE);
        this.fileitemPresenter = new FileitemImp(this);
        this.data = ((FileListBean.data)getIntent().getSerializableExtra("FileListBean.data"));
        this.Id = this.data.getId();
        this.fileitemPresenter.huoqu(this.userId, this.token, this.Id);
        this.button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {

                 runs();

            }
        });
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_xiazai_wj);
        initview();
    }
    private class DownLoadCompleteReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)){
                i += 1;
                long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                Toast.makeText(XiazaiWjActivity.this, "编号："+id+"的下载任务已经完成！", Toast.LENGTH_SHORT).show();
            }else if(intent.getAction().equals(DownloadManager.ACTION_NOTIFICATION_CLICKED)){
                Toast.makeText(XiazaiWjActivity.this, "别瞎点！！！", Toast.LENGTH_SHORT).show();
            }
        }
    }

public void runs(){
        if(i<list.size()){
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(Url.images+list.get(i).getUrl()));
            //设置通知栏标题
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
            request.setTitle("下载");
            request.setDescription("文件正在下载");
            request.setAllowedOverRoaming(false);
            //设置文件存放目录
            request.setDestinationInExternalFilesDir(getBaseContext(), Environment.getExternalStorageState(), "zhjyPath");
            DownloadManager downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
            id=downloadManager.enqueue(request);
        }

}

}