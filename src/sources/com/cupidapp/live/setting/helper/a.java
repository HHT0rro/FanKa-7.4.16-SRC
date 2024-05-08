package com.cupidapp.live.setting.helper;

import android.net.Uri;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SwitchAccountHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f18182a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f18183b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final Uri f18184c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f18185d;

    public a(boolean z10, boolean z11, @Nullable Uri uri, @Nullable String str) {
        this.f18182a = z10;
        this.f18183b = z11;
        this.f18184c = uri;
        this.f18185d = str;
    }

    @Nullable
    public final Uri a() {
        return this.f18184c;
    }

    @Nullable
    public final String b() {
        return this.f18185d;
    }

    public final boolean c() {
        return this.f18182a;
    }

    public final boolean d() {
        return this.f18183b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f18182a == aVar.f18182a && this.f18183b == aVar.f18183b && s.d(this.f18184c, aVar.f18184c) && s.d(this.f18185d, aVar.f18185d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z10 = this.f18182a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.f18183b;
        int i11 = (i10 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        Uri uri = this.f18184c;
        int hashCode = (i11 + (uri == null ? 0 : uri.hashCode())) * 31;
        String str = this.f18185d;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        boolean z10 = this.f18182a;
        boolean z11 = this.f18183b;
        Uri uri = this.f18184c;
        return "SwitchAccountLoginConfig(isJumpSettingPage=" + z10 + ", isShowToast=" + z11 + ", intentData=" + ((Object) uri) + ", intentExtras=" + this.f18185d + ")";
    }

    public /* synthetic */ a(boolean z10, boolean z11, Uri uri, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, z11, (i10 & 4) != 0 ? null : uri, (i10 & 8) != 0 ? null : str);
    }
}
