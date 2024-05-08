package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ConnectInfo implements IMessageEntity {

    /* renamed from: a, reason: collision with root package name */
    @Packed
    private List<String> f31835a;

    /* renamed from: b, reason: collision with root package name */
    @Packed
    private List<Scope> f31836b;

    /* renamed from: c, reason: collision with root package name */
    @Packed
    private String f31837c;

    /* renamed from: d, reason: collision with root package name */
    @Packed
    private String f31838d;

    public ConnectInfo() {
    }

    public List<String> getApiNameList() {
        return this.f31835a;
    }

    public String getFingerprint() {
        return this.f31837c;
    }

    public List<Scope> getScopeList() {
        return this.f31836b;
    }

    public String getSubAppID() {
        return this.f31838d;
    }

    public void setApiNameList(List<String> list) {
        this.f31835a = list;
    }

    public void setFingerprint(String str) {
        this.f31837c = str;
    }

    public void setScopeList(List<Scope> list) {
        this.f31836b = list;
    }

    public void setSubAppID(String str) {
        this.f31838d = str;
    }

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.f31835a = list;
        this.f31836b = list2;
        this.f31837c = str;
        this.f31838d = str2;
    }
}
