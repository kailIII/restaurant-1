package com.caramel.restaurant.model.view.uploadimages;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class FileDownloadBean {
    private StreamedContent file;
    //I have had no time to finish this feature, but I will come back :)
    
    public FileDownloadBean() {        
        InputStream stream = null;//FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("C:/mapped/favicon.ico");
        file = new DefaultStreamedContent(stream, "image/jpg", "favicon.ico");
    }
 
    public StreamedContent getFile() {
        return file;
    }
}
