package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    public static void a(@NonNull final File file, boolean z10, @Nullable final CountDownLatch countDownLatch) {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "upload()" + ((Object) Thread.currentThread()));
        final f fVar = new f();
        fVar.aHH = av.getDeviceId();
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", g.fG(file.getName()));
        fVar.aHJ = new JSONObject(hashMap).toString();
        fVar.aHK = q.getExtension(file.getName());
        fVar.aHM = file;
        final boolean z11 = true;
        new l<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: Id, reason: merged with bridge method [inline-methods] */
            public c createRequest() {
                return new c(av.getDeviceId(), f.this.aHF, SplashAdCacheManager.SPLASH_AD_ZIP_PATH);
            }

            @NonNull
            private static GetUploadTokenResult fF(String str) {
                JSONObject jSONObject = new JSONObject(str);
                GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
                getUploadTokenResult.parseJson(jSONObject);
                return getUploadTokenResult;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ GetUploadTokenResult parseData(String str) {
                return fF(str);
            }
        }.request(new o<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull c cVar, @NonNull GetUploadTokenResult getUploadTokenResult) {
                com.kwad.sdk.core.e.c.d("AdExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
                if (getUploadTokenResult.isResultOk()) {
                    f fVar2 = f.this;
                    fVar2.aHL = getUploadTokenResult.uploadToken;
                    b.a(file, fVar2, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void Ib() {
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                        }

                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void Ic() {
                            com.kwad.sdk.core.e.c.d("AdExceptionCollector", "uploadLogFile onSuccess " + ((Object) Thread.currentThread()) + " delete file:" + file.getPath());
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z11) {
                                q.delete(file.getPath());
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar2, int i10, String str) {
                a((c) fVar2, i10, str);
            }

            private static void a(@NonNull c cVar, int i10, String str) {
                com.kwad.sdk.core.e.c.d("AdExceptionCollector", "onError errorCode=" + i10 + "errorMsg=" + str + "url=" + cVar.getUrl());
            }
        });
    }
}
