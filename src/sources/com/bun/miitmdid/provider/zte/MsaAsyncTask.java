package com.bun.miitmdid.provider.zte;

import android.os.AsyncTask;
import com.bun.lib.MsaIdInterface;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MsaAsyncTask extends AsyncTask<Void, Void, Boolean> {
    public MsaServiceConnection _conn;
    public MsaIdInterface msaIdInterface;

    public MsaAsyncTask(MsaIdInterface msaIdInterface, MsaServiceConnection msaServiceConnection) {
        this.msaIdInterface = msaIdInterface;
        this._conn = msaServiceConnection;
    }

    /* renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public Boolean doInBackground2(Void... voidArr) {
        return (Boolean) Utils.rL(new Object[]{this, voidArr, 108, 1598952044330L});
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Boolean, java.lang.Object] */
    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ Boolean doInBackground(Void[] voidArr) {
        return Utils.rL(new Object[]{this, voidArr, 109, 1598952044331L});
    }

    /* renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    public void onPostExecute2(Boolean bool) {
        Utils.rL(new Object[]{this, bool, 110, 1598952044332L});
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Boolean bool) {
        Utils.rL(new Object[]{this, bool, 111, 1598952044333L});
    }
}
