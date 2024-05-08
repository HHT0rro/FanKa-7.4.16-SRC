package com.cupidapp.live.base.router.helper;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogShare;
import com.cupidapp.live.base.sensorslog.ShareType;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.share.model.ShareBaseType;
import com.cupidapp.live.base.share.model.ShareItemHandledResult;
import com.cupidapp.live.base.share.model.ShareOperateType;
import com.cupidapp.live.base.share.view.b;
import com.cupidapp.live.base.view.FKAlertLayout;
import com.cupidapp.live.base.web.FKWebView;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import z0.k;

/* compiled from: WebActionSnapWebContentHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WebActionSnapWebContentHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WebActionSnapWebContentHelper f12130a = new WebActionSnapWebContentHelper();

    /* compiled from: WebActionSnapWebContentHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements com.cupidapp.live.base.share.view.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareBuilder f12131a;

        public a(ShareBuilder shareBuilder) {
            this.f12131a = shareBuilder;
        }

        @Override // com.cupidapp.live.base.share.view.b
        public void a(@NotNull ShareItemHandledResult shareItemHandledResult) {
            b.a.a(this, shareItemHandledResult);
        }

        @Override // com.cupidapp.live.base.share.view.b
        public void b(@NotNull ShareBaseType type) {
            s.i(type, "type");
            if (type == ShareOperateType.DOWNLOAD_IMAGE) {
                SensorsLogShare.f12216a.d(this.f12131a.getShareContent(), this.f12131a.getContentId(), this.f12131a.getOwnerId(), this.f12131a.getOwnerNickName(), ShareType.SAVE_PHOTO, SensorPosition.Web, (r21 & 64) != 0 ? "" : this.f12131a.getTitle(), (r21 & 128) != 0 ? "" : null);
            }
        }
    }

    public static final void g(FKWebView fKWebView, FragmentActivity activity, Function1 successCallback) {
        s.i(activity, "$activity");
        s.i(successCallback, "$successCallback");
        Bitmap createBitmap = Bitmap.createBitmap(fKWebView.getWidth(), (int) (fKWebView.getContentHeight() * fKWebView.getScale()), Bitmap.Config.RGB_565);
        s.h(createBitmap, "createBitmap(width, height, config)");
        fKWebView.draw(new Canvas(createBitmap));
        File h10 = k.f54819a.h(activity, "client_snap_web_content_" + System.currentTimeMillis() + ".jpg");
        if (h10 != null) {
            z0.f.g(createBitmap, h10, 0, 2, null);
            WebActionSnapWebContentHelper webActionSnapWebContentHelper = f12130a;
            if (webActionSnapWebContentHelper.d(h10)) {
                String absolutePath = h10.getAbsolutePath();
                s.h(absolutePath, "file.absolutePath");
                successCallback.invoke(absolutePath);
                webActionSnapWebContentHelper.e(activity);
            }
        }
    }

    public final void c(FragmentActivity fragmentActivity, String str) {
        File file = new File(str);
        k.a aVar = k.f54819a;
        String name = file.getName();
        s.h(name, "file.name");
        Uri H = k.a.H(aVar, fragmentActivity, file, name, null, 8, null);
        if (H == null || !aVar.D(fragmentActivity, H)) {
            return;
        }
        com.cupidapp.live.base.view.h.f12779a.c(fragmentActivity, R$string.save_success);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0027 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(java.io.File r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            boolean r1 = r8.exists()     // Catch: java.lang.Exception -> L29
            r2 = 1
            if (r1 == 0) goto L2d
            long r3 = r8.length()     // Catch: java.lang.Exception -> L29
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L2d
            java.lang.String r8 = r8.getAbsolutePath()     // Catch: java.lang.Exception -> L29
            if (r8 == 0) goto L24
            int r8 = r8.length()     // Catch: java.lang.Exception -> L29
            if (r8 != 0) goto L22
            goto L24
        L22:
            r8 = 0
            goto L25
        L24:
            r8 = 1
        L25:
            if (r8 != 0) goto L2d
            r0 = 1
            goto L2d
        L29:
            r8 = move-exception
            r8.printStackTrace()
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.router.helper.WebActionSnapWebContentHelper.d(java.io.File):boolean");
    }

    public final void e(FragmentActivity fragmentActivity) {
        FKAlertLayout.a aVar = FKAlertLayout.f12456d;
        View findViewById = fragmentActivity.findViewById(16908290);
        s.h(findViewById, "activity.findViewById(android.R.id.content)");
        aVar.c((ViewGroup) findViewById);
    }

    public final void f(final FragmentActivity fragmentActivity, final FKWebView fKWebView, final Function1<? super String, p> function1) {
        if (fKWebView == null) {
            return;
        }
        h(fragmentActivity);
        fKWebView.postDelayed(new Runnable() { // from class: com.cupidapp.live.base.router.helper.e
            @Override // java.lang.Runnable
            public final void run() {
                WebActionSnapWebContentHelper.g(FKWebView.this, fragmentActivity, function1);
            }
        }, 200L);
    }

    public final void h(FragmentActivity fragmentActivity) {
        ViewGroup viewGroup = (ViewGroup) fragmentActivity.findViewById(16908290);
        FKAlertLayout.a aVar = FKAlertLayout.f12456d;
        s.h(viewGroup, "viewGroup");
        aVar.a(viewGroup).e();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(androidx.fragment.app.FragmentActivity r25, com.cupidapp.live.base.web.model.WebShareModel r26, android.net.Uri r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.router.helper.WebActionSnapWebContentHelper.i(androidx.fragment.app.FragmentActivity, com.cupidapp.live.base.web.model.WebShareModel, android.net.Uri, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(@org.jetbrains.annotations.NotNull final androidx.fragment.app.FragmentActivity r12, @org.jetbrains.annotations.NotNull final android.net.Uri r13) {
        /*
            r11 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.s.i(r12, r0)
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.s.i(r13, r0)
            com.cupidapp.live.base.web.fragment.FKWebViewFragment$a r0 = com.cupidapp.live.base.web.fragment.FKWebViewFragment.f13075p
            com.cupidapp.live.base.web.FKWebView r0 = r0.c(r12)
            r1 = 0
            if (r0 == 0) goto L18
            com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper r2 = r0.getH5CallNativeHelper()
            goto L19
        L18:
            r2 = r1
        L19:
            if (r2 == 0) goto L20
            com.cupidapp.live.base.web.model.WebShareModel r3 = r2.f()
            goto L21
        L20:
            r3 = r1
        L21:
            if (r2 == 0) goto L28
            java.lang.String r4 = r2.e()
            goto L29
        L28:
            r4 = r1
        L29:
            r5 = 0
            if (r4 == 0) goto L35
            int r6 = r4.length()
            if (r6 != 0) goto L33
            goto L35
        L33:
            r6 = 0
            goto L36
        L35:
            r6 = 1
        L36:
            if (r6 != 0) goto L67
            z0.k$a r6 = z0.k.f54819a
            long r7 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "web_snap_web_content_"
            r9.append(r10)
            r9.append(r7)
            java.lang.String r7 = ".jpg"
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.io.File r6 = r6.h(r12, r7)
            if (r6 == 0) goto L67
            z0.e r7 = z0.e.f54814a
            android.graphics.Bitmap r4 = r7.a(r4)
            if (r4 == 0) goto L68
            r7 = 2
            z0.f.g(r4, r6, r5, r7, r1)
            goto L68
        L67:
            r6 = r1
        L68:
            boolean r4 = r11.d(r6)
            if (r4 == 0) goto L7d
            if (r2 == 0) goto L73
            r2.d()
        L73:
            if (r6 == 0) goto L79
            java.lang.String r1 = r6.getAbsolutePath()
        L79:
            r11.i(r12, r3, r13, r1)
            goto L85
        L7d:
            com.cupidapp.live.base.router.helper.WebActionSnapWebContentHelper$snapWebContent$2 r1 = new com.cupidapp.live.base.router.helper.WebActionSnapWebContentHelper$snapWebContent$2
            r1.<init>()
            r11.f(r12, r0, r1)
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.router.helper.WebActionSnapWebContentHelper.j(androidx.fragment.app.FragmentActivity, android.net.Uri):void");
    }
}
