package comndroid.example.recyclerview.smarteducation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Beans.AddRepairBean;
import comndroid.example.recyclerview.smarteducation.Beans.BuildingBean;
import comndroid.example.recyclerview.smarteducation.Beans.RoomBean;
import comndroid.example.recyclerview.smarteducation.Beans.UplaodBean;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Xialaliebiao;
import comndroid.example.recyclerview.smarteducation.presenter.AddRepairImp;
import comndroid.example.recyclerview.smarteducation.presenter.AddRepairPresenter;
import comndroid.example.recyclerview.smarteducation.presenter.GetRoomListImp;
import comndroid.example.recyclerview.smarteducation.presenter.GetRoomListPresenter;
import comndroid.example.recyclerview.smarteducation.presenter.UploadFileImp;
import comndroid.example.recyclerview.smarteducation.presenter.UploadFilePresenter;
import comndroid.example.recyclerview.smarteducation.ui.AddRepairView;
import comndroid.example.recyclerview.smarteducation.ui.GetRoomListView;
import comndroid.example.recyclerview.smarteducation.ui.UploadView;

public class AddRepairActivity extends BaseActity
        implements UploadView, GetRoomListView, AddRepairView
{
    private AddRepairPresenter addRepairPresenter;
    private String address;
    private BuildingBean buildingBean;
    private String buildingId;
    private String buildingname;

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.bxlx)
    Xialaliebiao bxlx;

    @BindView(R.id.content)
    EditText content;

    @BindView(R.id.dzlx)
    Xialaliebiao dzlx;
    private File file;

    @BindView(R.id.fj)
    RelativeLayout fj;
    private GetRoomListPresenter getRoomListPresenter;
    private String image;

    @BindView(R.id.im)
    ImageView imageView;
    private List<File> list = new ArrayList();
    private List<Map<String, String>> mapList = new ArrayList();
    private List<Map<String, String>> mapList1 = new ArrayList();
    private List<Map<String, String>> mapList2 = new ArrayList();
    private PopupWindow popupWindow;

    @BindView(R.id.rl)
    RelativeLayout relativeLayout;
    private String repairType;
    private String repairTypeName;
    private String reportContent;
    private String roomId = "";
    private String roomname = "";

    @BindView(R.id.ssfj)
    Xialaliebiao ssfj;

    @BindView(R.id.tel)
    EditText tel;
    private String telphone;

    @BindView(R.id.title)
    Titlelayout titlelayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private UploadFilePresenter uploadFilePresenter;
    private String userId = SPHelper.getInstance().getString("userId", "");
    private String userName;

    @BindView(R.id.xm)
    EditText xm;

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

    public void getAddrepairBean(AddRepairBean paramAddRepairBean)
    {
        ToastUtils.showShort("增加报修完成");
        EventBus.getDefault().post(paramAddRepairBean);
        finish();
    }

    public void getRoomBean(RoomBean paramRoomBean)
    {
        this.mapList2.clear();
        if (paramRoomBean.getData().size() > 0)
        {
            Object localObject = this.fj;
            int i = 0;
            ((RelativeLayout)localObject).setVisibility(View.VISIBLE);

            while (i < paramRoomBean.getData().size())
            {
                localObject = ((RoomBean.data)paramRoomBean.getData().get(i)).getRoomNo();
                String str = ((RoomBean.data)paramRoomBean.getData().get(i)).getRoomId();
                HashMap localHashMap = new HashMap();
                localHashMap.put(localObject, str);
                this.mapList2.add(localHashMap);
                i += 1;
            }
            this.ssfj.setList(this.mapList2);
            ssfj.SetOnXiaClickListener(new Xialaliebiao.XiaClickListener() {
                @Override
                public void run(String paramString) {

                    roomId=paramString;
                }
            });
        }else {
            this.fj.setVisibility(View.GONE);
            TextView textView=dzlx.findViewById(R.id.name);
            this.buildingname = textView.getText().toString();
            this.address = this.buildingname;
        }

    }

    public void getUploadBean(UplaodBean paramUplaodBean)
    {
        this.image = paramUplaodBean.getMessage();
        this.addRepairPresenter.huoqu(this.userId, this.token, "20", this.userName, this.buildingId, this.roomId, this.address, this.reportContent, this.image, this.telphone, this.repairType, this.repairTypeName);
    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
    }

    public void initview()
    {
        addActivity(this);
        ButterKnife.bind(this);
        this.ssfj.setActivity(this);
        Object localObject1 = this.fj;
        int i = 0;
        ((RelativeLayout)localObject1).setVisibility(View.VISIBLE);
        this.uploadFilePresenter = new UploadFileImp(this);
        this.getRoomListPresenter = new GetRoomListImp(this);
        this.addRepairPresenter = new AddRepairImp(this);
        this.buildingBean = ((BuildingBean)getIntent().getSerializableExtra("buildingBean"));
        while (i < this.buildingBean.getData().size())
        {
            String s1 = ((BuildingBean.data)this.buildingBean.getData().get(i)).getBuildingId();
            String s2 = ((BuildingBean.data)this.buildingBean.getData().get(i)).getBuildingName();
            Map<String,String> maps = new HashMap();
            maps.put(s2, s1);
            this.mapList1.add(maps);
            i += 1;
        }
        this.dzlx.setActivity(this);
        this.dzlx.setList(this.mapList1);
        this.bxlx.SetOnXiaClickListener(new Xialaliebiao.XiaClickListener()
        {
            public void run(String paramString)
            {
                repairType=paramString;
            }
        });
        this.dzlx.SetOnXiaClickListener(new Xialaliebiao.XiaClickListener()
        {
            public void run(String paramString)
            {
                buildingId=paramString;
                TextView textView1=ssfj.findViewById(R.id.name);
                textView1.setText("请选择房间");
                AddRepairActivity.this.getRoomListPresenter.huoqu(AddRepairActivity.this.userId, AddRepairActivity.this.token, "20", AddRepairActivity.this.buildingId);
            }
        });

        this.bxlx.setActivity(this);
        Map <String,String>  s1 = new HashMap();
        s1.put("水电", "1");
        Map <String,String>  s2 = new HashMap();
        s2.put("消防", "2");
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("教学设备", "3");
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("公共设施", "4");
        HashMap localHashMap3 = new HashMap();
        localHashMap3.put("其他", "5");
        this.mapList.add(s1);
        this.mapList.add(s2);
        this.mapList.add(localHashMap1);
        this.mapList.add(localHashMap2);
        this.mapList.add(localHashMap3);
        this.bxlx.setList(this.mapList);
        this.button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (AddRepairActivity.this.file != null)
                {
                    if (AddRepairActivity.this.repairType != null)
                    {
                        TextView textView=bxlx.findViewById(R.id.name);
                        repairTypeName=textView.getText().toString();

                        if (AddRepairActivity.this.buildingId != null)
                        {
                            TextView textView1=dzlx.findViewById(R.id.name);
                            buildingname=textView1.getText().toString();
                            if (AddRepairActivity.this.roomId != null)
                            {
                                TextView textView2=ssfj.findViewById(R.id.name);
                                roomname=textView2.getText().toString();
                                StringBuilder localStringBuilder = new StringBuilder();
                              address=buildingname+roomname;
                            }
                            else
                            {
                                address=buildingname;
                            }
                            if (AddRepairActivity.this.xm.getText().toString() != null)
                            {
                                userName=xm.getText().toString().trim();
                                if (AddRepairActivity.this.tel.getText().toString() != null)
                                {
                                    telphone=tel.getText().toString().trim();
                                    if (AddRepairActivity.this.content.getText().toString() != null)
                                    {
                                        AddRepairActivity.this.uploadFilePresenter.upload(AddRepairActivity.this.list);
                                        return;
                                    }
                                    ToastUtils.showShort("请输入故障缘由");
                                    return;
                                }
                            }
                            else
                            {
                                ToastUtils.showShort("请输入姓名");
                                return;
                            }
                        }
                        else
                        {
                            ToastUtils.showShort("请先选择所属区域");
                            return;
                        }
                    }
                    else
                    {
                        ToastUtils.showShort("请选择报修类型");
                        return;
                    }
                }
                else
                    ToastUtils.showShort("请选择图片");
            }
        });
        this.relativeLayout.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                View view = LayoutInflater.from(AddRepairActivity.this.getBaseContext()).inflate(R.layout.select, null);
                TextView localTextView1 = (TextView)view.findViewById(R.id.qx);
                TextView localTextView2 = (TextView)view.findViewById(R.id.xc);
                TextView localTextView3 = (TextView)view.findViewById(R.id.pz);
                popupWindow=new PopupWindow(view, -1, -2);
                AddRepairActivity.this.popupWindow.setOutsideTouchable(true);
                AddRepairActivity.this.popupWindow.setAnimationStyle(2131689874);
                AddRepairActivity.this.popupWindow.setFocusable(true);
                AddRepairActivity.this.backgroundAlpha(0.5F);
                AddRepairActivity.this.popupWindow.showAtLocation(relativeLayout, 80, 0, 0);
                AddRepairActivity.this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener()
                {
                    public void onDismiss()
                    {
                        AddRepairActivity.this.backgroundAlpha(1.0F);
                    }
                });
                localTextView1.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View paramView)
                    {
                        AddRepairActivity.this.closePopWindow();
                    }
                });
                localTextView2.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View paramView)
                    {
                        PictureSelector.create(AddRepairActivity.this).openGallery(PictureMimeType.ofImage()).enableCrop(true).showCropFrame(true).minimumCompressSize(100).withAspectRatio(1, 1).compress(true).isDragFrame(true).previewEggs(true).forResult(188);
                        AddRepairActivity.this.closePopWindow();
                    }
                });
                localTextView3.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View paramView)
                    {
                        PictureSelector.create(AddRepairActivity.this).openCamera(PictureMimeType.ofImage()).enableCrop(true).showCropFrame(true).minimumCompressSize(100).withAspectRatio(1, 1).compress(true).isDragFrame(true).previewEggs(true).forResult(188);
                        AddRepairActivity.this.closePopWindow();
                    }
                });
            }
        });
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener()
        {
            public void leftClick()
            {
                AddRepairActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
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
            Glide.with(this).load(selectList.get(0).getCompressPath()).into(this.imageView);
                 file=new File(selectList.get(0).getCompressPath());
                list.add(file);
            relativeLayout.setVisibility(View.GONE);
                    break;
            }
        }

    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_add_repair);
        initview();
    }
}