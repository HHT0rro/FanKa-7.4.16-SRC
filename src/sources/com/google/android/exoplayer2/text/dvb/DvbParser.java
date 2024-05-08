package com.google.android.exoplayer2.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.u;
import e6.a;
import java.io.ObjectStreamConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DvbParser {

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f22168h = {0, 7, 8, 15};

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f22169i = {0, ObjectStreamConstants.TC_BLOCKDATA, -120, -1};

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f22170j = {0, 17, 34, 51, 68, 85, 102, ObjectStreamConstants.TC_BLOCKDATA, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f22171a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f22172b;

    /* renamed from: c, reason: collision with root package name */
    public final Canvas f22173c;

    /* renamed from: d, reason: collision with root package name */
    public final b f22174d;

    /* renamed from: e, reason: collision with root package name */
    public final a f22175e;

    /* renamed from: f, reason: collision with root package name */
    public final g f22176f;

    /* renamed from: g, reason: collision with root package name */
    public Bitmap f22177g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class ObjectData {
        public final byte[] bottomFieldData;

        /* renamed from: id, reason: collision with root package name */
        public final int f22178id;
        public final boolean nonModifyingColorFlag;
        public final byte[] topFieldData;

        public ObjectData(int i10, boolean z10, byte[] bArr, byte[] bArr2) {
            this.f22178id = i10;
            this.nonModifyingColorFlag = z10;
            this.topFieldData = bArr;
            this.bottomFieldData = bArr2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f22179a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f22180b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f22181c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f22182d;

        public a(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f22179a = i10;
            this.f22180b = iArr;
            this.f22181c = iArr2;
            this.f22182d = iArr3;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f22183a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22184b;

        /* renamed from: c, reason: collision with root package name */
        public final int f22185c;

        /* renamed from: d, reason: collision with root package name */
        public final int f22186d;

        /* renamed from: e, reason: collision with root package name */
        public final int f22187e;

        /* renamed from: f, reason: collision with root package name */
        public final int f22188f;

        public b(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f22183a = i10;
            this.f22184b = i11;
            this.f22185c = i12;
            this.f22186d = i13;
            this.f22187e = i14;
            this.f22188f = i15;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f22189a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22190b;

        /* renamed from: c, reason: collision with root package name */
        public final int f22191c;

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray<d> f22192d;

        public c(int i10, int i11, int i12, SparseArray<d> sparseArray) {
            this.f22189a = i10;
            this.f22190b = i11;
            this.f22191c = i12;
            this.f22192d = sparseArray;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f22193a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22194b;

        public d(int i10, int i11) {
            this.f22193a = i10;
            this.f22194b = i11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f22195a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f22196b;

        /* renamed from: c, reason: collision with root package name */
        public final int f22197c;

        /* renamed from: d, reason: collision with root package name */
        public final int f22198d;

        /* renamed from: e, reason: collision with root package name */
        public final int f22199e;

        /* renamed from: f, reason: collision with root package name */
        public final int f22200f;

        /* renamed from: g, reason: collision with root package name */
        public final int f22201g;

        /* renamed from: h, reason: collision with root package name */
        public final int f22202h;

        /* renamed from: i, reason: collision with root package name */
        public final int f22203i;

        /* renamed from: j, reason: collision with root package name */
        public final int f22204j;

        /* renamed from: k, reason: collision with root package name */
        public final SparseArray<f> f22205k;

        public e(int i10, boolean z10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, SparseArray<f> sparseArray) {
            this.f22195a = i10;
            this.f22196b = z10;
            this.f22197c = i11;
            this.f22198d = i12;
            this.f22199e = i13;
            this.f22200f = i14;
            this.f22201g = i15;
            this.f22202h = i16;
            this.f22203i = i17;
            this.f22204j = i18;
            this.f22205k = sparseArray;
        }

        public void a(e eVar) {
            SparseArray<f> sparseArray = eVar.f22205k;
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                this.f22205k.put(sparseArray.keyAt(i10), sparseArray.valueAt(i10));
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f22206a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22207b;

        /* renamed from: c, reason: collision with root package name */
        public final int f22208c;

        /* renamed from: d, reason: collision with root package name */
        public final int f22209d;

        /* renamed from: e, reason: collision with root package name */
        public final int f22210e;

        /* renamed from: f, reason: collision with root package name */
        public final int f22211f;

        public f(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f22206a = i10;
            this.f22207b = i11;
            this.f22208c = i12;
            this.f22209d = i13;
            this.f22210e = i14;
            this.f22211f = i15;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final int f22212a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22213b;

        /* renamed from: c, reason: collision with root package name */
        public final SparseArray<e> f22214c = new SparseArray<>();

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray<a> f22215d = new SparseArray<>();

        /* renamed from: e, reason: collision with root package name */
        public final SparseArray<ObjectData> f22216e = new SparseArray<>();

        /* renamed from: f, reason: collision with root package name */
        public final SparseArray<a> f22217f = new SparseArray<>();

        /* renamed from: g, reason: collision with root package name */
        public final SparseArray<ObjectData> f22218g = new SparseArray<>();

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public b f22219h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public c f22220i;

        public g(int i10, int i11) {
            this.f22212a = i10;
            this.f22213b = i11;
        }

        public void a() {
            this.f22214c.clear();
            this.f22215d.clear();
            this.f22216e.clear();
            this.f22217f.clear();
            this.f22218g.clear();
            this.f22219h = null;
            this.f22220i = null;
        }
    }

    public DvbParser(int i10, int i11) {
        Paint paint = new Paint();
        this.f22171a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f22172b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f22173c = new Canvas();
        this.f22174d = new b(MetricsProto.MetricsEvent.ACTION_PERMISSION_GRANT_RECEIVE_WAP_PUSH, MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_DISCONNECT, 0, MetricsProto.MetricsEvent.ACTION_PERMISSION_GRANT_RECEIVE_WAP_PUSH, 0, MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_DISCONNECT);
        this.f22175e = new a(0, c(), d(), e());
        this.f22176f = new g(i10, i11);
    }

    public static byte[] a(int i10, int i11, u uVar) {
        byte[] bArr = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr[i12] = (byte) uVar.h(i11);
        }
        return bArr;
    }

    public static int[] c() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    public static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i10 = 1; i10 < 16; i10++) {
            if (i10 < 8) {
                iArr[i10] = f(255, (i10 & 1) != 0 ? 255 : 0, (i10 & 2) != 0 ? 255 : 0, (i10 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i10] = f(255, (i10 & 1) != 0 ? 127 : 0, (i10 & 2) != 0 ? 127 : 0, (i10 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i10 = 0; i10 < 256; i10++) {
            if (i10 < 8) {
                iArr[i10] = f(63, (i10 & 1) != 0 ? 255 : 0, (i10 & 2) != 0 ? 255 : 0, (i10 & 4) == 0 ? 0 : 255);
            } else {
                int i11 = i10 & 136;
                if (i11 == 0) {
                    iArr[i10] = f(255, ((i10 & 1) != 0 ? 85 : 0) + ((i10 & 16) != 0 ? 170 : 0), ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0), ((i10 & 4) == 0 ? 0 : 85) + ((i10 & 64) == 0 ? 0 : 170));
                } else if (i11 == 8) {
                    iArr[i10] = f(127, ((i10 & 1) != 0 ? 85 : 0) + ((i10 & 16) != 0 ? 170 : 0), ((i10 & 2) != 0 ? 85 : 0) + ((i10 & 32) != 0 ? 170 : 0), ((i10 & 4) == 0 ? 0 : 85) + ((i10 & 64) == 0 ? 0 : 170));
                } else if (i11 == 128) {
                    iArr[i10] = f(255, ((i10 & 1) != 0 ? 43 : 0) + 127 + ((i10 & 16) != 0 ? 85 : 0), ((i10 & 2) != 0 ? 43 : 0) + 127 + ((i10 & 32) != 0 ? 85 : 0), ((i10 & 4) == 0 ? 0 : 43) + 127 + ((i10 & 64) == 0 ? 0 : 85));
                } else if (i11 == 136) {
                    iArr[i10] = f(255, ((i10 & 1) != 0 ? 43 : 0) + ((i10 & 16) != 0 ? 85 : 0), ((i10 & 2) != 0 ? 43 : 0) + ((i10 & 32) != 0 ? 85 : 0), ((i10 & 4) == 0 ? 0 : 43) + ((i10 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int f(int i10, int i11, int i12, int i13) {
        return (i10 << 24) | (i11 << 16) | (i12 << 8) | i13;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0083 A[LOOP:0: B:2:0x0009->B:13:0x0083, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int g(com.google.android.exoplayer2.util.u r13, int[] r14, @androidx.annotation.Nullable byte[] r15, int r16, int r17, @androidx.annotation.Nullable android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L9:
            r3 = 2
            int r4 = r13.h(r3)
            r5 = 1
            if (r4 == 0) goto L14
            r11 = r2
        L12:
            r12 = 1
            goto L61
        L14:
            boolean r4 = r13.g()
            r6 = 3
            if (r4 == 0) goto L28
            int r4 = r13.h(r6)
            int r4 = r4 + r6
            int r3 = r13.h(r3)
        L24:
            r11 = r2
            r12 = r4
            r4 = r3
            goto L61
        L28:
            boolean r4 = r13.g()
            if (r4 == 0) goto L31
            r11 = r2
            r4 = 0
            goto L12
        L31:
            int r4 = r13.h(r3)
            if (r4 == 0) goto L5e
            if (r4 == r5) goto L5a
            if (r4 == r3) goto L4e
            if (r4 == r6) goto L41
            r11 = r2
            r4 = 0
        L3f:
            r12 = 0
            goto L61
        L41:
            r4 = 8
            int r4 = r13.h(r4)
            int r4 = r4 + 29
            int r3 = r13.h(r3)
            goto L24
        L4e:
            r4 = 4
            int r4 = r13.h(r4)
            int r4 = r4 + 12
            int r3 = r13.h(r3)
            goto L24
        L5a:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L61
        L5e:
            r4 = 0
            r11 = 1
            goto L3f
        L61:
            if (r12 == 0) goto L7f
            if (r8 == 0) goto L7f
            if (r15 == 0) goto L69
            r4 = r15[r4]
        L69:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L7f:
            int r10 = r10 + r12
            if (r11 == 0) goto L83
            return r10
        L83:
            r2 = r11
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.dvb.DvbParser.g(com.google.android.exoplayer2.util.u, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008e A[LOOP:0: B:2:0x0009->B:13:0x008e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int h(com.google.android.exoplayer2.util.u r13, int[] r14, @androidx.annotation.Nullable byte[] r15, int r16, int r17, @androidx.annotation.Nullable android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L9:
            r3 = 4
            int r4 = r13.h(r3)
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L16
            r11 = r2
        L13:
            r12 = 1
            goto L6e
        L16:
            boolean r4 = r13.g()
            r7 = 3
            if (r4 != 0) goto L2c
            int r3 = r13.h(r7)
            if (r3 == 0) goto L29
            int r5 = r3 + 2
            r11 = r2
            r12 = r5
            r4 = 0
            goto L6e
        L29:
            r4 = 0
            r11 = 1
            goto L4d
        L2c:
            boolean r4 = r13.g()
            if (r4 != 0) goto L3f
            int r4 = r13.h(r5)
            int r5 = r4 + 4
            int r4 = r13.h(r3)
        L3c:
            r11 = r2
            r12 = r5
            goto L6e
        L3f:
            int r4 = r13.h(r5)
            if (r4 == 0) goto L6b
            if (r4 == r6) goto L67
            if (r4 == r5) goto L5c
            if (r4 == r7) goto L4f
            r11 = r2
            r4 = 0
        L4d:
            r12 = 0
            goto L6e
        L4f:
            r4 = 8
            int r4 = r13.h(r4)
            int r5 = r4 + 25
            int r4 = r13.h(r3)
            goto L3c
        L5c:
            int r4 = r13.h(r3)
            int r5 = r4 + 9
            int r4 = r13.h(r3)
            goto L3c
        L67:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L6e
        L6b:
            r11 = r2
            r4 = 0
            goto L13
        L6e:
            if (r12 == 0) goto L8a
            if (r8 == 0) goto L8a
            if (r15 == 0) goto L76
            r4 = r15[r4]
        L76:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r5 = (float) r2
            int r2 = r1 + 1
            float r6 = (float) r2
            r2 = r19
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L8a:
            int r10 = r10 + r12
            if (r11 == 0) goto L8e
            return r10
        L8e:
            r2 = r11
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.dvb.DvbParser.h(com.google.android.exoplayer2.util.u, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    public static int i(u uVar, int[] iArr, @Nullable byte[] bArr, int i10, int i11, @Nullable Paint paint, Canvas canvas) {
        boolean z10;
        int h10;
        int i12 = i10;
        boolean z11 = false;
        while (true) {
            int h11 = uVar.h(8);
            if (h11 != 0) {
                z10 = z11;
                h10 = 1;
            } else if (!uVar.g()) {
                int h12 = uVar.h(7);
                if (h12 != 0) {
                    z10 = z11;
                    h10 = h12;
                    h11 = 0;
                } else {
                    h11 = 0;
                    z10 = true;
                    h10 = 0;
                }
            } else {
                z10 = z11;
                h10 = uVar.h(7);
                h11 = uVar.h(8);
            }
            if (h10 != 0 && paint != null) {
                if (bArr != null) {
                    h11 = bArr[h11];
                }
                paint.setColor(iArr[h11]);
                canvas.drawRect(i12, i11, i12 + h10, i11 + 1, paint);
            }
            i12 += h10;
            if (z10) {
                return i12;
            }
            z11 = z10;
        }
    }

    public static void j(byte[] bArr, int[] iArr, int i10, int i11, int i12, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        u uVar = new u(bArr);
        int i13 = i11;
        int i14 = i12;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        while (uVar.b() != 0) {
            int h10 = uVar.h(8);
            if (h10 != 240) {
                switch (h10) {
                    case 16:
                        if (i10 != 3) {
                            if (i10 == 2) {
                                bArr3 = bArr7 == null ? f22168h : bArr7;
                            } else {
                                bArr2 = null;
                                i13 = g(uVar, iArr, bArr2, i13, i14, paint, canvas);
                                uVar.c();
                                break;
                            }
                        } else {
                            bArr3 = bArr5 == null ? f22169i : bArr5;
                        }
                        bArr2 = bArr3;
                        i13 = g(uVar, iArr, bArr2, i13, i14, paint, canvas);
                        uVar.c();
                    case 17:
                        if (i10 == 3) {
                            bArr4 = bArr6 == null ? f22170j : bArr6;
                        } else {
                            bArr4 = null;
                        }
                        i13 = h(uVar, iArr, bArr4, i13, i14, paint, canvas);
                        uVar.c();
                        break;
                    case 18:
                        i13 = i(uVar, iArr, null, i13, i14, paint, canvas);
                        break;
                    default:
                        switch (h10) {
                            case 32:
                                bArr7 = a(4, 4, uVar);
                                break;
                            case 33:
                                bArr5 = a(4, 8, uVar);
                                break;
                            case 34:
                                bArr6 = a(16, 8, uVar);
                                break;
                        }
                }
            } else {
                i14 += 2;
                i13 = i11;
            }
        }
    }

    public static void k(ObjectData objectData, a aVar, int i10, int i11, int i12, @Nullable Paint paint, Canvas canvas) {
        int[] iArr;
        if (i10 == 3) {
            iArr = aVar.f22182d;
        } else if (i10 == 2) {
            iArr = aVar.f22181c;
        } else {
            iArr = aVar.f22180b;
        }
        int[] iArr2 = iArr;
        j(objectData.topFieldData, iArr2, i10, i11, i12, paint, canvas);
        j(objectData.bottomFieldData, iArr2, i10, i11, i12 + 1, paint, canvas);
    }

    public static a l(u uVar, int i10) {
        int h10;
        int i11;
        int h11;
        int i12;
        int i13;
        int i14 = 8;
        int h12 = uVar.h(8);
        uVar.r(8);
        int i15 = 2;
        int i16 = i10 - 2;
        int[] c4 = c();
        int[] d10 = d();
        int[] e2 = e();
        while (i16 > 0) {
            int h13 = uVar.h(i14);
            int h14 = uVar.h(i14);
            int i17 = i16 - 2;
            int[] iArr = (h14 & 128) != 0 ? c4 : (h14 & 64) != 0 ? d10 : e2;
            if ((h14 & 1) != 0) {
                i12 = uVar.h(i14);
                i13 = uVar.h(i14);
                h10 = uVar.h(i14);
                h11 = uVar.h(i14);
                i11 = i17 - 4;
            } else {
                int h15 = uVar.h(6) << i15;
                int h16 = uVar.h(4) << 4;
                h10 = uVar.h(4) << 4;
                i11 = i17 - 2;
                h11 = uVar.h(i15) << 6;
                i12 = h15;
                i13 = h16;
            }
            if (i12 == 0) {
                i13 = 0;
                h10 = 0;
                h11 = 255;
            }
            double d11 = i12;
            double d12 = i13 - 128;
            double d13 = h10 - 128;
            iArr[h13] = f((byte) (255 - (h11 & 255)), j0.r((int) (d11 + (1.402d * d12)), 0, 255), j0.r((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255), j0.r((int) (d11 + (d13 * 1.772d)), 0, 255));
            i16 = i11;
            h12 = h12;
            i14 = 8;
            i15 = 2;
        }
        return new a(h12, c4, d10, e2);
    }

    public static b m(u uVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        uVar.r(4);
        boolean g3 = uVar.g();
        uVar.r(3);
        int h10 = uVar.h(16);
        int h11 = uVar.h(16);
        if (g3) {
            int h12 = uVar.h(16);
            int h13 = uVar.h(16);
            int h14 = uVar.h(16);
            i11 = uVar.h(16);
            i10 = h13;
            i13 = h14;
            i12 = h12;
        } else {
            i10 = h10;
            i11 = h11;
            i12 = 0;
            i13 = 0;
        }
        return new b(h10, h11, i12, i10, i13, i11);
    }

    public static ObjectData n(u uVar) {
        byte[] bArr;
        int h10 = uVar.h(16);
        uVar.r(4);
        int h11 = uVar.h(2);
        boolean g3 = uVar.g();
        uVar.r(1);
        byte[] bArr2 = j0.f22995f;
        if (h11 == 1) {
            uVar.r(uVar.h(8) * 16);
        } else if (h11 == 0) {
            int h12 = uVar.h(16);
            int h13 = uVar.h(16);
            if (h12 > 0) {
                bArr2 = new byte[h12];
                uVar.k(bArr2, 0, h12);
            }
            if (h13 > 0) {
                bArr = new byte[h13];
                uVar.k(bArr, 0, h13);
                return new ObjectData(h10, g3, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new ObjectData(h10, g3, bArr2, bArr);
    }

    public static c o(u uVar, int i10) {
        int h10 = uVar.h(8);
        int h11 = uVar.h(4);
        int h12 = uVar.h(2);
        uVar.r(2);
        int i11 = i10 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i11 > 0) {
            int h13 = uVar.h(8);
            uVar.r(8);
            i11 -= 6;
            sparseArray.put(h13, new d(uVar.h(16), uVar.h(16)));
        }
        return new c(h10, h11, h12, sparseArray);
    }

    public static e p(u uVar, int i10) {
        int h10;
        int h11;
        int h12 = uVar.h(8);
        uVar.r(4);
        boolean g3 = uVar.g();
        uVar.r(3);
        int i11 = 16;
        int h13 = uVar.h(16);
        int h14 = uVar.h(16);
        int h15 = uVar.h(3);
        int h16 = uVar.h(3);
        int i12 = 2;
        uVar.r(2);
        int h17 = uVar.h(8);
        int h18 = uVar.h(8);
        int h19 = uVar.h(4);
        int h20 = uVar.h(2);
        uVar.r(2);
        int i13 = i10 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i13 > 0) {
            int h21 = uVar.h(i11);
            int h22 = uVar.h(i12);
            int h23 = uVar.h(i12);
            int h24 = uVar.h(12);
            int i14 = h20;
            uVar.r(4);
            int h25 = uVar.h(12);
            i13 -= 6;
            if (h22 == 1 || h22 == 2) {
                i13 -= 2;
                h10 = uVar.h(8);
                h11 = uVar.h(8);
            } else {
                h10 = 0;
                h11 = 0;
            }
            sparseArray.put(h21, new f(h22, h23, h24, h25, h10, h11));
            h20 = i14;
            i12 = 2;
            i11 = 16;
        }
        return new e(h12, g3, h13, h14, h15, h16, h17, h18, h19, h20, sparseArray);
    }

    public static void q(u uVar, g gVar) {
        e eVar;
        int h10 = uVar.h(8);
        int h11 = uVar.h(16);
        int h12 = uVar.h(16);
        int d10 = uVar.d() + h12;
        if (h12 * 8 > uVar.b()) {
            m.h("DvbParser", "Data field length exceeds limit");
            uVar.r(uVar.b());
            return;
        }
        switch (h10) {
            case 16:
                if (h11 == gVar.f22212a) {
                    c cVar = gVar.f22220i;
                    c o10 = o(uVar, h12);
                    if (o10.f22191c != 0) {
                        gVar.f22220i = o10;
                        gVar.f22214c.clear();
                        gVar.f22215d.clear();
                        gVar.f22216e.clear();
                        break;
                    } else if (cVar != null && cVar.f22190b != o10.f22190b) {
                        gVar.f22220i = o10;
                        break;
                    }
                }
                break;
            case 17:
                c cVar2 = gVar.f22220i;
                if (h11 == gVar.f22212a && cVar2 != null) {
                    e p10 = p(uVar, h12);
                    if (cVar2.f22191c == 0 && (eVar = gVar.f22214c.get(p10.f22195a)) != null) {
                        p10.a(eVar);
                    }
                    gVar.f22214c.put(p10.f22195a, p10);
                    break;
                }
                break;
            case 18:
                if (h11 == gVar.f22212a) {
                    a l10 = l(uVar, h12);
                    gVar.f22215d.put(l10.f22179a, l10);
                    break;
                } else if (h11 == gVar.f22213b) {
                    a l11 = l(uVar, h12);
                    gVar.f22217f.put(l11.f22179a, l11);
                    break;
                }
                break;
            case 19:
                if (h11 == gVar.f22212a) {
                    ObjectData n10 = n(uVar);
                    gVar.f22216e.put(n10.f22178id, n10);
                    break;
                } else if (h11 == gVar.f22213b) {
                    ObjectData n11 = n(uVar);
                    gVar.f22218g.put(n11.f22178id, n11);
                    break;
                }
                break;
            case 20:
                if (h11 == gVar.f22212a) {
                    gVar.f22219h = m(uVar);
                    break;
                }
                break;
        }
        uVar.s(d10 - uVar.d());
    }

    public List<e6.a> b(byte[] bArr, int i10) {
        int i11;
        int i12;
        SparseArray<f> sparseArray;
        u uVar = new u(bArr, i10);
        while (uVar.b() >= 48 && uVar.h(8) == 15) {
            q(uVar, this.f22176f);
        }
        g gVar = this.f22176f;
        c cVar = gVar.f22220i;
        if (cVar == null) {
            return Collections.emptyList();
        }
        b bVar = gVar.f22219h;
        if (bVar == null) {
            bVar = this.f22174d;
        }
        Bitmap bitmap = this.f22177g;
        if (bitmap == null || bVar.f22183a + 1 != bitmap.getWidth() || bVar.f22184b + 1 != this.f22177g.getHeight()) {
            Bitmap createBitmap = Bitmap.createBitmap(bVar.f22183a + 1, bVar.f22184b + 1, Bitmap.Config.ARGB_8888);
            this.f22177g = createBitmap;
            this.f22173c.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<d> sparseArray2 = cVar.f22192d;
        for (int i13 = 0; i13 < sparseArray2.size(); i13++) {
            this.f22173c.save();
            d valueAt = sparseArray2.valueAt(i13);
            e eVar = this.f22176f.f22214c.get(sparseArray2.keyAt(i13));
            int i14 = valueAt.f22193a + bVar.f22185c;
            int i15 = valueAt.f22194b + bVar.f22187e;
            this.f22173c.clipRect(i14, i15, Math.min(eVar.f22197c + i14, bVar.f22186d), Math.min(eVar.f22198d + i15, bVar.f22188f));
            a aVar = this.f22176f.f22215d.get(eVar.f22201g);
            if (aVar == null && (aVar = this.f22176f.f22217f.get(eVar.f22201g)) == null) {
                aVar = this.f22175e;
            }
            SparseArray<f> sparseArray3 = eVar.f22205k;
            int i16 = 0;
            while (i16 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i16);
                f valueAt2 = sparseArray3.valueAt(i16);
                ObjectData objectData = this.f22176f.f22216e.get(keyAt);
                ObjectData objectData2 = objectData == null ? this.f22176f.f22218g.get(keyAt) : objectData;
                if (objectData2 != null) {
                    i12 = i16;
                    sparseArray = sparseArray3;
                    k(objectData2, aVar, eVar.f22200f, valueAt2.f22208c + i14, i15 + valueAt2.f22209d, objectData2.nonModifyingColorFlag ? null : this.f22171a, this.f22173c);
                } else {
                    i12 = i16;
                    sparseArray = sparseArray3;
                }
                i16 = i12 + 1;
                sparseArray3 = sparseArray;
            }
            if (eVar.f22196b) {
                int i17 = eVar.f22200f;
                if (i17 == 3) {
                    i11 = aVar.f22182d[eVar.f22202h];
                } else if (i17 == 2) {
                    i11 = aVar.f22181c[eVar.f22203i];
                } else {
                    i11 = aVar.f22180b[eVar.f22204j];
                }
                this.f22172b.setColor(i11);
                this.f22173c.drawRect(i14, i15, eVar.f22197c + i14, eVar.f22198d + i15, this.f22172b);
            }
            arrayList.add(new a.b().f(Bitmap.createBitmap(this.f22177g, i14, i15, eVar.f22197c, eVar.f22198d)).k(i14 / bVar.f22183a).l(0).h(i15 / bVar.f22184b, 0).i(0).n(eVar.f22197c / bVar.f22183a).g(eVar.f22198d / bVar.f22184b).a());
            this.f22173c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f22173c.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.f22176f.a();
    }
}
