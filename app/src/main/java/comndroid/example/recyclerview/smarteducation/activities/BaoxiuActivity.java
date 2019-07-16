package comndroid.example.recyclerview.smarteducation.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Fragments.DaichuliFragment;
import comndroid.example.recyclerview.smarteducation.Fragments.DaichuliFragment2;
import comndroid.example.recyclerview.smarteducation.Fragments.yiwanchengFragment;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class BaoxiuActivity extends BaseActity
        implements View.OnClickListener
{
    private String Areaname;
    private String Typename = "6";
    private TextView ab;
    private boolean area = false;
    private TextView bx;
    private TextView cz;
    private TextView gg;
    private TextView ggqy;
    private TextView lcqy;

    @BindView(R.id.title)
    Titlelayout titlelayout;
    @BindView(R.id.ling)
    LinearLayout ling;
    private List<String> list;
    private List<Fragment> lists;
    private TextView mq;
    private PopupWindow popupWindow;
    private TextView qd;
    private TextView sd;

    @BindView(R.id.select)
    RelativeLayout select;

    @BindView(R.id.tablayouts)
    TabLayout tabLayout;
    private boolean type = false;
    private View view;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private int width;

    private void initdata()
    {
        this.list = new ArrayList();
        this.lists = new ArrayList();
        this.list.add("待处理");
        this.list.add("已处理");
        this.lists.add(new DaichuliFragment());
        this.lists.add(new yiwanchengFragment());
    }

    public void backgroundAlpha(float paramFloat)
    {
        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        localLayoutParams.alpha = paramFloat;
        getWindow().setAttributes(localLayoutParams);
        getWindow().addFlags(2);
    }

    @SuppressLint({"ResourceAsColor"})
    public void closePopWindow()
    {
        this.popupWindow.dismiss();
        this.popupWindow = null;
        backgroundAlpha(1.0F);
    }

    public void initview() {
        addActivity(this);
        ButterKnife.bind(this);
        this.select.setOnClickListener(this);
        titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int paramInt) {
            }

            public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
            }

            public void onPageSelected(int paramInt) {
            }
        });
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
            }

            public int getCount() {
                return BaoxiuActivity.this.lists.size();
            }

            public Fragment getItem(int paramInt) {
                return (Fragment) BaoxiuActivity.this.lists.get(paramInt);
            }

            @Nullable
            public CharSequence getPageTitle(int paramInt) {
                return (CharSequence) BaoxiuActivity.this.list.get(paramInt);
            }
        };
        this.viewPager.setAdapter(adapter);
        this.tabLayout.setupWithViewPager(this.viewPager);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onClick(View paramView)
    {
        int i = paramView.getId();

            view = LayoutInflater.from(this).inflate(R.layout.baoxiupopwindow, null, false);
            this.ab = ((TextView)this.view.findViewById(R.id.ab));
            this.mq = ((TextView)this.view.findViewById(R.id.mq));
            this.sd = ((TextView)this.view.findViewById(R.id.sd));
            this.lcqy = ((TextView)this.view.findViewById(R.id.lcqy));
            this.ggqy = ((TextView)this.view.findViewById(R.id.ggqy));
            this.cz = ((TextView)this.view.findViewById(R.id.cz));
            this.qd = ((TextView)this.view.findViewById(R.id.qd));
            this.gg = ((TextView)this.view.findViewById(R.id.gg));
            this.bx = ((TextView)this.view.findViewById(R.id.bx));
            this.width = getWindowManager().getDefaultDisplay().getWidth();
            this.popupWindow = new PopupWindow(this.view, this.width * 2 / 3, -1);
            this.popupWindow.setOutsideTouchable(true);
            this.popupWindow.setAnimationStyle(2131689874);
            this.popupWindow.setFocusable(true);
            if (this.Typename.equals("1"))
            {
                this.type = true;
                this.sd.setBackgroundResource(R.drawable.kuang_select);
                this.sd.setTextColor(-1);
                this.mq.setBackgroundResource(R.drawable.kuang_un);
                this.mq.setTextColor(-16777216);
                this.ab.setTextColor(-16777216);
                this.ab.setBackgroundResource(R.drawable.kuang_un);
                this.gg.setTextColor(-16777216);
                this.gg.setBackgroundResource(R.drawable.kuang_un);
                this.bx.setTextColor(-16777216);
                this.bx.setBackgroundResource(R.drawable.kuang_un);
            }
            if (this.Typename.equals("2"))
            {
                this.type = true;
                this.mq.setBackgroundResource(R.drawable.kuang_select);
                this.mq.setTextColor(-1);
                this.ab.setBackgroundResource(R.drawable.kuang_un);
                this.ab.setTextColor(-16777216);
                this.sd.setTextColor(-16777216);
                this.sd.setBackgroundResource(R.drawable.kuang_un);
                this.gg.setTextColor(-16777216);
                this.gg.setBackgroundResource(R.drawable.kuang_un);
                this.bx.setTextColor(-16777216);
                this.bx.setBackgroundResource(R.drawable.kuang_un);
            }
            if (this.Typename.equals("3"))
            {
                this.type = true;
                this.ab.setBackgroundResource(R.drawable.kuang_select);
                this.ab.setTextColor(-1);
                this.mq.setBackgroundResource(R.drawable.kuang_un);
                this.mq.setTextColor(-16777216);
                this.sd.setTextColor(-16777216);
                this.sd.setBackgroundResource(R.drawable.kuang_un);
                this.gg.setTextColor(-16777216);
                this.gg.setBackgroundResource(R.drawable.kuang_un);
                this.bx.setTextColor(-16777216);
                this.bx.setBackgroundResource(R.drawable.kuang_un);
            }
            if (this.Typename.equals("4"))
            {
                this.type = true;
                this.gg.setBackgroundResource(R.drawable.kuang_select);
                this.gg.setTextColor(-1);
                this.ab.setBackgroundResource(R.drawable.kuang_un);
                this.ab.setTextColor(-16777216);
                this.sd.setTextColor(-16777216);
                this.sd.setBackgroundResource(R.drawable.kuang_un);
                this.mq.setTextColor(-16777216);
                this.mq.setBackgroundResource(R.drawable.kuang_un);
                this.bx.setTextColor(-16777216);
                this.bx.setBackgroundResource(R.drawable.kuang_un);
            }
            if (this.Typename.equals("5"))
            {
                this.type = true;
                this.bx.setBackgroundResource(R.drawable.kuang_select);
                this.bx.setTextColor(-1);
                this.ab.setBackgroundResource(R.drawable.kuang_un);
                this.ab.setTextColor(-16777216);
                this.sd.setTextColor(-16777216);
                this.sd.setBackgroundResource(R.drawable.kuang_un);
                this.gg.setTextColor(-16777216);
                this.gg.setBackgroundResource(R.drawable.kuang_un);
                this.mq.setTextColor(-16777216);
                this.mq.setBackgroundResource(R.drawable.kuang_un);
            }
            if (this.Typename.equals("6"))
            {
                view = LayoutInflater.from(this).inflate(R.layout.baoxiupopwindow, null, false);
                this.ab = ((TextView)this.view.findViewById(R.id.ab));
                this.mq = ((TextView)this.view.findViewById(R.id.mq));
                this.sd = ((TextView)this.view.findViewById(R.id.sd));
                this.lcqy = ((TextView)this.view.findViewById(R.id.lcqy));
                this.ggqy = ((TextView)this.view.findViewById(R.id.ggqy));
                this.cz = ((TextView)this.view.findViewById(R.id.cz));
                this.qd = ((TextView)this.view.findViewById(R.id.qd));
                this.gg = ((TextView)this.view.findViewById(R.id.gg));
                this.bx = ((TextView)this.view.findViewById(R.id.bx));
                this.width = getWindowManager().getDefaultDisplay().getWidth();
                this.popupWindow = new PopupWindow(this.view, this.width * 2 / 3, -1);
                this.popupWindow.setOutsideTouchable(true);
                this.popupWindow.setAnimationStyle(R.style.Animation_CustomPopup);
                this.popupWindow.setFocusable(true);
            }
            if(Areaname!=null){
                if(Areaname.equals(ggqy.getText().toString())){

                    ggqy.setBackgroundResource(R.drawable.kuang_select);
                    ggqy.setTextColor(-1);
                    lcqy.setTextColor(-16777216);
                lcqy.setBackgroundResource(R.drawable.kuang_un);
                }
                if(Areaname.equals(lcqy.getText().toString())){
                  lcqy.setBackgroundResource(R.drawable.kuang_select);
                 lcqy.setTextColor(-1);
                    ggqy.setTextColor(-16777216);
                  ggqy.setBackgroundResource(R.drawable.kuang_un);
                }
            }

        this.ab.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                type=true;
                ab.setBackgroundResource(R.drawable.kuang_select);
                ab.setTextColor(-1);
                mq.setBackgroundResource(R.drawable.kuang_un);
                mq.setTextColor(-16777216);
                sd.setTextColor(-16777216);
                sd.setBackgroundResource(R.drawable.kuang_un);
                gg.setTextColor(-16777216);
                gg.setBackgroundResource(R.drawable.kuang_un);
                bx.setTextColor(-16777216);
                bx.setBackgroundResource(R.drawable.kuang_un);
                Typename="3";
            }
        });
        this.sd.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                type=true;
               sd.setBackgroundResource(R.drawable.kuang_select);
                sd.setTextColor(-1);
                mq.setBackgroundResource(R.drawable.kuang_un);
                mq.setTextColor(-16777216);
                ab.setTextColor(-16777216);
                ab.setBackgroundResource(R.drawable.kuang_un);
                gg.setTextColor(-16777216);
                gg.setBackgroundResource(R.drawable.kuang_un);
                bx.setTextColor(-16777216);
                bx.setBackgroundResource(R.drawable.kuang_un);
                Typename="1";
            }
        });
        this.mq.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                type=true;
                mq.setBackgroundResource(R.drawable.kuang_select);
                mq.setTextColor(-1);
                ab.setBackgroundResource(R.drawable.kuang_un);
                ab.setTextColor(-16777216);
                sd.setTextColor(-16777216);
                sd.setBackgroundResource(R.drawable.kuang_un);
                gg.setTextColor(-16777216);
                gg.setBackgroundResource(R.drawable.kuang_un);
                bx.setTextColor(-16777216);
                bx.setBackgroundResource(R.drawable.kuang_un);
                Typename="2";
            }
        });
        this.gg.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                type=true;
                gg.setBackgroundResource(R.drawable.kuang_select);
                gg.setTextColor(-1);
                ab.setBackgroundResource(R.drawable.kuang_un);
                ab.setTextColor(-16777216);
                sd.setTextColor(-16777216);
                sd.setBackgroundResource(R.drawable.kuang_un);
                mq.setTextColor(-16777216);
                mq.setBackgroundResource(R.drawable.kuang_un);
                bx.setTextColor(-16777216);
                bx.setBackgroundResource(R.drawable.kuang_un);
                Typename="4";
            }
        });
        this.bx.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                type=true;
                bx.setBackgroundResource(R.drawable.kuang_select);
                bx.setTextColor(-1);
                ab.setBackgroundResource(R.drawable.kuang_un);
                ab.setTextColor(-16777216);
                sd.setTextColor(-16777216);
                sd.setBackgroundResource(R.drawable.kuang_un);
                gg.setTextColor(-16777216);
                gg.setBackgroundResource(R.drawable.kuang_un);
                mq.setTextColor(-16777216);
                mq.setBackgroundResource(R.drawable.kuang_un);
                Typename="5";
            }
        });
        this.lcqy.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                area=true;
                lcqy.setBackgroundResource(R.drawable.kuang_select);
                lcqy.setTextColor(-1);
                ggqy.setTextColor(-16777216);
                ggqy.setBackgroundResource(R.drawable.kuang_un);
                Areaname=lcqy.getText().toString();
            }
        });
        this.ggqy.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                area=true;
                ggqy.setBackgroundResource(R.drawable.kuang_select);
                ggqy.setTextColor(-1);
                lcqy.setTextColor(-16777216);
                lcqy.setBackgroundResource(R.drawable.kuang_un);
                Areaname=ggqy.getText().toString();
            }
        });
        this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener()
        {
            public void onDismiss()
            {
                backgroundAlpha(1.0F);
            }
        });
        this.cz.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                Areaname="";
                area=false;
                type=false;
                Typename="6";
                ab.setBackgroundResource(R.drawable.kuang_un);
                ab.setTextColor(-16777216);
                mq.setBackgroundResource(R.drawable.kuang_un);
                mq.setTextColor(-16777216);
                sd.setTextColor(-16777216);
                sd.setBackgroundResource(R.drawable.kuang_un);
                ggqy.setBackgroundResource(R.drawable.kuang_un);
                ggqy.setTextColor(-16777216);
                lcqy.setTextColor(-16777216);
                lcqy.setBackgroundResource(R.drawable.kuang_un);
                gg.setTextColor(-16777216);
                gg.setBackgroundResource(R.drawable.kuang_un);
                bx.setTextColor(-16777216);
                bx.setBackgroundResource(R.drawable.kuang_un);
            }
        });
        this.qd.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (Typename.equals("6"))
                {
                    EventBus.getDefault().post(new BaoxiuActivity.MessageEvents( ""));
                    closePopWindow();
                    return;
                }
                EventBus.getDefault().post(new BaoxiuActivity.MessageEvents(Typename));
                closePopWindow();
            }
        });
        this.popupWindow.showAtLocation(this.select, 5, 0, 0);
        backgroundAlpha(0.7F);
        this.popupWindow.setAnimationStyle(2131689643);
            this.popupWindow.showAtLocation(this.select, 5, 0, 0);
            backgroundAlpha(0.7F);
            this.popupWindow.setAnimationStyle(2131689643);
            return;
        }


    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_baoxiu);
        initdata();

        initview();
    }


    public class MessageEvents
    {
        private String message;

        public MessageEvents(String message)
        {
            this.message = message;
        }

        public String getMessage()
        {
            return this.message;
        }

        public void setMessage(String paramString)
        {
            this.message = paramString;
        }
    }
}