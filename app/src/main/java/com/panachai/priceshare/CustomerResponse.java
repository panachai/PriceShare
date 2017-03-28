package com.panachai.priceshare;

/**
 * Created by KILLERCON on 3/29/2017.
 */

public class CustomerResponse {


    /**
     * cusID : 1
     * cusName : panachai
     * cusStatus : 0
     * cusUser : pana
     * cusPass : 1234
     * cusEmail : pana@gmail.com
     */

    private int cusID;
    private String cusName;
    private int cusStatus;
    private String cusUser;
    private String cusPass;
    private String cusEmail;

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(int cusStatus) {
        this.cusStatus = cusStatus;
    }

    public String getCusUser() {
        return cusUser;
    }

    public void setCusUser(String cusUser) {
        this.cusUser = cusUser;
    }

    public String getCusPass() {
        return cusPass;
    }

    public void setCusPass(String cusPass) {
        this.cusPass = cusPass;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }
}
