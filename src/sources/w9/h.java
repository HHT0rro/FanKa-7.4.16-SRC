package w9;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f54308a;

    public h(Context context, String str) {
        this.f54308a = context.getSharedPreferences(str, 0);
    }

    public String a(String str, String str2) {
        try {
            return this.f54308a.getString(str, str2);
        } catch (Exception unused) {
            this.f54308a.edit().remove(str).commit();
            return str2;
        }
    }

    public void b(String str, String str2) {
        try {
            SharedPreferences.Editor edit = this.f54308a.edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Exception e2) {
            m.b("BaseSharedPreference", "putString error!!key:" + str, e2);
        }
    }
}
