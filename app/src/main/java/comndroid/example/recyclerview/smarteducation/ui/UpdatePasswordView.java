package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.ForgetPasswordbean;

public abstract interface UpdatePasswordView
{
    public abstract void getForgetPasswordbean(ForgetPasswordbean paramForgetPasswordbean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}