package com.android.internal.content.om;

import android.content.pm.PackagePartitions;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.Log;
import com.android.apex.ApexInfo;
import com.android.apex.XmlParser;
import com.android.internal.content.om.OverlayConfig;
import com.android.internal.content.om.OverlayConfigParser;
import com.android.internal.content.om.OverlayScanner;
import com.android.internal.util.Preconditions;
import com.android.internal.util.function.TriConsumer;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OverlayConfig {
    public static final int DEFAULT_PRIORITY = Integer.MAX_VALUE;
    static final String TAG = "OverlayConfig";
    private static OverlayConfig sInstance;
    private static final Comparator<OverlayConfigParser.ParsedConfiguration> sStaticOverlayComparator = new Comparator() { // from class: com.android.internal.content.om.OverlayConfig$$ExternalSyntheticLambda5
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return OverlayConfig.lambda$static$0((OverlayConfigParser.ParsedConfiguration) obj, (OverlayConfigParser.ParsedConfiguration) obj2);
        }
    };
    private final ArrayMap<String, Configuration> mConfigurations = new ArrayMap<>();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface PackageProvider {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public interface Package {
            String getBaseApkPath();

            int getOverlayPriority();

            String getOverlayTarget();

            String getPackageName();

            int getTargetSdkVersion();

            boolean isOverlayIsStatic();
        }

        void forEachPackage(TriConsumer<Package, Boolean, File> triConsumer);
    }

    private static native String[] createIdmap(String str, String[] strArr, String[] strArr2, boolean z10);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Configuration {
        public final int configIndex;
        public final OverlayConfigParser.ParsedConfiguration parsedConfig;

        public Configuration(OverlayConfigParser.ParsedConfiguration parsedConfig, int configIndex) {
            this.parsedConfig = parsedConfig;
            this.configIndex = configIndex;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$static$0(OverlayConfigParser.ParsedConfiguration c12, OverlayConfigParser.ParsedConfiguration c22) {
        OverlayScanner.ParsedOverlayInfo o12 = c12.parsedInfo;
        OverlayScanner.ParsedOverlayInfo o22 = c22.parsedInfo;
        Preconditions.checkArgument(o12.isStatic && o22.isStatic, "attempted to sort non-static overlay");
        if (!o12.targetPackageName.equals(o22.targetPackageName)) {
            return o12.targetPackageName.compareTo(o22.targetPackageName);
        }
        int comparedPriority = o12.priority - o22.priority;
        return comparedPriority == 0 ? o12.path.compareTo(o22.path) : comparedPriority;
    }

    public OverlayConfig(final File rootDirectory, Supplier<OverlayScanner> scannerFactory, PackageProvider packageProvider) {
        ArrayList<OverlayConfigParser.OverlayPartition> partitions;
        ArrayList<OverlayScanner.ParsedOverlayInfo> partitionOverlayInfos;
        ArrayList<OverlayConfigParser.OverlayPartition> partitions2;
        ArrayMap<Integer, List<String>> activeApexesPerPartition;
        ArrayMap<Integer, List<String>> activeApexesPerPartition2;
        int m10;
        int i10 = 1;
        Preconditions.checkArgument((scannerFactory == null) != (packageProvider == null), "scannerFactory and packageProvider cannot be both null or both non-null");
        if (rootDirectory == null) {
            partitions = new ArrayList<>(PackagePartitions.getOrderedPartitions(new Function() { // from class: com.android.internal.content.om.OverlayConfig$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return new OverlayConfigParser.OverlayPartition((PackagePartitions.SystemPartition) obj);
                }
            }));
        } else {
            partitions = new ArrayList<>(PackagePartitions.getOrderedPartitions(new Function() { // from class: com.android.internal.content.om.OverlayConfig$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return OverlayConfig.lambda$new$1(File.this, (PackagePartitions.SystemPartition) obj);
                }
            }));
        }
        ArrayMap<Integer, List<String>> activeApexesPerPartition3 = getActiveApexes(partitions);
        boolean foundConfigFile = false;
        Map<String, OverlayScanner.ParsedOverlayInfo> packageManagerOverlayInfos = packageProvider == null ? null : getOverlayPackageInfos(packageProvider);
        ArrayList<OverlayConfigParser.ParsedConfiguration> overlays = new ArrayList<>();
        int i11 = 0;
        int n10 = partitions.size();
        while (i11 < n10) {
            OverlayConfigParser.OverlayPartition partition = partitions.get(i11);
            OverlayScanner scanner = scannerFactory == null ? null : scannerFactory.get();
            ArrayList<OverlayConfigParser.ParsedConfiguration> partitionOverlays = OverlayConfigParser.getConfigurations(partition, scanner, packageManagerOverlayInfos, (List) activeApexesPerPartition3.getOrDefault(Integer.valueOf(partition.type), Collections.emptyList()));
            if (partitionOverlays != null) {
                foundConfigFile = true;
                overlays.addAll(partitionOverlays);
                partitions2 = partitions;
                activeApexesPerPartition = activeApexesPerPartition3;
            } else {
                if (scannerFactory != null) {
                    partitionOverlayInfos = new ArrayList<>(scanner.getAllParsedInfos());
                } else {
                    partitionOverlayInfos = new ArrayList<>(packageManagerOverlayInfos.values());
                    for (int j10 = partitionOverlayInfos.size() - i10; j10 >= 0; j10--) {
                        if (!partition.containsFile(partitionOverlayInfos.get(j10).getOriginalPartitionPath())) {
                            partitionOverlayInfos.remove(j10);
                        }
                    }
                }
                ArrayList<OverlayConfigParser.ParsedConfiguration> partitionConfigs = new ArrayList<>();
                int j11 = 0;
                int m11 = partitionOverlayInfos.size();
                while (j11 < m11) {
                    OverlayScanner.ParsedOverlayInfo p10 = partitionOverlayInfos.get(j11);
                    ArrayList<OverlayConfigParser.OverlayPartition> partitions3 = partitions;
                    if (!p10.isStatic) {
                        activeApexesPerPartition2 = activeApexesPerPartition3;
                        m10 = m11;
                    } else {
                        activeApexesPerPartition2 = activeApexesPerPartition3;
                        m10 = m11;
                        partitionConfigs.add(new OverlayConfigParser.ParsedConfiguration(p10.packageName, true, false, partition.policy, p10, null));
                    }
                    j11++;
                    partitions = partitions3;
                    activeApexesPerPartition3 = activeApexesPerPartition2;
                    m11 = m10;
                }
                partitions2 = partitions;
                activeApexesPerPartition = activeApexesPerPartition3;
                Comparator<? super OverlayConfigParser.ParsedConfiguration> comparator = sStaticOverlayComparator;
                partitionConfigs.sort(comparator);
                overlays.addAll(partitionConfigs);
                if (!foundConfigFile) {
                    overlays.sort(comparator);
                }
            }
            i11++;
            partitions = partitions2;
            activeApexesPerPartition3 = activeApexesPerPartition;
            i10 = 1;
        }
        int n11 = overlays.size();
        for (int i12 = 0; i12 < n11; i12++) {
            OverlayConfigParser.ParsedConfiguration config = overlays.get(i12);
            this.mConfigurations.put(config.packageName, new Configuration(config, i12));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ OverlayConfigParser.OverlayPartition lambda$new$1(File rootDirectory, PackagePartitions.SystemPartition p10) {
        return new OverlayConfigParser.OverlayPartition(new File(rootDirectory, p10.getNonConicalFolder().getPath()), p10);
    }

    public static OverlayConfig getZygoteInstance() {
        Trace.traceBegin(67108864L, "OverlayConfig#getZygoteInstance");
        try {
            return new OverlayConfig(null, new Supplier() { // from class: com.android.internal.content.om.OverlayConfig$$ExternalSyntheticLambda2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new OverlayScanner();
                }
            }, null);
        } finally {
            Trace.traceEnd(67108864L);
        }
    }

    public static OverlayConfig initializeSystemInstance(PackageProvider packageProvider) {
        Trace.traceBegin(67108864L, "OverlayConfig#initializeSystemInstance");
        try {
            sInstance = new OverlayConfig(null, null, packageProvider);
            Trace.traceEnd(67108864L);
            return sInstance;
        } catch (Throwable th) {
            Trace.traceEnd(67108864L);
            throw th;
        }
    }

    public static OverlayConfig getSystemInstance() {
        OverlayConfig overlayConfig = sInstance;
        if (overlayConfig == null) {
            throw new IllegalStateException("System instance not initialized");
        }
        return overlayConfig;
    }

    public Configuration getConfiguration(String packageName) {
        return this.mConfigurations.get(packageName);
    }

    public boolean isEnabled(String packageName) {
        Configuration config = this.mConfigurations.get(packageName);
        if (config == null) {
            return false;
        }
        return config.parsedConfig.enabled;
    }

    public boolean isMutable(String packageName) {
        Configuration config = this.mConfigurations.get(packageName);
        if (config == null) {
            return true;
        }
        return config.parsedConfig.mutable;
    }

    public int getPriority(String packageName) {
        Configuration config = this.mConfigurations.get(packageName);
        if (config == null) {
            return Integer.MAX_VALUE;
        }
        return config.configIndex;
    }

    private ArrayList<Configuration> getSortedOverlays() {
        ArrayList<Configuration> sortedOverlays = new ArrayList<>();
        int n10 = this.mConfigurations.size();
        for (int i10 = 0; i10 < n10; i10++) {
            sortedOverlays.add(this.mConfigurations.valueAt(i10));
        }
        sortedOverlays.sort(Comparator.comparingInt(new ToIntFunction() { // from class: com.android.internal.content.om.OverlayConfig$$ExternalSyntheticLambda4
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                int i11;
                i11 = ((OverlayConfig.Configuration) obj).configIndex;
                return i11;
            }
        }));
        return sortedOverlays;
    }

    private static Map<String, OverlayScanner.ParsedOverlayInfo> getOverlayPackageInfos(PackageProvider packageManager) {
        final HashMap<String, OverlayScanner.ParsedOverlayInfo> overlays = new HashMap<>();
        packageManager.forEachPackage(new TriConsumer() { // from class: com.android.internal.content.om.OverlayConfig$$ExternalSyntheticLambda3
            public final void accept(Object obj, Object obj2, Object obj3) {
                OverlayConfig.lambda$getOverlayPackageInfos$3(HashMap.this, (OverlayConfig.PackageProvider.Package) obj, (Boolean) obj2, (File) obj3);
            }
        });
        return overlays;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getOverlayPackageInfos$3(HashMap overlays, PackageProvider.Package p10, Boolean isSystem, File preInstalledApexPath) {
        if (p10.getOverlayTarget() != null && isSystem.booleanValue()) {
            overlays.put(p10.getPackageName(), new OverlayScanner.ParsedOverlayInfo(p10.getPackageName(), p10.getOverlayTarget(), p10.getTargetSdkVersion(), p10.isOverlayIsStatic(), p10.getOverlayPriority(), new File(p10.getBaseApkPath()), preInstalledApexPath));
        }
    }

    private static ArrayMap<Integer, List<String>> getActiveApexes(List<OverlayConfigParser.OverlayPartition> partitions) {
        ArrayMap<Integer, List<String>> result = new ArrayMap<>();
        Iterator<OverlayConfigParser.OverlayPartition> iterator2 = partitions.iterator2();
        while (iterator2.hasNext()) {
            result.put(Integer.valueOf(iterator2.next().type), new ArrayList());
        }
        File apexInfoList = new File("/apex/apex-info-list.xml");
        if (apexInfoList.exists() && apexInfoList.canRead()) {
            try {
                FileInputStream stream = new FileInputStream(apexInfoList);
                try {
                    List<ApexInfo> apexInfos = XmlParser.readApexInfoList(stream).getApexInfo();
                    for (ApexInfo info : apexInfos) {
                        if (info.getIsActive()) {
                            Iterator<OverlayConfigParser.OverlayPartition> iterator22 = partitions.iterator2();
                            while (true) {
                                if (iterator22.hasNext()) {
                                    OverlayConfigParser.OverlayPartition partition = iterator22.next();
                                    if (partition.containsPath(info.getPreinstalledModulePath())) {
                                        result.get(Integer.valueOf(partition.type)).add(info.getModuleName());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    stream.close();
                } finally {
                }
            } catch (Exception e2) {
                Log.w(TAG, "Error reading apex-info-list: " + ((Object) e2));
            }
        }
        return result;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class IdmapInvocation {
        public final boolean enforceOverlayable;
        public final ArrayList<String> overlayPaths = new ArrayList<>();
        public final String policy;

        IdmapInvocation(boolean enforceOverlayable, String policy) {
            this.enforceOverlayable = enforceOverlayable;
            this.policy = policy;
        }

        public String toString() {
            return getClass().getSimpleName() + String.format("{enforceOverlayable=%s, policy=%s, overlayPaths=[%s]}", Boolean.valueOf(this.enforceOverlayable), this.policy, String.join(", ", this.overlayPaths));
        }
    }

    public ArrayList<IdmapInvocation> getImmutableFrameworkOverlayIdmapInvocations() {
        ArrayList<IdmapInvocation> idmapInvocations = new ArrayList<>();
        ArrayList<Configuration> sortedConfigs = getSortedOverlays();
        int n10 = sortedConfigs.size();
        for (int i10 = 0; i10 < n10; i10++) {
            Configuration overlay = sortedConfigs.get(i10);
            if (!overlay.parsedConfig.mutable && overlay.parsedConfig.enabled && "android".equals(overlay.parsedConfig.parsedInfo.targetPackageName)) {
                boolean enforceOverlayable = overlay.parsedConfig.parsedInfo.targetSdkVersion >= 29;
                IdmapInvocation invocation = null;
                if (!idmapInvocations.isEmpty()) {
                    IdmapInvocation last = idmapInvocations.get(idmapInvocations.size() - 1);
                    if (last.enforceOverlayable == enforceOverlayable && last.policy.equals(overlay.parsedConfig.policy)) {
                        invocation = last;
                    }
                }
                if (invocation == null) {
                    invocation = new IdmapInvocation(enforceOverlayable, overlay.parsedConfig.policy);
                    idmapInvocations.add(invocation);
                }
                invocation.overlayPaths.add(overlay.parsedConfig.parsedInfo.path.getAbsolutePath());
            }
        }
        return idmapInvocations;
    }

    public String[] createImmutableFrameworkIdmapsInZygote() {
        ArrayList<String> idmapPaths = new ArrayList<>();
        ArrayList<IdmapInvocation> idmapInvocations = getImmutableFrameworkOverlayIdmapInvocations();
        int n10 = idmapInvocations.size();
        for (int i10 = 0; i10 < n10; i10++) {
            IdmapInvocation invocation = idmapInvocations.get(i10);
            String[] idmaps = createIdmap("/system/framework/framework-res.apk", (String[]) invocation.overlayPaths.toArray(new String[0]), new String[]{"public", invocation.policy}, invocation.enforceOverlayable);
            if (idmaps == null) {
                Log.w(TAG, "'idmap2 create-multiple' failed: no mutable=\"false\" overlays targeting \"android\" will be loaded");
                return new String[0];
            }
            idmapPaths.addAll(Arrays.asList(idmaps));
        }
        return (String[]) idmapPaths.toArray(new String[0]);
    }

    public void dump(PrintWriter writer) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(writer);
        ipw.println("Overlay configurations:");
        ipw.increaseIndent();
        ArrayList<Configuration> configurations = new ArrayList<>(this.mConfigurations.values());
        configurations.sort(Comparator.comparingInt(new ToIntFunction() { // from class: com.android.internal.content.om.OverlayConfig$$ExternalSyntheticLambda6
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                int i10;
                i10 = ((OverlayConfig.Configuration) obj).configIndex;
                return i10;
            }
        }));
        for (int i10 = 0; i10 < configurations.size(); i10++) {
            Configuration configuration = configurations.get(i10);
            ipw.print(configuration.configIndex);
            ipw.print(", ");
            ipw.print(configuration.parsedConfig);
            ipw.println();
        }
        ipw.decreaseIndent();
        ipw.println();
    }

    public ArrayList<IdmapInvocation> getImmutableOplusFrameworkOverlayIdmapInvocations() {
        ArrayList<IdmapInvocation> idmapInvocations = new ArrayList<>();
        ArrayList<Configuration> sortedConfigs = getSortedOverlays();
        int n10 = sortedConfigs.size();
        for (int i10 = 0; i10 < n10; i10++) {
            Configuration overlay = sortedConfigs.get(i10);
            if (!overlay.parsedConfig.mutable && overlay.parsedConfig.enabled && "oplus".equals(overlay.parsedConfig.parsedInfo.targetPackageName)) {
                boolean enforceOverlayable = overlay.parsedConfig.parsedInfo.targetSdkVersion >= 29;
                IdmapInvocation invocation = null;
                if (!idmapInvocations.isEmpty()) {
                    IdmapInvocation last = idmapInvocations.get(idmapInvocations.size() - 1);
                    if (last.enforceOverlayable == enforceOverlayable && last.policy.equals(overlay.parsedConfig.policy)) {
                        invocation = last;
                    }
                }
                if (invocation == null) {
                    invocation = new IdmapInvocation(enforceOverlayable, overlay.parsedConfig.policy);
                    idmapInvocations.add(invocation);
                }
                invocation.overlayPaths.add(overlay.parsedConfig.parsedInfo.path.getAbsolutePath());
            }
        }
        return idmapInvocations;
    }

    public String[] createImmutableOplusFrameworkIdmapsInZygote() {
        ArrayList<String> idmapPaths = new ArrayList<>();
        ArrayList<IdmapInvocation> idmapInvocations = getImmutableOplusFrameworkOverlayIdmapInvocations();
        int n10 = idmapInvocations.size();
        for (int i10 = 0; i10 < n10; i10++) {
            IdmapInvocation invocation = idmapInvocations.get(i10);
            String[] idmaps = createIdmap("/system_ext/framework/oplus-framework-res.apk", (String[]) invocation.overlayPaths.toArray(new String[0]), new String[]{"public", invocation.policy}, invocation.enforceOverlayable);
            if (idmaps == null) {
                Log.w(TAG, "'idmap2 create-multiple' failed: no mutable=\"false\" overlays targeting \"oplus\" will be loaded");
                return new String[0];
            }
            idmapPaths.addAll(Arrays.asList(idmaps));
        }
        return (String[]) idmapPaths.toArray(new String[0]);
    }
}
