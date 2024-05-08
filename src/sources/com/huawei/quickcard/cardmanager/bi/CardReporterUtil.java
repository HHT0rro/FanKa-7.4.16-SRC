package com.huawei.quickcard.cardmanager.bi;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardReporterUtil {

    /* renamed from: a, reason: collision with root package name */
    private static Reporter f33532a;

    public static int getHostVersionCode(Context context) {
        Reporter reporter = f33532a;
        if (reporter != null) {
            return reporter.getHostVersionCode(context);
        }
        return -1;
    }

    public static void reportDownload(Context context, CardReportBean cardReportBean) {
        Reporter reporter = f33532a;
        if (reporter != null) {
            reporter.reportDownload(context, cardReportBean);
        }
    }

    public static void setReporter(Reporter reporter) {
        f33532a = reporter;
    }
}
