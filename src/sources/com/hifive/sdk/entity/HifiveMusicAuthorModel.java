package com.hifive.sdk.entity;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusicAuthorModel implements Serializable {
    private String code;
    private String icon;

    /* renamed from: id, reason: collision with root package name */
    private int f27205id;
    private String name;

    public String getCode() {
        return this.code;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.f27205id;
    }

    public String getName() {
        return this.name;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(int i10) {
        this.f27205id = i10;
    }

    public void setName(String str) {
        this.name = str;
    }
}
