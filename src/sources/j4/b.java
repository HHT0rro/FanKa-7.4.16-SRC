package j4;

import android.text.TextUtils;

/* compiled from: WebPWriter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class b extends h4.a {
    public void f(int i10) {
        h(i10 - 1);
    }

    public void g(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 4) {
            b((byte) (str.charAt(0) & 255));
            b((byte) (str.charAt(1) & 255));
            b((byte) (str.charAt(2) & 255));
            b((byte) (str.charAt(3) & 255));
            return;
        }
        d(4);
    }

    public void h(int i10) {
        b((byte) (i10 & 255));
        b((byte) ((i10 >> 8) & 255));
        b((byte) ((i10 >> 16) & 255));
    }

    public void i(int i10) {
        b((byte) (i10 & 255));
        b((byte) ((i10 >> 8) & 255));
        b((byte) ((i10 >> 16) & 255));
        b((byte) ((i10 >> 24) & 255));
    }
}
