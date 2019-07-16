package comndroid.example.recyclerview.smarteducation.Beans;

import java.io.Serializable;

public class Loginreturns
        implements Serializable
{
    private String deptName;
    private int distId;
    private String distName;
    private String realName;
    private String sex;
    private boolean success;
    private String token;
    private String userId;
    private String userName;

    public int  getDeptId() {
        return deptId;
    }

    public void setDeptId(int  deptId) {
        this.deptId = deptId;
    }

    private int userType;
    private String userTypeName;
  private int  deptId;
    public String getDeptName()
    {
        return this.deptName;
    }

    public int getDistId()
    {
        return this.distId;
    }

    public String getDistName()
    {
        return this.distName;
    }

    public String getRealName()
    {
        return this.realName;
    }

    public String getSex()
    {
        return this.sex;
    }

    public String getToken()
    {
        return this.token;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public int getUserType()
    {
        return this.userType;
    }

    public String getUserTypeName()
    {
        return this.userTypeName;
    }

    public boolean isSuccess()
    {
        return this.success;
    }

    public void setDeptName(String paramString)
    {
        this.deptName = paramString;
    }

    public void setDistId(int paramInt)
    {
        this.distId = paramInt;
    }

    public void setDistName(String paramString)
    {
        this.distName = paramString;
    }

    public void setRealName(String paramString)
    {
        this.realName = paramString;
    }

    public void setSex(String paramString)
    {
        this.sex = paramString;
    }

    public void setSuccess(boolean paramBoolean)
    {
        this.success = paramBoolean;
    }

    public void setToken(String paramString)
    {
        this.token = paramString;
    }

    public void setUserId(String paramString)
    {
        this.userId = paramString;
    }

    public void setUserName(String paramString)
    {
        this.userName = paramString;
    }

    public void setUserType(int paramInt)
    {
        this.userType = paramInt;
    }

    public void setUserTypeName(String paramString)
    {
        this.userTypeName = paramString;
    }
}
