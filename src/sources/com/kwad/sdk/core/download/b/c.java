package com.kwad.sdk.core.download.b;

import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.kwad.sdk.api.core.IProgressRemoteView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private IProgressRemoteView auK;

    private c(IProgressRemoteView iProgressRemoteView) {
        this.auK = iProgressRemoteView;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.kwad.sdk.core.download.b.c a(android.content.Context r2, int r3, boolean r4) {
        /*
            java.lang.Class<com.kwad.sdk.service.a.f> r0 = com.kwad.sdk.service.a.f.class
            java.lang.Object r0 = com.kwad.sdk.service.ServiceProvider.get(r0)
            com.kwad.sdk.service.a.f r0 = (com.kwad.sdk.service.a.f) r0
            int r0 = r0.getApiVersionCode()
            r1 = 3031000(0x2e3fd8, float:4.247336E-39)
            if (r0 < r1) goto L13
            r0 = 1
            goto L14
        L13:
            r0 = 0
        L14:
            if (r0 == 0) goto L25
            com.kwad.sdk.api.core.IProgressRemoteView r3 = com.kwad.sdk.api.core.RemoteViewBuilder.createProgressView(r2, r3, r4)     // Catch: java.lang.Throwable -> L20
            com.kwad.sdk.core.download.b.c r4 = new com.kwad.sdk.core.download.b.c     // Catch: java.lang.Throwable -> L20
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L20
            goto L34
        L20:
            r3 = move-exception
            com.kwad.sdk.core.e.c.printStackTraceOnly(r3)
            goto L33
        L25:
            com.kwad.sdk.api.core.IProgressRemoteView r3 = com.kwad.sdk.api.core.RemoteViewBuilder.createProgressView(r2)     // Catch: java.lang.Throwable -> L2f
            com.kwad.sdk.core.download.b.c r4 = new com.kwad.sdk.core.download.b.c     // Catch: java.lang.Throwable -> L2f
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L2f
            goto L34
        L2f:
            r3 = move-exception
            com.kwad.sdk.core.e.c.printStackTraceOnly(r3)
        L33:
            r4 = 0
        L34:
            if (r4 != 0) goto L45
            com.kwad.sdk.api.core.IProgressRemoteView r2 = com.kwad.sdk.api.core.RemoteViewBuilder.createProgressView(r2)     // Catch: java.lang.Throwable -> L41
            com.kwad.sdk.core.download.b.c r3 = new com.kwad.sdk.core.download.b.c     // Catch: java.lang.Throwable -> L41
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L41
            r4 = r3
            goto L45
        L41:
            r2 = move-exception
            com.kwad.sdk.core.e.c.printStackTraceOnly(r2)
        L45:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.b.c.a(android.content.Context, int, boolean):com.kwad.sdk.core.download.b.c");
    }

    public final RemoteViews build() {
        IProgressRemoteView iProgressRemoteView = this.auK;
        if (iProgressRemoteView != null) {
            return iProgressRemoteView.build();
        }
        return null;
    }

    public final void setControlBtnPaused(boolean z10) {
        try {
            IProgressRemoteView iProgressRemoteView = this.auK;
            if (iProgressRemoteView != null) {
                iProgressRemoteView.setControlBtnPaused(z10);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public final void setIcon(Bitmap bitmap) {
        IProgressRemoteView iProgressRemoteView = this.auK;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setIcon(bitmap);
        }
    }

    public final void setName(String str) {
        IProgressRemoteView iProgressRemoteView = this.auK;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setName(str);
        }
    }

    public final void setPercentNum(String str) {
        IProgressRemoteView iProgressRemoteView = this.auK;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setPercentNum(str);
        }
    }

    public final void setProgress(int i10, int i11, boolean z10) {
        IProgressRemoteView iProgressRemoteView = this.auK;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setProgress(100, i11, false);
        }
    }

    public final void setSize(String str) {
        IProgressRemoteView iProgressRemoteView = this.auK;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setSize(str);
        }
    }

    public final void setStatus(String str) {
        IProgressRemoteView iProgressRemoteView = this.auK;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setStatus(str);
        }
    }
}
