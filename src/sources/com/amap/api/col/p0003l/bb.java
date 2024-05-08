package com.amap.api.col.p0003l;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: OfflineMapDataVerify.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bb extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private Context f5106a;

    /* renamed from: b, reason: collision with root package name */
    private bn f5107b;

    public bb(Context context) {
        this.f5106a = context;
        this.f5107b = bn.a(context);
    }

    private static bi a(File file) {
        String a10 = dx.a(file);
        bi biVar = new bi();
        biVar.b(a10);
        return biVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0086, code lost:
    
        if (r10 != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.util.ArrayList<java.lang.String> r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = r13.f5106a
            java.lang.String r1 = com.amap.api.col.p0003l.dx.a(r1)
            r0.append(r1)
            r0.append(r15)
            java.io.File r15 = new java.io.File
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            boolean r0 = r15.exists()
            if (r0 != 0) goto L21
            return
        L21:
            java.io.File[] r15 = r15.listFiles()
            if (r15 != 0) goto L28
            return
        L28:
            int r0 = r15.length
            r1 = 0
            r2 = 0
        L2b:
            if (r2 >= r0) goto L92
            r3 = r15[r2]
            boolean r4 = r3.isDirectory()
            if (r4 == 0) goto L8f
            java.lang.String r4 = r3.getName()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L8f
            java.lang.String[] r3 = r3.list()
            if (r3 == 0) goto L8f
            int r5 = r3.length
            if (r5 <= 0) goto L8f
            boolean r5 = r14.contains(r4)
            if (r5 != 0) goto L8f
            java.lang.String r5 = "a0"
            boolean r5 = r4.equals(r5)
            java.lang.String r6 = "m1.ans"
            r7 = 1
            if (r5 == 0) goto L69
            int r5 = r3.length
            r8 = 0
        L5b:
            if (r8 >= r5) goto L89
            r9 = r3[r8]
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto L66
            goto L8a
        L66:
            int r8 = r8 + 1
            goto L5b
        L69:
            int r5 = r3.length
            r8 = 0
            r9 = 0
            r10 = 0
        L6d:
            if (r8 >= r5) goto L84
            r11 = r3[r8]
            boolean r12 = r6.equals(r11)
            if (r12 == 0) goto L78
            r9 = 1
        L78:
            java.lang.String r12 = "m3.ans"
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L81
            r10 = 1
        L81:
            int r8 = r8 + 1
            goto L6d
        L84:
            if (r9 == 0) goto L89
            if (r10 == 0) goto L89
            goto L8a
        L89:
            r7 = 0
        L8a:
            if (r7 == 0) goto L8f
            r14.add(r4)
        L8f:
            int r2 = r2 + 1
            goto L2b
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.bb.b(java.util.ArrayList, java.lang.String):void");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() {
        bi a10;
        String b4;
        int indexOf;
        boolean z10;
        String b10;
        int indexOf2;
        String b11;
        int indexOf3;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<bi> a11 = this.f5107b.a();
        a(arrayList, "vmap/");
        a(arrayList, "map/");
        b(arrayList, "map/");
        ArrayList<String> b12 = b();
        Iterator<bi> iterator2 = a11.iterator2();
        while (iterator2.hasNext()) {
            bi next = iterator2.next();
            if (next != null && next.c() != null) {
                int i10 = next.f5143l;
                boolean z11 = true;
                if (i10 == 4 || i10 == 7) {
                    boolean contains = arrayList.contains(next.h());
                    if (contains || (b4 = bv.b(next.f())) == null || (indexOf = arrayList.indexOf(b4)) == -1) {
                        z11 = contains;
                    } else {
                        arrayList.set(indexOf, next.h());
                    }
                    if (!z11) {
                        this.f5107b.b(next);
                    }
                } else {
                    if (i10 != 0 && i10 != 1) {
                        if (i10 == 3 && next.g() != 0) {
                            z10 = b12.contains(next.e()) || b12.contains(next.h());
                            if (z10 || (b11 = bv.b(next.f())) == null || (indexOf3 = b12.indexOf(b11)) == -1) {
                                z11 = z10;
                            } else {
                                b12.set(indexOf3, next.h());
                            }
                            if (!z11) {
                                this.f5107b.b(next);
                            }
                        }
                    } else {
                        z10 = b12.contains(next.e()) || b12.contains(next.h());
                        if (z10 || (b10 = bv.b(next.f())) == null || (indexOf2 = b12.indexOf(b10)) == -1) {
                            z11 = z10;
                        } else {
                            b12.set(indexOf2, next.h());
                        }
                        if (!z11) {
                            this.f5107b.b(next);
                        }
                    }
                }
            }
        }
        Iterator<String> iterator22 = arrayList.iterator2();
        while (iterator22.hasNext()) {
            String next2 = iterator22.next();
            if (!a(next2, a11) && (a10 = a(next2)) != null) {
                this.f5107b.a(a10);
            }
        }
        ay a12 = ay.a(this.f5106a);
        if (a12 != null) {
            a12.b();
        }
    }

    private ArrayList<String> b() {
        File[] listFiles;
        String name;
        int lastIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(dx.c(this.f5106a));
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return arrayList;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(".zip") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                arrayList.add(name.substring(0, lastIndexOf));
            }
        }
        return arrayList;
    }

    private bi a(String str) {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        ay a10 = ay.a(this.f5106a);
        bi biVar = null;
        if (a10 != null) {
            String g3 = a10.g(str);
            File[] listFiles = new File(dx.c(this.f5106a)).listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file : listFiles) {
                if ((file.getName().contains(g3) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) {
                    biVar = a(file);
                    if (biVar.c() != null) {
                        return biVar;
                    }
                }
            }
        }
        return biVar;
    }

    private static boolean a(String str, ArrayList<bi> arrayList) {
        Iterator<bi> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            if (str.equals(iterator2.next().h())) {
                return true;
            }
        }
        return false;
    }

    private void a(ArrayList<String> arrayList, String str) {
        File[] listFiles;
        String name;
        int lastIndexOf;
        File file = new File(dx.b(this.f5106a) + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".dat") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                    String substring = name.substring(0, lastIndexOf);
                    if (!arrayList.contains(substring)) {
                        arrayList.add(substring);
                    }
                }
            }
        }
    }
}
