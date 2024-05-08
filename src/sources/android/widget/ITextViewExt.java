package android.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ITextViewExt {
    default void init(Context context) {
    }

    default boolean getClipboardStatus() {
        return true;
    }

    default int getTypefaceIndex(int originIndex, int oplusIndex) {
        return originIndex;
    }

    default void replaceFakeBoldToMedium(TextView textView, Typeface typeface, int style) {
        textView.setTypeface(typeface, style);
    }

    default Typeface flipTypeface(Typeface typeface, Paint paint) {
        return typeface;
    }
}
