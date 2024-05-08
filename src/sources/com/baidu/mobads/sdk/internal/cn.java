package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cn extends i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cm f10074b;

    public cn(cm cmVar) {
        this.f10074b = cmVar;
    }

    @Override // com.baidu.mobads.sdk.internal.i
    public Object i() {
        String a10;
        String a11;
        Context context;
        String a12;
        try {
            a10 = this.f10074b.a("key_crash_trace");
            a11 = this.f10074b.a("key_crash_ad");
            if (TextUtils.isEmpty(a10)) {
                return null;
            }
            cj a13 = cj.a();
            context = this.f10074b.f10072m;
            a13.a(context);
            a12 = this.f10074b.a("key_crash_source");
            a13.a(a12, a10, a11);
            this.f10074b.g();
            return null;
        } catch (Exception e2) {
            bs.a().a(e2);
            return null;
        }
    }
}
