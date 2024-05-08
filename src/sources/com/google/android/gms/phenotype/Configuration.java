package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import m7.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class Configuration extends AbstractSafeParcelable implements Comparable<Configuration> {
    public static final Parcelable.Creator<Configuration> CREATOR = new m7.b();

    /* renamed from: b, reason: collision with root package name */
    public final int f25783b;

    /* renamed from: c, reason: collision with root package name */
    public final zzi[] f25784c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f25785d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<String, zzi> f25786e = new TreeMap();

    public Configuration(int i10, zzi[] zziVarArr, String[] strArr) {
        this.f25783b = i10;
        this.f25784c = zziVarArr;
        for (zzi zziVar : zziVarArr) {
            this.f25786e.put(zziVar.f25802b, zziVar);
        }
        this.f25785d = strArr;
        if (strArr != null) {
            Arrays.sort(strArr);
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Configuration configuration) {
        return this.f25783b - configuration.f25783b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Configuration) {
            Configuration configuration = (Configuration) obj;
            if (this.f25783b == configuration.f25783b && h.a(this.f25786e, configuration.f25786e) && Arrays.equals(this.f25785d, configuration.f25785d)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Configuration(");
        sb2.append(this.f25783b);
        sb2.append(", ");
        sb2.append("(");
        Iterator<zzi> iterator2 = this.f25786e.values().iterator2();
        while (iterator2.hasNext()) {
            sb2.append((Object) iterator2.next());
            sb2.append(", ");
        }
        sb2.append(")");
        sb2.append(", ");
        sb2.append("(");
        String[] strArr = this.f25785d;
        if (strArr != null) {
            for (String str : strArr) {
                sb2.append(str);
                sb2.append(", ");
            }
        } else {
            sb2.append("null");
        }
        sb2.append(")");
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 2, this.f25783b);
        w6.a.r(parcel, 3, this.f25784c, i10, false);
        w6.a.p(parcel, 4, this.f25785d, false);
        w6.a.b(parcel, a10);
    }
}
