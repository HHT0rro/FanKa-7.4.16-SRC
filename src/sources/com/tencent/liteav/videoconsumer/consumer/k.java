package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43744a;

    /* renamed from: b, reason: collision with root package name */
    private final String f43745b;

    private k(b bVar, String str) {
        this.f43744a = bVar;
        this.f43745b = str;
    }

    public static Runnable a(b bVar, String str) {
        return new k(bVar, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43744a;
        String str = this.f43745b;
        try {
            LiteavLog.i(bVar.f43692a, "setHWDecoderDeviceRelatedParams: ".concat(String.valueOf(str)));
            final JSONArray jSONArray = new JSONArray(str);
            final VideoDecodeController videoDecodeController = bVar.f43698g;
            videoDecodeController.a(new Runnable(videoDecodeController, jSONArray) { // from class: com.tencent.liteav.videoconsumer.decoder.as

                /* renamed from: a, reason: collision with root package name */
                private final VideoDecodeController f43874a;

                /* renamed from: b, reason: collision with root package name */
                private final JSONArray f43875b;

                {
                    this.f43874a = videoDecodeController;
                    this.f43875b = jSONArray;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    VideoDecodeController videoDecodeController2 = this.f43874a;
                    JSONArray jSONArray2 = this.f43875b;
                    videoDecodeController2.f43785l = jSONArray2;
                    LiteavLog.i(videoDecodeController2.f43774a, "set MediaCodec device related params to %s", jSONArray2);
                }
            });
        } catch (JSONException e2) {
            LiteavLog.e(bVar.f43692a, "setHWDecoderDeviceRelatedParams error ".concat(String.valueOf(e2)));
        }
    }
}
