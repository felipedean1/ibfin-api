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

import br.com.ibrowse.bean.ContasPagar;
import br.com.ibrowse.bean.jpa.ContasPagarEntity;
import br.com.ibrowse.business.service.mapping.ContasPagarServiceMapper;
import br.com.ibrowse.data.repository.jpa.ContasPagarJpaRepository;
import br.com.ibrowse.test.ContasPagarEntityFactoryForTest;
import br.com.ibrowse.test.ContasPagarFactoryForTest;
import br.com.ibrowse.test.MockValues;

/**
 * Test : Implementation of ContasPagarService
 */
@RunWith(MockitoJUnitRunner.class)
public class ContasPagarServiceImplTest {

	@InjectMocks
	private ContasPagarServiceImpl contasPagarService;
	@Mock
	private ContasPagarJpaRepository contasPagarJpaRepository;
	@Mock
	private ContasPagarServiceMapper contasPagarServiceMapper;
	
	private ContasPagarFactoryForTest contasPagarFactoryForTest = new ContasPagarFactoryForTest();

	private ContasPagarEntityFactoryForTest contasPagarEntityFactoryForTest = new ContasPagarEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Long oidContasPagar = mockValues.nextLong();
		
		ContasPagarEntity contasPagarEntity = contasPagarJpaRepository.findOne(oidContasPagar);
		
		ContasPagar contasPagar = contasPagarFactoryForTest.newContasPagar();
		when(contasPagarServiceMapper.mapContasPagarEntityToContasPagar(contasPagarEntity)).thenReturn(contasPagar);

		// When
		ContasPagar contasPagarFound = contasPagarService.findById(oidContasPagar);

		// Then
		assertEquals(contasPagar.getOidContasPagar(),contasPagarFound.getOidContasPagar());
	}

	@Test
	public void findAll() {
		// Given
		List<ContasPagarEntity> contasPagarEntitys = new ArrayList<ContasPagarEntity>();
		ContasPagarEntity contasPagarEntity1 = contasPagarEntityFactoryForTest.newContasPagarEntity();
		contasPagarEntitys.add(contasPagarEntity1);
		ContasPagarEntity contasPagarEntity2 = contasPagarEntityFactoryForTest.newContasPagarEntity();
		contasPagarEntitys.add(contasPagarEntity2);
		when(contasPagarJpaRepository.findAll()).thenReturn(contasPagarEntitys);
		
		ContasPagar contasPagar1 = contasPagarFactoryForTest.newContasPagar();
		when(contasPagarServiceMapper.mapContasPagarEntityToContasPagar(contasPagarEntity1)).thenReturn(contasPagar1);
		ContasPagar contasPagar2 = contasPagarFactoryForTest.newContasPagar();
		when(contasPagarServiceMapper.mapContasPagarEntityToContasPagar(contasPagarEntity2)).thenReturn(contasPagar2);

		// When
		List<ContasPagar> contasPagarsFounds = contasPagarService.findAll();

		// Then
		assertTrue(contasPagar1 == contasPagarsFounds.get(0));
		assertTrue(contasPagar2 == contasPagarsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		ContasPagar contasPagar = contasPagarFactoryForTest.newContasPagar();

		ContasPagarEntity contasPagarEntity = contasPagarEntityFactoryForTest.newContasPagarEntity();
		when(contasPagarJpaRepository.findOne(contasPagar.getOidContasPagar())).thenReturn(null);
		
		contasPagarEntity = new ContasPagarEntity();
		contasPagarServiceMapper.mapContasPagarToContasPagarEntity(contasPagar, contasPagarEntity);
		ContasPagarEntity contasPagarEntitySaved = contasPagarJpaRepository.save(contasPagarEntity);
		
		ContasPagar contasPagarSaved = contasPagarFactoryForTest.newContasPagar();
		when(contasPagarServiceMapper.mapContasPagarEntityToContasPagar(contasPagarEntitySaved)).thenReturn(contasPagarSaved);

		// When
		ContasPagar contasPagarResult = contasPagarService.create(contasPagar);

		// Then
		assertTrue(contasPagarResult == contasPagarSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		ContasPagar contasPagar = contasPagarFactoryForTest.newContasPagar();

		ContasPagarEntity contasPagarEntity = contasPagarEntityFactoryForTest.newContasPagarEntity();
		when(contasPagarJpaRepository.findOne(contasPagar.getOidContasPagar())).thenReturn(contasPagarEntity);

		// When
		Exception exception = null;
		try {
			contasPagarService.create(contasPagar);
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
		ContasPagar contasPagar = contasPagarFactoryForTest.newContasPagar();

		ContasPagarEntity contasPagarEntity = contasPagarEntityFactoryForTest.newContasPagarEntity();
		when(contasPagarJpaRepository.findOne(contasPagar.getOidContasPagar())).thenReturn(contasPagarEntity);
		
		ContasPagarEntity contasPagarEntitySaved = contasPagarEntityFactoryForTest.newContasPagarEntity();
		when(contasPagarJpaRepository.save(contasPagarEntity)).thenReturn(contasPagarEntitySaved);
		
		ContasPagar contasPagarSaved = contasPagarFactoryForTest.newContasPagar();
		when(contasPagarServiceMapper.mapContasPagarEntityToContasPagar(contasPagarEntitySaved)).thenReturn(contasPagarSaved);

		// When
		ContasPagar contasPagarResult = contasPagarService.update(contasPagar);

		// Then
		verify(contasPagarServiceMapper).mapContasPagarToContasPagarEntity(contasPagar, contasPagarEntity);
		assertTrue(contasPagarResult == contasPagarSaved);
	}

	@Test
	public void delete() {
		// Given
		Long oidContasPagar = mockValues.nextLong();

		// When
		contasPagarService.delete(oidContasPagar);

		// Then
		verify(contasPagarJpaRepository).delete(oidContasPagar);
		
	}

}