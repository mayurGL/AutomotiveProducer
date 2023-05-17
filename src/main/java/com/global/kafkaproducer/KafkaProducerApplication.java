package com.global.kafkaproducer;


import com.global.kafkaproducer.model.Company;
import com.global.kafkaproducer.model.Device;
import com.global.kafkaproducer.model.Gps;
import com.global.kafkaproducer.model.Vehicle;
import com.global.kafkaproducer.service.KafkaMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

    @Autowired
    private KafkaMessageService messageService;

    private final Random random = new Random();

    private final List<Vehicle> vehicles = Arrays.asList(
            new Vehicle(1, 2, "Suzuki", "Dzire", 2017, null, null, "Mayur", "Mayur"),
            new Vehicle(2, 5, "Honda", "Accord", 2020, null, null, "Mayur", "Mayur"),
            new Vehicle(3, 1, "Hyundai", "Aura", 2023, null, null, "Mayur", "Mayur"),
            new Vehicle(4, 4, "Toyota", "Innova", 2015, null, null, "Mayur", "Mayur"),
            new Vehicle(5, 3, "Tata", "Tiago", 2017, null, null, "Mayur", "Mayur"),
            new Vehicle(6, 6, "Kia", "Seltos", 2015, null, null, "Mayur", "Mayur"));

    private final List<Device> devices = Arrays.asList(
            new Device(1, "sensor", "temperature sensor", null, null, "Mayur", "Mayur"),
            new Device(2, "sensor", "voltage sensor", null, null, "Mayur", "Mayur"),
            new Device(3, "sensor", "parking sensor", null, null, "Mayur", "Mayur"));


    private final List<Company> companies = Arrays.asList(
            new Company(1, "GlobalLogic", "Noida", null, null, "Mayur", "Mayur"),
            new Company(2, "HCL", "Chennai", null, null, "Mayur", "Mayur"),
            new Company(3, "IBM", "Bangalore", null, null, "Mayur", "Mayur"),
            new Company(4, "TCS", "Hyderabad", null, null, "Mayur", "Mayur"),
            new Company(5, "Infosys", "Pune", null, null, "Mayur", "Mayur"),
            new Company(6, "EY", "Noida", null, null, "Mayur", "Mayur"));


    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        for (Company data : companies) {
            data.setCreatedTime(LocalDateTime.now());
            data.setModifiedTime(LocalDateTime.now());
            messageService.sendCompanyData(data);
        }

        for (Device data : devices) {
            data.setCreatedTime(LocalDateTime.now());
            data.setModifiedTime(LocalDateTime.now());
            messageService.sendDeviceData(data);
        }

        for (Vehicle data : vehicles) {
            data.setCreatedTime(LocalDateTime.now());
            data.setModifiedTime(LocalDateTime.now());
            data.setCompanyId(setRandomCompanyId());
            messageService.sendVehicleData(data);
        }
        while (true) {
            Gps gps = new Gps(LocalDateTime.now(), getRandomVehicleId(), getRandomDeviceId(), setRandomCompanyId(), getRandomLatitude(), getRandomLongitude(), getRandomSpeed());
            messageService.sendGpsData(gps);
            TimeUnit.SECONDS.sleep(60);
        }
    }

    /**
     * Random latitude between 25 and 35 degree
     *
     * @return double value of latitude
     */
    private double getRandomLatitude() {
        return 25.0 + random.nextDouble() * 10.0;
    }


    /**
     * Random longitude between -120 and -130 degree
     *
     * @return double value of longitude
     */
    private double getRandomLongitude() {
        return -120.0 - random.nextDouble() * 10.0;
    }


    /**
     * Random speed between 0 and 100 km/h
     *
     * @return double value of speed
     */
    private double getRandomSpeed() {
        return random.nextDouble() * 100.0;
    }


    /**
     * Random company Ids for vehicles
     *
     * @return String value of company Ids
     */
    private Integer setRandomCompanyId() {
        List<Integer> companies = Arrays.asList(1, 2, 3, 4, 5, 6);
        return companies.get(random.nextInt(companies.size()));
    }

    /**
     * Random device IDs for gps
     *
     * @return
     */
    public Integer getRandomDeviceId() {
        List<Integer> deviceIds = Arrays.asList(1, 2, 3);
        return deviceIds.get(random.nextInt(deviceIds.size()));
    }

    public Integer getRandomVehicleId() {
        List<Integer> vehicleIds = Arrays.asList(1, 2, 3, 4, 5, 6);
        return vehicleIds.get(random.nextInt(vehicleIds.size()));
    }
}
