package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.Audit;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPlacesEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StTollsEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.request.StTollsRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StPlacesService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StTollsService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StTollsController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class StTollsControllerDiffblueTest {
    @MockBean
    private StPlacesService stPlacesService;

    @Autowired
    private StTollsController stTollsController;

    @MockBean
    private StTollsService stTollsService;

    /**
     * Test {@link StTollsController#validateToll(Long)}.
     * <ul>
     *   <li>When {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StTollsController#validateToll(Long)}
     */
    @Test
    @DisplayName("Test validateToll(Long); when 'null'")
    @Tag("MaintainedByDiffblue")
    void testValidateToll_whenNull() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ResponseEntity<Boolean> actualValidateTollResult = (new StTollsController()).validateToll(null);

        // Assert
        HttpStatusCode statusCode = actualValidateTollResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals(500, actualValidateTollResult.getStatusCodeValue());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
        assertFalse(actualValidateTollResult.getBody());
        assertTrue(actualValidateTollResult.hasBody());
        assertTrue(actualValidateTollResult.getHeaders().isEmpty());
    }

    /**
     * Test {@link StTollsController#validateToll(Long)}.
     * <ul>
     *   <li>When one.</li>
     * </ul>
     * <p>
     * Method under test: {@link StTollsController#validateToll(Long)}
     */
    @Test
    @DisplayName("Test validateToll(Long); when one")
    @Tag("MaintainedByDiffblue")
    void testValidateToll_whenOne() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ResponseEntity<Boolean> actualValidateTollResult = (new StTollsController()).validateToll(1L);

        // Assert
        HttpStatusCode statusCode = actualValidateTollResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals(500, actualValidateTollResult.getStatusCodeValue());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
        assertFalse(actualValidateTollResult.getBody());
        assertTrue(actualValidateTollResult.hasBody());
        assertTrue(actualValidateTollResult.getHeaders().isEmpty());
    }

    /**
     * Test {@link StTollsController#validateToll(Long)}.
     * <ul>
     *   <li>When zero.</li>
     * </ul>
     * <p>
     * Method under test: {@link StTollsController#validateToll(Long)}
     */
    @Test
    @DisplayName("Test validateToll(Long); when zero")
    @Tag("MaintainedByDiffblue")
    void testValidateToll_whenZero() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ResponseEntity<Boolean> actualValidateTollResult = (new StTollsController()).validateToll(0L);

        // Assert
        HttpStatusCode statusCode = actualValidateTollResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        assertEquals(500, actualValidateTollResult.getStatusCodeValue());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
        assertFalse(actualValidateTollResult.getBody());
        assertTrue(actualValidateTollResult.hasBody());
        assertTrue(actualValidateTollResult.getHeaders().isEmpty());
    }

    /**
     * Test {@link StTollsController#getAllTolls()}.
     * <p>
     * Method under test: {@link StTollsController#getAllTolls()}
     */
    @Test
    @DisplayName("Test getAllTolls()")
    @Tag("MaintainedByDiffblue")
    void testGetAllTolls() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StTollsEntity>> actualAllTolls = (new StTollsController()).getAllTolls();

        // Assert
        assertEquals("", actualAllTolls.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StTollsService.isServiceAvailable()\" because \"this.stTollsService\" is null",
                actualAllTolls.getMessage());
        assertNull(actualAllTolls.getData());
        assertEquals(500, actualAllTolls.getStatus().intValue());
    }

    /**
     * Test {@link StTollsController#getAllTollsByStatus()}.
     * <p>
     * Method under test: {@link StTollsController#getAllTollsByStatus()}
     */
    @Test
    @DisplayName("Test getAllTollsByStatus()")
    @Tag("MaintainedByDiffblue")
    void testGetAllTollsByStatus() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StTollsEntity>> actualAllTollsByStatus = (new StTollsController()).getAllTollsByStatus();

        // Assert
        assertEquals("", actualAllTollsByStatus.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StTollsService.isServiceAvailable()\" because \"this.stTollsService\" is null",
                actualAllTollsByStatus.getMessage());
        assertNull(actualAllTollsByStatus.getData());
        assertEquals(500, actualAllTollsByStatus.getStatus().intValue());
    }

    /**
     * Test {@link StTollsController#getTollsById(Long)}.
     * <p>
     * Method under test: {@link StTollsController#getTollsById(Long)}
     */
    @Test
    @DisplayName("Test getTollsById(Long)")
    @Tag("MaintainedByDiffblue")
    void testGetTollsById() throws Exception {
        // Arrange
        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit2 = new Audit();
        audit2.setAction("Action");
        audit2.setCreateBy("Create By");
        audit2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setCurrentValue("42");
        audit2.setDeleteBy("Delete By");
        audit2.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setIpAddress("42 Main St");
        audit2.setPreviousValue("42");
        audit2.setRecordVersion(1);
        audit2.setUpdateBy("2020-03-01");
        audit2.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit3 = new Audit();
        audit3.setAction("Action");
        audit3.setCreateBy("Create By");
        audit3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setCurrentValue("42");
        audit3.setDeleteBy("Delete By");
        audit3.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setIpAddress("42 Main St");
        audit3.setPreviousValue("42");
        audit3.setRecordVersion(1);
        audit3.setUpdateBy("2020-03-01");
        audit3.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity country = new StCountryEntity();
        country.setAudit(new Audit());
        country.setCountryName("GB");
        country.setCountryStatus(3);
        country.setIdCountry(1L);

        StCityEntity city = new StCityEntity();
        city.setAudit(audit3);
        city.setCityName("Oxford");
        city.setCityStatus(1);
        city.setCountry(country);
        city.setIdCity(1L);

        StPlacesEntity places = new StPlacesEntity();
        places.setAudit(audit2);
        places.setCity(city);
        places.setIdPlaces(1L);
        places.setPlaceName("Place Name");
        places.setPlacesStatus(1);

        StTollsEntity stTollsEntity = new StTollsEntity();
        stTollsEntity.setAudit(audit);
        stTollsEntity.setIdTolls(1L);
        stTollsEntity.setPlaces(places);
        stTollsEntity.setTollsName("Tolls Name");
        stTollsEntity.setTollsStatus(1);
        Optional<StTollsEntity> ofResult = Optional.of(stTollsEntity);
        when(stTollsService.getTollsById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/toll/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stTollsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idTolls\":1,\"tollsName\":\"Tolls Name\",\"places\":{\"idPlaces\":1,"
                                        + "\"placeName\":\"Place Name\",\"placesStatus\":1,\"city\":{\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country"
                                        + "\":{\"idCountry\":1,\"countryName\":\"GB\",\"countryStatus\":3,\"audit\":{\"createBy\":null,\"createDate\":null,"
                                        + "\"updateBy\":null,\"updateDate\":null,\"deleteBy\":null,\"deleteDate\":null,\"ipAddress\":null,\"action\":null,"
                                        + "\"previousValue\":null,\"currentValue\":null,\"recordVersion\":null}},\"audit\":{\"createBy\":\"Create"
                                        + " By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete"
                                        + " By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\","
                                        + "\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],"
                                        + "\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0"
                                        + "],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"tollsStatus\":1,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03"
                                        + "-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42"
                                        + " Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"error\":\"\"}"));
    }

    /**
     * Test {@link StTollsController#getTollsByPlaceId(Long)}.
     * <ul>
     *   <li>When {@code null}.</li>
     *   <li>Then return Message is {@code Invalid id}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StTollsController#getTollsByPlaceId(Long)}
     */
    @Test
    @DisplayName("Test getTollsByPlaceId(Long); when 'null'; then return Message is 'Invalid id'")
    @Tag("MaintainedByDiffblue")
    void testGetTollsByPlaceId_whenNull_thenReturnMessageIsInvalidId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StTollsEntity>> actualTollsByPlaceId = (new StTollsController()).getTollsByPlaceId(null);

        // Assert
        assertEquals("", actualTollsByPlaceId.getError());
        assertEquals("Invalid id", actualTollsByPlaceId.getMessage());
        assertNull(actualTollsByPlaceId.getData());
        assertEquals(400, actualTollsByPlaceId.getStatus().intValue());
    }

    /**
     * Test {@link StTollsController#getTollsByPlaceId(Long)}.
     * <ul>
     *   <li>When one.</li>
     *   <li>Then return Message is {@code Place with ID: 1 not found}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StTollsController#getTollsByPlaceId(Long)}
     */
    @Test
    @DisplayName("Test getTollsByPlaceId(Long); when one; then return Message is 'Place with ID: 1 not found'")
    @Tag("MaintainedByDiffblue")
    void testGetTollsByPlaceId_whenOne_thenReturnMessageIsPlaceWithId1NotFound() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StTollsEntity>> actualTollsByPlaceId = (new StTollsController()).getTollsByPlaceId(1L);

        // Assert
        assertEquals("", actualTollsByPlaceId.getError());
        assertEquals("Place with ID: 1 not found", actualTollsByPlaceId.getMessage());
        assertNull(actualTollsByPlaceId.getData());
        assertEquals(404, actualTollsByPlaceId.getStatus().intValue());
    }

    /**
     * Test {@link StTollsController#getTollsByPlaceId(Long)}.
     * <ul>
     *   <li>When zero.</li>
     *   <li>Then return Message is {@code Invalid id}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StTollsController#getTollsByPlaceId(Long)}
     */
    @Test
    @DisplayName("Test getTollsByPlaceId(Long); when zero; then return Message is 'Invalid id'")
    @Tag("MaintainedByDiffblue")
    void testGetTollsByPlaceId_whenZero_thenReturnMessageIsInvalidId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StTollsEntity>> actualTollsByPlaceId = (new StTollsController()).getTollsByPlaceId(0L);

        // Assert
        assertEquals("", actualTollsByPlaceId.getError());
        assertEquals("Invalid id", actualTollsByPlaceId.getMessage());
        assertNull(actualTollsByPlaceId.getData());
        assertEquals(400, actualTollsByPlaceId.getStatus().intValue());
    }

    /**
     * Test {@link StTollsController#createToll(StTollsRequest)}.
     * <p>
     * Method under test: {@link StTollsController#createToll(StTollsRequest)}
     */
    @Test
    @DisplayName("Test createToll(StTollsRequest)")
    @Tag("MaintainedByDiffblue")
    void testCreateToll() throws Exception {
        // Arrange
        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit2 = new Audit();
        audit2.setAction("Action");
        audit2.setCreateBy("Create By");
        audit2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setCurrentValue("42");
        audit2.setDeleteBy("Delete By");
        audit2.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setIpAddress("42 Main St");
        audit2.setPreviousValue("42");
        audit2.setRecordVersion(1);
        audit2.setUpdateBy("2020-03-01");
        audit2.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit3 = new Audit();
        audit3.setAction("Action");
        audit3.setCreateBy("Create By");
        audit3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setCurrentValue("42");
        audit3.setDeleteBy("Delete By");
        audit3.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setIpAddress("42 Main St");
        audit3.setPreviousValue("42");
        audit3.setRecordVersion(1);
        audit3.setUpdateBy("2020-03-01");
        audit3.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity country = new StCountryEntity();
        country.setAudit(audit3);
        country.setCountryName("GB");
        country.setCountryStatus(3);
        country.setIdCountry(1L);

        StCityEntity city = new StCityEntity();
        city.setAudit(audit2);
        city.setCityName("Oxford");
        city.setCityStatus(1);
        city.setCountry(country);
        city.setIdCity(1L);

        StPlacesEntity stPlacesEntity = new StPlacesEntity();
        stPlacesEntity.setAudit(audit);
        stPlacesEntity.setCity(city);
        stPlacesEntity.setIdPlaces(1L);
        stPlacesEntity.setPlaceName("Place Name");
        stPlacesEntity.setPlacesStatus(1);
        Optional<StPlacesEntity> ofResult = Optional.of(stPlacesEntity);
        when(stPlacesService.getPlaceById(Mockito.<Long>any())).thenReturn(ofResult);

        Audit audit4 = new Audit();
        audit4.setAction("Action");
        audit4.setCreateBy("Create By");
        audit4.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit4.setCurrentValue("42");
        audit4.setDeleteBy("Delete By");
        audit4.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit4.setIpAddress("42 Main St");
        audit4.setPreviousValue("42");
        audit4.setRecordVersion(1);
        audit4.setUpdateBy("2020-03-01");
        audit4.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit5 = new Audit();
        audit5.setAction("Action");
        audit5.setCreateBy("Create By");
        audit5.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit5.setCurrentValue("42");
        audit5.setDeleteBy("Delete By");
        audit5.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit5.setIpAddress("42 Main St");
        audit5.setPreviousValue("42");
        audit5.setRecordVersion(1);
        audit5.setUpdateBy("2020-03-01");
        audit5.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit6 = new Audit();
        audit6.setAction("Action");
        audit6.setCreateBy("Create By");
        audit6.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit6.setCurrentValue("42");
        audit6.setDeleteBy("Delete By");
        audit6.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit6.setIpAddress("42 Main St");
        audit6.setPreviousValue("42");
        audit6.setRecordVersion(1);
        audit6.setUpdateBy("2020-03-01");
        audit6.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity country2 = new StCountryEntity();
        country2.setAudit(new Audit());
        country2.setCountryName("GB");
        country2.setCountryStatus(3);
        country2.setIdCountry(1L);

        StCityEntity city2 = new StCityEntity();
        city2.setAudit(audit6);
        city2.setCityName("Oxford");
        city2.setCityStatus(1);
        city2.setCountry(country2);
        city2.setIdCity(1L);

        StPlacesEntity places = new StPlacesEntity();
        places.setAudit(audit5);
        places.setCity(city2);
        places.setIdPlaces(1L);
        places.setPlaceName("Place Name");
        places.setPlacesStatus(1);

        StTollsEntity stTollsEntity = new StTollsEntity();
        stTollsEntity.setAudit(audit4);
        stTollsEntity.setIdTolls(1L);
        stTollsEntity.setPlaces(places);
        stTollsEntity.setTollsName("Tolls Name");
        stTollsEntity.setTollsStatus(1);
        Optional<StTollsEntity> ofResult2 = Optional.of(stTollsEntity);
        when(stTollsService.createTolls(Mockito.<StTollsEntity>any())).thenReturn(ofResult2);

        StTollsRequest stTollsRequest = new StTollsRequest();
        stTollsRequest.setIdPlaces(1L);
        stTollsRequest.setIdTolls(1L);
        stTollsRequest.setTollsName("Tolls Name");
        String content = (new ObjectMapper()).writeValueAsString(stTollsRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/toll/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stTollsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idTolls\":1,\"tollsName\":\"Tolls Name\",\"places\":{\"idPlaces\":1,"
                                        + "\"placeName\":\"Place Name\",\"placesStatus\":1,\"city\":{\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country"
                                        + "\":{\"idCountry\":1,\"countryName\":\"GB\",\"countryStatus\":3,\"audit\":{\"createBy\":null,\"createDate\":null,"
                                        + "\"updateBy\":null,\"updateDate\":null,\"deleteBy\":null,\"deleteDate\":null,\"ipAddress\":null,\"action\":null,"
                                        + "\"previousValue\":null,\"currentValue\":null,\"recordVersion\":null}},\"audit\":{\"createBy\":\"Create"
                                        + " By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete"
                                        + " By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\","
                                        + "\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],"
                                        + "\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0"
                                        + "],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"tollsStatus\":1,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03"
                                        + "-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42"
                                        + " Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"error\":\"\"}"));
    }

    /**
     * Test {@link StTollsController#updateToll(Long, StTollsRequest)}.
     * <p>
     * Method under test: {@link StTollsController#updateToll(Long, StTollsRequest)}
     */
    @Test
    @DisplayName("Test updateToll(Long, StTollsRequest)")
    @Tag("MaintainedByDiffblue")
    void testUpdateToll() throws Exception {
        // Arrange
        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit2 = new Audit();
        audit2.setAction("Action");
        audit2.setCreateBy("Create By");
        audit2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setCurrentValue("42");
        audit2.setDeleteBy("Delete By");
        audit2.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setIpAddress("42 Main St");
        audit2.setPreviousValue("42");
        audit2.setRecordVersion(1);
        audit2.setUpdateBy("2020-03-01");
        audit2.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit3 = new Audit();
        audit3.setAction("Action");
        audit3.setCreateBy("Create By");
        audit3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setCurrentValue("42");
        audit3.setDeleteBy("Delete By");
        audit3.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setIpAddress("42 Main St");
        audit3.setPreviousValue("42");
        audit3.setRecordVersion(1);
        audit3.setUpdateBy("2020-03-01");
        audit3.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity country = new StCountryEntity();
        country.setAudit(audit3);
        country.setCountryName("GB");
        country.setCountryStatus(3);
        country.setIdCountry(1L);

        StCityEntity city = new StCityEntity();
        city.setAudit(audit2);
        city.setCityName("Oxford");
        city.setCityStatus(1);
        city.setCountry(country);
        city.setIdCity(1L);

        StPlacesEntity stPlacesEntity = new StPlacesEntity();
        stPlacesEntity.setAudit(audit);
        stPlacesEntity.setCity(city);
        stPlacesEntity.setIdPlaces(1L);
        stPlacesEntity.setPlaceName("Place Name");
        stPlacesEntity.setPlacesStatus(1);
        Optional<StPlacesEntity> ofResult = Optional.of(stPlacesEntity);
        when(stPlacesService.getPlaceById(Mockito.<Long>any())).thenReturn(ofResult);

        Audit audit4 = new Audit();
        audit4.setAction("Action");
        audit4.setCreateBy("Create By");
        audit4.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit4.setCurrentValue("42");
        audit4.setDeleteBy("Delete By");
        audit4.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit4.setIpAddress("42 Main St");
        audit4.setPreviousValue("42");
        audit4.setRecordVersion(1);
        audit4.setUpdateBy("2020-03-01");
        audit4.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit5 = new Audit();
        audit5.setAction("Action");
        audit5.setCreateBy("Create By");
        audit5.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit5.setCurrentValue("42");
        audit5.setDeleteBy("Delete By");
        audit5.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit5.setIpAddress("42 Main St");
        audit5.setPreviousValue("42");
        audit5.setRecordVersion(1);
        audit5.setUpdateBy("2020-03-01");
        audit5.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit6 = new Audit();
        audit6.setAction("Action");
        audit6.setCreateBy("Create By");
        audit6.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit6.setCurrentValue("42");
        audit6.setDeleteBy("Delete By");
        audit6.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit6.setIpAddress("42 Main St");
        audit6.setPreviousValue("42");
        audit6.setRecordVersion(1);
        audit6.setUpdateBy("2020-03-01");
        audit6.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity country2 = new StCountryEntity();
        country2.setAudit(new Audit());
        country2.setCountryName("GB");
        country2.setCountryStatus(3);
        country2.setIdCountry(1L);

        StCityEntity city2 = new StCityEntity();
        city2.setAudit(audit6);
        city2.setCityName("Oxford");
        city2.setCityStatus(1);
        city2.setCountry(country2);
        city2.setIdCity(1L);

        StPlacesEntity places = new StPlacesEntity();
        places.setAudit(audit5);
        places.setCity(city2);
        places.setIdPlaces(1L);
        places.setPlaceName("Place Name");
        places.setPlacesStatus(1);

        StTollsEntity stTollsEntity = new StTollsEntity();
        stTollsEntity.setAudit(audit4);
        stTollsEntity.setIdTolls(1L);
        stTollsEntity.setPlaces(places);
        stTollsEntity.setTollsName("Tolls Name");
        stTollsEntity.setTollsStatus(1);
        Optional<StTollsEntity> ofResult2 = Optional.of(stTollsEntity);
        when(stTollsService.updateTolls(Mockito.<Long>any(), Mockito.<StTollsEntity>any())).thenReturn(ofResult2);

        StTollsRequest stTollsRequest = new StTollsRequest();
        stTollsRequest.setIdPlaces(1L);
        stTollsRequest.setIdTolls(1L);
        stTollsRequest.setTollsName("Tolls Name");
        String content = (new ObjectMapper()).writeValueAsString(stTollsRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/toll/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stTollsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idTolls\":1,\"tollsName\":\"Tolls Name\",\"places\":{\"idPlaces\":1,"
                                        + "\"placeName\":\"Place Name\",\"placesStatus\":1,\"city\":{\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country"
                                        + "\":{\"idCountry\":1,\"countryName\":\"GB\",\"countryStatus\":3,\"audit\":{\"createBy\":null,\"createDate\":null,"
                                        + "\"updateBy\":null,\"updateDate\":null,\"deleteBy\":null,\"deleteDate\":null,\"ipAddress\":null,\"action\":null,"
                                        + "\"previousValue\":null,\"currentValue\":null,\"recordVersion\":null}},\"audit\":{\"createBy\":\"Create"
                                        + " By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete"
                                        + " By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\","
                                        + "\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],"
                                        + "\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0"
                                        + "],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"tollsStatus\":1,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03"
                                        + "-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42"
                                        + " Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"error\":\"\"}"));
    }

    /**
     * Test {@link StTollsController#deleteToll(Long)}.
     * <p>
     * Method under test: {@link StTollsController#deleteToll(Long)}
     */
    @Test
    @DisplayName("Test deleteToll(Long)")
    @Tag("MaintainedByDiffblue")
    void testDeleteToll() throws Exception {
        // Arrange
        Audit audit = new Audit();
        audit.setAction("Action");
        audit.setCreateBy("Create By");
        audit.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setCurrentValue("42");
        audit.setDeleteBy("Delete By");
        audit.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit.setIpAddress("42 Main St");
        audit.setPreviousValue("42");
        audit.setRecordVersion(1);
        audit.setUpdateBy("2020-03-01");
        audit.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit2 = new Audit();
        audit2.setAction("Action");
        audit2.setCreateBy("Create By");
        audit2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setCurrentValue("42");
        audit2.setDeleteBy("Delete By");
        audit2.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit2.setIpAddress("42 Main St");
        audit2.setPreviousValue("42");
        audit2.setRecordVersion(1);
        audit2.setUpdateBy("2020-03-01");
        audit2.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        Audit audit3 = new Audit();
        audit3.setAction("Action");
        audit3.setCreateBy("Create By");
        audit3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setCurrentValue("42");
        audit3.setDeleteBy("Delete By");
        audit3.setDeleteDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        audit3.setIpAddress("42 Main St");
        audit3.setPreviousValue("42");
        audit3.setRecordVersion(1);
        audit3.setUpdateBy("2020-03-01");
        audit3.setUpdateDate(LocalDate.of(1970, 1, 1).atStartOfDay());

        StCountryEntity country = new StCountryEntity();
        country.setAudit(new Audit());
        country.setCountryName("GB");
        country.setCountryStatus(3);
        country.setIdCountry(1L);

        StCityEntity city = new StCityEntity();
        city.setAudit(audit3);
        city.setCityName("Oxford");
        city.setCityStatus(1);
        city.setCountry(country);
        city.setIdCity(1L);

        StPlacesEntity places = new StPlacesEntity();
        places.setAudit(audit2);
        places.setCity(city);
        places.setIdPlaces(1L);
        places.setPlaceName("Place Name");
        places.setPlacesStatus(1);

        StTollsEntity stTollsEntity = new StTollsEntity();
        stTollsEntity.setAudit(audit);
        stTollsEntity.setIdTolls(1L);
        stTollsEntity.setPlaces(places);
        stTollsEntity.setTollsName("Tolls Name");
        stTollsEntity.setTollsStatus(1);
        Optional<StTollsEntity> ofResult = Optional.of(stTollsEntity);
        when(stTollsService.deleteTolls(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/toll/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stTollsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idTolls\":1,\"tollsName\":\"Tolls Name\",\"places\":{\"idPlaces\":1,"
                                        + "\"placeName\":\"Place Name\",\"placesStatus\":1,\"city\":{\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country"
                                        + "\":{\"idCountry\":1,\"countryName\":\"GB\",\"countryStatus\":3,\"audit\":{\"createBy\":null,\"createDate\":null,"
                                        + "\"updateBy\":null,\"updateDate\":null,\"deleteBy\":null,\"deleteDate\":null,\"ipAddress\":null,\"action\":null,"
                                        + "\"previousValue\":null,\"currentValue\":null,\"recordVersion\":null}},\"audit\":{\"createBy\":\"Create"
                                        + " By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete"
                                        + " By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\","
                                        + "\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],"
                                        + "\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0"
                                        + "],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"tollsStatus\":1,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03"
                                        + "-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42"
                                        + " Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"error\":\"\"}"));
    }
}
