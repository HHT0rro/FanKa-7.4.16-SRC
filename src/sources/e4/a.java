package e4;

import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.maskparty.model.QuitRoomModel;
import com.cupidapp.live.voiceparty.model.VoicePartyQuestionModel;
import com.cupidapp.live.voiceparty.model.VoicePartyRoomDissolveModel;
import com.cupidapp.live.voiceparty.model.VoicePartyRoomModel;
import io.reactivex.Observable;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import ne.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoicePartyService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a {
    @o("/mask-match/audio/select-question")
    @e
    @NotNull
    Observable<Result<Object>> a(@c("roomId") @NotNull String str, @c("index") int i10);

    @o("/mask-match/question-type")
    @e
    @NotNull
    Observable<Result<Object>> b(@c("roomId") @NotNull String str, @c("type") int i10);

    @o("/mask-match/audio/game-invite")
    @e
    @NotNull
    Observable<Result<Object>> c(@c("roomId") @NotNull String str);

    @o("/mask-match/audio/invite-follow")
    @e
    @NotNull
    Observable<Result<Object>> d(@c("roomId") @NotNull String str, @c("targetUserId") @NotNull String str2);

    @o("mask-match/audio/disband-room")
    @e
    @NotNull
    Observable<Result<VoicePartyRoomDissolveModel>> e(@c("roomId") @NotNull String str, @c("level") int i10);

    @f("/mask-match/leave-room")
    @NotNull
    Observable<Result<QuitRoomModel>> f(@t("roomId") @NotNull String str, @t("costTime") @Nullable Integer num);

    @o("/mask-match/audio/agree-invite")
    @e
    @NotNull
    Observable<Result<Object>> g(@c("roomId") @NotNull String str);

    @o("/mask-match/audio/show-profile")
    @e
    @NotNull
    Observable<Result<Object>> h(@c("roomId") @NotNull String str);

    @f("/mask-match/question-list")
    @NotNull
    Observable<Result<ListResult<VoicePartyQuestionModel>>> i(@t("roomId") @NotNull String str, @t("type") int i10);

    @o("/mask-match/audio/confirm-question")
    @e
    @NotNull
    Observable<Result<Object>> j(@c("roomId") @NotNull String str, @c("confirm") boolean z10);

    @f("/mask-match/audio/chat-room")
    @NotNull
    Observable<Result<VoicePartyRoomModel>> k(@t("roomId") @NotNull String str);
}
