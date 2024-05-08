package com.alibaba.security.realidentity.upload;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum UploadFileType {
    ARUP(1, "内部arup上传"),
    OSS(2, "外部oss上传");

    public String desc;
    public int type;

    UploadFileType(int i10, String str) {
        this.type = i10;
        this.desc = str;
    }
}
