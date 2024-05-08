package com.wangmai.common.nativepot;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Permission {
    public String description;
    public String permissionValue;
    public String title;

    public String getDescription() {
        return this.description;
    }

    public String getPermissionValue() {
        return this.permissionValue;
    }

    public String getTitle() {
        return this.title;
    }

    public Permission setDescription(String str) {
        this.description = str;
        return this;
    }

    public Permission setPermissionValue(String str) {
        this.permissionValue = str;
        return this;
    }

    public Permission setTitle(String str) {
        this.title = str;
        return this;
    }
}
