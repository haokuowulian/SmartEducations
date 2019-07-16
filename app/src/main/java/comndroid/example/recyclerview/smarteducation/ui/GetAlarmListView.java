package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.BaojingBean;

public abstract interface GetAlarmListView
{
    public abstract void getBaojingBean(BaojingBean paramBaojingBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}