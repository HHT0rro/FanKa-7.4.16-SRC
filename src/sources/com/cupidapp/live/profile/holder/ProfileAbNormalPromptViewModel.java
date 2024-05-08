package com.cupidapp.live.profile.holder;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileAbNormalPromptViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileAbNormalPromptViewModel {
    private final boolean abNormal;

    @NotNull
    private final String prompt;

    public ProfileAbNormalPromptViewModel(boolean z10, @NotNull String prompt) {
        s.i(prompt, "prompt");
        this.abNormal = z10;
        this.prompt = prompt;
    }

    public static /* synthetic */ ProfileAbNormalPromptViewModel copy$default(ProfileAbNormalPromptViewModel profileAbNormalPromptViewModel, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = profileAbNormalPromptViewModel.abNormal;
        }
        if ((i10 & 2) != 0) {
            str = profileAbNormalPromptViewModel.prompt;
        }
        return profileAbNormalPromptViewModel.copy(z10, str);
    }

    public final boolean component1() {
        return this.abNormal;
    }

    @NotNull
    public final String component2() {
        return this.prompt;
    }

    @NotNull
    public final ProfileAbNormalPromptViewModel copy(boolean z10, @NotNull String prompt) {
        s.i(prompt, "prompt");
        return new ProfileAbNormalPromptViewModel(z10, prompt);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileAbNormalPromptViewModel)) {
            return false;
        }
        ProfileAbNormalPromptViewModel profileAbNormalPromptViewModel = (ProfileAbNormalPromptViewModel) obj;
        return this.abNormal == profileAbNormalPromptViewModel.abNormal && s.d(this.prompt, profileAbNormalPromptViewModel.prompt);
    }

    public final boolean getAbNormal() {
        return this.abNormal;
    }

    @NotNull
    public final String getPrompt() {
        return this.prompt;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.abNormal;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (r02 * 31) + this.prompt.hashCode();
    }

    @NotNull
    public String toString() {
        return "ProfileAbNormalPromptViewModel(abNormal=" + this.abNormal + ", prompt=" + this.prompt + ")";
    }
}
