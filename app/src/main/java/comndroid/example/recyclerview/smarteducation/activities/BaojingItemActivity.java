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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.luck.picture.lib.PictureSelectionModel;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import org.greenrobot.eventbus.EventBus;

import comndroid.example.recyclerview.smarteducation.Beans.AlarmHandleBean;
import comndroid.example.recyclerview.smarteducation.Beans.BaojingBean;
import comndroid.example.recyclerview.smarteducation.Beans.BaojingBean.data;
import comndroid.example.recyclerview.smarteducation.Beans.UplaodBean;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.http.Url;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout.titlelayoutClickListener;
import comndroid.example.recyclerview.smarteducation.layout.Xialaliebiao;
import comndroid.example.recyclerview.smarteducation.layout.Xialaliebiao.XiaClickListener;
import comndroid.example.recyclerview.smarteducation.presenter.AlarmHandleImp;
import comndroid.example.recyclerview.smarteducation.presenter.AlarmHandlePresenter;
import comndroid.example.recyclerview.smarteducation.presenter.UploadFileImp;
import comndroid.example.recyclerview.smarteducation.presenter.UploadFilePresenter;
import comndroid.example.recyclerview.smarteducation.ui.AlarmHandleView;
import comndroid.example.recyclerview.smarteducation.ui.UploadView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaojingItemActivity extends BaseActity
        implements UploadView, AlarmHandleView
{

    @BindView(R.id.address)
    TextView address;
    private AlarmHandlePresenter alarmHandlePresenter;

    @BindView(R.id.bjlx)
    TextView bjlx;

    @BindView(R.id.bjsj)
    TextView bjsj;

    @BindView(R.id.bjxq)
    TextView bjxq;

    @BindView(R.id.button)
    Button button;
    private String confirmResult;

    @BindView(R.id.content)
    EditText content;
    private BaojingBean.data data;
    private File file;
    private String id;
    private String image;

    @BindView(R.id.im)
    ImageView imageView;
@BindView(R.id.ims)
ImageView imageViews;

    @BindView(R.id.buttons)
    LinearLayout linearLayout;
    private List<File> list = new ArrayList();
    private String manager = SPHelper.getInstance().getString("realName", "");
    private List<Map<String, String>> mapList = new ArrayList();
    private PopupWindow popupWindow = null;

    @BindView(R.id.rl)
    RelativeLayout relativeLayout;
    private String report;

    @BindView(R.id.result)
    TextView result;

    @BindView(R.id.state)
    TextView state;

    @BindView(R.id.cljgs)
    TextView textView;

    @BindView(R.id.title)
    Titlelayout titlelayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private UploadFilePresenter uploadFilePresenter;
    private String userId = SPHelper.getInstance().getString("userId", "");

    @BindView(R.id.vis)
    LinearLayout vis;

    @BindView(R.id.cljg)
    Xialaliebiao xialaliebiao;

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

    public void getAlarmHandleBean(AlarmHandleBean paramAlarmHandleBean)
    {
        ToastUtils.showShort("操作成功");
        EventBus.getDefault().post(paramAlarmHandleBean);
        finish();
    }

    public void getUploadBean(UplaodBean paramUplaodBean)
    {
        this.image = Url.image+paramUplaodBean.getMessage();
        this.alarmHandlePresenter.huoqu(this.userId, this.token, "20  ", this.manager, this.report, this.image, this.id, this.confirmResult);
    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
    }

    public void initview()
    {
         addActivity(this);
        ButterKnife.bind(this);
        this.uploadFilePresenter = new UploadFileImp(this);
        this.alarmHandlePresenter = new AlarmHandleImp(this);
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener()
        {
            public void leftClick()
            {
                BaojingItemActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });
        this.xialaliebiao.setVisibility(View.VISIBLE);
        this.xialaliebiao.setActivity(this);
        Map<String,String> localObject1 = new HashMap();
        localObject1.put("报警", "1");
        Map<String,String>  localObject2 = new HashMap();
        ((Map)localObject2).put("误报", "2");
        HashMap localHashMap = new HashMap();
        localHashMap.put("测试", "3");
        this.mapList.add(localObject1);
        this.mapList.add(localObject2);
        this.mapList.add(localHashMap);
        this.xialaliebiao.setList(this.mapList);
        this.xialaliebiao.SetOnXiaClickListener(new Xialaliebiao.XiaClickListener()
        {
            public void run(String paramString)
            {
                confirmResult=paramString;
            }
        });
        this.relativeLayout.setVisibility(View.VISIBLE);
        this.data = ((BaojingBean.data)getIntent().getSerializableExtra("BaojingBean.data"));
        this.id = this.data.getId();
        this.address.setText(this.data.getAddress());
        this.bjlx.setText(this.data.getAlarmType());
        this.bjsj.setText(this.data.getAlarmTime());
        this.bjxq.setText(this.data.getContent());
        if (this.data.getAlarmImage() != null)
        {
            Glide.with(this).load(data.getAlarmImage()).into(imageView);

        }
        switch (this.data.getIsConfirmed())
        {
            default:
                return;
            case 1:
                this.state.setText("已处理");
                this.relativeLayout.setVisibility(View.GONE);
                if (this.data.getImage() != null)
                {
                    Glide.with(this).load(data.getImage()).into(imageViews);

                }
                else
                {
                    this.vis.setVisibility(View.GONE);
                }
                this.content.setVisibility(View.GONE);
                this.result.setVisibility(View.VISIBLE);
                this.linearLayout.setVisibility(View.GONE);
                this.result.setText(this.data.getReport());
                this.xialaliebiao.setVisibility(View.GONE);
                switch (this.data.getConfirmResult())
                {
                    default:
                        return;
                    case 3:
                        this.textView.setText("测试");
                        return;
                    case 2:
                        this.textView.setText("误报");
                        return;
                    case 1:
                }
                this.textView.setText("报警");
                return;
            case 0:
        }
        this.state.setText("待处理");
        this.result.setVisibility(View.GONE);
        this.vis.setVisibility(View.VISIBLE);
        this.relativeLayout.setVisibility(View.VISIBLE);
        this.content.setVisibility(View.VISIBLE);
        this.linearLayout.setVisibility(View.VISIBLE);
        this.button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                     report=content.getText().toString();
                if (BaojingItemActivity.this.file != null)
                {
                    if (BaojingItemActivity.this.confirmResult != null)
                    {
                        if (BaojingItemActivity.this.report != null)
                        {
                            BaojingItemActivity.this.uploadFilePresenter.upload(BaojingItemActivity.this.list);
                            return;
                        }
                        ToastUtils.showShort("请输入回复内容");
                        return;
                    }
                    ToastUtils.showShort("请选择处理结果");
                    return;
                }
                if (BaojingItemActivity.this.confirmResult != null)
                {
                    if (BaojingItemActivity.this.report != null)
                    {
                        alarmHandlePresenter.huoqu(userId, token, "20",manager, report, "", id, confirmResult);
                        return;
                    }
                    ToastUtils.showShort("请输入回复内容");
                    return;
                }
                ToastUtils.showShort("请选择处理结果");
                return;

            }
        });
        this.relativeLayout.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.select, null);
                TextView localTextView1 = (TextView)view.findViewById(R.id.qx);
                TextView localTextView2 = (TextView)view.findViewById(R.id.xc);
                TextView localTextView3 = (TextView)view.findViewById(R.id.pz);
                popupWindow=new PopupWindow(view, -1, -2);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setAnimationStyle(2131689874);
                popupWindow.setFocusable(true);
                backgroundAlpha(0.5F);
                popupWindow.showAtLocation(relativeLayout, 80, 0, 0);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener()
                {
                    public void onDismiss()
                    {
                        backgroundAlpha(1.0F);
                    }
                });
                localTextView1.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View paramView)
                    {
                        closePopWindow();
                    }
                });
                localTextView2.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View paramView)
                    {
                        PictureSelector.create(BaojingItemActivity.this).openGallery(PictureMimeType.ofImage()).enableCrop(true).showCropFrame(true).minimumCompressSize(100).withAspectRatio(1, 1).compress(true).isDragFrame(true).previewEggs(true).forResult(188);
                        closePopWindow();
                    }
                });
                localTextView3.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View paramView)
                    {
                        PictureSelector.create(BaojingItemActivity.this).openCamera(PictureMimeType.ofImage()).enableCrop(true).showCropFrame(true).minimumCompressSize(100).withAspectRatio(1, 1).compress(true).isDragFrame(true).previewEggs(true).forResult(188);
                        closePopWindow();
                    }
                });
            }
        });
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (paramInt2 == RESULT_OK) {
            switch (paramInt1) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(paramIntent);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    Glide.with(this).load(selectList.get(0).getCompressPath()).into(imageViews);
                    file = new File(selectList.get(0).getCompressPath());
                        list.add(file);
                    relativeLayout.setVisibility(View.GONE);
                    break;
            }
        }
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_baojing_item);
        initview();
    }
}