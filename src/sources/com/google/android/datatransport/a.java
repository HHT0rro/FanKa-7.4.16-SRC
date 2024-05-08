package com.google.android.datatransport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* compiled from: Encoding.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f19305a;

    public a(@NonNull String str) {
        Objects.requireNonNull(str, "name is null");
        this.f19305a = str;
    }

    public static a b(@NonNull String str) {
        return new a(str);
    }

    public String a() {
        return this.f19305a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return this.f19305a.equals(((a) obj).f19305a);
        }
        return false;
    }

    public int hashCode() {
        return this.f19305a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.f19305a + "\"}";
    }
}
