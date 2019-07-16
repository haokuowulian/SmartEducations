package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.Loginreturns;

public abstract interface LoginVIew
{
    public abstract void getLoginreturns(Loginreturns paramLoginreturns);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}