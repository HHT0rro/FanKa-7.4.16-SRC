package s6;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.h;
import com.huawei.openalliance.ad.constant.u;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static final Lock f53625c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static b f53626d;

    /* renamed from: a, reason: collision with root package name */
    public final Lock f53627a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f53628b;

    public b(Context context) {
        this.f53628b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @RecentlyNonNull
    public static b a(@RecentlyNonNull Context context) {
        h.h(context);
        Lock lock = f53625c;
        lock.lock();
        try {
            if (f53626d == null) {
                f53626d = new b(context.getApplicationContext());
            }
            b bVar = f53626d;
            lock.unlock();
            return bVar;
        } catch (Throwable th) {
            f53625c.unlock();
            throw th;
        }
    }

    public static String d(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(u.bD);
        sb2.append(str2);
        return sb2.toString();
    }

    @RecentlyNullable
    public GoogleSignInAccount b() {
        return c(e("defaultGoogleSignInAccount"));
    }

    @Nullable
    public final GoogleSignInAccount c(@Nullable String str) {
        String e2;
        if (!TextUtils.isEmpty(str) && (e2 = e(d("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.w(e2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Nullable
    public final String e(String str) {
        this.f53627a.lock();
        try {
            return this.f53628b.getString(str, null);
        } finally {
            this.f53627a.unlock();
        }
    }
}
