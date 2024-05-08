package com.hifive.sdk.repository;

import com.hifive.sdk.entity.HifiveMusicBean;
import com.hifive.sdk.entity.HifiveMusicChannelModel;
import com.hifive.sdk.entity.HifiveMusicDetailModel;
import com.hifive.sdk.entity.HifiveMusicModel;
import com.hifive.sdk.entity.HifiveMusicSearchrModel;
import com.hifive.sdk.entity.HifiveMusicSheetModel;
import com.hifive.sdk.entity.HifiveMusicUserSheetModel;
import com.hifive.sdk.ext.CommonExtKt;
import com.hifive.sdk.net.LiveRetrofitFactory;
import com.hifive.sdk.protocol.BaseResp;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DataRepository.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class DataRepository {
    @NotNull
    public final Flowable<BaseResp<Object>> bind(@NotNull String memberId, @NotNull String societyId) {
        s.j(memberId, "memberId");
        s.j(societyId, "societyId");
        return LiveRetrofitFactory.Companion.api().bind(memberId, societyId);
    }

    @NotNull
    public final Flowable<BaseResp<Object>> delete(@NotNull String memberId) {
        s.j(memberId, "memberId");
        return LiveRetrofitFactory.Companion.api().delete(memberId);
    }

    @NotNull
    public final Flowable<BaseResp<Object>> deleteMemberSheetMusic(@NotNull String sheetId, @NotNull String musicId) {
        s.j(sheetId, "sheetId");
        s.j(musicId, "musicId");
        return LiveRetrofitFactory.Companion.api().deleteMemberSheetMusic(sheetId, musicId);
    }

    @NotNull
    public final Flowable<BaseResp<Object>> deleteSearchRecord() {
        return LiveRetrofitFactory.Companion.api().deleteSearchRecord();
    }

    @NotNull
    public final Flowable<BaseResp<Object>> deleteSociety(@NotNull String societyId) {
        s.j(societyId, "societyId");
        return LiveRetrofitFactory.Companion.api().deleteSociaty(societyId);
    }

    @NotNull
    public final Flowable<List<HifiveMusicChannelModel>> getCompanyChannelList() {
        return CommonExtKt.convert(LiveRetrofitFactory.Companion.api().getCompanyChannelList());
    }

    @NotNull
    public final Flowable<HifiveMusicBean<HifiveMusicSheetModel>> getCompanySheetList(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        return CommonExtKt.convert(LiveRetrofitFactory.Companion.api().getCompanySheetList(str, str2, str3, str4, str5, str6, str7, str8));
    }

    @NotNull
    public final Flowable<List<HifiveMusicModel>> getCompanySheetMusicAll(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return CommonExtKt.convert(LiveRetrofitFactory.Companion.api().getCompanySheetMusicAll(str, str2, str3));
    }

    @NotNull
    public final Flowable<BaseResp<Object>> getCompanySheetMusicList(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        return LiveRetrofitFactory.Companion.api().getCompanySheetMusicList(str, str2, str3, str4, str5);
    }

    @NotNull
    public final Flowable<BaseResp<Object>> getCompanySheetTagList() {
        return LiveRetrofitFactory.Companion.api().getCompanySheetTagList();
    }

    @NotNull
    public final Flowable<BaseResp<Object>> getConfigList() {
        return LiveRetrofitFactory.Companion.api().getConfigList();
    }

    @NotNull
    public final Flowable<HifiveMusicBean<HifiveMusicUserSheetModel>> getMemberSheetList(@Nullable String str, @Nullable String str2) {
        return CommonExtKt.convert(LiveRetrofitFactory.Companion.api().getMemberSheetList(str, str2));
    }

    @NotNull
    public final Flowable<BaseResp<Object>> getMemberSheetMusicAll(@NotNull String sheetId, @Nullable String str, @Nullable String str2) {
        s.j(sheetId, "sheetId");
        return LiveRetrofitFactory.Companion.api().getMemberSheetMusicAll(sheetId, str, str2);
    }

    @NotNull
    public final Flowable<HifiveMusicBean<HifiveMusicModel>> getMemberSheetMusicList(@NotNull String sheetId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        s.j(sheetId, "sheetId");
        return CommonExtKt.convert(LiveRetrofitFactory.Companion.api().getMemberSheetMusicList(sheetId, str, str2, str3, str4));
    }

    @NotNull
    public final Flowable<HifiveMusicDetailModel> getMusicDetail(@NotNull String musicId, @Nullable String str, @NotNull String mediaType, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        s.j(musicId, "musicId");
        s.j(mediaType, "mediaType");
        return CommonExtKt.convert(LiveRetrofitFactory.Companion.api().getMusicDetail(musicId, str, mediaType, str2, str3, str4));
    }

    @NotNull
    public final Flowable<HifiveMusicBean<HifiveMusicModel>> getMusicList(@NotNull String searchId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        s.j(searchId, "searchId");
        return CommonExtKt.convert(LiveRetrofitFactory.Companion.api().getMusicList(searchId, str, str2, str3, str4, str5));
    }

    @NotNull
    public final Flowable<HifiveMusicBean<HifiveMusicSearchrModel>> getSearchRecordList(@Nullable String str, @Nullable String str2) {
        return CommonExtKt.convert(LiveRetrofitFactory.Companion.api().getSearchRecordList(str, str2));
    }

    @NotNull
    public final Flowable<BaseResp<Object>> saveMemberSheet(@NotNull String sheetName) {
        s.j(sheetName, "sheetName");
        return LiveRetrofitFactory.Companion.api().saveMemberSheet(sheetName);
    }

    @NotNull
    public final Flowable<BaseResp<Object>> saveMemberSheetMusic(@NotNull String sheetId, @NotNull String musicId) {
        s.j(sheetId, "sheetId");
        s.j(musicId, "musicId");
        return LiveRetrofitFactory.Companion.api().saveMemberSheetMusic(sheetId, musicId);
    }

    @NotNull
    public final Flowable<BaseResp<Object>> societyLogin(@NotNull String sign, @NotNull String appId, @NotNull String societyName, @NotNull String societyId, @NotNull String deviceId, @NotNull String timestamp) {
        s.j(sign, "sign");
        s.j(appId, "appId");
        s.j(societyName, "societyName");
        s.j(societyId, "societyId");
        s.j(deviceId, "deviceId");
        s.j(timestamp, "timestamp");
        return LiveRetrofitFactory.Companion.api().societyLogin(sign, appId, societyName, societyId, deviceId, timestamp);
    }

    @NotNull
    public final Flowable<BaseResp<Object>> token(@NotNull String sign, @NotNull String appId, @NotNull String memberName, @NotNull String memberId, @Nullable String str, @Nullable String str2, @NotNull String deviceId, @NotNull String timestamp, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        s.j(sign, "sign");
        s.j(appId, "appId");
        s.j(memberName, "memberName");
        s.j(memberId, "memberId");
        s.j(deviceId, "deviceId");
        s.j(timestamp, "timestamp");
        return LiveRetrofitFactory.Companion.api().token(sign, appId, memberName, memberId, str, str2, deviceId, timestamp, str3, str4, str5, str6, str7, str8);
    }

    @NotNull
    public final Flowable<BaseResp<Object>> unbindingMember(@NotNull String memberId, @NotNull String societyId) {
        s.j(memberId, "memberId");
        s.j(societyId, "societyId");
        return LiveRetrofitFactory.Companion.api().unbendingMember(memberId, societyId);
    }

    @NotNull
    public final Flowable<BaseResp<Object>> updateMusicRecord(@NotNull String recordId, @NotNull String duration, @NotNull String mediaType) {
        s.j(recordId, "recordId");
        s.j(duration, "duration");
        s.j(mediaType, "mediaType");
        return LiveRetrofitFactory.Companion.api().updateMusicRecord(recordId, duration, mediaType);
    }
}
