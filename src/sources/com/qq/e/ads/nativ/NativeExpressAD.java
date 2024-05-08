package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> implements IReward {

    /* renamed from: g, reason: collision with root package name */
    private volatile int f38179g;

    /* renamed from: h, reason: collision with root package name */
    private volatile int f38180h;

    /* renamed from: i, reason: collision with root package name */
    private List<Integer> f38181i = Collections.synchronizedList(new ArrayList());

    /* renamed from: j, reason: collision with root package name */
    private VideoOption f38182j;

    /* renamed from: k, reason: collision with root package name */
    private ADSize f38183k;

    /* renamed from: l, reason: collision with root package name */
    private NativeExpressADListener f38184l;

    /* renamed from: m, reason: collision with root package name */
    private final ADListenerAdapter f38185m;

    /* renamed from: n, reason: collision with root package name */
    private LoadAdParams f38186n;

    /* renamed from: o, reason: collision with root package name */
    private volatile ServerSideVerificationOptions f38187o;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private NativeExpressADListener f38188a;

        /* renamed from: b, reason: collision with root package name */
        private NativeExpressMediaListener f38189b;

        /* renamed from: c, reason: collision with root package name */
        private NegativeFeedbackListener f38190c;

        /* renamed from: d, reason: collision with root package name */
        private ADRewardListener f38191d;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.f38188a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f38189b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeExpressAD.a(this.f38188a, aDEvent) || NativeExpressAD.a(this.f38189b, aDEvent) || NativeExpressAD.a(this.f38190c, aDEvent)) {
                return;
            }
            NativeExpressAD.a(this.f38191d, aDEvent);
        }

        public void setAdRewardListener(ADRewardListener aDRewardListener) {
            this.f38191d = aDRewardListener;
        }

        public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f38189b = nativeExpressMediaListener;
        }

        public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
            this.f38190c = negativeFeedbackListener;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        this.f38184l = nativeExpressADListener;
        this.f38185m = new ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        this.f38184l = nativeExpressADListener;
        this.f38185m = new ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str, str2);
    }

    private boolean a(ADSize aDSize) {
        if (aDSize != null) {
            this.f38183k = aDSize;
            return false;
        }
        GDTLogger.e("初始化错误：参数adSize不能为空");
        a(2001);
        return true;
    }

    public static boolean a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener != null) {
            int type = aDEvent.getType();
            if (type == 100) {
                List<NativeExpressADView> list = (List) aDEvent.getParam(List.class);
                if (list != null) {
                    nativeExpressADListener.onADLoaded(list);
                }
            } else if (type == 101) {
                Integer num = (Integer) aDEvent.getParam(Integer.class);
                if (num != null) {
                    nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                }
            } else if (type == 103) {
                NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView != null) {
                    nativeExpressADListener.onADExposure(nativeExpressADView);
                }
            } else if (type == 303) {
                NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView2 != null) {
                    nativeExpressADListener.onADLeftApplication(nativeExpressADView2);
                }
            } else if (type == 105) {
                NativeExpressADView nativeExpressADView3 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView3 != null) {
                    nativeExpressADListener.onADClicked(nativeExpressADView3);
                }
            } else if (type == 106) {
                NativeExpressADView nativeExpressADView4 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView4 != null) {
                    nativeExpressADListener.onADClosed(nativeExpressADView4);
                    nativeExpressADView4.negativeFeedback();
                }
            } else if (type == 109) {
                NativeExpressADView nativeExpressADView5 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView5 != null) {
                    nativeExpressADListener.onRenderSuccess(nativeExpressADView5);
                }
            } else if (type == 110) {
                NativeExpressADView nativeExpressADView6 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView6 != null) {
                    nativeExpressADListener.onRenderFail(nativeExpressADView6);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NEADI neadi) {
        super.a((NativeExpressAD) neadi);
        neadi.setMinVideoDuration(this.f38179g);
        neadi.setMaxVideoDuration(this.f38180h);
        ((NEADI) this.f38089a).setServerSideVerificationOptions(this.f38187o);
        VideoOption videoOption = this.f38182j;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.f38181i) {
            Iterator<Integer> iterator2 = this.f38181i.iterator2();
            while (iterator2.hasNext()) {
                T t2 = this.f38089a;
                if (t2 != 0) {
                    if (this.f38186n != null) {
                        ((NEADI) t2).loadAd(iterator2.next().intValue(), this.f38186n);
                    } else {
                        ((NEADI) t2).loadAd(iterator2.next().intValue());
                    }
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        NativeExpressADListener nativeExpressADListener = this.f38184l;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public String getAdNetWorkName() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            return ((NEADI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i10) {
        loadAD(i10, null);
    }

    public void loadAD(int i10, LoadAdParams loadAdParams) {
        if (a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.f38181i) {
                    this.f38181i.add(Integer.valueOf(i10));
                }
                return;
            }
            T t2 = this.f38089a;
            if (t2 == 0) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.f38186n;
            NEADI neadi = (NEADI) t2;
            if (loadAdParams2 != null) {
                neadi.loadAd(i10, loadAdParams2);
            } else {
                neadi.loadAd(i10);
            }
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.f38186n = loadAdParams;
    }

    public void setMaxVideoDuration(int i10) {
        this.f38180h = i10;
        if (this.f38180h > 0 && this.f38179g > this.f38180h) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((NEADI) t2).setMaxVideoDuration(this.f38180h);
        }
    }

    public void setMinVideoDuration(int i10) {
        this.f38179g = i10;
        if (this.f38180h > 0 && this.f38179g > this.f38180h) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((NEADI) t2).setMinVideoDuration(this.f38179g);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f38185m.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f38187o = serverSideVerificationOptions;
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((NEADI) t2).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f38182j = videoOption;
        T t2 = this.f38089a;
        if (t2 == 0 || videoOption == null) {
            return;
        }
        ((NEADI) t2).setVideoOption(videoOption);
    }

    public static boolean a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        NativeExpressADView nativeExpressADView;
        if (nativeExpressMediaListener != null && (nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class)) != null) {
            int type = aDEvent.getType();
            if (type == 201) {
                nativeExpressMediaListener.onVideoCached(nativeExpressADView);
                return true;
            }
            if (type == 202) {
                nativeExpressMediaListener.onVideoStart(nativeExpressADView);
                return true;
            }
            if (type == 204) {
                nativeExpressMediaListener.onVideoPause(nativeExpressADView);
                return true;
            }
            if (type == 206) {
                nativeExpressMediaListener.onVideoComplete(nativeExpressADView);
                return true;
            }
            if (type == 207) {
                Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                if (num == null) {
                    return true;
                }
                nativeExpressMediaListener.onVideoError(nativeExpressADView, AdErrorConvertor.formatErrorCode(num.intValue()));
                return true;
            }
            if (type == 301) {
                nativeExpressMediaListener.onVideoPageOpen(nativeExpressADView);
                return true;
            }
            if (type == 302) {
                nativeExpressMediaListener.onVideoPageClose(nativeExpressADView);
                return true;
            }
            switch (type) {
                case 209:
                    nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                    return true;
                case 210:
                    if (((Integer) aDEvent.getParam(1, Integer.class)) == null) {
                        return true;
                    }
                    nativeExpressMediaListener.onVideoReady(nativeExpressADView, r6.intValue());
                    return true;
                case 211:
                    nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                    return true;
            }
        }
        return false;
    }

    public static boolean a(NegativeFeedbackListener negativeFeedbackListener, ADEvent aDEvent) {
        if (negativeFeedbackListener == null || aDEvent.getType() != 304) {
            return false;
        }
        negativeFeedbackListener.onComplainSuccess();
        return true;
    }

    public static boolean a(ADRewardListener aDRewardListener, ADEvent aDEvent) {
        if (aDRewardListener == null || aDEvent.getType() != 104) {
            return false;
        }
        String str = (String) aDEvent.getParam(String.class);
        if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("transId", str);
            aDRewardListener.onReward(hashMap);
        }
        return true;
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.f38183k, str, str2, str3, this.f38185m);
    }
}
