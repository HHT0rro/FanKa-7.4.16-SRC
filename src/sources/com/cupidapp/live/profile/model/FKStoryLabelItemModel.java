package com.cupidapp.live.profile.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: User.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelItemModel implements Serializable {

    @Nullable
    private String content;

    @Nullable
    private final String contentId;

    @NotNull
    private final String defaultContent;

    @Nullable
    private final ImageModel icon;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f17840id;
    private final boolean online;

    @NotNull
    private final String question;

    public FKStoryLabelItemModel(@NotNull String id2, @Nullable ImageModel imageModel, @NotNull String question, @NotNull String defaultContent, @Nullable String str, boolean z10, @Nullable String str2) {
        s.i(id2, "id");
        s.i(question, "question");
        s.i(defaultContent, "defaultContent");
        this.f17840id = id2;
        this.icon = imageModel;
        this.question = question;
        this.defaultContent = defaultContent;
        this.content = str;
        this.online = z10;
        this.contentId = str2;
    }

    public static /* synthetic */ FKStoryLabelItemModel copy$default(FKStoryLabelItemModel fKStoryLabelItemModel, String str, ImageModel imageModel, String str2, String str3, String str4, boolean z10, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fKStoryLabelItemModel.f17840id;
        }
        if ((i10 & 2) != 0) {
            imageModel = fKStoryLabelItemModel.icon;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 4) != 0) {
            str2 = fKStoryLabelItemModel.question;
        }
        String str6 = str2;
        if ((i10 & 8) != 0) {
            str3 = fKStoryLabelItemModel.defaultContent;
        }
        String str7 = str3;
        if ((i10 & 16) != 0) {
            str4 = fKStoryLabelItemModel.content;
        }
        String str8 = str4;
        if ((i10 & 32) != 0) {
            z10 = fKStoryLabelItemModel.online;
        }
        boolean z11 = z10;
        if ((i10 & 64) != 0) {
            str5 = fKStoryLabelItemModel.contentId;
        }
        return fKStoryLabelItemModel.copy(str, imageModel2, str6, str7, str8, z11, str5);
    }

    @NotNull
    public final String component1() {
        return this.f17840id;
    }

    @Nullable
    public final ImageModel component2() {
        return this.icon;
    }

    @NotNull
    public final String component3() {
        return this.question;
    }

    @NotNull
    public final String component4() {
        return this.defaultContent;
    }

    @Nullable
    public final String component5() {
        return this.content;
    }

    public final boolean component6() {
        return this.online;
    }

    @Nullable
    public final String component7() {
        return this.contentId;
    }

    @NotNull
    public final FKStoryLabelItemModel copy(@NotNull String id2, @Nullable ImageModel imageModel, @NotNull String question, @NotNull String defaultContent, @Nullable String str, boolean z10, @Nullable String str2) {
        s.i(id2, "id");
        s.i(question, "question");
        s.i(defaultContent, "defaultContent");
        return new FKStoryLabelItemModel(id2, imageModel, question, defaultContent, str, z10, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKStoryLabelItemModel)) {
            return false;
        }
        FKStoryLabelItemModel fKStoryLabelItemModel = (FKStoryLabelItemModel) obj;
        return s.d(this.f17840id, fKStoryLabelItemModel.f17840id) && s.d(this.icon, fKStoryLabelItemModel.icon) && s.d(this.question, fKStoryLabelItemModel.question) && s.d(this.defaultContent, fKStoryLabelItemModel.defaultContent) && s.d(this.content, fKStoryLabelItemModel.content) && this.online == fKStoryLabelItemModel.online && s.d(this.contentId, fKStoryLabelItemModel.contentId);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getContentId() {
        return this.contentId;
    }

    @NotNull
    public final String getDefaultContent() {
        return this.defaultContent;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getId() {
        return this.f17840id;
    }

    public final boolean getOnline() {
        return this.online;
    }

    @NotNull
    public final String getQuestion() {
        return this.question;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f17840id.hashCode() * 31;
        ImageModel imageModel = this.icon;
        int hashCode2 = (((((hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31) + this.question.hashCode()) * 31) + this.defaultContent.hashCode()) * 31;
        String str = this.content;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z10 = this.online;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode3 + i10) * 31;
        String str2 = this.contentId;
        return i11 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    @NotNull
    public String toString() {
        String str = this.f17840id;
        ImageModel imageModel = this.icon;
        return "FKStoryLabelItemModel(id=" + str + ", icon=" + ((Object) imageModel) + ", question=" + this.question + ", defaultContent=" + this.defaultContent + ", content=" + this.content + ", online=" + this.online + ", contentId=" + this.contentId + ")";
    }
}
