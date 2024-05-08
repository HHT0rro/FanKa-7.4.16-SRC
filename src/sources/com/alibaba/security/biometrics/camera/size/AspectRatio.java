package com.alibaba.security.biometrics.camera.size;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SparseArrayCompat;
import com.alibaba.security.biometrics.build.f;
import com.huawei.openalliance.ad.constant.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AspectRatio implements Parcelable, Comparable<AspectRatio> {

    /* renamed from: b, reason: collision with root package name */
    public final int f2417b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2418c;

    /* renamed from: a, reason: collision with root package name */
    public static final AspectRatio f2415a = new AspectRatio(4, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final SparseArrayCompat<SparseArrayCompat<AspectRatio>> f2416d = new SparseArrayCompat<>(16);
    public static final Parcelable.Creator<AspectRatio> CREATOR = new Parcelable.Creator<AspectRatio>() { // from class: com.alibaba.security.biometrics.camera.size.AspectRatio.1
        private static AspectRatio a(Parcel parcel) {
            return AspectRatio.a(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AspectRatio createFromParcel(Parcel parcel) {
            return AspectRatio.a(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AspectRatio[] newArray(int i10) {
            return new AspectRatio[i10];
        }

        private static AspectRatio[] a(int i10) {
            return new AspectRatio[i10];
        }
    };

    private AspectRatio(int i10, int i11) {
        this.f2417b = i10;
        this.f2418c = i11;
    }

    public static AspectRatio a(int i10, int i11) {
        int b4 = b(i10, i11);
        int i12 = i10 / b4;
        int i13 = i11 / b4;
        SparseArrayCompat<SparseArrayCompat<AspectRatio>> sparseArrayCompat = f2416d;
        SparseArrayCompat<AspectRatio> sparseArrayCompat2 = sparseArrayCompat.get(i12);
        if (sparseArrayCompat2 == null) {
            AspectRatio aspectRatio = new AspectRatio(i12, i13);
            SparseArrayCompat<AspectRatio> sparseArrayCompat3 = new SparseArrayCompat<>();
            sparseArrayCompat3.put(i13, aspectRatio);
            sparseArrayCompat.put(i12, sparseArrayCompat3);
            return aspectRatio;
        }
        AspectRatio aspectRatio2 = sparseArrayCompat2.get(i13);
        if (aspectRatio2 != null) {
            return aspectRatio2;
        }
        AspectRatio aspectRatio3 = new AspectRatio(i12, i13);
        sparseArrayCompat2.put(i13, aspectRatio3);
        return aspectRatio3;
    }

    private int b() {
        return this.f2418c;
    }

    private float c() {
        return this.f2417b / this.f2418c;
    }

    private AspectRatio d() {
        return a(this.f2418c, this.f2417b);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(AspectRatio aspectRatio) {
        AspectRatio aspectRatio2 = aspectRatio;
        if (equals(aspectRatio2)) {
            return 0;
        }
        return c() - aspectRatio2.c() > 0.0f ? 1 : -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof AspectRatio) {
            AspectRatio aspectRatio = (AspectRatio) obj;
            if (this.f2417b == aspectRatio.f2417b && this.f2418c == aspectRatio.f2418c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.f2418c;
        int i11 = this.f2417b;
        return i10 ^ ((i11 >>> 16) | (i11 << 16));
    }

    public String toString() {
        return this.f2417b + u.bD + this.f2418c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2417b);
        parcel.writeInt(this.f2418c);
    }

    public static int b(int i10, int i11) {
        while (true) {
            int i12 = i11;
            int i13 = i10;
            i10 = i12;
            if (i10 == 0) {
                return i13;
            }
            i11 = i13 % i10;
        }
    }

    private static AspectRatio a(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            try {
                return a(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException("Malformed aspect ratio: ".concat(str), e2);
            }
        }
        throw new IllegalArgumentException("Malformed aspect ratio: ".concat(str));
    }

    private int a() {
        return this.f2417b;
    }

    private int a(AspectRatio aspectRatio) {
        if (equals(aspectRatio)) {
            return 0;
        }
        return c() - aspectRatio.c() > 0.0f ? 1 : -1;
    }

    private boolean a(f fVar) {
        int b4 = b(fVar.f2297a, fVar.f2298b);
        return this.f2417b == fVar.f2297a / b4 && this.f2418c == fVar.f2298b / b4;
    }
}
