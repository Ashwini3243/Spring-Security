package com.nendrasys.model;

public class Password {
    private String oldPassword;
    private String newPassword;

    public String getConfirmNewPassword() {
        return ConfirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        ConfirmNewPassword = confirmNewPassword;
    }

    private String ConfirmNewPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }


    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "Password{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", ConfirmNewPassword='" + ConfirmNewPassword + '\'' +
                '}';
    }
}
