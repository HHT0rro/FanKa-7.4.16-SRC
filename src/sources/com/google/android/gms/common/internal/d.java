package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static int f23659a = 4225;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f23660b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static d f23661c;

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: f, reason: collision with root package name */
        public static final Uri f23662f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f23663a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f23664b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final ComponentName f23665c = null;

        /* renamed from: d, reason: collision with root package name */
        public final int f23666d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f23667e;

        public a(String str, String str2, int i10, boolean z10) {
            this.f23663a = h.e(str);
            this.f23664b = h.e(str2);
            this.f23666d = i10;
            this.f23667e = z10;
        }

        public final Intent a(Context context) {
            if (this.f23663a != null) {
                Intent d10 = this.f23667e ? d(context) : null;
                return d10 == null ? new Intent(this.f23663a).setPackage(this.f23664b) : d10;
            }
            return new Intent().setComponent(this.f23665c);
        }

        @Nullable
        public final String b() {
            return this.f23664b;
        }

        @Nullable
        public final ComponentName c() {
            return this.f23665c;
        }

        @Nullable
        public final Intent d(Context context) {
            Bundle bundle;
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.f23663a);
            try {
                bundle = context.getContentResolver().call(f23662f, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 34);
                sb2.append("Dynamic intent resolution failed: ");
                sb2.append(valueOf);
                bundle = null;
            }
            Intent intent = bundle != null ? (Intent) bundle.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                String valueOf2 = String.valueOf(this.f23663a);
                if (valueOf2.length() != 0) {
                    "Dynamic lookup for intent failed for action: ".concat(valueOf2);
                }
            }
            return intent;
        }

        public final int e() {
            return this.f23666d;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return g.a(this.f23663a, aVar.f23663a) && g.a(this.f23664b, aVar.f23664b) && g.a(this.f23665c, aVar.f23665c) && this.f23666d == aVar.f23666d && this.f23667e == aVar.f23667e;
        }

        public final int hashCode() {
            return g.b(this.f23663a, this.f23664b, this.f23665c, Integer.valueOf(this.f23666d), Boolean.valueOf(this.f23667e));
        }

        public final String toString() {
            String str = this.f23663a;
            if (str != null) {
                return str;
            }
            h.h(this.f23665c);
            return this.f23665c.flattenToString();
        }
    }

    @RecentlyNonNull
    public static int a() {
        return f23659a;
    }

    @RecentlyNonNull
    public static d b(@RecentlyNonNull Context context) {
        synchronized (f23660b) {
            if (f23661c == null) {
                f23661c = new y(context.getApplicationContext());
            }
        }
        return f23661c;
    }

    public final void c(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull int i10, @RecentlyNonNull ServiceConnection serviceConnection, @RecentlyNonNull String str3, @RecentlyNonNull boolean z10) {
        e(new a(str, str2, i10, z10), serviceConnection, str3);
    }

    public abstract boolean d(a aVar, ServiceConnection serviceConnection, String str);

    public abstract void e(a aVar, ServiceConnection serviceConnection, String str);
}
