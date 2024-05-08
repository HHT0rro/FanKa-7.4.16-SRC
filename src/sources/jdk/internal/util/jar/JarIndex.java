package jdk.internal.util.jar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.io.IOUtils;
import sun.security.action.GetPropertyAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class JarIndex {
    public static final String INDEX_NAME = "META-INF/INDEX.LIST";
    private static final boolean metaInfFilenames = "true".equals(GetPropertyAction.privilegedGetProperty("sun.misc.JarIndex.metaInfFilenames"));
    private HashMap<String, LinkedList<String>> indexMap;
    private String[] jarFiles;
    private HashMap<String, LinkedList<String>> jarMap;

    public JarIndex() {
        this.indexMap = new HashMap<>();
        this.jarMap = new HashMap<>();
    }

    public JarIndex(InputStream is) throws IOException {
        this();
        read(is);
    }

    public JarIndex(String[] files) throws IOException {
        this();
        this.jarFiles = files;
        parseJars(files);
    }

    public static JarIndex getJarIndex(JarFile jar) throws IOException {
        JarEntry e2 = jar.getJarEntry(INDEX_NAME);
        if (e2 == null) {
            return null;
        }
        JarIndex index = new JarIndex(jar.getInputStream(e2));
        return index;
    }

    public String[] getJarFiles() {
        return this.jarFiles;
    }

    private void addToList(String key, String value, HashMap<String, LinkedList<String>> t2) {
        LinkedList<String> list = t2.get(key);
        if (list == null) {
            LinkedList<String> list2 = new LinkedList<>();
            list2.add(value);
            t2.put(key, list2);
        } else if (!list.contains(value)) {
            list.add(value);
        }
    }

    public LinkedList<String> get(String fileName) {
        int pos;
        LinkedList<String> jarFiles = this.indexMap.get(fileName);
        return (jarFiles != null || (pos = fileName.lastIndexOf(47)) == -1) ? jarFiles : this.indexMap.get(fileName.substring(0, pos));
    }

    public void add(String fileName, String jarName) {
        String packageName;
        int pos = fileName.lastIndexOf(47);
        if (pos != -1) {
            packageName = fileName.substring(0, pos);
        } else {
            packageName = fileName;
        }
        addMapping(packageName, jarName);
    }

    private void addMapping(String jarItem, String jarName) {
        addToList(jarItem, jarName, this.indexMap);
        addToList(jarName, jarItem, this.jarMap);
    }

    private void parseJars(String[] files) throws IOException {
        if (files == null) {
            return;
        }
        for (String currentJar : files) {
            ZipFile zrf = new ZipFile(currentJar.replace(IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar));
            Enumeration<? extends ZipEntry> entries = zrf.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                String fileName = entry.getName();
                if (!fileName.equals("META-INF/") && !fileName.equals(INDEX_NAME) && !fileName.equals(JarFile.MANIFEST_NAME) && !fileName.startsWith("META-INF/versions/")) {
                    if (!metaInfFilenames || !fileName.startsWith("META-INF/")) {
                        add(fileName, currentJar);
                    } else if (!entry.isDirectory()) {
                        addMapping(fileName, currentJar);
                    }
                }
            }
            zrf.close();
        }
    }

    public void write(OutputStream out) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
        bw.write("JarIndex-Version: 1.0\n\n");
        if (this.jarFiles != null) {
            int i10 = 0;
            while (true) {
                String[] strArr = this.jarFiles;
                if (i10 < strArr.length) {
                    String jar = strArr[i10];
                    bw.write(jar + "\n");
                    LinkedList<String> jarlist = this.jarMap.get(jar);
                    if (jarlist != null) {
                        Iterator<String> listitr = jarlist.iterator2();
                        while (listitr.hasNext()) {
                            bw.write(listitr.next() + "\n");
                        }
                    }
                    bw.write("\n");
                    i10++;
                } else {
                    bw.flush();
                    return;
                }
            }
        }
    }

    public void read(InputStream is) throws IOException {
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String currentJar = null;
        Vector<String> jars = new Vector<>();
        do {
            String readLine = br.readLine();
            line = readLine;
            if (readLine == null) {
                break;
            }
        } while (!line.endsWith(".jar"));
        while (line != null) {
            if (!line.isEmpty()) {
                if (line.endsWith(".jar")) {
                    currentJar = line;
                    jars.add(currentJar);
                } else {
                    String name = line;
                    addMapping(name, currentJar);
                }
            }
            line = br.readLine();
        }
        this.jarFiles = (String[]) jars.toArray(new String[jars.size()]);
    }

    public void merge(JarIndex toIndex, String path) {
        for (Map.Entry<String, LinkedList<String>> e2 : this.indexMap.entrySet()) {
            String packageName = e2.getKey();
            LinkedList<String> from_list = e2.getValue();
            Iterator<String> listItr = from_list.iterator2();
            while (listItr.hasNext()) {
                String jarName = listItr.next();
                if (path != null) {
                    jarName = path.concat(jarName);
                }
                toIndex.addMapping(packageName, jarName);
            }
        }
    }
}
