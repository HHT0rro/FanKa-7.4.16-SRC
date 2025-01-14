package com.bytedance.pangle;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Iterator;
import java.util.List;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class ZeusPluginStateListener {
    public static final int EVENT_DOWNLOAD_FAILED = 4;
    public static final int EVENT_DOWNLOAD_PROGRESS = 2;
    public static final int EVENT_DOWNLOAD_START = 1;
    public static final int EVENT_DOWNLOAD_SUCCESS = 3;
    public static final int EVENT_INSTALL_FAILED = 7;
    public static final int EVENT_INSTALL_START = 5;
    public static final int EVENT_INSTALL_SUCCESS = 6;
    public static final int EVENT_LOAD_FAILED = 10;
    public static final int EVENT_LOAD_START = 8;
    public static final int EVENT_LOAD_SUCCESS = 9;
    public static final int EVENT_REQUEST_FINISH = 0;
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static void postStateChange(@Nullable final String str, final int i10, final Object... objArr) {
        mHandler.post(new Runnable() { // from class: com.bytedance.pangle.ZeusPluginStateListener.1
            @Override // java.lang.Runnable
            public final void run() {
                List<ZeusPluginStateListener> list = h.a().f10818b;
                if (list == null || list.size() <= 0) {
                    return;
                }
                Iterator<ZeusPluginStateListener> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().onPluginStateChange(TextUtils.isEmpty(String.this) ? GrsBaseInfo.CountryCodeSource.UNKNOWN : String.this, i10, objArr);
                }
            }
        });
        List<ZeusPluginStateListener> list = h.a().f10818b;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<ZeusPluginStateListener> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onStateChangeOnCurThread(TextUtils.isEmpty(str) ? GrsBaseInfo.CountryCodeSource.UNKNOWN : str, i10, objArr);
        }
    }

    @Deprecated
    public void onPluginStateChange(String str, int i10, Object... objArr) {
    }

    public void onStateChangeOnCurThread(String str, int i10, Object... objArr) {
    }
}
