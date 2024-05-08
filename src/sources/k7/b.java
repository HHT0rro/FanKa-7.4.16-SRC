package k7;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.internal.phenotype.zzb;
import com.google.android.gms.internal.phenotype.zzc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends c<zzb> {
    public b(Context context, Looper looper, com.google.android.gms.common.internal.b bVar, GoogleApiClient.a aVar, GoogleApiClient.b bVar2) {
        super(context, looper, 51, bVar, aVar, bVar2);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.a.f
    public final int g() {
        return 11925000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface o(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.phenotype.internal.IPhenotypeService");
        return queryLocalInterface instanceof zzb ? (zzb) queryLocalInterface : new zzc(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String y() {
        return "com.google.android.gms.phenotype.internal.IPhenotypeService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String z() {
        return "com.google.android.gms.phenotype.service.START";
    }
}
