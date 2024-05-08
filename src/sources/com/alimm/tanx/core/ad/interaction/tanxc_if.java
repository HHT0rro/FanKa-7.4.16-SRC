package com.alimm.tanx.core.ad.interaction;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.interaction.tanxc_for;
import com.alimm.tanx.core.utils.LogUtils;

/* compiled from: AdWebNavHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_if {
    public static boolean tanxc_do(Context context, String str, BidInfo bidInfo) {
        tanxc_for tanxc_forVar;
        if (!(!tanxc_do(str))) {
            return false;
        }
        tanxc_forVar = tanxc_for.tanxc_do.tanxc_do;
        return tanxc_forVar.tanxc_do(context, str, bidInfo);
    }

    public static boolean tanxc_do(int i10, long j10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 5 || i10 == 6 || i10 == 7 || i10 == 8) {
                return true;
            }
        } else {
            if (j10 == -1) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isUserHit: diff = ");
            long j11 = currentTimeMillis - j10;
            sb2.append(j11);
            sb2.append(", hitTest = ");
            sb2.append(5000);
            LogUtils.d("AdWebHelper", sb2.toString());
            if (j11 > 5000) {
                return true;
            }
        }
        return false;
    }

    public static boolean tanxc_do(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://");
    }
}
