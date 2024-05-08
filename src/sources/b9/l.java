package b9;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final a9.b f1452a;

    public l(Context context, String str) {
        this.f1452a = (TextUtils.isEmpty(a(context, str)) || Build.VERSION.SDK_INT < 26) ? new h(context, str) : new i(context, str);
    }

    public final String a(Context context, String str) {
        String b4 = m.b(context, str, "agc_plugin_", "crypto");
        if (b4 == null) {
            return null;
        }
        try {
            return new String(a.b(b4), "utf-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("UnsupportedEncodingException");
            sb2.append(e2.getMessage());
            return null;
        }
    }

    public String b(String str, String str2) {
        return this.f1452a.decrypt(str, str2);
    }
}
