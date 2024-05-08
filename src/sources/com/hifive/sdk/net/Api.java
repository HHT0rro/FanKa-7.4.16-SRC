package com.hifive.sdk.net;

import com.hifive.sdk.entity.HifiveMusicBean;
import com.hifive.sdk.entity.HifiveMusicChannelModel;
import com.hifive.sdk.entity.HifiveMusicDetailModel;
import com.hifive.sdk.entity.HifiveMusicModel;
import com.hifive.sdk.entity.HifiveMusicSearchrModel;
import com.hifive.sdk.entity.HifiveMusicSheetModel;
import com.hifive.sdk.entity.HifiveMusicUserSheetModel;
import com.hifive.sdk.protocol.BaseResp;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import ne.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Api.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface Api {
    @o("/livestream/v1/member/bindingMember")
    @e
    @NotNull
    Flowable<BaseResp<Object>> bind(@c("memberId") @NotNull String str, @c("sociatyId") @NotNull String str2);

    @o("/livestream/v1/member/deleteMember")
    @e
    @NotNull
    Flowable<BaseResp<Object>> delete(@c("memberId") @NotNull String str);

    @o("/livestream/v1/member/music/deleteMemberSheetMusic")
    @e
    @NotNull
    Flowable<BaseResp<Object>> deleteMemberSheetMusic(@c("sheetId") @NotNull String str, @c("musicId") @NotNull String str2);

    @o("/livestream/v1/search/deleteSearchRecord")
    @NotNull
    Flowable<BaseResp<Object>> deleteSearchRecord();

    @o("/livestream/v1/member/deleteSociaty")
    @e
    @NotNull
    Flowable<BaseResp<Object>> deleteSociaty(@c("sociatyId") @NotNull String str);

    @f("/livestream/v1/company/getCompanyChannelList")
    @NotNull
    Flowable<BaseResp<List<HifiveMusicChannelModel>>> getCompanyChannelList();

    @o("/livestream/v1/company/getCompanySheetList")
    @e
    @NotNull
    Flowable<BaseResp<HifiveMusicBean<HifiveMusicSheetModel>>> getCompanySheetList(@c("channelId") @Nullable String str, @c("language") @Nullable String str2, @c("recoNum") @Nullable String str3, @c("type") @Nullable String str4, @c("tagIdList") @Nullable String str5, @c("field") @Nullable String str6, @c("pageSize") @Nullable String str7, @c("page") @Nullable String str8);

    @o("/livestream/v1/company/getCompanySheetMusicAll")
    @e
    @NotNull
    Flowable<BaseResp<List<HifiveMusicModel>>> getCompanySheetMusicAll(@c("sheetId") @Nullable String str, @c("language") @Nullable String str2, @c("field") @Nullable String str3);

    @o("/livestream/v1/company/getCompanySheetMusicList")
    @e
    @NotNull
    Flowable<BaseResp<Object>> getCompanySheetMusicList(@c("sheetId") @Nullable String str, @c("language") @Nullable String str2, @c("field") @Nullable String str3, @c("pageSize") @Nullable String str4, @c("page") @Nullable String str5);

    @f("/livestream/v1/company/getCompanySheetTagList")
    @NotNull
    Flowable<BaseResp<Object>> getCompanySheetTagList();

    @f("/livestream/v1/search/getConfigList")
    @NotNull
    Flowable<BaseResp<Object>> getConfigList();

    @o("/livestream/v1/member/music/getMemberSheetList")
    @e
    @NotNull
    Flowable<BaseResp<HifiveMusicBean<HifiveMusicUserSheetModel>>> getMemberSheetList(@c("page") @Nullable String str, @c("pageSize") @Nullable String str2);

    @o("/livestream/v1/search/getMusicList")
    @e
    @NotNull
    Flowable<BaseResp<Object>> getMemberSheetMusicAll(@c("sheetId") @NotNull String str, @c("language") @Nullable String str2, @c("field") @Nullable String str3);

    @o("/livestream/v1/member/music/getMemberSheetMusicList")
    @e
    @NotNull
    Flowable<BaseResp<HifiveMusicBean<HifiveMusicModel>>> getMemberSheetMusicList(@c("sheetId") @NotNull String str, @c("language") @Nullable String str2, @c("field") @Nullable String str3, @c("pageSize") @Nullable String str4, @c("page") @Nullable String str5);

    @o("/livestream/v1/member/music/getMusicDetail")
    @e
    @NotNull
    Flowable<BaseResp<HifiveMusicDetailModel>> getMusicDetail(@c("musicId") @NotNull String str, @c("language") @Nullable String str2, @c("mediaType") @NotNull String str3, @c("audioFormat") @Nullable String str4, @c("audioRate") @Nullable String str5, @c("field") @Nullable String str6);

    @o("/livestream/v1/search/getMusicList")
    @e
    @NotNull
    Flowable<BaseResp<HifiveMusicBean<HifiveMusicModel>>> getMusicList(@c("searchId") @NotNull String str, @c("keyword") @Nullable String str2, @c("language") @Nullable String str3, @c("field") @Nullable String str4, @c("pageSize") @Nullable String str5, @c("page") @Nullable String str6);

    @f("/livestream/v1/search/getSearchRecordList")
    @NotNull
    Flowable<BaseResp<HifiveMusicBean<HifiveMusicSearchrModel>>> getSearchRecordList(@t("pageSize") @Nullable String str, @t("page") @Nullable String str2);

    @o("/livestream/v1/member/music/saveMemberSheet")
    @e
    @NotNull
    Flowable<BaseResp<Object>> saveMemberSheet(@c("sheetName") @NotNull String str);

    @o("/livestream/v1/member/music/saveMemberSheetMusic")
    @e
    @NotNull
    Flowable<BaseResp<Object>> saveMemberSheetMusic(@c("sheetId") @NotNull String str, @c("musicId") @NotNull String str2);

    @o("/livestream/v1/member/sociatyLogin")
    @e
    @NotNull
    Flowable<BaseResp<Object>> societyLogin(@c("sign") @NotNull String str, @c("appId") @NotNull String str2, @c("sociatyName") @NotNull String str3, @c("sociatyId") @NotNull String str4, @c("deviceId") @Nullable String str5, @c("timestamp") @Nullable String str6);

    @o("/livestream/v1/member/memberLogin")
    @e
    @NotNull
    Flowable<BaseResp<Object>> token(@c("sign") @NotNull String str, @c("appId") @NotNull String str2, @c("memberName") @NotNull String str3, @c("memberId") @NotNull String str4, @c("sociatyName") @Nullable String str5, @c("sociatyId") @Nullable String str6, @c("deviceId") @NotNull String str7, @c("timestamp") @NotNull String str8, @c("headerUrl") @Nullable String str9, @c("gender") @Nullable String str10, @c("birthday") @Nullable String str11, @c("location") @Nullable String str12, @c("favoriteSinger") @Nullable String str13, @c("phone") @Nullable String str14);

    @o("/livestream/v1/member/unbundlingMember")
    @e
    @NotNull
    Flowable<BaseResp<Object>> unbendingMember(@c("memberId") @NotNull String str, @c("sociatyId") @NotNull String str2);

    @o("/livestream/v1/member/record/updateMusicRecord")
    @e
    @NotNull
    Flowable<BaseResp<Object>> updateMusicRecord(@c("recordId") @NotNull String str, @c("duration") @NotNull String str2, @c("mediaType") @NotNull String str3);
}
