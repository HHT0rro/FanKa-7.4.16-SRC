package com.kwad.sdk.oaid;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class OADIDSDKHelper25 {
    private static final String SUB_TAG = "OADIDSDKHelper25:";
    private static final String TAG = "KSAdSDK";
    private static boolean mIsRequestIng;
    private static boolean sGetOaidFail;

    @Keep
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class IIdentifierListener25 implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListener25(long j10, a aVar) {
            this.mStartTime = j10;
            this.mOaidListener = aVar;
        }

        @Override // com.bun.miitmdid.interfaces.IIdentifierListener
        public void OnSupport(boolean z10, IdSupplier idSupplier) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (!TextUtils.isEmpty(oaid)) {
                    StringBuilder sb2 = new StringBuilder("OADIDSDKHelper25:oaid time=");
                    sb2.append(currentTimeMillis);
                    sb2.append("--OAID:");
                    sb2.append(oaid);
                    this.mOaidListener.em(oaid);
                } else {
                    boolean unused = OADIDSDKHelper25.sGetOaidFail = true;
                }
            }
            boolean unused2 = OADIDSDKHelper25.mIsRequestIng = false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        @WorkerThread
        void em(String str);
    }

    public static void getOAId(Context context, a aVar) {
        if (context == null || sGetOaidFail) {
            return;
        }
        if (!isSupport()) {
            sGetOaidFail = true;
            return;
        }
        if (mIsRequestIng) {
            return;
        }
        mIsRequestIng = true;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int InitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener25(currentTimeMillis, aVar));
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            StringBuilder sb2 = new StringBuilder("OADIDSDKHelper25:sdk init time=");
            sb2.append(currentTimeMillis2);
            sb2.append("--result=");
            sb2.append(InitSdk);
        } catch (Throwable unused) {
            mIsRequestIng = false;
            sGetOaidFail = true;
        }
    }

    public static boolean isSupport() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.OADIDSDKHelper25.1
                @Override // com.bun.miitmdid.interfaces.IIdentifierListener
                public final void OnSupport(boolean z10, IdSupplier idSupplier) {
                }
            }.OnSupport(true, null);
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper25.class.getClassLoader());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
