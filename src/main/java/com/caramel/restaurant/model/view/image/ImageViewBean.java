package com.caramel.restaurant.model.view.image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean(eager = true)
@ApplicationScoped
public class ImageViewBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5165303716632643529L;

	private static Logger log = LogManager.getLogger(ImageViewBean.class.getName());
	
    private List<String> images;
    private List<String> smallImages;


	private String name;
    
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        images.add("food1-resized.jpg");
        
        smallImages = new ArrayList<String>();
        smallImages.add("food1-small.jpg");
        log.debug(this.getClass().getSimpleName() + " was constructed");
    }
    
    public String addImage(){
    	
	    	ImageViewDAO imageDAO = new ImageViewDAO();

    		
	    	ImageView image = new ImageView(name);
	    	
	    	log.info("saving image to DB");
	    	imageDAO.save(image);
    	
    	return "Success";
    }
    
    public List<String> getImages() {
    	return images;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public List<String> getSmallImages() {
    	return smallImages;
    }
    
    public void setSmallImages(List<String> smallImages) {
    	this.smallImages = smallImages;
    }
}
