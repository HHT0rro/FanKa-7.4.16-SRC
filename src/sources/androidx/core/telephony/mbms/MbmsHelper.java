package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class MbmsHelper {

    @RequiresApi(28)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static CharSequence getBestNameForService(Context context, ServiceInfo serviceInfo) {
            Set<Locale> namedContentLocales = serviceInfo.getNamedContentLocales();
            if (namedContentLocales.isEmpty()) {
                return null;
            }
            String[] strArr = new String[namedContentLocales.size()];
            int i10 = 0;
            Iterator<Locale> iterator2 = serviceInfo.getNamedContentLocales().iterator2();
            while (iterator2.hasNext()) {
                strArr[i10] = iterator2.next().toLanguageTag();
                i10++;
            }
            Locale firstMatch = context.getResources().getConfiguration().getLocales().getFirstMatch(strArr);
            if (firstMatch == null) {
                return null;
            }
            return serviceInfo.getNameForLocale(firstMatch);
        }
    }

    private MbmsHelper() {
    }

    @Nullable
    public static CharSequence getBestNameForService(@NonNull Context context, @NonNull ServiceInfo serviceInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getBestNameForService(context, serviceInfo);
        }
        return null;
    }
}
