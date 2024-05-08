package com.alibaba.security.realidentity.oss.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum ObjectPermission {
    Private("private"),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write"),
    Default("default"),
    Unknown("");

    private String permissionString;

    ObjectPermission(String str) {
        this.permissionString = str;
    }

    public static ObjectPermission parsePermission(String str) {
        ObjectPermission[] objectPermissionArr = {Private, PublicRead, PublicReadWrite, Default};
        for (int i10 = 0; i10 < 4; i10++) {
            ObjectPermission objectPermission = objectPermissionArr[i10];
            if (objectPermission.permissionString.equals(str)) {
                return objectPermission;
            }
        }
        return Unknown;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.permissionString;
    }
}
