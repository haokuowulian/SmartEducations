package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.Baoxiuitembean;

public abstract interface InfoRepairView
{
    public abstract void getBaoxiuitembean(Baoxiuitembean paramBaoxiuitembean);

    public abstract void getError(Throwable paramThrowable, String paramString);
}
