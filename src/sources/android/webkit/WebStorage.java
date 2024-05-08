package android.webkit;

import android.annotation.SystemApi;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class WebStorage {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface QuotaUpdater {
        void updateQuota(long j10);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Origin {
        private String mOrigin;
        private long mQuota;
        private long mUsage;

        @SystemApi
        protected Origin(String origin, long quota, long usage) {
            this.mOrigin = null;
            this.mQuota = 0L;
            this.mUsage = 0L;
            this.mOrigin = origin;
            this.mQuota = quota;
            this.mUsage = usage;
        }

        public String getOrigin() {
            return this.mOrigin;
        }

        public long getQuota() {
            return this.mQuota;
        }

        public long getUsage() {
            return this.mUsage;
        }
    }

    public void getOrigins(ValueCallback<Map> callback) {
    }

    public void getUsageForOrigin(String origin, ValueCallback<Long> callback) {
    }

    public void getQuotaForOrigin(String origin, ValueCallback<Long> callback) {
    }

    @Deprecated
    public void setQuotaForOrigin(String origin, long quota) {
    }

    public void deleteOrigin(String origin) {
    }

    public void deleteAllData() {
    }

    public static WebStorage getInstance() {
        return WebViewFactory.getProvider().getWebStorage();
    }

    @SystemApi
    public WebStorage() {
    }
}
