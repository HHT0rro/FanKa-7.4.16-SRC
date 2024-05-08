package com.bytedance.sdk.openadsdk.api.plugin.dk;

import javax.security.auth.x500.X500Principal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class dk {
    private final int dk;
    private int ej;

    /* renamed from: hc, reason: collision with root package name */
    private char[] f11108hc;

    /* renamed from: l, reason: collision with root package name */
    private int f11109l;

    /* renamed from: m, reason: collision with root package name */
    private final String f11110m;

    /* renamed from: n, reason: collision with root package name */
    private int f11111n;
    private int np;

    public dk(X500Principal x500Principal) {
        String name = x500Principal.getName(X500Principal.RFC2253);
        this.f11110m = name;
        this.dk = name.length();
    }

    private String dk() {
        int i10 = this.ej + 1;
        this.ej = i10;
        this.f11109l = i10;
        this.np = i10;
        while (true) {
            int i11 = this.ej;
            if (i11 != this.dk) {
                char[] cArr = this.f11108hc;
                if (cArr[i11] == '\"') {
                    this.ej = i11 + 1;
                    while (true) {
                        int i12 = this.ej;
                        if (i12 >= this.dk || this.f11108hc[i12] != ' ') {
                            break;
                        }
                        this.ej = i12 + 1;
                    }
                    char[] cArr2 = this.f11108hc;
                    int i13 = this.f11109l;
                    return new String(cArr2, i13, this.np - i13);
                }
                if (cArr[i11] == '\\') {
                    cArr[this.np] = np();
                } else {
                    cArr[this.np] = cArr[i11];
                }
                this.ej++;
                this.np++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f11110m);
            }
        }
    }

    private String ej() {
        int i10;
        int i11 = this.ej;
        if (i11 + 4 < this.dk) {
            this.f11109l = i11;
            this.ej = i11 + 1;
            while (true) {
                i10 = this.ej;
                if (i10 == this.dk) {
                    break;
                }
                char[] cArr = this.f11108hc;
                if (cArr[i10] == '+' || cArr[i10] == ',' || cArr[i10] == ';') {
                    break;
                }
                if (cArr[i10] == ' ') {
                    this.np = i10;
                    this.ej = i10 + 1;
                    while (true) {
                        int i12 = this.ej;
                        if (i12 >= this.dk || this.f11108hc[i12] != ' ') {
                            break;
                        }
                        this.ej = i12 + 1;
                    }
                } else {
                    if (cArr[i10] >= 'A' && cArr[i10] <= 'F') {
                        cArr[i10] = (char) (cArr[i10] + ' ');
                    }
                    this.ej = i10 + 1;
                }
            }
            this.np = i10;
            int i13 = this.np;
            int i14 = this.f11109l;
            int i15 = i13 - i14;
            if (i15 >= 5 && (i15 & 1) != 0) {
                int i16 = i15 / 2;
                byte[] bArr = new byte[i16];
                int i17 = i14 + 1;
                for (int i18 = 0; i18 < i16; i18++) {
                    bArr[i18] = (byte) m(i17);
                    i17 += 2;
                }
                return new String(this.f11108hc, this.f11109l, i15);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f11110m);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f11110m);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a1, code lost:
    
        return new java.lang.String(r1, r2, r8.f11111n - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String l() {
        /*
            r8 = this;
            int r0 = r8.ej
            r8.f11109l = r0
            r8.np = r0
        L6:
            int r0 = r8.ej
            int r1 = r8.dk
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f11108hc
            int r2 = r8.f11109l
            int r3 = r8.np
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f11108hc
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5e
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.np
            int r3 = r2 + 1
            r8.np = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.ej = r0
            goto L6
        L40:
            int r0 = r8.np
            int r2 = r0 + 1
            r8.np = r2
            char r2 = r8.np()
            r1[r0] = r2
            int r0 = r8.ej
            int r0 = r0 + 1
            r8.ej = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f11109l
            int r3 = r8.np
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5e:
            int r2 = r8.np
            r8.f11111n = r2
            int r0 = r0 + 1
            r8.ej = r0
            int r0 = r2 + 1
            r8.np = r0
            r1[r2] = r6
        L6c:
            int r0 = r8.ej
            int r1 = r8.dk
            if (r0 >= r1) goto L85
            char[] r2 = r8.f11108hc
            char r7 = r2[r0]
            if (r7 != r6) goto L85
            int r1 = r8.np
            int r7 = r1 + 1
            r8.np = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.ej = r0
            goto L6c
        L85:
            if (r0 == r1) goto L95
            char[] r1 = r8.f11108hc
            char r2 = r1[r0]
            if (r2 == r3) goto L95
            char r2 = r1[r0]
            if (r2 == r4) goto L95
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L95:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f11108hc
            int r2 = r8.f11109l
            int r3 = r8.f11111n
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.dk.dk.l():java.lang.String");
    }

    private String m() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        while (true) {
            i10 = this.ej;
            i11 = this.dk;
            if (i10 >= i11 || this.f11108hc[i10] != ' ') {
                break;
            }
            this.ej = i10 + 1;
        }
        if (i10 == i11) {
            return null;
        }
        this.f11109l = i10;
        this.ej = i10 + 1;
        while (true) {
            i12 = this.ej;
            i13 = this.dk;
            if (i12 >= i13) {
                break;
            }
            char[] cArr = this.f11108hc;
            if (cArr[i12] == '=' || cArr[i12] == ' ') {
                break;
            }
            this.ej = i12 + 1;
        }
        if (i12 < i13) {
            this.np = i12;
            if (this.f11108hc[i12] == ' ') {
                while (true) {
                    i14 = this.ej;
                    i15 = this.dk;
                    if (i14 >= i15) {
                        break;
                    }
                    char[] cArr2 = this.f11108hc;
                    if (cArr2[i14] == '=' || cArr2[i14] != ' ') {
                        break;
                    }
                    this.ej = i14 + 1;
                }
                if (this.f11108hc[i14] != '=' || i14 == i15) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f11110m);
                }
            }
            this.ej++;
            while (true) {
                int i16 = this.ej;
                if (i16 >= this.dk || this.f11108hc[i16] != ' ') {
                    break;
                }
                this.ej = i16 + 1;
            }
            int i17 = this.np;
            int i18 = this.f11109l;
            if (i17 - i18 > 4) {
                char[] cArr3 = this.f11108hc;
                if (cArr3[i18 + 3] == '.' && ((cArr3[i18] == 'O' || cArr3[i18] == 'o') && ((cArr3[i18 + 1] == 'I' || cArr3[i18 + 1] == 'i') && (cArr3[i18 + 2] == 'D' || cArr3[i18 + 2] == 'd')))) {
                    this.f11109l = i18 + 4;
                }
            }
            char[] cArr4 = this.f11108hc;
            int i19 = this.f11109l;
            return new String(cArr4, i19, i17 - i19);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f11110m);
    }

    private char n() {
        int i10;
        int i11;
        int m10 = m(this.ej);
        this.ej++;
        if (m10 < 128) {
            return (char) m10;
        }
        if (m10 < 192 || m10 > 247) {
            return '?';
        }
        if (m10 <= 223) {
            i11 = m10 & 31;
            i10 = 1;
        } else if (m10 <= 239) {
            i10 = 2;
            i11 = m10 & 15;
        } else {
            i10 = 3;
            i11 = m10 & 7;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = this.ej + 1;
            this.ej = i13;
            if (i13 == this.dk || this.f11108hc[i13] != '\\') {
                return '?';
            }
            int i14 = i13 + 1;
            this.ej = i14;
            int m11 = m(i14);
            this.ej++;
            if ((m11 & 192) != 128) {
                return '?';
            }
            i11 = (i11 << 6) + (m11 & 63);
        }
        return (char) i11;
    }

    private char np() {
        int i10 = this.ej + 1;
        this.ej = i10;
        if (i10 != this.dk) {
            char[] cArr = this.f11108hc;
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
                                return n();
                        }
                }
            }
            return cArr[i10];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f11110m);
    }

    private int m(int i10) {
        int i11;
        int i12;
        int i13 = i10 + 1;
        if (i13 < this.dk) {
            char[] cArr = this.f11108hc;
            char c4 = cArr[i10];
            if (c4 >= '0' && c4 <= '9') {
                i11 = c4 - '0';
            } else if (c4 >= 'a' && c4 <= 'f') {
                i11 = c4 - 'W';
            } else {
                if (c4 < 'A' || c4 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f11110m);
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
                    throw new IllegalStateException("Malformed DN: " + this.f11110m);
                }
                i12 = c10 - '7';
            }
            return (i11 << 4) + i12;
        }
        throw new IllegalStateException("Malformed DN: " + this.f11110m);
    }

    public String m(String str) {
        String dk;
        this.ej = 0;
        this.f11109l = 0;
        this.np = 0;
        this.f11111n = 0;
        this.f11108hc = this.f11110m.toCharArray();
        String m10 = m();
        if (m10 == null) {
            return null;
        }
        do {
            int i10 = this.ej;
            if (i10 == this.dk) {
                return null;
            }
            char c4 = this.f11108hc[i10];
            if (c4 == '\"') {
                dk = dk();
            } else if (c4 != '#') {
                dk = (c4 == '+' || c4 == ',' || c4 == ';') ? "" : l();
            } else {
                dk = ej();
            }
            if (str.equalsIgnoreCase(m10)) {
                return dk;
            }
            int i11 = this.ej;
            if (i11 >= this.dk) {
                return null;
            }
            char[] cArr = this.f11108hc;
            if (cArr[i11] != ',' && cArr[i11] != ';' && cArr[i11] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f11110m);
            }
            this.ej = i11 + 1;
            m10 = m();
        } while (m10 != null);
        throw new IllegalStateException("Malformed DN: " + this.f11110m);
    }
}
