package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.a;
import com.google.android.exoplayer2.trackselection.b;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.p;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DefaultTrackSelector extends com.google.android.exoplayer2.trackselection.b {

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f22223f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public static final Ordering<Integer> f22224g = Ordering.from(new Comparator() { // from class: n6.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int z10;
            z10 = DefaultTrackSelector.z((Integer) obj, (Integer) obj2);
            return z10;
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public static final Ordering<Integer> f22225h = Ordering.from(new Comparator() { // from class: n6.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int A;
            A = DefaultTrackSelector.A((Integer) obj, (Integer) obj2);
            return A;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public final ExoTrackSelection.b f22226d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference<Parameters> f22227e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Parameters extends TrackSelectionParameters {
        public static final Parcelable.Creator<Parameters> CREATOR;
        public static final Parameters M;

        @Deprecated
        public static final Parameters N;
        public final boolean A;
        public final boolean B;
        public final boolean C;
        public final boolean D;
        public final boolean E;
        public final boolean F;
        public final boolean G;
        public final boolean H;
        public final boolean I;
        public final boolean J;
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> K;
        public final SparseBooleanArray L;

        /* renamed from: z, reason: collision with root package name */
        public final int f22228z;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public class a implements Parcelable.Creator<Parameters> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Parameters createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Parameters[] newArray(int i10) {
                return new Parameters[i10];
            }
        }

        static {
            Parameters w3 = new d().w();
            M = w3;
            N = w3;
            CREATOR = new a();
        }

        public static boolean c(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i10)) < 0) {
                    return false;
                }
            }
            return true;
        }

        public static boolean d(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i10));
                if (indexOfKey < 0 || !e(sparseArray.valueAt(i10), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean e(Map<TrackGroupArray, SelectionOverride> map, Map<TrackGroupArray, SelectionOverride> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry<TrackGroupArray, SelectionOverride> entry : map.entrySet()) {
                TrackGroupArray key = entry.getKey();
                if (!map2.containsKey(key) || !j0.c(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }

        public static Parameters g(Context context) {
            return new d(context).w();
        }

        public static SparseArray<Map<TrackGroupArray, SelectionOverride>> k(Parcel parcel) {
            int readInt = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i11 = 0; i11 < readInt3; i11++) {
                    hashMap.put((TrackGroupArray) com.google.android.exoplayer2.util.a.e((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader())), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        public static void l(Parcel parcel, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i10 = 0; i10 < size; i10++) {
                int keyAt = sparseArray.keyAt(i10);
                Map<TrackGroupArray, SelectionOverride> valueAt = sparseArray.valueAt(i10);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry<TrackGroupArray, SelectionOverride> entry : valueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return super.equals(parameters) && this.A == parameters.A && this.B == parameters.B && this.C == parameters.C && this.D == parameters.D && this.E == parameters.E && this.F == parameters.F && this.G == parameters.G && this.f22228z == parameters.f22228z && this.H == parameters.H && this.I == parameters.I && this.J == parameters.J && c(this.L, parameters.L) && d(this.K, parameters.K);
        }

        public d f() {
            return new d(this);
        }

        public final boolean h(int i10) {
            return this.L.get(i10);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public int hashCode() {
            return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.A ? 1 : 0)) * 31) + (this.B ? 1 : 0)) * 31) + (this.C ? 1 : 0)) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + (this.G ? 1 : 0)) * 31) + this.f22228z) * 31) + (this.H ? 1 : 0)) * 31) + (this.I ? 1 : 0)) * 31) + (this.J ? 1 : 0);
        }

        @Nullable
        public final SelectionOverride i(int i10, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.K.get(i10);
            if (map != null) {
                return map.get(trackGroupArray);
            }
            return null;
        }

        public final boolean j(int i10, TrackGroupArray trackGroupArray) {
            Map<TrackGroupArray, SelectionOverride> map = this.K.get(i10);
            return map != null && map.containsKey(trackGroupArray);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            j0.Y0(parcel, this.A);
            j0.Y0(parcel, this.B);
            j0.Y0(parcel, this.C);
            j0.Y0(parcel, this.D);
            j0.Y0(parcel, this.E);
            j0.Y0(parcel, this.F);
            j0.Y0(parcel, this.G);
            parcel.writeInt(this.f22228z);
            j0.Y0(parcel, this.H);
            j0.Y0(parcel, this.I);
            j0.Y0(parcel, this.J);
            l(parcel, this.K);
            parcel.writeSparseBooleanArray(this.L);
        }

        public Parameters(d dVar) {
            super(dVar);
            this.A = dVar.f22249w;
            this.B = dVar.f22250x;
            this.C = dVar.f22251y;
            this.D = dVar.f22252z;
            this.E = dVar.A;
            this.F = dVar.B;
            this.G = dVar.C;
            this.f22228z = dVar.D;
            this.H = dVar.E;
            this.I = dVar.F;
            this.J = dVar.G;
            this.K = dVar.H;
            this.L = dVar.I;
        }

        public Parameters(Parcel parcel) {
            super(parcel);
            this.A = j0.F0(parcel);
            this.B = j0.F0(parcel);
            this.C = j0.F0(parcel);
            this.D = j0.F0(parcel);
            this.E = j0.F0(parcel);
            this.F = j0.F0(parcel);
            this.G = j0.F0(parcel);
            this.f22228z = parcel.readInt();
            this.H = j0.F0(parcel);
            this.I = j0.F0(parcel);
            this.J = j0.F0(parcel);
            this.K = k(parcel);
            this.L = (SparseBooleanArray) j0.j(parcel.readSparseBooleanArray());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public final int f22229b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f22230c;

        /* renamed from: d, reason: collision with root package name */
        public final int f22231d;

        /* renamed from: e, reason: collision with root package name */
        public final int f22232e;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public class a implements Parcelable.Creator<SelectionOverride> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SelectionOverride[] newArray(int i10) {
                return new SelectionOverride[i10];
            }
        }

        public SelectionOverride(int i10, int... iArr) {
            this(i10, iArr, 0);
        }

        public boolean a(int i10) {
            for (int i11 : this.f22230c) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            return this.f22229b == selectionOverride.f22229b && Arrays.equals(this.f22230c, selectionOverride.f22230c) && this.f22232e == selectionOverride.f22232e;
        }

        public int hashCode() {
            return (((this.f22229b * 31) + Arrays.hashCode(this.f22230c)) * 31) + this.f22232e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f22229b);
            parcel.writeInt(this.f22230c.length);
            parcel.writeIntArray(this.f22230c);
            parcel.writeInt(this.f22232e);
        }

        public SelectionOverride(int i10, int[] iArr, int i11) {
            this.f22229b = i10;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f22230c = copyOf;
            this.f22231d = iArr.length;
            this.f22232e = i11;
            Arrays.sort(copyOf);
        }

        public SelectionOverride(Parcel parcel) {
            this.f22229b = parcel.readInt();
            int readByte = parcel.readByte();
            this.f22231d = readByte;
            int[] iArr = new int[readByte];
            this.f22230c = iArr;
            parcel.readIntArray(iArr);
            this.f22232e = parcel.readInt();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f22233b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f22234c;

        /* renamed from: d, reason: collision with root package name */
        public final Parameters f22235d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f22236e;

        /* renamed from: f, reason: collision with root package name */
        public final int f22237f;

        /* renamed from: g, reason: collision with root package name */
        public final int f22238g;

        /* renamed from: h, reason: collision with root package name */
        public final int f22239h;

        /* renamed from: i, reason: collision with root package name */
        public final int f22240i;

        /* renamed from: j, reason: collision with root package name */
        public final int f22241j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f22242k;

        /* renamed from: l, reason: collision with root package name */
        public final int f22243l;

        /* renamed from: m, reason: collision with root package name */
        public final int f22244m;

        /* renamed from: n, reason: collision with root package name */
        public final int f22245n;

        /* renamed from: o, reason: collision with root package name */
        public final int f22246o;

        public b(Format format, Parameters parameters, int i10) {
            int i11;
            int i12;
            int i13;
            this.f22235d = parameters;
            this.f22234c = DefaultTrackSelector.C(format.f19535d);
            int i14 = 0;
            this.f22236e = DefaultTrackSelector.w(i10, false);
            int i15 = 0;
            while (true) {
                i11 = Integer.MAX_VALUE;
                if (i15 >= parameters.f22286n.size()) {
                    i15 = Integer.MAX_VALUE;
                    i12 = 0;
                    break;
                } else {
                    i12 = DefaultTrackSelector.s(format, parameters.f22286n.get(i15), false);
                    if (i12 > 0) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
            this.f22238g = i15;
            this.f22237f = i12;
            this.f22239h = Integer.bitCount(format.f19537f & parameters.f22287o);
            boolean z10 = true;
            this.f22242k = (format.f19536e & 1) != 0;
            int i16 = format.f19557z;
            this.f22243l = i16;
            this.f22244m = format.A;
            int i17 = format.f19540i;
            this.f22245n = i17;
            if ((i17 != -1 && i17 > parameters.f22289q) || (i16 != -1 && i16 > parameters.f22288p)) {
                z10 = false;
            }
            this.f22233b = z10;
            String[] e02 = j0.e0();
            int i18 = 0;
            while (true) {
                if (i18 >= e02.length) {
                    i18 = Integer.MAX_VALUE;
                    i13 = 0;
                    break;
                } else {
                    i13 = DefaultTrackSelector.s(format, e02[i18], false);
                    if (i13 > 0) {
                        break;
                    } else {
                        i18++;
                    }
                }
            }
            this.f22240i = i18;
            this.f22241j = i13;
            while (true) {
                if (i14 < parameters.f22290r.size()) {
                    String str = format.f19544m;
                    if (str != null && str.equals(parameters.f22290r.get(i14))) {
                        i11 = i14;
                        break;
                    }
                    i14++;
                } else {
                    break;
                }
            }
            this.f22246o = i11;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            Ordering reverse;
            if (this.f22233b && this.f22236e) {
                reverse = DefaultTrackSelector.f22224g;
            } else {
                reverse = DefaultTrackSelector.f22224g.reverse();
            }
            p g3 = p.k().h(this.f22236e, bVar.f22236e).g(Integer.valueOf(this.f22238g), Integer.valueOf(bVar.f22238g), Ordering.natural().reverse()).d(this.f22237f, bVar.f22237f).d(this.f22239h, bVar.f22239h).h(this.f22233b, bVar.f22233b).g(Integer.valueOf(this.f22246o), Integer.valueOf(bVar.f22246o), Ordering.natural().reverse()).g(Integer.valueOf(this.f22245n), Integer.valueOf(bVar.f22245n), this.f22235d.f22294v ? DefaultTrackSelector.f22224g.reverse() : DefaultTrackSelector.f22225h).h(this.f22242k, bVar.f22242k).g(Integer.valueOf(this.f22240i), Integer.valueOf(bVar.f22240i), Ordering.natural().reverse()).d(this.f22241j, bVar.f22241j).g(Integer.valueOf(this.f22243l), Integer.valueOf(bVar.f22243l), reverse).g(Integer.valueOf(this.f22244m), Integer.valueOf(bVar.f22244m), reverse);
            Integer valueOf = Integer.valueOf(this.f22245n);
            Integer valueOf2 = Integer.valueOf(bVar.f22245n);
            if (!j0.c(this.f22234c, bVar.f22234c)) {
                reverse = DefaultTrackSelector.f22225h;
            }
            return g3.g(valueOf, valueOf2, reverse).j();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements Comparable<c> {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f22247b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f22248c;

        public c(Format format, int i10) {
            this.f22247b = (format.f19536e & 1) != 0;
            this.f22248c = DefaultTrackSelector.w(i10, false);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return p.k().h(this.f22248c, cVar.f22248c).h(this.f22247b, cVar.f22247b).j();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d extends TrackSelectionParameters.b {
        public boolean A;
        public boolean B;
        public boolean C;
        public int D;
        public boolean E;
        public boolean F;
        public boolean G;
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> H;
        public final SparseBooleanArray I;

        /* renamed from: w, reason: collision with root package name */
        public boolean f22249w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f22250x;

        /* renamed from: y, reason: collision with root package name */
        public boolean f22251y;

        /* renamed from: z, reason: collision with root package name */
        public boolean f22252z;

        public static SparseArray<Map<TrackGroupArray, SelectionOverride>> Q(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                sparseArray2.put(sparseArray.keyAt(i10), new HashMap(sparseArray.valueAt(i10)));
            }
            return sparseArray2;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public Parameters w() {
            return new Parameters(this);
        }

        public final d P(int i10) {
            Map<TrackGroupArray, SelectionOverride> map = this.H.get(i10);
            if (map != null && !map.isEmpty()) {
                this.H.remove(i10);
            }
            return this;
        }

        public final void R() {
            this.f22249w = true;
            this.f22250x = false;
            this.f22251y = true;
            this.f22252z = true;
            this.A = false;
            this.B = false;
            this.C = false;
            this.D = 0;
            this.E = true;
            this.F = false;
            this.G = true;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* renamed from: S, reason: merged with bridge method [inline-methods] */
        public d x(Context context) {
            super.x(context);
            return this;
        }

        public final d T(int i10, boolean z10) {
            if (this.I.get(i10) == z10) {
                return this;
            }
            if (z10) {
                this.I.put(i10, true);
            } else {
                this.I.delete(i10);
            }
            return this;
        }

        public final d U(int i10, TrackGroupArray trackGroupArray, @Nullable SelectionOverride selectionOverride) {
            Map<TrackGroupArray, SelectionOverride> map = this.H.get(i10);
            if (map == null) {
                map = new HashMap<>();
                this.H.put(i10, map);
            }
            if (map.containsKey(trackGroupArray) && j0.c(map.get(trackGroupArray), selectionOverride)) {
                return this;
            }
            map.put(trackGroupArray, selectionOverride);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* renamed from: V, reason: merged with bridge method [inline-methods] */
        public d z(int i10, int i11, boolean z10) {
            super.z(i10, i11, z10);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.b
        /* renamed from: W, reason: merged with bridge method [inline-methods] */
        public d A(Context context, boolean z10) {
            super.A(context, z10);
            return this;
        }

        @Deprecated
        public d() {
            this.H = new SparseArray<>();
            this.I = new SparseBooleanArray();
            R();
        }

        public d(Context context) {
            super(context);
            this.H = new SparseArray<>();
            this.I = new SparseBooleanArray();
            R();
        }

        public d(Parameters parameters) {
            super(parameters);
            this.D = parameters.f22228z;
            this.f22249w = parameters.A;
            this.f22250x = parameters.B;
            this.f22251y = parameters.C;
            this.f22252z = parameters.D;
            this.A = parameters.E;
            this.B = parameters.F;
            this.C = parameters.G;
            this.E = parameters.H;
            this.F = parameters.I;
            this.G = parameters.J;
            this.H = Q(parameters.K);
            this.I = parameters.L.clone();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e implements Comparable<e> {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f22253b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f22254c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f22255d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f22256e;

        /* renamed from: f, reason: collision with root package name */
        public final int f22257f;

        /* renamed from: g, reason: collision with root package name */
        public final int f22258g;

        /* renamed from: h, reason: collision with root package name */
        public final int f22259h;

        /* renamed from: i, reason: collision with root package name */
        public final int f22260i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f22261j;

        public e(Format format, Parameters parameters, int i10, @Nullable String str) {
            ImmutableList<String> immutableList;
            int i11;
            boolean z10 = false;
            this.f22254c = DefaultTrackSelector.w(i10, false);
            int i12 = format.f19536e & (~parameters.f22228z);
            this.f22255d = (i12 & 1) != 0;
            this.f22256e = (i12 & 2) != 0;
            int i13 = Integer.MAX_VALUE;
            if (parameters.f22291s.isEmpty()) {
                immutableList = ImmutableList.of("");
            } else {
                immutableList = parameters.f22291s;
            }
            int i14 = 0;
            while (true) {
                if (i14 >= immutableList.size()) {
                    i11 = 0;
                    break;
                }
                i11 = DefaultTrackSelector.s(format, immutableList.get(i14), parameters.f22293u);
                if (i11 > 0) {
                    i13 = i14;
                    break;
                }
                i14++;
            }
            this.f22257f = i13;
            this.f22258g = i11;
            int bitCount = Integer.bitCount(format.f19537f & parameters.f22292t);
            this.f22259h = bitCount;
            this.f22261j = (format.f19537f & MetricsProto.MetricsEvent.DATA_PLAN_USAGE_SUMMARY) != 0;
            int s2 = DefaultTrackSelector.s(format, str, DefaultTrackSelector.C(str) == null);
            this.f22260i = s2;
            if (i11 > 0 || ((parameters.f22291s.isEmpty() && bitCount > 0) || this.f22255d || (this.f22256e && s2 > 0))) {
                z10 = true;
            }
            this.f22253b = z10;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            p d10 = p.k().h(this.f22254c, eVar.f22254c).g(Integer.valueOf(this.f22257f), Integer.valueOf(eVar.f22257f), Ordering.natural().reverse()).d(this.f22258g, eVar.f22258g).d(this.f22259h, eVar.f22259h).h(this.f22255d, eVar.f22255d).g(Boolean.valueOf(this.f22256e), Boolean.valueOf(eVar.f22256e), this.f22258g == 0 ? Ordering.natural() : Ordering.natural().reverse()).d(this.f22260i, eVar.f22260i);
            if (this.f22259h == 0) {
                d10 = d10.i(this.f22261j, eVar.f22261j);
            }
            return d10.j();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f implements Comparable<f> {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f22262b;

        /* renamed from: c, reason: collision with root package name */
        public final Parameters f22263c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f22264d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f22265e;

        /* renamed from: f, reason: collision with root package name */
        public final int f22266f;

        /* renamed from: g, reason: collision with root package name */
        public final int f22267g;

        /* renamed from: h, reason: collision with root package name */
        public final int f22268h;

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
        
            if (r10 < r8.f22280h) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x005b, code lost:
        
            if (r10 < r8.f22281i) goto L41;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0091 A[EDGE_INSN: B:53:0x0091->B:47:0x0091 BREAK  A[LOOP:0: B:39:0x0074->B:51:0x008e], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public f(com.google.android.exoplayer2.Format r7, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r8, int r9, boolean r10) {
            /*
                r6 = this;
                r6.<init>()
                r6.f22263c = r8
                r0 = -1082130432(0xffffffffbf800000, float:-1.0)
                r1 = 1
                r2 = 0
                r3 = -1
                if (r10 == 0) goto L33
                int r4 = r7.f19549r
                if (r4 == r3) goto L14
                int r5 = r8.f22274b
                if (r4 > r5) goto L33
            L14:
                int r4 = r7.f19550s
                if (r4 == r3) goto L1c
                int r5 = r8.f22275c
                if (r4 > r5) goto L33
            L1c:
                float r4 = r7.f19551t
                int r5 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r5 == 0) goto L29
                int r5 = r8.f22276d
                float r5 = (float) r5
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 > 0) goto L33
            L29:
                int r4 = r7.f19540i
                if (r4 == r3) goto L31
                int r5 = r8.f22277e
                if (r4 > r5) goto L33
            L31:
                r4 = 1
                goto L34
            L33:
                r4 = 0
            L34:
                r6.f22262b = r4
                if (r10 == 0) goto L5e
                int r10 = r7.f19549r
                if (r10 == r3) goto L40
                int r4 = r8.f22278f
                if (r10 < r4) goto L5e
            L40:
                int r10 = r7.f19550s
                if (r10 == r3) goto L48
                int r4 = r8.f22279g
                if (r10 < r4) goto L5e
            L48:
                float r10 = r7.f19551t
                int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r0 == 0) goto L55
                int r0 = r8.f22280h
                float r0 = (float) r0
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 < 0) goto L5e
            L55:
                int r10 = r7.f19540i
                if (r10 == r3) goto L5f
                int r0 = r8.f22281i
                if (r10 < r0) goto L5e
                goto L5f
            L5e:
                r1 = 0
            L5f:
                r6.f22264d = r1
                boolean r9 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.w(r9, r2)
                r6.f22265e = r9
                int r9 = r7.f19540i
                r6.f22266f = r9
                int r9 = r7.c()
                r6.f22267g = r9
                r9 = 2147483647(0x7fffffff, float:NaN)
            L74:
                com.google.common.collect.ImmutableList<java.lang.String> r10 = r8.f22285m
                int r10 = r10.size()
                if (r2 >= r10) goto L91
                java.lang.String r10 = r7.f19544m
                if (r10 == 0) goto L8e
                com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.f22285m
                java.lang.Object r0 = r0.get(r2)
                boolean r10 = r10.equals(r0)
                if (r10 == 0) goto L8e
                r9 = r2
                goto L91
            L8e:
                int r2 = r2 + 1
                goto L74
            L91:
                r6.f22268h = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.f.<init>(com.google.android.exoplayer2.Format, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters, int, boolean):void");
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(f fVar) {
            Ordering reverse;
            if (this.f22262b && this.f22265e) {
                reverse = DefaultTrackSelector.f22224g;
            } else {
                reverse = DefaultTrackSelector.f22224g.reverse();
            }
            return p.k().h(this.f22265e, fVar.f22265e).h(this.f22262b, fVar.f22262b).h(this.f22264d, fVar.f22264d).g(Integer.valueOf(this.f22268h), Integer.valueOf(fVar.f22268h), Ordering.natural().reverse()).g(Integer.valueOf(this.f22266f), Integer.valueOf(fVar.f22266f), this.f22263c.f22294v ? DefaultTrackSelector.f22224g.reverse() : DefaultTrackSelector.f22225h).g(Integer.valueOf(this.f22267g), Integer.valueOf(fVar.f22267g), reverse).g(Integer.valueOf(this.f22266f), Integer.valueOf(fVar.f22266f), reverse).j();
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this(Parameters.M, new a.b());
    }

    public static /* synthetic */ int A(Integer num, Integer num2) {
        return 0;
    }

    public static void B(b.a aVar, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        boolean z10;
        boolean z11 = false;
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < aVar.c(); i12++) {
            int d10 = aVar.d(i12);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i12];
            if ((d10 == 1 || d10 == 2) && exoTrackSelection != null && D(iArr[i12], aVar.e(i12), exoTrackSelection)) {
                if (d10 == 1) {
                    if (i11 != -1) {
                        z10 = false;
                        break;
                    }
                    i11 = i12;
                } else {
                    if (i10 != -1) {
                        z10 = false;
                        break;
                    }
                    i10 = i12;
                }
            }
        }
        z10 = true;
        if (i11 != -1 && i10 != -1) {
            z11 = true;
        }
        if (z10 && z11) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(true);
            rendererConfigurationArr[i11] = rendererConfiguration;
            rendererConfigurationArr[i10] = rendererConfiguration;
        }
    }

    @Nullable
    public static String C(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, LanguageTag.UNDETERMINED)) {
            return null;
        }
        return str;
    }

    public static boolean D(int[][] iArr, TrackGroupArray trackGroupArray, ExoTrackSelection exoTrackSelection) {
        if (exoTrackSelection == null) {
            return false;
        }
        int b4 = trackGroupArray.b(exoTrackSelection.g());
        for (int i10 = 0; i10 < exoTrackSelection.length(); i10++) {
            if (m1.e(iArr[b4][exoTrackSelection.c(i10)]) != 32) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static ExoTrackSelection.a E(TrackGroupArray trackGroupArray, int[][] iArr, int i10, Parameters parameters) {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i11 = parameters2.C ? 24 : 16;
        boolean z10 = parameters2.B && (i10 & i11) != 0;
        int i12 = 0;
        while (i12 < trackGroupArray2.f21172b) {
            TrackGroup a10 = trackGroupArray2.a(i12);
            int i13 = i12;
            int[] r10 = r(a10, iArr[i12], z10, i11, parameters2.f22274b, parameters2.f22275c, parameters2.f22276d, parameters2.f22277e, parameters2.f22278f, parameters2.f22279g, parameters2.f22280h, parameters2.f22281i, parameters2.f22282j, parameters2.f22283k, parameters2.f22284l);
            if (r10.length > 0) {
                return new ExoTrackSelection.a(a10, r10);
            }
            i12 = i13 + 1;
            trackGroupArray2 = trackGroupArray;
            parameters2 = parameters;
        }
        return null;
    }

    @Nullable
    public static ExoTrackSelection.a H(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        int i10 = -1;
        TrackGroup trackGroup = null;
        f fVar = null;
        for (int i11 = 0; i11 < trackGroupArray.f21172b; i11++) {
            TrackGroup a10 = trackGroupArray.a(i11);
            List<Integer> v2 = v(a10, parameters.f22282j, parameters.f22283k, parameters.f22284l);
            int[] iArr2 = iArr[i11];
            for (int i12 = 0; i12 < a10.f21168b; i12++) {
                Format a11 = a10.a(i12);
                if ((a11.f19537f & 16384) == 0 && w(iArr2[i12], parameters.H)) {
                    f fVar2 = new f(a11, parameters, iArr2[i12], v2.contains(Integer.valueOf(i12)));
                    if ((fVar2.f22262b || parameters.A) && (fVar == null || fVar2.compareTo(fVar) > 0)) {
                        trackGroup = a10;
                        i10 = i12;
                        fVar = fVar2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.a(trackGroup, i10);
    }

    public static void o(TrackGroup trackGroup, int[] iArr, int i10, @Nullable String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!y(trackGroup.a(intValue), str, iArr[intValue], i10, i11, i12, i13, i14, i15, i16, i17, i18)) {
                list.remove(size);
            }
        }
    }

    public static int[] p(TrackGroup trackGroup, int[] iArr, int i10, int i11, boolean z10, boolean z11, boolean z12) {
        Format a10 = trackGroup.a(i10);
        int[] iArr2 = new int[trackGroup.f21168b];
        int i12 = 0;
        for (int i13 = 0; i13 < trackGroup.f21168b; i13++) {
            if (i13 == i10 || x(trackGroup.a(i13), iArr[i13], a10, i11, z10, z11, z12)) {
                iArr2[i12] = i13;
                i12++;
            }
        }
        return Arrays.copyOf(iArr2, i12);
    }

    public static int q(TrackGroup trackGroup, int[] iArr, int i10, @Nullable String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, List<Integer> list) {
        int i19 = 0;
        for (int i20 = 0; i20 < list.size(); i20++) {
            int intValue = list.get(i20).intValue();
            if (y(trackGroup.a(intValue), str, iArr[intValue], i10, i11, i12, i13, i14, i15, i16, i17, i18)) {
                i19++;
            }
        }
        return i19;
    }

    public static int[] r(TrackGroup trackGroup, int[] iArr, boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, boolean z11) {
        String str;
        int i21;
        int i22;
        HashSet hashSet;
        if (trackGroup.f21168b < 2) {
            return f22223f;
        }
        List<Integer> v2 = v(trackGroup, i19, i20, z11);
        if (v2.size() < 2) {
            return f22223f;
        }
        if (z10) {
            str = null;
        } else {
            HashSet hashSet2 = new HashSet();
            String str2 = null;
            int i23 = 0;
            int i24 = 0;
            while (i24 < v2.size()) {
                String str3 = trackGroup.a(v2.get(i24).intValue()).f19544m;
                if (hashSet2.add(str3)) {
                    i21 = i23;
                    i22 = i24;
                    hashSet = hashSet2;
                    int q10 = q(trackGroup, iArr, i10, str3, i11, i12, i13, i14, i15, i16, i17, i18, v2);
                    if (q10 > i21) {
                        i23 = q10;
                        str2 = str3;
                        i24 = i22 + 1;
                        hashSet2 = hashSet;
                    }
                } else {
                    i21 = i23;
                    i22 = i24;
                    hashSet = hashSet2;
                }
                i23 = i21;
                i24 = i22 + 1;
                hashSet2 = hashSet;
            }
            str = str2;
        }
        o(trackGroup, iArr, i10, str, i11, i12, i13, i14, i15, i16, i17, i18, v2);
        return v2.size() < 2 ? f22223f : Ints.m(v2);
    }

    public static int s(Format format, @Nullable String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && str.equals(format.f19535d)) {
            return 4;
        }
        String C = C(str);
        String C2 = C(format.f19535d);
        if (C2 == null || C == null) {
            return (z10 && C2 == null) ? 1 : 0;
        }
        if (C2.startsWith(C) || C.startsWith(C2)) {
            return 3;
        }
        return j0.N0(C2, "-")[0].equals(j0.N0(C, "-")[0]) ? 2 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if ((r6 > r7) != (r4 > r5)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Point t(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L10
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L8
            r1 = 1
            goto L9
        L8:
            r1 = 0
        L9:
            if (r4 <= r5) goto Lc
            goto Ld
        Lc:
            r3 = 0
        Ld:
            if (r1 == r3) goto L10
            goto L13
        L10:
            r2 = r5
            r5 = r4
            r4 = r2
        L13:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L23
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.util.j0.l(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L23:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.j0.l(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.t(boolean, int, int, int, int):android.graphics.Point");
    }

    public static List<Integer> v(TrackGroup trackGroup, int i10, int i11, boolean z10) {
        int i12;
        ArrayList arrayList = new ArrayList(trackGroup.f21168b);
        for (int i13 = 0; i13 < trackGroup.f21168b; i13++) {
            arrayList.add(Integer.valueOf(i13));
        }
        if (i10 != Integer.MAX_VALUE && i11 != Integer.MAX_VALUE) {
            int i14 = Integer.MAX_VALUE;
            for (int i15 = 0; i15 < trackGroup.f21168b; i15++) {
                Format a10 = trackGroup.a(i15);
                int i16 = a10.f19549r;
                if (i16 > 0 && (i12 = a10.f19550s) > 0) {
                    Point t2 = t(z10, i10, i11, i16, i12);
                    int i17 = a10.f19549r;
                    int i18 = a10.f19550s;
                    int i19 = i17 * i18;
                    if (i17 >= ((int) (t2.x * 0.98f)) && i18 >= ((int) (t2.y * 0.98f)) && i19 < i14) {
                        i14 = i19;
                    }
                }
            }
            if (i14 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int c4 = trackGroup.a(((Integer) arrayList.get(size)).intValue()).c();
                    if (c4 == -1 || c4 > i14) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean w(int i10, boolean z10) {
        int d10 = m1.d(i10);
        return d10 == 4 || (z10 && d10 == 3);
    }

    public static boolean x(Format format, int i10, Format format2, int i11, boolean z10, boolean z11, boolean z12) {
        int i12;
        int i13;
        String str;
        int i14;
        if (!w(i10, false) || (i12 = format.f19540i) == -1 || i12 > i11) {
            return false;
        }
        if (!z12 && ((i14 = format.f19557z) == -1 || i14 != format2.f19557z)) {
            return false;
        }
        if (z10 || ((str = format.f19544m) != null && TextUtils.equals(str, format2.f19544m))) {
            return z11 || ((i13 = format.A) != -1 && i13 == format2.A);
        }
        return false;
    }

    public static boolean y(Format format, @Nullable String str, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        int i20;
        if ((format.f19537f & 16384) != 0 || !w(i10, false) || (i10 & i11) == 0) {
            return false;
        }
        if (str != null && !j0.c(format.f19544m, str)) {
            return false;
        }
        int i21 = format.f19549r;
        if (i21 != -1 && (i16 > i21 || i21 > i12)) {
            return false;
        }
        int i22 = format.f19550s;
        if (i22 != -1 && (i17 > i22 || i22 > i13)) {
            return false;
        }
        float f10 = format.f19551t;
        return (f10 == -1.0f || (((float) i18) <= f10 && f10 <= ((float) i14))) && (i20 = format.f19540i) != -1 && i19 <= i20 && i20 <= i15;
    }

    public static /* synthetic */ int z(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    public ExoTrackSelection.a[] F(b.a aVar, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        int i10;
        String str;
        int i11;
        b bVar;
        String str2;
        int i12;
        int c4 = aVar.c();
        ExoTrackSelection.a[] aVarArr = new ExoTrackSelection.a[c4];
        int i13 = 0;
        boolean z10 = false;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i14 >= c4) {
                break;
            }
            if (2 == aVar.d(i14)) {
                if (!z10) {
                    aVarArr[i14] = K(aVar.e(i14), iArr[i14], iArr2[i14], parameters, true);
                    z10 = aVarArr[i14] != null;
                }
                i15 |= aVar.e(i14).f21172b <= 0 ? 0 : 1;
            }
            i14++;
        }
        b bVar2 = null;
        String str3 = null;
        int i16 = -1;
        int i17 = 0;
        while (i17 < c4) {
            if (i10 == aVar.d(i17)) {
                i11 = i16;
                bVar = bVar2;
                str2 = str3;
                i12 = i17;
                Pair<ExoTrackSelection.a, b> G = G(aVar.e(i17), iArr[i17], iArr2[i17], parameters, parameters.J || i15 == 0);
                if (G != null && (bVar == null || ((b) G.second).compareTo(bVar) > 0)) {
                    if (i11 != -1) {
                        aVarArr[i11] = null;
                    }
                    ExoTrackSelection.a aVar2 = (ExoTrackSelection.a) G.first;
                    aVarArr[i12] = aVar2;
                    str3 = aVar2.f22269a.a(aVar2.f22270b[0]).f19535d;
                    bVar2 = (b) G.second;
                    i16 = i12;
                    i17 = i12 + 1;
                    i10 = 1;
                }
            } else {
                i11 = i16;
                bVar = bVar2;
                str2 = str3;
                i12 = i17;
            }
            i16 = i11;
            bVar2 = bVar;
            str3 = str2;
            i17 = i12 + 1;
            i10 = 1;
        }
        String str4 = str3;
        e eVar = null;
        int i18 = -1;
        while (i13 < c4) {
            int d10 = aVar.d(i13);
            if (d10 != 1) {
                if (d10 != 2) {
                    if (d10 != 3) {
                        aVarArr[i13] = I(d10, aVar.e(i13), iArr[i13], parameters);
                    } else {
                        str = str4;
                        Pair<ExoTrackSelection.a, e> J = J(aVar.e(i13), iArr[i13], parameters, str);
                        if (J != null && (eVar == null || ((e) J.second).compareTo(eVar) > 0)) {
                            if (i18 != -1) {
                                aVarArr[i18] = null;
                            }
                            aVarArr[i13] = (ExoTrackSelection.a) J.first;
                            eVar = (e) J.second;
                            i18 = i13;
                        }
                    }
                }
                str = str4;
            } else {
                str = str4;
            }
            i13++;
            str4 = str;
        }
        return aVarArr;
    }

    @Nullable
    public Pair<ExoTrackSelection.a, b> G(TrackGroupArray trackGroupArray, int[][] iArr, int i10, Parameters parameters, boolean z10) throws ExoPlaybackException {
        ExoTrackSelection.a aVar = null;
        b bVar = null;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < trackGroupArray.f21172b; i13++) {
            TrackGroup a10 = trackGroupArray.a(i13);
            int[] iArr2 = iArr[i13];
            for (int i14 = 0; i14 < a10.f21168b; i14++) {
                if (w(iArr2[i14], parameters.H)) {
                    b bVar2 = new b(a10.a(i14), parameters, iArr2[i14]);
                    if ((bVar2.f22233b || parameters.D) && (bVar == null || bVar2.compareTo(bVar) > 0)) {
                        i11 = i13;
                        i12 = i14;
                        bVar = bVar2;
                    }
                }
            }
        }
        if (i11 == -1) {
            return null;
        }
        TrackGroup a11 = trackGroupArray.a(i11);
        if (!parameters.f22295w && !parameters.f22294v && z10) {
            int[] p10 = p(a11, iArr[i11], i12, parameters.f22289q, parameters.E, parameters.F, parameters.G);
            if (p10.length > 1) {
                aVar = new ExoTrackSelection.a(a11, p10);
            }
        }
        if (aVar == null) {
            aVar = new ExoTrackSelection.a(a11, i12);
        }
        return Pair.create(aVar, (b) com.google.android.exoplayer2.util.a.e(bVar));
    }

    @Nullable
    public ExoTrackSelection.a I(int i10, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        c cVar = null;
        int i11 = 0;
        for (int i12 = 0; i12 < trackGroupArray.f21172b; i12++) {
            TrackGroup a10 = trackGroupArray.a(i12);
            int[] iArr2 = iArr[i12];
            for (int i13 = 0; i13 < a10.f21168b; i13++) {
                if (w(iArr2[i13], parameters.H)) {
                    c cVar2 = new c(a10.a(i13), iArr2[i13]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        trackGroup = a10;
                        i11 = i13;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.a(trackGroup, i11);
    }

    @Nullable
    public Pair<ExoTrackSelection.a, e> J(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, @Nullable String str) throws ExoPlaybackException {
        int i10 = -1;
        TrackGroup trackGroup = null;
        e eVar = null;
        for (int i11 = 0; i11 < trackGroupArray.f21172b; i11++) {
            TrackGroup a10 = trackGroupArray.a(i11);
            int[] iArr2 = iArr[i11];
            for (int i12 = 0; i12 < a10.f21168b; i12++) {
                if (w(iArr2[i12], parameters.H)) {
                    e eVar2 = new e(a10.a(i12), parameters, iArr2[i12], str);
                    if (eVar2.f22253b && (eVar == null || eVar2.compareTo(eVar) > 0)) {
                        trackGroup = a10;
                        i10 = i12;
                        eVar = eVar2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return Pair.create(new ExoTrackSelection.a(trackGroup, i10), (e) com.google.android.exoplayer2.util.a.e(eVar));
    }

    @Nullable
    public ExoTrackSelection.a K(TrackGroupArray trackGroupArray, int[][] iArr, int i10, Parameters parameters, boolean z10) throws ExoPlaybackException {
        ExoTrackSelection.a E = (parameters.f22295w || parameters.f22294v || !z10) ? null : E(trackGroupArray, iArr, i10, parameters);
        return E == null ? H(trackGroupArray, iArr, parameters) : E;
    }

    public void L(Parameters parameters) {
        com.google.android.exoplayer2.util.a.e(parameters);
        if (this.f22227e.getAndSet(parameters).equals(parameters)) {
            return;
        }
        c();
    }

    public void M(d dVar) {
        L(dVar.w());
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public final Pair<RendererConfiguration[], ExoTrackSelection[]> j(b.a aVar, int[][][] iArr, int[] iArr2, s.a aVar2, Timeline timeline) throws ExoPlaybackException {
        Parameters parameters = this.f22227e.get();
        int c4 = aVar.c();
        ExoTrackSelection.a[] F = F(aVar, iArr, iArr2, parameters);
        int i10 = 0;
        while (true) {
            if (i10 >= c4) {
                break;
            }
            if (parameters.h(i10)) {
                F[i10] = null;
            } else {
                TrackGroupArray e2 = aVar.e(i10);
                if (parameters.j(i10, e2)) {
                    SelectionOverride i11 = parameters.i(i10, e2);
                    F[i10] = i11 != null ? new ExoTrackSelection.a(e2.a(i11.f22229b), i11.f22230c, i11.f22232e) : null;
                }
            }
            i10++;
        }
        ExoTrackSelection[] a10 = this.f22226d.a(F, a(), aVar2, timeline);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[c4];
        for (int i12 = 0; i12 < c4; i12++) {
            rendererConfigurationArr[i12] = !parameters.h(i12) && (aVar.d(i12) == 7 || a10[i12] != null) ? RendererConfiguration.f19651b : null;
        }
        if (parameters.I) {
            B(aVar, iArr, rendererConfigurationArr, a10);
        }
        return Pair.create(rendererConfigurationArr, a10);
    }

    public Parameters u() {
        return this.f22227e.get();
    }

    public DefaultTrackSelector(Context context) {
        this(context, new a.b());
    }

    public DefaultTrackSelector(Context context, ExoTrackSelection.b bVar) {
        this(Parameters.g(context), bVar);
    }

    public DefaultTrackSelector(Parameters parameters, ExoTrackSelection.b bVar) {
        this.f22226d = bVar;
        this.f22227e = new AtomicReference<>(parameters);
    }
}
