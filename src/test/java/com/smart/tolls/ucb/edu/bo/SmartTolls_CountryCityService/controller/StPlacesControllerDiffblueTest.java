package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.Audit;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPlacesEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.request.StPlacesRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StCityService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StPlacesService;

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
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StPlacesController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class StPlacesControllerDiffblueTest {
    @MockBean
    private StCityService stCityService;

    @Autowired
    private StPlacesController stPlacesController;

    @MockBean
    private StPlacesService stPlacesService;

    /**
     * Test {@link StPlacesController#getAllPlaces()}.
     * <p>
     * Method under test: {@link StPlacesController#getAllPlaces()}
     */
    @Test
    @DisplayName("Test getAllPlaces()")
    @Tag("MaintainedByDiffblue")
    void testGetAllPlaces() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StPlacesEntity>> actualAllPlaces = (new StPlacesController()).getAllPlaces();

        // Assert
        assertEquals("", actualAllPlaces.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StPlacesService.isServiceAvailable()\" because \"this.stPlacesService\" is null",
                actualAllPlaces.getMessage());
        assertNull(actualAllPlaces.getData());
        assertEquals(500, actualAllPlaces.getStatus().intValue());
    }

    /**
     * Test {@link StPlacesController#getPlacesByCityId(Long)}.
     * <ul>
     *   <li>When {@code null}.</li>
     *   <li>Then return Message is {@code Invalid city ID}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StPlacesController#getPlacesByCityId(Long)}
     */
    @Test
    @DisplayName("Test getPlacesByCityId(Long); when 'null'; then return Message is 'Invalid city ID'")
    @Tag("MaintainedByDiffblue")
    void testGetPlacesByCityId_whenNull_thenReturnMessageIsInvalidCityId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StPlacesEntity>> actualPlacesByCityId = (new StPlacesController()).getPlacesByCityId(null);

        // Assert
        assertEquals("", actualPlacesByCityId.getError());
        assertEquals("Invalid city ID", actualPlacesByCityId.getMessage());
        assertNull(actualPlacesByCityId.getData());
        assertEquals(400, actualPlacesByCityId.getStatus().intValue());
    }

    /**
     * Test {@link StPlacesController#getPlacesByCityId(Long)}.
     * <ul>
     *   <li>When one.</li>
     *   <li>Then return Message is a string.</li>
     * </ul>
     * <p>
     * Method under test: {@link StPlacesController#getPlacesByCityId(Long)}
     */
    @Test
    @DisplayName("Test getPlacesByCityId(Long); when one; then return Message is a string")
    @Tag("MaintainedByDiffblue")
    void testGetPlacesByCityId_whenOne_thenReturnMessageIsAString() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StPlacesEntity>> actualPlacesByCityId = (new StPlacesController()).getPlacesByCityId(1L);

        // Assert
        assertEquals("", actualPlacesByCityId.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StPlacesService.getPlacesByCityId(java.lang.Long)\" because \"this.stPlacesService\" is null",
                actualPlacesByCityId.getMessage());
        assertNull(actualPlacesByCityId.getData());
        assertEquals(500, actualPlacesByCityId.getStatus().intValue());
    }

    /**
     * Test {@link StPlacesController#getPlacesByCityId(Long)}.
     * <ul>
     *   <li>When zero.</li>
     *   <li>Then return Message is {@code Invalid city ID}.</li>
     * </ul>
     * <p>
     * Method under test: {@link StPlacesController#getPlacesByCityId(Long)}
     */
    @Test
    @DisplayName("Test getPlacesByCityId(Long); when zero; then return Message is 'Invalid city ID'")
    @Tag("MaintainedByDiffblue")
    void testGetPlacesByCityId_whenZero_thenReturnMessageIsInvalidCityId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StPlacesEntity>> actualPlacesByCityId = (new StPlacesController()).getPlacesByCityId(0L);

        // Assert
        assertEquals("", actualPlacesByCityId.getError());
        assertEquals("Invalid city ID", actualPlacesByCityId.getMessage());
        assertNull(actualPlacesByCityId.getData());
        assertEquals(400, actualPlacesByCityId.getStatus().intValue());
    }

    /**
     * Test {@link StPlacesController#getAllPlacesByStatus()}.
     * <p>
     * Method under test: {@link StPlacesController#getAllPlacesByStatus()}
     */
    @Test
    @DisplayName("Test getAllPlacesByStatus()")
    @Tag("MaintainedByDiffblue")
    void testGetAllPlacesByStatus() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StPlacesEntity>> actualAllPlacesByStatus = (new StPlacesController()).getAllPlacesByStatus();

        // Assert
        assertEquals("", actualAllPlacesByStatus.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StPlacesService.getAllPlacesByStatus()\" because \"this.stPlacesService\" is null",
                actualAllPlacesByStatus.getMessage());
        assertNull(actualAllPlacesByStatus.getData());
        assertEquals(500, actualAllPlacesByStatus.getStatus().intValue());
    }

    /**
     * Test {@link StPlacesController#getPlacesById(Long)}.
     * <p>
     * Method under test: {@link StPlacesController#getPlacesById(Long)}
     */
    @Test
    @DisplayName("Test getPlacesById(Long)")
    @Tag("MaintainedByDiffblue")
    void testGetPlacesById() throws Exception {
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/places/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stPlacesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idPlaces\":1,\"placeName\":\"Place Name\",\"placesStatus\":1,\"city\":{"
                                        + "\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country\":{\"idCountry\":1,\"countryName\":\"GB\",\"countryStatus"
                                        + "\":3,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\""
                                        + ":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\""
                                        + ":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create"
                                        + " By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete"
                                        + " By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\","
                                        + "\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],"
                                        + "\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0"
                                        + "],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"error\":\"\"}"));
    }

    /**
     * Test {@link StPlacesController#createPlaces(StPlacesRequest)}.
     * <p>
     * Method under test: {@link StPlacesController#createPlaces(StPlacesRequest)}
     */
    @Test
    @DisplayName("Test createPlaces(StPlacesRequest)")
    @Tag("MaintainedByDiffblue")
    void testCreatePlaces() throws Exception {
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

        StCountryEntity country = new StCountryEntity();
        country.setAudit(audit2);
        country.setCountryName("GB");
        country.setCountryStatus(3);
        country.setIdCountry(1L);

        StCityEntity stCityEntity = new StCityEntity();
        stCityEntity.setAudit(audit);
        stCityEntity.setCityName("Oxford");
        stCityEntity.setCityStatus(1);
        stCityEntity.setCountry(country);
        stCityEntity.setIdCity(1L);
        Optional<StCityEntity> ofResult = Optional.of(stCityEntity);
        when(stCityService.getCityById(Mockito.<Long>any())).thenReturn(ofResult);

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

        StCountryEntity country2 = new StCountryEntity();
        country2.setAudit(audit5);
        country2.setCountryName("GB");
        country2.setCountryStatus(3);
        country2.setIdCountry(1L);

        StCityEntity city = new StCityEntity();
        city.setAudit(audit4);
        city.setCityName("Oxford");
        city.setCityStatus(1);
        city.setCountry(country2);
        city.setIdCity(1L);

        StPlacesEntity stPlacesEntity = new StPlacesEntity();
        stPlacesEntity.setAudit(audit3);
        stPlacesEntity.setCity(city);
        stPlacesEntity.setIdPlaces(1L);
        stPlacesEntity.setPlaceName("Place Name");
        stPlacesEntity.setPlacesStatus(1);
        Optional<StPlacesEntity> ofResult2 = Optional.of(stPlacesEntity);
        when(stPlacesService.createPlaces(Mockito.<StPlacesEntity>any())).thenReturn(ofResult2);

        StPlacesRequest stPlacesRequest = new StPlacesRequest();
        stPlacesRequest.setIdCity(1L);
        stPlacesRequest.setIdPlaces(1L);
        stPlacesRequest.setPlaceName("Place Name");
        stPlacesRequest.setStatus(1);
        String content = (new ObjectMapper()).writeValueAsString(stPlacesRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/places/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stPlacesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idPlaces\":1,\"placeName\":\"Place Name\",\"placesStatus\":1,\"city\":{"
                                        + "\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country\":{\"idCountry\":1,\"countryName\":\"GB\",\"countryStatus"
                                        + "\":3,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\""
                                        + ":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\""
                                        + ":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create"
                                        + " By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete"
                                        + " By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\","
                                        + "\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],"
                                        + "\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0"
                                        + "],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"error\":\"\"}"));
    }

    /**
     * Test {@link StPlacesController#updatePlaces(Long, StPlacesRequest)}.
     * <p>
     * Method under test: {@link StPlacesController#updatePlaces(Long, StPlacesRequest)}
     */
    @Test
    @DisplayName("Test updatePlaces(Long, StPlacesRequest)")
    @Tag("MaintainedByDiffblue")
    void testUpdatePlaces() throws Exception {
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

        StCountryEntity country = new StCountryEntity();
        country.setAudit(audit2);
        country.setCountryName("GB");
        country.setCountryStatus(3);
        country.setIdCountry(1L);

        StCityEntity stCityEntity = new StCityEntity();
        stCityEntity.setAudit(audit);
        stCityEntity.setCityName("Oxford");
        stCityEntity.setCityStatus(1);
        stCityEntity.setCountry(country);
        stCityEntity.setIdCity(1L);
        Optional<StCityEntity> ofResult = Optional.of(stCityEntity);
        when(stCityService.getCityById(Mockito.<Long>any())).thenReturn(ofResult);

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

        StCountryEntity country2 = new StCountryEntity();
        country2.setAudit(audit5);
        country2.setCountryName("GB");
        country2.setCountryStatus(3);
        country2.setIdCountry(1L);

        StCityEntity city = new StCityEntity();
        city.setAudit(audit4);
        city.setCityName("Oxford");
        city.setCityStatus(1);
        city.setCountry(country2);
        city.setIdCity(1L);

        StPlacesEntity stPlacesEntity = new StPlacesEntity();
        stPlacesEntity.setAudit(audit3);
        stPlacesEntity.setCity(city);
        stPlacesEntity.setIdPlaces(1L);
        stPlacesEntity.setPlaceName("Place Name");
        stPlacesEntity.setPlacesStatus(1);
        Optional<StPlacesEntity> ofResult2 = Optional.of(stPlacesEntity);
        when(stPlacesService.updatePlaces(Mockito.<Long>any(), Mockito.<StPlacesEntity>any())).thenReturn(ofResult2);

        StPlacesRequest stPlacesRequest = new StPlacesRequest();
        stPlacesRequest.setIdCity(1L);
        stPlacesRequest.setIdPlaces(1L);
        stPlacesRequest.setPlaceName("Place Name");
        stPlacesRequest.setStatus(1);
        String content = (new ObjectMapper()).writeValueAsString(stPlacesRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/places/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stPlacesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idPlaces\":1,\"placeName\":\"Place Name\",\"placesStatus\":1,\"city\":{"
                                        + "\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country\":{\"idCountry\":1,\"countryName\":\"GB\",\"countryStatus"
                                        + "\":3,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\""
                                        + ":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\""
                                        + ":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create"
                                        + " By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete"
                                        + " By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\","
                                        + "\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],"
                                        + "\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0"
                                        + "],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"error\":\"\"}"));
    }

    /**
     * Test {@link StPlacesController#deletePlaces(Long)}.
     * <p>
     * Method under test: {@link StPlacesController#deletePlaces(Long)}
     */
    @Test
    @DisplayName("Test deletePlaces(Long)")
    @Tag("MaintainedByDiffblue")
    void testDeletePlaces() throws Exception {
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
        when(stPlacesService.deletePlaces(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/places/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stPlacesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idPlaces\":1,\"placeName\":\"Place Name\",\"placesStatus\":1,\"city\":{"
                                        + "\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country\":{\"idCountry\":1,\"countryName\":\"GB\",\"countryStatus"
                                        + "\":3,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\""
                                        + ":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\""
                                        + ":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create"
                                        + " By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete"
                                        + " By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\","
                                        + "\"currentValue\":\"42\",\"recordVersion\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],"
                                        + "\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0"
                                        + "],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"error\":\"\"}"));
    }
}
