package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.AddRepairBean;

public abstract interface AddRepairView
{
    public abstract void getAddrepairBean(AddRepairBean paramAddRepairBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}