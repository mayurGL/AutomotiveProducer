package com.global.kafkaproducer.service;



import com.global.kafkaproducer.model.Company;
import com.global.kafkaproducer.model.Device;
import com.global.kafkaproducer.model.Gps;
import com.global.kafkaproducer.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageServiceImpl implements KafkaMessageService {

    private final String companyTopic = "companyTopic";
    private final String vehicleTopic = "vehicleTopic";
    private final String gpsTopic = "gpsTopic";
    private final String deviceTopic = "deviceTopic";


    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendVehicleData(Vehicle vehicleData) {
        kafkaTemplate.send(vehicleTopic, vehicleData);
    }

    @Override
    public void sendGpsData(Gps gpsData) {
        kafkaTemplate.send(gpsTopic, gpsData);
    }

    @Override
    public void sendDeviceData(Device deviceData) {
        kafkaTemplate.send(deviceTopic, deviceData);
    }

    @Override
    public void sendCompanyData(Company companyData) {
        kafkaTemplate.send(companyTopic, companyData);
    }
}
