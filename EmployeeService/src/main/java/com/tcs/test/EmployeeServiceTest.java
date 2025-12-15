//package com.tcs.test;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.*;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.tcs.repository.EmployeeRepository;
//
//@SpringBootTest
//public class EmployeeServiceTest {
//
//    @Mock
//    private EmployeeRepository  employeeRepository;
//
//    @Mock
//    private EmployeeClient employeeClient;
//
//    @InjectMocks
//    private EmployeeService employeeService;  // The service under test
//
//    private Employee testEmployee;
//    private LaptopDTO testLaptop;
//
//    @BeforeEach
//    public void setUp() {
//        // Initialize the mocks
//        MockitoAnnotations.openMocks(this);
//
//        // Create a sample Employee object
//        testEmployee = new Employee();
//        testEmployee.setId(1L);
//        testEmployee.setName("John Doe");
//        testEmployee.setEmail("johndoe@example.com");
//        testEmployee.setLaptopId(101L);  // Assume this employee has a laptop ID
//
//        // Create a sample LaptopDTO object
//        testLaptop = new LaptopDTO(101L, "Dell", "XPS 13");
//    }
//
//    @Test
//    public void testGetEmployeeWithLaptop_Success() throws EmployeeIDNotFoundException {
//        // Arrange: Mock the repository and client methods
//        when(employeeRepository.findById(1L)).thenReturn(Optional.of(testEmployee));
//        when(employeeClient.getLaptopById(101L)).thenReturn(testLaptop);
//
//        // Act: Call the service method
//        EmployeeWithLaptopDTO result = employeeService.getEmployeeWithLaptop(1L);
//
//        // Assert: Verify the results
//        assertNotNull(result);
//        assertEquals(1L, result.getId());
//        assertEquals("John Doe", result.getName());
//        assertEquals("johndoe@example.com", result.getEmail());
//        assertNotNull(result.getLaptop());
//        assertEquals(101L, result.getLaptop().getId());
//        assertEquals("Dell", result.getLaptop().getBrand());
//        assertEquals("XPS 13", result.getLaptop().getModel());
//
//        // Verify interactions with the mocks
//        verify(employeeRepository).findById(1L);
//        verify(employeeClient).getLaptopById(101L);
//    }
//
//    @Test
//    public void testGetEmployeeWithLaptop_EmployeeNotFound() {
//        // Arrange: Mock the repository to return empty for the given ID
//        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());
//
//        // Act & Assert: Expect an exception
//        assertThrows(EmployeeIDNotFoundException.class, () -> employeeService.getEmployeeWithLaptop(1L));
//
//        // Verify that the repository method was called
//        verify(employeeRepository).findById(1L);
//    }
//
//    @Test
//    public void testGetEmployeeWithLaptop_NoLaptop() throws EmployeeIDNotFoundException {
//        // Arrange: Create an employee without a laptop ID
//        testEmployee.setLaptopId(null);
//        when(employeeRepository.findById(1L)).thenReturn(Optional.of(testEmployee));
//
//        // Act: Call the service method
//        EmployeeWithLaptopDTO result = employeeService.getEmployeeWithLaptop(1L);
//
//        // Assert: Verify the results
//        assertNotNull(result);
//        assertNull(result.getLaptop());  // No laptop should be returned
//
//        // Verify interactions with the mocks
//        verify(employeeRepository).findById(1L);
//        verify(employeeClient, never()).getLaptopById(anyLong());  // Ensure no call to getLaptopById
//    }
//}
