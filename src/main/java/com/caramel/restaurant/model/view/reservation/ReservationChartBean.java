package com.caramel.restaurant.model.view.reservation;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
@ViewScoped
public class ReservationChartBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1810265804202935441L;
	
	private BarChartModel barChart = new BarChartModel();
	
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries two = new ChartSeries();
        two.setLabel("two people");
        two.set("2004", 120);
        two.set("2005", 100);
        two.set("2006", 44);
        two.set("2007", 150);
        two.set("2008", 25);
 
        ChartSeries six = new ChartSeries();
        six.setLabel("six people");
        six.set("2004", 52);
        six.set("2005", 60);
        six.set("2006", 110);
        six.set("2007", 135);
        six.set("2008", 120);
 
        model.addSeries(two);
        model.addSeries(six);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barChart = initBarModel();
         
        barChart.setTitle("Bar Chart");
        barChart.setLegendPosition("ne");
         
        Axis xAxis = barChart.getAxis(AxisType.X);
        xAxis.setLabel("time");
         
        Axis yAxis = barChart.getAxis(AxisType.Y);
        yAxis.setLabel("table");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
	
	//getters and setters
	public BarChartModel getBarChart() {
		return barChart;
	}

	public void setBarChart(BarChartModel barChart) {
		this.barChart = barChart;
	}

}
