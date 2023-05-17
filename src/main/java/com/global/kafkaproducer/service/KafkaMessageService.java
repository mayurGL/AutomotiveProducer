package com.global.kafkaproducer.service;


import com.global.kafkaproducer.model.Company;
import com.global.kafkaproducer.model.Device;
import com.global.kafkaproducer.model.Gps;
import com.global.kafkaproducer.model.Vehicle;



public interface KafkaMessageService {
    void sendVehicleData(Vehicle vehicleData);

    void sendGpsData(Gps gpsData);

    void sendDeviceData(Device deviceData);

    public void sendCompanyData(Company companyData);

}
