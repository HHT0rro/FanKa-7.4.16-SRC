package com.android.internal.os;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Settings;
import android.util.KeyValueListParser;
import android.util.Range;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class KernelCpuThreadReaderSettingsObserver extends ContentObserver {
    private static final String COLLECTED_UIDS_DEFAULT = "0-0;1000-1000";
    private static final String COLLECTED_UIDS_SETTINGS_KEY = "collected_uids";
    private static final int MINIMUM_TOTAL_CPU_USAGE_MILLIS_DEFAULT = 10000;
    private static final String MINIMUM_TOTAL_CPU_USAGE_MILLIS_SETTINGS_KEY = "minimum_total_cpu_usage_millis";
    private static final int NUM_BUCKETS_DEFAULT = 8;
    private static final String NUM_BUCKETS_SETTINGS_KEY = "num_buckets";
    private static final String TAG = "KernelCpuThreadReaderSettingsObserver";
    private final Context mContext;
    private final KernelCpuThreadReader mKernelCpuThreadReader;
    private final KernelCpuThreadReaderDiff mKernelCpuThreadReaderDiff;

    public static KernelCpuThreadReaderDiff getSettingsModifiedReader(Context context) {
        KernelCpuThreadReaderSettingsObserver settingsObserver = new KernelCpuThreadReaderSettingsObserver(context);
        Uri settingsUri = Settings.Global.getUriFor("kernel_cpu_thread_reader");
        context.getContentResolver().registerContentObserver(settingsUri, false, settingsObserver, 0);
        return settingsObserver.mKernelCpuThreadReaderDiff;
    }

    private KernelCpuThreadReaderSettingsObserver(Context context) {
        super(BackgroundThread.getHandler());
        KernelCpuThreadReaderDiff kernelCpuThreadReaderDiff;
        this.mContext = context;
        KernelCpuThreadReader create = KernelCpuThreadReader.create(8, UidPredicate.fromString(COLLECTED_UIDS_DEFAULT));
        this.mKernelCpuThreadReader = create;
        if (create == null) {
            kernelCpuThreadReaderDiff = null;
        } else {
            kernelCpuThreadReaderDiff = new KernelCpuThreadReaderDiff(create, 10000);
        }
        this.mKernelCpuThreadReaderDiff = kernelCpuThreadReaderDiff;
    }

    public void onChange(boolean selfChange, Collection<Uri> uris, int flags, int userId) {
        updateReader();
    }

    private void updateReader() {
        if (this.mKernelCpuThreadReader == null) {
            return;
        }
        KeyValueListParser parser = new KeyValueListParser(',');
        try {
            parser.setString(Settings.Global.getString(this.mContext.getContentResolver(), "kernel_cpu_thread_reader"));
            try {
                UidPredicate uidPredicate = UidPredicate.fromString(parser.getString(COLLECTED_UIDS_SETTINGS_KEY, COLLECTED_UIDS_DEFAULT));
                this.mKernelCpuThreadReader.setNumBuckets(parser.getInt(NUM_BUCKETS_SETTINGS_KEY, 8));
                this.mKernelCpuThreadReader.setUidPredicate(uidPredicate);
                this.mKernelCpuThreadReaderDiff.setMinimumTotalCpuUsageMillis(parser.getInt(MINIMUM_TOTAL_CPU_USAGE_MILLIS_SETTINGS_KEY, 10000));
            } catch (NumberFormatException e2) {
                Slog.w(TAG, "Failed to get UID predicate", e2);
            }
        } catch (IllegalArgumentException e10) {
            Slog.e(TAG, "Bad settings", e10);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class UidPredicate implements Predicate<Integer> {
        private static final Pattern UID_RANGE_PATTERN = Pattern.compile("([0-9]+)-([0-9]+)");
        private static final String UID_SPECIFIER_DELIMITER = ";";
        private final List<Range<Integer>> mAcceptedUidRanges;

        public static UidPredicate fromString(String predicateString) throws NumberFormatException {
            List<Range<Integer>> acceptedUidRanges = new ArrayList<>();
            for (String uidSpecifier : predicateString.split(";")) {
                Matcher uidRangeMatcher = UID_RANGE_PATTERN.matcher(uidSpecifier);
                if (!uidRangeMatcher.matches()) {
                    throw new NumberFormatException("Failed to recognize as number range: " + uidSpecifier);
                }
                acceptedUidRanges.add(Range.create(Integer.valueOf(Integer.parseInt(uidRangeMatcher.group(1))), Integer.valueOf(Integer.parseInt(uidRangeMatcher.group(2)))));
            }
            return new UidPredicate(acceptedUidRanges);
        }

        private UidPredicate(List<Range<Integer>> acceptedUidRanges) {
            this.mAcceptedUidRanges = acceptedUidRanges;
        }

        @Override // java.util.function.Predicate
        public boolean test(Integer uid) {
            for (int i10 = 0; i10 < this.mAcceptedUidRanges.size(); i10++) {
                if (this.mAcceptedUidRanges.get(i10).contains((Range<Integer>) uid)) {
                    return true;
                }
            }
            return false;
        }
    }
}
