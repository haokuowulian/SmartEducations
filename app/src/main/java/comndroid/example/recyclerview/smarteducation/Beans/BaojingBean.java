package comndroid.example.recyclerview.smarteducation.Beans;

import java.io.Serializable;
import java.util.List;

public class BaojingBean
        implements Serializable
{
    private String code;
    private int count;
    private List<data> data;
    private String msg;
    private int pageIndex;
    private int pageSize;

    public String getCode()
    {
        return this.code;
    }

    public int getCount()
    {
        return this.count;
    }

    public List<data> getData()
    {
        return this.data;
    }

    public String getMsg()
    {
        return this.msg;
    }

    public int getPageIndex()
    {
        return this.pageIndex;
    }

    public int getPageSize()
    {
        return this.pageSize;
    }

    public void setCode(String paramString)
    {
        this.code = paramString;
    }

    public void setCount(int paramInt)
    {
        this.count = paramInt;
    }

    public void setData(List<data> paramList)
    {
        this.data = paramList;
    }

    public void setMsg(String paramString)
    {
        this.msg = paramString;
    }

    public void setPageIndex(int paramInt)
    {
        this.pageIndex = paramInt;
    }

    public void setPageSize(int paramInt)
    {
        this.pageSize = paramInt;
    }

    public class data
            implements Serializable
    {
        private String alarmImage;

        public String getAlarmImage() {
            return alarmImage;
        }

        public void setAlarmImage(String alarmImage) {
            this.alarmImage = alarmImage;
        }

        private String address;
        private String alarmOrigin;
        private String alarmTime;
        private String alarmType;
        private int confirmResult;
        private String content;
        private String deleted;
        private String deviceCode;
        private String deviceId;
        private String distId;
        private String id;
        private String image;
        private int isConfirmed;
        private String report;
        private int sign;

        public data()
        {
        }

        public String getAddress()
        {
            return this.address;
        }

        public String getAlarmOrigin()
        {
            return this.alarmOrigin;
        }

        public String getAlarmTime()
        {
            return this.alarmTime;
        }

        public String getAlarmType()
        {
            return this.alarmType;
        }

        public int getConfirmResult()
        {
            return this.confirmResult;
        }

        public String getContent()
        {
            return this.content;
        }

        public String getDeleted()
        {
            return this.deleted;
        }

        public String getDeviceCode()
        {
            return this.deviceCode;
        }

        public String getDeviceId()
        {
            return this.deviceId;
        }

        public String getDistId()
        {
            return this.distId;
        }

        public String getId()
        {
            return this.id;
        }

        public String getImage()
        {
            return this.image;
        }

        public int getIsConfirmed()
        {
            return this.isConfirmed;
        }

        public String getReport()
        {
            return this.report;
        }

        public int getSign()
        {
            return this.sign;
        }

        public void setAddress(String paramString)
        {
            this.address = paramString;
        }

        public void setAlarmOrigin(String paramString)
        {
            this.alarmOrigin = paramString;
        }

        public void setAlarmTime(String paramString)
        {
            this.alarmTime = paramString;
        }

        public void setAlarmType(String paramString)
        {
            this.alarmType = paramString;
        }

        public void setConfirmResult(int paramInt)
        {
            this.confirmResult = paramInt;
        }

        public void setContent(String paramString)
        {
            this.content = paramString;
        }

        public void setDeleted(String paramString)
        {
            this.deleted = paramString;
        }

        public void setDeviceCode(String paramString)
        {
            this.deviceCode = paramString;
        }

        public void setDeviceId(String paramString)
        {
            this.deviceId = paramString;
        }

        public void setDistId(String paramString)
        {
            this.distId = paramString;
        }

        public void setId(String paramString)
        {
            this.id = paramString;
        }

        public void setImage(String paramString)
        {
            this.image = paramString;
        }

        public void setIsConfirmed(int paramInt)
        {
            this.isConfirmed = paramInt;
        }

        public void setReport(String paramString)
        {
            this.report = paramString;
        }

        public void setSign(int paramInt)
        {
            this.sign = paramInt;
        }
    }
}