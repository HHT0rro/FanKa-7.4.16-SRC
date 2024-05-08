package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class m implements np {
    public final DownloadSetting dk;
    public final String ej;

    /* renamed from: m, reason: collision with root package name */
    public final Context f38895m;

    public m(Context context, DownloadSetting downloadSetting, String str) {
        this.f38895m = context;
        this.dk = downloadSetting;
        this.ej = str;
    }

    public boolean m() {
        if (this.f38895m == null) {
            return false;
        }
        try {
        } catch (Throwable unused) {
            Logger.debug();
        }
        return dk().resolveActivity(this.f38895m.getPackageManager()) != null;
    }
}
