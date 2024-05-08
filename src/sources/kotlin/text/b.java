package kotlin.text;

/* compiled from: Char.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b extends a {
    public static final boolean d(char c4, char c10, boolean z10) {
        if (c4 == c10) {
            return true;
        }
        if (!z10) {
            return false;
        }
        char upperCase = Character.toUpperCase(c4);
        char upperCase2 = Character.toUpperCase(c10);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }
}
