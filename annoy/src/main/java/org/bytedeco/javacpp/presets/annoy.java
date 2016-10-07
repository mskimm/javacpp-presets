package org.bytedeco.javacpp.presets;

import org.bytedeco.javacpp.annotation.*;
import org.bytedeco.javacpp.tools.*;

@Properties(target = "org.bytedeco.javacpp.annoy", value = {
    @Platform(include = {"annoylib.h", "kissrandom.h"}),
    @Platform(value = "windows", include = {"mman.h"})
})
public class annoy implements InfoMapper {
    public void map(InfoMap infoMap) {
      infoMap
        .put(new Info("ANNOY_NODE_ATTRIBUTE").cppText("#define ANNOY_NODE_ATTRIBUTE __attribute__((__packed__))"))
        .put(new Info("AnnoyIndexInterface<int,float>").pointerTypes("AnnoyIndexInterface"))
        .put(new Info("AnnoyIndex<int,float,Euclidean,Kiss64Random>").pointerTypes("AnnoyIndex").base("AnnoyIndexInterface"))
        ;
    }
}
