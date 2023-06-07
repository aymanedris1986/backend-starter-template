/*
 * © 2020. TU Dortmund University,
 * Institute of Energy Systems, Energy Efficiency and Energy Economics,
 * Research group Distribution grid planning and operation
*/
package com.ed.core.dto.charts.apex;

import com.ed.core.dto.charts.apex.data.PairDataSeries;
import com.ed.core.dto.charts.apex.options.chart.ChartType;
import com.ed.core.dto.charts.apex.exceptions.ApexChartsException;
import com.ed.core.dto.charts.apex.options.chart.ChartOptions;
import com.ed.core.dto.charts.apex.options.stroke.StrokeOptions;
import com.ed.core.dto.charts.apex.options.title.ChartTitle;
import com.ed.core.dto.charts.apex.options.xaxis.XAxisOptions;
import java.util.List;

/**
 * //ToDo: Class Description
 *
 * @version 0.1
 * @since 13.01.20
 */
public class PairedValuesChart<X extends Comparable<X>, Y extends Comparable<Y>> extends ApexChart {

  private final List<PairDataSeries
          <X, Y>> series;
  private final XAxisOptions xaxis;

  public PairedValuesChart(
      List<PairDataSeries<X, Y>> series,
      ChartOptions chartOptions,
      ChartTitle title,
      XAxisOptions xaxis,
      StrokeOptions strokeOptions)
      throws ApexChartsException {
    super(title, chartOptions, strokeOptions);

    if (chartOptions.getType().equals(ChartType.line)) {
      throw new ApexChartsException(
          "Provision of paired values is not supported for chart type"
              + ChartType.line
              + " at the moment. And btw it also looks awful! "
              + "Use single values chart and x-axis categories instead!");
    }

    this.series = series;
    this.xaxis = xaxis;
  }

  public List<PairDataSeries<X, Y>> getSeries() {
    return series;
  }

  public XAxisOptions getXaxis() {
    return xaxis;
  }
}
