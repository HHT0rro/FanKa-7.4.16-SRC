package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.by;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cg extends i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ by.c f10018b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Handler f10019c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ by f10020d;

    public cg(by byVar, by.c cVar, Handler handler) {
        this.f10020d = byVar;
        this.f10018b = cVar;
        this.f10019c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.i
    public Object i() {
        bs bsVar;
        SharedPreferences m10;
        bs bsVar2;
        SharedPreferences m11;
        bs bsVar3;
        SharedPreferences m12;
        try {
            try {
                synchronized (by.class) {
                    this.f10020d.b(this.f10018b, this.f10019c);
                }
                m12 = this.f10020d.m();
                SharedPreferences.Editor edit = m12.edit();
                edit.putString(by.f9981d, this.f10020d.a());
                edit.apply();
                return null;
            } catch (Throwable th) {
                try {
                    String str = "Load APK Failed: " + th.toString();
                    bsVar2 = this.f10020d.f10003z;
                    bsVar2.a(by.f9978a, str);
                    this.f10020d.b(false);
                    m11 = this.f10020d.m();
                    SharedPreferences.Editor edit2 = m11.edit();
                    edit2.putString(by.f9981d, this.f10020d.a());
                    edit2.apply();
                    return null;
                } catch (Throwable th2) {
                    try {
                        m10 = this.f10020d.m();
                        SharedPreferences.Editor edit3 = m10.edit();
                        edit3.putString(by.f9981d, this.f10020d.a());
                        edit3.apply();
                    } catch (Throwable th3) {
                        bsVar = this.f10020d.f10003z;
                        bsVar.a(by.f9978a, th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            bsVar3 = this.f10020d.f10003z;
            bsVar3.a(by.f9978a, th4);
            return null;
        }
    }
}
