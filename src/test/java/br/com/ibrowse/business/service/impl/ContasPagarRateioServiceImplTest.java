/*
 * Created on 23 mai 2017 ( Time 18:19:41 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package br.com.ibrowse.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.ibrowse.bean.ContasPagarRateio;
import br.com.ibrowse.bean.jpa.ContasPagarRateioEntity;
import br.com.ibrowse.business.service.mapping.ContasPagarRateioServiceMapper;
import br.com.ibrowse.data.repository.jpa.ContasPagarRateioJpaRepository;
import br.com.ibrowse.test.ContasPagarRateioEntityFactoryForTest;
import br.com.ibrowse.test.ContasPagarRateioFactoryForTest;
import br.com.ibrowse.test.MockValues;

/**
 * Test : Implementation of ContasPagarRateioService
 */
@RunWith(MockitoJUnitRunner.class)
public class ContasPagarRateioServiceImplTest {

	@InjectMocks
	private ContasPagarRateioServiceImpl contasPagarRateioService;
	@Mock
	private ContasPagarRateioJpaRepository contasPagarRateioJpaRepository;
	@Mock
	private ContasPagarRateioServiceMapper contasPagarRateioServiceMapper;
	
	private ContasPagarRateioFactoryForTest contasPagarRateioFactoryForTest = new ContasPagarRateioFactoryForTest();

	private ContasPagarRateioEntityFactoryForTest contasPagarRateioEntityFactoryForTest = new ContasPagarRateioEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Long oidContasPagarRateio = mockValues.nextLong();
		
		ContasPagarRateioEntity contasPagarRateioEntity = contasPagarRateioJpaRepository.findOne(oidContasPagarRateio);
		
		ContasPagarRateio contasPagarRateio = contasPagarRateioFactoryForTest.newContasPagarRateio();
		when(contasPagarRateioServiceMapper.mapContasPagarRateioEntityToContasPagarRateio(contasPagarRateioEntity)).thenReturn(contasPagarRateio);

		// When
		ContasPagarRateio contasPagarRateioFound = contasPagarRateioService.findById(oidContasPagarRateio);

		// Then
		assertEquals(contasPagarRateio.getOidContasPagarRateio(),contasPagarRateioFound.getOidContasPagarRateio());
	}

	@Test
	public void findAll() {
		// Given
		List<ContasPagarRateioEntity> contasPagarRateioEntitys = new ArrayList<ContasPagarRateioEntity>();
		ContasPagarRateioEntity contasPagarRateioEntity1 = contasPagarRateioEntityFactoryForTest.newContasPagarRateioEntity();
		contasPagarRateioEntitys.add(contasPagarRateioEntity1);
		ContasPagarRateioEntity contasPagarRateioEntity2 = contasPagarRateioEntityFactoryForTest.newContasPagarRateioEntity();
		contasPagarRateioEntitys.add(contasPagarRateioEntity2);
		when(contasPagarRateioJpaRepository.findAll()).thenReturn(contasPagarRateioEntitys);
		
		ContasPagarRateio contasPagarRateio1 = contasPagarRateioFactoryForTest.newContasPagarRateio();
		when(contasPagarRateioServiceMapper.mapContasPagarRateioEntityToContasPagarRateio(contasPagarRateioEntity1)).thenReturn(contasPagarRateio1);
		ContasPagarRateio contasPagarRateio2 = contasPagarRateioFactoryForTest.newContasPagarRateio();
		when(contasPagarRateioServiceMapper.mapContasPagarRateioEntityToContasPagarRateio(contasPagarRateioEntity2)).thenReturn(contasPagarRateio2);

		// When
		List<ContasPagarRateio> contasPagarRateiosFounds = contasPagarRateioService.findAll();

		// Then
		assertTrue(contasPagarRateio1 == contasPagarRateiosFounds.get(0));
		assertTrue(contasPagarRateio2 == contasPagarRateiosFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		ContasPagarRateio contasPagarRateio = contasPagarRateioFactoryForTest.newContasPagarRateio();

		ContasPagarRateioEntity contasPagarRateioEntity = contasPagarRateioEntityFactoryForTest.newContasPagarRateioEntity();
		when(contasPagarRateioJpaRepository.findOne(contasPagarRateio.getOidContasPagarRateio())).thenReturn(null);
		
		contasPagarRateioEntity = new ContasPagarRateioEntity();
		contasPagarRateioServiceMapper.mapContasPagarRateioToContasPagarRateioEntity(contasPagarRateio, contasPagarRateioEntity);
		ContasPagarRateioEntity contasPagarRateioEntitySaved = contasPagarRateioJpaRepository.save(contasPagarRateioEntity);
		
		ContasPagarRateio contasPagarRateioSaved = contasPagarRateioFactoryForTest.newContasPagarRateio();
		when(contasPagarRateioServiceMapper.mapContasPagarRateioEntityToContasPagarRateio(contasPagarRateioEntitySaved)).thenReturn(contasPagarRateioSaved);

		// When
		ContasPagarRateio contasPagarRateioResult = contasPagarRateioService.create(contasPagarRateio);

		// Then
		assertTrue(contasPagarRateioResult == contasPagarRateioSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		ContasPagarRateio contasPagarRateio = contasPagarRateioFactoryForTest.newContasPagarRateio();

		ContasPagarRateioEntity contasPagarRateioEntity = contasPagarRateioEntityFactoryForTest.newContasPagarRateioEntity();
		when(contasPagarRateioJpaRepository.findOne(contasPagarRateio.getOidContasPagarRateio())).thenReturn(contasPagarRateioEntity);

		// When
		Exception exception = null;
		try {
			contasPagarRateioService.create(contasPagarRateio);
		} catch(Exception e) {
			exception = e;
		}

		// Then
		assertTrue(exception instanceof IllegalStateException);
		assertEquals("already.exists", exception.getMessage());
	}

	@Test
	public void update() {
		// Given
		ContasPagarRateio contasPagarRateio = contasPagarRateioFactoryForTest.newContasPagarRateio();

		ContasPagarRateioEntity contasPagarRateioEntity = contasPagarRateioEntityFactoryForTest.newContasPagarRateioEntity();
		when(contasPagarRateioJpaRepository.findOne(contasPagarRateio.getOidContasPagarRateio())).thenReturn(contasPagarRateioEntity);
		
		ContasPagarRateioEntity contasPagarRateioEntitySaved = contasPagarRateioEntityFactoryForTest.newContasPagarRateioEntity();
		when(contasPagarRateioJpaRepository.save(contasPagarRateioEntity)).thenReturn(contasPagarRateioEntitySaved);
		
		ContasPagarRateio contasPagarRateioSaved = contasPagarRateioFactoryForTest.newContasPagarRateio();
		when(contasPagarRateioServiceMapper.mapContasPagarRateioEntityToContasPagarRateio(contasPagarRateioEntitySaved)).thenReturn(contasPagarRateioSaved);

		// When
		ContasPagarRateio contasPagarRateioResult = contasPagarRateioService.update(contasPagarRateio);

		// Then
		verify(contasPagarRateioServiceMapper).mapContasPagarRateioToContasPagarRateioEntity(contasPagarRateio, contasPagarRateioEntity);
		assertTrue(contasPagarRateioResult == contasPagarRateioSaved);
	}

	@Test
	public void delete() {
		// Given
		Long oidContasPagarRateio = mockValues.nextLong();

		// When
		contasPagarRateioService.delete(oidContasPagarRateio);

		// Then
		verify(contasPagarRateioJpaRepository).delete(oidContasPagarRateio);
		
	}

}
