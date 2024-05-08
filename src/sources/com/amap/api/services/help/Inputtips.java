package com.amap.api.services.help;

import android.content.Context;
import com.amap.api.col.s.bm;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class Inputtips {

    /* renamed from: a, reason: collision with root package name */
    private IInputtipsSearch f8572a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface InputtipsListener {
        void onGetInputtips(List<Tip> list, int i10);
    }

    public Inputtips(Context context, InputtipsListener inputtipsListener) throws AMapException {
        this.f8572a = null;
        try {
            this.f8572a = new bm(context, inputtipsListener);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (e2 instanceof AMapException) {
                throw ((AMapException) e2);
            }
        }
    }

    public final InputtipsQuery getQuery() {
        IInputtipsSearch iInputtipsSearch = this.f8572a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.getQuery();
        }
        return null;
    }

    public final List<Tip> requestInputtips() throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f8572a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.requestInputtips();
        }
        return null;
    }

    public final void requestInputtipsAsyn() {
        IInputtipsSearch iInputtipsSearch = this.f8572a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtipsAsyn();
        }
    }

    public final void setInputtipsListener(InputtipsListener inputtipsListener) {
        IInputtipsSearch iInputtipsSearch = this.f8572a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setInputtipsListener(inputtipsListener);
        }
    }

    public final void setQuery(InputtipsQuery inputtipsQuery) {
        IInputtipsSearch iInputtipsSearch = this.f8572a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setQuery(inputtipsQuery);
        }
    }

    public final void requestInputtips(String str, String str2) throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f8572a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2);
        }
    }

    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f8572a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2, str3);
        }
    }

    public Inputtips(Context context, InputtipsQuery inputtipsQuery) {
        this.f8572a = null;
        try {
            this.f8572a = new bm(context, inputtipsQuery);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
