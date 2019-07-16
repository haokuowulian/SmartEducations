package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.AlarmHandleBean;

public abstract interface AlarmHandleView
{
    public abstract void getAlarmHandleBean(AlarmHandleBean paramAlarmHandleBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}