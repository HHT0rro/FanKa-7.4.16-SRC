package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b7.d;
import b7.f;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r6.a;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();

    /* renamed from: o, reason: collision with root package name */
    public static d f23263o = f.c();

    /* renamed from: b, reason: collision with root package name */
    public final int f23264b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f23265c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f23266d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public String f23267e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f23268f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Uri f23269g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public String f23270h;

    /* renamed from: i, reason: collision with root package name */
    public long f23271i;

    /* renamed from: j, reason: collision with root package name */
    public String f23272j;

    /* renamed from: k, reason: collision with root package name */
    public List<Scope> f23273k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public String f23274l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public String f23275m;

    /* renamed from: n, reason: collision with root package name */
    public Set<Scope> f23276n = new HashSet();

    public GoogleSignInAccount(int i10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Uri uri, @Nullable String str5, long j10, String str6, List<Scope> list, @Nullable String str7, @Nullable String str8) {
        this.f23264b = i10;
        this.f23265c = str;
        this.f23266d = str2;
        this.f23267e = str3;
        this.f23268f = str4;
        this.f23269g = uri;
        this.f23270h = str5;
        this.f23271i = j10;
        this.f23272j = str6;
        this.f23273k = list;
        this.f23274l = str7;
        this.f23275m = str8;
    }

    @RecentlyNullable
    public static GoogleSignInAccount w(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(jSONArray.getString(i10)));
        }
        GoogleSignInAccount x10 = x(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        x10.f23270h = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return x10;
    }

    public static GoogleSignInAccount x(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l10, @NonNull String str7, @NonNull Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, (l10 == null ? Long.valueOf(f23263o.b() / 1000) : l10).longValue(), h.e(str7), new ArrayList((Collection) h.h(set)), str5, str6);
    }

    @RecentlyNonNull
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f23272j.equals(this.f23272j) && googleSignInAccount.r().equals(r());
    }

    @RecentlyNullable
    public String f() {
        return this.f23268f;
    }

    @RecentlyNullable
    public String g() {
        return this.f23267e;
    }

    @RecentlyNullable
    public Account getAccount() {
        if (this.f23267e == null) {
            return null;
        }
        return new Account(this.f23267e, "com.google");
    }

    @RecentlyNonNull
    public int hashCode() {
        return ((this.f23272j.hashCode() + MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE) * 31) + r().hashCode();
    }

    @RecentlyNullable
    public String i() {
        return this.f23275m;
    }

    @RecentlyNullable
    public String j() {
        return this.f23274l;
    }

    @RecentlyNullable
    public String k() {
        return this.f23265c;
    }

    @RecentlyNullable
    public String l() {
        return this.f23266d;
    }

    @RecentlyNullable
    public Uri m() {
        return this.f23269g;
    }

    @NonNull
    public Set<Scope> r() {
        HashSet hashSet = new HashSet(this.f23273k);
        hashSet.addAll(this.f23276n);
        return hashSet;
    }

    @RecentlyNullable
    public String u() {
        return this.f23270h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23264b);
        w6.a.o(parcel, 2, k(), false);
        w6.a.o(parcel, 3, l(), false);
        w6.a.o(parcel, 4, g(), false);
        w6.a.o(parcel, 5, f(), false);
        w6.a.n(parcel, 6, m(), i10, false);
        w6.a.o(parcel, 7, u(), false);
        w6.a.l(parcel, 8, this.f23271i);
        w6.a.o(parcel, 9, this.f23272j, false);
        w6.a.s(parcel, 10, this.f23273k, false);
        w6.a.o(parcel, 11, j(), false);
        w6.a.o(parcel, 12, i(), false);
        w6.a.b(parcel, a10);
    }
}
