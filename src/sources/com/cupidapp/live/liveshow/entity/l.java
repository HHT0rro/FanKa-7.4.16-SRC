package com.cupidapp.live.liveshow.entity;

import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.sensorslog.TrackAppErrorType;
import com.cupidapp.live.liveshow.pk.view.MultiPkPlaceType;
import com.zego.zegoavkit2.mixstream.IZegoMixStreamExCallback;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamConfig;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamInfo;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamOutput;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamResultEx;
import com.zego.zegoavkit2.mixstream.ZegoStreamMixer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ZGMixStreamPublisher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public int f14932a;

    /* renamed from: b, reason: collision with root package name */
    public int f14933b;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f14935d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public ZegoStreamMixer f14936e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public ZegoMixStreamConfig f14937f;

    /* renamed from: i, reason: collision with root package name */
    public int f14940i;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f14934c = "rtmp://publish-ws.finkapp.cn/enjoymeet/";

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final List<MixStreamLayoutModel> f14938g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Map<String, ZegoMixStreamInfo> f14939h = new LinkedHashMap();

    /* compiled from: ZGMixStreamPublisher.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14941a;

        static {
            int[] iArr = new int[MultiPkPlaceType.values().length];
            try {
                iArr[MultiPkPlaceType.ThreePkPlace.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MultiPkPlaceType.TwoPkPlace.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MultiPkPlaceType.OnePkPlace.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f14941a = iArr;
        }
    }

    public static final void m(l this$0, Function0 mixStreamSuccess, int i10, String str, ZegoMixStreamResultEx zegoMixStreamResultEx) {
        s.i(this$0, "this$0");
        s.i(mixStreamSuccess, "$mixStreamSuccess");
        Collection<ZegoMixStreamInfo> values = this$0.f14939h.values();
        ArrayList arrayList = new ArrayList(t.t(values, 10));
        Iterator<ZegoMixStreamInfo> iterator2 = values.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().streamID);
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGMixStreamPublisher", "mixStreamID: " + str + " stateCode: " + i10 + " mixStreamInfoMap: " + ((Object) arrayList));
        if (i10 == 0) {
            s.h(zegoMixStreamResultEx.outputList, "streamInfo.outputList");
            if (!r8.isEmpty()) {
                mixStreamSuccess.invoke();
            }
            this$0.f14940i = 0;
            return;
        }
        com.cupidapp.live.base.view.h.f12779a.t("混流失败 code: " + i10);
        if (this$0.f14940i < 1) {
            p(this$0, str, null, 2, null);
            this$0.f14940i++;
        }
        j1.f.f50231a.a(TrackAppErrorType.MIX_STREAM_FAILED, "mixStreamID: " + str + " stateCode: " + i10 + " streamIdList: " + ((Object) arrayList));
    }

    public static /* synthetic */ void p(l lVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        lVar.o(str, str2);
    }

    public final ByteBuffer b(String str) {
        byte[] bytes = str.getBytes(kotlin.text.c.f51097b);
        s.h(bytes, "this as java.lang.String).getBytes(charset)");
        int length = bytes.length;
        ByteBuffer inData = ByteBuffer.allocateDirect(length);
        inData.put(bytes, 0, length);
        inData.flip();
        s.h(inData, "inData");
        return inData;
    }

    public final String c() {
        String json = GsonUtil.f12000a.b().toJson(new MixStreamLayoutListModel(this.f14938g));
        com.cupidapp.live.base.utils.j.f12332a.a("ZGMixStreamPublisher", "json: " + json);
        s.h(json, "json");
        return json;
    }

    public final ZegoMixStreamInfo d(String str, String str2, MultiPkPlaceType multiPkPlaceType, int i10) {
        MixStreamLocationPercentModel f10 = f(multiPkPlaceType, i10);
        if (f10 == null) {
            return null;
        }
        this.f14938g.add(e(str, f10));
        ZegoMixStreamInfo zegoMixStreamInfo = new ZegoMixStreamInfo();
        zegoMixStreamInfo.streamID = str2;
        zegoMixStreamInfo.contentControl = 0;
        zegoMixStreamInfo.left = (int) (this.f14932a * f10.getLeft());
        zegoMixStreamInfo.top = (int) (this.f14933b * f10.getTop());
        zegoMixStreamInfo.right = (int) (this.f14932a * f10.getRight());
        zegoMixStreamInfo.bottom = (int) (this.f14933b * f10.getBottom());
        return zegoMixStreamInfo;
    }

    public final MixStreamLayoutModel e(String str, MixStreamLocationPercentModel mixStreamLocationPercentModel) {
        return new MixStreamLayoutModel(str, mixStreamLocationPercentModel.getLeft(), mixStreamLocationPercentModel.getTop(), mixStreamLocationPercentModel.getRight() - mixStreamLocationPercentModel.getLeft(), mixStreamLocationPercentModel.getBottom() - mixStreamLocationPercentModel.getTop());
    }

    public final MixStreamLocationPercentModel f(MultiPkPlaceType multiPkPlaceType, int i10) {
        int i11 = a.f14941a[multiPkPlaceType.ordinal()];
        if (i11 == 1) {
            if (i10 == 0) {
                return new MixStreamLocationPercentModel(0.0f, 0.0f, 0.5f, 0.5f);
            }
            if (i10 == 1) {
                return new MixStreamLocationPercentModel(0.5f, 0.0f, 1.0f, 0.5f);
            }
            if (i10 == 2) {
                return new MixStreamLocationPercentModel(0.0f, 0.5f, 0.5f, 1.0f);
            }
            if (i10 != 3) {
                return null;
            }
            return new MixStreamLocationPercentModel(0.5f, 0.5f, 1.0f, 1.0f);
        }
        if (i11 != 2) {
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (i10 == 0) {
                return new MixStreamLocationPercentModel(0.0f, 0.0f, 0.5f, 1.0f);
            }
            if (i10 != 1) {
                return null;
            }
            return new MixStreamLocationPercentModel(0.5f, 0.0f, 1.0f, 1.0f);
        }
        if (i10 == 0) {
            return new MixStreamLocationPercentModel(0.0f, 0.0f, 0.5f, 1.0f);
        }
        if (i10 == 1) {
            return new MixStreamLocationPercentModel(0.5f, 0.0f, 1.0f, 0.5f);
        }
        if (i10 != 2) {
            return null;
        }
        return new MixStreamLocationPercentModel(0.5f, 0.5f, 1.0f, 1.0f);
    }

    public final String g() {
        if (this.f14935d == null) {
            this.f14935d = this.f14934c;
        }
        return this.f14935d;
    }

    public final void h(@NotNull String liveShowId, @NotNull String streamId, @NotNull MultiPkPlaceType placeType, int i10, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        s.i(streamId, "streamId");
        s.i(placeType, "placeType");
        if (str == null || this.f14939h.containsKey(liveShowId)) {
            return;
        }
        ZegoMixStreamInfo d10 = d(liveShowId, streamId, placeType, i10);
        if (d10 != null) {
            this.f14939h.put(liveShowId, d10);
        }
        p(this, str, null, 2, null);
    }

    public final void i(@NotNull String liveShowId) {
        MixStreamLayoutModel mixStreamLayoutModel;
        s.i(liveShowId, "liveShowId");
        if (this.f14939h.containsKey(liveShowId)) {
            this.f14939h.remove(liveShowId);
        }
        Iterator<MixStreamLayoutModel> iterator2 = this.f14938g.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                mixStreamLayoutModel = null;
                break;
            } else {
                mixStreamLayoutModel = iterator2.next();
                if (s.d(mixStreamLayoutModel.getLiveShowId(), liveShowId)) {
                    break;
                }
            }
        }
        MixStreamLayoutModel mixStreamLayoutModel2 = mixStreamLayoutModel;
        if (mixStreamLayoutModel2 != null) {
            this.f14938g.remove(mixStreamLayoutModel2);
        }
    }

    public final void j(@NotNull String liveShowId, boolean z10, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        if (str == null) {
            return;
        }
        ZegoMixStreamInfo zegoMixStreamInfo = this.f14939h.get(liveShowId);
        if (zegoMixStreamInfo != null) {
            zegoMixStreamInfo.contentControl = z10 ? 2 : 0;
        }
        p(this, str, null, 2, null);
    }

    public final void k(@NotNull String liveShowId, @NotNull String streamId, @NotNull MultiPkPlaceType placeType, int i10) {
        s.i(liveShowId, "liveShowId");
        s.i(streamId, "streamId");
        s.i(placeType, "placeType");
        ZegoMixStreamInfo d10 = d(liveShowId, streamId, placeType, i10);
        if (d10 != null) {
            this.f14939h.put(liveShowId, d10);
        }
    }

    public final void l(@NotNull final Function0<p> mixStreamSuccess) {
        s.i(mixStreamSuccess, "mixStreamSuccess");
        if (this.f14936e == null) {
            ZegoStreamMixer zegoStreamMixer = new ZegoStreamMixer();
            zegoStreamMixer.setMixStreamExCallback(new IZegoMixStreamExCallback() { // from class: com.cupidapp.live.liveshow.entity.k
                @Override // com.zego.zegoavkit2.mixstream.IZegoMixStreamExCallback
                public final void onMixStreamExConfigUpdate(int i10, String str, ZegoMixStreamResultEx zegoMixStreamResultEx) {
                    l.m(l.this, mixStreamSuccess, i10, str, zegoMixStreamResultEx);
                }
            });
            this.f14936e = zegoStreamMixer;
        }
    }

    public final void n(int i10, int i11) {
        this.f14932a = i10;
        this.f14933b = i11;
    }

    public final void o(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return;
        }
        if (str2 != null) {
            this.f14935d = str2;
        }
        ZegoMixStreamConfig zegoMixStreamConfig = new ZegoMixStreamConfig();
        zegoMixStreamConfig.outputBitrate = 800000;
        zegoMixStreamConfig.outputFps = 15;
        zegoMixStreamConfig.outputAudioBitrate = 48000;
        zegoMixStreamConfig.outputWidth = this.f14932a;
        zegoMixStreamConfig.outputHeight = this.f14933b;
        zegoMixStreamConfig.inputStreamList = (ZegoMixStreamInfo[]) this.f14939h.values().toArray(new ZegoMixStreamInfo[0]);
        ZegoMixStreamOutput zegoMixStreamOutput = new ZegoMixStreamOutput();
        zegoMixStreamOutput.isUrl = true;
        zegoMixStreamOutput.target = g() + str;
        zegoMixStreamConfig.outputList = new ZegoMixStreamOutput[]{zegoMixStreamOutput};
        zegoMixStreamConfig.outputBackgroundImage = "preset-id://3840043536_live_view_2.png";
        String c4 = c();
        zegoMixStreamConfig.userData = b(c4);
        byte[] bytes = c4.getBytes(kotlin.text.c.f51097b);
        s.h(bytes, "this as java.lang.String).getBytes(charset)");
        zegoMixStreamConfig.lenOfUserData = bytes.length;
        this.f14937f = zegoMixStreamConfig;
        ZegoStreamMixer zegoStreamMixer = this.f14936e;
        if (zegoStreamMixer != null) {
            zegoStreamMixer.mixStreamEx(zegoMixStreamConfig, str);
        }
    }

    public final void q(@Nullable String str) {
        if (str == null) {
            return;
        }
        ZegoMixStreamConfig zegoMixStreamConfig = this.f14937f;
        if (zegoMixStreamConfig != null) {
            zegoMixStreamConfig.inputStreamList = new ZegoMixStreamInfo[0];
            ZegoMixStreamOutput zegoMixStreamOutput = new ZegoMixStreamOutput();
            zegoMixStreamOutput.isUrl = true;
            zegoMixStreamOutput.target = g() + str;
            zegoMixStreamConfig.outputList = new ZegoMixStreamOutput[]{zegoMixStreamOutput};
        }
        ZegoStreamMixer zegoStreamMixer = this.f14936e;
        if (zegoStreamMixer != null) {
            zegoStreamMixer.mixStreamEx(this.f14937f, str);
        }
        this.f14939h.clear();
        this.f14938g.clear();
        this.f14936e = null;
        this.f14937f = null;
        this.f14940i = 0;
    }

    public final void r(@NotNull MultiPkPlaceType placeType, @NotNull List<String> liveShowList, @Nullable String str) {
        s.i(placeType, "placeType");
        s.i(liveShowList, "liveShowList");
        if (str == null) {
            return;
        }
        int i10 = 0;
        for (String str2 : liveShowList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            s(str2, placeType, i10);
            i10 = i11;
        }
        p(this, str, null, 2, null);
    }

    public final void s(String str, MultiPkPlaceType multiPkPlaceType, int i10) {
        MixStreamLocationPercentModel f10;
        MixStreamLayoutModel mixStreamLayoutModel;
        ZegoMixStreamInfo zegoMixStreamInfo = this.f14939h.get(str);
        if (zegoMixStreamInfo == null || (f10 = f(multiPkPlaceType, i10)) == null) {
            return;
        }
        zegoMixStreamInfo.left = (int) (this.f14932a * f10.getLeft());
        zegoMixStreamInfo.top = (int) (this.f14933b * f10.getTop());
        zegoMixStreamInfo.right = (int) (this.f14932a * f10.getRight());
        zegoMixStreamInfo.bottom = (int) (this.f14933b * f10.getBottom());
        Iterator<MixStreamLayoutModel> iterator2 = this.f14938g.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                mixStreamLayoutModel = null;
                break;
            } else {
                mixStreamLayoutModel = iterator2.next();
                if (s.d(mixStreamLayoutModel.getLiveShowId(), str)) {
                    break;
                }
            }
        }
        MixStreamLayoutModel mixStreamLayoutModel2 = mixStreamLayoutModel;
        if (mixStreamLayoutModel2 != null) {
            int indexOf = this.f14938g.indexOf(mixStreamLayoutModel2);
            this.f14938g.remove(mixStreamLayoutModel2);
            this.f14938g.add(indexOf, e(str, f10));
        }
    }
}
