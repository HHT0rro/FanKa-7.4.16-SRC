package org.joda.time.chrono;

import org.joda.time.DateTimeZone;
import org.joda.time.Instant;

/* compiled from: GJCacheKey.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeZone f52504a;

    /* renamed from: b, reason: collision with root package name */
    public final Instant f52505b;

    /* renamed from: c, reason: collision with root package name */
    public final int f52506c;

    public h(DateTimeZone dateTimeZone, Instant instant, int i10) {
        this.f52504a = dateTimeZone;
        this.f52505b = instant;
        this.f52506c = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        Instant instant = this.f52505b;
        if (instant == null) {
            if (hVar.f52505b != null) {
                return false;
            }
        } else if (!instant.equals(hVar.f52505b)) {
            return false;
        }
        if (this.f52506c != hVar.f52506c) {
            return false;
        }
        DateTimeZone dateTimeZone = this.f52504a;
        if (dateTimeZone == null) {
            if (hVar.f52504a != null) {
                return false;
            }
        } else if (!dateTimeZone.equals(hVar.f52504a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Instant instant = this.f52505b;
        int hashCode = ((((instant == null ? 0 : instant.hashCode()) + 31) * 31) + this.f52506c) * 31;
        DateTimeZone dateTimeZone = this.f52504a;
        return hashCode + (dateTimeZone != null ? dateTimeZone.hashCode() : 0);
    }
}
