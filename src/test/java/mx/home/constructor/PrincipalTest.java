package mx.home.constructor;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrincipalTest {
	
	@Test
	public void test() {
		System.out.println("Test");
		DAOPrueba mockDaoPrueba = Mockito.mock(DAOPrueba.class);
		Mockito.when(mockDaoPrueba.obtenerPrimerDato()).thenReturn("Primer mock dato");
		Mockito.when(mockDaoPrueba.obtenerSegundoDato()).thenReturn("Segundo mock dato");
		String[] testInfo = {"Primer mock dato", "Segundo mock dato"};
		
		ASPrueba asPrueba = new ASPruebaImpl(mockDaoPrueba, "");
		assertArrayEquals(testInfo, asPrueba.obtenerInformacion().toArray());
	}
	
	@Test
	public void test1() {
		System.out.println("Test1");
		ASPrueba asPrueba = new ASPrueba() {
			@Override
			public List<String> obtenerInformacion() {
				List<String> lista = new ArrayList<>();
				lista.add("Primer dato");
				lista.add("Segundo dato");
				return lista;
			}
		};
		ASPrueba asPrueba2 = new ASPruebaImpl(new DAOPruebaImpl(), "Prueba");
		
		List<String> info1 = asPrueba.obtenerInformacion();
		List<String> info2 = asPrueba2.obtenerInformacion();
		System.out.println(info1);
		System.out.println(info2);
		assertArrayEquals(info1.toArray(new String[0]), info2.toArray(new String[0]));
	}
	
	// Pruebas usando Mock 
	@Test
	@SuppressWarnings("unchecked")
	public void test2() {
		List<String> mockList = Mockito.mock(ArrayList.class);
		mockList.add("Prueba1");
		mockList.add("Prueba2");
		Mockito.verify(mockList).add("Prueba1");
		assertEquals(0, mockList.size()); //mockList will return 0 until it is defined.
		
		Mockito.when(mockList.size()).thenReturn(100);
		assertEquals(100, mockList.size());
	}
	
	@Mock
	private List<String> mockedList;
	
	@Test
	public void test3() {
		mockedList.add("One");
		Mockito.verify(mockedList).add("One");
		assertEquals(0, mockedList.size()); //mockedList will return 0 until it is defined.
		
		Mockito.when(mockedList.size()).thenReturn(100);
		assertEquals(100, mockedList.size());
	}
	
	@Test
	public void test4() {
		assertEquals(0, mockedList.size()); //mockedList devuelve 0 aunque en test3() se definió que regresara 100.
	}
	
	// Pruebas usando Spy
	@Test
	public void test5() {
		List<String> spyList = Mockito.spy(new ArrayList<>());
		spyList.add("Prueba1");
		spyList.add("Prueba2");
		Mockito.verify(spyList).add("Prueba1");
		assertEquals(2, spyList.size());
		
		Mockito.doReturn(100).when(spyList).size();
		assertEquals(100, spyList.size());
	}
	
	// Prueba de clase final
	@Test
	public void test6() {
		TestFinalClass finalClass = new TestFinalClass();
		TestFinalClass mockFinalClass = Mockito.mock(TestFinalClass.class);
		Mockito.when(mockFinalClass.obtenCualquierNombre()).thenReturn("Joe Satriani");
		assertEquals(finalClass.obtenCualquierNombre(), mockFinalClass.obtenCualquierNombre());
	}
	
}


















