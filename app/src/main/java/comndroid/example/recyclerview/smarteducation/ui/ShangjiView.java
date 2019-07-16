package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.ShangjiBean;

public abstract interface ShangjiView
{
    public abstract void getShangjibean(ShangjiBean paramShangjiBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}
