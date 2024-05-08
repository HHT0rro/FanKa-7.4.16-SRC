package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR;

    /* renamed from: x, reason: collision with root package name */
    public static final TrackSelectionParameters f22272x;

    /* renamed from: y, reason: collision with root package name */
    @Deprecated
    public static final TrackSelectionParameters f22273y;

    /* renamed from: b, reason: collision with root package name */
    public final int f22274b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22275c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22276d;

    /* renamed from: e, reason: collision with root package name */
    public final int f22277e;

    /* renamed from: f, reason: collision with root package name */
    public final int f22278f;

    /* renamed from: g, reason: collision with root package name */
    public final int f22279g;

    /* renamed from: h, reason: collision with root package name */
    public final int f22280h;

    /* renamed from: i, reason: collision with root package name */
    public final int f22281i;

    /* renamed from: j, reason: collision with root package name */
    public final int f22282j;

    /* renamed from: k, reason: collision with root package name */
    public final int f22283k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f22284l;

    /* renamed from: m, reason: collision with root package name */
    public final ImmutableList<String> f22285m;

    /* renamed from: n, reason: collision with root package name */
    public final ImmutableList<String> f22286n;

    /* renamed from: o, reason: collision with root package name */
    public final int f22287o;

    /* renamed from: p, reason: collision with root package name */
    public final int f22288p;

    /* renamed from: q, reason: collision with root package name */
    public final int f22289q;

    /* renamed from: r, reason: collision with root package name */
    public final ImmutableList<String> f22290r;

    /* renamed from: s, reason: collision with root package name */
    public final ImmutableList<String> f22291s;

    /* renamed from: t, reason: collision with root package name */
    public final int f22292t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f22293u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f22294v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f22295w;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Parcelable.Creator<TrackSelectionParameters> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackSelectionParameters createFromParcel(Parcel parcel) {
            return new TrackSelectionParameters(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TrackSelectionParameters[] newArray(int i10) {
            return new TrackSelectionParameters[i10];
        }
    }

    static {
        TrackSelectionParameters w3 = new b().w();
        f22272x = w3;
        f22273y = w3;
        CREATOR = new a();
    }

    public TrackSelectionParameters(b bVar) {
        this.f22274b = bVar.f22296a;
        this.f22275c = bVar.f22297b;
        this.f22276d = bVar.f22298c;
        this.f22277e = bVar.f22299d;
        this.f22278f = bVar.f22300e;
        this.f22279g = bVar.f22301f;
        this.f22280h = bVar.f22302g;
        this.f22281i = bVar.f22303h;
        this.f22282j = bVar.f22304i;
        this.f22283k = bVar.f22305j;
        this.f22284l = bVar.f22306k;
        this.f22285m = bVar.f22307l;
        this.f22286n = bVar.f22308m;
        this.f22287o = bVar.f22309n;
        this.f22288p = bVar.f22310o;
        this.f22289q = bVar.f22311p;
        this.f22290r = bVar.f22312q;
        this.f22291s = bVar.f22313r;
        this.f22292t = bVar.f22314s;
        this.f22293u = bVar.f22315t;
        this.f22294v = bVar.f22316u;
        this.f22295w = bVar.f22317v;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return this.f22274b == trackSelectionParameters.f22274b && this.f22275c == trackSelectionParameters.f22275c && this.f22276d == trackSelectionParameters.f22276d && this.f22277e == trackSelectionParameters.f22277e && this.f22278f == trackSelectionParameters.f22278f && this.f22279g == trackSelectionParameters.f22279g && this.f22280h == trackSelectionParameters.f22280h && this.f22281i == trackSelectionParameters.f22281i && this.f22284l == trackSelectionParameters.f22284l && this.f22282j == trackSelectionParameters.f22282j && this.f22283k == trackSelectionParameters.f22283k && this.f22285m.equals(trackSelectionParameters.f22285m) && this.f22286n.equals(trackSelectionParameters.f22286n) && this.f22287o == trackSelectionParameters.f22287o && this.f22288p == trackSelectionParameters.f22288p && this.f22289q == trackSelectionParameters.f22289q && this.f22290r.equals(trackSelectionParameters.f22290r) && this.f22291s.equals(trackSelectionParameters.f22291s) && this.f22292t == trackSelectionParameters.f22292t && this.f22293u == trackSelectionParameters.f22293u && this.f22294v == trackSelectionParameters.f22294v && this.f22295w == trackSelectionParameters.f22295w;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((this.f22274b + 31) * 31) + this.f22275c) * 31) + this.f22276d) * 31) + this.f22277e) * 31) + this.f22278f) * 31) + this.f22279g) * 31) + this.f22280h) * 31) + this.f22281i) * 31) + (this.f22284l ? 1 : 0)) * 31) + this.f22282j) * 31) + this.f22283k) * 31) + this.f22285m.hashCode()) * 31) + this.f22286n.hashCode()) * 31) + this.f22287o) * 31) + this.f22288p) * 31) + this.f22289q) * 31) + this.f22290r.hashCode()) * 31) + this.f22291s.hashCode()) * 31) + this.f22292t) * 31) + (this.f22293u ? 1 : 0)) * 31) + (this.f22294v ? 1 : 0)) * 31) + (this.f22295w ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.f22286n);
        parcel.writeInt(this.f22287o);
        parcel.writeList(this.f22291s);
        parcel.writeInt(this.f22292t);
        j0.Y0(parcel, this.f22293u);
        parcel.writeInt(this.f22274b);
        parcel.writeInt(this.f22275c);
        parcel.writeInt(this.f22276d);
        parcel.writeInt(this.f22277e);
        parcel.writeInt(this.f22278f);
        parcel.writeInt(this.f22279g);
        parcel.writeInt(this.f22280h);
        parcel.writeInt(this.f22281i);
        parcel.writeInt(this.f22282j);
        parcel.writeInt(this.f22283k);
        j0.Y0(parcel, this.f22284l);
        parcel.writeList(this.f22285m);
        parcel.writeInt(this.f22288p);
        parcel.writeInt(this.f22289q);
        parcel.writeList(this.f22290r);
        j0.Y0(parcel, this.f22294v);
        j0.Y0(parcel, this.f22295w);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f22296a;

        /* renamed from: b, reason: collision with root package name */
        public int f22297b;

        /* renamed from: c, reason: collision with root package name */
        public int f22298c;

        /* renamed from: d, reason: collision with root package name */
        public int f22299d;

        /* renamed from: e, reason: collision with root package name */
        public int f22300e;

        /* renamed from: f, reason: collision with root package name */
        public int f22301f;

        /* renamed from: g, reason: collision with root package name */
        public int f22302g;

        /* renamed from: h, reason: collision with root package name */
        public int f22303h;

        /* renamed from: i, reason: collision with root package name */
        public int f22304i;

        /* renamed from: j, reason: collision with root package name */
        public int f22305j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f22306k;

        /* renamed from: l, reason: collision with root package name */
        public ImmutableList<String> f22307l;

        /* renamed from: m, reason: collision with root package name */
        public ImmutableList<String> f22308m;

        /* renamed from: n, reason: collision with root package name */
        public int f22309n;

        /* renamed from: o, reason: collision with root package name */
        public int f22310o;

        /* renamed from: p, reason: collision with root package name */
        public int f22311p;

        /* renamed from: q, reason: collision with root package name */
        public ImmutableList<String> f22312q;

        /* renamed from: r, reason: collision with root package name */
        public ImmutableList<String> f22313r;

        /* renamed from: s, reason: collision with root package name */
        public int f22314s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f22315t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f22316u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f22317v;

        @Deprecated
        public b() {
            this.f22296a = Integer.MAX_VALUE;
            this.f22297b = Integer.MAX_VALUE;
            this.f22298c = Integer.MAX_VALUE;
            this.f22299d = Integer.MAX_VALUE;
            this.f22304i = Integer.MAX_VALUE;
            this.f22305j = Integer.MAX_VALUE;
            this.f22306k = true;
            this.f22307l = ImmutableList.of();
            this.f22308m = ImmutableList.of();
            this.f22309n = 0;
            this.f22310o = Integer.MAX_VALUE;
            this.f22311p = Integer.MAX_VALUE;
            this.f22312q = ImmutableList.of();
            this.f22313r = ImmutableList.of();
            this.f22314s = 0;
            this.f22315t = false;
            this.f22316u = false;
            this.f22317v = false;
        }

        public b A(Context context, boolean z10) {
            Point N = j0.N(context);
            return z(N.x, N.y, z10);
        }

        public TrackSelectionParameters w() {
            return new TrackSelectionParameters(this);
        }

        public b x(Context context) {
            if (j0.f22990a >= 19) {
                y(context);
            }
            return this;
        }

        @RequiresApi(19)
        public final void y(Context context) {
            CaptioningManager captioningManager;
            if ((j0.f22990a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f22314s = MetricsProto.MetricsEvent.DATA_PLAN_USAGE_SUMMARY;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f22313r = ImmutableList.of(j0.U(locale));
                }
            }
        }

        public b z(int i10, int i11, boolean z10) {
            this.f22304i = i10;
            this.f22305j = i11;
            this.f22306k = z10;
            return this;
        }

        public b(Context context) {
            this();
            x(context);
            A(context, true);
        }

        public b(TrackSelectionParameters trackSelectionParameters) {
            this.f22296a = trackSelectionParameters.f22274b;
            this.f22297b = trackSelectionParameters.f22275c;
            this.f22298c = trackSelectionParameters.f22276d;
            this.f22299d = trackSelectionParameters.f22277e;
            this.f22300e = trackSelectionParameters.f22278f;
            this.f22301f = trackSelectionParameters.f22279g;
            this.f22302g = trackSelectionParameters.f22280h;
            this.f22303h = trackSelectionParameters.f22281i;
            this.f22304i = trackSelectionParameters.f22282j;
            this.f22305j = trackSelectionParameters.f22283k;
            this.f22306k = trackSelectionParameters.f22284l;
            this.f22307l = trackSelectionParameters.f22285m;
            this.f22308m = trackSelectionParameters.f22286n;
            this.f22309n = trackSelectionParameters.f22287o;
            this.f22310o = trackSelectionParameters.f22288p;
            this.f22311p = trackSelectionParameters.f22289q;
            this.f22312q = trackSelectionParameters.f22290r;
            this.f22313r = trackSelectionParameters.f22291s;
            this.f22314s = trackSelectionParameters.f22292t;
            this.f22315t = trackSelectionParameters.f22293u;
            this.f22316u = trackSelectionParameters.f22294v;
            this.f22317v = trackSelectionParameters.f22295w;
        }
    }

    public TrackSelectionParameters(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        this.f22286n = ImmutableList.copyOf((Collection) arrayList);
        this.f22287o = parcel.readInt();
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, null);
        this.f22291s = ImmutableList.copyOf((Collection) arrayList2);
        this.f22292t = parcel.readInt();
        this.f22293u = j0.F0(parcel);
        this.f22274b = parcel.readInt();
        this.f22275c = parcel.readInt();
        this.f22276d = parcel.readInt();
        this.f22277e = parcel.readInt();
        this.f22278f = parcel.readInt();
        this.f22279g = parcel.readInt();
        this.f22280h = parcel.readInt();
        this.f22281i = parcel.readInt();
        this.f22282j = parcel.readInt();
        this.f22283k = parcel.readInt();
        this.f22284l = j0.F0(parcel);
        ArrayList arrayList3 = new ArrayList();
        parcel.readList(arrayList3, null);
        this.f22285m = ImmutableList.copyOf((Collection) arrayList3);
        this.f22288p = parcel.readInt();
        this.f22289q = parcel.readInt();
        ArrayList arrayList4 = new ArrayList();
        parcel.readList(arrayList4, null);
        this.f22290r = ImmutableList.copyOf((Collection) arrayList4);
        this.f22294v = j0.F0(parcel);
        this.f22295w = j0.F0(parcel);
    }
}
