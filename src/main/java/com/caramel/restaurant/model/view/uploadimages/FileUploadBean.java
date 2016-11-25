package com.caramel.restaurant.model.view.uploadimages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class FileUploadBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2260007464398768243L;
	private final Logger log = LogManager.getLogger(FileUploadBean.class.getName());
	
	private UploadedFile file;
	private FileOutputStream foStream;
	
	//path where files will be saved
	private String path = FacesContext.getCurrentInstance()
								.getExternalContext()
								.getRealPath("/resources/user/");
	
	
    public void upload() {
    	
    	log.info("trying to upload file: " + file.getFileName().toString());
    	
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful, ", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public void saveToDisk() throws IOException, SecurityException{
    	
    	log.info("trying to save file: " + file.getFileName().toString());
    	
    	//create new file to put data inside
    	File newFile = new File(path + file.getFileName());
    	
    	log.info("trying to save file: " + newFile.getName().toString() + " into " + path);
    		
    		//write data
    	try{
	    	foStream = new FileOutputStream(newFile);
	    	foStream.write(file.getContents());
	    	foStream.flush();
	    	foStream.close();
		
	    	//try to close the streamer if exception occured
    	} catch (Exception e) {
    		e.printStackTrace();
    		
    	} finally {
    		try {
    			if (foStream != null) {
    				foStream.close();
    			}
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		log.info(file.getFileName() + ": file set was called");
		this.file = file;
	}
}
