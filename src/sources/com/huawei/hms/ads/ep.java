package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.analysis.DynamicLoaderAnalysis;
import com.huawei.hms.ads.analysis.IDynamicLoaderAnalysis;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ep {
    private static final String Code = "decouple";
    private static a V;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements IDynamicLoaderAnalysis {
        private Context Code;

        public a(Context context) {
            this.Code = context.getApplicationContext();
        }

        @Override // com.huawei.hms.ads.analysis.IDynamicLoaderAnalysis
        public void onLoaderException(String str, String str2, int i10, String str3) {
            eo.Code(this.Code, str, str2, i10, str3);
        }

        @Override // com.huawei.hms.ads.analysis.IDynamicLoaderAnalysis
        public void onLoaderSuccess(String str, String str2, long j10) {
            eo.Code(this.Code, str, str2, j10);
        }
    }

    public static void Code(Context context) {
        if (V == null) {
            V = new a(context);
        }
        DynamicLoaderAnalysis.getInstance().registerDynamicLoaderAnalysis(Code, V);
    }
}
