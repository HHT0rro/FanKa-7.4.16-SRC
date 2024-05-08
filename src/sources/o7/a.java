package o7;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.zar;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zae;
import com.google.android.gms.signin.internal.zah;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.internal.zam;
import com.huawei.hms.api.HuaweiApiClientImpl;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a extends com.google.android.gms.common.internal.c<zae> implements n7.e {
    public final boolean H;
    public final com.google.android.gms.common.internal.b I;
    public final Bundle J;

    @Nullable
    public final Integer K;

    public a(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull boolean z10, @RecentlyNonNull com.google.android.gms.common.internal.b bVar, @RecentlyNonNull Bundle bundle, @RecentlyNonNull GoogleApiClient.a aVar, @RecentlyNonNull GoogleApiClient.b bVar2) {
        super(context, looper, 44, bVar, aVar, bVar2);
        this.H = z10;
        this.I = bVar;
        this.J = bundle;
        this.K = bVar.i();
    }

    @RecentlyNonNull
    public static Bundle i0(@RecentlyNonNull com.google.android.gms.common.internal.b bVar) {
        n7.a h10 = bVar.h();
        Integer i10 = bVar.i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", bVar.a());
        if (i10 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i10.intValue());
        }
        if (h10 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.a.f
    @RecentlyNonNull
    public boolean c() {
        return this.H;
    }

    @Override // n7.e
    public final void d() {
        b(new BaseGmsClient.d());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.a.f
    @RecentlyNonNull
    public int g() {
        return com.google.android.gms.common.d.f23519a;
    }

    @Override // n7.e
    public final void j(zac zacVar) {
        h.i(zacVar, "Expecting a valid ISignInCallbacks");
        try {
            Account b4 = this.I.b();
            ((zae) x()).zaa(new zak(new zar(b4, ((Integer) h.h(this.K)).intValue(), HuaweiApiClientImpl.DEFAULT_ACCOUNT.equals(b4.name) ? s6.b.a(t()).b() : null)), zacVar);
        } catch (RemoteException e2) {
            try {
                zacVar.zaa(new zam(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public /* synthetic */ IInterface o(@RecentlyNonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof zae) {
            return (zae) queryLocalInterface;
        }
        return new zah(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public Bundle u() {
        if (!t().getPackageName().equals(this.I.d())) {
            this.J.putString("com.google.android.gms.signin.internal.realClientPackageName", this.I.d());
        }
        return this.J;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public String y() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public String z() {
        return "com.google.android.gms.signin.service.START";
    }

    public a(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull boolean z10, @RecentlyNonNull com.google.android.gms.common.internal.b bVar, @RecentlyNonNull n7.a aVar, @RecentlyNonNull GoogleApiClient.a aVar2, @RecentlyNonNull GoogleApiClient.b bVar2) {
        this(context, looper, true, bVar, i0(bVar), aVar2, bVar2);
    }
}
