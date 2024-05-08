package com.hifive.sdk.net;

import com.hifive.sdk.common.BaseConstance;
import com.hifive.sdk.manager.HFLiveApi;
import com.huawei.openalliance.ad.constant.u;
import java.net.URLEncoder;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: DefaultHeaderInterceptor.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class DefaultHeaderInterceptor implements Interceptor {
    private final String getValueEncoded(String str) {
        String A = p.A(str, "\n", "", false, 4, null);
        int length = A.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = A.charAt(i10);
            if (charAt <= 31 || charAt >= 127) {
                String encode = URLEncoder.encode(A, "UTF-8");
                s.e(encode, "URLEncoder.encode(newValue, \"UTF-8\")");
                return encode;
            }
        }
        return A;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        String str;
        String str2;
        s.j(chain, "chain");
        BaseConstance.Companion companion = BaseConstance.Companion;
        String accessTokenMember = companion.getAccessTokenMember();
        if (accessTokenMember == null) {
            accessTokenMember = companion.getAccessTokenUnion();
        }
        if (companion.getAccessTokenMember() != null) {
            str = companion.getMemberOutId();
            if (str == null) {
                str = "";
            }
            str2 = companion.getSocietyOutId();
            if (str2 == null) {
                str2 = "";
            }
        } else {
            str = "";
            str2 = str;
        }
        if (companion.getAccessTokenUnion() != null) {
            String societyOutId = companion.getSocietyOutId();
            str2 = societyOutId != null ? societyOutId : "";
            str = "";
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        Request.Builder newBuilder = chain.request().newBuilder();
        HFLiveApi.Companion companion2 = HFLiveApi.Companion;
        String secret = companion2.getSECRET();
        if (secret == null) {
            s.u();
        }
        if (accessTokenMember == null) {
            accessTokenMember = "";
        }
        String signToken = companion.getSignToken(secret, accessTokenMember, valueOf);
        if (signToken == null) {
            signToken = "";
        }
        Request.Builder addHeader = newBuilder.addHeader(u.cO, signToken);
        String app_id = companion2.getAPP_ID();
        Request.Builder addHeader2 = addHeader.addHeader("appId", app_id != null ? app_id : "").addHeader("timestamp", valueOf);
        if (!p.t(str)) {
            addHeader2.addHeader("memberOutId", getValueEncoded(str));
        }
        if (!p.t(str2)) {
            addHeader2.addHeader("sociatyOutId", getValueEncoded(str2));
        }
        addHeader2.addHeader("X-HF-Version", getValueEncoded(companion.getVerison()));
        return chain.proceed(addHeader2.build());
    }
}
