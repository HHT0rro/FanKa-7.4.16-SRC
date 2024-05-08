package o8;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.mlkit_vision_face.u9;
import com.google.android.gms.internal.mlkit_vision_face.v9;
import com.google.android.gms.internal.mlkit_vision_face.zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzf;
import com.google.android.gms.internal.mlkit_vision_face.zzlf;
import com.google.android.gms.internal.mlkit_vision_face.zzlj;
import com.google.android.gms.internal.mlkit_vision_face.zzlp;
import com.google.android.gms.internal.mlkit_vision_face.zzn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.zip.ZipUtils;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f52362a;

    /* renamed from: b, reason: collision with root package name */
    public int f52363b;

    /* renamed from: c, reason: collision with root package name */
    public final float f52364c;

    /* renamed from: d, reason: collision with root package name */
    public final float f52365d;

    /* renamed from: e, reason: collision with root package name */
    public final float f52366e;

    /* renamed from: f, reason: collision with root package name */
    public final float f52367f;

    /* renamed from: g, reason: collision with root package name */
    public final float f52368g;

    /* renamed from: h, reason: collision with root package name */
    public final float f52369h;

    /* renamed from: i, reason: collision with root package name */
    public final SparseArray<e> f52370i = new SparseArray<>();

    /* renamed from: j, reason: collision with root package name */
    public final SparseArray<b> f52371j = new SparseArray<>();

    public a(@NonNull zzf zzfVar) {
        float f10 = zzfVar.f25375d;
        float f11 = zzfVar.f25377f / 2.0f;
        float f12 = zzfVar.f25376e;
        float f13 = zzfVar.f25378g / 2.0f;
        this.f52362a = new Rect((int) (f10 - f11), (int) (f12 - f13), (int) (f10 + f11), (int) (f12 + f13));
        this.f52363b = zzfVar.f25374c;
        for (zzn zznVar : zzfVar.f25382k) {
            if (g(zznVar.f25423e)) {
                SparseArray<e> sparseArray = this.f52370i;
                int i10 = zznVar.f25423e;
                sparseArray.put(i10, new e(i10, new PointF(zznVar.f25421c, zznVar.f25422d)));
            }
        }
        for (zzd zzdVar : zzfVar.f25386o) {
            int i11 = zzdVar.f25372c;
            if (h(i11)) {
                SparseArray<b> sparseArray2 = this.f52371j;
                PointF[] pointFArr = zzdVar.f25371b;
                Objects.requireNonNull(pointFArr);
                long length = pointFArr.length + 5 + (r7 / 10);
                ArrayList arrayList = new ArrayList(length > ZipUtils.UPPER_UNIXTIME_BOUND ? Integer.MAX_VALUE : (int) length);
                Collections.addAll(arrayList, pointFArr);
                sparseArray2.put(i11, new b(i11, arrayList));
            }
        }
        this.f52367f = zzfVar.f25381j;
        this.f52368g = zzfVar.f25379h;
        this.f52369h = zzfVar.f25380i;
        this.f52366e = zzfVar.f25385n;
        this.f52365d = zzfVar.f25383l;
        this.f52364c = zzfVar.f25384m;
    }

    public static boolean g(int i10) {
        return i10 == 0 || i10 == 1 || i10 == 7 || i10 == 3 || i10 == 9 || i10 == 4 || i10 == 10 || i10 == 5 || i10 == 11 || i10 == 6;
    }

    public static boolean h(int i10) {
        return i10 <= 15 && i10 > 0;
    }

    @NonNull
    public Rect a() {
        return this.f52362a;
    }

    @RecentlyNullable
    public b b(int i10) {
        return this.f52371j.get(i10);
    }

    @RecentlyNullable
    public e c(int i10) {
        return this.f52370i.get(i10);
    }

    @RecentlyNonNull
    public final SparseArray<b> d() {
        return this.f52371j;
    }

    public final void e(@RecentlyNonNull SparseArray<b> sparseArray) {
        this.f52371j.clear();
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            this.f52371j.put(sparseArray.keyAt(i10), sparseArray.valueAt(i10));
        }
    }

    public final void f(int i10) {
        this.f52363b = -1;
    }

    @RecentlyNonNull
    public String toString() {
        u9 a10 = v9.a("Face");
        a10.a("boundingBox", this.f52362a);
        a10.d("trackingId", this.f52363b);
        a10.c("rightEyeOpenProbability", this.f52364c);
        a10.c("leftEyeOpenProbability", this.f52365d);
        a10.c("smileProbability", this.f52366e);
        a10.c("eulerX", this.f52367f);
        a10.c("eulerY", this.f52368g);
        a10.c("eulerZ", this.f52369h);
        u9 a11 = v9.a("Landmarks");
        for (int i10 = 0; i10 <= 11; i10++) {
            if (g(i10)) {
                StringBuilder sb2 = new StringBuilder(20);
                sb2.append("landmark_");
                sb2.append(i10);
                a11.a(sb2.toString(), c(i10));
            }
        }
        a10.a("landmarks", a11.toString());
        u9 a12 = v9.a("Contours");
        for (int i11 = 1; i11 <= 15; i11++) {
            StringBuilder sb3 = new StringBuilder(19);
            sb3.append("Contour_");
            sb3.append(i11);
            a12.a(sb3.toString(), b(i11));
        }
        a10.a("contours", a12.toString());
        return a10.toString();
    }

    public a(@NonNull zzlj zzljVar) {
        this.f52362a = zzljVar.f();
        this.f52363b = zzljVar.zza();
        for (zzlp zzlpVar : zzljVar.r()) {
            if (g(zzlpVar.zza())) {
                this.f52370i.put(zzlpVar.zza(), new e(zzlpVar.zza(), zzlpVar.f()));
            }
        }
        for (zzlf zzlfVar : zzljVar.u()) {
            int zza = zzlfVar.zza();
            if (h(zza)) {
                this.f52371j.put(zza, new b(zza, zzlfVar.f()));
            }
        }
        this.f52367f = zzljVar.j();
        this.f52368g = zzljVar.i();
        this.f52369h = -zzljVar.g();
        this.f52366e = zzljVar.m();
        this.f52365d = zzljVar.k();
        this.f52364c = zzljVar.l();
    }
}
