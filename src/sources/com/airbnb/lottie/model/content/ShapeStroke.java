package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.layer.BaseLayer;
import e.s;
import i.b;
import i.d;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ShapeStroke implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f1977a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final b f1978b;

    /* renamed from: c, reason: collision with root package name */
    public final List<b> f1979c;

    /* renamed from: d, reason: collision with root package name */
    public final i.a f1980d;

    /* renamed from: e, reason: collision with root package name */
    public final d f1981e;

    /* renamed from: f, reason: collision with root package name */
    public final b f1982f;

    /* renamed from: g, reason: collision with root package name */
    public final LineCapType f1983g;

    /* renamed from: h, reason: collision with root package name */
    public final LineJoinType f1984h;

    /* renamed from: i, reason: collision with root package name */
    public final float f1985i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f1986j;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i10 = a.f1987a[ordinal()];
            if (i10 == 1) {
                return Paint.Cap.BUTT;
            }
            if (i10 != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i10 = a.f1988b[ordinal()];
            if (i10 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i10 == 2) {
                return Paint.Join.MITER;
            }
            if (i10 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1987a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f1988b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f1988b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1988b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1988b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f1987a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1987a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1987a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, @Nullable b bVar, List<b> list, i.a aVar, d dVar, b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f10, boolean z10) {
        this.f1977a = str;
        this.f1978b = bVar;
        this.f1979c = list;
        this.f1980d = aVar;
        this.f1981e = dVar;
        this.f1982f = bVar2;
        this.f1983g = lineCapType;
        this.f1984h = lineJoinType;
        this.f1985i = f10;
        this.f1986j = z10;
    }

    public LineCapType a() {
        return this.f1983g;
    }

    public i.a b() {
        return this.f1980d;
    }

    public b c() {
        return this.f1978b;
    }

    public LineJoinType d() {
        return this.f1984h;
    }

    public List<b> e() {
        return this.f1979c;
    }

    public float f() {
        return this.f1985i;
    }

    public String g() {
        return this.f1977a;
    }

    public d h() {
        return this.f1981e;
    }

    public b i() {
        return this.f1982f;
    }

    public boolean j() {
        return this.f1986j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new s(lottieDrawable, baseLayer, this);
    }
}
