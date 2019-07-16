package comndroid.example.recyclerview.smarteducation.ui;

import comndroid.example.recyclerview.smarteducation.Beans.AirReturnBean;

public interface GetAirView {
    public void getAirReturnBean(AirReturnBean airReturnBean);
    public void getError(String msg,Throwable error);
}
