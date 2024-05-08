package com.cupidapp.live.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import p1.g;
import z0.k;

/* compiled from: APPDownLoadCompleteReceiver.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class APPDownLoadCompleteReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Uri parse;
        s.i(context, "context");
        s.i(intent, "intent");
        long longExtra = intent.getLongExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, -1L);
        Long c4 = g.f52734a.D1().c();
        long longValue = c4 != null ? c4.longValue() : -1L;
        if (longValue == -1 || longExtra != longValue) {
            return;
        }
        File o10 = k.f54819a.o(context);
        String path = o10 != null ? o10.getPath() : null;
        String str = path + File.separator + "finka_new_version.apk";
        if (str.length() == 0) {
            return;
        }
        Intent intent2 = new Intent();
        intent2.addFlags(268435456);
        intent2.setAction("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent2.addFlags(1);
            parse = FileProvider.getUriForFile(context, "com.cupidapp.live", new File(str));
            s.h(parse, "{\n                instal…kFilePath))\n            }");
        } else {
            parse = Uri.parse("file://" + str);
            s.h(parse, "{\n                Uri.pa…kFilePath\")\n            }");
        }
        intent2.setDataAndType(parse, "application/vnd.android.package-archive");
        ContextCompat.startActivity(context, intent2, null);
    }
}
