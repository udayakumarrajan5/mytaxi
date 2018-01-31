package com.mytaxi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MytaxiServerApplicantTestApplication.class)
public class MytaxiServerApplicantTestApplicationTests
{

	@Autowired
	private TestRestTemplate restTemplate;
	
    @Test
    public void contextLoads()
    {
    }
    

	@Test
	public void driverTest() {
		DriverDTO driver = this.restTemplate.getForObject("/v1/drivers/1", DriverDTO.class);
		assertThat(driver.getUsername()).isEqualTo("driver01");
	}

	@Test
	public void carTest() {
		CarDTO car = this.restTemplate.getForObject("/v1/cars/1", CarDTO.class);
		assertThat(car.getLicensePlate()).isEqualTo("RAKL8136");
	}
    
	@Test
	public void carTestByLicensePlate() {
		CarDTO car = this.restTemplate.getForObject("/v1/cars/licenseplate/RAKL8136", CarDTO.class);
		assertThat(car.getLicensePlate()).isEqualTo("RAKL8136");
	}
    
	
	

}
