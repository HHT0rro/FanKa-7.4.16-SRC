package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class p implements NativeResponse.CustomizeMediaPlayer {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10280a = "vstart";

    /* renamed from: b, reason: collision with root package name */
    private static final String f10281b = "vrepeatedplay";

    /* renamed from: c, reason: collision with root package name */
    private static final String f10282c = "vclose";

    /* renamed from: d, reason: collision with root package name */
    private static final String f10283d = "vreadyplay";

    /* renamed from: e, reason: collision with root package name */
    private static final String f10284e = "vplayfail";

    /* renamed from: f, reason: collision with root package name */
    private static final String f10285f = "vmute";

    /* renamed from: g, reason: collision with root package name */
    private static final String f10286g = "vfrozen";

    /* renamed from: h, reason: collision with root package name */
    private static final String f10287h = "vshow";

    /* renamed from: i, reason: collision with root package name */
    private static final String f10288i = "curTimeSec";

    /* renamed from: j, reason: collision with root package name */
    private static final String f10289j = "startTimeSec";

    /* renamed from: k, reason: collision with root package name */
    private static final String f10290k = "autoPlay";

    /* renamed from: l, reason: collision with root package name */
    private static final String f10291l = "reasonValue";

    /* renamed from: m, reason: collision with root package name */
    private final dj f10292m;

    /* renamed from: n, reason: collision with root package name */
    private final a f10293n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f10294o = false;

    /* renamed from: p, reason: collision with root package name */
    private int f10295p = 0;

    public p(dj djVar, a aVar) {
        this.f10292m = djVar;
        this.f10293n = aVar;
    }

    private void a(String str, JSONObject jSONObject) {
        a aVar;
        JSONObject T;
        if (this.f10292m == null || (aVar = this.f10293n) == null || (T = aVar.T()) == null) {
            return;
        }
        try {
            T.put("msg", "sendVideoThirdLog");
            T.put("trackType", str);
            T.put("trackInfo", jSONObject);
            this.f10292m.a(T);
        } catch (Throwable th) {
            bs.a().d(th.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public String getVideoUrl() {
        a aVar = this.f10293n;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayError(int i10) {
        a(f10284e, a(this.f10295p, i10, this.f10294o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayFrozen(int i10) {
        a(f10286g, a(this.f10295p, i10, this.f10294o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayerReady() {
        a(f10283d, a(0, 0, false, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoMuteChange(int i10, boolean z10) {
        a(f10285f, a(this.f10295p, i10, this.f10294o, z10 ? 2 : 1));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoPause(int i10, NativeResponse.VideoReason videoReason) {
        a(f10282c, a(this.f10295p, i10, this.f10294o, videoReason.getCode()));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoReplay() {
        this.f10295p = 0;
        a(f10281b, a(0, 0, this.f10294o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoResume(int i10) {
        this.f10295p = i10;
        a(f10280a, a(i10, i10, this.f10294o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoShow() {
        a(f10287h, a(0, 0, false, 7));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStart(boolean z10) {
        this.f10295p = 0;
        this.f10294o = z10;
        a(f10280a, a(0, 0, z10, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStop(int i10, NativeResponse.VideoReason videoReason) {
        a(f10282c, a(this.f10295p, i10, this.f10294o, videoReason.getCode()));
    }

    private JSONObject a(int i10, int i11, boolean z10, int i12) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f10289j, i10 / 1000);
            jSONObject.put(f10288i, i11 / 1000);
            jSONObject.put(f10290k, z10);
            jSONObject.put(f10291l, i12);
        } catch (Throwable th) {
            bs.a().d(th.getMessage());
        }
        return jSONObject;
    }
}
