package com.caramel.restaurant.model.view.reservation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

@ManagedBean
@ViewScoped
public class ReservationChartBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1810265804202935441L;
	private static Logger log = LogManager.getLogger(Reservation.class.getName());
	private static ReservationDAOImpl dao = new ReservationDAOImpl();
	
	private BarChartModel barChart = new BarChartModel();
	
	private Date date1 = new Date();//date
	private String people = "6";
	private int openTime = 9;
	private int spaceBetweenTimes = 15;
	
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    private BarChartModel initBarModel() {
        HorizontalBarChartModel model = new HorizontalBarChartModel();
 
        ChartSeries series = new ChartSeries();
        series.setLabel(people + " people");
        
        
        //init variables before loop
        String hoursAndMinutes;
        DateTime dateTimeLoop = new DateTime(date1);
        DateTime dateTime1;
        DateTime dateTime2;
        
        
        

        	//set time for first loop
	        dateTime1 = new DateTime(date1).withHourOfDay(openTime)
	        								.withMinuteOfHour(0);
	        		
	        dateTime2 = new DateTime(date1).withHourOfDay(23)
											.withMinuteOfHour(59);
	        
	        
	        //charts ids need to be initialized before get function will be called
	        while(dateTime1.isBefore(dateTime2.getMillis() + 1) ){//as long as is before
				
	        	
	        	hoursAndMinutes = dateTime1.getHourOfDay() + ":" + dateTime1.getMinuteOfHour();//create hour:minutes sample
	        	series.set( hoursAndMinutes, 0);//get last value and increment it
	        	
	        	dateTime1 = dateTime1.plusMinutes(spaceBetweenTimes);
			}
        
	        
        	
        	
	    dateTime1 = new DateTime(date1).withHourOfDay(openTime)
	        							.withMinuteOfHour(0);
	    
        
        //for everyone reservation 
        for (Reservation reservation : dao.getByDay(dateTime1.getYear(), 
        											dateTime1.getMonthOfYear(), 
        											dateTime1.getDayOfMonth(), 
        											people)) {
        	
        	//set time for each loop
	        dateTime1 = new DateTime(date1).withHourOfDay(reservation.getFirstTime().getHours())
	        										.withMinuteOfHour(reservation.getFirstTime().getMinutes());
	        		
	        dateTime2 = new DateTime(date1).withHourOfDay(reservation.getSecondTime().getHours())
													.withMinuteOfHour(reservation.getSecondTime().getMinutes());
	
	        
	        
	        
	        while(dateTime1.isBefore(dateTime2.getMillis() + 1) ){//as long as is before
				
	        	hoursAndMinutes = dateTime1.getHourOfDay() + ":" + dateTime1.getMinuteOfHour();//create hour:minutes sample
	        	series.set( hoursAndMinutes,//use time as id
	        			series.getData().get(hoursAndMinutes).intValue() + 1);//get last value and increment it
	        	
	        	dateTime1 = dateTime1.plusMinutes(15);
			}
        
        }
        
        
        
        
        
        
        
        
        
        
        
//        List<Reservation> list = dao.getByDay(2016, 12, 1, "6");
//        log.info(list.size());
//        for (Reservation reservation : list) {
//        	DateTime dateTime = new DateTime(reservation.getDate()).withHourOfDay(reservation.getFirstTime().getHours())//set date, hours and minutes
//        															.withMinuteOfHour(reservation.getFirstTime().getMinutes());
//		}
        
        
        
        
        
        
        
        model.addSeries(series);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barChart = initBarModel();
         
        barChart.setTitle("Bar Chart");
        barChart.setLegendPosition("ne");
        barChart.setAnimate(true);
         
        Axis xAxis = barChart.getAxis(AxisType.X);
        xAxis.setLabel("time");
         
        Axis yAxis = barChart.getAxis(AxisType.Y);
        yAxis.setLabel("table");
    }
    
    
    
	//getters and setters
	public BarChartModel getBarChart() {
		return barChart;
	}

	public void setBarChart(BarChartModel barChart) {
		this.barChart = barChart;
	}

}
