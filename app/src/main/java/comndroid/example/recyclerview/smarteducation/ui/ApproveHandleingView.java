package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.HandlereturnBean;

public abstract interface ApproveHandleingView
{
    public abstract void getHandlereturnBean(HandlereturnBean paramHandlereturnBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}