/*
 * © 2020. TU Dortmund University,
 * Institute of Energy Systems, Energy Efficiency and Energy Economics,
 * Research group Distribution grid planning and operation
*/
package com.ed.core.dto.charts.apex.options.zoom;

import com.ed.core.dto.charts.apex.util.ApexUtil;

import java.awt.*;

/**
 * Fill options for {@link ZoomedAreaOptions}
 *
 * @version 0.1
 * @since 21.01.20
 */
public class ZoomedAreaFill {

  public static final ZoomedAreaFill TRANSPARENT = new ZoomedAreaFill(Color.WHITE, 0.0);

  private final String color;
  private final double opacity;

  /**
   * Standard constructor for fill options of {@link ZoomedAreaOptions}
   *
   * @param color background color of the selection zoomed area
   * @param opacity the transparency level of the selection fill
   */
  public ZoomedAreaFill(Color color, double opacity) {
    this.color = ApexUtil.rgbToHex(color);
    this.opacity = opacity;
  }

  public String getColor() {
    return color;
  }

  public double getOpacity() {
    return opacity;
  }
}
