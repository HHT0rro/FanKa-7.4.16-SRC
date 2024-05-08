package java.util.logging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Level implements Serializable {
    private static final long serialVersionUID = -8176160795706313070L;
    private transient Locale cachedLocale;
    private transient String localizedLevelName;
    private final String name;
    private final String resourceBundleName;
    private final int value;
    private static final String defaultBundle = "sun.util.logging.resources.logging";
    public static final Level OFF = new Level("OFF", Integer.MAX_VALUE, defaultBundle);
    public static final Level SEVERE = new Level("SEVERE", 1000, defaultBundle);
    public static final Level WARNING = new Level("WARNING", 900, defaultBundle);
    public static final Level INFO = new Level("INFO", 800, defaultBundle);
    public static final Level CONFIG = new Level("CONFIG", 700, defaultBundle);
    public static final Level FINE = new Level("FINE", 500, defaultBundle);
    public static final Level FINER = new Level("FINER", 400, defaultBundle);
    public static final Level FINEST = new Level("FINEST", 300, defaultBundle);
    public static final Level ALL = new Level("ALL", Integer.MIN_VALUE, defaultBundle);

    protected Level(String name, int value) {
        this(name, value, null);
    }

    protected Level(String name, int value, String resourceBundleName) {
        this(name, value, resourceBundleName, true);
    }

    private Level(String name, int value, String resourceBundleName, boolean visible) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.value = value;
        this.resourceBundleName = resourceBundleName;
        this.localizedLevelName = resourceBundleName == null ? name : null;
        this.cachedLocale = null;
        if (visible) {
            KnownLevel.add(this);
        }
    }

    public String getResourceBundleName() {
        return this.resourceBundleName;
    }

    public String getName() {
        return this.name;
    }

    public String getLocalizedName() {
        return getLocalizedLevelName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getLevelName() {
        return this.name;
    }

    private String computeLocalizedLevelName(Locale newLocale) {
        ResourceBundle rb2 = ResourceBundle.getBundle(this.resourceBundleName, newLocale, Thread.currentThread().getContextClassLoader());
        String localizedName = rb2.getString(this.name);
        boolean isDefaultBundle = defaultBundle.equals(this.resourceBundleName);
        if (!isDefaultBundle) {
            return localizedName;
        }
        Locale rbLocale = rb2.getLocale();
        Locale locale = (Locale.ROOT.equals(rbLocale) || this.name.equals(localizedName.toUpperCase(Locale.ROOT))) ? Locale.ROOT : rbLocale;
        return Locale.ROOT.equals(locale) ? this.name : localizedName.toUpperCase(locale);
    }

    final String getCachedLocalizedLevelName() {
        Locale locale;
        if (this.localizedLevelName != null && (locale = this.cachedLocale) != null && locale.equals(Locale.getDefault())) {
            return this.localizedLevelName;
        }
        if (this.resourceBundleName == null) {
            return this.name;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized String getLocalizedLevelName() {
        String cachedLocalizedName = getCachedLocalizedLevelName();
        if (cachedLocalizedName != null) {
            return cachedLocalizedName;
        }
        Locale newLocale = Locale.getDefault();
        try {
            this.localizedLevelName = computeLocalizedLevelName(newLocale);
        } catch (Exception e2) {
            this.localizedLevelName = this.name;
        }
        this.cachedLocale = newLocale;
        return this.localizedLevelName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Level findLevel(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        KnownLevel level = KnownLevel.findByName(name);
        if (level != null) {
            return level.mirroredLevel;
        }
        try {
            int x10 = Integer.parseInt(name);
            KnownLevel level2 = KnownLevel.findByValue(x10);
            if (level2 == null) {
                new Level(name, x10);
                level2 = KnownLevel.findByValue(x10);
            }
            Level levelObject = level2.mirroredLevel;
            return levelObject;
        } catch (NumberFormatException e2) {
            KnownLevel level3 = KnownLevel.findByLocalizedLevelName(name);
            if (level3 != null) {
                return level3.mirroredLevel;
            }
            return null;
        }
    }

    public final String toString() {
        return this.name;
    }

    public final int intValue() {
        return this.value;
    }

    private Object readResolve() {
        KnownLevel o10 = KnownLevel.matches(this);
        if (o10 != null) {
            return o10.levelObject;
        }
        Level level = new Level(this.name, this.value, this.resourceBundleName);
        return level;
    }

    public static synchronized Level parse(String name) throws IllegalArgumentException {
        synchronized (Level.class) {
            name.length();
            KnownLevel level = KnownLevel.findByName(name);
            if (level != null) {
                return level.levelObject;
            }
            try {
                int x10 = Integer.parseInt(name);
                KnownLevel level2 = KnownLevel.findByValue(x10);
                if (level2 == null) {
                    new Level(name, x10);
                    level2 = KnownLevel.findByValue(x10);
                }
                Level levelObject = level2.levelObject;
                return levelObject;
            } catch (NumberFormatException e2) {
                KnownLevel level3 = KnownLevel.findByLocalizedLevelName(name);
                if (level3 != null) {
                    return level3.levelObject;
                }
                throw new IllegalArgumentException("Bad level \"" + name + "\"");
            }
        }
    }

    public boolean equals(Object ox) {
        try {
            Level lx = (Level) ox;
            return lx.value == this.value;
        } catch (Exception e2) {
            return false;
        }
    }

    public int hashCode() {
        return this.value;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class KnownLevel {
        final Level levelObject;
        final Level mirroredLevel;
        private static Map<String, List<KnownLevel>> nameToLevels = new HashMap();
        private static Map<Integer, List<KnownLevel>> intToLevels = new HashMap();

        KnownLevel(Level l10) {
            this.levelObject = l10;
            if (l10.getClass() == Level.class) {
                this.mirroredLevel = l10;
            } else {
                this.mirroredLevel = new Level(l10.name, l10.value, l10.resourceBundleName, false);
            }
        }

        static synchronized void add(Level l10) {
            synchronized (KnownLevel.class) {
                KnownLevel o10 = new KnownLevel(l10);
                List<KnownLevel> list = nameToLevels.get(l10.name);
                if (list == null) {
                    list = new ArrayList();
                    nameToLevels.put(l10.name, list);
                }
                list.add(o10);
                List<KnownLevel> list2 = intToLevels.get(Integer.valueOf(l10.value));
                if (list2 == null) {
                    list2 = new ArrayList();
                    intToLevels.put(Integer.valueOf(l10.value), list2);
                }
                list2.add(o10);
            }
        }

        static synchronized KnownLevel findByName(String name) {
            synchronized (KnownLevel.class) {
                List<KnownLevel> list = nameToLevels.get(name);
                if (list == null) {
                    return null;
                }
                return list.get(0);
            }
        }

        static synchronized KnownLevel findByValue(int value) {
            synchronized (KnownLevel.class) {
                List<KnownLevel> list = intToLevels.get(Integer.valueOf(value));
                if (list == null) {
                    return null;
                }
                return list.get(0);
            }
        }

        static synchronized KnownLevel findByLocalizedLevelName(String name) {
            synchronized (KnownLevel.class) {
                for (List<KnownLevel> levels : nameToLevels.values()) {
                    for (KnownLevel l10 : levels) {
                        String lname = l10.levelObject.getLocalizedLevelName();
                        if (name.equals(lname)) {
                            return l10;
                        }
                    }
                }
                return null;
            }
        }

        static synchronized KnownLevel matches(Level l10) {
            synchronized (KnownLevel.class) {
                List<KnownLevel> list = nameToLevels.get(l10.name);
                if (list != null) {
                    for (KnownLevel level : list) {
                        Level other = level.mirroredLevel;
                        Class<?> cls = level.levelObject.getClass();
                        if (l10.value == other.value && (l10.resourceBundleName == other.resourceBundleName || (l10.resourceBundleName != null && l10.resourceBundleName.equals(other.resourceBundleName)))) {
                            if (cls == l10.getClass()) {
                                return level;
                            }
                        }
                    }
                }
                return null;
            }
        }
    }
}
