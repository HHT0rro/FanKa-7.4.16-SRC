package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class am extends af {
    private static final String B = "anchorViewX";
    private static final String C = "anchorViewY";
    private static final int D = -1;
    private static final String F = "anchorHeight";
    private static final String S = "anchorWidth";
    private static final String Z = "JsbStartComplianceActivity";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements ab {
        private Context Code;
        private RemoteCallResultCallback<String> I;
        private String V;
        private String Z;

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2) {
            this.Code = context;
            this.V = str;
            this.I = remoteCallResultCallback;
            this.Z = str2;
        }

        @Override // com.huawei.hms.ads.ab
        public void Code(AdContentData adContentData) {
            if (adContentData == null || aa.Code(adContentData.aG())) {
                gl.I(am.Z, "content is null or compliance is null.");
            }
            try {
                JSONObject jSONObject = new JSONObject(this.V);
                int optInt = jSONObject.optInt(am.B, -1);
                int optInt2 = jSONObject.optInt(am.C, -1);
                if (-1 == optInt || -1 == optInt2) {
                    gl.I(am.Z, "invalid anchor loc");
                }
                int optInt3 = jSONObject.optInt(am.S, -1);
                int optInt4 = jSONObject.optInt(am.F, -1);
                if (-1 == optInt3 || -1 == optInt4) {
                    gl.I(am.Z, "invalid anchor size");
                }
                int[] iArr = {optInt, optInt2};
                int[] iArr2 = {optInt3, optInt4};
                if (gl.Code()) {
                    gl.Code(am.Z, "parse param complete, anchor loc (%s, %s), anchor size (%s, %s)", Integer.valueOf(optInt), Integer.valueOf(optInt2), Integer.valueOf(optInt3), Integer.valueOf(optInt4));
                }
                ComplianceActivity.Code(new b(this.I, this.Z));
                ComplianceActivity.Code(this.Code, iArr, iArr2, adContentData, true);
            } catch (Throwable th) {
                gl.I(am.Z, "parse param ex: %s", th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements com.huawei.openalliance.ad.activity.b {
        private String Code;
        private RemoteCallResultCallback<String> V;

        public b(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.V = remoteCallResultCallback;
            this.Code = str;
        }

        @Override // com.huawei.openalliance.ad.activity.b
        public void Code() {
            gl.V(am.Z, "onActivityShow");
            af.Code(this.V, this.Code, 1000, 5001, false);
        }

        @Override // com.huawei.openalliance.ad.activity.b
        public void V() {
            gl.V(am.Z, "onActivityFinish");
            af.Code(this.V, this.Code, 1000, 5002, false);
            ComplianceActivity.S();
        }
    }

    public am() {
        super(ai.f29048x);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Code(context, str, true, (ab) new a(context, str, remoteCallResultCallback, this.Code));
        } catch (Throwable th) {
            gl.I(Z, "execute ex: %s", th.getClass().getSimpleName());
        }
    }
}
