package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: LogCatNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c implements d {

    /* renamed from: a, reason: collision with root package name */
    private d f29617a;

    @Override // com.huawei.hms.base.log.d
    public void a(Context context, String str) {
        d dVar = this.f29617a;
        if (dVar != null) {
            dVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.d
    public void a(d dVar) {
        this.f29617a = dVar;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(String str, int i10, String str2, String str3) {
        Log.println(i10, "HMSSDK_" + str2, str3);
        d dVar = this.f29617a;
        if (dVar != null) {
            dVar.a(str, i10, str2, str3);
        }
    }
}
