package com.kwad.sdk.crash.utils;

import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i {
    private static SimpleDateFormat aHS = new SimpleDateFormat(TimeUtils.STARD_FROMAT);

    public static String ax(long j10) {
        return j10 <= 0 ? "unknown" : aHS.format(new Date(j10));
    }
}
