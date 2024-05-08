package wc;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/* compiled from: IdStorageManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public static final String f54340b = "dexe";

    /* renamed from: c, reason: collision with root package name */
    public static e f54341c;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f54342a;

    /* compiled from: IdStorageManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f54343b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f54344c;

        public a(String str, String str2) {
            this.f54343b = str;
            this.f54344c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SharedPreferences.Editor edit = e.this.f54342a.edit();
                edit.putString(this.f54343b, this.f54344c);
                edit.apply();
            } catch (Exception unused) {
                String unused2 = e.f54340b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("putString异常 key");
                sb2.append(this.f54343b);
                sb2.append(" value:");
                sb2.append(this.f54344c);
            }
        }
    }

    public e(Context context) {
        this.f54342a = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static e d(Context context) {
        if (f54341c == null) {
            synchronized (e.class) {
                if (f54341c == null) {
                    f54341c = new e(context);
                }
            }
        }
        return f54341c;
    }

    public String c(String str) {
        try {
            return this.f54342a.getString(str, "");
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getString异常 key:");
            sb2.append(str);
            return "";
        }
    }

    public void e(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            f(str, str2);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("key:");
        sb2.append(str);
        sb2.append(" v");
        sb2.append(str2);
        sb2.append(" 过程有key或value为空，终止");
    }

    public void f(String str, String str2) {
        h.b(new a(str, str2));
    }
}
