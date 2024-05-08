package com.cupidapp.live.maskparty.holder;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ScriptKillViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ScriptKillPromptModel {

    @NotNull
    private final String prompt;

    public ScriptKillPromptModel(@NotNull String prompt) {
        s.i(prompt, "prompt");
        this.prompt = prompt;
    }

    public static /* synthetic */ ScriptKillPromptModel copy$default(ScriptKillPromptModel scriptKillPromptModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = scriptKillPromptModel.prompt;
        }
        return scriptKillPromptModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.prompt;
    }

    @NotNull
    public final ScriptKillPromptModel copy(@NotNull String prompt) {
        s.i(prompt, "prompt");
        return new ScriptKillPromptModel(prompt);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ScriptKillPromptModel) && s.d(this.prompt, ((ScriptKillPromptModel) obj).prompt);
    }

    @NotNull
    public final String getPrompt() {
        return this.prompt;
    }

    public int hashCode() {
        return this.prompt.hashCode();
    }

    @NotNull
    public String toString() {
        return "ScriptKillPromptModel(prompt=" + this.prompt + ")";
    }
}
