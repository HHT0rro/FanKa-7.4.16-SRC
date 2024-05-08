package com.huawei.quickcard;

import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d1 {

    /* renamed from: d, reason: collision with root package name */
    private static final String f33581d = "QOrigin";

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<View> f33582a;

    /* renamed from: b, reason: collision with root package name */
    private String f33583b;

    /* renamed from: c, reason: collision with root package name */
    private String f33584c;

    public d1(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f33583b = "0%";
            this.f33584c = "0%";
            return;
        }
        String[] split = str.split(" ");
        for (int i10 = 0; i10 < split.length; i10++) {
            if (i10 == 0) {
                this.f33583b = split[0];
            } else if (i10 == 1) {
                this.f33584c = split[1];
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:23:0x0069
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    public void a() {
        /*
            r8 = this;
            java.lang.String r0 = "QOrigin"
            java.lang.String r1 = "dp"
            java.lang.String r2 = "%"
            java.lang.ref.WeakReference<android.view.View> r3 = r8.f33582a
            if (r3 != 0) goto Lb
            return
        Lb:
            java.lang.Object r3 = r3.get()
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L14
            return
        L14:
            r4 = 1120403456(0x42c80000, float:100.0)
            r5 = 0
            java.lang.String r6 = r8.f33583b     // Catch: java.lang.NumberFormatException -> L69
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.NumberFormatException -> L69
            if (r6 != 0) goto L6e
            java.lang.String r6 = r8.f33583b     // Catch: java.lang.NumberFormatException -> L69
            boolean r6 = r6.endsWith(r2)     // Catch: java.lang.NumberFormatException -> L69
            if (r6 == 0) goto L41
            java.lang.String r6 = r8.f33583b     // Catch: java.lang.NumberFormatException -> L69
            int r7 = r6.indexOf(r2)     // Catch: java.lang.NumberFormatException -> L69
            java.lang.String r6 = r6.substring(r5, r7)     // Catch: java.lang.NumberFormatException -> L69
            float r6 = java.lang.Float.parseFloat(r6)     // Catch: java.lang.NumberFormatException -> L69
            float r6 = r6 / r4
            int r7 = r3.getWidth()     // Catch: java.lang.NumberFormatException -> L69
            float r7 = (float) r7     // Catch: java.lang.NumberFormatException -> L69
            float r6 = r6 * r7
            r3.setPivotX(r6)     // Catch: java.lang.NumberFormatException -> L69
            goto L6e
        L41:
            java.lang.String r6 = r8.f33583b     // Catch: java.lang.NumberFormatException -> L69
            boolean r6 = r6.endsWith(r1)     // Catch: java.lang.NumberFormatException -> L69
            if (r6 == 0) goto L5f
            java.lang.String r6 = r8.f33583b     // Catch: java.lang.NumberFormatException -> L69
            int r7 = r6.indexOf(r1)     // Catch: java.lang.NumberFormatException -> L69
            java.lang.String r6 = r6.substring(r5, r7)     // Catch: java.lang.NumberFormatException -> L69
            float r6 = java.lang.Float.parseFloat(r6)     // Catch: java.lang.NumberFormatException -> L69
            float r6 = com.huawei.quickcard.utils.ViewUtils.dip2FloatPx(r3, r6)     // Catch: java.lang.NumberFormatException -> L69
            r3.setPivotX(r6)     // Catch: java.lang.NumberFormatException -> L69
            goto L6e
        L5f:
            java.lang.String r6 = r8.f33583b     // Catch: java.lang.NumberFormatException -> L69
            float r6 = java.lang.Float.parseFloat(r6)     // Catch: java.lang.NumberFormatException -> L69
            r3.setPivotX(r6)     // Catch: java.lang.NumberFormatException -> L69
            goto L6e
        L69:
            java.lang.String r6 = "parse x failed"
            com.huawei.quickcard.base.log.CardLogUtils.w(r0, r6)
        L6e:
            java.lang.String r6 = r8.f33584c     // Catch: java.lang.NumberFormatException -> Lc0
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.NumberFormatException -> Lc0
            if (r6 != 0) goto Lc5
            java.lang.String r6 = r8.f33584c     // Catch: java.lang.NumberFormatException -> Lc0
            boolean r6 = r6.endsWith(r2)     // Catch: java.lang.NumberFormatException -> Lc0
            if (r6 == 0) goto L98
            java.lang.String r1 = r8.f33584c     // Catch: java.lang.NumberFormatException -> Lc0
            int r2 = r1.indexOf(r2)     // Catch: java.lang.NumberFormatException -> Lc0
            java.lang.String r1 = r1.substring(r5, r2)     // Catch: java.lang.NumberFormatException -> Lc0
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> Lc0
            float r1 = r1 / r4
            int r2 = r3.getHeight()     // Catch: java.lang.NumberFormatException -> Lc0
            float r2 = (float) r2     // Catch: java.lang.NumberFormatException -> Lc0
            float r1 = r1 * r2
            r3.setPivotY(r1)     // Catch: java.lang.NumberFormatException -> Lc0
            goto Lc5
        L98:
            java.lang.String r2 = r8.f33584c     // Catch: java.lang.NumberFormatException -> Lc0
            boolean r2 = r2.endsWith(r1)     // Catch: java.lang.NumberFormatException -> Lc0
            if (r2 == 0) goto Lb6
            java.lang.String r2 = r8.f33584c     // Catch: java.lang.NumberFormatException -> Lc0
            int r1 = r2.indexOf(r1)     // Catch: java.lang.NumberFormatException -> Lc0
            java.lang.String r1 = r2.substring(r5, r1)     // Catch: java.lang.NumberFormatException -> Lc0
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> Lc0
            float r1 = com.huawei.quickcard.utils.ViewUtils.dip2FloatPx(r3, r1)     // Catch: java.lang.NumberFormatException -> Lc0
            r3.setPivotY(r1)     // Catch: java.lang.NumberFormatException -> Lc0
            goto Lc5
        Lb6:
            java.lang.String r1 = r8.f33584c     // Catch: java.lang.NumberFormatException -> Lc0
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> Lc0
            r3.setPivotY(r1)     // Catch: java.lang.NumberFormatException -> Lc0
            goto Lc5
        Lc0:
            java.lang.String r1 = "parse y failed"
            com.huawei.quickcard.base.log.CardLogUtils.w(r0, r1)
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.d1.a():void");
    }

    public void a(View view) {
        this.f33582a = new WeakReference<>(view);
    }
}
