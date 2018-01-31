package com.mytaxi.service.driver;

import com.mytaxi.dataaccessobject.DriverRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.exception.ServiceException;
import com.mytaxi.service.car.CarService;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some driver specific things.
 * <p/>
 */
@Service
public class DefaultDriverService implements DriverService
{

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultDriverService.class);

    private final DriverRepository driverRepository;
    
    @Autowired
    CarService carService;


    public DefaultDriverService(final DriverRepository driverRepository)
    {
        this.driverRepository = driverRepository;
    }


    /**
     * Selects a driver by id.
     *
     * @param driverId
     * @return found driver
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    public DriverDO find(Long driverId) throws EntityNotFoundException
    {
        return findDriverChecked(driverId);
    }


    /**
     * Creates a new driver.
     *
     * @param driverDO
     * @return
     * @throws ConstraintsViolationException if a driver already exists with the given username, ... .
     */
    @Override
    public DriverDO create(DriverDO driverDO) throws ConstraintsViolationException
    {
        DriverDO driver;
        try
        {
            driver = driverRepository.save(driverDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("Some constraints are thrown due to driver creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return driver;
    }


    /**
     * Deletes an existing driver by id.
     *
     * @param driverId
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long driverId) throws EntityNotFoundException
    {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setDeleted(true);
    }


    /**
     * Update the location for a driver.
     *
     * @param driverId
     * @param longitude
     * @param latitude
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException
    {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setCoordinate(new GeoCoordinate(latitude, longitude));
    }


    /**
     * Find all drivers by online state.
     *
     * @param onlineStatus
     */
    @Override
    public List<DriverDO> find(OnlineStatus onlineStatus)
    {
        return driverRepository.findByOnlineStatus(onlineStatus);
    }


    private DriverDO findDriverChecked(Long driverId) throws EntityNotFoundException
    {
        DriverDO driverDO = driverRepository.findOne(driverId);
        if (driverDO == null)
        {
            throw new EntityNotFoundException("Could not find entity with id: " + driverId);
        }
        return driverDO;
    }


	@Override
	public void selectCar(Long id, String licensePlate) throws CarAlreadyInUseException, ServiceException {
		DriverDO driverDO = null;
		try {
			driverDO = driverRepository.findByIdAndOnlineStatus(id, OnlineStatus.ONLINE);
			if (driverDO == null) {
				throw new EntityNotFoundException(null);
			}
			CarDO carDO = carService.find(licensePlate);
			if (carDO.getDriverDO() != null && carDO.getDriverDO().getId() != driverDO.getId()) {
				throw new CarAlreadyInUseException("Selected car is already hired");
			}
			driverDO.setCarDO(carDO);
			create(driverDO);
		} catch (ConstraintsViolationException | EntityNotFoundException e) {
			throw new ServiceException("Driver is not online Status or information not found! ");
		}

	}

	@Override
	public void deSelectCar(Long id, String licensePlate) throws ServiceException {
		try {
			DriverDO driverDO = findDriverChecked(id);
			driverDO.setCarDO(null);
			create(driverDO);
		} catch (EntityNotFoundException | ConstraintsViolationException e) {
			throw new ServiceException("Unable to deselect the car");
		}
	}
	
	@Override
	public DriverDO findByUsernameAndPassword (String username, String password) {
		return driverRepository.findByUsernameAndPassword(username, password);
	}
	
	@Override
	@Cacheable("drivers")
	public List<DriverDO> findAll () {
		Iterable<DriverDO> driversDO = driverRepository.findAll();
		List<DriverDO> drivers = new ArrayList<>();
		driversDO.forEach(drivers :: add);
		return drivers;
	}

}
