package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: DecodeMultiCodes.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m1 {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f31252a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f31253b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f31254c;

    /* renamed from: d, reason: collision with root package name */
    private static int f31255d;

    /* renamed from: e, reason: collision with root package name */
    private static LinkedList<i2> f31256e = new LinkedList<>();

    /* renamed from: f, reason: collision with root package name */
    private static LinkedList<c6> f31257f = new LinkedList<>();

    /* renamed from: g, reason: collision with root package name */
    private static LinkedList<c6> f31258g = new LinkedList<>();

    /* renamed from: h, reason: collision with root package name */
    private static boolean f31259h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f31260i;

    /* renamed from: j, reason: collision with root package name */
    private static long f31261j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f31262k;

    static {
        f31259h = !r3.f31446a || r3.f31448c;
        f31260i = false;
        f31262k = false;
        if (DynamicModuleInitializer.getContext() != null) {
            y4.c(DynamicModuleInitializer.getContext(), "detect.ms");
            y4.a(DynamicModuleInitializer.getContext(), "angle.ms");
            y4.b(DynamicModuleInitializer.getContext(), "corner.ms");
        }
    }

    public static s6 a(List<BarcodeFormat> list, n1 n1Var) {
        if (list.size() > 0) {
            return n1Var.e(list, null);
        }
        return null;
    }

    public static s6[] b(Bitmap bitmap, x6 x6Var) {
        byte[] bArr = null;
        try {
            x6Var.f31722a = bitmap.getWidth();
            x6Var.f31723b = bitmap.getHeight();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(allocate);
            allocate.flip();
            bArr = new m6(x6Var.f31722a, x6Var.f31723b, allocate).b();
            allocate.clear();
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
        } catch (Exception unused2) {
            o4.b("exception", "Exception");
        } catch (OutOfMemoryError unused3) {
            o4.b("exception", "OutOfMemoryError");
        } catch (UnsatisfiedLinkError unused4) {
            o4.b("exception", "UnsatisfiedLinkError");
        } catch (UnsupportedOperationException unused5) {
            o4.b("exception", "UnsupportedArgumentException");
        }
        return c(bArr, x6Var);
    }

    public static s6[] c(byte[] bArr, x6 x6Var) {
        s6[] s6VarArr = new s6[0];
        try {
            return a(bArr, x6Var, true);
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
            return s6VarArr;
        } catch (UnsatisfiedLinkError unused2) {
            o4.b("exception", "UnsatisfiedLinkError");
            return s6VarArr;
        } catch (UnsupportedOperationException unused3) {
            o4.b("exception", "UnsupportedArgumentException");
            return s6VarArr;
        } catch (Exception unused4) {
            o4.b("exception", "Exception");
            return s6VarArr;
        } catch (OutOfMemoryError unused5) {
            o4.b("exception", "OutOfMemoryError");
            return s6VarArr;
        }
    }

    public static s6[] a(Bitmap bitmap, x6 x6Var) {
        o4.b("scankit mul", "start decodeMultiCode pre");
        byte[] bArr = null;
        try {
            x6Var.f31722a = bitmap.getWidth();
            x6Var.f31723b = bitmap.getHeight();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(allocate);
            allocate.flip();
            bArr = new m6(x6Var.f31722a, x6Var.f31723b, allocate).b();
            allocate.clear();
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
        } catch (UnsupportedOperationException unused2) {
            o4.b("exception", "UnsupportedArgumentException");
        } catch (Exception unused3) {
            o4.b("exception", "Exception");
        } catch (OutOfMemoryError unused4) {
            o4.b("exception", "OutOfMemoryError");
        } catch (UnsatisfiedLinkError unused5) {
            o4.b("exception", "UnsatisfiedLinkError");
        }
        o4.b("scankit mul", "end decodeMultiCode pre");
        return b(bArr, x6Var);
    }

    public static s6[] b(p4 p4Var, x6 x6Var) {
        s6 s6Var;
        s6 s6Var2;
        float f10;
        boolean z10;
        boolean z11;
        int i10;
        o4.d("ScankitDecode", "scankit mode:FULLSDK21200300 VERSION_NAME: 2.12.0.300");
        r3.a(x6Var);
        List<i2> arrayList = new ArrayList<>();
        if (x6Var.f31722a >= 30 && x6Var.f31723b >= 30 && p4Var != null) {
            List<List<BarcodeFormat>> a10 = n3.a(x6Var.f31724c);
            List<BarcodeFormat> list = a10.get(0);
            List<BarcodeFormat> list2 = a10.get(1);
            List<BarcodeFormat> list3 = a10.get(2);
            List<BarcodeFormat> list4 = a10.get(3);
            List<BarcodeFormat> list5 = a10.get(4);
            n1 n1Var = new n1(p4Var);
            o4.d("Scankit", "Start decoding the full image");
            s6 s6Var3 = null;
            if (!f31252a || f31254c) {
                s6Var = null;
            } else {
                s6Var = a(list, n1Var);
                f31260i = false;
                f31261j = System.currentTimeMillis();
            }
            if (a(s6Var)) {
                o4.d("Scankit", "detection start.");
                arrayList = n1Var.a(0, r3.f31462q);
                o4.d("Scankit", "detection results size: " + arrayList.size());
                if (arrayList.size() > 0) {
                    o4.d("Scankit", "Start decoding  with detection");
                    s6Var = b(arrayList, n1Var, a10);
                    f31260i = true;
                } else {
                    o4.d("Scankit", "Start decoding  without detection");
                    if (r3.f31448c || !r3.f31446a || r3.f31447b) {
                        if (a(s6Var) && list3.size() > 0) {
                            s6Var = n1Var.d(list3, null);
                        }
                        if (a(s6Var) && list2.size() > 0 && f31259h) {
                            s6Var = n1Var.a(list2, (i2) null);
                        }
                        if (a(s6Var) && list5.size() > 0) {
                            s6Var = n1Var.b(list5, (i2) null);
                        }
                        if (a(s6Var) && list4.size() > 0) {
                            s6Var = n1Var.b(list4, (i2) null);
                        }
                    }
                }
            }
            o4.d("Scankit", "Decoding completed");
            boolean z12 = (f31252a || !f31253b || f31254c) ? false : true;
            if (x6Var.f31726e && a(s6Var) && z12) {
                s6Var = a(list, n1Var);
                f31253b = false;
            }
            if (r3.f31448c) {
                s6Var2 = null;
                f10 = 1.0f;
                z10 = false;
                z11 = false;
            } else {
                boolean b4 = n1Var.b();
                int i11 = r3.f31456k - 1;
                if (i11 <= 0) {
                    i11 = 0;
                }
                r3.f31456k = i11;
                if (arrayList.size() > 0) {
                    b4 = b4 || n1Var.b(arrayList);
                }
                if (b4 && n1Var.c(n1Var.a()) < 20.0f) {
                    b4 = false;
                }
                if (n1Var.e() > 0.0f) {
                    f10 = Math.max(1.0f, n1Var.e());
                } else {
                    f10 = Math.max(1.0f, Math.max(n1Var.c(), n1Var.d()));
                }
                s6 a11 = n1.a(arrayList, n1Var);
                s6 a12 = n1.a(n1Var);
                z11 = arrayList.size() > 0 ? n1.a(arrayList, b4) : false;
                z10 = b4;
                s6Var2 = a11;
                s6Var3 = a12;
            }
            if (s6Var3 != null && s6Var3.h() == -2) {
                f31255d++;
                i10 = 0;
            } else {
                i10 = 0;
                f31255d = 0;
            }
            o4.d("Scankit", "end zoom and expose cal");
            if (s6Var != null && s6Var.k() != null) {
                o4.d("ScankitDecode", "ScanCode successful");
                f31255d = i10;
                s6Var.b(f31261j);
                s6Var.a(System.currentTimeMillis());
                s6Var.a(f31260i);
                s6[] s6VarArr = new s6[1];
                s6VarArr[i10] = s6Var;
                return s6VarArr;
            }
            if (z10) {
                o4.d("ScankitDecode", "ScanCode need zoom");
                s6 s6Var4 = new s6(f10);
                s6Var4.c(true);
                f31255d = i10;
                s6[] s6VarArr2 = new s6[1];
                s6VarArr2[i10] = s6Var4;
                return s6VarArr2;
            }
            if (arrayList.size() > 0 && s6Var2 != null) {
                o4.d("ScankitDecode", "ScanCode need exposure");
                f31255d = i10;
                s6[] s6VarArr3 = new s6[1];
                s6VarArr3[i10] = s6Var2;
                return s6VarArr3;
            }
            if (s6Var3 != null && f31255d == 3) {
                s6Var3.b(true);
                s6Var3.a(-1);
                o4.d("ScankitDecode", "ScanCode need globalexposure");
                f31255d = 0;
                return new s6[]{s6Var3};
            }
            if (z11) {
                s6 s6Var5 = new s6(1.0f, true);
                float[] fArr = r3.f31470y;
                s6Var5.a(new i2(false, fArr[0], fArr[1], fArr[2] - fArr[0], fArr[3] - fArr[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
                return new s6[]{s6Var5};
            }
            o4.d("ScankitDecode", "ScanCode null");
            return new s6[0];
        }
        throw new IllegalArgumentException("widthOrHeight is Illeagle");
    }

    public static s6[] a(ByteBuffer byteBuffer, x6 x6Var) {
        return b(byteBuffer.array(), x6Var);
    }

    public static s6[] a(p4 p4Var, x6 x6Var) {
        s6 a10;
        boolean z10;
        List arrayList = new ArrayList();
        r3.a(x6Var);
        r3.a(1);
        if (x6Var.f31722a >= 30 && x6Var.f31723b >= 30 && p4Var != null) {
            List<List<BarcodeFormat>> a11 = n3.a(x6Var.f31724c);
            List<BarcodeFormat> list = a11.get(0);
            List<BarcodeFormat> list2 = a11.get(1);
            List<BarcodeFormat> list3 = a11.get(2);
            List<BarcodeFormat> list4 = a11.get(3);
            n1 n1Var = new n1(p4Var);
            o4.b("scankit mul", "start detectCodes");
            List<i2> a12 = n1Var.a(1, r3.f31462q);
            o4.b("scankit mul", "end detectCodes");
            if (a12.size() > 0) {
                arrayList = a(a12, n1Var, a11);
            } else if ((r3.f31448c || !r3.f31446a) && (a10 = a(n1Var, list, list2, list3, list4)) != null && a10.k() != null) {
                arrayList.add(a10);
            }
            List<s6> a13 = v7.a(arrayList);
            if (r3.f31452g && a13.size() > 0 && a13.get(0).k() != null) {
                return (s6[]) a13.toArray(new s6[0]);
            }
            float f10 = 1.0f;
            if (r3.f31448c || !r3.f31452g) {
                z10 = false;
            } else {
                if (a13.size() > 0) {
                    z10 = a13.get(0).p();
                    f10 = Math.max(1.0f, a13.get(0).l());
                } else {
                    z10 = false;
                }
                int i10 = r3.f31456k - 1;
                if (i10 <= 0) {
                    i10 = 0;
                }
                r3.f31456k = i10;
                if (a12.size() > 0) {
                    z10 = z10 || n1Var.c(a12);
                }
                if (z10 && n1Var.c(n1Var.a()) < 20.0f) {
                    z10 = false;
                }
                if (z10) {
                    f10 = Math.max(f10, n1Var.e());
                }
            }
            if (!r3.f31452g || !z10) {
                return a13.size() > 0 ? (s6[]) a13.toArray(new s6[0]) : new s6[0];
            }
            s6 s6Var = new s6(f10);
            s6Var.c(true);
            a13.clear();
            a13.add(s6Var);
            return (s6[]) a13.toArray(new s6[0]);
        }
        throw new IllegalArgumentException("width or Height is Illeagle");
    }

    private static s6 a(n1 n1Var, List<BarcodeFormat> list, List<BarcodeFormat> list2, List<BarcodeFormat> list3, List<BarcodeFormat> list4) {
        s6 f10 = list.size() > 0 ? n1Var.f(list, null) : null;
        if (a(f10) && list3.size() > 0) {
            f10 = n1Var.d(list3, null);
        }
        if (a(f10) && list2.size() > 0 && f31259h) {
            f10 = n1Var.a(list2, (i2) null);
        }
        return (!a(f10) || list4.size() <= 0) ? f10 : n1Var.b(list4, (i2) null);
    }

    public static List<s6> a(List<i2> list, n1 n1Var, List<List<BarcodeFormat>> list2) {
        s6 g3;
        float max;
        List<BarcodeFormat> list3 = list2.get(0);
        List<BarcodeFormat> list4 = list2.get(1);
        List<BarcodeFormat> list5 = list2.get(2);
        List<BarcodeFormat> list6 = list2.get(3);
        List<BarcodeFormat> list7 = list2.get(4);
        List<BarcodeFormat> list8 = list2.get(5);
        List<BarcodeFormat> list9 = list2.get(6);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            n1Var.f31303i.a();
            i2 i2Var = list.get(i10);
            boolean z10 = i2Var.g() == 5.0f;
            boolean z11 = i2Var.g() == 1.0f;
            boolean z12 = i2Var.g() == 3.0f;
            boolean z13 = i2Var.g() == 2.0f;
            boolean z14 = i2Var.g() == 4.0f;
            boolean z15 = i2Var.g() == 6.0f;
            boolean z16 = i2Var.g() == 7.0f;
            if (r3.f31447b) {
                z10 = i2Var.g() == 1.0f;
                z11 = i2Var.g() == 2.0f;
                z12 = i2Var.g() == 2.0f;
                z14 = i2Var.g() == 1.0f;
                z13 = i2Var.g() == 2.0f;
            }
            o4.d("scankit mul", "start cropAndRotate");
            n1Var.b(i2Var);
            o4.d("scankit mul", "end cropAndRotate");
            o4.d("scankit mul", "start decode");
            s6 e2 = (a((s6) null) && list3.size() > 0 && z11) ? n1Var.e(list3, i2Var) : null;
            if (a(e2) && list6.size() > 0 && z12) {
                e2 = n1Var.b(list6, i2Var);
            }
            if (a(e2) && list5.size() > 0 && z14) {
                e2 = n1Var.d(list5, i2Var);
            }
            if (a(e2) && list7.size() > 0 && z13) {
                e2 = n1Var.b(list7, i2Var);
            }
            if (a(e2) && list4.size() > 0 && z10) {
                e2 = n1Var.a(list4, i2Var);
            }
            if (a(e2) && list8.size() > 0 && z16) {
                e2 = n1Var.c(list8, i2Var);
            }
            s6 s6Var = (!(a(e2) && list9.size() > 0 && z15 && ((((double) i2Var.h()) > 0.6d ? 1 : (((double) i2Var.h()) == 0.6d ? 0 : -1)) > 0 || r3.f31448c)) || (e2 = n1Var.h(list9, i2Var)) == null || n1.b(n1Var.a(), i2Var)) ? e2 : null;
            if (r3.f31452g && s6Var != null && n1Var.b()) {
                if (n1Var.e() > 0.0f) {
                    max = Math.max(1.0f, n1Var.e());
                } else {
                    max = Math.max(1.0f, Math.max(n1Var.c(), n1Var.d()));
                }
                s6 s6Var2 = new s6(max);
                s6Var2.c(true);
                arrayList.add(s6Var2);
            } else if (s6Var != null && s6Var.k() != null) {
                arrayList.add(s6Var);
            }
        }
        if (arrayList.size() == 0 && list3.size() > 0 && !r3.f31452g && (g3 = n1Var.g(list3, null)) != null && g3.k() != null) {
            arrayList.add(g3);
        }
        o4.d("scankit mul", "end decode");
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x0191  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.scankit.p.s6 b(java.util.List<com.huawei.hms.scankit.p.i2> r25, com.huawei.hms.scankit.p.n1 r26, java.util.List<java.util.List<com.huawei.hms.scankit.aiscan.common.BarcodeFormat>> r27) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.m1.b(java.util.List, com.huawei.hms.scankit.p.n1, java.util.List):com.huawei.hms.scankit.p.s6");
    }

    private static p4 a(byte[] bArr, x6 x6Var) {
        int i10 = x6Var.f31722a;
        int i11 = x6Var.f31723b;
        if (x6Var.f31725d) {
            float f10 = 0.0f;
            int i12 = i10 * i11;
            byte[] bArr2 = new byte[i12];
            for (int i13 = 0; i13 < i11; i13++) {
                for (int i14 = 0; i14 < i10; i14++) {
                    f10 += bArr[r9] & 255;
                    bArr2[(((i14 * i11) + i11) - i13) - 1] = bArr[(i13 * i10) + i14];
                }
            }
            float f11 = f10 / i12;
            if (f11 < 25.0f) {
                r3.f31450e = true;
            } else if (f11 > 215.0f) {
                r3.f31449d = true;
            }
            x6Var.f31722a = i11;
            x6Var.f31723b = i10;
            return new e6(bArr2, i11, i10, 0, 0, i11, i10, false);
        }
        return new e6(bArr, i10, i11, 0, 0, i10, i11, false);
    }

    public static s6[] b(byte[] bArr, x6 x6Var) {
        s6[] a10;
        o4.b("scankit mul", "start decodeMultiCode");
        s6[] s6VarArr = new s6[0];
        try {
            a10 = a(bArr, x6Var, false);
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
        } catch (Exception unused2) {
            o4.b("exception", "Exception");
        } catch (OutOfMemoryError unused3) {
            o4.b("exception", "OutOfMemoryError");
        } catch (UnsatisfiedLinkError unused4) {
            o4.b("exception", "UnsatisfiedLinkError");
        } catch (UnsupportedOperationException unused5) {
            o4.b("exception", "UnsupportedArgumentException");
        }
        if (r3.f31452g && a10.length > 0 && a10[0].p()) {
            return a10;
        }
        int length = a10.length;
        int[] iArr = new int[length];
        int i10 = 0;
        int i11 = 0;
        while (i10 < a10.length) {
            int i12 = i10 + 1;
            for (int i13 = i12; i13 < a10.length; i13++) {
                if (v7.a(a10[i10].j(), a10[i13].j()) > 0.7d) {
                    iArr[i13] = 1;
                    i11++;
                }
            }
            i10 = i12;
        }
        int length2 = a10.length - i11;
        s6VarArr = new s6[length2];
        for (int i14 = 0; i14 < length2; i14++) {
            int i15 = i14;
            while (i15 < length) {
                if (iArr[i15] != 1) {
                    break;
                }
                i15++;
            }
            s6VarArr[i14] = a10[i15];
        }
        o4.b("scankit mul", "end decodeMultiCode");
        return s6VarArr;
    }

    public static void a(boolean z10) {
        r3.f31446a = z10;
    }

    private static void a() {
        f31254c = false;
        f31256e = new LinkedList<>();
        f31257f = new LinkedList<>();
        f31258g = new LinkedList<>();
        r3.f31449d = false;
        r3.f31450e = false;
    }

    public static s6[] a(byte[] bArr, x6 x6Var, boolean z10) {
        int i10;
        int i11;
        o4.d("scankit mul", "start pre");
        LinkedList linkedList = new LinkedList();
        a();
        int min = Math.min(x6Var.f31722a, x6Var.f31723b);
        float f10 = min;
        float max = Math.max(x6Var.f31722a, x6Var.f31723b) / f10;
        int i12 = (int) (f10 * 1.78f);
        p4 a10 = a(bArr, x6Var);
        o4.d("Scankit", "init " + f31262k);
        if ((r3.f31449d || r3.f31450e) && f31262k) {
            return new s6[0];
        }
        f31262k = true;
        x6 x6Var2 = new x6(x6Var);
        o4.d("scankit mul", "end pre");
        if (min > 500 && x6Var.f31722a >= x6Var.f31723b && x6Var.f31726e && max > 3.0f) {
            f31254c = true;
            x6Var2.f31722a = i12;
            int i13 = x6Var.f31722a - 1;
            while (i13 >= 0) {
                i13 -= i12;
                int i14 = i13 >= 0 ? i13 : 0;
                x6Var2.f31729h = i14;
                x6Var2.f31730i = 0;
                a(a10, i14, 0, x6Var2);
            }
            Collections.sort(f31256e);
            s6 a11 = a(a10, x6Var2, linkedList, z10, true, i12);
            if (a11 != null) {
                return new s6[]{a11};
            }
            f31256e = new LinkedList<>();
            Collections.sort(f31257f);
            HashSet hashSet = new HashSet();
            Iterator<c6> it = f31257f.iterator2();
            while (it.hasNext()) {
                c6 next = it.next();
                if (hashSet.add(Integer.valueOf(next.f30805b)) && (i11 = next.f30805b) >= i12 && i11 <= (x6Var.f31722a - 1) - i12) {
                    x6Var2.f31722a = i12;
                    x6Var2.f31731j = true;
                    int i15 = i11 - (i12 / 2);
                    x6Var2.f31729h = i15;
                    x6Var2.f31730i = 0;
                    a(a10, i15, 0, x6Var2);
                }
            }
            Collections.sort(f31256e);
            s6 a12 = a(a10, x6Var2, linkedList, z10, true, i12);
            if (a12 != null) {
                return new s6[]{a12};
            }
        } else if (min > 500 && x6Var.f31726e && max > 3.0f) {
            f31254c = true;
            x6Var2.f31723b = i12;
            int i16 = x6Var.f31723b - 1;
            while (i16 >= 0) {
                i16 -= i12;
                int i17 = i16 >= 0 ? i16 : 0;
                x6Var2.f31729h = 0;
                x6Var2.f31730i = i17;
                a(a10, 0, i17, x6Var2);
            }
            Collections.sort(f31256e);
            s6 a13 = a(a10, x6Var, linkedList, z10, false, i12);
            if (a13 != null) {
                return new s6[]{a13};
            }
            f31256e = new LinkedList<>();
            Collections.sort(f31258g);
            HashSet hashSet2 = new HashSet();
            Iterator<c6> it2 = f31258g.iterator2();
            while (it2.hasNext()) {
                c6 next2 = it2.next();
                if (hashSet2.add(Integer.valueOf(next2.f30805b)) && (i10 = next2.f30805b) >= i12 && i10 <= (x6Var.f31723b - 1) - i12) {
                    int i18 = i10 - (i12 / 2);
                    x6Var2.f31723b = i12;
                    x6Var2.f31731j = true;
                    x6Var2.f31729h = 0;
                    x6Var2.f31730i = i18;
                    a(a10, 0, i18, x6Var2);
                }
            }
            Collections.sort(f31256e);
            s6 a14 = a(a10, x6Var, linkedList, z10, false, i12);
            if (a14 != null) {
                return new s6[]{a14};
            }
        } else {
            f31254c = false;
            if (z10) {
                return b(a10, x6Var);
            }
            return a(a10, x6Var);
        }
        s6[] s6VarArr = new s6[linkedList.size()];
        linkedList.toArray(s6VarArr);
        return s6VarArr;
    }

    private static void a(p4 p4Var, int i10, int i11, x6 x6Var) {
        r3.a(x6Var);
        byte[] b4 = p4Var.a(i10, i11, x6Var.f31722a, x6Var.f31723b).b();
        int i12 = x6Var.f31722a;
        int i13 = x6Var.f31723b;
        List<i2> a10 = new n1(new e6(b4, i12, i13, 0, 0, i12, i13, false)).a(0, r3.f31462q);
        if (!x6Var.f31731j) {
            a(a10, x6Var);
        }
        for (i2 i2Var : a10) {
            i2Var.a(x6Var.f31729h, x6Var.f31730i);
            f31256e.offer(i2Var);
        }
    }

    private static s6 a(p4 p4Var, x6 x6Var, LinkedList<s6> linkedList, boolean z10, boolean z11, int i10) {
        n1 n1Var = new n1(p4Var);
        List<List<BarcodeFormat>> a10 = n3.a(x6Var.f31724c);
        if (z10) {
            s6 b4 = b(f31256e, n1Var, a10);
            if (b4 == null || b4.k() == null) {
                return null;
            }
            return b4;
        }
        Iterator<s6> iterator2 = a(f31256e, n1Var, a10).iterator2();
        while (iterator2.hasNext()) {
            linkedList.offer(iterator2.next());
        }
        return null;
    }

    private static void a(List<i2> list, x6 x6Var) {
        for (i2 i2Var : list) {
            if (i2Var.d() < x6Var.f31722a * 0.1f) {
                f31257f.offer(new c6(i2Var, x6Var.f31729h));
            } else {
                float d10 = i2Var.d() + i2Var.f();
                int i10 = x6Var.f31722a;
                if (d10 > i10 * 0.9f) {
                    f31257f.offer(new c6(i2Var, x6Var.f31729h + i10));
                }
            }
            if (i2Var.e() < x6Var.f31723b * 0.1f) {
                f31258g.offer(new c6(i2Var, x6Var.f31730i));
            } else {
                float e2 = i2Var.e() + i2Var.c();
                int i11 = x6Var.f31723b;
                if (e2 > i11 * 0.9f) {
                    f31258g.offer(new c6(i2Var, x6Var.f31730i + i11));
                }
            }
        }
    }

    private static boolean a(s6 s6Var) {
        return s6Var == null || s6Var.k() == null;
    }
}
