/*
 * © 2020. TU Dortmund University,
 * Institute of Energy Systems, Energy Efficiency and Energy Economics,
 * Research group Distribution grid planning and operation
*/
package com.ed.core.dto.charts.apex.util;

import com.ed.core.dto.charts.apex.data.PairDataSeries;
import com.ed.core.dto.charts.apex.data.Tuple2;
import com.ed.core.dto.charts.apex.options.chart.*;
import com.ed.core.dto.charts.apex.options.stroke.LineCap;
import com.ed.core.dto.charts.apex.options.stroke.LineCurve;
import com.ed.core.dto.charts.apex.options.stroke.MultiStrokeOptions;
import com.ed.core.dto.charts.apex.options.xaxis.XAxisOptions;
import com.ed.core.dto.charts.apex.options.xaxis.XAxisType;
import com.ed.core.dto.charts.apex.options.zoom.ZoomOptions;

import java.awt.*;
import java.util.Arrays;

/**
 * Utility class that provides functions that are used in several places in this package
 *
 * @version 0.1
 * @since 19.01.20
 */
public class ApexUtil {

  public static final Animations DEFAULT_ANIMATIONS = new Animations(true, Easing.easein,400l, AnimateGradually.ENABLED_DEFAULT_VALUES);
  public static final int DEF_HIEGHT = 500;
  private ApexUtil() {
    throw new IllegalStateException("This is an utility class!");
  }

  /**
   * Converts a given {@link Color} into it's hex representation string
   *
   * @param color the color that should be converted
   * @return the hex representation of the provided color as String
   */
  public static String rgbToHex(Color color) {
    return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
  }

  public static Animations defaultAnimation(){
    return DEFAULT_ANIMATIONS;
  }

  public static Animations defaultAnimation(Easing easing,long speed){
    return new Animations(true, easing ,speed, AnimateGradually.ENABLED_DEFAULT_VALUES);
  }

  public static ChartOptions generateChartOptions(ChartType chartType, boolean stacked, int height, Animations animations){
    ChartOptions chartOptions = new ChartOptions(chartType,stacked,height, ZoomOptions.DEFAULT_X_WITH_AUTOSCALE, animations);
    return chartOptions;
  }

  public static ChartOptions generateChartOptions(ChartType chartType,boolean stacked,int height){
    return generateChartOptions(chartType,stacked,height,defaultAnimation());
  }

  public static ChartOptions generateChartOptions(ChartType chartType,int height){
    return generateChartOptions(chartType,false,height);
  }

  public static ChartOptions generateChartOptions(ChartType chartType){
    return generateChartOptions(chartType,DEF_HIEGHT);
  }

  public static <X extends Comparable<X>, Y extends Comparable<Y>> Tuple2<X,Y> createTuple(X x, Y y){
    return new Tuple2<X,Y>(x,y);
  }

  public static <X extends Comparable<X>, Y extends Comparable<Y>> PairDataSeries<X,Y> createPairedSeries(String title, Tuple2<X,Y>...tuples){
    return new PairDataSeries<>(title, Arrays.asList(tuples));
  }

  public static XAxisOptions getXAxisDefault(){
    return XAxisOptions.DEFAULT;
  }

  public static XAxisOptions getXAxisOptions(XAxisType type,String...list){
    return new XAxisOptions(type,Arrays.asList(list));
  }

  public static MultiStrokeOptions getMultiStrokeOptions(){
    return new MultiStrokeOptions(true, Arrays.asList(LineCurve.smooth,LineCurve.straight), LineCap.round,1d,new int [10]);
  }
}
