package com.huawei.appgallery.agd.core.internalapi;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.core.impl.store.openevent.OpenEventUploadRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class OpenEventInfo {

    /* renamed from: a, reason: collision with root package name */
    public int f27463a;

    /* renamed from: b, reason: collision with root package name */
    public String f27464b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<String> f27465c;

    /* renamed from: d, reason: collision with root package name */
    public String f27466d;

    /* renamed from: e, reason: collision with root package name */
    public String f27467e;

    public OpenEventInfo(int i10, String str, String str2) {
        this.f27463a = i10;
        this.f27464b = str;
        ArrayList<String> arrayList = new ArrayList<>();
        this.f27465c = arrayList;
        arrayList.add(str2);
    }

    public OpenEventUploadRequest.EventDetail getEventDetail() {
        OpenEventUploadRequest.EventDetail eventDetail = new OpenEventUploadRequest.EventDetail();
        eventDetail.setLayoutId(this.f27464b);
        eventDetail.setDetailIdList(this.f27465c);
        return eventDetail;
    }

    public int getEventType() {
        return this.f27463a;
    }

    public String getEventValue() {
        return this.f27467e;
    }

    public String getLayoutId() {
        return this.f27464b;
    }

    public String getReferrer() {
        return this.f27466d;
    }

    public void setEventValue(String str) {
        this.f27467e = str;
    }

    public void setReferrer(String str) {
        this.f27466d = str;
    }

    public OpenEventInfo(int i10, String str, @NonNull List<String> list) {
        this.f27463a = i10;
        this.f27464b = str;
        this.f27465c = new ArrayList<>(list);
    }
}
