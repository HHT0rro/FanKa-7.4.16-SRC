package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.k3;
import com.google.android.gms.internal.vision.l3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class l3<MessageType extends l3<MessageType, BuilderType>, BuilderType extends k3<MessageType, BuilderType>> implements c6 {
    public int zza = 0;

    public static <T> void b(Iterable<T> iterable, List<? super T> list) {
        b5.d(iterable);
        if (iterable instanceof o5) {
            List<?> zzd = ((o5) iterable).zzd();
            o5 o5Var = (o5) list;
            int size = list.size();
            for (Object obj : zzd) {
                if (obj == null) {
                    int size2 = o5Var.size() - size;
                    StringBuilder sb2 = new StringBuilder(37);
                    sb2.append("Element at index ");
                    sb2.append(size2);
                    sb2.append(" is null.");
                    String sb3 = sb2.toString();
                    for (int size3 = o5Var.size() - 1; size3 >= size; size3--) {
                        o5Var.remove(size3);
                    }
                    throw new NullPointerException(sb3);
                }
                if (obj instanceof zzht) {
                    o5Var.e((zzht) obj);
                } else {
                    o5Var.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof n6) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t2 : iterable) {
            if (t2 == null) {
                int size5 = list.size() - size4;
                StringBuilder sb4 = new StringBuilder(37);
                sb4.append("Element at index ");
                sb4.append(size5);
                sb4.append(" is null.");
                String sb5 = sb4.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(sb5);
            }
            list.add(t2);
        }
    }

    public void c(int i10) {
        throw new UnsupportedOperationException();
    }

    public final byte[] d() {
        try {
            byte[] bArr = new byte[zzm()];
            zzii f10 = zzii.f(bArr);
            a(f10);
            f10.N();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 62 + "byte array".length());
            sb2.append("Serializing ");
            sb2.append(name);
            sb2.append(" to a ");
            sb2.append("byte array");
            sb2.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e2);
        }
    }

    public int e() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.vision.c6
    public final zzht zzg() {
        try {
            c4 zzc = zzht.zzc(zzm());
            a(zzc.b());
            return zzc.a();
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
