package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ContentExt implements Serializable {
    private static final long serialVersionUID = 5565833272963480072L;
    private String key;
    private String value;

    public ContentExt() {
    }

    public ContentExt(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String Code() {
        return this.key;
    }

    public void Code(String str) {
        this.key = str;
    }

    public String V() {
        return this.value;
    }

    public void V(String str) {
        this.value = str;
    }
}
