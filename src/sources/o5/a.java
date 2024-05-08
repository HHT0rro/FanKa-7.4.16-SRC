package o5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import com.google.android.exoplayer2.util.u;
import com.google.common.base.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import n5.d;
import n5.f;

/* compiled from: AppInfoTableDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends f {
    @Nullable
    public static Metadata c(u uVar) {
        uVar.r(12);
        int d10 = (uVar.d() + uVar.h(12)) - 4;
        uVar.r(44);
        uVar.s(uVar.h(12));
        uVar.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str = null;
            if (uVar.d() >= d10) {
                break;
            }
            uVar.r(48);
            int h10 = uVar.h(8);
            uVar.r(4);
            int d11 = uVar.d() + uVar.h(12);
            String str2 = null;
            while (uVar.d() < d11) {
                int h11 = uVar.h(8);
                int h12 = uVar.h(8);
                int d12 = uVar.d() + h12;
                if (h11 == 2) {
                    int h13 = uVar.h(16);
                    uVar.r(8);
                    if (h13 != 3) {
                    }
                    while (uVar.d() < d12) {
                        str = uVar.l(uVar.h(8), c.f25959a);
                        int h14 = uVar.h(8);
                        for (int i10 = 0; i10 < h14; i10++) {
                            uVar.s(uVar.h(8));
                        }
                    }
                } else if (h11 == 21) {
                    str2 = uVar.l(h12, c.f25959a);
                }
                uVar.p(d12 * 8);
            }
            uVar.p(d11 * 8);
            if (str != null && str2 != null) {
                arrayList.add(new AppInfoTable(h10, str2.length() != 0 ? str.concat(str2) : new String(str)));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    @Override // n5.f
    @Nullable
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new u(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
