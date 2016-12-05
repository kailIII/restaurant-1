package com.caramel.restaurant.model.view.reservation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

import com.caramel.restaurant.model.view.message.MessageDAOImpl;
import com.caramel.restaurant.model.view.message.NumericMessageDAOImpl;

@ManagedBean
@RequestScoped
public class ReservationChartBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1810265804202935441L;
	private static Logger log = LogManager.getLogger(Reservation.class.getName());
	private static ReservationDAOImpl dao = new ReservationDAOImpl();
	
	private BarChartModel barChart = new BarChartModel();

	private Date date1 = new Date();//date
	private String people = new String();
	private int maxTables;
	private int spaceBetweenTimes = 15;
	
	
    @PostConstruct
    public void init() {

    	//init before validation
        NumericMessageDAOImpl numDAO = new NumericMessageDAOImpl();
        MessageDAOImpl dao = new MessageDAOImpl();
        
        
        //validations
        if (!people.equals("6") && !people.equals("2") ) {
        	people = "6";
		}
        
        if (people.equals("6"))
        	maxTables = numDAO.getMessageByTarget("tablesFor6");
        
        if (people.equals("2"))
    		maxTables = numDAO.getMessageByTarget("tablesFor2");
        
        
        //init after validation
        createBarModels();
    }
 
    private BarChartModel initBarModel() {
        HorizontalBarChartModel model = new HorizontalBarChartModel();
 
        ChartSeries series = new ChartSeries();
        series.setLabel(people + " people");
        
        log.info(date1.toString());
        
        //init variables before loop
        String hoursAndMinutes;
        
        //DateTime dateTimeLoop = new DateTime(date1);
        DateTime dateTime1;
        DateTime dateTime2;
        

        	//set time for first loop
	        dateTime1 = new DateTime(date1.getTime()).withHourOfDay(0)
	        								.withMinuteOfHour(0);
	        		
	        dateTime2 = new DateTime(date1.getTime()).withHourOfDay(23)
											.withMinuteOfHour(59);
	        
	        
	        //charts ids need to be initialized before get function will be called
	        while(dateTime1.isBefore(dateTime2.getMillis() + 1) ){//as long as is before
				
	        	
	        	hoursAndMinutes = dateTime1.getHourOfDay() + ":" + dateTime1.getMinuteOfHour();//create hour:minutes sample
	        	series.set( hoursAndMinutes, 0);//get last value and increment it
	        	
	        	dateTime1 = dateTime1.plusMinutes(spaceBetweenTimes);
			}
        
	        
	        
	        //init for next loop
	        dateTime1 = new DateTime(date1.getTime()).withHourOfDay(0)
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
        
        
        model.addSeries(series);
         
        return model;
    }
     
    
    public void createBarModels() {
        createBarModel();
    }
     
    
    private void createBarModel() {
        barChart = initBarModel();
         
        barChart.setTitle("Bar Chart");
        barChart.setLegendPosition("ne");
        barChart.setAnimate(true);
         
        Axis xAxis = barChart.getAxis(AxisType.X);
        xAxis.setLabel("Tables");
        xAxis.setMax(maxTables); 
        
        Axis yAxis = barChart.getAxis(AxisType.Y);
        yAxis.setLabel("Time");
    }
    
    
    
	//getters and setters
	public BarChartModel getBarChart() {
		return barChart;
	}

	public void setBarChart(BarChartModel barChart) {
		this.barChart = barChart;
	}

	public Date getDate1() {
		return date1;
	}
	
	public void setDate1(Date date1) {
		this.date1 = new DateTime(date1.getTime()).withHourOfDay(12).toDate();//if hour is set to 12 locale doesn't matter
	}
	
	public String getPeople() {
		return people;
	}
	
	public void setPeople(String people) {
		this.people = people;
	}
	
	public int getSpaceBetweenTimes() {
		return spaceBetweenTimes;
	}
	
	public void setSpaceBetweenTimes(int spaceBetweenTimes) {
		this.spaceBetweenTimes = spaceBetweenTimes;
	}
}
