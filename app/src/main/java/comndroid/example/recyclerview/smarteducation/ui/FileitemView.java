package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.FileitemBean;

public abstract interface FileitemView
{
    public abstract void getFileitemBean(FileitemBean paramFileitemBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}