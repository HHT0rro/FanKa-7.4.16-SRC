package com.huawei.hms.support.api.entity.push;

import com.alipay.sdk.util.i;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ProfileReq implements IMessageEntity {

    @Packed
    private int operation;

    @Packed
    private String pkgName;

    @Packed
    private String profileId;

    @Packed
    private String subjectId;

    @Packed
    private int type;

    public int getOperation() {
        return this.operation;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public int getType() {
        return this.type;
    }

    public void setOperation(int i10) {
        this.operation = i10;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setProfileId(String str) {
        this.profileId = str;
    }

    public void setSubjectId(String str) {
        this.subjectId = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public String toString() {
        return getClass().getName() + "{ pkgName: " + this.pkgName + ",subjectId: " + this.subjectId + ",operation: " + this.operation + " type: " + this.type + i.f4738d;
    }
}
