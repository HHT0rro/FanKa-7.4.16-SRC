package sun.util.locale;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class LocaleMatcher {
    public static List<Locale> filter(List<Locale.LanguageRange> priorityList, Collection<Locale> locales, Locale.FilteringMode mode) {
        if (priorityList.isEmpty() || locales.isEmpty()) {
            return new ArrayList();
        }
        List<String> tags = new ArrayList<>();
        for (Locale locale : locales) {
            tags.add(locale.toLanguageTag());
        }
        List<String> filteredTags = filterTags(priorityList, tags, mode);
        List<Locale> filteredLocales = new ArrayList<>(filteredTags.size());
        for (String tag : filteredTags) {
            filteredLocales.add(Locale.forLanguageTag(tag));
        }
        return filteredLocales;
    }

    public static List<String> filterTags(List<Locale.LanguageRange> priorityList, Collection<String> tags, Locale.FilteringMode mode) {
        String range;
        if (priorityList.isEmpty() || tags.isEmpty()) {
            return new ArrayList();
        }
        if (mode == Locale.FilteringMode.EXTENDED_FILTERING) {
            return filterExtended(priorityList, tags);
        }
        ArrayList<Locale.LanguageRange> list = new ArrayList<>();
        for (Locale.LanguageRange lr : priorityList) {
            String range2 = lr.getRange();
            if (range2.startsWith("*-") || range2.indexOf("-*") != -1) {
                if (mode == Locale.FilteringMode.AUTOSELECT_FILTERING) {
                    return filterExtended(priorityList, tags);
                }
                if (mode == Locale.FilteringMode.MAP_EXTENDED_RANGES) {
                    if (range2.charAt(0) == '*') {
                        range = StringUtils.NO_PRINT_CODE;
                    } else {
                        range = range2.replaceAll("-[*]", "");
                    }
                    list.add(new Locale.LanguageRange(range, lr.getWeight()));
                } else if (mode == Locale.FilteringMode.REJECT_EXTENDED_RANGES) {
                    throw new IllegalArgumentException("An extended range \"" + range2 + "\" found in REJECT_EXTENDED_RANGES mode.");
                }
            } else {
                list.add(lr);
            }
        }
        return filterBasic(list, tags);
    }

    private static List<String> filterBasic(List<Locale.LanguageRange> priorityList, Collection<String> tags) {
        List<Locale.LanguageRange> nonZeroRanges;
        List<Locale.LanguageRange> zeroRanges;
        int len;
        int splitIndex = splitRanges(priorityList);
        if (splitIndex != -1) {
            nonZeroRanges = priorityList.subList(0, splitIndex);
            zeroRanges = priorityList.subList(splitIndex, priorityList.size());
        } else {
            nonZeroRanges = priorityList;
            zeroRanges = List.of();
        }
        List<String> list = new ArrayList<>();
        for (Locale.LanguageRange lr : nonZeroRanges) {
            String range = lr.getRange();
            if (range.equals(StringUtils.NO_PRINT_CODE)) {
                return new ArrayList(removeTagsMatchingBasicZeroRange(zeroRanges, tags));
            }
            for (String tag : tags) {
                String lowerCaseTag = tag.toLowerCase(Locale.ROOT);
                if (lowerCaseTag.startsWith(range) && (lowerCaseTag.length() == (len = range.length()) || lowerCaseTag.charAt(len) == '-')) {
                    if (!caseInsensitiveMatch(list, lowerCaseTag) && !shouldIgnoreFilterBasicMatch(zeroRanges, lowerCaseTag)) {
                        list.add(tag);
                    }
                }
            }
        }
        return list;
    }

    private static Collection<String> removeTagsMatchingBasicZeroRange(List<Locale.LanguageRange> zeroRange, Collection<String> tags) {
        if (zeroRange.isEmpty()) {
            return removeDuplicates(tags);
        }
        List<String> matchingTags = new ArrayList<>();
        for (String tag : tags) {
            String lowerCaseTag = tag.toLowerCase(Locale.ROOT);
            if (!shouldIgnoreFilterBasicMatch(zeroRange, lowerCaseTag) && !caseInsensitiveMatch(matchingTags, lowerCaseTag)) {
                matchingTags.add(tag);
            }
        }
        return matchingTags;
    }

    private static Collection<String> removeDuplicates(Collection<String> tags) {
        final Set<String> distinctTags = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        return (Collection) tags.stream().filter(new Predicate() { // from class: sun.util.locale.LocaleMatcher$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean add;
                add = Set.this.add((String) obj);
                return add;
            }
        }).collect(Collectors.toList());
    }

    private static boolean caseInsensitiveMatch(List<String> list, final String tag) {
        return list.stream().anyMatch(new Predicate() { // from class: sun.util.locale.LocaleMatcher$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean equalsIgnoreCase;
                equalsIgnoreCase = ((String) obj).equalsIgnoreCase(String.this);
                return equalsIgnoreCase;
            }
        });
    }

    private static boolean shouldIgnoreFilterBasicMatch(List<Locale.LanguageRange> zeroRange, String tag) {
        int len;
        if (zeroRange.isEmpty()) {
            return false;
        }
        for (Locale.LanguageRange lr : zeroRange) {
            String range = lr.getRange();
            if (range.equals(StringUtils.NO_PRINT_CODE)) {
                return true;
            }
            if (tag.startsWith(range) && (tag.length() == (len = range.length()) || tag.charAt(len) == '-')) {
                return true;
            }
        }
        return false;
    }

    private static List<String> filterExtended(List<Locale.LanguageRange> priorityList, Collection<String> tags) {
        List<Locale.LanguageRange> nonZeroRanges;
        List<Locale.LanguageRange> zeroRanges;
        int splitIndex = splitRanges(priorityList);
        if (splitIndex != -1) {
            nonZeroRanges = priorityList.subList(0, splitIndex);
            zeroRanges = priorityList.subList(splitIndex, priorityList.size());
        } else {
            nonZeroRanges = priorityList;
            zeroRanges = List.of();
        }
        List<String> list = new ArrayList<>();
        for (Locale.LanguageRange lr : nonZeroRanges) {
            String range = lr.getRange();
            if (range.equals(StringUtils.NO_PRINT_CODE)) {
                return new ArrayList(removeTagsMatchingExtendedZeroRange(zeroRanges, tags));
            }
            String[] rangeSubtags = range.split("-");
            for (String tag : tags) {
                String lowerCaseTag = tag.toLowerCase(Locale.ROOT);
                String[] tagSubtags = lowerCaseTag.split("-");
                int splitIndex2 = splitIndex;
                List<Locale.LanguageRange> nonZeroRanges2 = nonZeroRanges;
                if (rangeSubtags[0].equals(tagSubtags[0]) || rangeSubtags[0].equals(StringUtils.NO_PRINT_CODE)) {
                    int rangeIndex = matchFilterExtendedSubtags(rangeSubtags, tagSubtags);
                    if (rangeSubtags.length == rangeIndex && !caseInsensitiveMatch(list, lowerCaseTag) && !shouldIgnoreFilterExtendedMatch(zeroRanges, lowerCaseTag)) {
                        list.add(tag);
                    }
                    splitIndex = splitIndex2;
                    nonZeroRanges = nonZeroRanges2;
                } else {
                    splitIndex = splitIndex2;
                    nonZeroRanges = nonZeroRanges2;
                }
            }
        }
        return list;
    }

    private static Collection<String> removeTagsMatchingExtendedZeroRange(List<Locale.LanguageRange> zeroRange, Collection<String> tags) {
        if (zeroRange.isEmpty()) {
            return removeDuplicates(tags);
        }
        List<String> matchingTags = new ArrayList<>();
        for (String tag : tags) {
            String lowerCaseTag = tag.toLowerCase(Locale.ROOT);
            if (!shouldIgnoreFilterExtendedMatch(zeroRange, lowerCaseTag) && !caseInsensitiveMatch(matchingTags, lowerCaseTag)) {
                matchingTags.add(tag);
            }
        }
        return matchingTags;
    }

    private static boolean shouldIgnoreFilterExtendedMatch(List<Locale.LanguageRange> zeroRange, String tag) {
        if (zeroRange.isEmpty()) {
            return false;
        }
        String[] tagSubtags = tag.split("-");
        for (Locale.LanguageRange lr : zeroRange) {
            String range = lr.getRange();
            if (range.equals(StringUtils.NO_PRINT_CODE)) {
                return true;
            }
            String[] rangeSubtags = range.split("-");
            if (rangeSubtags[0].equals(tagSubtags[0]) || rangeSubtags[0].equals(StringUtils.NO_PRINT_CODE)) {
                int rangeIndex = matchFilterExtendedSubtags(rangeSubtags, tagSubtags);
                if (rangeSubtags.length == rangeIndex) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int matchFilterExtendedSubtags(String[] rangeSubtags, String[] tagSubtags) {
        int rangeIndex = 1;
        int tagIndex = 1;
        while (rangeIndex < rangeSubtags.length && tagIndex < tagSubtags.length) {
            if (rangeSubtags[rangeIndex].equals(StringUtils.NO_PRINT_CODE)) {
                rangeIndex++;
            } else if (rangeSubtags[rangeIndex].equals(tagSubtags[tagIndex])) {
                rangeIndex++;
                tagIndex++;
            } else {
                if (tagSubtags[tagIndex].length() == 1 && !tagSubtags[tagIndex].equals(StringUtils.NO_PRINT_CODE)) {
                    break;
                }
                tagIndex++;
            }
        }
        return rangeIndex;
    }

    public static Locale lookup(List<Locale.LanguageRange> priorityList, Collection<Locale> locales) {
        if (priorityList.isEmpty() || locales.isEmpty()) {
            return null;
        }
        List<String> tags = new ArrayList<>();
        for (Locale locale : locales) {
            tags.add(locale.toLanguageTag());
        }
        String lookedUpTag = lookupTag(priorityList, tags);
        if (lookedUpTag == null) {
            return null;
        }
        return Locale.forLanguageTag(lookedUpTag);
    }

    public static String lookupTag(List<Locale.LanguageRange> priorityList, Collection<String> tags) {
        List<Locale.LanguageRange> nonZeroRanges;
        List<Locale.LanguageRange> zeroRanges;
        if (priorityList.isEmpty() || tags.isEmpty()) {
            return null;
        }
        int splitIndex = splitRanges(priorityList);
        if (splitIndex != -1) {
            nonZeroRanges = priorityList.subList(0, splitIndex);
            zeroRanges = priorityList.subList(splitIndex, priorityList.size());
        } else {
            nonZeroRanges = priorityList;
            zeroRanges = List.of();
        }
        for (Locale.LanguageRange lr : nonZeroRanges) {
            String range = lr.getRange();
            if (!range.equals(StringUtils.NO_PRINT_CODE)) {
                for (String rangeForRegex = range.replace(StringUtils.NO_PRINT_CODE, "\\p{Alnum}*"); !rangeForRegex.isEmpty(); rangeForRegex = truncateRange(rangeForRegex)) {
                    for (String tag : tags) {
                        String lowerCaseTag = tag.toLowerCase(Locale.ROOT);
                        if (lowerCaseTag.matches(rangeForRegex) && !shouldIgnoreLookupMatch(zeroRanges, lowerCaseTag)) {
                            return tag;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static boolean shouldIgnoreLookupMatch(List<Locale.LanguageRange> zeroRange, String tag) {
        for (Locale.LanguageRange lr : zeroRange) {
            String range = lr.getRange();
            if (!range.equals(StringUtils.NO_PRINT_CODE)) {
                for (String rangeForRegex = range.replace(StringUtils.NO_PRINT_CODE, "\\p{Alnum}*"); !rangeForRegex.isEmpty(); rangeForRegex = truncateRange(rangeForRegex)) {
                    if (tag.matches(rangeForRegex)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static String truncateRange(String rangeForRegex) {
        int index = rangeForRegex.lastIndexOf(45);
        if (index >= 0) {
            String rangeForRegex2 = rangeForRegex.substring(0, index);
            int index2 = rangeForRegex2.lastIndexOf(45);
            if (index2 >= 0 && index2 == rangeForRegex2.length() - 2) {
                return rangeForRegex2.substring(0, rangeForRegex2.length() - 2);
            }
            return rangeForRegex2;
        }
        return "";
    }

    private static int splitRanges(List<Locale.LanguageRange> priorityList) {
        int size = priorityList.size();
        for (int index = 0; index < size; index++) {
            Locale.LanguageRange range = priorityList.get(index);
            if (range.getWeight() == ShadowDrawableWrapper.COS_45) {
                return index;
            }
        }
        return -1;
    }

    public static List<Locale.LanguageRange> parse(String ranges) {
        String ranges2;
        String r10;
        double w3;
        String ranges3;
        int i10;
        int i11;
        String ranges4 = ranges.replace(" ", "").toLowerCase(Locale.ROOT);
        if (!ranges4.startsWith("accept-language:")) {
            ranges2 = ranges4;
        } else {
            ranges2 = ranges4.substring(16);
        }
        String[] langRanges = ranges2.split(",");
        List<Locale.LanguageRange> list = new ArrayList<>(langRanges.length);
        List<String> tempList = new ArrayList<>();
        int length = langRanges.length;
        int i12 = 0;
        int numOfRanges = 0;
        int numOfRanges2 = 0;
        while (numOfRanges2 < length) {
            String range = langRanges[numOfRanges2];
            int index = range.indexOf(";q=");
            if (index == -1) {
                r10 = range;
                w3 = 1.0d;
            } else {
                r10 = range.substring(i12, index);
                int index2 = index + 3;
                try {
                    w3 = Double.parseDouble(range.substring(index2));
                    if (w3 < ShadowDrawableWrapper.COS_45 || w3 > 1.0d) {
                        throw new IllegalArgumentException("weight=" + w3 + " for language range \"" + r10 + "\". It must be between " + ShadowDrawableWrapper.COS_45 + " and 1.0.");
                    }
                } catch (Exception e2) {
                    throw new IllegalArgumentException("weight=\"" + range.substring(index2) + "\" for language range \"" + r10 + "\"");
                }
            }
            if (tempList.contains(r10)) {
                ranges3 = ranges2;
            } else {
                Locale.LanguageRange lr = new Locale.LanguageRange(r10, w3);
                int index3 = numOfRanges;
                int j10 = 0;
                while (true) {
                    if (j10 >= numOfRanges) {
                        break;
                    }
                    if (list.get(j10).getWeight() >= w3) {
                        j10++;
                    } else {
                        index3 = j10;
                        break;
                    }
                }
                list.add(index3, lr);
                numOfRanges++;
                tempList.add(r10);
                String equivalent = getEquivalentForRegionAndVariant(r10);
                if (equivalent != null && !tempList.contains(equivalent)) {
                    list.add(index3 + 1, new Locale.LanguageRange(equivalent, w3));
                    numOfRanges++;
                    tempList.add(equivalent);
                }
                String[] equivalents = getEquivalentsForLanguage(r10);
                if (equivalents == null) {
                    ranges3 = ranges2;
                } else {
                    int length2 = equivalents.length;
                    ranges3 = ranges2;
                    int i13 = 0;
                    while (i13 < length2) {
                        String[] langRanges2 = langRanges;
                        String equiv = equivalents[i13];
                        if (tempList.contains(equiv)) {
                            i10 = length;
                            i11 = length2;
                        } else {
                            i10 = length;
                            i11 = length2;
                            list.add(index3 + 1, new Locale.LanguageRange(equiv, w3));
                            numOfRanges++;
                            tempList.add(equiv);
                        }
                        String equivalent2 = getEquivalentForRegionAndVariant(equiv);
                        if (equivalent2 != null && !tempList.contains(equivalent2)) {
                            list.add(index3 + 1, new Locale.LanguageRange(equivalent2, w3));
                            numOfRanges++;
                            tempList.add(equivalent2);
                        }
                        i13++;
                        length2 = i11;
                        langRanges = langRanges2;
                        length = i10;
                    }
                }
            }
            numOfRanges2++;
            ranges2 = ranges3;
            langRanges = langRanges;
            length = length;
            i12 = 0;
        }
        return list;
    }

    private static String replaceFirstSubStringMatch(String range, String substr, String replacement) {
        int pos = range.indexOf(substr);
        if (pos == -1) {
            return range;
        }
        return range.substring(0, pos) + replacement + range.substring(substr.length() + pos);
    }

    private static String[] getEquivalentsForLanguage(String range) {
        String r10 = range;
        while (!r10.isEmpty()) {
            if (LocaleEquivalentMaps.singleEquivMap.containsKey(r10)) {
                String equiv = LocaleEquivalentMaps.singleEquivMap.get(r10);
                return new String[]{replaceFirstSubStringMatch(range, r10, equiv)};
            }
            if (LocaleEquivalentMaps.multiEquivsMap.containsKey(r10)) {
                String[] equivs = LocaleEquivalentMaps.multiEquivsMap.get(r10);
                String[] result = new String[equivs.length];
                for (int i10 = 0; i10 < equivs.length; i10++) {
                    result[i10] = replaceFirstSubStringMatch(range, r10, equivs[i10]);
                }
                return result;
            }
            int index = r10.lastIndexOf(45);
            if (index != -1) {
                r10 = r10.substring(0, index);
            } else {
                return null;
            }
        }
        return null;
    }

    private static String getEquivalentForRegionAndVariant(String range) {
        int extensionKeyIndex = getExtentionKeyIndex(range);
        for (String subtag : LocaleEquivalentMaps.regionVariantEquivMap.h()) {
            int index = range.indexOf(subtag);
            if (index != -1 && (extensionKeyIndex == Integer.MIN_VALUE || index <= extensionKeyIndex)) {
                int len = subtag.length() + index;
                if (range.length() == len || range.charAt(len) == '-') {
                    return replaceFirstSubStringMatch(range, subtag, LocaleEquivalentMaps.regionVariantEquivMap.get(subtag));
                }
            }
        }
        return null;
    }

    private static int getExtentionKeyIndex(String s2) {
        char[] c4 = s2.toCharArray();
        int index = Integer.MIN_VALUE;
        for (int i10 = 1; i10 < c4.length; i10++) {
            if (c4[i10] == '-') {
                if (i10 - index == 2) {
                    return index;
                }
                index = i10;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static List<Locale.LanguageRange> mapEquivalents(List<Locale.LanguageRange> priorityList, Map<String, List<String>> map) {
        if (priorityList.isEmpty()) {
            return new ArrayList();
        }
        if (map == null || map.isEmpty()) {
            return new ArrayList(priorityList);
        }
        Map<String, String> keyMap = new HashMap<>();
        for (String key : map.h()) {
            keyMap.put(key.toLowerCase(Locale.ROOT), key);
        }
        List<Locale.LanguageRange> list = new ArrayList<>();
        for (Locale.LanguageRange lr : priorityList) {
            String range = lr.getRange();
            String r10 = range;
            boolean hasEquivalent = false;
            while (true) {
                if (r10.isEmpty()) {
                    break;
                }
                if (keyMap.containsKey(r10)) {
                    hasEquivalent = true;
                    List<String> equivalents = map.get(keyMap.get(r10));
                    if (equivalents != null) {
                        int len = r10.length();
                        for (String equivalent : equivalents) {
                            list.add(new Locale.LanguageRange(equivalent.toLowerCase(Locale.ROOT) + range.substring(len), lr.getWeight()));
                        }
                    }
                } else {
                    int index = r10.lastIndexOf(45);
                    if (index == -1) {
                        break;
                    }
                    r10 = r10.substring(0, index);
                }
            }
            if (!hasEquivalent) {
                list.add(lr);
            }
        }
        return list;
    }

    private LocaleMatcher() {
    }
}
