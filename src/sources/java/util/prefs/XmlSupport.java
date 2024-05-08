package java.util.prefs;

import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import sun.security.x509.PolicyMappingsExtension;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class XmlSupport {
    private static final String EXTERNAL_XML_VERSION = "1.0";
    private static final String MAP_XML_VERSION = "1.0";
    private static final String PREFS_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!-- DTD for preferences --><!ELEMENT preferences (root) ><!ATTLIST preferences EXTERNAL_XML_VERSION CDATA \"0.0\"  ><!ELEMENT root (map, node*) ><!ATTLIST root          type (system|user) #REQUIRED ><!ELEMENT node (map, node*) ><!ATTLIST node          name CDATA #REQUIRED ><!ELEMENT map (entry*) ><!ATTLIST map  MAP_XML_VERSION CDATA \"0.0\"  ><!ELEMENT entry EMPTY ><!ATTLIST entry          key CDATA #REQUIRED          value CDATA #REQUIRED >";
    private static final String PREFS_DTD_URI = "http://java.sun.com/dtd/preferences.dtd";

    XmlSupport() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void export(OutputStream os, Preferences p10, boolean subTree) throws IOException, BackingStoreException {
        if (((AbstractPreferences) p10).isRemoved()) {
            throw new IllegalStateException("Node has been removed");
        }
        Document doc = createPrefsDoc("preferences");
        Element preferences = doc.getDocumentElement();
        preferences.setAttribute("EXTERNAL_XML_VERSION", "1.0");
        Element xmlRoot = (Element) preferences.appendChild(doc.createElement("root"));
        xmlRoot.setAttribute("type", p10.isUserNode() ? UserData.NAME : "system");
        List<Preferences> ancestors = new ArrayList<>();
        Preferences kid = p10;
        Preferences dad = kid.parent();
        while (dad != null) {
            ancestors.add(kid);
            kid = dad;
            dad = kid.parent();
        }
        Element e2 = xmlRoot;
        for (int i10 = ancestors.size() - 1; i10 >= 0; i10--) {
            e2.appendChild(doc.createElement(PolicyMappingsExtension.MAP));
            e2 = (Element) e2.appendChild(doc.createElement("node"));
            e2.setAttribute("name", ancestors.get(i10).name());
        }
        putPreferencesInXml(e2, doc, p10, subTree);
        writeDoc(doc, os);
    }

    private static void putPreferencesInXml(Element elt, Document doc, Preferences prefs, boolean subTree) throws BackingStoreException {
        Preferences[] kidsCopy = null;
        String[] kidNames = null;
        synchronized (((AbstractPreferences) prefs).lock) {
            if (((AbstractPreferences) prefs).isRemoved()) {
                elt.getParentNode().removeChild(elt);
                return;
            }
            String[] keys = prefs.keys();
            Element map = (Element) elt.appendChild(doc.createElement(PolicyMappingsExtension.MAP));
            for (int i10 = 0; i10 < keys.length; i10++) {
                Element entry = (Element) map.appendChild(doc.createElement("entry"));
                entry.setAttribute("key", keys[i10]);
                entry.setAttribute("value", prefs.get(keys[i10], null));
            }
            if (subTree) {
                kidNames = prefs.childrenNames();
                kidsCopy = new Preferences[kidNames.length];
                for (int i11 = 0; i11 < kidNames.length; i11++) {
                    kidsCopy[i11] = prefs.node(kidNames[i11]);
                }
            }
            if (subTree) {
                for (int i12 = 0; i12 < kidNames.length; i12++) {
                    Element xmlKid = (Element) elt.appendChild(doc.createElement("node"));
                    xmlKid.setAttribute("name", kidNames[i12]);
                    putPreferencesInXml(xmlKid, doc, kidsCopy[i12], subTree);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void importPreferences(InputStream is) throws IOException, InvalidPreferencesFormatException {
        try {
            Document doc = loadPrefsDoc(is);
            String xmlVersion = doc.getDocumentElement().getAttribute("EXTERNAL_XML_VERSION");
            if (xmlVersion.compareTo("1.0") > 0) {
                throw new InvalidPreferencesFormatException("Exported preferences file format version " + xmlVersion + " is not supported. This java installation can read versions 1.0 or older. You may need to install a newer version of JDK.");
            }
            NodeList elements = doc.getDocumentElement().getElementsByTagName("root");
            if (elements == null || elements.getLength() != 1) {
                throw new InvalidPreferencesFormatException("invalid root node");
            }
            Element xmlRoot = (Element) elements.item(0);
            Preferences prefsRoot = xmlRoot.getAttribute("type").equals(UserData.NAME) ? Preferences.userRoot() : Preferences.systemRoot();
            ImportSubtree(prefsRoot, xmlRoot);
        } catch (SAXException e2) {
            throw new InvalidPreferencesFormatException(e2);
        }
    }

    private static Document createPrefsDoc(String qname) {
        try {
            DOMImplementation di = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation();
            DocumentType dt = di.createDocumentType(qname, null, PREFS_DTD_URI);
            return di.createDocument(null, qname, dt);
        } catch (ParserConfigurationException e2) {
            throw new AssertionError(e2);
        }
    }

    private static Document loadPrefsDoc(InputStream inputStream) throws SAXException, IOException {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setIgnoringElementContentWhitespace(true);
        newInstance.setCoalescing(true);
        newInstance.setIgnoringComments(true);
        try {
            DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
            newDocumentBuilder.setEntityResolver(new Resolver());
            newDocumentBuilder.setErrorHandler(new EH());
            return newDocumentBuilder.parse(new InputSource(inputStream));
        } catch (ParserConfigurationException e2) {
            throw new AssertionError(e2);
        }
    }

    private static final void writeDoc(Document doc, OutputStream out) throws IOException {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            try {
                tf.setAttribute("indent-number", new Integer(2));
            } catch (IllegalArgumentException e2) {
            }
            Transformer t2 = tf.newTransformer();
            t2.setOutputProperty("doctype-system", doc.getDoctype().getSystemId());
            t2.setOutputProperty("indent", "yes");
            t2.transform(new DOMSource(doc), new StreamResult(new BufferedWriter(new OutputStreamWriter(out, "UTF-8"))));
        } catch (TransformerException e10) {
            throw new AssertionError(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class NodeListAdapter implements NodeList {
        private final List<? extends Node> delegate;

        public NodeListAdapter(List<? extends Node> delegate) {
            this.delegate = (List) Objects.requireNonNull(delegate);
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int index) {
            if (index < 0 || index >= this.delegate.size()) {
                return null;
            }
            return this.delegate.get(index);
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            return this.delegate.size();
        }
    }

    private static NodeList elementNodesOf(NodeList xmlKids) {
        List<Element> elements = new ArrayList<>(xmlKids.getLength());
        for (int i10 = 0; i10 < xmlKids.getLength(); i10++) {
            Node node = xmlKids.item(i10);
            if (node instanceof Element) {
                elements.add((Element) node);
            }
        }
        return new NodeListAdapter(elements);
    }

    private static void ImportSubtree(Preferences prefsNode, Element xmlNode) {
        NodeList xmlKids = elementNodesOf(xmlNode.getChildNodes());
        int numXmlKids = xmlKids.getLength();
        synchronized (((AbstractPreferences) prefsNode).lock) {
            if (((AbstractPreferences) prefsNode).isRemoved()) {
                return;
            }
            Element firstXmlKid = (Element) xmlKids.item(0);
            ImportPrefs(prefsNode, firstXmlKid);
            Preferences[] prefsKids = new Preferences[numXmlKids - 1];
            for (int i10 = 1; i10 < numXmlKids; i10++) {
                Element xmlKid = (Element) xmlKids.item(i10);
                prefsKids[i10 - 1] = prefsNode.node(xmlKid.getAttribute("name"));
            }
            for (int i11 = 1; i11 < numXmlKids; i11++) {
                ImportSubtree(prefsKids[i11 - 1], (Element) xmlKids.item(i11));
            }
        }
    }

    private static void ImportPrefs(Preferences prefsNode, Element map) {
        NodeList entries = elementNodesOf(map.getChildNodes());
        int numEntries = entries.getLength();
        for (int i10 = 0; i10 < numEntries; i10++) {
            Element entry = (Element) entries.item(i10);
            prefsNode.put(entry.getAttribute("key"), entry.getAttribute("value"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void exportMap(OutputStream os, Map<String, String> map) throws IOException {
        Document doc = createPrefsDoc(PolicyMappingsExtension.MAP);
        Element xmlMap = doc.getDocumentElement();
        xmlMap.setAttribute("MAP_XML_VERSION", "1.0");
        for (Map.Entry<String, String> e2 : map.entrySet()) {
            Element xe = (Element) xmlMap.appendChild(doc.createElement("entry"));
            xe.setAttribute("key", e2.getKey());
            xe.setAttribute("value", e2.getValue());
        }
        writeDoc(doc, os);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void importMap(InputStream is, Map<String, String> m10) throws IOException, InvalidPreferencesFormatException {
        try {
            Document doc = loadPrefsDoc(is);
            Element xmlMap = doc.getDocumentElement();
            String mapVersion = xmlMap.getAttribute("MAP_XML_VERSION");
            if (mapVersion.compareTo("1.0") > 0) {
                throw new InvalidPreferencesFormatException("Preferences map file format version " + mapVersion + " is not supported. This java installation can read versions 1.0 or older. You may need to install a newer version of JDK.");
            }
            NodeList entries = xmlMap.getChildNodes();
            int numEntries = entries.getLength();
            for (int i10 = 0; i10 < numEntries; i10++) {
                if (entries.item(i10) instanceof Element) {
                    Element entry = (Element) entries.item(i10);
                    m10.put(entry.getAttribute("key"), entry.getAttribute("value"));
                }
            }
        } catch (SAXException e2) {
            throw new InvalidPreferencesFormatException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Resolver implements EntityResolver {
        private Resolver() {
        }

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String pid, String sid) throws SAXException {
            if (sid.equals(XmlSupport.PREFS_DTD_URI)) {
                InputSource is = new InputSource(new StringReader(XmlSupport.PREFS_DTD));
                is.setSystemId(XmlSupport.PREFS_DTD_URI);
                return is;
            }
            throw new SAXException("Invalid system identifier: " + sid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class EH implements ErrorHandler {
        private EH() {
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException x10) throws SAXException {
            throw x10;
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException x10) throws SAXException {
            throw x10;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException x10) throws SAXException {
            throw x10;
        }
    }
}
