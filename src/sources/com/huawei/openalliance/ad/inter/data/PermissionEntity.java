package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PermissionEntity implements Serializable {
    private static final long serialVersionUID = -1825501272693801533L;
    private String name;
    private int type;

    public PermissionEntity() {
    }

    public PermissionEntity(String str, int i10) {
        this.name = str;
        this.type = i10;
    }

    public String Code() {
        return this.name;
    }

    public int V() {
        return this.type;
    }
}
