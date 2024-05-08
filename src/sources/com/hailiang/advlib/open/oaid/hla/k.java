package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import com.hailiang.advlib.open.oaid.OAIDException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: XiaomiImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class k implements com.hailiang.advlib.open.oaid.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27196a;

    /* renamed from: b, reason: collision with root package name */
    public Class<?> f27197b;

    /* renamed from: c, reason: collision with root package name */
    public Object f27198c;

    public k(Context context) {
        this.f27196a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f27197b = cls;
            this.f27198c = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    private String b() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.f27197b.getMethod("getOAID", Context.class).invoke(this.f27198c, this.f27196a);
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        return this.f27198c != null;
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f27196a == null || aVar == null) {
            return;
        }
        if (this.f27197b != null && this.f27198c != null) {
            try {
                String b4 = b();
                if (b4 != null && b4.length() != 0) {
                    aVar.a(b4);
                    return;
                }
                throw new OAIDException("OAID query failed");
            } catch (Exception e2) {
                aVar.a(e2);
                return;
            }
        }
        aVar.a(new OAIDException("Xiaomi IdProvider not exists"));
    }
}
