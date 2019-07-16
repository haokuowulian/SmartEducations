package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.MyapproveListBean;

public abstract interface MyapproveListView
{
    public abstract void geterror(Throwable paramThrowable, String paramString);

    public abstract void getmyapproveListbean(MyapproveListBean paramMyapproveListBean);
}