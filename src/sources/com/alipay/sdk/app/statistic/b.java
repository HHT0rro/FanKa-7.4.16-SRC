package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.d;
import com.alipay.sdk.util.j;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f4429a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4430b;

    public b(Context context, String str) {
        this.f4429a = context;
        this.f4430b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = new d();
        try {
            String b4 = j.b(this.f4429a, a.f4427a, null);
            if (!TextUtils.isEmpty(b4) && dVar.a(this.f4429a, b4) != null) {
                j.b(this.f4429a, a.f4427a);
            }
        } catch (Throwable unused) {
        }
        try {
            if (TextUtils.isEmpty(this.f4430b)) {
                return;
            }
            dVar.a(this.f4429a, this.f4430b);
        } catch (IOException unused2) {
            j.a(this.f4429a, a.f4427a, this.f4430b);
        } catch (Throwable unused3) {
        }
    }
}
