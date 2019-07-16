package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.ApproveListBean;

public abstract interface ApproveListView
{
    public abstract void getApproveListBean(ApproveListBean paramApproveListBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}
