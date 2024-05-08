package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f4489a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StringBuilder f4490b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ APAuthInfo f4491c;

    public h(Activity activity, StringBuilder sb2, APAuthInfo aPAuthInfo) {
        this.f4489a = activity;
        this.f4490b = sb2;
        this.f4491c = aPAuthInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alipay.sdk.widget.a aVar;
        com.alipay.sdk.widget.a aVar2;
        com.alipay.sdk.widget.a aVar3;
        com.alipay.sdk.widget.a aVar4;
        com.alipay.sdk.packet.b bVar;
        com.alipay.sdk.widget.a aVar5;
        String str;
        String str2;
        com.alipay.sdk.widget.a aVar6;
        String str3;
        com.alipay.sdk.widget.a aVar7;
        com.alipay.sdk.widget.a aVar8;
        String str4;
        com.alipay.sdk.widget.a aVar9;
        com.alipay.sdk.widget.a aVar10;
        com.alipay.sdk.widget.a aVar11;
        try {
            try {
                bVar = new com.alipay.sdk.packet.impl.a().a(this.f4489a, this.f4490b.toString());
            } catch (Throwable th) {
                com.alipay.sdk.util.c.a("msp", th);
                bVar = null;
            }
            aVar5 = g.f4487c;
            if (aVar5 != null) {
                aVar11 = g.f4487c;
                aVar11.c();
                com.alipay.sdk.widget.a unused = g.f4487c = null;
            }
        } catch (Exception unused2) {
            aVar3 = g.f4487c;
            if (aVar3 == null) {
                return;
            }
        } catch (Throwable th2) {
            aVar = g.f4487c;
            if (aVar != null) {
                aVar2 = g.f4487c;
                aVar2.c();
            }
            throw th2;
        }
        if (bVar == null) {
            String unused3 = g.f4488d = this.f4491c.getRedirectUri() + "?resultCode=202";
            Activity activity = this.f4489a;
            str4 = g.f4488d;
            g.a(activity, str4);
            aVar9 = g.f4487c;
            if (aVar9 != null) {
                aVar10 = g.f4487c;
                aVar10.c();
                return;
            }
            return;
        }
        List<com.alipay.sdk.protocol.b> a10 = com.alipay.sdk.protocol.b.a(bVar.c().optJSONObject(com.alipay.sdk.cons.c.f4552c).optJSONObject(com.alipay.sdk.cons.c.f4553d));
        int i10 = 0;
        while (true) {
            if (i10 >= a10.size()) {
                break;
            }
            if (a10.get(i10).b() == com.alipay.sdk.protocol.a.WapPay) {
                String unused4 = g.f4488d = a10.get(i10).c()[0];
                break;
            }
            i10++;
        }
        str = g.f4488d;
        if (TextUtils.isEmpty(str)) {
            String unused5 = g.f4488d = this.f4491c.getRedirectUri() + "?resultCode=202";
            Activity activity2 = this.f4489a;
            str3 = g.f4488d;
            g.a(activity2, str3);
            aVar7 = g.f4487c;
            if (aVar7 != null) {
                aVar8 = g.f4487c;
                aVar8.c();
                return;
            }
            return;
        }
        Intent intent = new Intent(this.f4489a, (Class<?>) AuthActivity.class);
        str2 = g.f4488d;
        intent.putExtra("params", str2);
        intent.putExtra(AuthActivity.f4467b, this.f4491c.getRedirectUri());
        this.f4489a.startActivity(intent);
        aVar6 = g.f4487c;
        if (aVar6 == null) {
            return;
        }
        aVar4 = g.f4487c;
        aVar4.c();
    }
}
