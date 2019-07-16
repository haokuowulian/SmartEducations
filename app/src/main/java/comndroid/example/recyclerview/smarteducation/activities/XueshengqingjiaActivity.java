package comndroid.example.recyclerview.smarteducation.activities;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Beans.Addqingjiabean;
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

public class XueshengqingjiaActivity extends BaseActity
        implements AddqingjiaView, View.OnClickListener {
    private AddqingjiaPresenter addqingjiaPresenter;

    @BindView(R.id.bj)
    EditText bj;
    private String currentTime;

    @BindView(R.id.day)
    TextView days;
    private String deptName = SPHelper.getInstance().getString("deptName", "");
private int startDay=0;
private int endDay=0;
    @BindView(R.id.endTime)
    TextView endTime;
    private String endtime;
    private List<Map<String, String>> mapList = new ArrayList();

    @BindView(R.id.qjlx)
    Xialaliebiao qjlx;
    private String realName = SPHelper.getInstance().getString("realName", "");

    @BindView(R.id.content)
    EditText reason;

    @BindView(R.id.startTime)
    TextView startTime;
    private String starttime;

    @BindView(R.id.names)
    EditText studentname;

    @BindView(R.id.button)
    Button tijiao;

    @BindView(R.id.title)
    Titlelayout titlelayout;
    private String token = SPHelper.getInstance().getString("token", "");
    private String tpyeId;
    private String userId = SPHelper.getInstance().getString("userId", "");

    public void getAddqingbean(Addqingjiabean paramAddqingjiabean) {
        if (paramAddqingjiabean.isSuccess()) {
            ToastUtils.showShort("提交成功");
            finish();
        }
    }

    public void geterror(Throwable paramThrowable, String paramString) {
    }


    public void initview() {
        addActivity(this);
        ButterKnife.bind(this);
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener() {
            public void leftClick() {
                XueshengqingjiaActivity.this.finish();
            }

            public void rightClick() {
            }
        });
        this.qjlx.setActivity(this);
        this.startTime.setOnClickListener(this);
        this.endTime.setOnClickListener(this);
        this.tijiao.setOnClickListener(this);
        this.addqingjiaPresenter = new AddqingjiaImp(this);
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
        this.qjlx.setList(this.mapList);
        this.qjlx.SetOnXiaClickListener(new Xialaliebiao.XiaClickListener() {
            public void run(String paramString) {
                tpyeId = paramString;
            }
        });
    }

    public void onClick(View paramView) {
        int i = paramView.getId();
        switch (paramView.getId()) {
            case R.id.endTime:
                DateUtil.setYearDate(XueshengqingjiaActivity.this, new DateListener() {
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
                        endTime.setText(year + "-" + month + "-" + day );
                        endDay= Integer.parseInt(day);
                        if(startDay!=0){
                            days.setText(endDay-startDay+1+"");
                        }


                    }
                });
                break;
            case R.id.startTime:
                DateUtil.setYearDate(XueshengqingjiaActivity.this, new DateListener() {
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
                        startTime.setText(year + "-" + month + "-" + day);
                        startDay= Integer.parseInt(day);
                        if(endDay!=0){
                            days.setText(endDay-startDay+1+"");
                        }

                    }
                });

                break;
            case R.id.button:
                if ((this.startTime.getText().toString() != null) && (this.endTime.getText().toString() != null) && (this.tpyeId != null))
                    this.addqingjiaPresenter.add(this.userId, this.token, "20", this.tpyeId, this.reason.getText().toString(), this.startTime.getText().toString(), this.endTime.getText().toString(), this.days.getText().toString(), this.studentname.getText().toString(), "0", this.bj.getText().toString(), "0", "0", "2");
                break;
        }


    }


    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_xueshengqingjia);
        initview();
    }
}