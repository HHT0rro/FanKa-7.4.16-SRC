package i6;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* compiled from: SsaDialogueFormat.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f49811a;

    /* renamed from: b, reason: collision with root package name */
    public final int f49812b;

    /* renamed from: c, reason: collision with root package name */
    public final int f49813c;

    /* renamed from: d, reason: collision with root package name */
    public final int f49814d;

    /* renamed from: e, reason: collision with root package name */
    public final int f49815e;

    public b(int i10, int i11, int i12, int i13, int i14) {
        this.f49811a = i10;
        this.f49812b = i11;
        this.f49813c = i12;
        this.f49814d = i13;
        this.f49815e = i14;
    }

    @Nullable
    public static b a(String str) {
        char c4;
        com.google.android.exoplayer2.util.a.a(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < split.length; i14++) {
            String e2 = com.google.common.base.a.e(split[i14].trim());
            e2.hashCode();
            switch (e2.hashCode()) {
                case 100571:
                    if (e2.equals("end")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 3556653:
                    if (e2.equals("text")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 109757538:
                    if (e2.equals("start")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 109780401:
                    if (e2.equals("style")) {
                        c4 = 3;
                        break;
                    }
                    break;
            }
            c4 = 65535;
            switch (c4) {
                case 0:
                    i11 = i14;
                    break;
                case 1:
                    i13 = i14;
                    break;
                case 2:
                    i10 = i14;
                    break;
                case 3:
                    i12 = i14;
                    break;
            }
        }
        if (i10 == -1 || i11 == -1 || i13 == -1) {
            return null;
        }
        return new b(i10, i11, i12, i13, split.length);
    }
}
