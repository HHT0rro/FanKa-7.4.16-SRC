package com.hifive.sdk.service.impl;

import com.hifive.sdk.entity.HifiveMusicBean;
import com.hifive.sdk.entity.HifiveMusicChannelModel;
import com.hifive.sdk.entity.HifiveMusicDetailModel;
import com.hifive.sdk.entity.HifiveMusicModel;
import com.hifive.sdk.entity.HifiveMusicSearchrModel;
import com.hifive.sdk.entity.HifiveMusicSheetModel;
import com.hifive.sdk.entity.HifiveMusicUserSheetModel;
import com.hifive.sdk.ext.CommonExtKt;
import com.hifive.sdk.repository.DataRepository;
import com.hifive.sdk.service.Service;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ServiceImpl.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ServiceImpl implements Service {
    public static final /* synthetic */ j[] $$delegatedProperties = {v.h(new PropertyReference1Impl(v.b(ServiceImpl.class), "dataRepository", "getDataRepository()Lcom/hifive/sdk/repository/DataRepository;"))};
    private final Lazy dataRepository$delegate = c.b(new Function0<DataRepository>() { // from class: com.hifive.sdk.service.impl.ServiceImpl$dataRepository$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final DataRepository invoke() {
            return new DataRepository();
        }
    });

    private final DataRepository getDataRepository() {
        Lazy lazy = this.dataRepository$delegate;
        j jVar = $$delegatedProperties[0];
        return (DataRepository) lazy.getValue();
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> bind(@NotNull String memberId, @NotNull String societyId) {
        s.j(memberId, "memberId");
        s.j(societyId, "societyId");
        return CommonExtKt.convert(getDataRepository().bind(memberId, societyId));
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> delete(@NotNull String memberId) {
        s.j(memberId, "memberId");
        return CommonExtKt.convert(getDataRepository().delete(memberId));
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> deleteMemberSheetMusic(@NotNull String sheetId, @NotNull String musicId) {
        s.j(sheetId, "sheetId");
        s.j(musicId, "musicId");
        return CommonExtKt.convert(getDataRepository().deleteMemberSheetMusic(sheetId, musicId));
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> deleteSearchRecord() {
        return CommonExtKt.convert(getDataRepository().deleteSearchRecord());
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> deleteSociety(@NotNull String societyId) {
        s.j(societyId, "societyId");
        return CommonExtKt.convert(getDataRepository().deleteSociety(societyId));
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<List<HifiveMusicChannelModel>> getCompanyChannelList() {
        return getDataRepository().getCompanyChannelList();
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<HifiveMusicBean<HifiveMusicSheetModel>> getCompanySheetList(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        return getDataRepository().getCompanySheetList(str, str2, str3, str4, str5, str6, str7, str8);
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<List<HifiveMusicModel>> getCompanySheetMusicAll(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return getDataRepository().getCompanySheetMusicAll(str, str2, str3);
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> getCompanySheetMusicList(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        return CommonExtKt.convert(getDataRepository().getCompanySheetMusicList(str, str2, str3, str4, str5));
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> getCompanySheetTagList() {
        return CommonExtKt.convert(getDataRepository().getCompanySheetTagList());
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> getConfigList() {
        return CommonExtKt.convert(getDataRepository().getConfigList());
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<HifiveMusicBean<HifiveMusicUserSheetModel>> getMemberSheetList(@Nullable String str, @Nullable String str2) {
        return getDataRepository().getMemberSheetList(str, str2);
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> getMemberSheetMusicAll(@NotNull String sheetId, @Nullable String str, @Nullable String str2) {
        s.j(sheetId, "sheetId");
        return CommonExtKt.convert(getDataRepository().getMemberSheetMusicAll(sheetId, str, str2));
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<HifiveMusicBean<HifiveMusicModel>> getMemberSheetMusicList(@NotNull String sheetId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        s.j(sheetId, "sheetId");
        return getDataRepository().getMemberSheetMusicList(sheetId, str, str2, str3, str4);
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<HifiveMusicDetailModel> getMusicDetail(@NotNull String musicId, @Nullable String str, @NotNull String mediaType, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        s.j(musicId, "musicId");
        s.j(mediaType, "mediaType");
        return getDataRepository().getMusicDetail(musicId, str, mediaType, str2, str3, str4);
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<HifiveMusicBean<HifiveMusicModel>> getMusicList(@NotNull String searchId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        s.j(searchId, "searchId");
        return getDataRepository().getMusicList(searchId, str, str2, str3, str4, str5);
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<HifiveMusicBean<HifiveMusicSearchrModel>> getSearchRecordList(@Nullable String str, @Nullable String str2) {
        return getDataRepository().getSearchRecordList(str, str2);
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> saveMemberSheet(@NotNull String sheetName) {
        s.j(sheetName, "sheetName");
        return CommonExtKt.convert(getDataRepository().saveMemberSheet(sheetName));
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> saveMemberSheetMusic(@NotNull String sheetId, @NotNull String musicId) {
        s.j(sheetId, "sheetId");
        s.j(musicId, "musicId");
        return CommonExtKt.convert(getDataRepository().saveMemberSheetMusic(sheetId, musicId));
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> societyLogin(@NotNull String sign, @NotNull String appId, @NotNull String societyName, @NotNull String societyId, @NotNull String deviceId, @NotNull String timestamp) {
        s.j(sign, "sign");
        s.j(appId, "appId");
        s.j(societyName, "societyName");
        s.j(societyId, "societyId");
        s.j(deviceId, "deviceId");
        s.j(timestamp, "timestamp");
        return CommonExtKt.convert(getDataRepository().societyLogin(sign, appId, societyName, societyId, deviceId, timestamp));
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> token(@NotNull String sign, @NotNull String appId, @NotNull String memberName, @NotNull String memberId, @Nullable String str, @Nullable String str2, @NotNull String deviceId, @NotNull String timestamp, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        s.j(sign, "sign");
        s.j(appId, "appId");
        s.j(memberName, "memberName");
        s.j(memberId, "memberId");
        s.j(deviceId, "deviceId");
        s.j(timestamp, "timestamp");
        return CommonExtKt.convert(getDataRepository().token(sign, appId, memberName, memberId, str, str2, deviceId, timestamp, str3, str4, str5, str6, str7, str8));
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> unbindMember(@NotNull String memberId, @NotNull String societyId) {
        s.j(memberId, "memberId");
        s.j(societyId, "societyId");
        return CommonExtKt.convert(getDataRepository().unbindingMember(memberId, societyId));
    }

    @Override // com.hifive.sdk.service.Service
    @NotNull
    public Flowable<Object> updateMusicRecord(@NotNull String recordId, @NotNull String duration, @NotNull String mediaType) {
        s.j(recordId, "recordId");
        s.j(duration, "duration");
        s.j(mediaType, "mediaType");
        return CommonExtKt.convert(getDataRepository().updateMusicRecord(recordId, duration, mediaType));
    }
}
