package com.google.android.gms.internal.clearcut;

import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f3 {
    public static String a(zzbb zzbbVar) {
        String str;
        g3 g3Var = new g3(zzbbVar);
        StringBuilder sb2 = new StringBuilder(g3Var.size());
        for (int i10 = 0; i10 < g3Var.size(); i10++) {
            int a10 = g3Var.a(i10);
            if (a10 == 34) {
                str = "\\\"";
            } else if (a10 == 39) {
                str = "\\'";
            } else if (a10 != 92) {
                switch (a10) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (a10 < 32 || a10 > 126) {
                            sb2.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb2.append((char) (((a10 >>> 6) & 3) + 48));
                            sb2.append((char) (((a10 >>> 3) & 7) + 48));
                            a10 = (a10 & 7) + 48;
                        }
                        sb2.append((char) a10);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb2.append(str);
        }
        return sb2.toString();
    }
}
