package comndroid.example.recyclerview.smarteducation.presenter;

import java.io.File;
import java.util.List;

public abstract interface UploadFilePresenter
{
    public abstract void upload(List<File> paramList);
}