/*
 * © 2020. TU Dortmund University,
 * Institute of Energy Systems, Energy Efficiency and Energy Economics,
 * Research group Distribution grid planning and operation
*/
package com.ed.core.dto.charts.apex;

import com.ed.core.dto.charts.apex.options.chart.ChartOptions;
import com.ed.core.dto.charts.apex.options.stroke.StrokeOptions;
import com.ed.core.dto.charts.apex.options.title.ChartTitle;

/**
 * Internal API for ApexCharts. For the resulting ApexChart objects from the ChartFactory refer to
 * {@link JApexChart}
 *
 * @version 0.1
 * @since 14.01.20
 */

abstract class ApexChart {

  private final ChartTitle title;
  private final ChartOptions chart;
  private final StrokeOptions stroke;

  public ApexChart(ChartTitle title, ChartOptions chart, StrokeOptions strokeOptions) {
    this.title = title;
    this.chart = chart;
    this.stroke = strokeOptions;
  }

  public ChartOptions getChart() {
    return chart;
  }

  public ChartTitle getTitle() {
    return title;
  }

  public StrokeOptions getStroke() {
    return stroke;
  }
}
