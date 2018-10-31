package com.example.test1.Cars;

import com.example.test1.Image.Image;
import com.example.test1.Image.ImagesRespository;
import com.example.test1.Locations.Location;
import com.example.test1.Locations.LocationRepository;
import com.example.test1.Users.Account;
import com.example.test1.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class ApiModelToEntityAdapter {
    private UsersRepository usersRepository;
    private LocationRepository locationRepository;
    private ImagesRespository imagesRespository;
    @Autowired
    ApiModelToEntityAdapter(LocationRepository locationRepository, UsersRepository usersRepository, ImagesRespository imagesRespository) {
        this.usersRepository = usersRepository;
        this.locationRepository = locationRepository;
        this.imagesRespository = imagesRespository;
    }

    public Car getNewCarEntity(CarsApiModel carsApiModel) throws Exception {
        Car newCar = new Car();
        newCar.setManifatuer(carsApiModel.getManifatuer());
        newCar.setFuelConsumption(carsApiModel.getFuelConsumption());
        newCar.setModel(carsApiModel.getModel());
        newCar.setNumberOfDoors(carsApiModel.getNumberOfDoors());
        newCar.setPower(carsApiModel.getPower());
        Optional<Location> location = this.locationRepository.findById(carsApiModel.getLocation_id());
        Optional<Account> user = this.usersRepository.findById(carsApiModel.getUser_id());
        newCar.setLocation(location.orElseThrow(()->new Exception("Can't find location")));
        newCar.setUser(user.orElseThrow(()->new Exception("Can't find user")));
        try {
            Set<Image> realImages = new HashSet<>();
            for (int i = 0; i < carsApiModel.getImages().length; i++) {
                Image image = new Image();
                image.setImages(carsApiModel.getImages()[0].getBytes());
                realImages.add(image);
            }
            imagesRespository.saveAll(realImages);
            newCar.setImages(realImages);
        } catch (Exception e) {
            throw new Exception("Problem with images");
        }
        return newCar;
    }
}
