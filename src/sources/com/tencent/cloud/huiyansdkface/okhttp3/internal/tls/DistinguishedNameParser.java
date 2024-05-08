package com.tencent.cloud.huiyansdkface.okhttp3.internal.tls;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class DistinguishedNameParser {

    /* renamed from: a, reason: collision with root package name */
    private final String f42015a;

    /* renamed from: b, reason: collision with root package name */
    private final int f42016b;

    /* renamed from: c, reason: collision with root package name */
    private int f42017c;

    /* renamed from: d, reason: collision with root package name */
    private int f42018d;

    /* renamed from: e, reason: collision with root package name */
    private int f42019e;

    /* renamed from: f, reason: collision with root package name */
    private int f42020f;

    /* renamed from: g, reason: collision with root package name */
    private char[] f42021g;

    private int a(int i10) {
        int i11;
        int i12;
        int i13 = i10 + 1;
        if (i13 >= this.f42016b) {
            throw new IllegalStateException("Malformed DN: " + this.f42015a);
        }
        char[] cArr = this.f42021g;
        char c4 = cArr[i10];
        if (c4 >= '0' && c4 <= '9') {
            i11 = c4 - '0';
        } else if (c4 >= 'a' && c4 <= 'f') {
            i11 = c4 - 'W';
        } else {
            if (c4 < 'A' || c4 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f42015a);
            }
            i11 = c4 - '7';
        }
        char c10 = cArr[i13];
        if (c10 >= '0' && c10 <= '9') {
            i12 = c10 - '0';
        } else if (c10 >= 'a' && c10 <= 'f') {
            i12 = c10 - 'W';
        } else {
            if (c10 < 'A' || c10 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f42015a);
            }
            i12 = c10 - '7';
        }
        return (i11 << 4) + i12;
    }

    private String a() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        char[] cArr;
        while (true) {
            i10 = this.f42017c;
            i11 = this.f42016b;
            if (i10 >= i11 || this.f42021g[i10] != ' ') {
                break;
            }
            this.f42017c = i10 + 1;
        }
        if (i10 == i11) {
            return null;
        }
        this.f42018d = i10;
        do {
            this.f42017c = i10 + 1;
            i10 = this.f42017c;
            i12 = this.f42016b;
            if (i10 >= i12) {
                break;
            }
            cArr = this.f42021g;
            if (cArr[i10] == '=') {
                break;
            }
        } while (cArr[i10] != ' ');
        if (i10 >= i12) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f42015a);
        }
        this.f42019e = i10;
        if (this.f42021g[i10] == ' ') {
            while (true) {
                i13 = this.f42017c;
                i14 = this.f42016b;
                if (i13 >= i14) {
                    break;
                }
                char[] cArr2 = this.f42021g;
                if (cArr2[i13] == '=' || cArr2[i13] != ' ') {
                    break;
                }
                this.f42017c = i13 + 1;
            }
            if (this.f42021g[i13] != '=' || i13 == i14) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f42015a);
            }
        }
        int i15 = this.f42017c;
        do {
            this.f42017c = i15 + 1;
            i15 = this.f42017c;
            if (i15 >= this.f42016b) {
                break;
            }
        } while (this.f42021g[i15] == ' ');
        int i16 = this.f42019e;
        int i17 = this.f42018d;
        if (i16 - i17 > 4) {
            char[] cArr3 = this.f42021g;
            if (cArr3[i17 + 3] == '.' && ((cArr3[i17] == 'O' || cArr3[i17] == 'o') && ((cArr3[i17 + 1] == 'I' || cArr3[i17 + 1] == 'i') && (cArr3[i17 + 2] == 'D' || cArr3[i17 + 2] == 'd')))) {
                this.f42018d = i17 + 4;
            }
        }
        char[] cArr4 = this.f42021g;
        int i18 = this.f42018d;
        return new String(cArr4, i18, i16 - i18);
    }

    private String b() {
        int i10 = this.f42017c + 1;
        this.f42017c = i10;
        this.f42018d = i10;
        while (true) {
            this.f42019e = i10;
            int i11 = this.f42017c;
            if (i11 == this.f42016b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f42015a);
            }
            char[] cArr = this.f42021g;
            if (cArr[i11] == '\"') {
                do {
                    this.f42017c = i11 + 1;
                    i11 = this.f42017c;
                    if (i11 >= this.f42016b) {
                        break;
                    }
                } while (this.f42021g[i11] == ' ');
                char[] cArr2 = this.f42021g;
                int i12 = this.f42018d;
                return new String(cArr2, i12, this.f42019e - i12);
            }
            if (cArr[i11] == '\\') {
                cArr[this.f42019e] = e();
            } else {
                cArr[this.f42019e] = cArr[i11];
            }
            this.f42017c++;
            i10 = this.f42019e + 1;
        }
    }

    private String c() {
        int i10 = this.f42017c;
        if (i10 + 4 >= this.f42016b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f42015a);
        }
        this.f42018d = i10;
        while (true) {
            this.f42017c = i10 + 1;
            i10 = this.f42017c;
            if (i10 == this.f42016b) {
                break;
            }
            char[] cArr = this.f42021g;
            if (cArr[i10] == '+' || cArr[i10] == ',' || cArr[i10] == ';') {
                break;
            }
            if (cArr[i10] == ' ') {
                this.f42019e = i10;
                do {
                    this.f42017c = i10 + 1;
                    i10 = this.f42017c;
                    if (i10 >= this.f42016b) {
                        break;
                    }
                } while (this.f42021g[i10] == ' ');
            } else if (cArr[i10] >= 'A' && cArr[i10] <= 'F') {
                cArr[i10] = (char) (cArr[i10] + ' ');
            }
        }
        this.f42019e = i10;
        int i11 = this.f42019e;
        int i12 = this.f42018d;
        int i13 = i11 - i12;
        if (i13 < 5 || (i13 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f42015a);
        }
        int i14 = i13 / 2;
        byte[] bArr = new byte[i14];
        int i15 = i12 + 1;
        for (int i16 = 0; i16 < i14; i16++) {
            bArr[i16] = (byte) a(i15);
            i15 += 2;
        }
        return new String(this.f42021g, this.f42018d, i13);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x009d, code lost:
    
        return new java.lang.String(r1, r2, r8.f42020f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d() {
        /*
            r8 = this;
            int r0 = r8.f42017c
            r8.f42018d = r0
            r8.f42019e = r0
        L6:
            int r0 = r8.f42017c
            int r1 = r8.f42016b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f42021g
            int r2 = r8.f42018d
            int r3 = r8.f42019e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f42021g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5a
            if (r2 == r5) goto L4f
            r5 = 92
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L4f
            if (r2 == r3) goto L4f
            int r2 = r8.f42019e
            int r3 = r2 + 1
            r8.f42019e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            goto L4a
        L3c:
            int r0 = r8.f42019e
            int r2 = r0 + 1
            r8.f42019e = r2
            char r2 = r8.e()
            r1[r0] = r2
            int r0 = r8.f42017c
        L4a:
            int r0 = r0 + 1
            r8.f42017c = r0
            goto L6
        L4f:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f42018d
            int r3 = r8.f42019e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5a:
            int r2 = r8.f42019e
            r8.f42020f = r2
            int r0 = r0 + 1
            r8.f42017c = r0
            int r0 = r2 + 1
            r8.f42019e = r0
            r1[r2] = r6
        L68:
            int r0 = r8.f42017c
            int r1 = r8.f42016b
            if (r0 >= r1) goto L81
            char[] r2 = r8.f42021g
            char r7 = r2[r0]
            if (r7 != r6) goto L81
            int r1 = r8.f42019e
            int r7 = r1 + 1
            r8.f42019e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f42017c = r0
            goto L68
        L81:
            if (r0 == r1) goto L91
            char[] r1 = r8.f42021g
            char r2 = r1[r0]
            if (r2 == r3) goto L91
            char r2 = r1[r0]
            if (r2 == r4) goto L91
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L91:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f42021g
            int r2 = r8.f42018d
            int r3 = r8.f42020f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.DistinguishedNameParser.d():java.lang.String");
    }

    private char e() {
        int i10 = this.f42017c + 1;
        this.f42017c = i10;
        if (i10 == this.f42016b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f42015a);
        }
        char[] cArr = this.f42021g;
        char c4 = cArr[i10];
        if (c4 != ' ' && c4 != '%' && c4 != '\\' && c4 != '_' && c4 != '\"' && c4 != '#') {
            switch (c4) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c4) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return f();
                    }
            }
        }
        return cArr[i10];
    }

    private char f() {
        int i10;
        int i11;
        int a10 = a(this.f42017c);
        this.f42017c++;
        if (a10 < 128) {
            return (char) a10;
        }
        if (a10 < 192 || a10 > 247) {
            return '?';
        }
        if (a10 <= 223) {
            i11 = a10 & 31;
            i10 = 1;
        } else if (a10 <= 239) {
            i10 = 2;
            i11 = a10 & 15;
        } else {
            i10 = 3;
            i11 = a10 & 7;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = this.f42017c + 1;
            this.f42017c = i13;
            if (i13 == this.f42016b || this.f42021g[i13] != '\\') {
                return '?';
            }
            int i14 = i13 + 1;
            this.f42017c = i14;
            int a11 = a(i14);
            this.f42017c++;
            if ((a11 & 192) != 128) {
                return '?';
            }
            i11 = (i11 << 6) + (a11 & 63);
        }
        return (char) i11;
    }

    public String findMostSpecific(String str) {
        this.f42017c = 0;
        this.f42018d = 0;
        this.f42019e = 0;
        this.f42020f = 0;
        this.f42021g = this.f42015a.toCharArray();
        String a10 = a();
        if (a10 == null) {
            return null;
        }
        do {
            int i10 = this.f42017c;
            if (i10 == this.f42016b) {
                return null;
            }
            char c4 = this.f42021g[i10];
            String d10 = c4 != '\"' ? c4 != '#' ? (c4 == '+' || c4 == ',' || c4 == ';') ? "" : d() : c() : b();
            if (str.equalsIgnoreCase(a10)) {
                return d10;
            }
            int i11 = this.f42017c;
            if (i11 >= this.f42016b) {
                return null;
            }
            char[] cArr = this.f42021g;
            if (cArr[i11] != ',' && cArr[i11] != ';' && cArr[i11] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f42015a);
            }
            this.f42017c = i11 + 1;
            a10 = a();
        } while (a10 != null);
        throw new IllegalStateException("Malformed DN: " + this.f42015a);
    }
}
