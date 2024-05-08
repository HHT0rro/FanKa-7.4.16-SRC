package java.lang;

import dalvik.system.VMRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import org.apache.commons.io.IOUtils;
import sun.net.www.ParseUtil;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Package implements AnnotatedElement {
    private final String implTitle;
    private final String implVendor;
    private final String implVersion;
    private final transient ClassLoader loader;
    private transient Class<?> packageInfo;
    private final String pkgName;
    private final URL sealBase;
    private final String specTitle;
    private final String specVendor;
    private final String specVersion;
    private static Map<String, Package> pkgs = new HashMap(31);
    private static Map<String, URL> urls = new HashMap(10);
    private static Map<String, Manifest> mans = new HashMap(10);

    private static native String getSystemPackage0(String str);

    private static native String[] getSystemPackages0();

    public String getName() {
        return this.pkgName;
    }

    public String getSpecificationTitle() {
        return this.specTitle;
    }

    public String getSpecificationVersion() {
        return this.specVersion;
    }

    public String getSpecificationVendor() {
        return this.specVendor;
    }

    public String getImplementationTitle() {
        return this.implTitle;
    }

    public String getImplementationVersion() {
        return this.implVersion;
    }

    public String getImplementationVendor() {
        return this.implVendor;
    }

    public boolean isSealed() {
        return this.sealBase != null;
    }

    public boolean isSealed(URL url) {
        return url.equals(this.sealBase);
    }

    public boolean isCompatibleWith(String desired) throws NumberFormatException {
        String str = this.specVersion;
        if (str == null || str.length() < 1) {
            throw new NumberFormatException("Empty version string");
        }
        String[] sa2 = this.specVersion.split("\\.", -1);
        int[] si = new int[sa2.length];
        for (int i10 = 0; i10 < sa2.length; i10++) {
            si[i10] = Integer.parseInt(sa2[i10]);
            if (si[i10] < 0) {
                throw NumberFormatException.forInputString("" + si[i10]);
            }
        }
        String[] da2 = desired.split("\\.", -1);
        int[] di = new int[da2.length];
        for (int i11 = 0; i11 < da2.length; i11++) {
            di[i11] = Integer.parseInt(da2[i11]);
            if (di[i11] < 0) {
                throw NumberFormatException.forInputString("" + di[i11]);
            }
        }
        int i12 = di.length;
        int len = Math.max(i12, si.length);
        int i13 = 0;
        while (i13 < len) {
            int d10 = i13 < di.length ? di[i13] : 0;
            int s2 = i13 < si.length ? si[i13] : 0;
            if (s2 < d10) {
                return false;
            }
            if (s2 > d10) {
                return true;
            }
            i13++;
        }
        return true;
    }

    @CallerSensitive
    public static Package getPackage(String name) {
        ClassLoader l10 = ClassLoader.getClassLoader(Reflection.getCallerClass());
        if (l10 != null) {
            return l10.getPackage(name);
        }
        return getSystemPackage(name);
    }

    @CallerSensitive
    public static Package[] getPackages() {
        ClassLoader l10 = ClassLoader.getClassLoader(Reflection.getCallerClass());
        if (l10 != null) {
            return l10.getPackages();
        }
        return getSystemPackages();
    }

    static Package getPackage(Class<?> c4) {
        String name = c4.getName();
        int i10 = name.lastIndexOf(46);
        if (i10 != -1) {
            String name2 = name.substring(0, i10);
            ClassLoader cl = c4.getClassLoader();
            if (cl != null) {
                return cl.getPackage(name2);
            }
            return getSystemPackage(name2);
        }
        return null;
    }

    public int hashCode() {
        return this.pkgName.hashCode();
    }

    public String toString() {
        String spec;
        String ver;
        int targetSdkVersion = VMRuntime.getRuntime().getTargetSdkVersion();
        if (targetSdkVersion > 0 && targetSdkVersion <= 24) {
            return "package " + this.pkgName;
        }
        String spec2 = this.specTitle;
        String ver2 = this.specVersion;
        if (spec2 != null && spec2.length() > 0) {
            spec = ", " + spec2;
        } else {
            spec = "";
        }
        if (ver2 != null && ver2.length() > 0) {
            ver = ", version " + ver2;
        } else {
            ver = "";
        }
        return "package " + this.pkgName + spec + ver;
    }

    private Class<?> getPackageInfo() {
        if (this.packageInfo == null) {
            try {
                this.packageInfo = Class.forName(this.pkgName + ".package-info", false, this.loader);
            } catch (ClassNotFoundException e2) {
                this.packageInfo = C1PackageInfoProxy.class;
            }
        }
        return this.packageInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.lang.Package$1PackageInfoProxy, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C1PackageInfoProxy {
        C1PackageInfoProxy() {
        }
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) getPackageInfo().getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return super.isAnnotationPresent(annotationClass);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> cls) {
        return (A[]) getPackageInfo().getAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getPackageInfo().getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> cls) {
        return (A) getPackageInfo().getDeclaredAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> cls) {
        return (A[]) getPackageInfo().getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return getPackageInfo().getDeclaredAnnotations();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Package(String name, String spectitle, String specversion, String specvendor, String impltitle, String implversion, String implvendor, URL sealbase, ClassLoader loader) {
        this.pkgName = name;
        this.implTitle = impltitle;
        this.implVersion = implversion;
        this.implVendor = implvendor;
        this.specTitle = spectitle;
        this.specVersion = specversion;
        this.specVendor = specvendor;
        this.sealBase = sealbase;
        this.loader = loader;
    }

    private Package(String name, Manifest man, URL url, ClassLoader loader) {
        String path = name.replace('.', IOUtils.DIR_SEPARATOR_UNIX).concat("/");
        String sealed = null;
        String specTitle = null;
        String specVersion = null;
        String specVendor = null;
        String implTitle = null;
        String implVersion = null;
        String implVendor = null;
        Attributes attr = man.getAttributes(path);
        if (attr != null) {
            specTitle = attr.getValue(Attributes.Name.SPECIFICATION_TITLE);
            specVersion = attr.getValue(Attributes.Name.SPECIFICATION_VERSION);
            specVendor = attr.getValue(Attributes.Name.SPECIFICATION_VENDOR);
            implTitle = attr.getValue(Attributes.Name.IMPLEMENTATION_TITLE);
            implVersion = attr.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            implVendor = attr.getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
            sealed = attr.getValue(Attributes.Name.SEALED);
        }
        Attributes attr2 = man.getMainAttributes();
        if (attr2 != null) {
            specTitle = specTitle == null ? attr2.getValue(Attributes.Name.SPECIFICATION_TITLE) : specTitle;
            specVersion = specVersion == null ? attr2.getValue(Attributes.Name.SPECIFICATION_VERSION) : specVersion;
            specVendor = specVendor == null ? attr2.getValue(Attributes.Name.SPECIFICATION_VENDOR) : specVendor;
            implTitle = implTitle == null ? attr2.getValue(Attributes.Name.IMPLEMENTATION_TITLE) : implTitle;
            implVersion = implVersion == null ? attr2.getValue(Attributes.Name.IMPLEMENTATION_VERSION) : implVersion;
            implVendor = implVendor == null ? attr2.getValue(Attributes.Name.IMPLEMENTATION_VENDOR) : implVendor;
            if (sealed == null) {
                sealed = attr2.getValue(Attributes.Name.SEALED);
            }
        }
        URL sealBase = "true".equalsIgnoreCase(sealed) ? url : null;
        this.pkgName = name;
        this.specTitle = specTitle;
        this.specVersion = specVersion;
        this.specVendor = specVendor;
        this.implTitle = implTitle;
        this.implVersion = implVersion;
        this.implVendor = implVendor;
        this.sealBase = sealBase;
        this.loader = loader;
    }

    static Package getSystemPackage(String name) {
        Package pkg;
        String name2;
        String fn;
        synchronized (pkgs) {
            pkg = pkgs.get(name);
            if (pkg == null && (fn = getSystemPackage0((name2 = name.replace('.', IOUtils.DIR_SEPARATOR_UNIX).concat("/")))) != null) {
                pkg = defineSystemPackage(name2, fn);
            }
        }
        return pkg;
    }

    static Package[] getSystemPackages() {
        Package[] packageArr;
        String[] names = getSystemPackages0();
        synchronized (pkgs) {
            for (int i10 = 0; i10 < names.length; i10++) {
                defineSystemPackage(names[i10], getSystemPackage0(names[i10]));
            }
            packageArr = (Package[]) pkgs.values().toArray(new Package[pkgs.size()]);
        }
        return packageArr;
    }

    private static Package defineSystemPackage(final String iname, final String fn) {
        return (Package) AccessController.doPrivileged(new PrivilegedAction<Package>() { // from class: java.lang.Package.1
            @Override // java.security.PrivilegedAction
            public Package run() {
                Package pkg;
                String name = String.this;
                URL url = (URL) Package.urls.get(fn);
                if (url == null) {
                    File file = new File(fn);
                    try {
                        url = ParseUtil.fileToEncodedURL(file);
                    } catch (MalformedURLException e2) {
                    }
                    if (url != null) {
                        Package.urls.put(fn, url);
                        if (file.isFile()) {
                            Map map = Package.mans;
                            String str = fn;
                            map.put(str, Package.loadManifest(str));
                        }
                    }
                }
                String name2 = name.substring(0, name.length() - 1).replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
                Manifest man = (Manifest) Package.mans.get(fn);
                if (man != null) {
                    pkg = new Package(name2, man, url, null);
                } else {
                    pkg = new Package(name2, null, null, null, null, null, null, null, null);
                }
                Package.pkgs.put(name2, pkg);
                return pkg;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Manifest loadManifest(String fn) {
        try {
            FileInputStream fis = new FileInputStream(fn);
            try {
                JarInputStream jis = new JarInputStream(fis, false);
                try {
                    Manifest manifest = jis.getManifest();
                    jis.close();
                    fis.close();
                    return manifest;
                } finally {
                }
            } finally {
            }
        } catch (IOException e2) {
            return null;
        }
    }
}
