package comndroid.example.recyclerview.smarteducation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout;
import comndroid.example.recyclerview.smarteducation.layout.Titlelayout.titlelayoutClickListener;

public class WodeshezhiActivity extends BaseActity
        implements View.OnClickListener
{
    private boolean f = false;

    @BindView(R.id.tuichudenglu)
    TextView tc;

    @BindView(R.id.titlelayout_1)
    Titlelayout titlelayout;

    @BindView(R.id.xiugaimima1)
    LinearLayout xgmm;

    @BindView(R.id.xiaoxitongzhi)
    ImageView xiaoxi;

    public void initview()
    {
        addActivity(this);
        ButterKnife.bind(this);
        this.xgmm.setOnClickListener(this);
        this.tc.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                finishAllActivity();
            }
        });
        this.titlelayout.setOntitlelayoutClickListener(new Titlelayout.titlelayoutClickListener()
        {
            public void leftClick()
            {
                WodeshezhiActivity.this.finish();
            }

            public void rightClick()
            {
            }
        });
        this.xiaoxi.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (!WodeshezhiActivity.this.f)
                {
                           f=true;
                            WodeshezhiActivity.this.xiaoxi.setImageResource(R.mipmap.btn_sz_open);
                    return;
                }
                f=false;
                WodeshezhiActivity.this.xiaoxi.setImageResource(R.mipmap.btn_sz_close);
            }
        });
    }

    public void onClick(View paramView)
    {
        startActivity(new Intent(this, XiugaimimaActivity.class));
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_wodeshezhi);
        initview();
    }
}