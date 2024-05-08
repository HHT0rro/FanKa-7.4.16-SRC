package com.cupidapp.live.base.utils;

import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReportHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n0 f12353a = new n0();

    @Nullable
    public final String a(@NotNull SensorPosition source) {
        ConstantsUrlModel urlModel;
        String urlReportGuide;
        kotlin.jvm.internal.s.i(source, "source");
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 == null || (urlModel = q10.getUrlModel()) == null || (urlReportGuide = urlModel.getUrlReportGuide()) == null) {
            return null;
        }
        return urlReportGuide + "?operationSource=" + ((Object) source);
    }

    @Nullable
    public final String b(@Nullable String str, @NotNull SensorPosition source, @Nullable String str2) {
        ConstantsUrlModel urlModel;
        String urlReport;
        kotlin.jvm.internal.s.i(source, "source");
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 == null || (urlModel = q10.getUrlModel()) == null || (urlReport = urlModel.getUrlReport()) == null) {
            return null;
        }
        String str3 = urlReport + "?operationSource=" + ((Object) source);
        if (!(str == null || str.length() == 0)) {
            str3 = str3 + "&reportData=" + str;
        }
        if (!(str2 == null || str2.length() == 0)) {
            str3 = str3 + "&reportedUserId=" + str2;
        }
        j.f12332a.a("reportUrl", "url:" + str3);
        return str3;
    }

    @Nullable
    public final String c(@Nullable String str, @NotNull String source, @Nullable String str2) {
        ConstantsUrlModel urlModel;
        String urlReport;
        kotlin.jvm.internal.s.i(source, "source");
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 == null || (urlModel = q10.getUrlModel()) == null || (urlReport = urlModel.getUrlReport()) == null) {
            return null;
        }
        String str3 = urlReport + "?operationSource=" + source;
        if (!(str == null || str.length() == 0)) {
            str3 = str3 + "&reportData=" + str;
        }
        if (!(str2 == null || str2.length() == 0)) {
            str3 = str3 + "&reportedUserId=" + str2;
        }
        j.f12332a.a("reportUrl", "url:" + str3);
        return str3;
    }
}
