package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.c;
import java.io.Serializable;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Image implements Serializable {
    private static final long serialVersionUID = 3793768731771300290L;

    @c(Code = "Ext")
    private ImageExt ext;

    @c(Code = "H")
    private int height;
    private String localPath;
    private String url;

    @c(Code = "W")
    private int width;

    public String B() {
        return this.localPath;
    }

    public String Code() {
        return this.url;
    }

    public void Code(int i10) {
        this.width = i10;
    }

    public void Code(ImageExt imageExt) {
        this.ext = imageExt;
    }

    public void Code(String str) {
        this.url = str;
    }

    public int I() {
        return this.height;
    }

    public int V() {
        return this.width;
    }

    public void V(int i10) {
        this.height = i10;
    }

    public void V(String str) {
        this.localPath = str;
    }

    public ImageExt Z() {
        return this.ext;
    }
}
