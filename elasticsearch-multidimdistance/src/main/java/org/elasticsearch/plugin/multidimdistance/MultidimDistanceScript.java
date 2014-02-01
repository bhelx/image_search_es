package org.elasticsearch.plugin.multidimdistance;

import java.util.Map;

import org.elasticsearch.common.Nullable;
import org.elasticsearch.script.ExecutableScript;
import org.elasticsearch.script.NativeScriptFactory;
import org.elasticsearch.script.AbstractDoubleSearchScript;

import org.elasticsearch.index.fielddata.ScriptDocValues.Doubles;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;


public class MultidimDistanceScript extends AbstractDoubleSearchScript {

  List<Double> searchFeatures;

  public MultidimDistanceScript(@Nullable Map<String,Object> params) {
    searchFeatures = (List<Double>) params.get("features");
  }

  @Override
  public double runAsDouble() {
    Doubles features = (Doubles) doc().get("features");
    List<Double> docFeatures = features.getValues();
    return euclideanDistance(searchFeatures, docFeatures);
  }

  private double euclideanDistance(List<Double> a, List<Double> b) {
    double dist = 0.0;

    for (int i = 0; i < a.size(); i++) {
      double x = a.get(i);
      double y = b.get(i);

      dist += (x-y)*(x-y);
    }

    return Math.sqrt(dist);
  }

}
