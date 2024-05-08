package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {

    /* renamed from: g, reason: collision with root package name */
    private AdListenerAdapter f38192g;

    /* renamed from: h, reason: collision with root package name */
    private NativeADUnifiedListener f38193h;

    /* renamed from: i, reason: collision with root package name */
    private List<Integer> f38194i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private List<String> f38195j;

    /* renamed from: k, reason: collision with root package name */
    private volatile int f38196k;

    /* renamed from: l, reason: collision with root package name */
    private volatile int f38197l;

    /* renamed from: m, reason: collision with root package name */
    private String f38198m;

    /* renamed from: n, reason: collision with root package name */
    private LoadAdParams f38199n;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AdListenerAdapter implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private NativeADUnifiedListener f38200a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f38200a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.f38200a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.f38200a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                List list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(new NativeUnifiedADDataAdapter((NativeUnifiedADData) iterator2.next()));
                }
                this.f38200a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f38193h = nativeADUnifiedListener;
        this.f38192g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f38193h = nativeADUnifiedListener;
        this.f38192g = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    private void a(int i10, boolean z10) {
        if (a()) {
            if (!b()) {
                if (z10) {
                    this.f38194i.add(Integer.valueOf(i10));
                    return;
                }
                return;
            }
            T t2 = this.f38089a;
            if (t2 != 0) {
                LoadAdParams loadAdParams = this.f38199n;
                NUADI nuadi = (NUADI) t2;
                if (loadAdParams != null) {
                    nuadi.loadData(i10, loadAdParams);
                } else {
                    nuadi.loadData(i10);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f38192g);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NUADI nuadi) {
        super.a((NativeUnifiedAD) nuadi);
        nuadi.setMinVideoDuration(this.f38196k);
        nuadi.setMaxVideoDuration(this.f38197l);
        nuadi.setVastClassName(this.f38198m);
        List<String> list = this.f38195j;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> iterator2 = this.f38194i.iterator2();
        while (iterator2.hasNext()) {
            a(iterator2.next().intValue(), false);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f38193h;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public String getAdNetWorkName() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            return ((NUADI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i10) {
        a(i10, true);
    }

    public void loadData(int i10, LoadAdParams loadAdParams) {
        this.f38199n = loadAdParams;
        loadData(i10);
    }

    public void setCategories(List<String> list) {
        this.f38195j = list;
        T t2 = this.f38089a;
        if (t2 == 0 || list == null) {
            return;
        }
        ((NUADI) t2).setCategories(list);
    }

    public void setMaxVideoDuration(int i10) {
        this.f38197l = i10;
        if (this.f38197l > 0 && this.f38196k > this.f38197l) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((NUADI) t2).setMaxVideoDuration(this.f38197l);
        }
    }

    public void setMinVideoDuration(int i10) {
        this.f38196k = i10;
        if (this.f38197l > 0 && this.f38196k > this.f38197l) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((NUADI) t2).setMinVideoDuration(this.f38196k);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.f38198m = str;
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((NUADI) t2).setVastClassName(str);
        }
    }
}
