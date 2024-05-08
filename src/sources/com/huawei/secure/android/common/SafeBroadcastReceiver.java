package com.huawei.secure.android.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class SafeBroadcastReceiver extends BroadcastReceiver {
    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final boolean a(android.content.Context r2, android.content.Intent r3) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L12
            if (r3 != 0) goto L6
            goto L12
        L6:
            java.lang.String r2 = "TestIntent"
            r3.getStringExtra(r2)     // Catch: java.lang.Exception -> L12
            java.lang.String r2 = r3.getAction()
            if (r2 == 0) goto L12
            r0 = 1
        L12:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.SafeBroadcastReceiver.a(android.content.Context, android.content.Intent):boolean");
    }

    @Deprecated
    public abstract void b(Context context, Intent intent);

    @Override // android.content.BroadcastReceiver
    @Deprecated
    public final void onReceive(Context context, Intent intent) {
        if (a(context, intent)) {
            b(context, new SafeIntent(intent));
        }
    }
}
