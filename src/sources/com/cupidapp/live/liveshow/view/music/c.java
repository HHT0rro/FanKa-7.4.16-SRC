package com.cupidapp.live.liveshow.view.music;

import android.app.Application;
import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.view.music.model.MusicDataResult;
import com.cupidapp.live.liveshow.view.music.model.MusicListViewModel;
import com.cupidapp.live.liveshow.view.music.model.MusicSheetModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hailiang.advlib.core.ADEvent;
import com.hifive.sdk.common.HFLiveCallback;
import com.hifive.sdk.controller.MusicManager;
import com.hifive.sdk.entity.HifiveMusicBean;
import com.hifive.sdk.entity.HifiveMusicDetailModel;
import com.hifive.sdk.entity.HifiveMusicModel;
import com.hifive.sdk.entity.HifiveMusicSheetModel;
import com.hifive.sdk.hInterface.DataResponse;
import com.hifive.sdk.manager.HFLiveApi;
import com.hifive.sdk.rx.BaseException;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* compiled from: FKLiveMusicUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f15798a = new c();

    /* compiled from: FKLiveMusicUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements DataResponse<HifiveMusicBean<HifiveMusicSheetModel>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicSheetModel>> f15799a;

        public a(com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicSheetModel>> dVar) {
            this.f15799a = dVar;
        }

        @Override // com.hifive.sdk.hInterface.DataResponse
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void data(@NotNull HifiveMusicBean<HifiveMusicSheetModel> any) {
            s.i(any, "any");
            com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicSheetModel>> dVar = this.f15799a;
            List<HifiveMusicSheetModel> records = any.getRecords();
            s.h(records, "any.records");
            ArrayList arrayList = new ArrayList(t.t(records, 10));
            for (HifiveMusicSheetModel hifiveMusicSheetModel : records) {
                String valueOf = String.valueOf(hifiveMusicSheetModel.getSheetId());
                String sheetName = hifiveMusicSheetModel.getSheetName();
                s.h(sheetName, "it.sheetName");
                arrayList.add(new MusicSheetModel(valueOf, sheetName));
            }
            dVar.success(new MusicDataResult<>(arrayList, any.getTotalPage(), any.getCurrentPage(), false, 8, null));
        }

        @Override // com.hifive.sdk.hInterface.DataResponse
        public void errorMsg(@NotNull String string, @Nullable Integer num) {
            s.i(string, "string");
            this.f15799a.a(string, num);
        }
    }

    /* compiled from: FKLiveMusicUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements DataResponse<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicListViewModel>> f15800a;

        /* compiled from: FKLiveMusicUtil.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class a extends TypeToken<HifiveMusicBean<HifiveMusicModel>> {
        }

        public b(com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicListViewModel>> dVar) {
            this.f15800a = dVar;
        }

        @Override // com.hifive.sdk.hInterface.DataResponse
        public void data(@NotNull Object any) {
            s.i(any, "any");
            Gson b4 = GsonUtil.f12000a.b();
            HifiveMusicBean hifiveMusicBean = (HifiveMusicBean) b4.fromJson(b4.toJson(any), new a().getType());
            com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicListViewModel>> dVar = this.f15800a;
            List<HifiveMusicModel> records = hifiveMusicBean.getRecords();
            s.h(records, "musicListResult.records");
            ArrayList arrayList = new ArrayList(t.t(records, 10));
            for (HifiveMusicModel it : records) {
                s.h(it, "it");
                arrayList.add(new MusicListViewModel(it, FKLiveMusicFragment.f15772i.a(it.getMusicId())));
            }
            dVar.success(new MusicDataResult<>(arrayList, hifiveMusicBean.getTotalPage(), hifiveMusicBean.getCurrentPage(), false, 8, null));
        }

        @Override // com.hifive.sdk.hInterface.DataResponse
        public void errorMsg(@NotNull String string, @Nullable Integer num) {
            s.i(string, "string");
            this.f15800a.a(string, num);
        }
    }

    /* compiled from: FKLiveMusicUtil.kt */
    @kotlin.d
    /* renamed from: com.cupidapp.live.liveshow.view.music.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0160c implements DataResponse<HifiveMusicDetailModel> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.cupidapp.live.liveshow.view.music.d<HifiveMusicDetailModel> f15801a;

        public C0160c(com.cupidapp.live.liveshow.view.music.d<HifiveMusicDetailModel> dVar) {
            this.f15801a = dVar;
        }

        @Override // com.hifive.sdk.hInterface.DataResponse
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void data(@NotNull HifiveMusicDetailModel any) {
            s.i(any, "any");
            this.f15801a.success(any);
        }

        @Override // com.hifive.sdk.hInterface.DataResponse
        public void errorMsg(@NotNull String string, @Nullable Integer num) {
            s.i(string, "string");
            this.f15801a.a(string, num);
        }
    }

    /* compiled from: FKLiveMusicUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements DataResponse<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.cupidapp.live.liveshow.view.music.d<String> f15802a;

        public d(com.cupidapp.live.liveshow.view.music.d<String> dVar) {
            this.f15802a = dVar;
        }

        @Override // com.hifive.sdk.hInterface.DataResponse
        public void data(@NotNull Object any) {
            s.i(any, "any");
            String accessToken = new JSONObject(any.toString()).getString(u.cO);
            com.cupidapp.live.liveshow.view.music.d<String> dVar = this.f15802a;
            s.h(accessToken, "accessToken");
            dVar.success(accessToken);
        }

        @Override // com.hifive.sdk.hInterface.DataResponse
        public void errorMsg(@NotNull String string, @Nullable Integer num) {
            s.i(string, "string");
            this.f15802a.a(string, num);
        }
    }

    /* compiled from: FKLiveMusicUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e implements com.cupidapp.live.liveshow.view.music.d<HifiveMusicDetailModel> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15803a;

        public e(Context context) {
            this.f15803a = context;
        }

        @Override // com.cupidapp.live.liveshow.view.music.d
        public void a(@NotNull String string, @Nullable Integer num) {
            s.i(string, "string");
            h.f12779a.r(this.f15803a, R$string.music_load_failed);
        }

        @Override // com.cupidapp.live.liveshow.view.music.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull HifiveMusicDetailModel data) {
            s.i(data, "data");
            FKLiveMusicFragment.f15772i.d(data);
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            fKLiveUtil.x(data.getDuration());
            String url = data.getFile().getUrl();
            s.h(url, "data.file.url");
            fKLiveUtil.B(url);
        }
    }

    /* compiled from: FKLiveMusicUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class f implements HFLiveCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f15804a;

        public f(Application application) {
            this.f15804a = application;
        }

        @Override // com.hifive.sdk.common.HFLiveCallback
        public void onError(@NotNull BaseException exception) {
            s.i(exception, "exception");
            h.f12779a.r(this.f15804a, R$string.network_error);
        }

        @Override // com.hifive.sdk.common.HFLiveCallback
        public void onSuccess() {
        }
    }

    /* compiled from: FKLiveMusicUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class g implements DataResponse<HifiveMusicBean<HifiveMusicModel>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicListViewModel>> f15805a;

        public g(com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicListViewModel>> dVar) {
            this.f15805a = dVar;
        }

        @Override // com.hifive.sdk.hInterface.DataResponse
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void data(@NotNull HifiveMusicBean<HifiveMusicModel> any) {
            s.i(any, "any");
            com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicListViewModel>> dVar = this.f15805a;
            List<HifiveMusicModel> records = any.getRecords();
            s.h(records, "any.records");
            ArrayList arrayList = new ArrayList(t.t(records, 10));
            for (HifiveMusicModel it : records) {
                s.h(it, "it");
                arrayList.add(new MusicListViewModel(it, FKLiveMusicFragment.f15772i.a(it.getMusicId())));
            }
            dVar.success(new MusicDataResult<>(arrayList, any.getTotalPage(), any.getCurrentPage(), any.isRecommand()));
        }

        @Override // com.hifive.sdk.hInterface.DataResponse
        public void errorMsg(@NotNull String string, @Nullable Integer num) {
            s.i(string, "string");
            this.f15805a.a(string, num);
        }
    }

    public final void a(@Nullable Context context, @NotNull com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicSheetModel>> dataResponse) {
        MusicManager companion;
        s.i(dataResponse, "dataResponse");
        if (context == null || (companion = HFLiveApi.Companion.getInstance()) == null) {
            return;
        }
        companion.getCompanySheetList(context, null, null, null, null, null, null, ADEvent.PRICE_FILTER, null, new a(dataResponse));
    }

    public final void b(@Nullable Context context, @NotNull String sheetId, int i10, @NotNull com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicListViewModel>> dataResponse) {
        MusicManager companion;
        s.i(sheetId, "sheetId");
        s.i(dataResponse, "dataResponse");
        if (context == null || (companion = HFLiveApi.Companion.getInstance()) == null) {
            return;
        }
        companion.getCompanySheetMusicList(context, sheetId, null, FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST, null, String.valueOf(i10), new b(dataResponse));
    }

    public final void c(Context context, String str, com.cupidapp.live.liveshow.view.music.d<HifiveMusicDetailModel> dVar) {
        MusicManager companion;
        if (context == null || (companion = HFLiveApi.Companion.getInstance()) == null) {
            return;
        }
        companion.getMusicDetail(context, str, null, "2", null, null, FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST, new C0160c(dVar));
    }

    public final void d(@Nullable Context context, @NotNull String memberName, @NotNull String memberId, @NotNull com.cupidapp.live.liveshow.view.music.d<String> dataResponse) {
        MusicManager companion;
        s.i(memberName, "memberName");
        s.i(memberId, "memberId");
        s.i(dataResponse, "dataResponse");
        if (context == null || (companion = HFLiveApi.Companion.getInstance()) == null) {
            return;
        }
        companion.memberLogin(context, memberName, memberId, null, null, null, null, null, null, null, null, new d(dataResponse));
    }

    public final void e(@Nullable Context context, @NotNull String musicId) {
        s.i(musicId, "musicId");
        c(context, musicId, new e(context));
    }

    public final void f(@NotNull Application context) {
        ConstantsUrlModel urlModel;
        s.i(context, "context");
        ConstantsResult q10 = p1.g.f52734a.q();
        String liveShowMusicDomain = (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getLiveShowMusicDomain();
        if (liveShowMusicDomain == null || liveShowMusicDomain.length() == 0) {
            liveShowMusicDomain = "https://gateway-open.haifanwu.com";
        }
        HFLiveApi.Companion companion = HFLiveApi.Companion;
        companion.registerApp(context, liveShowMusicDomain);
        companion.configCallBack(new f(context));
    }

    public final void g(@Nullable Context context, @NotNull String keyword, int i10, @NotNull com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicListViewModel>> dataResponse) {
        MusicManager companion;
        s.i(keyword, "keyword");
        s.i(dataResponse, "dataResponse");
        if (context == null || (companion = HFLiveApi.Companion.getInstance()) == null) {
            return;
        }
        companion.getMusicList(context, "1", keyword, null, FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST, null, String.valueOf(i10), new g(dataResponse));
    }
}
