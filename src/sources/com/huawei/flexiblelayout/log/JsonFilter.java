package com.huawei.flexiblelayout.log;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonFilter {

    /* renamed from: a, reason: collision with root package name */
    private final int f28210a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final int f28211b = 1;

    /* renamed from: c, reason: collision with root package name */
    private final int f28212c = 2;

    /* renamed from: d, reason: collision with root package name */
    private final int f28213d = 3;

    /* renamed from: e, reason: collision with root package name */
    private final int f28214e = 4;

    /* renamed from: f, reason: collision with root package name */
    private final int f28215f = 5;

    /* renamed from: g, reason: collision with root package name */
    private final int f28216g = 6;

    /* renamed from: h, reason: collision with root package name */
    private final int f28217h = 7;

    /* renamed from: i, reason: collision with root package name */
    private final int f28218i = 8;

    /* renamed from: j, reason: collision with root package name */
    private final int f28219j = 9;

    /* renamed from: k, reason: collision with root package name */
    private List<String> f28220k = new ArrayList();

    private boolean a(char c4) {
        return c4 == '\"';
    }

    private boolean a(String str) {
        return this.f28220k.contains(str);
    }

    public void addMatchString(String str) {
        this.f28220k.add(str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x002c. Please report as an issue. */
    public String process(String str) {
        StringBuilder sb2 = new StringBuilder(str.length());
        StringBuilder sb3 = new StringBuilder();
        int i10 = 0;
        boolean z10 = false;
        char c4 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if (!z10) {
                sb2.append(charAt);
            }
            switch (c4) {
                case 0:
                    if (!a(charAt)) {
                        break;
                    } else {
                        c4 = 1;
                        break;
                    }
                case 1:
                    if (a(charAt)) {
                        z10 = a(sb3.toString());
                        sb3.setLength(0);
                        c4 = 2;
                        break;
                    } else {
                        sb3.append(charAt);
                        break;
                    }
                case 2:
                    if (charAt != ':') {
                        if (charAt != ',') {
                            break;
                        }
                        c4 = 0;
                        break;
                    } else {
                        c4 = 3;
                        break;
                    }
                case 3:
                    if (!z10) {
                        if (charAt != '{' && charAt != ',') {
                            if (!a(charAt)) {
                                break;
                            }
                            c4 = 4;
                        }
                        c4 = 0;
                        break;
                    } else if (charAt != '[') {
                        if (charAt != '{') {
                            if (!a(charAt)) {
                                if (!Character.isDigit(charAt)) {
                                    if (!Character.isLetter(charAt)) {
                                        break;
                                    } else {
                                        c4 = '\t';
                                        break;
                                    }
                                } else {
                                    c4 = 5;
                                    break;
                                }
                            }
                            c4 = 4;
                            break;
                        } else {
                            c4 = 7;
                            break;
                        }
                    } else {
                        c4 = 6;
                        break;
                    }
                case 4:
                    if (!a(charAt)) {
                        break;
                    } else {
                        if (str.charAt(i10 - 1) == '\\') {
                            break;
                        }
                        c4 = '\b';
                        break;
                    }
                case 5:
                    if (!Character.isDigit(charAt)) {
                        if (charAt == '.') {
                            break;
                        }
                        i10--;
                        c4 = '\b';
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (charAt != '[') {
                        if (charAt == ']') {
                            if (i11 != 0) {
                                i11--;
                                break;
                            }
                            c4 = '\b';
                            break;
                        } else {
                            break;
                        }
                    } else {
                        i11++;
                        break;
                    }
                case 7:
                    if (charAt != '{') {
                        if (charAt == '}') {
                            if (i12 != 0) {
                                i12--;
                                break;
                            }
                            c4 = '\b';
                            break;
                        } else {
                            break;
                        }
                    } else {
                        i12++;
                        break;
                    }
                case '\b':
                    if (z10) {
                        sb2.append(":\"[FILTERED]\"");
                        sb2.append(charAt);
                        z10 = false;
                    }
                    c4 = 0;
                    break;
                case '\t':
                    if (Character.isLetter(charAt)) {
                        break;
                    }
                    i10--;
                    c4 = '\b';
                    break;
            }
            i10++;
        }
        return sb2.toString();
    }
}
