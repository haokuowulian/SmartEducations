package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.XiajiBean;

public abstract interface ListSubUserView
{
    public abstract void getError(Throwable paramThrowable, String paramString);

    public abstract void getXiajiBean(XiajiBean paramXiajiBean);
}