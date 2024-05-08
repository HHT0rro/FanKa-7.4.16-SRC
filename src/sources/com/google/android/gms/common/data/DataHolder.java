package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import v6.b;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
@KeepName
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @RecentlyNonNull
    public static final Parcelable.Creator<DataHolder> CREATOR = new b();

    /* renamed from: l, reason: collision with root package name */
    public static final a f23528l = new com.google.android.gms.common.data.a(new String[0], null);

    /* renamed from: b, reason: collision with root package name */
    public final int f23529b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f23530c;

    /* renamed from: d, reason: collision with root package name */
    public Bundle f23531d;

    /* renamed from: e, reason: collision with root package name */
    public final CursorWindow[] f23532e;

    /* renamed from: f, reason: collision with root package name */
    public final int f23533f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final Bundle f23534g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f23535h;

    /* renamed from: i, reason: collision with root package name */
    public int f23536i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f23537j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f23538k = true;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class zaa extends RuntimeException {
        public zaa(String str) {
            super(str);
        }
    }

    public DataHolder(int i10, String[] strArr, CursorWindow[] cursorWindowArr, int i11, @Nullable Bundle bundle) {
        this.f23529b = i10;
        this.f23530c = strArr;
        this.f23532e = cursorWindowArr;
        this.f23533f = i11;
        this.f23534g = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.f23537j) {
                this.f23537j = true;
                int i10 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.f23532e;
                    if (i10 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i10].close();
                    i10++;
                }
            }
        }
    }

    @RecentlyNullable
    public final Bundle f() {
        return this.f23534g;
    }

    public final void finalize() throws Throwable {
        try {
            if (this.f23538k && this.f23532e.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 178);
                sb2.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb2.append(obj);
                sb2.append(")");
            }
        } finally {
            super.finalize();
        }
    }

    @RecentlyNonNull
    public final int g() {
        return this.f23533f;
    }

    public final void i() {
        this.f23531d = new Bundle();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr = this.f23530c;
            if (i11 >= strArr.length) {
                break;
            }
            this.f23531d.putInt(strArr[i11], i11);
            i11++;
        }
        this.f23535h = new int[this.f23532e.length];
        int i12 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f23532e;
            if (i10 < cursorWindowArr.length) {
                this.f23535h[i10] = i12;
                i12 += this.f23532e[i10].getNumRows() - (i12 - cursorWindowArr[i10].getStartPosition());
                i10++;
            } else {
                this.f23536i = i12;
                return;
            }
        }
    }

    @RecentlyNonNull
    public final boolean isClosed() {
        boolean z10;
        synchronized (this) {
            z10 = this.f23537j;
        }
        return z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.p(parcel, 1, this.f23530c, false);
        w6.a.r(parcel, 2, this.f23532e, i10, false);
        w6.a.j(parcel, 3, g());
        w6.a.d(parcel, 4, f(), false);
        w6.a.j(parcel, 1000, this.f23529b);
        w6.a.b(parcel, a10);
        if ((i10 & 1) != 0) {
            close();
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f23539a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<HashMap<String, Object>> f23540b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f23541c;

        /* renamed from: d, reason: collision with root package name */
        public final HashMap<Object, Integer> f23542d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f23543e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public String f23544f;

        public a(String[] strArr, @Nullable String str) {
            this.f23539a = (String[]) h.h(strArr);
            this.f23540b = new ArrayList<>();
            this.f23541c = null;
            this.f23542d = new HashMap<>();
            this.f23543e = false;
            this.f23544f = null;
        }

        public /* synthetic */ a(String[] strArr, String str, com.google.android.gms.common.data.a aVar) {
            this(strArr, null);
        }
    }
}
