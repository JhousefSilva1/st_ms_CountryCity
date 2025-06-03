package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.Audit;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.request.StCityRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StCityService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StCountryService;

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

@ContextConfiguration(classes = {StCityController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class StCityControllerDiffblueTest {
    @Autowired
    private StCityController stCityController;

    @MockBean
    private StCityService stCityService;

    @MockBean
    private StCountryService stCountryService;

    /**
     * Test {@link StCityController#getAllCities()}.
     * <p>
     * Method under test: {@link StCityController#getAllCities()}
     */
    @Test
    @DisplayName("Test getAllCities()")
    @Tag("MaintainedByDiffblue")
    void testGetAllCities() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StCityEntity>> actualAllCities = (new StCityController()).getAllCities();

        // Assert
        assertEquals("", actualAllCities.getError());
        assertEquals(
                "An unexpected error occurred: Cannot invoke \"com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService"
                        + ".service.StCityService.isServiceAvailable()\" because \"this.stCityService\" is null",
                actualAllCities.getMessage());
        assertNull(actualAllCities.getData());
        assertEquals(500, actualAllCities.getStatus().intValue());
    }

    /**
     * Test {@link StCityController#getAllCitiesByStatus()}.
     * <p>
     * Method under test: {@link StCityController#getAllCitiesByStatus()}
     */
    @Test
    @DisplayName("Test getAllCitiesByStatus()")
    @Tag("MaintainedByDiffblue")
    void testGetAllCitiesByStatus() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StCityEntity>> actualAllCitiesByStatus = (new StCityController()).getAllCitiesByStatus();

        // Assert
        assertEquals("", actualAllCitiesByStatus.getError());
        assertEquals("Internal Server Error", actualAllCitiesByStatus.getMessage());
        assertNull(actualAllCitiesByStatus.getData());
        assertEquals(500, actualAllCitiesByStatus.getStatus().intValue());
    }

    /**
     * Test {@link StCityController#getCityById(Long)}.
     * <p>
     * Method under test: {@link StCityController#getCityById(Long)}
     */
    @Test
    @DisplayName("Test getCityById(Long)")
    @Tag("MaintainedByDiffblue")
    void testGetCityById() throws Exception {
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/city/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stCityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country\":{\"idCountry"
                                        + "\":1,\"countryName\":\"GB\",\"countryStatus\":3,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0]"
                                        + ",\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0"
                                        + ",0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate"
                                        + "\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action"
                                        + "\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"error\":\"\"}"));
    }

    /**
     * Test {@link StCityController#getCitiesByCountryById(Long)}.
     * <p>
     * Method under test: {@link StCityController#getCitiesByCountryById(Long)}
     */
    @Test
    @DisplayName("Test getCitiesByCountryById(Long)")
    @Tag("MaintainedByDiffblue")
    void testGetCitiesByCountryById() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange and Act
        ApiResponse<List<StCityEntity>> actualCitiesByCountryById = (new StCityController()).getCitiesByCountryById(1L);

        // Assert
        assertEquals("", actualCitiesByCountryById.getError());
        assertEquals("Not Found", actualCitiesByCountryById.getMessage());
        assertNull(actualCitiesByCountryById.getData());
        assertEquals(404, actualCitiesByCountryById.getStatus().intValue());
    }

    /**
     * Test {@link StCityController#createCity(StCityRequest)}.
     * <p>
     * Method under test: {@link StCityController#createCity(StCityRequest)}
     */
    @Test
    @DisplayName("Test createCity(StCityRequest)")
    @Tag("MaintainedByDiffblue")
    void testCreateCity() throws Exception {
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
        when(stCityService.createCity(Mockito.<StCityEntity>any())).thenReturn(ofResult);

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

        StCountryEntity stCountryEntity = new StCountryEntity();
        stCountryEntity.setAudit(audit3);
        stCountryEntity.setCountryName("GB");
        stCountryEntity.setCountryStatus(3);
        stCountryEntity.setIdCountry(1L);
        Optional<StCountryEntity> ofResult2 = Optional.of(stCountryEntity);
        when(stCountryService.getCountryById(Mockito.<Long>any())).thenReturn(ofResult2);

        StCityRequest stCityRequest = new StCityRequest();
        stCityRequest.setCityName("Oxford");
        stCityRequest.setIdCity(1L);
        stCityRequest.setIdCountry(1L);
        stCityRequest.setStatus(1);
        String content = (new ObjectMapper()).writeValueAsString(stCityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/city/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stCityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country\":{\"idCountry"
                                        + "\":1,\"countryName\":\"GB\",\"countryStatus\":3,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0]"
                                        + ",\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0"
                                        + ",0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate"
                                        + "\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action"
                                        + "\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"error\":\"\"}"));
    }

    /**
     * Test {@link StCityController#updateCity(Long, StCityRequest)}.
     * <p>
     * Method under test: {@link StCityController#updateCity(Long, StCityRequest)}
     */
    @Test
    @DisplayName("Test updateCity(Long, StCityRequest)")
    @Tag("MaintainedByDiffblue")
    void testUpdateCity() throws Exception {
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
        when(stCityService.updateCity(Mockito.<Long>any(), Mockito.<StCityEntity>any())).thenReturn(ofResult);

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

        StCountryEntity stCountryEntity = new StCountryEntity();
        stCountryEntity.setAudit(audit3);
        stCountryEntity.setCountryName("GB");
        stCountryEntity.setCountryStatus(3);
        stCountryEntity.setIdCountry(1L);
        Optional<StCountryEntity> ofResult2 = Optional.of(stCountryEntity);
        when(stCountryService.getCountryById(Mockito.<Long>any())).thenReturn(ofResult2);

        StCityRequest stCityRequest = new StCityRequest();
        stCityRequest.setCityName("Oxford");
        stCityRequest.setIdCity(1L);
        stCityRequest.setIdCountry(1L);
        stCityRequest.setStatus(1);
        String content = (new ObjectMapper()).writeValueAsString(stCityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/city/update/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stCityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country\":{\"idCountry"
                                        + "\":1,\"countryName\":\"GB\",\"countryStatus\":3,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0]"
                                        + ",\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0"
                                        + ",0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate"
                                        + "\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action"
                                        + "\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"error\":\"\"}"));
    }

    /**
     * Test {@link StCityController#deleteCity(Long)}.
     * <p>
     * Method under test: {@link StCityController#deleteCity(Long)}
     */
    @Test
    @DisplayName("Test deleteCity(Long)")
    @Tag("MaintainedByDiffblue")
    void testDeleteCity() throws Exception {
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
        when(stCityService.deleteCity(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/city/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(stCityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"OK\",\"data\":{\"idCity\":1,\"cityName\":\"Oxford\",\"cityStatus\":1,\"country\":{\"idCountry"
                                        + "\":1,\"countryName\":\"GB\",\"countryStatus\":3,\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0]"
                                        + ",\"updateBy\":\"2020-03-01\",\"updateDate\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0"
                                        + ",0],\"ipAddress\":\"42 Main St\",\"action\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion"
                                        + "\":1}},\"audit\":{\"createBy\":\"Create By\",\"createDate\":[1970,1,1,0,0],\"updateBy\":\"2020-03-01\",\"updateDate"
                                        + "\":[1970,1,1,0,0],\"deleteBy\":\"Delete By\",\"deleteDate\":[1970,1,1,0,0],\"ipAddress\":\"42 Main St\",\"action"
                                        + "\":\"Action\",\"previousValue\":\"42\",\"currentValue\":\"42\",\"recordVersion\":1}},\"error\":\"\"}"));
    }
}
