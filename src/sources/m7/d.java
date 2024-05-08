package m7;

import com.google.android.gms.phenotype.zzi;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements Comparator<zzi> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzi zziVar, zzi zziVar2) {
        zzi zziVar3 = zziVar;
        zzi zziVar4 = zziVar2;
        int i10 = zziVar3.f25809i;
        int i11 = zziVar4.f25809i;
        return i10 == i11 ? zziVar3.f25802b.compareTo(zziVar4.f25802b) : i10 - i11;
    }
}
