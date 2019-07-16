package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.RoomBean;

public abstract interface GetRoomListView
{
    public abstract void getRoomBean(RoomBean paramRoomBean);

    public abstract void geterror(Throwable paramThrowable, String paramString);
}