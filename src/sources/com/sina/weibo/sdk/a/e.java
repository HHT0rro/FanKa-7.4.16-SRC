package com.sina.weibo.sdk.a;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.e;
import com.tencent.connect.common.Constants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends c<Void, Void, String> {
    private com.sina.weibo.sdk.net.c<String> Z;

    /* renamed from: aa, reason: collision with root package name */
    private Throwable f38336aa;

    /* renamed from: ad, reason: collision with root package name */
    private Oauth2AccessToken f38337ad;
    private String appKey;

    public e(String str, Oauth2AccessToken oauth2AccessToken, com.sina.weibo.sdk.net.c<String> cVar) {
        this.appKey = str;
        this.f38337ad = oauth2AccessToken;
        this.Z = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.a.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public String o() {
        try {
            e.a aVar = new e.a();
            aVar.f38351i = "https://api.weibo.com/oauth2/access_token";
            return new com.sina.weibo.sdk.net.b().a(aVar.b(Constants.PARAM_CLIENT_ID, this.appKey).b("appKey", this.appKey).b("grant_type", Oauth2AccessToken.KEY_REFRESH_TOKEN).b(Oauth2AccessToken.KEY_REFRESH_TOKEN, this.f38337ad.getRefreshToken()).h()).i();
        } catch (Throwable th) {
            th.printStackTrace();
            this.f38336aa = th;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.a.c
    public final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th = this.f38336aa;
        if (th != null) {
            com.sina.weibo.sdk.net.c<String> cVar = this.Z;
            if (cVar != null) {
                cVar.onError(th);
                return;
            }
            return;
        }
        com.sina.weibo.sdk.net.c<String> cVar2 = this.Z;
        if (cVar2 != null) {
            cVar2.a(str2);
        }
    }
}
