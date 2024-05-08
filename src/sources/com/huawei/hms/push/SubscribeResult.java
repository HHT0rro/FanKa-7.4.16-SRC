package com.huawei.hms.push;

import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.api.client.Result;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SubscribeResult extends Result {

    /* renamed from: a, reason: collision with root package name */
    private String f30408a;

    /* renamed from: b, reason: collision with root package name */
    private List<SubscribedItem> f30409b;

    public String getErrorMsg() {
        return this.f30408a;
    }

    public List<SubscribedItem> getSubscribedItems() {
        return this.f30409b;
    }

    public void setErrorMsg(String str) {
        this.f30408a = str;
    }

    public void setSubscribedItems(List<SubscribedItem> list) {
        this.f30409b = list;
    }
}
