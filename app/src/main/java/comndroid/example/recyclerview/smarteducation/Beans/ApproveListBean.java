package comndroid.example.recyclerview.smarteducation.Beans;

import java.io.Serializable;
import java.util.List;

public class ApproveListBean
        implements Serializable
{
    private approve approve;
    private String code;
    private int count;
    private List<data> data;
    private String msg;
    private int pageSize;

    public approve getApprove()
    {
        return this.approve;
    }

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

    public int getPageSize()
    {
        return this.pageSize;
    }

    public void setApprove(approve paramapprove)
    {
        this.approve = paramapprove;
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

    public void setPageSize(int paramInt)
    {
        this.pageSize = paramInt;
    }

    public class approve
            implements Serializable
    {
        private String appStatus;
        private String deleted;
        private String distId;

        public approve()
        {
        }

        public String getAppStatus()
        {
            return this.appStatus;
        }

        public String getDeleted()
        {
            return this.deleted;
        }

        public String getDistId()
        {
            return this.distId;
        }

        public void setAppStatus(String paramString)
        {
            this.appStatus = paramString;
        }

        public void setDeleted(String paramString)
        {
            this.deleted = paramString;
        }

        public void setDistId(String paramString)
        {
            this.distId = paramString;
        }
    }

    public class data
            implements Serializable
    {
        private String appStatus;
        private String createDate;
        private String creator;
        private String deleted;
        private String deptName;
        private String endDate;
        private String howlong;
        private String id;
        private String incident;
        private int leaveType;
        private String onelevelId;
        private String readyStatus;
        private String realName;
        private String startDate;
        private String userId;

        public data()
        {
        }

        public String getAppStatus()
        {
            return this.appStatus;
        }

        public String getCreateDate()
        {
            return this.createDate;
        }

        public String getCreator()
        {
            return this.creator;
        }

        public String getDeleted()
        {
            return this.deleted;
        }

        public String getDeptName()
        {
            return this.deptName;
        }

        public String getEndDate()
        {
            return this.endDate;
        }

        public String getHowlong()
        {
            return this.howlong;
        }

        public String getId()
        {
            return this.id;
        }

        public String getIncident()
        {
            return this.incident;
        }

        public int getLeaveType()
        {
            return this.leaveType;
        }

        public String getOnelevelId()
        {
            return this.onelevelId;
        }

        public String getReadyStatus()
        {
            return this.readyStatus;
        }

        public String getRealName()
        {
            return this.realName;
        }

        public String getStartDate()
        {
            return this.startDate;
        }

        public String getUserId()
        {
            return this.userId;
        }

        public void setAppStatus(String paramString)
        {
            this.appStatus = paramString;
        }

        public void setCreateDate(String paramString)
        {
            this.createDate = paramString;
        }

        public void setCreator(String paramString)
        {
            this.creator = paramString;
        }

        public void setDeleted(String paramString)
        {
            this.deleted = paramString;
        }

        public void setDeptName(String paramString)
        {
            this.deptName = paramString;
        }

        public void setEndDate(String paramString)
        {
            this.endDate = paramString;
        }

        public void setHowlong(String paramString)
        {
            this.howlong = paramString;
        }

        public void setId(String paramString)
        {
            this.id = paramString;
        }

        public void setIncident(String paramString)
        {
            this.incident = paramString;
        }

        public void setLeaveType(int paramInt)
        {
            this.leaveType = paramInt;
        }

        public void setOnelevelId(String paramString)
        {
            this.onelevelId = paramString;
        }

        public void setReadyStatus(String paramString)
        {
            this.readyStatus = paramString;
        }

        public void setRealName(String paramString)
        {
            this.realName = paramString;
        }

        public void setStartDate(String paramString)
        {
            this.startDate = paramString;
        }

        public void setUserId(String paramString)
        {
            this.userId = paramString;
        }
    }
}