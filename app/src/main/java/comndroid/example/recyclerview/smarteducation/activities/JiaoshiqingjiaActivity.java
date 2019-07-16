package comndroid.example.recyclerview.smarteducation.activities;

import android.content.Intent;
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
import cn.qqtheme.framework.picker.DatePicker;
import comndroid.example.recyclerview.smarteducation.Beans.Addqingjiabean;
import comndroid.example.recyclerview.smarteducation.Beans.ShangjiBean;
import comndroid.example.recyclerview.smarteducation.Beans.ShangjiBean.userList1;
import comndroid.example.recyclerview.smarteducation.Beans.ShangjiBean.userList2;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.DateListener;
import comndroid.example.recyclerview.smarteducation.Utils.DateUtil;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout.titlelayoutClickListener;
import comndroid.example.recyclerview.smarteducation.layout.Xialaliebiao;
import comndroid.example.recyclerview.smarteducation.layout.Xialaliebiao.XiaClickListener;
import comndroid.example.recyclerview.smarteducation.presenter.AddqingjiaImp;
import comndroid.example.recyclerview.smarteducation.presenter.AddqingjiaPresenter;
import comndroid.example.recyclerview.smarteducation.ui.AddqingjiaView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class JiaoshiqingjiaActivity extends BaseActity
        implements View.OnClickListener, AddqingjiaView
{
    private AddqingjiaPresenter addqingjiaPresenter;
    private String currentTime;
private int startYear;
private int startMonth;
private int startDay=0;
private int endDay=0;
    @BindView(R.id.day)
    TextView days;
    private String deptName;
    private String ejId="0";

    @BindView(R.id.ejspr)
    Xialaliebiao ejspr;
    @BindView(R.id.endTime)
    TextView endTime;
    private String endtime;
    private List<ShangjiBean.userList1> list1 = new ArrayList();
    private List<ShangjiBean.userList2> list2 = new ArrayList();
    private List<Map<String, String>> mapList = new ArrayList();
    private List<Map<String, String>> mapList1 = new ArrayList();
    private List<Map<String, String>> mapList2 = new ArrayList();

    @BindView(R.id.qjlx)
    Xialaliebiao qjlx;
    private String realName ;

    @BindView(R.id.content)
    EditText reason;
    private ShangjiBean shangjiBean;
    @BindView(R.id.startTime)
    TextView startTime;
    private String starttime;

    @BindView(R.id.button)
    Button tijiao;
@BindView(R.id.ej)
    RelativeLayout ej;

    @BindView(R.id.title)
    Titlelayout titlelayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private String tpyeId;
    private String userId = SPHelper.getInstance().getString("userId", "");
    private String yjId="0";

    @BindView(R.id.yjspr)
    Xialaliebiao yjspr;

    public void getAddqingbean(Addqingjiabean paramAddqingjiabean)
    {
        if (paramAddqingjiabean.isSuccess())
        {
            ToastUtils.showShort("提交成功");
            finish();
        }
    }

    public void geterror(Throwable paramThrowable, String paramString)
    {
    }

    public void init() {
        this.currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA).format(Long.valueOf(new Date().getTime() + 2000000000L));
    }

    public void initview()
    {
         addActivity(this);
        ButterKnife.bind(this);
        deptName= SPHelper.getInstance().getString("deptName", "");
        realName= SPHelper.getInstance().getString("realName", "");
        this.startTime.setOnClickListener(this);
        this.endTime.setOnClickListener(this);
        this.tijiao.setOnClickListener(this);
        this.addqingjiaPresenter = new AddqingjiaImp(this);
        this.days.clearFocus();
        this.reason.clearFocus();
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener()
        {
            public void leftClick()
            {
                JiaoshiqingjiaActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });
        this.shangjiBean = ((ShangjiBean)getIntent().getSerializableExtra("shangjibean"));
        if(shangjiBean!=null){
            if ((this.shangjiBean.getUserList1() != null)&&shangjiBean.getUserList1().size()>0)
            {
                this.list1 = this.shangjiBean.getUserList1();
            }
            if(shangjiBean.getUserList2()!=null&&shangjiBean.getUserList2().size()>0){
                this.list2 = this.shangjiBean.getUserList2();
            }
        }
        if(list2.size()>0){
            ej.setVisibility(View.VISIBLE);
        }else {
            ej.setVisibility(View.GONE);
        }
        this.qjlx.setActivity(this);
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("公假", "0");
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("病假", "1");
        HashMap localHashMap3 = new HashMap();
        localHashMap3.put("事假", "2");
        HashMap localHashMap4 = new HashMap();
        localHashMap4.put("其他", "3");
        this.mapList.add(localHashMap1);
        this.mapList.add(localHashMap2);
        this.mapList.add(localHashMap3);
        this.mapList.add(localHashMap4);
        this.qjlx.SetOnXiaClickListener(new Xialaliebiao.XiaClickListener()
        {
            public void run(String paramString)
            {
                tpyeId=paramString;
//                JiaoshiqingjiaActivity.access$002(JiaoshiqingjiaActivity.this, paramString);
            }
        });
        this.qjlx.setList(this.mapList);
        this.yjspr.setActivity(this);
        int j = 0;
        int i = 0;
        while (i < this.list1.size())
        {
            localHashMap1 = new HashMap();
            localHashMap1.put(((ShangjiBean.userList1)this.list1.get(i)).getRealName(), ((ShangjiBean.userList1)this.list1.get(i)).getId());
            this.mapList1.add(localHashMap1);
            i += 1;
        }
        this.yjspr.SetOnXiaClickListener(new Xialaliebiao.XiaClickListener()
        {
            public void run(String paramString)
            {
                yjId=paramString;
            }
        });
        this.yjspr.setList(this.mapList1);
        i = j;
        while (i < this.list2.size())
        {
            localHashMap1 = new HashMap();
            localHashMap1.put(((ShangjiBean.userList2)this.list2.get(i)).getRealName(), ((ShangjiBean.userList2)this.list2.get(i)).getId());
            this.mapList2.add(localHashMap1);
            i += 1;
        }
        this.ejspr.setActivity(this);
        this.ejspr.SetOnXiaClickListener(new Xialaliebiao.XiaClickListener()
        {
            public void run(String paramString)
            {
              ejId=paramString;
            }
        });
        this.ejspr.setList(this.mapList2);
    }

    public void onClick(View paramView)
    {
        int i = paramView.getId();
        switch (paramView.getId()){
            case R.id.endTime:
                DateUtil.setYearDate(JiaoshiqingjiaActivity.this, new DateListener() {
                    @Override
                    public void setYear(String year) {

                    }

                    @Override
                    public void setMonth(String month) {

                    }

                    @Override
                    public void setDay(String day) {

                    }

                    @Override
                    public void setMouthDate(String year, String month) {

                    }

                    @Override
                    public void setYearDate(String year, String month, String day) {
                        endTime.setText(year+"-"+month+"-"+day);
                        endDay= Integer.parseInt(day);
                        if(startDay!=0){
                            days.setText(endDay-startDay+1+"");
                        }


                    }
                });
                break;
            case R.id.startTime:
                DateUtil.setYearDate(JiaoshiqingjiaActivity.this, new DateListener() {
                    @Override
                    public void setYear(String year) {

                    }

                    @Override
                    public void setMonth(String month) {

                    }

                    @Override
                    public void setDay(String day) {

                    }

                    @Override
                    public void setMouthDate(String year, String month) {

                    }

                    @Override
                    public void setYearDate(String year, String month, String day) {
                startTime.setText(year+"-"+month+"-"+day);
                        startDay= Integer.parseInt(day);
                        if(endDay!=0){
                            days.setText(endDay-startDay+1+"");
                        }

                    }
                });
                break;
            case R.id.button:
                if ((this.startTime.getText().toString() != null) && (this.endTime.getText().toString() != null) && (this.tpyeId != null) && (this.yjId != null) )
                    addqingjiaPresenter.add(this.userId, this.token, "20", this.tpyeId, reason.getText().toString().trim(), startTime.getText().toString(), endTime.getText().toString(),days.getText().toString(),realName ,"0", deptName, this.yjId, this.ejId, "1");
                break;
        }


    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_jiaoshiqingjia);
        init();
        initview();
    }
}