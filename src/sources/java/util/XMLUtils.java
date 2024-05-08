package java.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class XMLUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EXTERNAL_XML_VERSION = "1.0";
    private static final String PROPS_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!-- DTD for properties --><!ELEMENT properties ( comment?, entry* ) ><!ATTLIST properties version CDATA #FIXED \"1.0\"><!ELEMENT comment (#PCDATA) ><!ELEMENT entry (#PCDATA) ><!ATTLIST entry  key CDATA #REQUIRED>";
    private static final String PROPS_DTD_URI = "http://java.sun.com/dtd/properties.dtd";

    XMLUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void load(Properties props, InputStream in) throws IOException, InvalidPropertiesFormatException {
        try {
            Document doc = getLoadingDoc(in);
            Element propertiesElement = doc.getDocumentElement();
            String xmlVersion = propertiesElement.getAttribute("version");
            if (xmlVersion.compareTo("1.0") > 0) {
                throw new InvalidPropertiesFormatException("Exported Properties file format version " + xmlVersion + " is not supported. This java installation can read versions 1.0 or older. You may need to install a newer version of JDK.");
            }
            importProperties(props, propertiesElement);
        } catch (SAXException saxe) {
            throw new InvalidPropertiesFormatException(saxe);
        }
    }

    static Document getLoadingDoc(InputStream inputStream) throws SAXException, IOException {
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
            throw new Error(e2);
        }
    }

    static void importProperties(Properties props, Element propertiesElement) {
        NodeList entries = propertiesElement.getChildNodes();
        int numEntries = entries.getLength();
        int start = 0;
        if (numEntries > 0 && entries.item(0).getNodeName().equals(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT)) {
            start = 1;
        }
        for (int i10 = start; i10 < numEntries; i10++) {
            if (entries.item(i10) instanceof Element) {
                Element entry = (Element) entries.item(i10);
                if (entry.hasAttribute("key")) {
                    Node n10 = entry.getFirstChild();
                    String val = n10 == null ? "" : n10.getNodeValue();
                    props.setProperty(entry.getAttribute("key"), val);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void save(Properties props, OutputStream os, String comment, String encoding) throws IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db2 = null;
        try {
            db2 = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e2) {
        }
        Document doc = db2.newDocument();
        Element properties = (Element) doc.appendChild(doc.createElement("properties"));
        if (comment != null) {
            Element comments = (Element) properties.appendChild(doc.createElement(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT));
            comments.appendChild(doc.createTextNode(comment));
        }
        synchronized (props) {
            for (String key : props.stringPropertyNames()) {
                Element entry = (Element) properties.appendChild(doc.createElement("entry"));
                entry.setAttribute("key", key);
                entry.appendChild(doc.createTextNode(props.getProperty(key)));
            }
        }
        emitDocument(doc, os, encoding);
    }

    static void emitDocument(Document doc, OutputStream os, String encoding) throws IOException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t2 = null;
        try {
            t2 = tf.newTransformer();
            t2.setOutputProperty("doctype-system", PROPS_DTD_URI);
            t2.setOutputProperty("indent", "yes");
            t2.setOutputProperty("method", "xml");
            t2.setOutputProperty("encoding", encoding);
        } catch (TransformerConfigurationException e2) {
        }
        DOMSource doms = new DOMSource(doc);
        StreamResult sr = new StreamResult(os);
        try {
            t2.transform(doms, sr);
        } catch (TransformerException te) {
            IOException ioe = new IOException();
            ioe.initCause(te);
            throw ioe;
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
            if (sid.equals(XMLUtils.PROPS_DTD_URI)) {
                InputSource is = new InputSource(new StringReader(XMLUtils.PROPS_DTD));
                is.setSystemId(XMLUtils.PROPS_DTD_URI);
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
