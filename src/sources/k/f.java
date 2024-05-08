package k;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.i0;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import f.o;
import f.q;
import i.k;
import j.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import n.h;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

/* compiled from: TextLayer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f extends BaseLayer {
    public final StringBuilder D;
    public final RectF E;
    public final Matrix F;
    public final Paint G;
    public final Paint H;
    public final Map<h.b, List<e.c>> I;
    public final LongSparseArray<String> J;
    public final List<d> K;
    public final o L;
    public final LottieDrawable M;
    public final LottieComposition N;

    @Nullable
    public f.a<Integer, Integer> O;

    @Nullable
    public f.a<Integer, Integer> P;

    @Nullable
    public f.a<Integer, Integer> Q;

    @Nullable
    public f.a<Integer, Integer> R;

    @Nullable
    public f.a<Float, Float> S;

    @Nullable
    public f.a<Float, Float> T;

    @Nullable
    public f.a<Float, Float> U;

    @Nullable
    public f.a<Float, Float> V;

    @Nullable
    public f.a<Float, Float> W;

    @Nullable
    public f.a<Typeface, Typeface> X;

    /* compiled from: TextLayer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends Paint {
        public a(int i10) {
            super(i10);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class b extends Paint {
        public b(int i10) {
            super(i10);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* compiled from: TextLayer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50581a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f50581a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50581a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50581a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        i.b bVar;
        i.b bVar2;
        i.a aVar;
        i.a aVar2;
        this.D = new StringBuilder(2);
        this.E = new RectF();
        this.F = new Matrix();
        this.G = new a(1);
        this.H = new b(1);
        this.I = new HashMap();
        this.J = new LongSparseArray<>();
        this.K = new ArrayList();
        this.M = lottieDrawable;
        this.N = layer.b();
        o a10 = layer.s().a();
        this.L = a10;
        a10.a(this);
        i(a10);
        k t2 = layer.t();
        if (t2 != null && (aVar2 = t2.f49659a) != null) {
            f.a<Integer, Integer> a11 = aVar2.a();
            this.O = a11;
            a11.a(this);
            i(this.O);
        }
        if (t2 != null && (aVar = t2.f49660b) != null) {
            f.a<Integer, Integer> a12 = aVar.a();
            this.Q = a12;
            a12.a(this);
            i(this.Q);
        }
        if (t2 != null && (bVar2 = t2.f49661c) != null) {
            f.a<Float, Float> a13 = bVar2.a();
            this.S = a13;
            a13.a(this);
            i(this.S);
        }
        if (t2 == null || (bVar = t2.f49662d) == null) {
            return;
        }
        f.a<Float, Float> a14 = bVar.a();
        this.U = a14;
        a14.a(this);
        i(this.U);
    }

    public final String O(String str, int i10) {
        int codePointAt = str.codePointAt(i10);
        int charCount = Character.charCount(codePointAt) + i10;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!c0(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j10 = codePointAt;
        if (this.J.containsKey(j10)) {
            return this.J.get(j10);
        }
        this.D.setLength(0);
        while (i10 < charCount) {
            int codePointAt3 = str.codePointAt(i10);
            this.D.appendCodePoint(codePointAt3);
            i10 += Character.charCount(codePointAt3);
        }
        String sb2 = this.D.toString();
        this.J.put(j10, sb2);
        return sb2;
    }

    public final void P(DocumentData documentData, Matrix matrix) {
        f.a<Integer, Integer> aVar = this.P;
        if (aVar != null) {
            this.G.setColor(aVar.h().intValue());
        } else {
            f.a<Integer, Integer> aVar2 = this.O;
            if (aVar2 != null) {
                this.G.setColor(aVar2.h().intValue());
            } else {
                this.G.setColor(documentData.color);
            }
        }
        f.a<Integer, Integer> aVar3 = this.R;
        if (aVar3 != null) {
            this.H.setColor(aVar3.h().intValue());
        } else {
            f.a<Integer, Integer> aVar4 = this.Q;
            if (aVar4 != null) {
                this.H.setColor(aVar4.h().intValue());
            } else {
                this.H.setColor(documentData.strokeColor);
            }
        }
        int intValue = ((this.f2031x.h() == null ? 100 : this.f2031x.h().h().intValue()) * 255) / 100;
        this.G.setAlpha(intValue);
        this.H.setAlpha(intValue);
        f.a<Float, Float> aVar5 = this.T;
        if (aVar5 != null) {
            this.H.setStrokeWidth(aVar5.h().floatValue());
            return;
        }
        f.a<Float, Float> aVar6 = this.S;
        if (aVar6 != null) {
            this.H.setStrokeWidth(aVar6.h().floatValue());
        } else {
            this.H.setStrokeWidth(documentData.strokeWidth * h.e());
        }
    }

    public final void Q(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void R(h.b bVar, float f10, DocumentData documentData, Canvas canvas) {
        List<e.c> Z = Z(bVar);
        for (int i10 = 0; i10 < Z.size(); i10++) {
            Path path = Z.get(i10).getPath();
            path.computeBounds(this.E, false);
            this.F.reset();
            this.F.preTranslate(0.0f, (-documentData.baselineShift) * h.e());
            this.F.preScale(f10, f10);
            path.transform(this.F);
            if (documentData.strokeOverFill) {
                U(path, this.G, canvas);
                U(path, this.H, canvas);
            } else {
                U(path, this.H, canvas);
                U(path, this.G, canvas);
            }
        }
    }

    public final void S(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.strokeOverFill) {
            Q(str, this.G, canvas);
            Q(str, this.H, canvas);
        } else {
            Q(str, this.H, canvas);
            Q(str, this.G, canvas);
        }
    }

    public final void T(String str, DocumentData documentData, Canvas canvas, float f10) {
        int i10 = 0;
        while (i10 < str.length()) {
            String O = O(str, i10);
            i10 += O.length();
            S(O, documentData, canvas);
            canvas.translate(this.G.measureText(O) + f10, 0.0f);
        }
    }

    public final void U(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void V(String str, DocumentData documentData, h.a aVar, Canvas canvas, float f10, float f11, float f12) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            h.b bVar = this.N.c().get(h.b.c(str.charAt(i10), aVar.a(), aVar.c()));
            if (bVar != null) {
                R(bVar, f11, documentData, canvas);
                canvas.translate((((float) bVar.b()) * f11 * h.e()) + f12, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void W(com.airbnb.lottie.model.DocumentData r19, h.a r20, android.graphics.Canvas r21) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            android.graphics.Typeface r0 = r7.b0(r9)
            if (r0 != 0) goto Lf
            return
        Lf:
            java.lang.String r1 = r8.text
            com.airbnb.lottie.LottieDrawable r2 = r7.M
            com.airbnb.lottie.o0 r2 = r2.Z()
            if (r2 == 0) goto L21
            java.lang.String r3 = r18.getName()
            java.lang.String r1 = r2.c(r3, r1)
        L21:
            android.graphics.Paint r2 = r7.G
            r2.setTypeface(r0)
            f.a<java.lang.Float, java.lang.Float> r0 = r7.W
            if (r0 == 0) goto L35
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L37
        L35:
            float r0 = r8.size
        L37:
            android.graphics.Paint r2 = r7.G
            float r3 = n.h.e()
            float r3 = r3 * r0
            r2.setTextSize(r3)
            android.graphics.Paint r2 = r7.H
            android.graphics.Paint r3 = r7.G
            android.graphics.Typeface r3 = r3.getTypeface()
            r2.setTypeface(r3)
            android.graphics.Paint r2 = r7.H
            android.graphics.Paint r3 = r7.G
            float r3 = r3.getTextSize()
            r2.setTextSize(r3)
            int r2 = r8.tracking
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            f.a<java.lang.Float, java.lang.Float> r3 = r7.V
            if (r3 == 0) goto L6e
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
        L6c:
            float r2 = r2 + r3
            goto L7d
        L6e:
            f.a<java.lang.Float, java.lang.Float> r3 = r7.U
            if (r3 == 0) goto L7d
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L6c
        L7d:
            float r3 = n.h.e()
            float r2 = r2 * r3
            float r2 = r2 * r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r11 = r2 / r0
            java.util.List r12 = r7.a0(r1)
            int r13 = r12.size()
            r0 = -1
            r14 = 0
            r6 = 0
            r15 = -1
        L95:
            if (r6 >= r13) goto Le1
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r8.boxSize
            if (r0 != 0) goto La5
            r0 = 0
            r2 = 0
            goto La8
        La5:
            float r0 = r0.x
            r2 = r0
        La8:
            r4 = 0
            r16 = 0
            r0 = r18
            r3 = r20
            r5 = r11
            r17 = r6
            r6 = r16
            java.util.List r0 = r0.e0(r1, r2, r3, r4, r5, r6)
            r1 = 0
        Lb9:
            int r2 = r0.size()
            if (r1 >= r2) goto Lde
            java.lang.Object r2 = r0.get(r1)
            k.f$d r2 = (k.f.d) r2
            int r15 = r15 + 1
            r21.save()
            float r3 = k.f.d.a(r2)
            r7.d0(r10, r8, r15, r3)
            java.lang.String r2 = k.f.d.b(r2)
            r7.T(r2, r8, r10, r11)
            r21.restore()
            int r1 = r1 + 1
            goto Lb9
        Lde:
            int r6 = r17 + 1
            goto L95
        Le1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k.f.W(com.airbnb.lottie.model.DocumentData, h.a, android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void X(com.airbnb.lottie.model.DocumentData r21, android.graphics.Matrix r22, h.a r23, android.graphics.Canvas r24) {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            f.a<java.lang.Float, java.lang.Float> r0 = r8.W
            if (r0 == 0) goto L13
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L15
        L13:
            float r0 = r9.size
        L15:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r10 = r0 / r1
            float r11 = n.h.g(r22)
            java.lang.String r0 = r9.text
            java.util.List r12 = r8.a0(r0)
            int r13 = r12.size()
            int r0 = r9.tracking
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            f.a<java.lang.Float, java.lang.Float> r1 = r8.V
            if (r1 == 0) goto L3d
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L3b:
            float r0 = r0 + r1
            goto L4c
        L3d:
            f.a<java.lang.Float, java.lang.Float> r1 = r8.U
            if (r1 == 0) goto L4c
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L3b
        L4c:
            r14 = r0
            r0 = -1
            r15 = 0
            r6 = 0
            r7 = -1
        L51:
            if (r6 >= r13) goto Lb2
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r9.boxSize
            if (r0 != 0) goto L61
            r0 = 0
            r2 = 0
            goto L64
        L61:
            float r0 = r0.x
            r2 = r0
        L64:
            r16 = 1
            r0 = r20
            r3 = r23
            r4 = r10
            r5 = r14
            r17 = r6
            r6 = r16
            java.util.List r6 = r0.e0(r1, r2, r3, r4, r5, r6)
            r5 = 0
        L75:
            int r0 = r6.size()
            if (r5 >= r0) goto Laf
            java.lang.Object r0 = r6.get(r5)
            k.f$d r0 = (k.f.d) r0
            int r7 = r7 + 1
            r24.save()
            float r1 = k.f.d.a(r0)
            r4 = r24
            r8.d0(r4, r9, r7, r1)
            java.lang.String r1 = k.f.d.b(r0)
            r0 = r20
            r2 = r21
            r3 = r23
            r16 = r5
            r5 = r11
            r18 = r6
            r6 = r10
            r19 = r7
            r7 = r14
            r0.V(r1, r2, r3, r4, r5, r6, r7)
            r24.restore()
            int r5 = r16 + 1
            r6 = r18
            r7 = r19
            goto L75
        Laf:
            int r6 = r17 + 1
            goto L51
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k.f.X(com.airbnb.lottie.model.DocumentData, android.graphics.Matrix, h.a, android.graphics.Canvas):void");
    }

    public final d Y(int i10) {
        for (int size = this.K.size(); size < i10; size++) {
            this.K.add(new d(null));
        }
        return this.K.get(i10 - 1);
    }

    public final List<e.c> Z(h.b bVar) {
        if (this.I.containsKey(bVar)) {
            return this.I.get(bVar);
        }
        List<i> a10 = bVar.a();
        int size = a10.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new e.c(this.M, this, a10.get(i10), this.N));
        }
        this.I.put(bVar, arrayList);
        return arrayList;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, h.d
    public <T> void a(T t2, @Nullable o.c<T> cVar) {
        super.a(t2, cVar);
        if (t2 == i0.f1912a) {
            f.a<Integer, Integer> aVar = this.P;
            if (aVar != null) {
                G(aVar);
            }
            if (cVar == null) {
                this.P = null;
                return;
            }
            q qVar = new q(cVar);
            this.P = qVar;
            qVar.a(this);
            i(this.P);
            return;
        }
        if (t2 == i0.f1913b) {
            f.a<Integer, Integer> aVar2 = this.R;
            if (aVar2 != null) {
                G(aVar2);
            }
            if (cVar == null) {
                this.R = null;
                return;
            }
            q qVar2 = new q(cVar);
            this.R = qVar2;
            qVar2.a(this);
            i(this.R);
            return;
        }
        if (t2 == i0.f1930s) {
            f.a<Float, Float> aVar3 = this.T;
            if (aVar3 != null) {
                G(aVar3);
            }
            if (cVar == null) {
                this.T = null;
                return;
            }
            q qVar3 = new q(cVar);
            this.T = qVar3;
            qVar3.a(this);
            i(this.T);
            return;
        }
        if (t2 == i0.f1931t) {
            f.a<Float, Float> aVar4 = this.V;
            if (aVar4 != null) {
                G(aVar4);
            }
            if (cVar == null) {
                this.V = null;
                return;
            }
            q qVar4 = new q(cVar);
            this.V = qVar4;
            qVar4.a(this);
            i(this.V);
            return;
        }
        if (t2 == i0.F) {
            f.a<Float, Float> aVar5 = this.W;
            if (aVar5 != null) {
                G(aVar5);
            }
            if (cVar == null) {
                this.W = null;
                return;
            }
            q qVar5 = new q(cVar);
            this.W = qVar5;
            qVar5.a(this);
            i(this.W);
            return;
        }
        if (t2 == i0.M) {
            f.a<Typeface, Typeface> aVar6 = this.X;
            if (aVar6 != null) {
                G(aVar6);
            }
            if (cVar == null) {
                this.X = null;
                return;
            }
            q qVar6 = new q(cVar);
            this.X = qVar6;
            qVar6.a(this);
            i(this.X);
            return;
        }
        if (t2 == i0.O) {
            this.L.q(cVar);
        }
    }

    public final List<String> a0(String str) {
        return Arrays.asList(str.replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, StringUtils.CR).replaceAll("\u0003", StringUtils.CR).replaceAll("\n", StringUtils.CR).split(StringUtils.CR));
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, e.d
    public void b(RectF rectF, Matrix matrix, boolean z10) {
        super.b(rectF, matrix, z10);
        rectF.set(0.0f, 0.0f, this.N.b().width(), this.N.b().height());
    }

    @Nullable
    public final Typeface b0(h.a aVar) {
        Typeface h10;
        f.a<Typeface, Typeface> aVar2 = this.X;
        if (aVar2 != null && (h10 = aVar2.h()) != null) {
            return h10;
        }
        Typeface a02 = this.M.a0(aVar);
        return a02 != null ? a02 : aVar.d();
    }

    public final boolean c0(int i10) {
        return Character.getType(i10) == 16 || Character.getType(i10) == 27 || Character.getType(i10) == 6 || Character.getType(i10) == 28 || Character.getType(i10) == 8 || Character.getType(i10) == 19;
    }

    public final void d0(Canvas canvas, DocumentData documentData, int i10, float f10) {
        PointF pointF = documentData.boxPosition;
        PointF pointF2 = documentData.boxSize;
        float e2 = h.e();
        float f11 = (i10 * documentData.lineHeight * e2) + (pointF == null ? 0.0f : (documentData.lineHeight * e2) + pointF.y);
        float f12 = pointF == null ? 0.0f : pointF.x;
        float f13 = pointF2 != null ? pointF2.x : 0.0f;
        int i11 = c.f50581a[documentData.justification.ordinal()];
        if (i11 == 1) {
            canvas.translate(f12, f11);
        } else if (i11 == 2) {
            canvas.translate((f12 + f13) - f10, f11);
        } else {
            if (i11 != 3) {
                return;
            }
            canvas.translate((f12 + (f13 / 2.0f)) - (f10 / 2.0f), f11);
        }
    }

    public final List<d> e0(String str, float f10, h.a aVar, float f11, float f12, boolean z10) {
        float measureText;
        float f13 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        boolean z11 = false;
        float f14 = 0.0f;
        int i12 = 0;
        float f15 = 0.0f;
        for (int i13 = 0; i13 < str.length(); i13++) {
            char charAt = str.charAt(i13);
            if (z10) {
                h.b bVar = this.N.c().get(h.b.c(charAt, aVar.a(), aVar.c()));
                if (bVar != null) {
                    measureText = ((float) bVar.b()) * f11 * h.e();
                }
            } else {
                measureText = this.G.measureText(str.substring(i13, i13 + 1));
            }
            float f16 = measureText + f12;
            if (charAt == ' ') {
                z11 = true;
                f15 = f16;
            } else if (z11) {
                i12 = i13;
                f14 = f16;
                z11 = false;
            } else {
                f14 += f16;
            }
            f13 += f16;
            if (f10 > 0.0f && f13 >= f10 && charAt != ' ') {
                i10++;
                d Y = Y(i10);
                if (i12 == i11) {
                    Y.c(str.substring(i11, i13).trim(), (f13 - f16) - ((r9.length() - r7.length()) * f15));
                    i11 = i13;
                    i12 = i11;
                    f13 = f16;
                    f14 = f13;
                } else {
                    Y.c(str.substring(i11, i12 - 1).trim(), ((f13 - f14) - ((r7.length() - r13.length()) * f15)) - f15);
                    f13 = f14;
                    i11 = i12;
                }
            }
        }
        if (f13 > 0.0f) {
            i10++;
            Y(i10).c(str.substring(i11), f13);
        }
        return this.K.subList(0, i10);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void t(Canvas canvas, Matrix matrix, int i10) {
        DocumentData h10 = this.L.h();
        h.a aVar = this.N.g().get(h10.fontName);
        if (aVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        P(h10, matrix);
        if (this.M.j1()) {
            X(h10, matrix, aVar, canvas);
        } else {
            W(h10, aVar, canvas);
        }
        canvas.restore();
    }

    /* compiled from: TextLayer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f50582a;

        /* renamed from: b, reason: collision with root package name */
        public float f50583b;

        public d() {
            this.f50582a = "";
            this.f50583b = 0.0f;
        }

        public void c(String str, float f10) {
            this.f50582a = str;
            this.f50583b = f10;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
