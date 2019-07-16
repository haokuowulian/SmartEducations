package comndroid.example.recyclerview.smarteducation.Beans;

import java.io.Serializable;
import java.util.List;

public class RoomBean
        implements Serializable
{
    private List<data> data;
    private boolean success;

    public List<data> getData()
    {
        return this.data;
    }

    public boolean isSuccess()
    {
        return this.success;
    }

    public void setData(List<data> paramList)
    {
        this.data = paramList;
    }

    public void setSuccess(boolean paramBoolean)
    {
        this.success = paramBoolean;
    }

    public class data
            implements Serializable
    {
        private String roomId;
        private String roomNo;

        public data()
        {
        }

        public String getRoomId()
        {
            return this.roomId;
        }

        public String getRoomNo()
        {
            return this.roomNo;
        }

        public void setRoomId(String paramString)
        {
            this.roomId = paramString;
        }

        public void setRoomNo(String paramString)
        {
            this.roomNo = paramString;
        }
    }
}