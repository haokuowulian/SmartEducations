package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.Addqingjiabean;

public abstract interface AddqingjiaView
{
    public abstract void getAddqingbean(Addqingjiabean paramAddqingjiabean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}