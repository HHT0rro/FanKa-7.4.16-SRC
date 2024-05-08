package android.view.translation;

import android.icu.util.ULocale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface UiTranslationStateCallback {
    void onFinished();

    void onPaused();

    @Deprecated
    default void onStarted(String sourceLocale, String targetLocale) {
    }

    default void onStarted(ULocale sourceLocale, ULocale targetLocale) {
        onStarted(sourceLocale.getLanguage(), targetLocale.getLanguage());
    }

    default void onStarted(ULocale sourceLocale, ULocale targetLocale, String packageName) {
        onStarted(sourceLocale, targetLocale);
    }

    default void onPaused(String packageName) {
        onPaused();
    }

    default void onResumed(ULocale sourceLocale, ULocale targetLocale) {
    }

    default void onResumed(ULocale sourceLocale, ULocale targetLocale, String packageName) {
        onResumed(sourceLocale, targetLocale);
    }

    default void onFinished(String packageName) {
        onFinished();
    }
}
