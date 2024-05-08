package com.wangmai.ad.dex.allmodules.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.textclassifier.TextClassifier;
import com.wangmai.common.bean.MediaAdSlotIdConfig;
import com.wangmai.common.bean.Optimization;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: OptimizeUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appp {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: OptimizeUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Context f46858appa;
        final /* synthetic */ Optimization appb;

        appa(Context context, Optimization optimization) {
            this.f46858appa = context;
            this.appb = optimization;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ClipboardManager) this.f46858appa.getSystemService(TextClassifier.WIDGET_TYPE_CLIPBOARD)).setPrimaryClip(ClipData.newPlainText("Label", this.appb.getCopyContent()));
        }
    }

    public static void appa(MediaAdSlotIdConfig mediaAdSlotIdConfig, Context context) {
        if (mediaAdSlotIdConfig != null) {
            appa(context, mediaAdSlotIdConfig.getSdkAdslotConfig().getOptimization());
        }
    }

    private static void appa(Context context, Optimization optimization) {
        if (optimization != null) {
            try {
                if (TextUtils.isEmpty(optimization.getCopyContent())) {
                    return;
                }
                new Handler().postDelayed(new appa(context, optimization), 1000L);
            } catch (Throwable th) {
                appa.appa.appf.appd.appa("OptimizeUtils", "fetchClipboard:" + th.toString());
            }
        }
    }
}
