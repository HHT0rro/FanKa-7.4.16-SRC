package kotlin.text;

import org.jetbrains.annotations.NotNull;

/* compiled from: StringNumberConversionsJVM.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f51117a = new h();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Regex f51118b;

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        f51118b = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }
}
