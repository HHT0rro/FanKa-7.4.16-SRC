package com.cupidapp.live.base.router.jumper;

import com.cupidapp.live.base.router.h;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PersonalPostListUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PersonalPostListUrlJumper implements com.cupidapp.live.base.router.h {
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        if ((r0.length() > 0) == true) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cupidapp.live.base.router.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(@org.jetbrains.annotations.Nullable final android.content.Context r6, @org.jetbrains.annotations.NotNull android.net.Uri r7, @org.jetbrains.annotations.Nullable java.lang.String r8) {
        /*
            r5 = this;
            java.lang.String r8 = "uri"
            kotlin.jvm.internal.s.i(r7, r8)
            java.lang.String r8 = "userId"
            java.lang.String r8 = r7.getQueryParameter(r8)
            java.lang.String r0 = "userName"
            java.lang.String r0 = r7.getQueryParameter(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L21
            int r3 = r0.length()
            if (r3 <= 0) goto L1d
            r3 = 1
            goto L1e
        L1d:
            r3 = 0
        L1e:
            if (r3 != r1) goto L21
            goto L22
        L21:
            r1 = 0
        L22:
            if (r1 == 0) goto L2b
            java.lang.String r1 = "utf-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r0, r1)
            goto L2d
        L2b:
            java.lang.String r0 = ""
        L2d:
            java.lang.String r1 = "source"
            java.lang.String r7 = r7.getQueryParameter(r1)
            com.cupidapp.live.base.sensorslog.SensorPosition r7 = r5.b(r7)
            if (r8 != 0) goto L3a
            return
        L3a:
            com.cupidapp.live.base.network.NetworkClient r1 = com.cupidapp.live.base.network.NetworkClient.f11868a
            f2.a r1 = r1.l()
            r2 = 21
            r3 = 0
            io.reactivex.Observable r1 = r1.s(r8, r2, r3)
            boolean r2 = r6 instanceof com.cupidapp.live.base.network.g
            if (r2 == 0) goto L4f
            r2 = r6
            com.cupidapp.live.base.network.g r2 = (com.cupidapp.live.base.network.g) r2
            goto L50
        L4f:
            r2 = r3
        L50:
            com.cupidapp.live.base.network.i r4 = new com.cupidapp.live.base.network.i
            r4.<init>()
            io.reactivex.Observable r1 = r1.flatMap(r4)
            io.reactivex.Scheduler r4 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Observable r1 = r1.observeOn(r4)
            com.cupidapp.live.base.router.jumper.PersonalPostListUrlJumper$jump$$inlined$handleByContext$default$1 r4 = new com.cupidapp.live.base.router.jumper.PersonalPostListUrlJumper$jump$$inlined$handleByContext$default$1
            r4.<init>()
            com.cupidapp.live.base.network.e r6 = new com.cupidapp.live.base.network.e
            r6.<init>(r4)
            com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2 r7 = new com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2
            r7.<init>(r3, r2)
            com.cupidapp.live.base.network.e r8 = new com.cupidapp.live.base.network.e
            r8.<init>(r7)
            io.reactivex.disposables.Disposable r6 = r1.subscribe(r6, r8)
            java.lang.String r7 = "disposed"
            if (r6 == 0) goto L85
            kotlin.jvm.internal.s.h(r6, r7)
            if (r2 == 0) goto L85
            r2.H(r6)
        L85:
            kotlin.jvm.internal.s.h(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.router.jumper.PersonalPostListUrlJumper.a(android.content.Context, android.net.Uri, java.lang.String):void");
    }

    @NotNull
    public SensorPosition b(@Nullable String str) {
        return h.a.a(this, str);
    }
}
