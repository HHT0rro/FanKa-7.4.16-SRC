package com.cupidapp.live.update;

import android.app.Activity;
import android.app.DownloadManager;
import android.net.Uri;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.AndroidUpdateVersionModel;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.k;

/* compiled from: FKUpdateNewVersionDownloader.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKUpdateNewVersionDownloader {

    /* renamed from: a */
    @NotNull
    public static final FKUpdateNewVersionDownloader f18715a = new FKUpdateNewVersionDownloader();

    public static /* synthetic */ void b(FKUpdateNewVersionDownloader fKUpdateNewVersionDownloader, ConstantsResult constantsResult, Activity activity, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        fKUpdateNewVersionDownloader.a(constantsResult, activity, z10);
    }

    public final void a(@Nullable final ConstantsResult constantsResult, @NotNull final Activity activity, boolean z10) {
        s.i(activity, "activity");
        long currentTimeMillis = System.currentTimeMillis();
        if (z10) {
            Long c4 = g.f52734a.O().c();
            if (currentTimeMillis - (c4 != null ? c4.longValue() : 0L) < 86400000) {
                return;
            }
        }
        if (constantsResult != null) {
            AndroidUpdateVersionModel androidUpdateVersion = constantsResult.getAndroidUpdateVersion();
            if (androidUpdateVersion != null && androidUpdateVersion.getHasUpdateVersion()) {
                String urlAndroidAPK = constantsResult.getAndroidUpdateVersion().getUrlAndroidAPK();
                if (urlAndroidAPK == null || urlAndroidAPK.length() == 0) {
                    return;
                }
                g.f52734a.O().d(Long.valueOf(currentTimeMillis));
                FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, activity, false, 2, null).n(constantsResult.getAndroidUpdateVersion().getUpdateDetails()), 0, null, new Function0<p>() { // from class: com.cupidapp.live.update.FKUpdateNewVersionDownloader$checkNewVersionAndShowUpdateDialog$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ p invoke() {
                        invoke2();
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FKUpdateNewVersionDownloader.f18715a.c(activity, constantsResult.getAndroidUpdateVersion().getUrlAndroidAPK());
                    }
                }, 3, null), 0, null, 3, null), null, 1, null);
            }
        }
    }

    public final void c(@NotNull Activity activity, @NotNull String downloadUrl) {
        s.i(activity, "activity");
        s.i(downloadUrl, "downloadUrl");
        k.f54819a.b(activity);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
        request.setMimeType("application/vnd.android.package-archive");
        request.setDestinationInExternalFilesDir(activity, "apk", "finka_new_version.apk");
        request.setNotificationVisibility(1);
        request.setTitle(activity.getString(R$string.finka_app_name));
        request.setDescription(activity.getString(R$string.downloading_str));
        Object systemService = activity.getSystemService("download");
        s.g(systemService, "null cannot be cast to non-null type android.app.DownloadManager");
        g.f52734a.D1().d(Long.valueOf(((DownloadManager) systemService).enqueue(request)));
    }
}
