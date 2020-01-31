package org.course.spring.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class CarDealership {
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CarDealership.class);

    @Autowired
    private Resource resource;
    
    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehiculos(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void imprimirInformDeEstado(){
    	LOGGER.info("Informe de estado del concesionario");
    	if (vehicles == null) {
            vehicles = new ArrayList<>();
            construirConcesionario();
        }
        for (Vehicle v : this.vehicles) {
        	LOGGER.info("{}", v);
        }
    }
    
    private void construirConcesionario() {
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(resource.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String matricula = null;
            while ((matricula = br.readLine()) != null) {
            	Vehicle v = new Vehicle();
                v.setPlate(matricula);
                this.vehicles.add(v);
            }
        } catch (IOException ex) {
            LOGGER.error("{}", ex);
        } finally {
            try {
                isr.close();
            } catch (IOException ex) {
            	LOGGER.error("{}", ex);
            }
        }
    }
}
