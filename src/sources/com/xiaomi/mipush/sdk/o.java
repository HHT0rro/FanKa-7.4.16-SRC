package com.xiaomi.mipush.sdk;

import com.xiaomi.push.service.module.PushChannelRegion;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public PushChannelRegion f47045a = PushChannelRegion.China;

    /* renamed from: b, reason: collision with root package name */
    public boolean f47046b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47047c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f47048d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47049e = false;

    public boolean a() {
        return this.f47048d;
    }

    public boolean b() {
        return this.f47047c;
    }

    public boolean c() {
        return this.f47049e;
    }

    public boolean d() {
        return this.f47046b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PushConfiguration{");
        stringBuffer.append("Region:");
        PushChannelRegion pushChannelRegion = this.f47045a;
        stringBuffer.append(pushChannelRegion == null ? "null" : pushChannelRegion.name());
        stringBuffer.append(",mOpenHmsPush:" + this.f47046b);
        stringBuffer.append(",mOpenFCMPush:" + this.f47047c);
        stringBuffer.append(",mOpenCOSPush:" + this.f47048d);
        stringBuffer.append(",mOpenFTOSPush:" + this.f47049e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
