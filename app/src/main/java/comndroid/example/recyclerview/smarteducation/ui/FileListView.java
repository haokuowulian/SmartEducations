package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.FileListBean;

public abstract interface FileListView
{
    public abstract void getFileListBean(FileListBean paramFileListBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}