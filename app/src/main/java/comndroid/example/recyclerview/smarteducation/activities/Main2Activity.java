package comndroid.example.recyclerview.smarteducation.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.Fragments.Mainfragment;
import comndroid.example.recyclerview.smarteducation.Fragments.MyFragment;
import comndroid.example.recyclerview.smarteducation.Fragments.QjryFragment;
import comndroid.example.recyclerview.smarteducation.R;

public class Main2Activity extends BaseActity
        implements View.OnClickListener
{

    @BindView(R.id.gongzuo)
    RelativeLayout gongzuo;

    @BindView(R.id.pingjia_text)
    TextView leftText;

    @BindView(R.id.pingjia_image)
    ImageView leftimage;

    @BindView(R.id.shouye_iv)
    ImageView midImage;

    @BindView(R.id.shouye_text)
    TextView midText;

    @BindView(R.id.qjry)
    RelativeLayout qjry;

    @BindView(R.id.wode_iv)
    ImageView rightImage;

    @BindView(R.id.wode_text)
    TextView rightText;

    @BindView(R.id.wode)
    RelativeLayout wode;

    public void initview()
    {
        addActivity(this);
        ButterKnife.bind(this);
        this.qjry.setOnClickListener(this);
        this.gongzuo.setOnClickListener(this);
        this.wode.setOnClickListener(this);
        replaceFragment(new Mainfragment());
    }

    @SuppressLint({"ResourceAsColor"})
    public void onClick(View paramView)
    {
        switch (paramView.getId()){
            case R.id.wode:
                replaceFragment(new MyFragment());
                this.leftimage.setImageResource(R.mipmap.tabbar_btn_qjry);
                this.leftText.setTextColor(2131034199);
                this.midImage.setImageResource(R.mipmap.tabbar_btn_work);
                this.midText.setTextColor(2131034199);
                this.rightImage.setImageResource(R.mipmap.tabbar_btn_person_act);
                this.rightText.setTextColor(2131034269);
                break;
            case R.id.qjry:
                //QjryFragment
                replaceFragment(new QjryFragment());
                this.leftimage.setImageResource(R.mipmap.tabbar_btn_qjry_nav);
                this.leftText.setTextColor(2131034269);
                this.midImage.setImageResource(R.mipmap.tabbar_btn_work);
                this.midText.setTextColor(2131034199);
                this.rightImage.setImageResource(R.mipmap.tabbar_btn_person);
                this.rightText.setTextColor(2131034199);
                break;
            case R.id.gongzuo:
                replaceFragment(new Mainfragment());
                this.leftimage.setImageResource(R.mipmap.tabbar_btn_qjry);
                this.leftText.setTextColor(2131034199);
                this.midImage.setImageResource(R.mipmap.tabbar_gz_act);
                this.midText.setTextColor(2131034269);
                this.rightImage.setImageResource(R.mipmap.tabbar_btn_person);
                this.rightText.setTextColor(2131034199);
                break;
        }


    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_main2);
        initview();
    }

    public void replaceFragment(Fragment paramFragment)
    {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.replace(R.id.shouye_zhuanghuan, paramFragment);
        localFragmentTransaction.commit();
    }
}
