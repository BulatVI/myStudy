package com.stepik.functionalProgramming.Lesson6.Tasks3;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingLong;


class XmlUtils {

    public static void main(String[] args) {
        List<XmlFile> xmlFiles = List.of(
                new XmlFile("1", "UTF-8", List.of(new Tag("function"), new Tag("load"))),
                new XmlFile("2", "UTF-8", List.of(new Tag("table"), new Tag("main"))),
                new XmlFile("3", "ASCII", List.of(new Tag("row"), new Tag("column"))),
                new XmlFile("4", "ASCII", List.of(new Tag("sheet"), new Tag("row"))),
                new XmlFile("5", "ASCII", List.of(new Tag("sheet"), new Tag("column"), new Tag("row")))
        );

        System.out.println(XmlUtils.countAllByTagName(xmlFiles, "sheet")); // returns {"UTF-8"=0, "ASCII"=5}
    }

    public static Map<String, Long> countAllByTagName(List<XmlFile> files, String tagName) {
        // write your code here
        /*Map<String, List<XmlFile>> maps = files.stream()
                .collect(Collectors.groupingBy(XmlFile::getEncoding));

        Map<String, Long> myMap = new HashMap<>();

        for (Map.Entry<String, List<XmlFile>> list : maps.entrySet()) {
            long count = 0L;
            for (XmlFile xml : list.getValue()) {
                for (Tag t : xml.getTags()) {
                    if (t.getName().contains(tagName)) {
                        count += xml.getTags().size();
                        break;
                    }
                }
            }
            myMap.put(list.getKey(), count);
        }
        return myMap;*/


        /*return files.stream()
                .collect(Collectors.groupingBy(XmlFile::getEncoding,
                        Collectors.mapping(XmlFile::getTags,
                                Collectors.filtering(tags -> tags.stream().map(Tag::getName).anyMatch(tagName::equals),
                                        Collectors.flatMapping(Collection::stream, Collectors.counting())
                                        )
                                )
                        )
                );*/

        return files.stream()
                .collect(Collectors.groupingBy(XmlFile::getEncoding, Collectors.filtering(
                                        x -> x.getTags().stream().anyMatch(y -> y.getName().contains(tagName)),
                                        Collectors.summingLong(x -> x.getTags().size())
                                )
                        )
                );
    }
}

class Tag {
    private final String name;

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class XmlFile {
    private final String id;
    private final String encoding;
    private final List<Tag> tags;

    public XmlFile(String id, String encoding, List<Tag> tags) {
        this.id = id;
        this.encoding = encoding;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getEncoding() {
        return encoding;
    }
}
