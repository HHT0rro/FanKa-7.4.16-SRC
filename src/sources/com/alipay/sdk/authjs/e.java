package com.alipay.sdk.authjs;

import com.alipay.sdk.authjs.a;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f4514a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f4515b;

    public e(d dVar, a aVar) {
        this.f4515b = dVar;
        this.f4514a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.EnumC0095a b4;
        b4 = this.f4515b.b(this.f4514a);
        if (b4 != a.EnumC0095a.NONE_ERROR) {
            try {
                this.f4515b.a(this.f4514a.b(), b4, true);
            } catch (JSONException unused) {
            }
        }
    }
}
