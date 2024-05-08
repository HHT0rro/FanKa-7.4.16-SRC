package com.huawei.hms.scankit.p;

import com.android.internal.accessibility.common.ShortcutConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextEncoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class g7 extends d0 {
    @Override // com.huawei.hms.scankit.p.d0
    public int a() {
        return 2;
    }

    @Override // com.huawei.hms.scankit.p.d0
    public int a(char c4, StringBuilder sb2) {
        if (c4 == ' ') {
            sb2.append((char) 3);
            return 1;
        }
        if (c4 >= '0' && c4 <= '9') {
            sb2.append((char) ((c4 - '0') + 4));
            return 1;
        }
        if (c4 >= 'a' && c4 <= 'z') {
            sb2.append((char) ((c4 - 'a') + 14));
            return 1;
        }
        if (c4 < ' ') {
            sb2.append((char) 0);
            sb2.append(c4);
            return 2;
        }
        if (c4 >= '!' && c4 <= '/') {
            sb2.append((char) 1);
            sb2.append((char) (c4 - '!'));
            return 2;
        }
        if (c4 >= ':' && c4 <= '@') {
            sb2.append((char) 1);
            sb2.append((char) ((c4 - ShortcutConstants.SERVICES_SEPARATOR) + 15));
            return 2;
        }
        if (c4 >= '[' && c4 <= '_') {
            sb2.append((char) 1);
            sb2.append((char) ((c4 - '[') + 22));
            return 2;
        }
        if (c4 == '`') {
            sb2.append((char) 2);
            sb2.append((char) (c4 - '`'));
            return 2;
        }
        if (c4 >= 'A' && c4 <= 'Z') {
            sb2.append((char) 2);
            sb2.append((char) ((c4 - 'A') + 1));
            return 2;
        }
        if (c4 >= '{' && c4 <= 127) {
            sb2.append((char) 2);
            sb2.append((char) ((c4 - '{') + 27));
            return 2;
        }
        sb2.append("\u0001\u001e");
        return a((char) (c4 - 128), sb2) + 2;
    }
}
