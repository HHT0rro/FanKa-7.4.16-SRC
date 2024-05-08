package com.hifive.sdk.controller;

import android.content.Context;
import android.util.Base64;
import com.hifive.sdk.common.BaseConstance;
import com.hifive.sdk.common.HFLiveCallback;
import com.hifive.sdk.entity.HifiveMusicBean;
import com.hifive.sdk.entity.HifiveMusicChannelModel;
import com.hifive.sdk.entity.HifiveMusicDetailModel;
import com.hifive.sdk.entity.HifiveMusicModel;
import com.hifive.sdk.entity.HifiveMusicSearchrModel;
import com.hifive.sdk.entity.HifiveMusicSheetModel;
import com.hifive.sdk.entity.HifiveMusicUserSheetModel;
import com.hifive.sdk.ext.CommonExtKt;
import com.hifive.sdk.hInterface.DataResponse;
import com.hifive.sdk.hInterface.DownLoadResponse;
import com.hifive.sdk.manager.HFLiveApi;
import com.hifive.sdk.net.Encryption;
import com.hifive.sdk.rx.BaseException;
import com.hifive.sdk.rx.BaseSubscribe;
import com.hifive.sdk.service.impl.ServiceImpl;
import com.hifive.sdk.utils.NetWorkUtils;
import com.huawei.openalliance.ad.constant.u;
import com.mobile.auth.gatewayauth.ResultCode;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.DownloadResponseHandler;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.reflect.j;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: MusicManager.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class MusicManager {
    public static final /* synthetic */ j[] $$delegatedProperties = {v.h(new PropertyReference1Impl(v.b(MusicManager.class), "mService", "getMService()Lcom/hifive/sdk/service/impl/ServiceImpl;")), v.g(new PropertyReference0Impl(v.b(MusicManager.class), "down", "<v#0>"))};

    @NotNull
    private final Context context;
    private final Lazy mService$delegate;

    public MusicManager(@NotNull Context context) {
        s.j(context, "context");
        this.context = context;
        this.mService$delegate = c.b(new Function0<ServiceImpl>() { // from class: com.hifive.sdk.controller.MusicManager$mService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ServiceImpl invoke() {
                return new ServiceImpl();
            }
        });
    }

    private final ServiceImpl getMService() {
        Lazy lazy = this.mService$delegate;
        j jVar = $$delegatedProperties[0];
        return (ServiceImpl) lazy.getValue();
    }

    public final void bindingMember(@NotNull Context context, @NotNull String memberId, @NotNull String societyId, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(memberId, "memberId");
        s.j(societyId, "societyId");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().bind(memberId, societyId), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$bindingMember$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final boolean checkNetWork(@NotNull Context context) {
        s.j(context, "context");
        if (NetWorkUtils.INSTANCE.isNetWorkAvailable(context)) {
            return true;
        }
        HFLiveCallback callbacks = HFLiveApi.Companion.getCallbacks();
        if (callbacks == null) {
            return false;
        }
        callbacks.onError(new BaseException(10001, ResultCode.MSG_ERROR_NETWORK));
        return false;
    }

    public final void deleteMember(@NotNull Context context, @NotNull String memberId, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(memberId, "memberId");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().delete(memberId), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$deleteMember$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void deleteMemberSheetMusic(@NotNull Context context, @NotNull String sheetId, @NotNull String musicId, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(sheetId, "sheetId");
        s.j(musicId, "musicId");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().deleteMemberSheetMusic(sheetId, musicId), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$deleteMemberSheetMusic$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void deleteSearchRecord(@NotNull Context context, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().deleteSearchRecord(), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$deleteSearchRecord$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void deleteSociety(@NotNull Context context, @NotNull String societyId, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(societyId, "societyId");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().deleteSociety(societyId), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$deleteSociety$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    @NotNull
    public final Call downLoadFile(@NotNull Context context, @NotNull String url, @NotNull String path, @NotNull final DownLoadResponse response) {
        s.j(context, "context");
        s.j(url, "url");
        s.j(path, "path");
        s.j(response, "response");
        Lazy b4 = c.b(new Function0<MyOkHttp>() { // from class: com.hifive.sdk.controller.MusicManager$downLoadFile$down$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MyOkHttp invoke() {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                return new MyOkHttp(builder.connectTimeout(10000L, timeUnit).readTimeout(10000L, timeUnit).build());
            }
        });
        j jVar = $$delegatedProperties[1];
        Call enqueue = ((MyOkHttp) b4.getValue()).download().url(url).filePath(path).tag(this).enqueue(new DownloadResponseHandler() { // from class: com.hifive.sdk.controller.MusicManager$downLoadFile$1
            public void onFailure(@NotNull String error_msg) {
                s.j(error_msg, "error_msg");
                if (StringsKt__StringsKt.K(error_msg, "Canceled", false, 2, null)) {
                    return;
                }
                DownLoadResponse.this.fail("加载错误");
            }

            public void onFinish(@NotNull File downloadFile) {
                s.j(downloadFile, "downloadFile");
                DownLoadResponse.this.succeed(downloadFile);
            }

            public void onProgress(long j10, long j11) {
                DownLoadResponse.this.progress(j10, j11);
            }

            public void onStart(long j10) {
                DownLoadResponse.this.size(j10);
            }
        });
        s.e(enqueue, "down.download()\n        …     }\n                })");
        return enqueue;
    }

    public final void getCompanyChannelList(@NotNull Context context, @NotNull final DataResponse<List<HifiveMusicChannelModel>> response) {
        s.j(context, "context");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getCompanyChannelList(), new BaseSubscribe<List<? extends HifiveMusicChannelModel>>(response) { // from class: com.hifive.sdk.controller.MusicManager$getCompanyChannelList$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull List<? extends HifiveMusicChannelModel> t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void getCompanySheetList(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @NotNull final DataResponse<HifiveMusicBean<HifiveMusicSheetModel>> response) {
        s.j(context, "context");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getCompanySheetList(str, str2, str3, str4, str5, str6, str7, str8), new BaseSubscribe<HifiveMusicBean<HifiveMusicSheetModel>>(response) { // from class: com.hifive.sdk.controller.MusicManager$getCompanySheetList$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull HifiveMusicBean<HifiveMusicSheetModel> t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void getCompanySheetMusicAll(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull final DataResponse<List<HifiveMusicModel>> response) {
        s.j(context, "context");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getCompanySheetMusicAll(str, str2, str3), new BaseSubscribe<List<? extends HifiveMusicModel>>(response) { // from class: com.hifive.sdk.controller.MusicManager$getCompanySheetMusicAll$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull List<? extends HifiveMusicModel> t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void getCompanySheetMusicList(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getCompanySheetMusicList(str, str2, str3, str4, str5), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$getCompanySheetMusicList$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void getCompanySheetTagList(@NotNull Context context, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getCompanySheetTagList(), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$getCompanySheetTagList$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void getConfigList(@NotNull Context context, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getConfigList(), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$getConfigList$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final void getMemberSheetList(@NotNull Context context, @Nullable String str, @Nullable String str2, @NotNull final DataResponse<HifiveMusicBean<HifiveMusicUserSheetModel>> response) {
        s.j(context, "context");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getMemberSheetList(str, str2), new BaseSubscribe<HifiveMusicBean<HifiveMusicUserSheetModel>>(response) { // from class: com.hifive.sdk.controller.MusicManager$getMemberSheetList$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull HifiveMusicBean<HifiveMusicUserSheetModel> t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void getMemberSheetMusicAll(@NotNull Context context, @NotNull String sheetId, @Nullable String str, @Nullable String str2, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(sheetId, "sheetId");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getMemberSheetMusicAll(sheetId, str, str2), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$getMemberSheetMusicAll$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void getMemberSheetMusicList(@NotNull Context context, @NotNull String sheetId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull final DataResponse<HifiveMusicBean<HifiveMusicModel>> response) {
        s.j(context, "context");
        s.j(sheetId, "sheetId");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getMemberSheetMusicList(sheetId, str, str2, str3, str4), new BaseSubscribe<HifiveMusicBean<HifiveMusicModel>>(response) { // from class: com.hifive.sdk.controller.MusicManager$getMemberSheetMusicList$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull HifiveMusicBean<HifiveMusicModel> t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void getMusicDetail(@NotNull Context context, @NotNull String musicId, @Nullable String str, @NotNull String mediaType, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull final DataResponse<HifiveMusicDetailModel> response) {
        s.j(context, "context");
        s.j(musicId, "musicId");
        s.j(mediaType, "mediaType");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getMusicDetail(musicId, str, mediaType, str2, str3, str4), new BaseSubscribe<HifiveMusicDetailModel>(response) { // from class: com.hifive.sdk.controller.MusicManager$getMusicDetail$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull HifiveMusicDetailModel t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void getMusicList(@NotNull Context context, @NotNull String searchId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull final DataResponse<HifiveMusicBean<HifiveMusicModel>> response) {
        s.j(context, "context");
        s.j(searchId, "searchId");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getMusicList(searchId, str, str2, str3, str4, str5), new BaseSubscribe<HifiveMusicBean<HifiveMusicModel>>(response) { // from class: com.hifive.sdk.controller.MusicManager$getMusicList$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull HifiveMusicBean<HifiveMusicModel> t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void getSearchRecordList(@NotNull Context context, @Nullable String str, @Nullable String str2, @NotNull final DataResponse<HifiveMusicBean<HifiveMusicSearchrModel>> response) {
        s.j(context, "context");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().getSearchRecordList(str, str2), new BaseSubscribe<HifiveMusicBean<HifiveMusicSearchrModel>>(response) { // from class: com.hifive.sdk.controller.MusicManager$getSearchRecordList$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull HifiveMusicBean<HifiveMusicSearchrModel> t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void memberLogin(@NotNull Context context, @NotNull String memberName, @NotNull final String memberId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(memberName, "memberName");
        s.j(memberId, "memberId");
        s.j(response, "response");
        if (checkNetWork(context)) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String requestDeviceId = Encryption.Companion.requestDeviceId(context);
            StringBuilder sb2 = new StringBuilder();
            HFLiveApi.Companion companion = HFLiveApi.Companion;
            sb2.append(companion.getAPP_ID());
            sb2.append(memberId);
            sb2.append(requestDeviceId);
            sb2.append(valueOf);
            String sb3 = sb2.toString();
            BaseConstance.Companion companion2 = BaseConstance.Companion;
            String secret = companion.getSECRET();
            if (secret == null) {
                s.u();
            }
            String sign = companion2.getSign(secret, sb3);
            String obj = sign != null ? StringsKt__StringsKt.P0(sign).toString() : null;
            ServiceImpl mService = getMService();
            String str9 = obj != null ? obj : "";
            String app_id = companion.getAPP_ID();
            CommonExtKt.request(mService.token(str9, app_id != null ? app_id : "", memberName, memberId, str, str2, requestDeviceId, valueOf, str3, str4, str5, str6, str7, str8), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$memberLogin$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    BaseConstance.Companion companion3 = BaseConstance.Companion;
                    companion3.setMemberOutId(String.this);
                    companion3.setSocietyOutId(null);
                    String string = new JSONObject(t2.toString()).getString(u.cO);
                    if (string == null) {
                        string = "";
                    }
                    companion3.setAccessTokenMember(string);
                    companion3.setAccessTokenUnion(null);
                    DataResponse dataResponse = response;
                    String json = HFLiveApi.Companion.getGson().toJson(t2);
                    s.e(json, "HFLiveApi.gson.toJson(t)");
                    dataResponse.data(json);
                }
            });
        }
    }

    public final void saveMemberSheet(@NotNull Context context, @NotNull String sheetName, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(sheetName, "sheetName");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().saveMemberSheet(sheetName), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$saveMemberSheet$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void saveMemberSheetMusic(@NotNull Context context, @NotNull String sheetId, @NotNull String musicId, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(sheetId, "sheetId");
        s.j(musicId, "musicId");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().saveMemberSheetMusic(sheetId, musicId), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$saveMemberSheetMusic$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void societyLogin(@NotNull Context context, @NotNull String societyName, @NotNull final String societyId, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(societyName, "societyName");
        s.j(societyId, "societyId");
        s.j(response, "response");
        String requestDeviceId = Encryption.Companion.requestDeviceId(context);
        String valueOf = String.valueOf(System.currentTimeMillis());
        StringBuilder sb2 = new StringBuilder();
        HFLiveApi.Companion companion = HFLiveApi.Companion;
        sb2.append(companion.getAPP_ID());
        sb2.append(societyId);
        sb2.append(requestDeviceId);
        sb2.append(valueOf);
        String sb3 = sb2.toString();
        BaseConstance.Companion companion2 = BaseConstance.Companion;
        String secret = companion.getSECRET();
        if (secret == null) {
            s.u();
        }
        String sign = companion2.getSign(secret, sb3);
        String obj = sign != null ? StringsKt__StringsKt.P0(sign).toString() : null;
        if (checkNetWork(context)) {
            byte[] bytes = societyId.getBytes(kotlin.text.c.f51097b);
            s.e(bytes, "(this as java.lang.String).getBytes(charset)");
            String base64societyId = Base64.encodeToString(bytes, 0);
            ServiceImpl mService = getMService();
            if (obj == null) {
                obj = "";
            }
            String str = obj;
            String app_id = companion.getAPP_ID();
            if (app_id == null) {
                s.u();
            }
            s.e(base64societyId, "base64societyId");
            CommonExtKt.request(mService.societyLogin(str, app_id, societyName, base64societyId, requestDeviceId, valueOf), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$societyLogin$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    BaseConstance.Companion companion3 = BaseConstance.Companion;
                    companion3.setMemberOutId(null);
                    companion3.setSocietyOutId(String.this);
                    companion3.setAccessTokenMember(null);
                    String string = new JSONObject(t2.toString()).getString(u.cO);
                    if (string == null) {
                        string = "";
                    }
                    companion3.setAccessTokenUnion(string);
                    DataResponse dataResponse = response;
                    String json = HFLiveApi.Companion.getGson().toJson(t2);
                    s.e(json, "HFLiveApi.gson.toJson(t)");
                    dataResponse.data(json);
                }
            });
        }
    }

    public final void unbindingMember(@NotNull Context context, @NotNull String memberId, @NotNull String societyId, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(memberId, "memberId");
        s.j(societyId, "societyId");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().unbindMember(memberId, societyId), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$unbindingMember$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }

    public final void updateMusicRecord(@NotNull Context context, @NotNull String recordId, @NotNull String duration, @NotNull String mediaType, @NotNull final DataResponse<Object> response) {
        s.j(context, "context");
        s.j(recordId, "recordId");
        s.j(duration, "duration");
        s.j(mediaType, "mediaType");
        s.j(response, "response");
        if (checkNetWork(context)) {
            CommonExtKt.request(getMService().updateMusicRecord(recordId, duration, mediaType), new BaseSubscribe<Object>(response) { // from class: com.hifive.sdk.controller.MusicManager$updateMusicRecord$1
                @Override // com.hifive.sdk.rx.BaseSubscribe
                public void _onNext(@NotNull Object t2) {
                    s.j(t2, "t");
                    DataResponse.this.data(t2);
                }
            });
        }
    }
}
