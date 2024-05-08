package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyMatchConfigResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum MaskPartyType {
    MessageChat(1, "SECRET_LOUNGE"),
    ScriptKill(2, "DOUBLE_PLAY"),
    VoiceChat(20, "VOICE_CHAT");


    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private final String gameName;
    private final int type;

    /* compiled from: MaskPartyMatchConfigResult.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final MaskPartyType a(@Nullable Integer num) {
            MaskPartyType maskPartyType = MaskPartyType.MessageChat;
            int type = maskPartyType.getType();
            if (num != null && num.intValue() == type) {
                return maskPartyType;
            }
            MaskPartyType maskPartyType2 = MaskPartyType.ScriptKill;
            int type2 = maskPartyType2.getType();
            if (num != null && num.intValue() == type2) {
                return maskPartyType2;
            }
            MaskPartyType maskPartyType3 = MaskPartyType.VoiceChat;
            int type3 = maskPartyType3.getType();
            if (num != null && num.intValue() == type3) {
                return maskPartyType3;
            }
            return null;
        }
    }

    MaskPartyType(int i10, String str) {
        this.type = i10;
        this.gameName = str;
    }

    @NotNull
    public final String getGameName() {
        return this.gameName;
    }

    public final int getType() {
        return this.type;
    }
}
