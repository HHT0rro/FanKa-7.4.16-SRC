package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.WebData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b {
    public WebData aA;
    public String aB;
    public Context context;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void onComplete();

        void onError(String str);
    }

    public b() {
    }

    public abstract void a(Bundle bundle);

    public void a(a aVar) {
    }

    public abstract void b(Bundle bundle);

    public abstract String getUrl();

    public final void readFromBundle(Bundle bundle) {
        this.aA = (WebData) bundle.getParcelable("web_data");
        this.aB = bundle.getString("_weibo_transaction");
        b(bundle);
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    public final Bundle writeToBundle(Bundle bundle) {
        bundle.putParcelable("web_data", this.aA);
        int type = this.aA.getType();
        if (type == 1) {
            bundle.putInt("web_type", 1);
        } else if (type == 2) {
            bundle.putInt("web_type", 2);
        } else if (type == 3) {
            bundle.putInt("web_type", 3);
        }
        bundle.putString("_weibo_transaction", this.aB);
        a(bundle);
        return bundle;
    }

    public boolean x() {
        return false;
    }

    public final WebData y() {
        return this.aA;
    }

    public b(AuthInfo authInfo, int i10, String str, String str2) {
        this.aA = new WebData(authInfo, i10, str, str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        this.aB = sb2.toString();
    }
}
