package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.BuildingBean;

public abstract interface GetBulidingListView
{
    public abstract void getBuildingListBean(BuildingBean paramBuildingBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}