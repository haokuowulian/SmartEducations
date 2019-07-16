package comndroid.example.recyclerview.smarteducation.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import comndroid.example.recyclerview.smarteducation.Adapter.CityselectAdapter;
import comndroid.example.recyclerview.smarteducation.Adapter.CityselectAdapter.OnItemClickListeners;
import comndroid.example.recyclerview.smarteducation.R;
import comndroid.example.recyclerview.smarteducation.R.styleable;
import comndroid.example.recyclerview.smarteducation.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Xialaliebiao extends LinearLayout
{
    private Activity activity;
    private AttributeSet attrs;
    private Context context;
    private Map<String, String> goodsType;
    private List<Map<String, String>> list = new ArrayList();
    private String mName;
    private TextView name;
    private PopupWindow popupWindow = null;
    private View view;
    private XiaClickListener xiaClickListener;

    public Xialaliebiao(Context paramContext)
    {
        this(paramContext, null);
    }

    public Xialaliebiao(Context paramContext, @Nullable AttributeSet paramAttributeSet)
    {
        this(paramContext, paramAttributeSet, 0);
    }

    public Xialaliebiao(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        this.context = paramContext;
        this.view = LayoutInflater.from(paramContext).inflate(R.layout.xiaolaliebiao, this);
        TypedArray typedArray=context.obtainStyledAttributes(paramAttributeSet, R.styleable.Xialaliebiao);
        this.name = ((TextView)this.view.findViewById(R.id.name));
        mName=typedArray.getString(styleable.Xialaliebiao_dd);
        this.name.setText(this.mName);
        this.view.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                if (Xialaliebiao.this.popupWindow == null&&list.size()>0)
                {
                    Xialaliebiao.this.showPopWindow();
                    return;
                }
                if(popupWindow!=null){
                    if (Xialaliebiao.this.popupWindow.isShowing())
                    {
                        Xialaliebiao.this.popupWindow.dismiss();
                        return;
                    }
                    else {
                        ToastUtils.showShort("请先选择地址类型");

                    }
                }else if(list.size()>0){
                    Xialaliebiao.this.popupWindow.showAtLocation(Xialaliebiao.this.view, 81, 0, 0);

                }else {
                    ToastUtils.showShort("请先选择地址类型");
                }

            }
        });
    }

    private void closePopWindow()
    {
        this.popupWindow.dismiss();
        this.popupWindow = null;
        backgroundAlpha(1.0F);
    }

    public void SetOnXiaClickListener(XiaClickListener paramXiaClickListener)
    {
        this.xiaClickListener = paramXiaClickListener;
    }

    public void backgroundAlpha(float paramFloat)
    {
        WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
        localLayoutParams.alpha = paramFloat;
        getActivity().getWindow().setAttributes(localLayoutParams);
        getActivity().getWindow().addFlags(2);
    }

    public Activity getActivity()
    {
        return this.activity;
    }

    public Map<String, String> getGoodsType()
    {
        return this.goodsType;
    }

    public List<Map<String, String>> getList()
    {
        return this.list;
    }

    public void setActivity(Activity paramActivity)
    {
        this.activity = paramActivity;
    }

    public void setGoodsType(Map<String, String> paramMap)
    {
        this.goodsType = paramMap;
    }

    public void setList(List<Map<String, String>> paramList)
    {
        this.list = paramList;
    }

    public void showPopWindow()
    {
         View view = LayoutInflater.from(context).inflate(R.layout.popwindowrecyclerview, null, false);
        RecyclerView localRecyclerView =view.findViewById(R.id.recyclerview);
        LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
        localLinearLayoutManager.setOrientation(1);
        CityselectAdapter localCityselectAdapter = new CityselectAdapter(this.list);
        localRecyclerView.setLayoutManager(localLinearLayoutManager);
        localRecyclerView.addItemDecoration(new SpaceItemDecoration(5));
        localCityselectAdapter.setmItemClickListener(new CityselectAdapter.OnItemClickListeners()
        {
            public void onItemClick(Map<String, String> paramMap)
            {
                Xialaliebiao localXialaliebiao = new Xialaliebiao(Xialaliebiao.this.context);
                Iterator localIterator = paramMap.entrySet().iterator();
                while (localIterator.hasNext())
                {
                    Object localObject = (Map.Entry)localIterator.next();
                    String str = (String)((Map.Entry)localObject).getKey();
                    localObject = (String)((Map.Entry)localObject).getValue();
                    Xialaliebiao.this.name.setText(str);
                    if (Xialaliebiao.this.xiaClickListener == null)
                        continue;

                        Xialaliebiao.this.xiaClickListener.run((String)localObject);

                }
                localXialaliebiao.setGoodsType(paramMap);
                Xialaliebiao.this.closePopWindow();
            }
        });
        localRecyclerView.setAdapter(localCityselectAdapter);
        this.popupWindow = new PopupWindow((View)view, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
        this.popupWindow = new PopupWindow((View)view, -1, -2);
        this.popupWindow.setOutsideTouchable(true);
        this.popupWindow.setFocusable(true);
        this.popupWindow.showAtLocation(this.view, 81, 0, 0);
        this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener()
        {
            public void onDismiss()
            {
                Xialaliebiao.this.closePopWindow();
            }
        });
        backgroundAlpha(0.5F);
    }

    class SpaceItemDecoration extends RecyclerView.ItemDecoration
    {
        int mSpace;

        public SpaceItemDecoration(int arg2)
        {
            int i = 0;
            this.mSpace = i;
        }

        public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
        {
            super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
            paramRect.left = this.mSpace;
            paramRect.right = this.mSpace;
            paramRect.bottom = this.mSpace;
            if (paramRecyclerView.getChildAdapterPosition(paramView) == 0)
                paramRect.top = this.mSpace;
        }
    }

    public static abstract interface XiaClickListener
    {
        public abstract void run(String paramString);
    }
}