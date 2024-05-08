package ya;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f54693a;

    /* renamed from: b, reason: collision with root package name */
    public final int f54694b;

    /* renamed from: c, reason: collision with root package name */
    public int f54695c;

    /* renamed from: d, reason: collision with root package name */
    public int f54696d;

    /* renamed from: e, reason: collision with root package name */
    public int f54697e;

    /* renamed from: f, reason: collision with root package name */
    public int f54698f;

    /* renamed from: g, reason: collision with root package name */
    public char[] f54699g;

    public c(X500Principal x500Principal) {
        String name = x500Principal.getName(X500Principal.RFC2253);
        this.f54693a = name;
        this.f54694b = name.length();
    }

    public final int a(int i10) {
        int i11;
        int i12;
        int i13 = i10 + 1;
        if (i13 < this.f54694b) {
            char[] cArr = this.f54699g;
            char c4 = cArr[i10];
            if (c4 >= '0' && c4 <= '9') {
                i11 = c4 - '0';
            } else if (c4 >= 'a' && c4 <= 'f') {
                i11 = c4 - 'W';
            } else {
                if (c4 < 'A' || c4 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f54693a);
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
                    throw new IllegalStateException("Malformed DN: " + this.f54693a);
                }
                i12 = c10 - '7';
            }
            return (i11 << 4) + i12;
        }
        throw new IllegalStateException("Malformed DN: " + this.f54693a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a1, code lost:
    
        return new java.lang.String(r1, r2, r8.f54698f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b() {
        /*
            r8 = this;
            int r0 = r8.f54695c
            r8.f54696d = r0
            r8.f54697e = r0
        L6:
            int r0 = r8.f54695c
            int r1 = r8.f54694b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f54699g
            int r2 = r8.f54696d
            int r3 = r8.f54697e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f54699g
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
            int r2 = r8.f54697e
            int r3 = r2 + 1
            r8.f54697e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f54695c = r0
            goto L6
        L40:
            int r0 = r8.f54697e
            int r2 = r0 + 1
            r8.f54697e = r2
            char r2 = r8.c()
            r1[r0] = r2
            int r0 = r8.f54695c
            int r0 = r0 + 1
            r8.f54695c = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f54696d
            int r3 = r8.f54697e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5e:
            int r2 = r8.f54697e
            r8.f54698f = r2
            int r0 = r0 + 1
            r8.f54695c = r0
            int r0 = r2 + 1
            r8.f54697e = r0
            r1[r2] = r6
        L6c:
            int r0 = r8.f54695c
            int r1 = r8.f54694b
            if (r0 >= r1) goto L85
            char[] r2 = r8.f54699g
            char r7 = r2[r0]
            if (r7 != r6) goto L85
            int r1 = r8.f54697e
            int r7 = r1 + 1
            r8.f54697e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f54695c = r0
            goto L6c
        L85:
            if (r0 == r1) goto L95
            char[] r1 = r8.f54699g
            char r2 = r1[r0]
            if (r2 == r3) goto L95
            char r2 = r1[r0]
            if (r2 == r4) goto L95
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L95:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f54699g
            int r2 = r8.f54696d
            int r3 = r8.f54698f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.c.b():java.lang.String");
    }

    public final char c() {
        int i10 = this.f54695c + 1;
        this.f54695c = i10;
        if (i10 != this.f54694b) {
            char[] cArr = this.f54699g;
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
                                return e();
                        }
                }
            }
            return cArr[i10];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f54693a);
    }

    public List<String> d(String str) {
        String h10;
        this.f54695c = 0;
        this.f54696d = 0;
        this.f54697e = 0;
        this.f54698f = 0;
        this.f54699g = this.f54693a.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String g3 = g();
        if (g3 == null) {
            return emptyList;
        }
        do {
            int i10 = this.f54695c;
            if (i10 < this.f54694b) {
                char c4 = this.f54699g[i10];
                if (c4 == '\"') {
                    h10 = h();
                } else if (c4 != '#') {
                    h10 = (c4 == '+' || c4 == ',' || c4 == ';') ? "" : b();
                } else {
                    h10 = f();
                }
                if (str.equalsIgnoreCase(g3)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(h10);
                }
                int i11 = this.f54695c;
                if (i11 < this.f54694b) {
                    char[] cArr = this.f54699g;
                    if (cArr[i11] != ',' && cArr[i11] != ';' && cArr[i11] != '+') {
                        throw new IllegalStateException("Malformed DN: " + this.f54693a);
                    }
                    this.f54695c = i11 + 1;
                    g3 = g();
                }
            }
            return emptyList;
        } while (g3 != null);
        throw new IllegalStateException("Malformed DN: " + this.f54693a);
    }

    public final char e() {
        int i10;
        int i11;
        int a10 = a(this.f54695c);
        this.f54695c++;
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
            int i13 = this.f54695c + 1;
            this.f54695c = i13;
            if (i13 == this.f54694b || this.f54699g[i13] != '\\') {
                return '?';
            }
            int i14 = i13 + 1;
            this.f54695c = i14;
            int a11 = a(i14);
            this.f54695c++;
            if ((a11 & 192) != 128) {
                return '?';
            }
            i11 = (i11 << 6) + (a11 & 63);
        }
        return (char) i11;
    }

    public final String f() {
        int i10;
        int i11 = this.f54695c;
        if (i11 + 4 < this.f54694b) {
            this.f54696d = i11;
            this.f54695c = i11 + 1;
            while (true) {
                i10 = this.f54695c;
                if (i10 == this.f54694b) {
                    break;
                }
                char[] cArr = this.f54699g;
                if (cArr[i10] == '+' || cArr[i10] == ',' || cArr[i10] == ';') {
                    break;
                }
                if (cArr[i10] == ' ') {
                    this.f54697e = i10;
                    this.f54695c = i10 + 1;
                    while (true) {
                        int i12 = this.f54695c;
                        if (i12 >= this.f54694b || this.f54699g[i12] != ' ') {
                            break;
                        }
                        this.f54695c = i12 + 1;
                    }
                } else {
                    if (cArr[i10] >= 'A' && cArr[i10] <= 'F') {
                        cArr[i10] = (char) (cArr[i10] + ' ');
                    }
                    this.f54695c = i10 + 1;
                }
            }
            this.f54697e = i10;
            int i13 = this.f54697e;
            int i14 = this.f54696d;
            int i15 = i13 - i14;
            if (i15 >= 5 && (i15 & 1) != 0) {
                int i16 = i15 / 2;
                byte[] bArr = new byte[i16];
                int i17 = i14 + 1;
                for (int i18 = 0; i18 < i16; i18++) {
                    bArr[i18] = (byte) a(i17);
                    i17 += 2;
                }
                return new String(this.f54699g, this.f54696d, i15);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f54693a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f54693a);
    }

    public final String g() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        while (true) {
            i10 = this.f54695c;
            i11 = this.f54694b;
            if (i10 >= i11 || this.f54699g[i10] != ' ') {
                break;
            }
            this.f54695c = i10 + 1;
        }
        if (i10 == i11) {
            return null;
        }
        this.f54696d = i10;
        this.f54695c = i10 + 1;
        while (true) {
            i12 = this.f54695c;
            i13 = this.f54694b;
            if (i12 >= i13) {
                break;
            }
            char[] cArr = this.f54699g;
            if (cArr[i12] == '=' || cArr[i12] == ' ') {
                break;
            }
            this.f54695c = i12 + 1;
        }
        if (i12 < i13) {
            this.f54697e = i12;
            if (this.f54699g[i12] == ' ') {
                while (true) {
                    i14 = this.f54695c;
                    i15 = this.f54694b;
                    if (i14 >= i15) {
                        break;
                    }
                    char[] cArr2 = this.f54699g;
                    if (cArr2[i14] == '=' || cArr2[i14] != ' ') {
                        break;
                    }
                    this.f54695c = i14 + 1;
                }
                if (this.f54699g[i14] != '=' || i14 == i15) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f54693a);
                }
            }
            this.f54695c++;
            while (true) {
                int i16 = this.f54695c;
                if (i16 >= this.f54694b || this.f54699g[i16] != ' ') {
                    break;
                }
                this.f54695c = i16 + 1;
            }
            int i17 = this.f54697e;
            int i18 = this.f54696d;
            if (i17 - i18 > 4) {
                char[] cArr3 = this.f54699g;
                if (cArr3[i18 + 3] == '.' && (cArr3[i18] == 'O' || cArr3[i18] == 'o')) {
                    int i19 = i18 + 1;
                    if (cArr3[i19] == 'I' || cArr3[i19] == 'i') {
                        int i20 = i18 + 2;
                        if (cArr3[i20] == 'D' || cArr3[i20] == 'd') {
                            this.f54696d = i18 + 4;
                        }
                    }
                }
            }
            char[] cArr4 = this.f54699g;
            int i21 = this.f54696d;
            return new String(cArr4, i21, i17 - i21);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f54693a);
    }

    public final String h() {
        int i10 = this.f54695c + 1;
        this.f54695c = i10;
        this.f54696d = i10;
        this.f54697e = i10;
        while (true) {
            int i11 = this.f54695c;
            if (i11 != this.f54694b) {
                char[] cArr = this.f54699g;
                if (cArr[i11] == '\"') {
                    this.f54695c = i11 + 1;
                    while (true) {
                        int i12 = this.f54695c;
                        if (i12 >= this.f54694b || this.f54699g[i12] != ' ') {
                            break;
                        }
                        this.f54695c = i12 + 1;
                    }
                    char[] cArr2 = this.f54699g;
                    int i13 = this.f54696d;
                    return new String(cArr2, i13, this.f54697e - i13);
                }
                if (cArr[i11] == '\\') {
                    cArr[this.f54697e] = c();
                } else {
                    cArr[this.f54697e] = cArr[i11];
                }
                this.f54695c++;
                this.f54697e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f54693a);
            }
        }
    }
}
