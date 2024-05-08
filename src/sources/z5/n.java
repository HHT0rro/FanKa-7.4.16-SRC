package z5;

import java.util.Locale;

/* compiled from: UrlTemplate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f54971a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f54972b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f54973c;

    /* renamed from: d, reason: collision with root package name */
    public final int f54974d;

    public n(String[] strArr, int[] iArr, String[] strArr2, int i10) {
        this.f54971a = strArr;
        this.f54972b = iArr;
        this.f54973c = strArr2;
        this.f54974d = i10;
    }

    public static n b(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new n(strArr, iArr, strArr2, c(str, strArr, iArr, strArr2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e0, code lost:
    
        switch(r6) {
            case 0: goto L57;
            case 1: goto L56;
            case 2: goto L55;
            default: goto L67;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00fb, code lost:
    
        r13[r3] = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0105, code lost:
    
        r14[r3] = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ff, code lost:
    
        r13[r3] = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0103, code lost:
    
        r13[r3] = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00eb, code lost:
    
        if (r11.length() == 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ed, code lost:
    
        r11 = "Invalid template: ".concat(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fa, code lost:
    
        throw new java.lang.IllegalArgumentException(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f2, code lost:
    
        r11 = new java.lang.String("Invalid template: ");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(java.lang.String r11, java.lang.String[] r12, int[] r13, java.lang.String[] r14) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.n.c(java.lang.String, java.lang.String[], int[], java.lang.String[]):int");
    }

    public String a(String str, long j10, int i10, long j11) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        while (true) {
            int i12 = this.f54974d;
            if (i11 < i12) {
                sb2.append(this.f54971a[i11]);
                int[] iArr = this.f54972b;
                if (iArr[i11] == 1) {
                    sb2.append(str);
                } else if (iArr[i11] == 2) {
                    sb2.append(String.format(Locale.US, this.f54973c[i11], Long.valueOf(j10)));
                } else if (iArr[i11] == 3) {
                    sb2.append(String.format(Locale.US, this.f54973c[i11], Integer.valueOf(i10)));
                } else if (iArr[i11] == 4) {
                    sb2.append(String.format(Locale.US, this.f54973c[i11], Long.valueOf(j11)));
                }
                i11++;
            } else {
                sb2.append(this.f54971a[i12]);
                return sb2.toString();
            }
        }
    }
}
