package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> implements NFBI {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;

    /* renamed from: g, reason: collision with root package name */
    private final RewardVideoADListener f38218g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f38219h;

    /* renamed from: i, reason: collision with root package name */
    private LoadAdParams f38220i;

    /* renamed from: j, reason: collision with root package name */
    private ServerSideVerificationOptions f38221j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f38222k;

    /* renamed from: l, reason: collision with root package name */
    private final ADListenerAdapter f38223l;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a, reason: collision with root package name */
        private NegativeFeedbackListener f38224a;
        public RewardVideoADListener adListener;

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        public static void a(ADListenerAdapter aDListenerAdapter, NegativeFeedbackListener negativeFeedbackListener) {
            aDListenerAdapter.f38224a = negativeFeedbackListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                this.adListener.onADLoad();
                return;
            }
            if (type == 201) {
                this.adListener.onVideoCached();
                return;
            }
            if (type == 206) {
                this.adListener.onVideoComplete();
                return;
            }
            if (type == 304) {
                NegativeFeedbackListener negativeFeedbackListener = this.f38224a;
                if (negativeFeedbackListener != null) {
                    negativeFeedbackListener.onComplainSuccess();
                    return;
                }
                return;
            }
            switch (type) {
                case 102:
                    this.adListener.onADShow();
                    return;
                case 103:
                    this.adListener.onADExpose();
                    return;
                case 104:
                    String str = (String) aDEvent.getParam(String.class);
                    if (str != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("transId", str);
                        this.adListener.onReward(hashMap);
                        return;
                    }
                    return;
                case 105:
                    this.adListener.onADClick();
                    return;
                case 106:
                    this.adListener.onADClose();
                    return;
                case 107:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        this.adListener.onError(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z10) {
        this(rewardVideoADListener, z10);
        a(context, str);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z10, String str2) {
        this(rewardVideoADListener, z10);
        a(context, str, str2);
    }

    private RewardVideoAD(RewardVideoADListener rewardVideoADListener, boolean z10) {
        this.f38220i = null;
        this.f38222k = z10;
        this.f38218g = rewardVideoADListener;
        this.f38223l = new ADListenerAdapter(rewardVideoADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, this.f38223l);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        RewardVideoADListener rewardVideoADListener = this.f38218g;
        if (rewardVideoADListener != null) {
            rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public String getAdNetWorkName() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            return ((RVADI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getRewardAdType() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            return ((RVADI) t2).getRewardAdType();
        }
        a("getRewardAdType");
        return 0;
    }

    public int getVideoDuration() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            return ((RVADI) t2).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            return ((RVADI) t2).hasShown();
        }
        a("hasShown");
        return false;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f38219h = true;
                return;
            }
            T t2 = this.f38089a;
            if (t2 != 0) {
                ((RVADI) t2).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f38220i = loadAdParams;
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((RVADI) t2).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        ADListenerAdapter.a(this.f38223l, negativeFeedbackListener);
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f38221j = serverSideVerificationOptions;
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((RVADI) t2).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAD() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((RVADI) t2).showAD();
        } else {
            a("showAD");
        }
    }

    public void showAD(Activity activity) {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((RVADI) t2).showAD(activity);
        } else {
            a("showAD");
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        RVADI rvadi = (RVADI) obj;
        rvadi.setVolumeOn(this.f38222k);
        rvadi.setLoadAdParams(this.f38220i);
        rvadi.setServerSideVerificationOptions(this.f38221j);
        if (this.f38219h) {
            loadAD();
        }
    }
}
