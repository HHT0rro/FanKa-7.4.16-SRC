package com.tencent.mm.opensdk.diffdev.a;

import android.os.Handler;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements OAuthListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a f45091f;

    public b(a aVar) {
        this.f45091f = aVar;
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        List list;
        Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
        a.c(this.f45091f);
        ArrayList arrayList = new ArrayList();
        list = this.f45091f.f45088c;
        arrayList.addAll(list);
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            ((OAuthListener) iterator2.next()).onAuthFinish(oAuthErrCode, str);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthGotQrcode(String str, byte[] bArr) {
        List list;
        Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
        ArrayList arrayList = new ArrayList();
        list = this.f45091f.f45088c;
        arrayList.addAll(list);
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            ((OAuthListener) iterator2.next()).onAuthGotQrcode(str, bArr);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onQrcodeScanned() {
        Handler handler;
        Handler handler2;
        Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        handler = this.f45091f.handler;
        if (handler != null) {
            handler2 = this.f45091f.handler;
            handler2.post(new c(this));
        }
    }
}
