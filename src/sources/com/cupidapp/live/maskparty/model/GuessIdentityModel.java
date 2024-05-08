package com.cupidapp.live.maskparty.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyScriptModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class GuessIdentityModel {

    @NotNull
    private final List<IdentityModel> options;

    @NotNull
    private final String question;

    public GuessIdentityModel(@NotNull String question, @NotNull List<IdentityModel> options) {
        s.i(question, "question");
        s.i(options, "options");
        this.question = question;
        this.options = options;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuessIdentityModel copy$default(GuessIdentityModel guessIdentityModel, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = guessIdentityModel.question;
        }
        if ((i10 & 2) != 0) {
            list = guessIdentityModel.options;
        }
        return guessIdentityModel.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.question;
    }

    @NotNull
    public final List<IdentityModel> component2() {
        return this.options;
    }

    @NotNull
    public final GuessIdentityModel copy(@NotNull String question, @NotNull List<IdentityModel> options) {
        s.i(question, "question");
        s.i(options, "options");
        return new GuessIdentityModel(question, options);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuessIdentityModel)) {
            return false;
        }
        GuessIdentityModel guessIdentityModel = (GuessIdentityModel) obj;
        return s.d(this.question, guessIdentityModel.question) && s.d(this.options, guessIdentityModel.options);
    }

    @NotNull
    public final List<IdentityModel> getOptions() {
        return this.options;
    }

    @NotNull
    public final String getQuestion() {
        return this.question;
    }

    public int hashCode() {
        return (this.question.hashCode() * 31) + this.options.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuessIdentityModel(question=" + this.question + ", options=" + ((Object) this.options) + ")";
    }
}
