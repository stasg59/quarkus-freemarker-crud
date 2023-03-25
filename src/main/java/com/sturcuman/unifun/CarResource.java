package com.sturcuman.unifun;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class CarResource {

	@Inject
	EntityManager entityManager;

	public List<Car> getCars() {
		return entityManager.createQuery("SELECT c FROM Car c").getResultList();
	}

	public Car getCar(Long id) {
		return entityManager.find(Car.class, id);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public Car addCar(Car car) {
		entityManager.persist(car);
		return car;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void updateCar(Car car) {
		entityManager.merge(car);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void deleteCar(Long id) {
		Car car = getCar(id);
		entityManager.remove(car);
	}
}
