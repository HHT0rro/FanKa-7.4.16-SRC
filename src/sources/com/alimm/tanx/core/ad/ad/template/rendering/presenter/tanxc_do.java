package com.alimm.tanx.core.ad.ad.template.rendering.presenter;

import android.content.Context;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.listener.INewTanxExpressAd;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.listener.model.IModel;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BasePresenter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class tanxc_do<M extends IModel, T extends ITanxAd, F extends INewTanxExpressAd> implements IPresenter {
    public Context tanxc_do;
    public M tanxc_if;

    public tanxc_do(Context context, M m10) {
        this.tanxc_do = context;
        this.tanxc_if = m10;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public IPresenter destroy() {
        return this;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public IPresenter request(TanxAdSlot tanxAdSlot, final ITanxAdLoader.OnAdLoadListener onAdLoadListener, long j10) {
        if (onAdLoadListener == null) {
            return this;
        }
        this.tanxc_if.sendRequest(tanxAdSlot, new ITanxRequestLoader.ITanxRequestListener<T>() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do.1
            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onError(TanxError tanxError) {
                onAdLoadListener.onError(tanxError);
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onSuccess(List<T> list) {
                onAdLoadListener.onLoaded(tanxc_do.this.tanxc_do(list));
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onTimeOut() {
                onAdLoadListener.onTimeOut();
            }
        }, j10);
        return this;
    }

    public abstract F tanxc_do(T t2);

    public List<F> tanxc_do(List<T> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<T> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(tanxc_do((tanxc_do<M, T, F>) iterator2.next()));
        }
        return arrayList;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.IPresenter
    public IPresenter request(TanxAdSlot tanxAdSlot, ITanxAdLoader.OnAdLoadListener onAdLoadListener) {
        return request(tanxAdSlot, onAdLoadListener, 0L);
    }
}
