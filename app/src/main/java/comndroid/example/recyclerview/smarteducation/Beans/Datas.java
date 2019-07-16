package comndroid.example.recyclerview.smarteducation.Beans;

import java.nio.file.Path;

public class Datas {
    private String leaveType;
    private String incident;
    private String startDate;
    private String endDate;
    private String howlong;
    private String realName;

    public Datas(String leaveType, String incident, String startDate, String endDate, String howlong, String realName, String appStatus, String deptName, String onelevelId, String twolevelId) {
        this.leaveType = leaveType;
        this.incident = incident;
        this.startDate = startDate;
        this.endDate = endDate;
        this.howlong = howlong;
        this.realName = realName;
        this.appStatus = appStatus;
        this.deptName = deptName;
        this.onelevelId = onelevelId;
        this.twolevelId = twolevelId;
    }

    private String appStatus;
    private String deptName;

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHowlong() {
        return howlong;
    }

    public void setHowlong(String howlong) {
        this.howlong = howlong;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOnelevelId() {
        return onelevelId;
    }

    public void setOnelevelId(String onelevelId) {
        this.onelevelId = onelevelId;
    }

    public String getTwolevelId() {
        return twolevelId;
    }

    public void setTwolevelId(String twolevelId) {
        this.twolevelId = twolevelId;
    }



    private String onelevelId;
    private String twolevelId;
}
