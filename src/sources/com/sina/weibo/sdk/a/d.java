package com.sina.weibo.sdk.a;

import android.content.Context;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends c<Void, Void, String> {
    private com.sina.weibo.sdk.net.c<String> Z;

    /* renamed from: aa, reason: collision with root package name */
    private Throwable f38333aa;

    /* renamed from: ab, reason: collision with root package name */
    private String f38334ab;

    /* renamed from: ac, reason: collision with root package name */
    private String f38335ac;
    private String appKey;
    private Context context;

    public d(Context context, String str, String str2, String str3, com.sina.weibo.sdk.net.c<String> cVar) {
        this.context = context;
        this.f38334ab = str;
        this.appKey = str2;
        this.f38335ac = str3;
        this.Z = cVar;
    }

    private String e(String str) {
        return HttpManager.a(this.context, com.sina.weibo.sdk.b.e.r(), this.f38335ac, this.appKey, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.a.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public String o() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            e.a aVar = new e.a();
            aVar.f38351i = "https://service.weibo.com/share/mobilesdk_uppic.php";
            return new com.sina.weibo.sdk.net.b().a(aVar.a("aid", com.sina.weibo.sdk.b.e.r()).a("oauth_timestamp", valueOf).a("oauth_sign", e(valueOf)).b("appKey", this.appKey).b("aid", com.sina.weibo.sdk.b.e.r()).b("oauth_timestamp", valueOf).b("oauth_sign", e(valueOf)).b("img", this.f38334ab).h()).i();
        } catch (Throwable th) {
            th.printStackTrace();
            this.f38333aa = th;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.a.c
    public final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th = this.f38333aa;
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
