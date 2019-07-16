package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.UplaodBean;

public abstract interface UploadView
{
    public abstract void getUploadBean(UplaodBean paramUplaodBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}