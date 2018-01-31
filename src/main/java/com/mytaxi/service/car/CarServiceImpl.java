/**
 * 
 */
package com.mytaxi.service.car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

/**
 * @author udayakumar.rajan
 *
 */
@Service
public class CarServiceImpl implements CarService {

	/* (non-Javadoc)
	 * @see com.mytaxi.service.car.CarService#find(java.lang.Long)
	 * 
	 */
	CarRepository carRepository;
	
	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@Override
	public CarDO find(Long carId) throws EntityNotFoundException {
		return findCar(carId);
	}

	/* (non-Javadoc)
	 * @see com.mytaxi.service.car.CarService#create(com.mytaxi.domainobject.CarDO)
	 */
	@Override
	public CarDO create(CarDO carDO) throws ConstraintsViolationException {
		return carRepository.save(carDO);
	}

	/* (non-Javadoc)
	 * @see com.mytaxi.service.car.CarService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long carId) throws EntityNotFoundException {
		carRepository.delete(carId);

	}

	/* (non-Javadoc)
	 * @see com.mytaxi.service.car.CarService#find(java.lang.String)
	 */
	@Override
	public CarDO find(String licensePlate) throws EntityNotFoundException {
		CarDO carDo = carRepository.findByLicensePlate(licensePlate);
		if (carDo == null) {
			throw new EntityNotFoundException("Unable to find car");
		}
		return carDo;
	}

	/* (non-Javadoc)
	 * @see com.mytaxi.service.car.CarService#delete(java.lang.String)
	 */
	@Override
	public void delete(String licensePlate) throws EntityNotFoundException {
		 carRepository.deleteByLicensePlate(licensePlate);
	}

	private CarDO findCar (Long id)  throws EntityNotFoundException {
		CarDO carDo = carRepository.findOne(id);
		return carDo;
	}

	@Override
	public List<CarDO> findAll() {
		Iterable<CarDO> results = carRepository.findAll();
		List<CarDO> cars = new ArrayList<>();
		results.forEach(cars :: add);
		return cars;
	}

}
