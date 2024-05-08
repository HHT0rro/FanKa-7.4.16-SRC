package com.wangmai.appsdkdex;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.wangmai.common.IAdLoader;
import com.wangmai.common.utils.DebugLog;
import com.wangmai.common.utils.MessageEvent;
import zc.a;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TransActivity extends Activity {

    /* renamed from: b, reason: collision with root package name */
    public static final String f46885b = "TransActivity";

    public void a() {
        IAdLoader a10 = a.a(this);
        if (a10 != null) {
            a10.dispatchAction(this);
            return;
        }
        DebugLog.W(f46885b, b.a("cvjme!beMpbefs!gbjm"));
        MessageEvent.notify(b.a("fwfou`gbjm"));
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a();
    }
}
