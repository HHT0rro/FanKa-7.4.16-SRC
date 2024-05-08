package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class f {
    public static void Code(Context context, long j10, m.a aVar) {
        com.huawei.openalliance.ad.utils.m.Code(context, context.getString(R.string.hiad_reminder_app_over_size, Long.valueOf(j10)), context.getString(R.string.hiad_download_app_via_mobile_data), context.getString(R.string.hiad_continue_download_new), context.getString(R.string.hiad_dialog_cancel), aVar);
    }

    public static void Code(Context context, m.a aVar) {
        com.huawei.openalliance.ad.utils.m.Code(context, "", context.getString(R.string.hiad_confirm_download_app), context.getString(R.string.hiad_download_install), context.getString(R.string.hiad_dialog_cancel), aVar);
    }

    public static void V(Context context, long j10, m.a aVar) {
        com.huawei.openalliance.ad.utils.m.Code(context, context.getString(R.string.hiad_dialog_title_tip), com.huawei.openalliance.ad.utils.h.Code(context, R.string.hiad_download_use_mobile_network, "hiad_download_use_mobile_network", au.Code(context, j10)), context.getString(R.string.hiad_continue_download_new), context.getString(R.string.hiad_dialog_cancel), aVar);
    }
}
