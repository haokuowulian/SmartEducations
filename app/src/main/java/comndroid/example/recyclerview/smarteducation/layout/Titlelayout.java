package comndroid.example.recyclerview.smarteducation.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.R.styleable;

public class Titlelayout extends LinearLayout
{
    titlelayoutClickListener clickListener;
    private ImageView imageView;
    private RelativeLayout leftButton;
    private int mLeftImage;
    private int mRightImage;
    private String mRightText;
    private int mRightTextColor;
    private int mTiltleColor;
    private String mTiltleText;
    private float mTitleTextSize;
    private RelativeLayout rightButton;
    private TextView rightText;
    private ImageView rightView;
    private TextView title;

    public Titlelayout(Context paramContext)
    {
        super(paramContext);
    }

    public Titlelayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
        View localView = LayoutInflater.from(paramContext).inflate(R.layout.titlelayout, this);
      rightButton = localView.findViewById(R.id.right);
        leftButton = ((RelativeLayout)localView.findViewById(R.id.back_2));
        imageView = ((ImageView)localView.findViewById(R.id.back_1));
        title = ((TextView)localView.findViewById(R.id.title_t1));
       rightText = ((TextView)localView.findViewById(R.id.tijiao_2));
        rightView = ((ImageView)localView.findViewById(R.id.rightview));
        TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Titlelayout);
        mTiltleText = typedArray.getString(R.styleable.Titlelayout_title);
        mLeftImage = typedArray.getResourceId(styleable.Titlelayout_leftimage, 0);
        mRightText = typedArray.getString(styleable.Titlelayout_righttext);
        mTitleTextSize = typedArray.getDimension(styleable.Titlelayout_title_size, 16.200001F);
        mRightImage = typedArray.getResourceId(styleable.Titlelayout_rightimage, 0);
        typedArray.recycle();
        rightText.setText(this.mRightText);
        imageView.setImageResource(this.mLeftImage);
        title.setText(this.mTiltleText);
        rightView.setImageResource(this.mRightImage);
        rightButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View paramView)
            {
                Titlelayout.this.clickListener.rightClick();
            }
        });
        this.leftButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View paramView)
            {
                Titlelayout.this.clickListener.leftClick();
            }
        });
    }

    public void setOntitlelayoutClickListener(titlelayoutClickListener paramtitlelayoutClickListener)
    {
        this.clickListener = paramtitlelayoutClickListener;
    }

    public static abstract interface titlelayoutClickListener
    {
        public abstract void leftClick();

        public abstract void rightClick();
    }
}
