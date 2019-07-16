package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.ApproveItemBean;

public abstract interface ApproveItemView
{
    public abstract void getApproveItemBean(ApproveItemBean paramApproveItemBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}