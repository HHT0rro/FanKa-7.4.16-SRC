package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.q;
import com.google.android.gms.internal.clearcut.r;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class q<MessageType extends q<MessageType, BuilderType>, BuilderType extends r<MessageType, BuilderType>> implements a2 {
    private static boolean zzey;
    public int zzex = 0;

    public void b(int i10) {
        throw new UnsupportedOperationException();
    }

    public int f() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.clearcut.a2
    public final zzbb zzr() {
        try {
            c0 zzk = zzbb.zzk(g());
            e(zzk.b());
            return zzk.a();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 62 + "ByteString".length());
            sb2.append("Serializing ");
            sb2.append(name);
            sb2.append(" to a ");
            sb2.append("ByteString");
            sb2.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e2);
        }
    }
}
