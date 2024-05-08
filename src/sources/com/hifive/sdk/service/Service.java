package com.hifive.sdk.service;

import com.hifive.sdk.entity.HifiveMusicBean;
import com.hifive.sdk.entity.HifiveMusicChannelModel;
import com.hifive.sdk.entity.HifiveMusicDetailModel;
import com.hifive.sdk.entity.HifiveMusicModel;
import com.hifive.sdk.entity.HifiveMusicSearchrModel;
import com.hifive.sdk.entity.HifiveMusicSheetModel;
import com.hifive.sdk.entity.HifiveMusicUserSheetModel;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Service.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface Service {
    @NotNull
    Flowable<Object> bind(@NotNull String str, @NotNull String str2);

    @NotNull
    Flowable<Object> delete(@NotNull String str);

    @NotNull
    Flowable<Object> deleteMemberSheetMusic(@NotNull String str, @NotNull String str2);

    @NotNull
    Flowable<Object> deleteSearchRecord();

    @NotNull
    Flowable<Object> deleteSociety(@NotNull String str);

    @NotNull
    Flowable<List<HifiveMusicChannelModel>> getCompanyChannelList();

    @NotNull
    Flowable<HifiveMusicBean<HifiveMusicSheetModel>> getCompanySheetList(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8);

    @NotNull
    Flowable<List<HifiveMusicModel>> getCompanySheetMusicAll(@Nullable String str, @Nullable String str2, @Nullable String str3);

    @NotNull
    Flowable<Object> getCompanySheetMusicList(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5);

    @NotNull
    Flowable<Object> getCompanySheetTagList();

    @NotNull
    Flowable<Object> getConfigList();

    @NotNull
    Flowable<HifiveMusicBean<HifiveMusicUserSheetModel>> getMemberSheetList(@Nullable String str, @Nullable String str2);

    @NotNull
    Flowable<Object> getMemberSheetMusicAll(@NotNull String str, @Nullable String str2, @Nullable String str3);

    @NotNull
    Flowable<HifiveMusicBean<HifiveMusicModel>> getMemberSheetMusicList(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5);

    @NotNull
    Flowable<HifiveMusicDetailModel> getMusicDetail(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6);

    @NotNull
    Flowable<HifiveMusicBean<HifiveMusicModel>> getMusicList(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6);

    @NotNull
    Flowable<HifiveMusicBean<HifiveMusicSearchrModel>> getSearchRecordList(@Nullable String str, @Nullable String str2);

    @NotNull
    Flowable<Object> saveMemberSheet(@NotNull String str);

    @NotNull
    Flowable<Object> saveMemberSheetMusic(@NotNull String str, @NotNull String str2);

    @NotNull
    Flowable<Object> societyLogin(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6);

    @NotNull
    Flowable<Object> token(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6, @NotNull String str7, @NotNull String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14);

    @NotNull
    Flowable<Object> unbindMember(@NotNull String str, @NotNull String str2);

    @NotNull
    Flowable<Object> updateMusicRecord(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
