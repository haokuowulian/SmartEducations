package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.Baoxiubeans;

public abstract interface MyRepairListPresenterView
{
    public abstract void getBaoxiubeans(Baoxiubeans paramBaoxiubeans);

    public abstract void getError(Throwable paramThrowable, String paramString);
}