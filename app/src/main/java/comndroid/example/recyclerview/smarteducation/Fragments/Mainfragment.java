package comndroid.example.recyclerview.smarteducation.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import comndroid.example.recyclerview.smarteducation.Beans.AirReturnBean;
import comndroid.example.recyclerview.smarteducation.Beans.ShangjiBean;
import comndroid.example.recyclerview.smarteducation.Beans.XiajiBean;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.Utils.SPHelper;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;
import comndroid.example.recyclerview.smarteducation.activities.BaojingListActivity;
import comndroid.example.recyclerview.smarteducation.activities.BaoxiuActivity;
import comndroid.example.recyclerview.smarteducation.activities.GwfsActivity;
    import comndroid.example.recyclerview.smarteducation.activities.GwjsActivity;
import comndroid.example.recyclerview.smarteducation.activities.JiaoshiqingjiaActivity;
import comndroid.example.recyclerview.smarteducation.activities.MyapproveListActivity;
import comndroid.example.recyclerview.smarteducation.activities.QjclActivity;
import comndroid.example.recyclerview.smarteducation.activities.WupinbaoxiuActivity;
import comndroid.example.recyclerview.smarteducation.activities.XueshengqingjiaActivity;
import comndroid.example.recyclerview.smarteducation.layout.FiveTextView;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.presenter.GetAirImp;
import comndroid.example.recyclerview.smarteducation.presenter.GetAirPresenter;
import comndroid.example.recyclerview.smarteducation.presenter.ListSubUserImp;
import comndroid.example.recyclerview.smarteducation.presenter.ListSubUserPresenter;
import comndroid.example.recyclerview.smarteducation.presenter.ShangjiImp;
import comndroid.example.recyclerview.smarteducation.presenter.ShangjiPresenter;
import comndroid.example.recyclerview.smarteducation.ui.GetAirView;
import comndroid.example.recyclerview.smarteducation.ui.ListSubUserView;
import comndroid.example.recyclerview.smarteducation.ui.ShangjiView;
import java.util.ArrayList;
import java.util.List;

public class Mainfragment extends Fragment
            implements OnBannerListener, OnClickListener, ListSubUserView, ShangjiView, GetAirView {
    private int REQUEST_FILE = 1;
    private Banner banner;
    private FiveTextView fiveTextView;
    private RelativeLayout bjcl;
    private RelativeLayout bxcl;
    private RelativeLayout gwfs;
    private RelativeLayout gwjs;
    private List<Integer> images = new ArrayList();
    private RelativeLayout jsqj;

    private GetAirPresenter getAirPresenter;
    private ListSubUserPresenter listSubUserPresenter;
    private RelativeLayout qjcl;
    private ShangjiBean shangjiBean;
    private ShangjiPresenter shangjiPresenter;
    private String token = SPHelper.getInstance().getString("token", "");
    private String userId = SPHelper.getInstance().getString("userId", "");
        private int userType = SPHelper.getInstance().getInt("userType", 0);
    private int usertpye = SPHelper.getInstance().getInt("userType", 1);
    private int deptId=SPHelper.getInstance().getInt("deptId", 1);
    private RelativeLayout wdqj;
    private RelativeLayout wpbx;
    private XiajiBean xiajiBean;
    private RelativeLayout xsqj;
    private Titlelayout title;
    public void OnBannerClick(int paramInt) {
    }

    public void getError(Throwable paramThrowable, String paramString) {
    }

    public void getShangjibean(ShangjiBean paramShangjiBean) {
        this.shangjiBean = paramShangjiBean;
    }

    public void getXiajiBean(XiajiBean paramXiajiBean) {
        if (paramXiajiBean.isSuccess())
            this.xiajiBean = paramXiajiBean;

    }

    public void geterror(Throwable paramThrowable, String paramString) {
        ToastUtils.showShort("错误");
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
            case R.id.xsqj:
                startActivity(new Intent(getContext(), XueshengqingjiaActivity.class));
                return;
            case R.id.bxcl:
                switch (usertpye){
                    case  10:
                        ToastUtils.showShort("您的权限不匹配");
                        break;
                    case 11:
                        startActivity(new Intent(getContext(), BaoxiuActivity.class));
                        break;
                }
                break;
            case R.id.wdqj:
                startActivity(new Intent(getContext(), MyapproveListActivity.class));
                break;
            case R.id.qjcl:
                startActivity(new Intent(getContext(), QjclActivity.class));
                return;

            case R.id.jsqj:
                switch (usertpye){
                    case 10:
                        Intent intent = new Intent(getContext(), JiaoshiqingjiaActivity.class);
                        intent.putExtra("shangjibean", this.shangjiBean);
                        startActivity(intent);
                        break;
                    case 11:
                        ToastUtils.showShort("您的权限不匹配该功能");
                        break;
                }
                break;
                case R.id.gwjs:
                startActivity(new Intent(getContext(), GwjsActivity.class));
                break;
            case R.id.gwfs:
                //deptid
     if(usertpye==10){

         switch (deptId) {
             case 9:
                 Intent intent2 = new Intent(getContext(), GwfsActivity.class);
                 intent2.putExtra("xiajibean", this.xiajiBean);
                 startActivity(intent2);
                 break;
             case 10:
                 Intent intent1 = new Intent(getContext(), GwfsActivity.class);
                 intent1.putExtra("xiajibean", this.xiajiBean);
                 startActivity(intent1);
                 break;
             case 11:
                 ToastUtils.showShort("您的权限不匹配该功能");
                 break;
         }
     }
     break;


            case R.id.wpbx:
                startActivity(new Intent(getContext(), WupinbaoxiuActivity.class));
                return;
            case R.id.bjcl:
                        startActivity(new Intent(getContext(), BaojingListActivity.class));
                        break;


        }
    }

    @SuppressLint({"ResourceAsColor"})
    @Nullable
    public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
        View view = paramLayoutInflater.inflate(R.layout.mainfragment, null);
        this.listSubUserPresenter = new ListSubUserImp(this);
        getAirPresenter=new GetAirImp(this);
        this.shangjiPresenter = new ShangjiImp(this);
        this.listSubUserPresenter.get(this.userId, this.token, "20");
        getAirPresenter.get(userId,token,"20");
        this.shangjiPresenter.huoqu(this.userId, this.token, "20");
        this.banner = ((Banner) view.findViewById(R.id.banner));
        this.jsqj = ((RelativeLayout) view.findViewById(R.id.jsqj));
        title=view.findViewById(R.id.title);
        this.xsqj = ((RelativeLayout) view.findViewById(R.id.xsqj));
        fiveTextView=view.findViewById(R.id.filetext);

        this.wdqj = ((RelativeLayout) view.findViewById(R.id.wdqj));
        this.gwjs = ((RelativeLayout) view.findViewById(R.id.gwjs));
        this.gwfs = ((RelativeLayout) view.findViewById(R.id.gwfs));
        this.wpbx = ((RelativeLayout) view.findViewById(R.id.wpbx));
        this.qjcl = ((RelativeLayout) view.findViewById(R.id.qjcl));
        this.bjcl = ((RelativeLayout) view.findViewById(R.id.bjcl));
        this.bxcl = ((RelativeLayout) view.findViewById(R.id.bxcl));
        this.bxcl.setOnClickListener(this);
        this.wpbx.setOnClickListener(this);
        this.gwjs.setOnClickListener(this);
        this.gwfs.setOnClickListener(this);
        this.jsqj.setOnClickListener(this);
        this.xsqj.setOnClickListener(this);
        this.wdqj.setOnClickListener(this);
        this.qjcl.setOnClickListener(this);
        this.bjcl.setOnClickListener(this);
        this.banner.setBannerStyle(1);
        title.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener() {
            @Override
            public void leftClick() {

            }

            @Override
            public void rightClick() {

            }
        });
        this.banner.setImageLoader(new GlideImageLoder());
        this.images.add(Integer.valueOf(R.mipmap.banner));
        this.images.add(Integer.valueOf(R.mipmap.banner));
        this.images.add(Integer.valueOf(R.mipmap.banner));
        this.images.add(Integer.valueOf(R.mipmap.banner));
        this.images.add(Integer.valueOf(R.mipmap.banner));
        this.banner.setImages(this.images);
        this.banner.setBannerAnimation(Transformer.DepthPage);
        this.banner.isAutoPlay(true);
        this.banner.setDelayTime(1500);
        this.banner.setIndicatorGravity(6);
        this.banner.setOnBannerListener(this);
        this.banner.start();
        return view;
    }

    @Override
    public void getAirReturnBean(AirReturnBean airReturnBean) {
        if(airReturnBean.isSuccess()){
            fiveTextView.initScrollTextView(getActivity().getWindowManager(), airReturnBean.getAirList(), 1);
            fiveTextView.starScroll();
        }
    }

    @Override
    public void getError(String msg, Throwable error) {

    }

    public class GlideImageLoder extends ImageLoader
        {
        public GlideImageLoder()
        {
        }

        public void displayImage(Context paramContext, Object paramObject, ImageView paramImageView)
        {
            Glide.with(paramContext).load(paramObject).into(paramImageView);
        }
    }
}
