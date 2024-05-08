package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.ArrayList;

/* compiled from: InputtipsSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bm implements IInputtipsSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f7198a;

    /* renamed from: b, reason: collision with root package name */
    private Inputtips.InputtipsListener f7199b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f7200c;

    /* renamed from: d, reason: collision with root package name */
    private InputtipsQuery f7201d;

    public bm(Context context, Inputtips.InputtipsListener inputtipsListener) throws AMapException {
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7198a = context.getApplicationContext();
            this.f7199b = inputtipsListener;
            this.f7200c = y.a();
            return;
        }
        String str = a10.f7503b;
        throw new AMapException(str, 1, str, a10.f7502a.a());
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final InputtipsQuery getQuery() {
        return this.f7201d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final ArrayList<Tip> requestInputtips() throws AMapException {
        return a(this.f7201d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtipsAsyn() {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bm.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.obj = bm.this.f7199b;
                    obtainMessage.arg1 = 5;
                    try {
                        try {
                            bm bmVar = bm.this;
                            ArrayList<? extends Parcelable> a10 = bmVar.a(bmVar.f7201d);
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("result", a10);
                            obtainMessage.setData(bundle);
                            obtainMessage.what = 1000;
                        } catch (AMapException e2) {
                            obtainMessage.what = e2.getErrorCode();
                        }
                    } finally {
                        bm.this.f7200c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.f7199b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setQuery(InputtipsQuery inputtipsQuery) {
        this.f7201d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Tip> a(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            w.a(this.f7198a);
            if (inputtipsQuery != null) {
                if (inputtipsQuery.getKeyword() != null && !inputtipsQuery.getKeyword().equals("")) {
                    return new u(this.f7198a, inputtipsQuery).c();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (Throwable th) {
            n.a(th, "Inputtips", "requestInputtips");
            if (th instanceof AMapException) {
                throw th;
            }
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str != null && !str.equals("")) {
            InputtipsQuery inputtipsQuery = new InputtipsQuery(str, str2);
            this.f7201d = inputtipsQuery;
            inputtipsQuery.setType(str3);
            requestInputtipsAsyn();
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public bm(Context context, InputtipsQuery inputtipsQuery) {
        this.f7198a = context.getApplicationContext();
        this.f7201d = inputtipsQuery;
        this.f7200c = y.a();
    }
}
