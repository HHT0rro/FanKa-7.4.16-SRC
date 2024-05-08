package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.realidentity.R;
import com.alibaba.security.realidentity.activity.RPWebViewActivity;
import com.alibaba.security.realidentity.view.RPTopBar;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SetTitleApi.java */
@aw(a = "setTitle,rpSetTitle")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class br extends aq {
    private static boolean d() {
        return true;
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return com.alipay.sdk.widget.j.f4798d;
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean c() {
        return false;
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, ay ayVar) {
        try {
            final String string = new JSONObject(str).getString(aq.f3109e);
            Context context = this.al;
            if (context != null && (context instanceof RPWebViewActivity)) {
                ((RPWebViewActivity) context).runOnUiThread(new Runnable() { // from class: com.alibaba.security.realidentity.build.br.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        RPWebViewActivity rPWebViewActivity = (RPWebViewActivity) br.this.al;
                        ((RPTopBar) rPWebViewActivity.findViewById(R.id.topBar)).setTitle(string);
                    }
                });
                ayVar.b();
                a(new bf("success"), true);
                return true;
            }
            aq.b("SetTitleApi context is not RPWebViewActivity: " + ((Object) this.al));
            a(aq.a(ayVar, "context is not RPWebViewActivity"), false);
            return false;
        } catch (JSONException e2) {
            aq.a("SetTitleApi json parse error", CommonUtils.getStackTrace(e2));
            aq.a(ayVar);
            return false;
        }
    }
}
