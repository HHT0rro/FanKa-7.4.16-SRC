package com.cupidapp.live.chat2.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SurveyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatMessageModel {

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f13413id;

    @NotNull
    private final KeyMsgModel msglinkDict;

    @Nullable
    private final List<SurveyChatOptionsModel> options;

    @Nullable
    private final String text;
    private final int type;

    public SurveyChatMessageModel(@NotNull String id2, int i10, @Nullable String str, @Nullable List<SurveyChatOptionsModel> list, @NotNull KeyMsgModel msglinkDict) {
        s.i(id2, "id");
        s.i(msglinkDict, "msglinkDict");
        this.f13413id = id2;
        this.type = i10;
        this.text = str;
        this.options = list;
        this.msglinkDict = msglinkDict;
    }

    public static /* synthetic */ SurveyChatMessageModel copy$default(SurveyChatMessageModel surveyChatMessageModel, String str, int i10, String str2, List list, KeyMsgModel keyMsgModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = surveyChatMessageModel.f13413id;
        }
        if ((i11 & 2) != 0) {
            i10 = surveyChatMessageModel.type;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            str2 = surveyChatMessageModel.text;
        }
        String str3 = str2;
        if ((i11 & 8) != 0) {
            list = surveyChatMessageModel.options;
        }
        List list2 = list;
        if ((i11 & 16) != 0) {
            keyMsgModel = surveyChatMessageModel.msglinkDict;
        }
        return surveyChatMessageModel.copy(str, i12, str3, list2, keyMsgModel);
    }

    @NotNull
    public final String component1() {
        return this.f13413id;
    }

    public final int component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.text;
    }

    @Nullable
    public final List<SurveyChatOptionsModel> component4() {
        return this.options;
    }

    @NotNull
    public final KeyMsgModel component5() {
        return this.msglinkDict;
    }

    @NotNull
    public final SurveyChatMessageModel copy(@NotNull String id2, int i10, @Nullable String str, @Nullable List<SurveyChatOptionsModel> list, @NotNull KeyMsgModel msglinkDict) {
        s.i(id2, "id");
        s.i(msglinkDict, "msglinkDict");
        return new SurveyChatMessageModel(id2, i10, str, list, msglinkDict);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurveyChatMessageModel)) {
            return false;
        }
        SurveyChatMessageModel surveyChatMessageModel = (SurveyChatMessageModel) obj;
        return s.d(this.f13413id, surveyChatMessageModel.f13413id) && this.type == surveyChatMessageModel.type && s.d(this.text, surveyChatMessageModel.text) && s.d(this.options, surveyChatMessageModel.options) && s.d(this.msglinkDict, surveyChatMessageModel.msglinkDict);
    }

    @NotNull
    public final String getId() {
        return this.f13413id;
    }

    @Nullable
    public final BaseSurveyChatMessageModel getMessageModel(@NotNull User sender) {
        s.i(sender, "sender");
        int i10 = this.type;
        if (i10 == SurveyChatMessageType.TextMessage.getValue()) {
            String str = this.text;
            if (str == null || str.length() == 0) {
                return null;
            }
            return new SurveyChatTextMessageModel(this.f13413id, sender, this.text);
        }
        if (i10 == SurveyChatMessageType.OptionsMessage.getValue()) {
            String str2 = this.text;
            if (str2 == null || str2.length() == 0) {
                return null;
            }
            List<SurveyChatOptionsModel> list = this.options;
            if (list == null || list.isEmpty()) {
                return null;
            }
            return new SurveyChatOptionsMessageModel(this.f13413id, sender, this.text, this.options);
        }
        if (i10 != SurveyChatMessageType.SystemMessage.getValue()) {
            return null;
        }
        String str3 = this.text;
        if (str3 == null || str3.length() == 0) {
            return null;
        }
        return new SurveyChatSystemMessageModel(this.f13413id, sender, this.text, this.msglinkDict);
    }

    @NotNull
    public final KeyMsgModel getMsglinkDict() {
        return this.msglinkDict;
    }

    @Nullable
    public final List<SurveyChatOptionsModel> getOptions() {
        return this.options;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((this.f13413id.hashCode() * 31) + this.type) * 31;
        String str = this.text;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<SurveyChatOptionsModel> list = this.options;
        return ((hashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.msglinkDict.hashCode();
    }

    @NotNull
    public String toString() {
        return "SurveyChatMessageModel(id=" + this.f13413id + ", type=" + this.type + ", text=" + this.text + ", options=" + ((Object) this.options) + ", msglinkDict=" + ((Object) this.msglinkDict) + ")";
    }
}
