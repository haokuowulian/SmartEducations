package comndroid.example.recyclerview.smarteducation.Beans;

import java.io.Serializable;
import java.util.List;

public class XiajiBean
        implements Serializable
{
    private boolean success;
    public List<userList> userList;

    public List<userList> getUserList()
    {
        return this.userList;
    }

    public boolean isSuccess()
    {
        return this.success;
    }

    public void setSuccess(boolean paramBoolean)
    {
        this.success = paramBoolean;
    }

    public void setUserList(List<userList> paramList)
    {
        this.userList = paramList;
    }

    public class userList
            implements Serializable
    {
        private String deptId;
        private String id;
        private String realName;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        private boolean checked=false;
        public userList()
        {
        }

        public String getDeptId()
        {
            return this.deptId;
        }

        public String getId()
        {
            return this.id;
        }

        public String getRealName()
        {
            return this.realName;
        }

        public void setDeptId(String paramString)
        {
            this.deptId = paramString;
        }

        public void setId(String paramString)
        {
            this.id = paramString;
        }

        public void setRealName(String paramString)
        {
            this.realName = paramString;
        }
    }
}