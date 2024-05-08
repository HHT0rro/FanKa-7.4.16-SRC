package android.view.textservice;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.SpellCheckerSession;
import com.android.internal.textservice.ISpellCheckerSessionListener;
import com.android.internal.textservice.ITextServicesManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TextServicesManager {
    private static final boolean DBG = false;
    private static final String TAG = TextServicesManager.class.getSimpleName();

    @Deprecated
    private static TextServicesManager sInstance;
    private final InputMethodManager mInputMethodManager;
    private final ITextServicesManager mService = ITextServicesManager.Stub.asInterface(ServiceManager.getServiceOrThrow("textservices"));
    private final int mUserId;

    private TextServicesManager(int userId, InputMethodManager inputMethodManager) throws ServiceManager.ServiceNotFoundException {
        this.mUserId = userId;
        this.mInputMethodManager = inputMethodManager;
    }

    public static TextServicesManager createInstance(Context context) throws ServiceManager.ServiceNotFoundException {
        return new TextServicesManager(context.getUserId(), (InputMethodManager) context.getSystemService(InputMethodManager.class));
    }

    public static TextServicesManager getInstance() {
        TextServicesManager textServicesManager;
        synchronized (TextServicesManager.class) {
            if (sInstance == null) {
                try {
                    sInstance = new TextServicesManager(UserHandle.myUserId(), null);
                } catch (ServiceManager.ServiceNotFoundException e2) {
                    throw new IllegalStateException((Throwable) e2);
                }
            }
            textServicesManager = sInstance;
        }
        return textServicesManager;
    }

    public InputMethodManager getInputMethodManager() {
        return this.mInputMethodManager;
    }

    private static String parseLanguageFromLocaleString(String locale) {
        int idx = locale.indexOf(95);
        if (idx < 0) {
            return locale;
        }
        return locale.substring(0, idx);
    }

    public SpellCheckerSession newSpellCheckerSession(Bundle bundle, Locale locale, SpellCheckerSession.SpellCheckerSessionListener listener, boolean referToSpellCheckerLanguageSettings) {
        SpellCheckerSession.SpellCheckerSessionParams.Builder paramsBuilder = new SpellCheckerSession.SpellCheckerSessionParams.Builder().setLocale(locale).setShouldReferToSpellCheckerLanguageSettings(referToSpellCheckerLanguageSettings).setSupportedAttributes(7);
        if (bundle != null) {
            paramsBuilder.setExtras(bundle);
        }
        return newSpellCheckerSession(paramsBuilder.build(), new HandlerExecutor(new Handler()), listener);
    }

    public SpellCheckerSession newSpellCheckerSession(SpellCheckerSession.SpellCheckerSessionParams params, Executor executor, SpellCheckerSession.SpellCheckerSessionListener listener) {
        Objects.requireNonNull(executor);
        Objects.requireNonNull(listener);
        Locale locale = params.getLocale();
        if (!params.shouldReferToSpellCheckerLanguageSettings() && locale == null) {
            throw new IllegalArgumentException("Locale should not be null if you don't refer settings.");
        }
        if (params.shouldReferToSpellCheckerLanguageSettings() && !isSpellCheckerEnabled()) {
            return null;
        }
        try {
            SpellCheckerInfo sci = this.mService.getCurrentSpellChecker(this.mUserId, (String) null);
            if (sci == null) {
                return null;
            }
            SpellCheckerSubtype subtypeInUse = null;
            if (params.shouldReferToSpellCheckerLanguageSettings()) {
                subtypeInUse = getCurrentSpellCheckerSubtype(true);
                if (subtypeInUse == null) {
                    return null;
                }
                if (locale != null) {
                    String subtypeLocale = subtypeInUse.getLocale();
                    String subtypeLanguage = parseLanguageFromLocaleString(subtypeLocale);
                    if (subtypeLanguage.length() < 2 || !locale.getLanguage().equals(subtypeLanguage)) {
                        return null;
                    }
                }
            } else {
                String localeStr = locale.toString();
                int i10 = 0;
                while (true) {
                    if (i10 >= sci.getSubtypeCount()) {
                        break;
                    }
                    SpellCheckerSubtype subtype = sci.getSubtypeAt(i10);
                    String tempSubtypeLocale = subtype.getLocale();
                    String tempSubtypeLanguage = parseLanguageFromLocaleString(tempSubtypeLocale);
                    if (tempSubtypeLocale.equals(localeStr)) {
                        subtypeInUse = subtype;
                        break;
                    }
                    if (tempSubtypeLanguage.length() >= 2 && locale.getLanguage().equals(tempSubtypeLanguage)) {
                        subtypeInUse = subtype;
                    }
                    i10++;
                }
            }
            if (subtypeInUse == null) {
                return null;
            }
            SpellCheckerSession session = new SpellCheckerSession(sci, this, listener, executor);
            try {
                this.mService.getSpellCheckerService(this.mUserId, sci.getId(), subtypeInUse.getLocale(), session.getTextServicesSessionListener(), session.getSpellCheckerSessionListener(), params.getExtras(), params.getSupportedAttributes());
                return session;
            } catch (RemoteException e2) {
                throw e2.rethrowFromSystemServer();
            }
        } catch (RemoteException e10) {
            return null;
        }
    }

    public SpellCheckerInfo[] getEnabledSpellCheckers() {
        try {
            SpellCheckerInfo[] retval = this.mService.getEnabledSpellCheckers(this.mUserId);
            return retval;
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public List<SpellCheckerInfo> getEnabledSpellCheckerInfos() {
        SpellCheckerInfo[] enabledSpellCheckers = getEnabledSpellCheckers();
        return enabledSpellCheckers != null ? Arrays.asList(enabledSpellCheckers) : Collections.emptyList();
    }

    public SpellCheckerInfo getCurrentSpellCheckerInfo() {
        try {
            return this.mService.getCurrentSpellChecker(this.mUserId, (String) null);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public SpellCheckerInfo getCurrentSpellChecker() {
        return getCurrentSpellCheckerInfo();
    }

    public SpellCheckerSubtype getCurrentSpellCheckerSubtype(boolean allowImplicitlySelectedSubtype) {
        try {
            return this.mService.getCurrentSpellCheckerSubtype(this.mUserId, allowImplicitlySelectedSubtype);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public boolean isSpellCheckerEnabled() {
        try {
            return this.mService.isSpellCheckerEnabled(this.mUserId);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finishSpellCheckerService(ISpellCheckerSessionListener listener) {
        try {
            this.mService.finishSpellCheckerService(this.mUserId, listener);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }
}
